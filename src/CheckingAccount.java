public class CheckingAccount extends Account{

    // Default transaction fee
    private static double transactionFee = 2.5;

    // Default constructor
    public CheckingAccount() {
        super();
    }

    // Param constructor to initialize CheckingAccount with a customer accountNumber and a customer transactionFee
    public CheckingAccount(int accountNumber, double fee) {

        super(accountNumber);
        transactionFee = fee;
    }

    // Deposit amount as long as value is > 0
    public void deposit(double amount) {
        if (amount > 0){
            balance = amount;
            System.out.println("Amount deposited: $" + amount);

            System.out.println("Fee applied: $" + transactionFee);

            balance -= transactionFee;
            System.out.println("Balance currently: $" + balance);
        } else System.out.println("Amount entered must be greater than 0.");
    }

    // Withdraw funds from account while amount > 0 AND amount < balance
    public void withdraw(double amount) {

        if (amount > 0) {
            if ((amount + transactionFee) <= balance) {
                System.out.println("Amount withdrawn: $" + (amount));
                System.out.println("Fee applied for this transaction: $" + transactionFee);
                balance -= (amount+ transactionFee);
                System.out.println("Updated balance: $" + balance);
            }
        } else System.out.println("Amount entered must be greater than 0.");
    }
}
