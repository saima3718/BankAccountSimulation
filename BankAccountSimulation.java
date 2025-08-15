import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccountSimulation {
    public static void main(String[] args) {
        // Create a new account
        Account myAccount = new Account("134257689", "Sarah chaudhary", 10000.00);
        
        // Perform some transactions
        myAccount.deposit(5000.00);
        myAccount.withdraw(500.00);
        myAccount.deposit(10000.00);
        myAccount.withdraw(15000.00);
        
        // Try to withdraw more than balance
        myAccount.withdraw(10000.00);
        
        // Display account information
        myAccount.displayAccountInfo();
        
        // Display transaction history
        myAccount.displayTransactionHistory();
    }
}

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;
    
    // Constructor
    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        
        // Record initial deposit
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        transactionHistory.add(timestamp + " - Initial deposit: +₹" + initialBalance);
    }
    
    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            transactionHistory.add(timestamp + " - Deposit: +₹" + amount);
            System.out.println("Deposit of ₹" + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                transactionHistory.add(timestamp + " - Withdrawal: -₹" + amount);
                System.out.println("Withdrawal of ₹" + amount + " successful.");
            } else {
                System.out.println("Insufficient funds for withdrawal of ₹" + amount + 
                                 ". Current balance: ₹" + balance);
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    
    // Display account information
    public void displayAccountInfo() {
        System.out.println("\n=== Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: ₹" + balance);
    }
// Display transaction history
    public void displayTransactionHistory() {
        System.out.println("\n=== Transaction History ===");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
    
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance(){
        return balance;
    } 
}
