package models.sources;

import misc.providers.transfers.BankProvider;
import misc.providers.transfers.TransferProvider;

public class BankAccount implements FundingSource{
    private String accountNumber;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccount() {

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    @Override
    public TransferProvider getProvider() {
        return new BankProvider();
    }

    @Override
    public String getInfo() {
        String info = new String();
        info += "Funding source : Bank account";
        info += "Account number : " + accountNumber;
        return info;
    }

    @Override
    public String getIdentifier() {
        return accountNumber;
    }
}
