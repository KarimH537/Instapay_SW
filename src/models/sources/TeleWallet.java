package models.sources;

import misc.providers.transfers.TeleWalletProvider;
import misc.providers.transfers.TransferProvider;

public class TeleWallet implements FundingSource{
    private String phoneNumber;

    public TeleWallet(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TeleWallet() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public TransferProvider getProvider() {
        return new TeleWalletProvider();
    }

    @Override
    public String getInfo() {
        String info = new String();
        info += "Funding source : Tele Wallet" + "\n";
        info += "Phone number : " + phoneNumber + "\n";
        return info;
    }

    @Override
    public String getIdentifier() {
        return phoneNumber;
    }
}