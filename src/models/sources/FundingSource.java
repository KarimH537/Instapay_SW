package models.sources;

import misc.providers.transfers.TransferProvider;

public interface FundingSource{
    TransferProvider getProvider();
    // TODO
    String getInfo();

    String getIdentifier();
}

