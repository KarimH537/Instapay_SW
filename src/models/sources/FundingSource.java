package models.sources;

import misc.providers.transfers.TransferProvider;

public interface FundingSource{
    TransferProvider getProvider();

    String getInfo();

    String getIdentifier();
}

