package com.sample.designpattern;

/**
 * Builder Design pattern 
 * @author Thangaprabhu
 *
 */
class CreditCard {
	private String firstName;
	private String lastName;

	private CreditCard() {
	}

	static class CreditCardBuilder {
		private CreditCard card = new CreditCard();

		public CreditCardBuilder setFirstName(String firstName) {
			card.firstName = firstName;
			return this;
		}

		public CreditCardBuilder setLastName(String lastName) {
			card.lastName = lastName;
			return this;
		}

		public CreditCard build() {
			return card;
		}

	}
}

public class CreditCardBuilderRunner {

	public static void main(String[] args) {

		CreditCard card = new CreditCard.CreditCardBuilder().setFirstName("f")
				.setLastName("l").build();

	}

}
