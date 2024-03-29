package models;
import models.sources.*;
public class User {
    private String username;
    private String password;
    private String phoneNumber;
    private FundingSource source;

    public User(String username, String password, String phoneNumber, FundingSource source) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.source = source;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public FundingSource getSource() {
        return source;
    }

    public void setSource(FundingSource source) {
        this.source = source;
    }

}