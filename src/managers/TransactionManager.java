package managers;

import misc.Database;
import misc.providers.services.ServiceProvider;
import misc.providers.transfers.TransferProvider;
import models.User;
import models.transactions.transfers.Transaction;

public class TransactionManager {

    public static double getBalance(User user) {
        return user.getSource().getProvider().getBalance(user.getSource().getIdentifier());
    }

    public static boolean transferToSource(User src, String receiver, double amount, TransferProvider provider) {
        if (getBalance(src) < amount) {
            System.out.println("Your balance isn't enough to complete the transfer\n");
            return false;
        }
        if (!src.getSource().getProvider().deductAmount(src.getSource().getIdentifier(), amount)) {
            System.out.println("Transfer failed\n");
            return false;
        }
        Transaction transaction = provider.transfer(receiver, amount, src.getUsername());
        if (transaction == null) {
            System.out.println("Transfer failed\n");
            src.getSource().getProvider().addAmount(src.getSource().getIdentifier(), amount);
            return false;
        }
        System.out.println("Successfully transferred " + amount + " to " + receiver + "\n");
        Database.addUserTransaction(src.getUsername(), transaction);
        return true;
    }

    public static boolean transferToUser(User src, String receiver, double amount){
        if (getBalance(src) < amount) {
            System.out.println("Your balance isn't enough to complete the transfer\n");
            return false;
        }
        User dest = Database.getUser(receiver);
        if(dest == null){
            System.out.println("The username you are trying to transfer to is invalid\n");
            return false;
        }
        if (!src.getSource().getProvider().deductAmount(src.getSource().getIdentifier(), amount)) {
            System.out.println("Transfer failed\n");
            return false;
        }
        TransferProvider provider = dest.getSource().getProvider();
        Transaction transaction = provider.transfer(dest.getSource().getIdentifier(), amount, dest.getUsername());
        if (transaction == null) {
            System.out.println("Transfer failed\n");
            src.getSource().getProvider().addAmount(src.getSource().getIdentifier(), amount);
            return false;
        }
        System.out.println("Successfully transferred " + amount + " to " + receiver + "\n");
        Database.addUserTransaction(src.getUsername(), transaction);
        return true;
    }

    public static boolean payBill(User src, String eCode, ServiceProvider provider){
        double amount = provider.getBillAmount(eCode);
        if(amount == 0){
            System.out.println("You have no bills to pay\n");
            return false;
        }
        if (getBalance(src) < amount) {
            System.out.println("Your balance isn't enough to pay the bill\n");
            return false;
        }
        if (!src.getSource().getProvider().deductAmount(src.getSource().getIdentifier(), amount)) {
            System.out.println("Payment failed\n");
            return false;
        }
        Transaction bill = provider.payBill(eCode, src.getUsername());
        if(bill == null) {
            System.out.println("Payment failed\n");
            src.getSource().getProvider().addAmount(src.getSource().getIdentifier(), amount);
            return false;
        }
        System.out.println("Successfully paid bill " + eCode + " with amount " + amount + "\n");
        Database.addUserTransaction(src.getUsername(), bill);
        return true;
    }
}