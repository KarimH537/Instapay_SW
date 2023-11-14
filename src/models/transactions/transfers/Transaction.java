package models.transactions.transfers;
import java.util.Date;

public abstract class Transaction {
    String srcUserName;
    Date date;
    String id;
    double amount;
    public abstract String getInfo();
}