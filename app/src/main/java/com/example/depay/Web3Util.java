package com.example.depay;

import android.util.Log;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

public class Web3Util {
    private String contractAddress = "0xDf35dB1b389Be8677A01DF22b309DC1cdaE40073";
    private String blockchainUrl = "http://192.168.1.103:8545";
    private String privateKey = "0x72d0d9fab5546774fbba18e68391881a965cb6446fe57bfdd494d6ae74212ec3";
    private BigInteger gasPrice = new BigInteger("60000");
    private BigInteger gasLimit = new BigInteger("600000");

    String getContractAddress() {
        return contractAddress;
    }

    String getBlockchainUrl() {
        return blockchainUrl;
    }

    Payment_sol_Payment loadContract() {
        Web3j web3 = Web3j.build(new HttpService(getBlockchainUrl()));
        Payment_sol_Payment paymentContract = null;
        Credentials credentials = Credentials.create(privateKey);

        try {
            Web3ClientVersion clientVersion = web3.web3ClientVersion().sendAsync().get();
            if (!clientVersion.hasError()) {
                Log.v("success", "success");
                paymentContract = Payment_sol_Payment.load(getContractAddress(), web3, credentials, new DefaultGasProvider() {
                    @Override
                    public BigInteger getGasPrice(String contractFunc) {
                        return new BigInteger("2000000000");
                    }

                    @Override
                    public BigInteger getGasPrice() {
                        return new BigInteger("2000000000");
                    }

                    @Override
                    public BigInteger getGasLimit(String contractFunc) {
                        return new BigInteger("2000000");
                    }

                    @Override
                    public BigInteger getGasLimit() {
                        return new BigInteger("2000000");
                    }
                });
            } else {
                Log.v("error", "error");
            }
        } catch (Exception e) {
            Log.v("error", e.getMessage());
        }
        return paymentContract;
    }
}
