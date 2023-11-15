package managers;

import misc.Database;
import misc.OTPAuthenticator;
import models.User;
import models.sources.FundingSource;

public class UserManager {

    private static User currentUser;

    public static boolean registerUser(String username, String password, String phoneNumber, FundingSource source) {
//        source.getProvider().validateNumber(phoneNumber);
        if (!OTPAuthenticator.sendOTP(phoneNumber))
            return false;
        User newUser = new User(username, password, phoneNumber, source);
        return Database.addUser(newUser);
    }

    public static boolean loginUser(String username, String password) {
        User user = Database.getUser(username);
        if (user == null || !user.getPassword().equals(password))
            return false;
        currentUser = user;
        return true;
    }

    public static void logout() {
        currentUser = null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}