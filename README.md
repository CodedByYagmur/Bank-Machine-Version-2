# Bank Machine - Version 2

This is my second attempt at making a simple ATM program in Java. I did a basic version before but it was mostly in one file, so for this one I split things into separate classes and tried to use OOP properly.

It runs in the console. You enter account number and PIN, and if login works you get a menu to check balance, deposit, withdraw, or see your recent transactions.

## Requirements

- Java JDK (I used JDK 17 in Eclipse, anything recent should be fine)

## Project structure

```
Machine/
  Account.java
  ATMSystem.java
  MainMachineSystem.java
```

All files use `package Machine;` so they need to be inside a `Machine` folder when compiling from terminal. If you use an IDE like Eclipse or IntelliJ, just import the project and run `MainMachineSystem`.

## How to run (command line)

From the project folder:

```
javac Machine/*.java
java Machine.MainMachineSystem
```

## Test accounts

Two accounts are already added in the code for testing:

| Account No | PIN  | Balance |
|------------|------|---------|
| 123        | 1111 | 5000    |
| 456        | 2222 | 3000    |

## What it does

After login you can pick from the menu:

1. Balance - shows current balance
2. Deposit - adds money to account
3. Withdraw - takes money out (won't let you withdraw more than you have)
4. Mini Statement - prints list of deposits and withdrawals
5. Exit

Login gives you 3 tries. If all fail the program stops (like card blocked).

## Classes

- **Account** - holds account number, pin, balance and transaction history
- **ATMSystem** - stores accounts in a HashMap and handles login
- **MainMachineSystem** - main method, menu loop and user input with Scanner

## Notes

This is still a school project so it doesn't save data to a file. When you close the program everything resets. Maybe I'll add file saving in a later version if I have time.
