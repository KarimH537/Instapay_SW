package models.sources;

import misc.providers.BankWalletProvider;
import misc.providers.TransferProvider;

public class BankWallet implements FundingSource{

    @Override
    public TransferProvider getProvider() {
        return new BankWalletProvider();
    }

    @Override
    public String getInfo() {
        String info = new String();
        info += "Funding source : Bank Wallet";
        return info;
    }
}