package models.sources;

import misc.providers.TransferProvider;

interface FundingSource{
    public TransferProvider getProvider();
    // TODO
    public String getInfo();
}

