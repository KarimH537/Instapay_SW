package views;

import managers.UserManager;
import models.sources.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterView {

    private static Scanner scanner = new Scanner(System.in);

    public static void showRegisterView() {
        System.out.println("1. Register using bank account\n2. Register using wallet\n3. Back\n4. Exit\n");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                registerUser(new BankAccount());
                break;
            case 2:
                registerWalletUser();
                break;
            case 3:
                break;
            default:
                System.exit(0);
        }
    }

    private static void registerWalletUser() {
        System.out.println("1. Register using tele wallet\n2. Register using bank wallet\n3. Register using epay wallet\n4. Back\n");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                registerUser(new TeleWallet());
                break;
            case 2:
                registerUser(new BankWallet());
                break;
            case 3:
                registerUser(new EpayWallet());
                break;
            case 4:
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

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValidPassword(final String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private static boolean registerUser(FundingSource source) {
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

        return UserManager.registerUser(username, password, phoneNumber, source);
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
        System.out.println("Failed login\n");
        return false;
    }
}
