import React, { useState, useEffect } from "react";
import Modal from "react-modal";

import "./Main.css";

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

const Main = ({ selectedNft, listData, burnNft, burnmsg, burnsuccess }) => {
  const [activeNft, setActiveNft] = useState(listData[0]);
  const [modalIsOpen, setIsOpen] = useState(false);
  let subtitle;
  const afterOpenModal = () => {
    // references are now sync'd and can be accessed.
    subtitle.style.color = "#f00";
  };

  const closeModal = () => {
    setIsOpen(false);
  };

  //console.log(selectedNft);
  useEffect(() => {
    setActiveNft(listData[selectedNft]);
    if (burnsuccess !== "") {
      setIsOpen(true);
    }
  }, [listData, selectedNft, burnmsg, burnsuccess]);
  return (
    <div className="main">
      <Modal
        isOpen={modalIsOpen}
        onAfterOpen={afterOpenModal}
        onRequestClose={closeModal}
        style={customStyles}
        contentLabel="Example Modal"
      >
        <p>{burnsuccess}</p>
        <span onClick={closeModal} className="close-btn">
          <i className="fal fa-times-circle"></i>
        </span>
      </Modal>
      <div className="mainContent">
        <div className="highlight">
          <div className="nftContainer">
            <img
              className="selectedNft"
              src={activeNft?.image_original_url}
              alt=""
            />
          </div>
        </div>
        <div className="nftDetails" style={{ color: "#fff" }}>
          <div className="title">
            Name : {activeNft?.name}
            <span className="itemNumber">.#{activeNft?.token_id}</span>
          </div>
          <div className="">
            <h4>Description : {activeNft?.description}</h4>
          </div>
          <button
            className="cta-button connect-wallet-button"
            onClick={() => burnNft(selectedNft)}
            style={{ width: "200px", margin: "auto" }}
          >
            {burnmsg}
          </button>
          <div className="owner">
            <div className="ownerImage">
              <img src={activeNft?.owner.profile_img_url} alt="" />
            </div>

            <div className="ownerDetails">
              <div className="ownerNameAndHandle">
                <div className="ether">
                  <a href="https://rinkeby.etherscan.io/address/0x5E08764718C340d9473B82f34B5A1E921F997B35">
                    Etherscan Address
                  </a>
                </div>
                <div className="ownerHandle">@rohitraje123</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default Main;
