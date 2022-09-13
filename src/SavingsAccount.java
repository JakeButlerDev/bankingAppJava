public class SavingsAccount extends Account{

    // interest rate
    private double interestRate;

    // Default constructor
    public SavingsAccount() {
        super();
    }

    // Param constructor to initialize CheckingAccount with a customer accountNumber and an interest rate
    public SavingsAccount(int accountNumber, double interestRate) {

        super(accountNumber);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calcInterest();
        System.out.println("Interest amount added to balance: $" + interest);
        deposit(interest);
    }

    // Deposit amount as long as value is > 0
    public void deposit(double amount) {
        if (amount > 0){
            balance += amount;
            System.out.println("Amount deposited: $" + amount);
            System.out.println("Balance currently: $" + balance);
        } else System.out.println("Amount entered must be greater than 0.");
    }

    // Withdraw funds from account while amount > 0 AND amount < balance
    public void withdraw(double amount) {

        if (amount > 0) {
            if ((amount) <= balance) {
                System.out.println("Amount withdrawn: $" + (amount));
                balance -= (amount);
                System.out.println("Updated balance: $" + balance);
            }
        } else System.out.println("Amount entered must be greater than 0.");
    }
}
