package models.transactions.bills;
import misc.providers.services.ServiceProvider;
import misc.providers.services.ElectricityProvider;

import java.util.Date;


public class ElectricityBill extends Bill{
    private double watt;

    public ElectricityBill(String srcUserName, Date date, double amount, String eCode, String month, String company, double watt) {
        super(srcUserName,date,amount,eCode,month,company);
        this.watt = watt;
    }

    public double getWatt(){
        return watt;
    }

    public void setWatt(double watt){
        this.watt = watt;
    }

    public ServiceProvider getProvider(){
        return new ElectricityProvider();
    }

    @Override
    public String getTransactionType() {
        return null;
    }

    @Override
    public String getExtraInfo() {
        String info = new String();
        info += "Ecode : " + geteCode() + "\n";
        info += "Month : " + getMonth() + "\n";
        info += "Company : " + getCompany() + "\n";
        info += "Watt : " + watt + "\n";
        return info;
    }
}