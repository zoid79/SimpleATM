
import static org.junit.jupiter.api.Assertions.*;

import org.example.atm.ATMController;
import org.example.bank.Bank;
import org.example.main.Card;
import org.example.bank.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ATMControllerTest {
	private Bank bank;
	private ATMController atmController;
	private Card card;
	private UserAccount account;

	@BeforeEach
	void setUp() {
		bank = new Bank();
		atmController = new ATMController(bank);
		card = new Card("123456789");
		account = new UserAccount(1234, 1000);
		bank.addAccount(card, account);
	}

	@Test
	void testInsertCard() {
		assertTrue(atmController.insertCard(card, 1234));
		assertFalse(atmController.insertCard(card, 1111));
	}

	@Test
	void testCheckBalance() {
		atmController.insertCard(card, 1234);
		assertEquals(1000, atmController.checkBalance(card));
	}

	@Test
	void testDeposit() {
		atmController.insertCard(card, 1234);
		atmController.deposit(card, 500);
		assertEquals(1500, atmController.checkBalance(card));
	}

	@Test
	void testWithdraw() {
		atmController.insertCard(card, 1234);
		assertTrue(atmController.withdraw(card, 200));
		assertEquals(800, atmController.checkBalance(card));
		assertFalse(atmController.withdraw(card, 2000));
	}
}
