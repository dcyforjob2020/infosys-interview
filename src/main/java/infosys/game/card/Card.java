package infosys.game.card;

public class Card {
	private int number;
	private int suits;

	public Card(int number, int suits) {
		this.number = number;
		this.suits = suits;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSuits() {
		return suits;
	}

	public void setSuits(int suits) {
		this.suits = suits;
	}

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
