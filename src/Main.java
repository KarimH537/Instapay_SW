import controllers.TransactionController;
import controllers.UserController;
import misc.Database;

import java.util.Scanner;

public class Main{
    private static UserController userController;
    private static TransactionController transactionController;

    public static void main(String[] args) {//TODO
        Database.init();
        userController = new UserController();
        transactionController = new TransactionController();

        System.out.println("Welcome to Instapay..\nPlease choose the option you would like to do:\n");
        while (true)
            showMenu();
    }

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        if (userController.getCurrentUser() == null) { //Not logged in view
            System.out.println("1. Register a new user\n2. Log in\n3. T\n4. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1: userController.handleRegister(); break;
                case 2: userController.handleLogin(); break;
                default:
                    System.exit(0);
            }
        } else {
            System.out.println("1. T1\n2. T2\n3. Logout\n4. Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1:break;
                default:
                    System.exit(0);
            }
        }
    }

}