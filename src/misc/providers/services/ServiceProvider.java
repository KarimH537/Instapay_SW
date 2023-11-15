package misc.providers.services;


import models.transactions.transfers.Transaction;

public interface ServiceProvider {

    double getBillAmount(String eCode);
    Transaction payBill(String eCode,String userName);
}