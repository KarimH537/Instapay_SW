package models.transactions.transfers;
import java.util.Date;

public abstract class Transaction {
    String srcUserName;
    Date date;
    int id;
    static int idCounter = 1;
    double amount;


    public Transaction(String srcUserName, Date date, double amount) {
        this.srcUserName = srcUserName;
        this.date = date;
        this.id = idCounter++;
        this.amount = amount;
    }

    public String getSrcUserName() {
        return srcUserName;
    }

    public void setSrcUserName(String srcUserName) {
        this.srcUserName = srcUserName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public abstract String getTransactionType();

    public abstract String getExtraInfo();
    public String getInfo(){
        // headLine of Transaction
        String info = new String();
        info += getTransactionType();
        info += "Source user name : " + srcUserName;
        info += "Date : " + date;
        info += "Transaction id : " + id;
        info += "amount : " + amount;
        info += getExtraInfo();
        return info;
    }

}