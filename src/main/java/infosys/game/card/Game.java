package infosys.game.card;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class Game {
	private Vector<Card> vCards = new Vector<Card>();// all cards in this game
	private Vector<Player> vPlayers = new Vector<Player>();// all players in this game
	private Dealer dealer = new Dealer();// dealer that deals the card
	private StringBuffer sbGameRecord = new StringBuffer();// record of the game

	public void joinGame(Player p) {
		vPlayers.add(p);
	}

	private void createDeckCard() {
		this.vCards = new Vector<Card>();

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				vCards.add(new Card(j, i));
			}
		}
	}

	private void dealCard() {
		dealer.dispatchCard(vCards, vPlayers);
	}

	private boolean haveNextRound() {
		for (int i = 0; i < vPlayers.size(); i++) {
			Player iPlayer = vPlayers.get(i);

			if (!iPlayer.haveCard()) {
				return false;
			}
		}

		return true;
	}

	private void recordRoundDraw(Player player, Card card) {
		recordRoundDraw(player.getName(), card.getSuitName(), card.getNumber());
	}

	private void recordRoundDraw(String name, String suitName, int cardNumber) {
		sbGameRecord.append(name).append(" draws ").append(suitName).append("\t").append(cardNumber).append("\r\n");
	}

	private void recordRoundWinner(Player player) {
		recordRoundWinner(player.getName());
	}

	private void recordRoundWinner(String name) {
		sbGameRecord.append("\r\n").append(name).append(" wins the round ").append("\r\n\r\n");
	}

	private void round() {
		Player winner = vPlayers.get(0);// the player who wins the round
		Card winCard = winner.playCard();// the card which wins the round

		recordRoundDraw(winner, winCard);

		for (int i = 1; i < vPlayers.size(); i++) {
			Player iPlayer = vPlayers.get(i);// the player who plays card
			Card iCard = iPlayer.playCard();

			if (iCard.isBigger(winCard)) {
				// the card of the player plays bigger card than the current winner
				winner = iPlayer;
				winCard = iCard;
			}

			recordRoundDraw(iPlayer, iCard);
		}

		winner.addWin();

		recordRoundWinner(winner);
	}

	private HashSet<Player> getWinner() {
		HashSet<Player> hsWinner = new HashSet<Player>();// the players who wins the game
		Player firstPlayer = vPlayers.get(0); // the first player

		hsWinner.add(firstPlayer);

		int maxWinRound = firstPlayer.getWin();// the rounds that the winner wins

		for (int i = 1; i < vPlayers.size(); i++) {
			Player iPlayer = vPlayers.get(i);// the player who plays card
			int iWinRound = iPlayer.getWin();// the total round that the player wins

			if (iWinRound > maxWinRound) {
				// win the most rounds
				hsWinner.clear();

				hsWinner.add(iPlayer);

				maxWinRound = iWinRound;
			} else if (iWinRound == maxWinRound) {
				// win the same rounds as the winner before
				hsWinner.add(iPlayer);
			}
		}

		return hsWinner;
	}

	public void start(int playerNum) {
		if (playerNum < 1) {
			// no player end game
			return;
		}

		for (int i = 0; i < playerNum; i++) {
			joinGame(new Player("Player" + (i + 1)));
		}

		createDeckCard();
		dealCard();

		while (haveNextRound()) {
			round();
		}

		System.out.print(sbGameRecord.toString());

		StringBuffer sbGameWinner = new StringBuffer();// message of the winner of the game

		sbGameWinner.append("the winner of the game is ");

		HashSet<Player> winners = getWinner();

		for (Iterator<Player> iterator = getWinner().iterator(); iterator.hasNext();) {
			Player iPlayer = iterator.next();

			sbGameWinner.append(iPlayer.getName()).append(", ");
		}

		if (!winners.isEmpty()) {
			sbGameWinner.setLength(sbGameWinner.length() - 2);
		}

		System.out.println(sbGameWinner.toString());
	}
}
