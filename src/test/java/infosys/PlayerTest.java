package infosys;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import infosys.game.card.Card;
import infosys.game.card.Player;

public class PlayerTest {
	private Player player = null;

	@Before
	public void setup() {
		player = new Player("test");
	}

	@Test
	public void constructor() {
		assertEquals("test", player.getName());
	}

	@Test
	public void drawCard() {
		Card card = new Card(1, 0);

		player.drawCard(card);

		assertEquals(true, player.haveCard());
	}

	@Test
	public void playCard() {
		Card card = new Card(1, 0);

		player.drawCard(card);

		Card playCard = player.playCard();

		assertEquals(false, card.isBigger(playCard));
	}

	@Test
	public void haveCard() {
		assertEquals(false, player.haveCard());

		Card card = new Card(1, 0);

		player.drawCard(card);

		assertEquals(true, player.haveCard());

		player.playCard();

		assertEquals(false, player.haveCard());
	}

	@Test
	public void getWin() {
		assertEquals(0, player.getWin());
	}

	@Test
	public void addWin() {
		assertEquals(0, player.getWin());

		player.addWin();

		assertEquals(1, player.getWin());
	}

	@Test
	public void getName() {
		assertEquals("test", player.getName());
	}

	@Test
	public void setName() {
		String testName = "test1";

		player.setName(testName);

		assertEquals(testName, player.getName());
	}
}
