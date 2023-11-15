package misc.providers;

import models.transactions.transfers.BankTransfer;
import models.transactions.transfers.Transaction;


import java.util.Date;

public class BankProvider implements TransferProvider {

    @Override
    public double getBalance(String identifier) {
        // Call API to get the balance of this identifier
        return 50000;
    }

    @Override
    public Transaction transfer(String identifier, double amount, String senderUserName) {
        // Call API to transfer the amount to this identifier
        // if transfer failed return null
        // else

        Date date = new Date();

        return new BankTransfer(senderUserName,date,amount,identifier);
    }

}