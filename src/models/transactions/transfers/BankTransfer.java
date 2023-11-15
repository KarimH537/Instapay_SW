package models.transactions.transfers;

import java.util.Date;

public class BankTransfer extends Transaction{
    private String destBankAccount;

    public BankTransfer(String srcUserName, Date date, String id, double amount, String destBankAccount) {
        super(srcUserName, date, id, amount);
        this.destBankAccount = destBankAccount;
    }

    public String getDestBankAccount() {
        return destBankAccount;
    }

    public void setDestBankAccount(String destBankAccount) {
        this.destBankAccount = destBankAccount;
    }

    @Override
    public String getTransactionType() {
        return "Bank Transfer";
    }

    @Override
    public String getExtraInfo() {
        String info = new String();
        info += "Destination bank account : " + destBankAccount;
        return info;
    }
}