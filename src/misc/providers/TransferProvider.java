package misc.providers;

interface TransferProvider {
    Transaction transfer(String identifier, double amount, String senderUserName);
    double getBalance(String identifier);
}