package Machine;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountNumber;
    private int pin;
    private double balance;
    private List<String> transactions = new ArrayList<>();

    public Account(int accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            transactions.add("Failed withdrawal (insufficient funds): " + amount);
            return false;
        }
        balance -= amount;
        transactions.add("Withdrawn: " + amount);
        return true;
    }

    public void printMiniStatement() {
        System.out.println("=== Mini Statement ===");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}