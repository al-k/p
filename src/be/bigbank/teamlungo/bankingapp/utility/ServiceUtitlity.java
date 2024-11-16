package be.bigbank.teamlungo.bankingapp.utility;

import be.bigbank.teamlungo.bankingapp.AccountDB;
import be.bigbank.teamlungo.bankingapp.BankAccount;

public class ServiceUtitlity {
    public static BankAccount logIn() {
        int pinAttempts = 3;
        String iban = "";
        String pin = "";
        BankAccount account;
        while (true) {
            iban = KeyboardUtility.askForString("Please enter your IBAN: ");
            pin = KeyboardUtility.askForString("Please enter your PIN: ");
            if (AccountDB.getAccount(iban) != null) {
                account = AccountDB.getAccount(iban);
                break;
            }
            System.out.println("\nInvalid IBAN. Please try again.\n");
        }
        if (!account.getPin().equals(pin)) {
            for (int i = pinAttempts - 1; i > 0; i--) {
                System.out.printf("%nInvalid PIN. You have %d attempts remaining%n%n", i);
                pin = KeyboardUtility.askForString("Please enter your PIN: ");
                if (account.getPin().equals(pin)) {
                    return account;
                }
            }
        } else return account;
        PrintUtility.printSorryMessage();
        return null;
    }
}
