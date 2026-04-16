package Machine;

import java.util.HashMap;
import java.util.Map;

public class ATMSystem {

    private Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account login(int accNumber, int pin) {
        Account acc = accounts.get(accNumber);

        if (acc != null && acc.getPin() == pin) {
            System.out.println("Login successful ✅");
            return acc;
        }

        System.out.println("Invalid credentials ❌");
        return null;
    }
}
