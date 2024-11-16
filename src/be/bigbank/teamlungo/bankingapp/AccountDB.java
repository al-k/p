package be.bigbank.teamlungo.bankingapp;

public class AccountDB {
    static final BankAccount[] ACCOUNTS = {
            new BankAccount("nl", "1234", "James Barns", 5000),
            new BankAccount("ua", "4321", "Alex Wilson", 7000),
            new BankAccount("be", "2", "Lisa Taylor", 5000),
    };

    public static BankAccount getAccount(String iban) {
        for (BankAccount account : ACCOUNTS) {
            if (account != null && account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }
}
