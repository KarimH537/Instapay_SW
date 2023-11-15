import controllers.TransactionController;
import controllers.UserController;
import misc.Database;
import models.sources.BankAccount;
import models.sources.BankWallet;
import views.RegisterView;

import java.util.Scanner;

public class Main {
    private static UserController userController;
    private static TransactionController transactionController;

    public static void main(String[] args) {//TODO
        Database.init();
        userController = new UserController();
        transactionController = new TransactionController();

        System.out.println("Welcome to Instapay (Rady Edition).\nPlease choose the option you would like to do:\n");
        while (true)
            showMenu();
    }

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        if (userController.getCurrentUser() == null) { //Not logged in view
            System.out.println("1. Register a new user\n2. Log in\n3. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    RegisterView.registerUser();
                    //userController.handleRegisterMenu();
                    break;
                case 2:
                    //userController.handleLogin();
                    break;
                default:
                    System.exit(0);
            }
        } else {
            System.out.println("1. Transfer To Wallet\n2. Transfer to Instapay Account\n3. Transfer to Bank Account\n4. Check balance\n5. Pay Bill\n6. Logout\n7. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    if (userController.getCurrentUser().getSource() instanceof BankAccount)
                    //transactionController
                    else
                        System.out.println("Transferring to bank accounts is only valid for users registered using their bank account.");
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.exit(0);
            }
        }
    }

}