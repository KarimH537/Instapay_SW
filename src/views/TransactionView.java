package views;

import managers.TransactionManager;
import managers.UserManager;
import misc.Database;
import misc.providers.services.ElectricityProvider;
import misc.providers.services.GasProvider;
import misc.providers.services.ServiceProvider;
import misc.providers.services.WaterProvider;
import misc.providers.transfers.*;
import models.User;
import models.sources.BankAccount;
import models.transactions.transfers.Transaction;

import java.util.ArrayList;
import java.util.Scanner;

public class TransactionView {

    private static Scanner sc = new Scanner(System.in);

    public static void showWalletView() {
        System.out.println("1. Transfer To Tele Wallet\n2. Transfer to Bank Wallet\n3. Transfer to Epay Wallet\n4. Back\n");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                transferMoney(new TeleWalletProvider());
                break;
            case 2:
                transferMoney(new BankWalletProvider());
                break;
            case 3:
                transferMoney(new EpayWalletProvider());
                break;
            case 4:
                break;
            default:

        }
    }

    private static void transferMoney(TransferProvider provider) {
        System.out.print("Enter phone number to transfer to:\n");
        String identifier = sc.nextLine();
        System.out.print("Enter amount:\n");
        double amount = sc.nextDouble();
        while (amount <= 0) {
            System.out.print("The amount to transfer must be positive enter amount:\n");
            amount = sc.nextDouble();
        }
        sc.nextLine();
        TransactionManager.transferToSource(UserManager.getCurrentUser(), identifier, amount, provider);
    }

    public static void showAccountView() {
        System.out.print("Enter username to transfer to:\n");
        String identifier = sc.nextLine();
        System.out.print("Enter amount:\n");
        double amount = sc.nextDouble();
        while (amount <= 0) {
            System.out.print("The amount to transfer must be positive enter amount:\n");
            amount = sc.nextDouble();
        }
        sc.nextLine();
        TransactionManager.transferToUser(UserManager.getCurrentUser(), identifier, amount);
    }

    public static void showBankView() {
        if (!(UserManager.getCurrentUser().getSource() instanceof BankAccount)) {
            System.out.println("Transferring to bank accounts is only valid for users registered using their bank account.\n");
            return;
        }
        System.out.print("Enter IBAN to transfer to:\n");
        String identifier = sc.nextLine();
        System.out.print("Enter amount:\n");
        double amount = sc.nextDouble();
        while (amount <= 0) {
            System.out.print("The amount to transfer must be positive enter amount:\n");
            amount = sc.nextDouble();
        }
        sc.nextLine();
        TransactionManager.transferToSource(UserManager.getCurrentUser(), identifier, amount, new BankProvider());
    }

    public static void showBillView() {
        System.out.println("1. Pay electricity bill\n2. Pay gas bill\n3. Pay water bill\n4. Back\n5. Exit\n");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                payBill(new ElectricityProvider());
                break;
            case 2:
                payBill(new GasProvider());
                break;
            case 3:
                payBill(new WaterProvider());
                break;
            case 4:
                break;
            default:

        }
    }

    private static void payBill(ServiceProvider provider) {
        System.out.print("Enter ECode of bill to pay:\n");
        String eCode = sc.nextLine();
        TransactionManager.payBill(UserManager.getCurrentUser(), eCode, provider);
    }

    public static void printUserTransactions() {
        String userName = UserManager.getCurrentUser().getUsername();
        ArrayList<Transaction> transactions = Database.getUserTransactions(userName);
        System.out.println("Your transaction history\n");
        int counter = 1;
        for (Transaction transaction : transactions) {
            System.out.println(counter++ + ". " + transaction.getInfo());
        }
    }

    public static void printUserProfile() {
        User user = UserManager.getCurrentUser();
        System.out.println("Username : " + user.getUsername());
        System.out.println("Phone number : " + user.getPhoneNumber());
        System.out.println(user.getSource().getInfo());
    }

    public static void showBalance() {
        System.out.println("Balance : " + TransactionManager.getBalance(UserManager.getCurrentUser()));
    }
}
