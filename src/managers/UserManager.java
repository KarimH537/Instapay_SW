package managers;

import misc.Database;
import misc.OTPAuthenticator;
import models.User;
import models.sources.FundingSource;

public class UserManager {

    private static User currentUser;

    public static boolean registerUser(String username, String password, String phoneNumber, FundingSource source) {
//        source.getProvider().validateNumber(phoneNumber);
        if (!OTPAuthenticator.sendOTP(phoneNumber)) {
            System.out.println("Invalid OTP\n");
            return false;
        }
        User newUser = new User(username, password, phoneNumber, source);
        if (Database.addUser(newUser)) {
            System.out.println("User successfully registered\n");
            return true;
        }
        System.out.println("User already exists\n");
        return false;
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