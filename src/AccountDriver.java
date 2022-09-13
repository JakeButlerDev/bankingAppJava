import java.util.Scanner;

public class AccountDriver {

    // Entry point of application
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Account accounts[] = new Account[10];
        int numAccounts = 0;

        int choice;

        do {
            choice = menu(scanner);
            System.out.println();

            if (choice == 1) {
                accounts[numAccounts++] = createAccount(scanner);
            } else if(choice == 2) {
                doDeposit(accounts, numAccounts, scanner);
            } else if (choice == 3) {
                doWithdraw(accounts, numAccounts, scanner);
            } else if (choice == 4) {
                applyInterest(accounts, numAccounts, scanner);
            } else {
                System.out.println("Thank you for being a valued customer. Good bye.");
            }
            System.out.println();
        } while (choice != 5);
    }

    // User menu for account type selection
    public static int accountMenu(Scanner scanner) {
        System.out.println("Select Account Type");
        System.out.println("1. Checking");
        System.out.println("2. Savings");

        int choice;

        do {
            System.out.println("Enter selection: \n");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 2);

        return choice;
    }

    public static int searchAccount(Account accounts[], int count, int accountNumber) {

        for(int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) return i;
        }

        return -1;
    }

    public static void doDeposit(Account accounts[], int count, Scanner scanner) {
        System.out.println("\nPlease enter your account number: ");
        int accountNumber = scanner.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            System.out.println("Please enter deposit amount: $");
            double amount = scanner.nextDouble();
            accounts[index].deposit(amount);
        } else System.out.println("Account number " + accountNumber + " not found.");
    }

    public static void doWithdraw (Account accounts[], int count, Scanner scanner) {
        System.out.println("\nPlease enter your account number: ");
        int accountNumber = scanner.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            System.out.println("Please enter withdrawal amount: $");
            double amount = scanner.nextDouble();
            accounts[index].withdraw(amount);
        } else System.out.println("Account number " + accountNumber + " not found.");
    }

    public static void applyInterest(Account accounts[], int count, Scanner scanner) {
        System.out.println("\nPlease enter your account number: ");
        int accountNumber = scanner.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {

            if (accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        } else System.out.println("Account number " + accountNumber + " not found.");
    }

    // Allows user to create new Account
    public static Account createAccount(Scanner scanner) {
        Account account = null;
        int choice = accountMenu(scanner);

        int accountNumber;
        System.out.println("Enter account number: ");
        accountNumber = scanner.nextInt();

        if (choice == 1) { // checking account
            System.out.println("Enter transaction fee: ");
            double transactionFee = scanner.nextDouble();

            account = new CheckingAccount(accountNumber, transactionFee);
        } else {    // savings account
            System.out.println("Enter interest rate: ");
            double interestRate = scanner.nextDouble();

            account = new SavingsAccount(accountNumber, interestRate);
        }
        return account;
    }

    // User menu to display options of app
    public static int menu(Scanner scanner) {
        System.out.println("Banking Menu");
        System.out.println("\n\n\n<------->");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Exit program");


        int choice;

        do {
            System.out.println("Enter selection: \n");
            choice = scanner.nextInt();
        } while (choice < 1 || choice >=5);

        return choice;
    }
}
