package org.example.bank;

import java.util.HashMap;
import java.util.Map;

import org.example.main.Card;

public class Bank {
	private Map<Card, UserAccount> accounts;

	public Bank() {
		accounts = new HashMap<>();
	}

	public void addAccount(Card card, UserAccount account) {
		accounts.put(card, account);
	}

	public boolean validatePin(Card card, int pin) {
		UserAccount account = accounts.get(card);
		return (account != null && account.getPin() == pin);
	}

	public int getBalance(Card card) {
		UserAccount account = accounts.get(card);
		if(account != null) return account.getBalance();
		return 0;
	}

	public boolean deposit(Card card, int amount) {
		UserAccount account = accounts.get(card);
		if (account != null) {
			account.deposit(amount);
		}
		return true;
	}

	public boolean withdraw(Card card, int amount) {
		UserAccount account = accounts.get(card);
		return account != null && account.withdraw(amount);
	}
}
