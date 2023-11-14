package src.models.transactions.transfers;

public abstract class Transaction {
    String srcUserName;
    Date date;
    String id;
    double amount;
    public abstract String getInfo();
}