const main = async () => {
  const nftContractFactory = await hre.ethers.getContractFactory("MyEpicNFT");
  const nftContract = await nftContractFactory.deploy();
  await nftContract.deployed();
  console.log("Contract deployed to:", nftContract.address);

  // Call the function.
  let txn = await nftContract.makeAnEpicNFT(
    "Qmbb5dBTJK4VTU1GJsTekWij2TXBpsKnZSqyvcYd1J28SQ",
    "NFT",
    "Testing"
  );
  // Wait for it to be mined.
  await txn.wait();

  console.log(`https://rinkeby.etherscan.io/tx/${txn.hash}`);

  // Mint another NFT for fun.
  // txn = await nftContract.makeAnEpicNFT();
  // // Wait for it to be mined.
  //await txn.wait();
};

const runMain = async () => {
  try {
    await main();
    process.exit(0);
  } catch (error) {
    console.log(error);
    process.exit(1);
  }
};

runMain();
