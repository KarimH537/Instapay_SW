import managers.TransactionManager;
import managers.UserManager;
import misc.Database;
import models.sources.BankAccount;
import views.RegisterView;
import views.TransactionView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {//TODO
        Database.init();
        System.out.println("Welcome to Instapay (Rady Edition).\nPlease choose the option you would like to do:\n");
        while (true)
            showMenu();
    }

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        if (UserManager.getCurrentUser() == null) { //Not logged in view
            System.out.println("1. Register a new user\n2. Log in\n3. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    RegisterView.showRegisterView();
                    break;
                case 2:
                    RegisterView.showLoginView();
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
                    if (UserManager.getCurrentUser().getSource() instanceof BankAccount)
                        TransactionView.showBankView();
                    else
                        System.out.println("Transferring to bank accounts is only valid for users registered using their bank account.\n");
                    break;
                case 4:
                    System.out.println("Balance : " + TransactionManager.getBalance(UserManager.getCurrentUser()));
                    break;
                case 5:
                    TransactionView.showBillView();
                    break;
                case 6:
                    TransactionView.printUserTransactions(UserManager.getCurrentUser().getUsername());
                    break;
                case 7:
                    TransactionView.printUserProfile(UserManager.getCurrentUser());
                    break;
                case 8:
                    UserManager.logout();
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