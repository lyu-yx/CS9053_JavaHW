package assignment3.part2;

import java.util.Scanner;

public class Bank {

	public static final int NUM_ACCOUNTS = 5;
    private Account[] accounts = new Account[NUM_ACCOUNTS];

    //constructor
	public Bank() {
        // create NUM_ACCOUNTS accounts in an array
        // with each account having a starting balance
        // of $1000
	    for (int i = 0; i < NUM_ACCOUNTS; i++) {
	        accounts[i] = new Account(1000);
        }
	}

	public Account getAccountById(int id) {
		// this should take an id, search
		// through the array of accounts until
		// it finds the account matching the id
		// and returns it, returning null if
		// it is not found
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        System.out.println("This id doesn't exist.");
        return null;
	}

	public int numAccounts() {
		// returns the number of accounts:
		// ie, the length of the array accounts
		return accounts.length;
	}



    public Account[] getAllAccounts() {
	    return accounts;
    }



	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Bank bank = new Bank();
		for (;;) {
			System.out.println("Accounts:");
			Account[] accounts = bank.getAllAccounts();
			for (int i = 0; i < accounts.length; i++) {
				System.out.println("Account " + accounts[i].getId() +
						": $" + accounts[i].getBalance());
			}
			System.out.print("Enter source account: ");
			int srcAccountId = in.nextInt();
			Account srcAccount = bank.getAccountById(srcAccountId);
			if (srcAccount == null) {
				System.out.println("no such account id. Starting over");
				continue;
			}
			System.out.print("Enter destination account: ");
			int destAccountId = in.nextInt();
			Account destAccount = bank.getAccountById(destAccountId);
			if (destAccount == null) {
				System.out.println("no such account id. Starting over");
				continue;
			}
			System.out.print("Enter transfer amount: ");
			double transferAmount = in.nextDouble();
			if (transferAmount < 0) {
				System.out.println("amount should > 0");
				continue;
			}

			boolean withdrawlResult = srcAccount.withdraw(transferAmount);
			if (withdrawlResult) {
				destAccount.deposit(transferAmount);
			} else {
				System.out.println("cannot withdraw more money than " + srcAccount.getBalance() + " in this account");
			}
		}
	}


}
