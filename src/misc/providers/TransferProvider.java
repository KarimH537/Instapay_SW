package misc.providers;

import models.transactions.transfers.Transaction;

public interface TransferProvider {
    Transaction transfer(String identifier, double amount, String senderUserName);
    double getBalance(String identifier);
    boolean addAmount(String identifier, double amount);
    boolean deductAmount(String identifier, double amount);
}