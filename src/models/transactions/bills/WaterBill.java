package models.transactions.bills;
import misc.providers.services.ServiceProvider;
import misc.providers.services.WaterProvider;

import java.util.Date;

public class WaterBill extends Bill{
    private double liters;

    public WaterBill(String srcUserName, Date date, double amount, String eCode, String month, String company, double liters) {
        super(srcUserName,date,amount,eCode,month,company);
        this.liters = liters;
    }

    public double getLiters(){
        return liters;
    }

    public void setLiters(double liters){
        this.liters = liters;
    }

    public ServiceProvider getProvider(){
        return new WaterProvider();
    }

    @Override
    public String getTransactionType() {
        return "Water Bill";
    }

    @Override
    public String getExtraInfo() {
        String info = new String();
        info += "Ecode : " + geteCode();
        info += "Month : " + getMonth();
        info += "Company : " + getCompany();
        info += "Liters : " + liters;
        return info;
    }
}
