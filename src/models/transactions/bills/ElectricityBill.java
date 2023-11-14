package models.transactions.bills;



class ElectricityBill extends Bill{
    private double watt;

    ElectricityBill(String eCode, String month, String company,double watt) {
        super(eCode,month,company);
        this.watt = watt;
    }

    public double getWatt(){
        return watt;
    }

    public void setWatt(double watt){
        this.watt = watt;
    }

//    public ServiceProvider getProvider(){
//        return new ElectricityProvider();
//    }

}