package modul_8.praktikum3;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String password;


    public BankAccount(String accountNumber, String accountHolder, double initialBalance, String password) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.password = password;
    }



    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
            logTransaction("DEPOSIT", amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public boolean withdraw(double amount, String inputPassword) {
        if (authenticate(inputPassword)) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                System.out.println("Successfully withdrawn: $" + amount);
                logTransaction("WITHDRAW", amount);
                return true;
            } else {
                System.out.println("Invalid withdrawal amount or insufficient funds");
                return false;
            }
        } else {
            System.out.println("Authentication failed!");
            return false;
        }
    }

    public boolean transfer(BankAccount recipient, double amount, String inputPassword) {
        if (withdraw(amount, inputPassword)) {
            recipient.deposit(amount);
            System.out.println("Transfer successful to " + recipient.getAccountHolder() + ".");
            logTransaction("TRANSFER to " + recipient.getAccountNumber(), amount);
            return true;
        }
        return false;
    }


    private boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }


    private void logTransaction(String type, double amount) {
        System.out.println("[LOG] " + type + " - Amount: $" + amount + " - New Balance: $" + balance);
    }


    protected void applyInterest(double rate) {
        double interest = balance * (rate / 100);
        balance += interest;
        System.out.println("Interest applied: $" + interest);
    }


    public void displayAccountInfo() {
        System.out.println("--- ACCOUNT INFO ---");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
}
