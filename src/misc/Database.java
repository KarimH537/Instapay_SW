package misc;

import models.User;
import models.transactions.transfers.Transaction;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private static HashMap<String, User> instaPayAccounts;
    private static HashMap<String, ArrayList<Transaction>> userTransactions;

    public static void init() {
        instaPayAccounts = new HashMap<>();
        userTransactions = new HashMap<>();
    }

    public static User getUser(String username) {
        return instaPayAccounts.get(username);
    }

    public static boolean addUser(User user) {
        if (instaPayAccounts.containsKey(user.getUsername())) {
            return false;
        } else {
            instaPayAccounts.put(user.getUsername(), user);
            userTransactions.put(user.getUsername(), new ArrayList<>());
            return true;
        }
    }

    public ArrayList<Transaction> getUserTransactions(String username) {
        return userTransactions.get(username);
    }

    public static boolean addUserTransaction(String username, Transaction transaction) {
        if (!instaPayAccounts.containsKey(username)) {
            return false;
        } else {
            userTransactions.get(username).add(transaction);
            return true;
        }
    }

}