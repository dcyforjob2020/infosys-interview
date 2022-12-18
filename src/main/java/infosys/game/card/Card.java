package infosys.game.card;

public class Card {
	private int number;
	private int suits;

	/**
	 * Card class constructor
	 * 
	 * @param number the number of the card
	 * @param suits  the suit of the card
	 */
	public Card(int number, int suits) {
		this.number = number;
		this.suits = suits;
	}

	/**
	 * get the number of the card
	 * 
	 * @return the number of the card
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * get the suit of the card
	 * 
	 * @return the suit of the card
	 */
	private int getSuits() {
		return suits;
	}

	/**
	 * compare the card is bigger than input card
	 * 
	 * @param card the card to be compared
	 * @return is the card bigger than input card
	 */
	public boolean isBigger(Card card) {
		if (this.number > card.getNumber()) {
			// number is bigger
			return true;
		} else if (this.number == card.getNumber() && this.suits > card.getSuits()) {
			// same number but suit is bigger
			return true;
		}

		return false;
	}

	/**
	 * get the english of suit of the card
	 * 
	 * @return
	 */
	public String getSuitName() {
		String suitName = "";// the english of suit

		if (suits == 0) {
			suitName = "club";
		} else if (suits == 1) {
			suitName = "diamond";
		} else if (suits == 2) {
			suitName = "heart";
		} else if (suits == 3) {
			suitName = "spade";
		}

		return suitName;
	}
}
