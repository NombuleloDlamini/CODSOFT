import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        }
    }

    public void checkBalance() {
        System.out.println("Current balance is: " + account.getBalance());
    }
}

// Main class
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(bankAccount);

       // int choice;
      //  do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();


        while(choice!=4){
            if(choice==1){
                System.out.println("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                atm.withdraw(withdrawAmount);
                break;
            }
            else if(choice==2){
                System.out.println("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                atm.deposit(depositAmount);
                break;
            }
            else if(choice==3){
                atm.checkBalance();
                break;
            }
            else{
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        System.out.println("Thank you for using this Bank");
        System.exit(0);
    }
}
