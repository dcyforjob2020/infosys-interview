package infosys.game.card;

import java.util.Random;
import java.util.Vector;

public class Dealer {
	public void dispatchCard(Vector<Card> vCards, Vector<Player> vPlayers) {
		int amountCard = vCards.size();// amount of cards
		int amountPlayers = vPlayers.size();// amount of players

		if (amountPlayers == 0) {
			// no players
			return;
		}

		Random random = new Random();

		for (int i = 0; i < amountCard; i++) {
			Player iPlayer = vPlayers.get(i % amountPlayers);// dispatch to the player
			int iCardNum = random.nextInt(amountCard - i);// the card that dispatch to the player
			Card iCard = vCards.get(iCardNum);// the card that dispatch to the player

			vCards.remove(iCardNum);

			iPlayer.drawCard(iCard);
		}
	}
}
