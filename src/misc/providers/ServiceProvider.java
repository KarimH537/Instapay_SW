package misc.providers;

interface ServiceProvider {

    double getBillAmount(String eCode);
    Bill payBill(String eCode);

}