package models.transactions.bills;
import misc.providers.ServiceProvider;
import misc.providers.GasProvider;

import java.util.Date;

public class GasBill extends Bill{
    private double cubicMeters;

    public GasBill(String srcUserName, Date date, double amount, String eCode, String month, String company, double cubicMeters) {
        super(srcUserName,date,amount,eCode,month,company);
        this.cubicMeters = cubicMeters;
    }

    public double getCubicMeters(){
        return cubicMeters;
    }

    public void setCubicMeters(double cubicMeters){
        this.cubicMeters = cubicMeters;
    }

    public ServiceProvider getProvider(){
        return new GasProvider();
    }

    @Override
    public String getTransactionType() {
        return "Gas Bill";
    }

    @Override
    public String getExtraInfo() {
        String info = new String();
        info += "Ecode : " + geteCode();
        info += "Month : " + getMonth();
        info += "Company : " + getCompany();
        info += "Cubic meters : " + cubicMeters;
        return info;
    }
}
