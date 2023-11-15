package models.sources;

import misc.providers.BankWalletProvider;
import misc.providers.TransferProvider;

public class BankWallet implements FundingSource{
    private String phoneNumber;

    public BankWallet(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public TransferProvider getProvider() {
        return new BankWalletProvider();
    }

    @Override
    public String getInfo() {
        String info = new String();
        info += "Funding source : Bank Wallet";
        info += "Phone number : " + phoneNumber;
        return info;
    }
}