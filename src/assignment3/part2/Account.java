package assignment3.part2;

public class Account {

    private static int accountCount;
    private double balance;
    private int id;

    //Constructors
    public Account() {
        id = ++accountCount;
    }
    public Account(double startingBalance) {
        this();
        this.balance = startingBalance;
    }

    public boolean withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void deposit(double amount) {
         balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }
}
