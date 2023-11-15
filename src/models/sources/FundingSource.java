package models.sources;

import misc.providers.TransferProvider;

public interface FundingSource{
    TransferProvider getProvider();
    // TODO
    String getInfo();

    String getIdentifier();
}

