package misc.providers;

import models.transactions.bills.Bill;

public interface ServiceProvider {

    double getBillAmount(String eCode);
    Bill payBill(String eCode);

}