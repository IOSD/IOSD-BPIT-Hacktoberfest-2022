import "./App.css";
import twitterLogo from "./assets/twitter-logo.svg";
import { ethers } from "ethers";
import React, { useEffect, useState } from "react";
import myEpicNft from "./utils/MyEpicNFT.json";
import { Buffer } from "buffer";
import { create } from "ipfs-http-client";
import axios from "axios";
import Modal from "react-modal";

import AbstractList from "./components/AbstractList";
import Main from "./components/Main";

const TWITTER_HANDLE = "rohitraje123";
const TWITTER_LINK = `https://twitter.com/${TWITTER_HANDLE}`;

const client = create("https://ipfs.infura.io:5001/api/v0");

const customStyles = {
  content: {
    top: "50%",
    left: "50%",
    right: "auto",
    bottom: "auto",
    marginRight: "-50%",
    transform: "translate(-50%, -50%)",
    width: "620px",
    borderRadius: "20px",
    background: " -webkit-linear-gradient(left, #60c657 30%, #35aee2 60%)",
    backgroundClip: "text",
  },
};

// I moved the contract address to the top for easy access.
const CONTRACT_ADDRESS = "0x62b85F9b3D1A3f3e2272CA8aE453adDd7f875EDf";

const App = () => {
  const [currentAccount, setCurrentAccount] = useState("");

  const [contract, setContract] = useState(null);
  const [loading, setLoading] = useState(false);
  const [nameOf, setNameOf] = useState("");
  const [description, setDescription] = useState("");
  const [buffer, setBuffer] = useState(null);
  const [listData, setListData] = useState([]);
  const [selectedNft, setSelectedNft] = useState(0);
  const [modalIsOpen, setIsOpen] = useState(false);
  const [message, setMessage] = useState("");
  const [burnmsg, setBurnMsg] = useState("Burn NFT");
  const [burnsuccess, setBurnSuccess] = useState("");

  const checkIfWalletIsConnected = async () => {
    const { ethereum } = window;

    if (!ethereum) {
      console.log("Make sure you have metamask!");
      return;
    } else {
      console.log("We have the ethereum object", ethereum);
    }

    const accounts = await ethereum.request({ method: "eth_accounts" });

    if (accounts.length !== 0) {
      const account = accounts[0];

      console.log("Found an authorized account:", account);
      setCurrentAccount(account);

      const provider = new ethers.providers.Web3Provider(ethereum);
      const signer = provider.getSigner();
      const contract = new ethers.Contract(
        CONTRACT_ADDRESS,
        myEpicNft.abi,
        signer
      );
      setContract(contract);

      // Setup listener! This is for the case where a user comes to our site
      // and ALREADY had their wallet connected + authorized.
      setupEventListener();
    } else {
      console.log("No authorized account found");
    }
  };

  const connectWallet = async () => {
    try {
      const { ethereum } = window;

      if (!ethereum) {
        alert("Get MetaMask!");
        return;
      }

      const accounts = await ethereum.request({
        method: "eth_requestAccounts",
      });

      console.log("Connected", accounts[0]);
      setCurrentAccount(accounts[0]);

      // Setup listener! This is for the case where a user comes to our site
      // and connected their wallet for the first time.

      const provider = new ethers.providers.Web3Provider(ethereum);
      const signer = provider.getSigner();
      const contract = new ethers.Contract(
        CONTRACT_ADDRESS,
        myEpicNft.abi,
        signer
      );
      setContract(contract);

      setupEventListener();
    } catch (error) {
      console.log(error);
    }
  };

  // Setup our listener.
  const setupEventListener = async () => {
    // Most of this looks the same as our function askContractToMintNft
    try {
      const { ethereum } = window;

      if (ethereum) {
        // Same stuff again
        const provider = new ethers.providers.Web3Provider(ethereum);
        const signer = provider.getSigner();
        const connectedContract = new ethers.Contract(
          CONTRACT_ADDRESS,
          myEpicNft.abi,
          signer
        );

        // THIS IS THE MAGIC SAUCE.
        // This will essentially "capture" our event when our contract throws it.
        // If you're familiar with webhooks, it's very similar to that!
        connectedContract.on("NewEpicNFTMinted", (from, tokenId) => {
          console.log(from, tokenId.toNumber());
          setMessage(
            `Hey there 👋  We've minted your NFT and sent it to your wallet. It may be blank right now. It will take some time to reflect. Here's the link: https://testnets.opensea.io/assets/${CONTRACT_ADDRESS}/${tokenId.toNumber()}`
          );
          setIsOpen(true);
        });

        console.log("Setup event listener!");
      } else {
        console.log("Ethereum object doesn't exist!");
      }
    } catch (error) {
      console.log(error);
    }
  };

  const captureFile = (event) => {
    event.preventDefault();
    const file = event.target.files[0];
    console.log(file);
    const reader = new window.FileReader();

    reader.readAsArrayBuffer(file);
    reader.onloadend = () => {
      console.log(Buffer(reader.result));
      setBuffer(Buffer(reader.result));
    };
  };

  useEffect(() => {
    checkIfWalletIsConnected();
    getOpenseaItems();
  }, []);

  const renderNotConnectedContainer = () => (
    <button
      onClick={connectWallet}
      className="cta-button connect-wallet-button"
    >
      Connect to Wallet
    </button>
  );
  let subtitle;
  const getOpenseaItems = async () => {
    const openseaData = await axios.get(
      `https://testnets-api.opensea.io/assets?asset_contract_address=${CONTRACT_ADDRESS}&format=json&order_direction=asc`
    );

    setListData(
      openseaData.data.assets.filter((x) => {
        return x.owner.address !== "0x0000000000000000000000000000000000000000";
      })
    );
  };

  const afterOpenModal = () => {
    // references are now sync'd and can be accessed.
    subtitle.style.color = "#f00";
  };

  const closeModal = () => {
    setMessage("");
    setIsOpen(false);
  };

  const burnNft = async (tokenId) => {
    console.log(listData[tokenId].token_id);
    let txn = await contract.burn(listData[tokenId].token_id);
    setBurnMsg("Burning NFT...");
    console.log("Nft is burning...");
    await txn.wait();
    console.log(txn.hash);
    setMessage("Burn NFT");
    setBurnSuccess(
      "The NFT is successfully burned 🔥,it will take sometime to reflect,please be patient!!!"
    );
  };

  const renderMintUI = () => (
    <div>
      <Modal
        isOpen={modalIsOpen}
        onAfterOpen={afterOpenModal}
        onRequestClose={closeModal}
        style={customStyles}
        contentLabel="Example Modal"
      >
        <p>{message}</p>
        <span onClick={closeModal} className="close-btn">
          <i className="fal fa-times-circle"></i>
        </span>
      </Modal>
      <div className="input-container">
        <input
          type="text"
          placeholder="Name"
          onChange={(e) => setNameOf(e.target.value)}
          className="input"
        />
        <input
          type="text"
          placeholder="Description"
          onChange={(e) => setDescription(e.target.value)}
          className="input"
        />

        <span class="btn btn-primary btn-file">
          Browse...
          <input type="file" onChange={captureFile} />
        </span>
      </div>
      <br />

      <button onClick={uploadFile} className="cta-button connect-wallet-button">
        {loading ? "Minting..." : "Mint NFT"}
      </button>
    </div>
  );

  const uploadFile = async () => {
    if (nameOf === "" || description === "" || buffer == null) {
      alert("Please fill all the details!!!");
      return;
    }
    console.log("submitting files on ipfs");
    try {
      const added = await client.add(buffer);
      console.log(added);
      const url = `https://ipfs.io/ipfs/${added.path}`;
      console.log(url);

      console.log("Going to pop wallet now to pay gas...");
      let nftTxn = await contract.makeAnEpicNFT(
        added.path,
        nameOf,
        description
      );
      setLoading(true);

      console.log("Mining...please wait.");
      await nftTxn.wait();
      setLoading(false);
      console.log(nftTxn);
      console.log(
        `Mined, see transaction: https://rinkeby.etherscan.io/tx/${nftTxn.hash}`
      );
    } catch (e) {
      console.log(e.message);
    }
  };

  return (
    <div className="App">
      <div className="container">
        <div className="header-container">
          <p className="header gradient-text">Mint Your NFT Collection</p>
          <p className="sub-text">
            Each unique. Each beautiful. Discover your NFT today.
          </p>
          {currentAccount === ""
            ? renderNotConnectedContainer()
            : renderMintUI()}
        </div>

        <div className="nft-container">
          {currentAccount !== "" && listData.length > 0 && (
            <>
              <Main
                listData={listData}
                selectedNft={selectedNft}
                burnNft={burnNft}
                burnmsg={burnmsg}
                burnsuccess={burnsuccess}
              />
              <h3 style={{ color: "#fff" }}>Your NFT's Collection</h3>
              <AbstractList
                listData={listData}
                setSelectedNft={setSelectedNft}
              />
            </>
          )}
        </div>

        <div className="footer-container">
          <img alt="Twitter Logo" className="twitter-logo" src={twitterLogo} />
          <a
            className="footer-text"
            href={TWITTER_LINK}
            target="_blank"
            rel="noreferrer"
          >{`built on @${TWITTER_HANDLE}`}</a>
        </div>
      </div>
    </div>
  );
};

export default App;
