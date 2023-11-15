package misc.providers.transfers;

import models.transactions.transfers.Transaction;
import models.transactions.transfers.WalletTransfer;

import java.util.Date;

public class TeleWalletProvider implements TransferProvider {
    @Override
    public double getBalance(String identifier) {
        // Call API to get the balance of this identifier
        return 15000;
    }

    @Override
    public boolean addAmount(String identifier, double amount) {
        // Call API to add the amount to this identifier
        // if successful return true otherwise false;
        return true;
    }

    @Override
    public boolean deductAmount(String identifier, double amount) {
        // Call API to deduct the amount to this identifier
        // if successful return true otherwise false;
        return true;
    }

    @Override
    public Transaction transfer(String identifier, double amount, String senderUserName) {
        // Call API to transfer the amount to this identifier
        // if transfer failed return null
        // else

        Date date = new Date();

        // Call API to get the name of the destination provider
        String destProvider = "Vodafone-Cash";

        return new WalletTransfer(senderUserName,date,amount,identifier,destProvider);
    }

}