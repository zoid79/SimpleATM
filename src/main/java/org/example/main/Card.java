package org.example.main;

public class Card {
	private String cardNumber;

	public Card(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	@Override
	public int hashCode() {
		return cardNumber.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Card card = (Card) obj;
		return cardNumber.equals(card.cardNumber);
	}
}
