package models.sources;


import misc.providers.transfers.EpayWalletProvider;
import misc.providers.transfers.TransferProvider;

public class EpayWallet implements FundingSource{
    private String phoneNumber;

    public EpayWallet(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EpayWallet() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public TransferProvider getProvider() {
        return new EpayWalletProvider();
    }

    @Override
    public String getInfo() {
        String info = new String();
        info += "Funding source : Epay Wallet" + "\n";
        info += "Phone number : " + phoneNumber + "\n";
        return info;
    }

    @Override
    public String getIdentifier() {
        return phoneNumber;
    }
}
