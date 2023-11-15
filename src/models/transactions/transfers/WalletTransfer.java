package models.transactions.transfers;

import java.util.Date;

public class WalletTransfer extends Transaction{
    private String destPhoneNumber;
    private String destProvider;

    public WalletTransfer(String srcUserName, Date date, double amount, String destPhoneNumber, String destProvider) {
        super(srcUserName, date, amount);
        this.destPhoneNumber = destPhoneNumber;
        this.destProvider = destProvider;
    }

    public String getDestPhoneNumber() {
        return destPhoneNumber;
    }

    public void setDestPhoneNumber(String destPhoneNumber) {
        this.destPhoneNumber = destPhoneNumber;
    }

    public String getDestProvider() {
        return destProvider;
    }

    public void setDestProvider(String destProvider) {
        this.destProvider = destProvider;
    }

    @Override
    public String getTransactionType() {
        return "Wallet Transfer";
    }

    @Override
    public String getExtraInfo() {
        String info = new String();
        info += "Destination phone number : " + destPhoneNumber;
        info += "Destination provider : " + destProvider;
        return info;
    }
}