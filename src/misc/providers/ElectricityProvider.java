package misc.providers;

import models.transactions.bills.Bill;
import models.transactions.bills.ElectricityBill;

public class ElectricityProvider implements ServiceProvider {

    @Override
    public double getBillAmount(String eCode) {
        // Call API to get the amount for this bill
        return 700;
    }

    @Override
    public Bill payBill(String eCode) {
        // Call API to pay the bill with this eCode
        // if payment failed return null
        // else

        // Call API to get the month of the bill with this eCode
        String month = "2023-11";
        // Call API to get the name of the company associated with this code
        String company = "Electrico";
        // Call API to get the watt of this bill
        double watt = 1700;
        return new ElectricityBill(eCode,month,company,watt);
    }
}