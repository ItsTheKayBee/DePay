package com.example.depay;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class Payment_sol_Payment extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506103b4806100206000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c8063722713f71461005c5780639ace38c214610076578063be1c766b146100c5578063d7081e03146100cd578063e32df819146100fb575b600080fd5b610064610118565b60408051918252519081900360200190f35b6100936004803603602081101561008c57600080fd5b503561012b565b604080516001600160a01b03958616815293909416602084015282840191909152606082015290519081900360800190f35b610064610171565b6100f9600480360360408110156100e357600080fd5b506001600160a01b038135169060200135610177565b005b6100f96004803603602081101561011157600080fd5b503561032c565b3360009081526001602052604090205490565b6000818154811061013b57600080fd5b600091825260209091206004909102018054600182015460028301546003909301546001600160a01b0392831694509116919084565b60005490565b3360009081526001602052604090205481106101d2576040805162461bcd60e51b815260206004820152601560248201527424b739bab33334b1b4b2b73a103130b630b731b29760591b604482015290519081900360640190fd5b336000818152600160208181526040808420805487900390556001600160a01b0387811680865282862080548901905582516080810184528781528085018281528185018a81524260608085019182528a54998a018b55998052925160049098027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563810180549987166001600160a01b03199a8b1617905591517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e564830180549190961698169790971790935594517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56583015593517f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56690910155805194855290840191909152828101849052517f3990db2d31862302a685e8086b5755072a6e2b5b780af1ee81ece35ee3cd33459281900390910190a15050565b336000818152600160209081526040918290208054850190558151928352820183905280517f446e00ad56f9b887844f390c87a128507b991ea0499375f13ecb115288c2df7d9281900390910190a15056fea264697066735822122082abe1bf9ae8bcc50b3fdc29f6d128a34c69cf9922dc1ce1551262ab9f3ed0ad64736f6c63430007040033";

    public static final String FUNC_ADDCRYPTO = "addCrypto";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_GETLENGTH = "getLength";

    public static final String FUNC_TRANSACTIONS = "transactions";

    public static final String FUNC_TRANSFERAMOUNT = "transferAmount";

    public static final Event ADDED_EVENT = new Event("Added",
            Arrays.asList(new TypeReference<Address>() {
            }, new TypeReference<Uint256>() {
            }));

    public static final Event SENT_EVENT = new Event("Sent",
            Arrays.asList(new TypeReference<Address>() {
            }, new TypeReference<Address>() {
            }, new TypeReference<Uint256>() {
            }));

    @Deprecated
    protected Payment_sol_Payment(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Payment_sol_Payment(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Payment_sol_Payment(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Payment_sol_Payment(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    @Deprecated
    public static Payment_sol_Payment load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Payment_sol_Payment(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Payment_sol_Payment load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Payment_sol_Payment(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Payment_sol_Payment load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Payment_sol_Payment(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Payment_sol_Payment load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Payment_sol_Payment(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Payment_sol_Payment> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Payment_sol_Payment.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Payment_sol_Payment> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Payment_sol_Payment.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Payment_sol_Payment> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Payment_sol_Payment.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Payment_sol_Payment> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Payment_sol_Payment.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<AddedEventResponse> getAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDED_EVENT, transactionReceipt);
        ArrayList<AddedEventResponse> responses = new ArrayList<AddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddedEventResponse typedResponse = new AddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddedEventResponse> addedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddedEventResponse>() {
            @Override
            public AddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDED_EVENT, log);
                AddedEventResponse typedResponse = new AddedEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddedEventResponse> addedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDED_EVENT));
        return addedEventFlowable(filter);
    }

    public List<SentEventResponse> getSentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SENT_EVENT, transactionReceipt);
        ArrayList<SentEventResponse> responses = new ArrayList<SentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SentEventResponse typedResponse = new SentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SentEventResponse> sentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SentEventResponse>() {
            @Override
            public SentEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SENT_EVENT, log);
                SentEventResponse typedResponse = new SentEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SentEventResponse> sentEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SENT_EVENT));
        return sentEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addCrypto(BigInteger _amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDCRYPTO,
                Arrays.asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)),
                Collections.emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF,
                Arrays.asList(),
                Arrays.asList(new TypeReference<Uint256>() {
                }));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getLength() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETLENGTH,
                Arrays.asList(),
                Arrays.asList(new TypeReference<Uint256>() {
                }));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple4<String, String, BigInteger, BigInteger>> transactions(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TRANSACTIONS,
                Arrays.asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.asList(new TypeReference<Address>() {
                }, new TypeReference<Address>() {
                }, new TypeReference<Uint256>() {
                }, new TypeReference<Uint256>() {
                }));
        return new RemoteFunctionCall<Tuple4<String, String, BigInteger, BigInteger>>(function,
                new Callable<Tuple4<String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(),
                                (String) results.get(1).getValue(),
                                (BigInteger) results.get(2).getValue(),
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> transferAmount(String _receiver, BigInteger _amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERAMOUNT,
                Arrays.asList(new org.web3j.abi.datatypes.Address(160, _receiver),
                        new org.web3j.abi.datatypes.generated.Uint256(_amount)),
                Collections.emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static class AddedEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger amount;
    }

    public static class SentEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger amount;
    }
}
