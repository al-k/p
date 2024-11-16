package be.bigbank.teamlungo.bankingapp;

import be.bigbank.teamlungo.bankingapp.utility.KeyboardUtility;

import java.time.LocalDateTime;

public class BankAccount {
    private String iban;
    private String pin;
    private String fullName;
    private double balance;
    private final Transaction[] incomingTX = new Transaction[10];
    private final Transaction[] outgoingTX = new Transaction[10];

    public BankAccount(String iban, String pin, String fullName, double balance) {
        setIban(iban);
        setPin(pin);
        setFullName(fullName);
        setBalance(balance);
    }

    public BankAccount() {
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
    }

    public void addIncoming(Transaction tx) {
        incomingTX[getEmptyIndex(incomingTX)] = tx;
        deposit(tx.getAmount());
    }

    public void addOutgoing(Transaction tx) {
        outgoingTX[getEmptyIndex(outgoingTX)] = tx;
        withdraw(tx.getAmount());
    }

    private int getEmptyIndex(Transaction[] txs) {
        for (int i = 0; i < txs.length; i++) {
            if (txs[i] == null) return i;
        }
        return -1;
    }

    public void makeTransfer() {
        while (true) {
            System.out.println("----- Making transfer -----");
            String iban = KeyboardUtility.askForString("Please enter recipient's IBAN: ");
            double amount = KeyboardUtility.askForDouble("Please enter amount: ");
            String description = KeyboardUtility.askForString("Please enter description: ");
            if (AccountDB.getAccount(iban) == null) {
                System.out.println("\nInvalid IBAN. Please try again.\n");
                continue;
            }
            if (this.getBalance() < amount) {
                System.out.println("\nInsufficient balance. Please try again.\n");
                continue;
            }
            addOutgoing(new Transaction(this, AccountDB.getAccount(iban), amount, LocalDateTime.now(), description));
            AccountDB.getAccount(iban).addIncoming(new Transaction(this, AccountDB.getAccount(iban), amount, LocalDateTime.now(), description));
            break;
        }
    }
}
