package modul_8.praktikum3;

public class SavingsAccount extends BankAccount{
    private double interestRate;
    public SavingsAccount(String accountNumber, String accountHolder,
                          double initialBalance, String password, double interestRate) {
        super(accountNumber, accountHolder, initialBalance, password);
        this.interestRate = interestRate;
    }

    // Public method to apply interest
    public void applyMonthlyInterest() {
        // Calling protected method from parent
        System.out.println("Monthly interest applied at rate: " + interestRate + "% annually");
        applyInterest(interestRate / 12);
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Savings");
        System.out.println("Annual Interest Rate: " + interestRate + "%");
        System.out.println("-------------");
    }
}
