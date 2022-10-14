// Base class
// Abstract
// Base class
// Abstract class
public abstract class Account {

    // account number
    private int accountNumber;

    // balance
    protected double balance;

    // Default constructor
    public Account() {}

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    // GETTERS
    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    // Deposit amount as long as value is > 0
    public abstract void deposit(double amount);

    // Withdraw funds from account while amount > 0 AND amount < balance
    public abstract void withdraw(double amount);
}
