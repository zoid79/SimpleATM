import static org.junit.jupiter.api.Assertions.*;

import org.example.bank.Bank;
import org.example.main.Card;
import org.example.bank.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {
	private Bank bank;
	private Card card;
	private UserAccount account;

	@BeforeEach
	void setUp() {
		bank = new Bank();
		card = new Card("123456789");
		account = new UserAccount(1234, 1000);
		bank.addAccount(card, account);
	}

	@Test
	void testValidatePin() {
		assertTrue(bank.validatePin(card, 1234));
		assertFalse(bank.validatePin(card, 1111));
	}

	@Test
	void testGetBalance() {
		assertEquals(1000, bank.getBalance(card));
	}

	@Test
	void testDeposit() {
		bank.deposit(card, 500);
		assertEquals(1500, bank.getBalance(card));
	}

	@Test
	void testWithdraw() {
		assertTrue(bank.withdraw(card, 200));
		assertEquals(800, bank.getBalance(card));
		assertFalse(bank.withdraw(card, 2000));
	}
}
