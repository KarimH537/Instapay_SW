package models.transactions.transfers;

import java.util.Date;

public class BankTransfer extends Transaction{
    private String destBankAccount;

    public BankTransfer(String srcUserName, Date date, double amount, String destBankAccount) {
        super(srcUserName, date, amount);
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