package infosys;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.Test;

import infosys.game.card.Card;
import infosys.game.card.Dealer;
import infosys.game.card.Player;

public class DealerTest {
	@Test
	public void dispatchCard() {
		Vector<Card> vCards = new Vector<Card>();

		vCards.add(new Card(1, 0));
		vCards.add(new Card(1, 0));

		Vector<Player> vPlayers = new Vector<Player>();

		vPlayers.add(new Player("test1"));
		vPlayers.add(new Player("test2"));

		Dealer dealer = new Dealer();

		dealer.dispatchCard(vCards, vPlayers);

		for (int i = 0; i < vPlayers.size(); i++) {
			Player iPlayer = vPlayers.get(i);

			assertEquals(true, iPlayer.haveCard());
		}
	}
}
