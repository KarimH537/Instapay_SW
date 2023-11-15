package misc.providers;

import models.transactions.bills.Bill;
import models.transactions.bills.ElectricityBill;
import models.transactions.bills.GasBill;
import models.transactions.transfers.Transaction;

import java.util.Date;

public class GasProvider implements ServiceProvider {

    @Override
    public double getBillAmount(String eCode) {
        // Call API to get the amount for this bill
        return 200;
    }

    @Override
    public Transaction payBill(String eCode,String userName) {
        // Call API to pay the bill with this eCode
        // if payment failed return null
        // else

        // Call API to get the month of the bill with this eCode
        String month = "2023-11";
        // Call API to get the name of the company associated with this code
        String company = "Gasco";
        // Call API to get the cubic meters of this bill
        double cubicMeters = 70;
        return new GasBill(userName,new Date(),getBillAmount(eCode),eCode,month,company,cubicMeters);
    }
}