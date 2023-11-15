package misc.providers;

public interface ServiceProvider {

    double getBillAmount(String eCode);
    Bill payBill(String eCode);

}