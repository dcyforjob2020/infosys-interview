package infosys.game.card;

import java.util.Random;
import java.util.Vector;

public class Player {
	private Vector<Card> vCard = new Vector<Card>();
	private int win = 0;
	private String name = "";

	/**
	 * constructor
	 * 
	 * @param name name of the player
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * player draws the card to his hand
	 * 
	 * @param card the card player drawed
	 */
	public void drawCard(Card card) {
		vCard.add(card);
	}

	/**
	 * player plays the card to his hand
	 * 
	 * @return the card the player played
	 */
	public Card playCard() {
		Random random = new Random();
		int cardNum = random.nextInt(vCard.size());// the card that is played

		Card card = vCard.get(cardNum);
		vCard.remove(cardNum);

		return card;
	}

	/**
	 * Does the player have cards in his/her hand
	 * 
	 * @return does the player have cards in his/her hand
	 */
	public boolean haveCard() {
		return !vCard.isEmpty();
	}

	/**
	 * How many rounds does the player win
	 * 
	 * @return rounds the player win
	 */
	public int getWin() {
		return win;
	}

	/**
	 * add 1 round that the player wins
	 */
	public void addWin() {
		this.win++;
	}

	/**
	 * Get players name
	 * 
	 * @return players name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set players name
	 * 
	 * @param name the name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
}
