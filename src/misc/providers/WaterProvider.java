package misc.providers;

import models.transactions.bills.Bill;
import models.transactions.bills.GasBill;
import models.transactions.bills.WaterBill;

import java.util.Date;

public class WaterProvider implements ServiceProvider {

    @Override
    public double getBillAmount(String eCode) {
        // Call API to get the amount for this bill
        return 1000;
    }

    @Override
    public Bill payBill(String eCode,String userName) {
        // Call API to pay the bill with this eCode
        // if payment failed return null
        // else

        // Call API to get the month of the bill with this eCode
        String month = "2023-11";
        // Call API to get the name of the company associated with this code
        String company = "Watco";
        // Call API to get the liters of this bill
        double liters = 150;
        return new WaterBill(userName,new Date(),getBillAmount(eCode),eCode,month,company,liters);
    }
}