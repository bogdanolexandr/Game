package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.entity.Statistics;
import com.exception.WrongRangeException;
import com.util.Verifier;

public class Game {

	private final int RAND_MAX = 100;
	private final int RAND_MIN = 0;
	private final int AVAILABLE_DIFFERENCE = 2;
	private int answer;
	private int minVal;
	private int maxVal;
	private List<Integer> usersAnswers = new ArrayList<>();
	private Random random = new Random();
	private Verifier verifier = new Verifier();

	public Game() {
		answer = generateRandomNumber(RAND_MIN + 1, RAND_MAX - 1);
	}

	public Game(int min, int max) {
		if (verifier.verifyRange(min, max, RAND_MIN, RAND_MAX, AVAILABLE_DIFFERENCE)) {
			answer = generateRandomNumber(min, max);
			minVal = min;
			maxVal = max;
		} else {
			throw new WrongRangeException();
		}
	}

	public boolean guess(int suspect) {
		boolean isCorrectEnter = verifier.verifyEnter(suspect, minVal, maxVal);
		if (isCorrectEnter) {
			boolean isWinner = isRightAnswer(suspect);
			if (isWinner) {
				return true;
			} else {
				usersAnswers.add(suspect);
				changeRange(suspect);
			}
		}
		return false;
	}

	public Statistics getStatistics() {
		Statistics statistics = new Statistics(usersAnswers, answer, maxVal, minVal);
		return statistics;
	}

	public int getMinVal() {
		return minVal;
	}

	public int getMaxVal() {
		return maxVal;
	}

	public boolean isCorrectEnter() {
		return verifier.isCorrectEnter();
	}

	public String getError() {
		return verifier.getError();
	}

	private void changeRange(int suspect) {
		if (suspect < answer) {
			minVal = suspect;
			minVal++;
		} else {
			maxVal = suspect;
			maxVal--;
		}
	}

	private boolean isRightAnswer(int suspect) {
		return (suspect == answer) ? true : false;
	}

	private int generateRandomNumber(int min, int max) {
		return random.nextInt(max - min) + min;
	}

}
