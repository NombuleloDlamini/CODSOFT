import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
            JOptionPane.showMessageDialog(null, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (account.withdraw(amount)) {
            JOptionPane.showMessageDialog(null, "Withdrawal successful. Remaining balance: " + account.getBalance(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient balance.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            account.deposit(amount);
            JOptionPane.showMessageDialog(null, "Deposit successful. New balance: " + account.getBalance(), "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void checkBalance() {
        JOptionPane.showMessageDialog(null, "Current balance is: " + account.getBalance(), "Balance", JOptionPane.INFORMATION_MESSAGE);
    }
}

// Main class
public class Task3 {
    public static void main(String[] args) {
        String initialBalanceStr = JOptionPane.showInputDialog("Enter initial balance: ");
        double initialBalance = Double.parseDouble(initialBalanceStr);
        BankAccount bankAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(bankAccount);

        String[] options = {"Withdraw", "Deposit", "Check Balance", "Exit"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "ATM", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        while (choice != 3) {
            if (choice == 0) {
                String withdrawAmountStr = JOptionPane.showInputDialog("Enter amount to withdraw: ");
                double withdrawAmount = Double.parseDouble(withdrawAmountStr);
                atm.withdraw(withdrawAmount);
            } else if (choice == 1) {
                String depositAmountStr = JOptionPane.showInputDialog("Enter amount to deposit: ");
                double depositAmount = Double.parseDouble(depositAmountStr);
                atm.deposit(depositAmount);
            } else if (choice == 2) {
                atm.checkBalance();
            } else {
                break;
            }

            choice = JOptionPane.showOptionDialog(null, "Choose an option:", "ATM", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        }

        JOptionPane.showMessageDialog(null, "Thank you for using this Bank", "Exit", JOptionPane.INFORMATION_MESSAGE);
    }
}
