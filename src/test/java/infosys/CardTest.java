package infosys;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import infosys.game.card.Card;

public class CardTest {
	private Card card = null;

	@Test
	public void constructor() {
		card = new Card(1, 0);

		assertEquals(1, card.getNumber());
		assertEquals("club", card.getSuitName());
	}

	@Test
	public void getNumber() {
		card = new Card(1, 0);

		assertEquals(1, card.getNumber());
	}

	@Test
	public void isBigger() {
		card = new Card(1, 0);
		Card card2 = new Card(2, 0);
		Card card3 = new Card(2, 0);
		Card card4 = new Card(2, 1);
		Card card5 = new Card(3, 0);

		assertEquals(true, card3.isBigger(card));
		assertEquals(false, card3.isBigger(card2));
		assertEquals(false, card3.isBigger(card4));
		assertEquals(false, card3.isBigger(card5));
	}

	@Test
	public void getSuitName() {
		card = new Card(1, 0);

		assertEquals("club", card.getSuitName());

		card = new Card(1, 1);

		assertEquals("diamond", card.getSuitName());

		card = new Card(1, 2);

		assertEquals("heart", card.getSuitName());

		card = new Card(1, 3);

		assertEquals("spade", card.getSuitName());
	}
}
