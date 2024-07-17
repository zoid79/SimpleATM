package org.example.bank;

public class UserAccount {
	private int pin;
	private int balance;

	public UserAccount(int pin, int initialBalance) {
		this.pin = pin;
		this.balance = initialBalance;
	}

	public int getPin() {
		return pin;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public boolean withdraw(int amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		}
		return false;
	}
}
