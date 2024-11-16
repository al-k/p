package be.bigbank.teamlungo.bankingapp;

import be.bigbank.teamlungo.bankingapp.utility.KeyboardUtility;
import be.bigbank.teamlungo.bankingapp.utility.PrintUtility;
import be.bigbank.teamlungo.bankingapp.utility.ServiceUtitlity;

public class BankApp {
    public static void main(String[] args) {
        PrintUtility.printWelcomeMessage();
        BankAccount bankAccount = ServiceUtitlity.logIn();
        if (bankAccount == null) {
            System.out.println("\nGoodbye!");
            return;
        }
        PrintUtility.printAccountData(bankAccount);
        showMainMenu(bankAccount);
        bankAccount.makeTransfer();
    }

    public static void showMainMenu(BankAccount bankAccount) {
        while (true) {
            PrintUtility.printMainMenu();
            int selection = KeyboardUtility.askForInt("Please enter your choice: ");
            switch (selection) {
                case 1:
                    showTXs("Incoming");
                    break;
                case 2:
                    showTXs("Outgoing");
                    break;
                case 3:
                    bankAccount.makeTransfer();
                    break;
                default:
                    return;
            }
        }
    }

    public static void showTXs(String s) {
        while (true) {
            PrintUtility.printTransactionMenu(s);
            int selection = KeyboardUtility.askForInt("Please enter your choice: ");
            switch (selection) {
                case 1:
                    showAllTransactions();
                    break;
                case 2:
                    showBeforeDateTXs();
                    break;
                case 3:
                    showAfterDateTXs();
                    break;
                case 4:
                    showBetweenTwoDatesTXs();
                    break;
                default:
                    return;
            }
        }
    }

    public static void showAllTransactions() {
    }

    public static void showBeforeDateTXs() {
    }

    public static void showAfterDateTXs() {
    }

    public static void showBetweenTwoDatesTXs() {
    }
}
