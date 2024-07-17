package org.example.main;

import org.example.atm.ATMController;
import org.example.bank.Bank;
import org.example.bank.UserAccount;

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank();
		Card card1 = new Card("123456789");
		UserAccount account1 = new UserAccount(1234, 1000);
		bank.addAccount(card1, account1);

		ATMController atmController = new ATMController(bank);
		if (atmController.insertCard(card1, 1234)) {
			System.out.println("Balance: " + atmController.checkBalance(card1));
			atmController.deposit(card1, 500);
			System.out.println("Balance after deposit: " + atmController.checkBalance(card1));
			if (atmController.withdraw(card1, 200)) {
				System.out.println("Balance after withdrawal: " + atmController.checkBalance(card1));
			} else {
				System.out.println("Insufficient funds for withdrawal.");
			}
		} else {
			System.out.println("Invalid PIN.");
		}
	}
}
