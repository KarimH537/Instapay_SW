public class BankAccount implements FundingSource {

    @Override
    public TransferProvider getProvider() {
        return null;
    }
}