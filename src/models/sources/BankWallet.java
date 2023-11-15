package models.sources;

import misc.providers.transfers.BankWalletProvider;
import misc.providers.transfers.TransferProvider;

public class BankWallet implements FundingSource{
    private String phoneNumber;

    public BankWallet(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BankWallet() {

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

    @Override
    public String getIdentifier() {
        return phoneNumber;
    }
}