package models.transactions.bills;
import misc.providers.ServiceProvider;
import misc.providers.GasProvider;

public class GasBill extends Bill{
    private double cubicMeters;

    public GasBill(String eCode, String month, String company, double cubicMeters) {
        super(eCode,month,company);
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

}
