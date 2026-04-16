package Machine;

import java.util.Scanner;

public class MainMachineSystem {
	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ATMSystem system = new ATMSystem();

        // Sample accounts
        system.addAccount(new Account(123, 1111, 5000));
        system.addAccount(new Account(456, 2222, 3000));

        System.out.println("🟢 Welcome to Next-Gen ATM");

        int attempts = 3;
        Account currentAccount = null;

        while (attempts > 0) {

            System.out.print("Enter Account Number: ");
            int accNo = scanner.nextInt();

            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();

            currentAccount = system.login(accNo, pin);

            if (currentAccount != null) break;

            attempts--;
            System.out.println("Attempts left: " + attempts);
        }

        if (currentAccount == null) {
            System.out.println("Card blocked 🚫");
            return;
        }

        while (true) {

            System.out.println("\n1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");

            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Balance: " + currentAccount.getBalance());
                    break;

                case 2:
                    System.out.print("Deposit amount: ");
                    double dep = scanner.nextDouble();
                    currentAccount.deposit(dep);
                    break;

                case 3:
                    System.out.print("Withdraw amount: ");
                    double wit = scanner.nextDouble();

                    if (currentAccount.withdraw(wit)) {
                        System.out.println("Collect cash ");
                    } else {
                        System.out.println("Insufficient balance ❌");
                    }
                    break;

                case 4:
                    currentAccount.printMiniStatement();
                    break;

                case 5:
                    System.out.println("Thank you for banking 🏦");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
