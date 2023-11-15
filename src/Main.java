import managers.TransactionManager;
import managers.UserManager;
import misc.Database;
import misc.providers.services.GasProvider;
import models.User;
import models.sources.BankAccount;
import models.sources.BankWallet;
import models.sources.EpayWallet;
import views.UserView;
import views.TransactionView;

import java.util.Scanner;

public class Main {

    public static void testMethod() {
        // Register
        UserManager.registerUser("Boda", "Bodapk1!@#", "0101001010", new BankAccount("AE10000"));
        UserManager.registerUser("Koghwassioant", "Bodapk1!@#", "0101001012", new EpayWallet("0101001012"));
        // Login
        UserManager.loginUser("Boda", "Bodapk1!@#");
        // Transfer to User
        TransactionManager.transferToUser(UserManager.getCurrentUser(), "Koghwassioant", 100);
        // Print transactions
        TransactionView.printUserTransactions();
        // View profile
        TransactionView.printUserProfile();
        // Pay Bill
        TransactionManager.payBill(UserManager.getCurrentUser(), "E10234900", new GasProvider());
    }

    public static void main(String[] args) {
        Database.init();
        System.out.println("Welcome to Instapay (Rady Edition).\nPlease choose the option you would like to do:\n");
        /*
        while (true)
            showMenu();
        */
        testMethod();
    }

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        if (UserManager.getCurrentUser() == null) { //Not logged in view
            System.out.println("1. Register a new user\n2. Log in\n3. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    UserView.showRegisterView();
                    break;
                case 2:
                    UserView.showLoginView();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Choose a valid option.\n");
            }
        } else {
            System.out.println("1. Transfer To Wallet\n2. Transfer to Instapay Account\n3. Transfer to Bank Account\n4. Check balance\n5. Pay Bill\n6. Get transaction history\n7. View your profile\n8. Logout\n9. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    TransactionView.showWalletView();
                    break;
                case 2:
                    TransactionView.showAccountView();
                    break;
                case 3:
                    TransactionView.showBankView();
                    break;
                case 4:
                    TransactionView.showBalance();
                    break;
                case 5:
                    TransactionView.showBillView();
                    break;
                case 6:
                    TransactionView.printUserTransactions();
                    break;
                case 7:
                    TransactionView.printUserProfile();
                    break;
                case 8:
                    UserView.showLogoutMenu();
                    break;
                case 9:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Choose a valid option.\n");
            }
        }
    }

}