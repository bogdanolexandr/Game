package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.entity.Statistics;
import com.exception.WrongRangeException;

public class Game {

	private final int RAND_MAX = 100;
	private final int RAND_MIN = 0;
	private final int AVAILABLE_DIFFERENCE = 2;
	private int answer;
	private int minVal;
	private int maxVal;
	private List<Integer> usersAnswers = new ArrayList<>();
	private Random random = new Random();
	private boolean isCorrectEnter;
	private String error;

	public Game() {
		rand();
	}

	public Game(int min, int max) {
		rand(min, max);
	}

	public boolean guess(int suspect) {
		boolean correctnessOfEnter = verify(suspect);
		if (correctnessOfEnter) {
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
		return isCorrectEnter;
	}

	public String getError() {
		return error;
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

	private boolean verify(int suspect) {
		if (suspect == -1) {
			isCorrectEnter = false;
			this.error = " you should enter a number";
			return false;
		}
		if ((suspect < minVal) || (suspect > maxVal)) {
			isCorrectEnter = false;
			this.error = " your number is out of range";
			return false;
		}
		isCorrectEnter = true;
		return true;
	}

	private boolean isRightAnswer(int suspect) {
		return (suspect == answer) ? true : false;
	}

	private int rand(int min, int max) {
		if ((min > RAND_MIN) && (max < RAND_MAX)) {
			if ((max - min) >= AVAILABLE_DIFFERENCE) {
				minVal = min;
				maxVal = max;
			} else {
				throw new WrongRangeException();
			}
		} else {
			throw new WrongRangeException();
		}
		answer = generateRandomNumber(min, max);
		return answer;
	}

	private int rand() {
		minVal = RAND_MIN + 1;
		maxVal = RAND_MAX - 1;
		answer = generateRandomNumber(minVal, maxVal);
		return answer;
	}

	private int generateRandomNumber(int min, int max) {
		return random.nextInt(maxVal - minVal) + minVal;
	}

}
