package models.transactions.bills;

import misc.providers.ServiceProvider;
import models.transactions.transfers.Transaction;

import java.util.Date;

public abstract class Bill extends Transaction {
    private String eCode;
    private String month;
    private String company;

    Bill(String srcUserName, Date date, double amount,String eCode, String month, String company) {
        super(srcUserName,date,amount);
        this.eCode = eCode;
        this.month = month;
        this.company = company;
    }

    public String geteCode(){
        return eCode;
    }

    public void seteCode(String eCode){
        this.eCode = eCode;
    }

    public String getMonth(){
        return month;
    }

    public void setMonth(String month){
        this.month = month;
    }

    public String getCompany(){
        return company;
    }

    public void setCompany(String company){
        this.company = company;
    }


    abstract public ServiceProvider getProvider();
}