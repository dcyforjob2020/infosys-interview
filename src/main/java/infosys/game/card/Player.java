package infosys.game.card;

import java.util.Random;
import java.util.Vector;

public class Player {
	private Vector<Card> vCard = new Vector<Card>();
	private int win = 0;
	private String name = "";

	public Player(String name) {
		this.name = name;
	}

	public void drawCard(Card card) {
		vCard.add(card);
	}

	public Card playCard() {
		Random random = new Random();
		int cardNum = random.nextInt(vCard.size());// the card that is played

		Card card = vCard.get(cardNum);
		vCard.remove(cardNum);

		return card;
	}

	public boolean haveCard() {
		return !vCard.isEmpty();
	}

	public int getWin() {
		return win;
	}

	public void addWin() {
		this.win++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
