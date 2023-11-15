package misc;

import models.User;
import models.transactions.transfers.Transaction;

import java.util.HashMap;
import java.util.List;

public class Database {
    private static HashMap<String, User> instaPayAccounts;
    private static HashMap<String, List<Transaction>> userTransactions;

    public static void init() {
        instaPayAccounts = new HashMap<>();
        userTransactions = new HashMap<>();
    }

    public User getUser(String username){
        return instaPayAccounts.get(username);
    }

    public boolean addUser(User user){
        if(instaPayAccounts.containsKey(user.getUsername())){
            return false;
        }
        else{
            instaPayAccounts.put(user.getUsername(),user);
            return true;
        }
    }

    public List<Transaction> getUserTransactions(String username){
        return userTransactions.get(username);
    }

}