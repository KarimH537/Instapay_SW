package models.sources;

import misc.providers.BankProvider;
import misc.providers.TransferProvider;

public class BankAccount implements FundingSource{
    private String accountNumber;

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
}
