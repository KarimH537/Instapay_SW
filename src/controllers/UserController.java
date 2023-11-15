package controllers;

import misc.Database;
import misc.OTPAuthenticator;
import models.User;
import models.sources.FundingSource;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    private static User currentUser;

    public static boolean registerUser(String username, String password, String phoneNumber, FundingSource source) {
//        source.getProvider().validateNumber(phoneNumber);
        if (!OTPAuthenticator.sendOTP(phoneNumber))
            return false;
        User newUser = new User(username, password, phoneNumber, source);
        return Database.addUser(newUser);
    }

    public static boolean loginUser(String username, String password) {
        //TODO
        return false;
    }

    public static void logout() {
        currentUser = null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}