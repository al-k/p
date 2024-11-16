package be.bigbank.teamlungo.bankingapp;

import java.time.LocalDateTime;

public class Transaction {
    private BankAccount sender;
    private BankAccount recipient;
    private double amount;
    private LocalDateTime timeStamp;
    private String description;

    public Transaction(BankAccount sender, BankAccount recipient, double amount, LocalDateTime timeStamp, String description) {
        setSender(sender);
        setRecipient(recipient);
        setAmount(amount);
        setTimeStamp(timeStamp);
        setDescription(description);
    }

    public Transaction() {
    }

    public BankAccount getSender() {
        return sender;
    }

    public void setSender(BankAccount sender) {
        this.sender = sender;
    }

    public BankAccount getRecipient() {
        return recipient;
    }

    public void setRecipient(BankAccount recipient) {
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
