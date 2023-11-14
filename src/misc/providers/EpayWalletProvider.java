package misc.providers;

public class EpayWalletProvider implements TransferProvider {

    @Override
    public Transaction transfer(String identifier, double amount, String senderUserName) {
        return null;
    }

    @Override
    public double getBalance(String identifier) {
        return 0;
    }
}