package src.models.sources;

public class BankWallet implements FundingSource {

    @Override
    public TransferProvider getProvider() {
        return null;
    }
}