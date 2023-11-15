package models.transactions.transfers;

import java.util.Date;

class InstapayTransfer extends Transaction{
    private String destUserName;

    public InstapayTransfer(String srcUserName, Date date, String id, double amount, String destUserName) {
        super(srcUserName, date, id, amount);
        this.destUserName = destUserName;
    }

    public String getDestUserName() {
        return destUserName;
    }

    public void setDestUserName(String destUserName) {
        this.destUserName = destUserName;
    }

    @Override
    public String getTransactionType() {
        return "Instapay Transfer";
    }

    @Override
    public String getExtraInfo() {
        String info = new String();
        info += "Destination username : " + destUserName;
        return info;
    }
}