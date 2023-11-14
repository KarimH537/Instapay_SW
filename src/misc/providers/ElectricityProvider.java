package misc.providers;

public class ElectricityProvider implements ServiceProvider {

    @Override
    public double getBillAmount(String eCode) {
        return 0;
    }

    @Override
    public Bill payBill(String eCode) {
        return null;
    }
}