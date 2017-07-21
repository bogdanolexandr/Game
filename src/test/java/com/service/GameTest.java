package com.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {

	private Game game = new Game(1, 15);

	@Test
	public void testCreateGame() {
		int expectedMin = 1;
		int expectedMax = 15;
		assertEquals(expectedMin, game.getMinVal());
		assertEquals(expectedMax, game.getMaxVal());
	}

	@Test
	public void testGuessWrongInput() {
		assertEquals(false, game.guess(16));
		assertEquals(false, game.guess(0));
	}

}
