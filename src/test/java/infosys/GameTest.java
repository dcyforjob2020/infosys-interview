package infosys;

import org.junit.Before;
import org.junit.Test;

import infosys.game.card.Game;

public class GameTest {
	Game game = null;

	@Before
	public void setup() {
		game = new Game();
	}

	@Test
	public void start() {
		game.start(4);
	}
}
