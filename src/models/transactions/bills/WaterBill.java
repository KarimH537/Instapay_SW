package models.transactions.bills;

class WaterBill extends Bill{
    private double liters;

    WaterBill(String eCode, String month, String company,double liters) {
        super(eCode,month,company);
        this.liters = liters;
    }

    public double getLiters(){
        return liters;
    }

    public void setLiters(double liters){
        this.liters = liters;
    }

//    public ServiceProvider getProvider(){
//        return new WaterProvider();
//    }

}
