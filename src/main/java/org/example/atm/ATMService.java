package org.example.atm;

import org.example.bank.Bank;
import org.example.main.Card;

public class ATMService {
	private Bank bank;
	private ATMRepository atmRepository;

	public ATMService(Bank bank) {
		this.bank = bank;
		this.atmRepository = new ATMRepository();
	}

	public boolean validatePin(Card card, int pin) {
		return bank.validatePin(card, pin);
	}

	public int getBalance(Card card) {
		return bank.getBalance(card);
	}

	public boolean deposit(Card card, int amount) {
		boolean isUpdateCashSuccessful = false;
		boolean isDepositSuccessful = bank.deposit(card, amount);
		if (isDepositSuccessful) {
			isUpdateCashSuccessful = updateCash(amount);
			if (!isUpdateCashSuccessful) {
				bank.withdraw(card, amount);
			}
		}
		return isDepositSuccessful && isUpdateCashSuccessful;
	}

	public boolean withdraw(Card card, int amount) {
		if (checkCash(amount)) {
			boolean isWithdrawSuccessful = bank.withdraw(card, amount);
			if (isWithdrawSuccessful) {
				boolean isUpdateCashSuccessful = updateCash(-amount);
				if (!isUpdateCashSuccessful) {
					bank.deposit(card, amount);
					return false;
				}
				return true;
			}
		}
		return false;
	}

	private boolean updateCash(int amount) {
		return atmRepository.updateCash(amount);
	}

	public boolean checkCash(int amount) {
		int remainCash = atmRepository.getCurrentBalanceFromFile();
		if (remainCash == -1) {
			System.out.println("Failed to retrieve the balance information.");
			return false;
		}
		return remainCash - amount >= 0;
	}
}
