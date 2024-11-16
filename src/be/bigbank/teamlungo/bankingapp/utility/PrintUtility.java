package be.bigbank.teamlungo.bankingapp.utility;

import be.bigbank.teamlungo.bankingapp.BankAccount;
import be.bigbank.teamlungo.bankingapp.Transaction;

public class PrintUtility {
    public static void printWelcomeMessage() {
        System.out.println("============================");
        System.out.println("Welcome to The Big Bank App!");
        System.out.println("============================\n");
    }

    public static void printSorryMessage() {
        System.out.println("\nSorry, but you exceeded the maximum numbers of attempts.");
        System.out.println("Program now will exit.");
    }

    public static void printAccountData(BankAccount account) {
        System.out.println("----------------------------------------");
        System.out.printf("Logged in as : %s%n", account.getFullName());
        System.out.printf("Balance : $%.2f%n", account.getBalance());
        System.out.println("----------------------------------------");

    }

    public static void printMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Incoming Transactions");
        System.out.println("2. Outgoing Transactions");
        System.out.println("3. Make transfer");
        System.out.println("4. Sign out\n");
    }

    public static void printTransactionMenu(String s) {
        System.out.printf("%s Transaction Menu:%n", s);
        System.out.println("1. All Transactions");
        System.out.println("2. Before a date");
        System.out.println("3. After a date");
        System.out.println("4. Between two dates");
        System.out.println("5. Back\n");
    }

    public static void printTransaction(Transaction transaction) {
//        System.out.println("Showing all transaction: ");
        System.out.printf("Sender: %s, Receiver: %n", transaction.getSender());
    }
}
