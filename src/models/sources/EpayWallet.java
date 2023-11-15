package models.sources;


import misc.providers.EpayWalletProvider;
import misc.providers.TransferProvider;

public class EpayWallet implements FundingSource{
    private String phoneNumber;

    public EpayWallet(String phoneNumber) {
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
        return new EpayWalletProvider();
    }

    @Override
    public String getInfo() {
        String info = new String();
        info += "Funding source : Epay Wallet";
        info += "Phone number : " + phoneNumber;
        return info;
    }
}
