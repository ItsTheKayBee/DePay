module.exports = {

  networks: {
    
    develop: {
      port: 8545,
      network_id: 1337,
      accounts: 5,
      defaultEtherBalance: 500000,
      blockTime: 3
    }

  },

  mocha: {
  },

  compilers: {
    solc: {
    }
  }
}
