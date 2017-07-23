package com.service;

import static org.junit.Assert.*;
import org.junit.Test;

import com.exception.WrongRangeException;

public class GameTest {

	private Game game = new Game(1, 15);

	@Test
	public void testCreateGame() {
		int expectedMin = 1;
		int expectedMax = 15;
		assertEquals(expectedMin, game.getMinVal());
		assertEquals(expectedMax, game.getMaxVal());
	}

	@Test(expected = WrongRangeException.class)
	public void testCreateGameWrongMinParam() {
		Game game = new Game(0,15);
	}
	
	@Test(expected = WrongRangeException.class)
	public void testCreateGameWrongMaxParam() {
		Game game = new Game(1,100);
	}
	
	@Test(expected = WrongRangeException.class)
	public void testCreateGameWrongBothParams() {
		Game game = new Game(0,100);
	}
	
	@Test
	public void testGuessWrongMinRangeInput() {
		game.guess(0);
		assertEquals(false, game.isCorrectEnter());
	}
	
	@Test
	public void testGuessWrongMaxRangeInput() {
		game.guess(16);
		assertEquals(false, game.isCorrectEnter());
	}
	
	@Test
	public void testGuessRightParam() {
		game.guess(5);
		assertEquals(true, game.isCorrectEnter());
	}

}
