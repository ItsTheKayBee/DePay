// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.8.0;

contract Payment {
    struct Transactions {
        address sender;
        address receiver;
        uint256 amount;
        uint256 timestamp;
    }
    Transactions[] public transactions;
    event Sent(address from, address to, uint256 amount);
    event Added(address sender, uint256 amount);

    mapping(address => uint256) balance;

    function balanceOf() external view returns (uint256) {
        return balance[msg.sender];
    }

    function getLength() external view returns (uint256) {
        return transactions.length;
    }

    function transferAmount(address _receiver, uint256 _amount) external {
        require(_amount < balance[msg.sender], "Insufficient balance.");
        balance[msg.sender] -= _amount;
        balance[_receiver] += _amount;
        transactions.push(
            Transactions(msg.sender, _receiver, _amount, block.timestamp)
        );
        emit Sent(msg.sender, _receiver, _amount);
    }
    
    function addCrypto(uint256 _amount) external {
        balance[msg.sender] += _amount;
        emit Added(msg.sender, _amount);
    }
    
}