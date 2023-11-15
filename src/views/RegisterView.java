package views;

import managers.UserManager;
import misc.Database;
import models.sources.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterView {

    private static Scanner scanner = new Scanner(System.in);

    public static void showRegisterView() {
        //Prompt for input
        System.out.print("Enter username:\n");
        String username = scanner.nextLine();

        while (!isValidUsername(username)) {
            System.out.println("Invalid username! Username should be at least 4 characters long.\n");
            username = scanner.nextLine();
        }


        System.out.print("Enter password:\n");
        String password = scanner.nextLine();

        while (!isValidPassword(password)) {
            System.out.println("Invalid password! Password should be at least 8 characters long and contain 1 digit," +
                    " 1 lowercase character, 1 uppercase character and a special character.\n");
            password = scanner.nextLine();
        }

        System.out.print("Enter phone number:\n");
        String phoneNumber = scanner.nextLine();

        while (!isValidPhone(phoneNumber)) {
            System.out.println("Phone number must be 10 digits.\n");
            phoneNumber = scanner.nextLine();
        }

        System.out.println("1. Register using bank account\n2. Register using tele wallet\n3. Register using bank wallet\n" +
                "4. Register using epay wallet\n5. Back\n");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.print("Enter bank IBAN:\n");
                String accNum = scanner.nextLine();
                //Check if valid IBAN using API
                UserManager.registerUser(username, password, phoneNumber, new BankAccount(accNum));
                break;
            case 2:
                UserManager.registerUser(username, password, phoneNumber, new TeleWallet(phoneNumber));
                break;
            case 3:
                UserManager.registerUser(username, password, phoneNumber, new BankWallet(phoneNumber));
                break;
            case 4:
                UserManager.registerUser(username, password, phoneNumber, new EpayWallet(phoneNumber));
                break;
            case 5:
                break;
            default:
                System.exit(0);
        }
    }

    // Validate username (at least 4 characters)
    private static boolean isValidUsername(String username) {
        return username.length() >= 4;
    }

    // Validate password
    // 8 characters + 1 digit + lowercase char + uppercase char + one special character
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private static final Pattern PASS_PATTERN = Pattern.compile(PASSWORD_PATTERN);

    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

    public static boolean isValidPassword(final String password) {
        Matcher matcher = PASS_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidPhone(final String phone) {
        Matcher matcher = PHONE_PATTERN.matcher(phone);
        return matcher.matches();
    }

    public static boolean showLoginView() {
        //Prompt for input
        System.out.print("Enter username:\n");
        String username = scanner.nextLine();
        System.out.print("Enter password:\n");
        String password = scanner.nextLine();
        if (UserManager.loginUser(username, password)) {
            System.out.println("Logged in successfully\n");
            return true;
        }
        return false;
    }
}
