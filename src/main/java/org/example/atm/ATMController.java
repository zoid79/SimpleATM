package org.example.atm;

import org.example.bank.Bank;
import org.example.main.Card;

public class ATMController {

	private ATMService atmService;

	public ATMController(Bank bank) {
		this.atmService = new ATMService(bank);
	}

	public boolean insertCard(Card card, int pin) {
		return atmService.validatePin(card, pin);
	}

	public int checkBalance(Card card) {
		return atmService.getBalance(card);
	}

	public boolean deposit(Card card, int amount) {
		return atmService.deposit(card, amount);
	}

	public boolean withdraw(Card card, int amount) {
		return atmService.withdraw(card, amount);
	}
}
