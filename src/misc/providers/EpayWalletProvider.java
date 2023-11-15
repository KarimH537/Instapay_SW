package misc.providers;

import models.transactions.transfers.Transaction;
import models.transactions.transfers.WalletTransfer;

import java.util.Date;

public class EpayWalletProvider implements TransferProvider {

    @Override
    public double getBalance(String identifier) {
        // Call API to get the balance of this identifier
        return 9000;
    }

    @Override
    public Transaction transfer(String identifier, double amount, String senderUserName) {
        // Call API to transfer the amount to this identifier
        // if transfer failed return null
        // else

        Date date = new Date();

        // Call API to get the name of the destination provider
        String destProvider = "Fawry";

        return new WalletTransfer(senderUserName,date,amount,identifier,destProvider);
    }

}