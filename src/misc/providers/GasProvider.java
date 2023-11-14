package misc.providers;

public class GasProvider implements ServiceProvider {

    @Override
    public double getBillAmount(String eCode) {
        return 0;
    }

    @Override
    public Bill payBill(String eCode) {
        return null;
    }
}