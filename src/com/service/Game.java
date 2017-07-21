package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.entity.Statistics;

public class Game {

	private final int RAND_MAX = 100;
	private int answer;
	private int minVal;
	private int maxVal;
	private List<Integer> usersAnswers = new ArrayList<>();
	private Random random = new Random();

	public Game() {
		rand();
	}

	public Game(int min, int max) {
		rand(min, max);
	}

	public boolean guess(int suspect) {
		
		if(suspect == -1){
			return false;
		}
		usersAnswers.add(suspect);
		if (suspect == answer) {
			return true;
		}
		return false;
	}

	public Statistics getStatistics() {
		int suspect = usersAnswers.get(usersAnswers.size() - 1);
		Statistics statistics = new Statistics(usersAnswers, suspect, maxVal, minVal);
		return statistics;
	}

	public int getMinVal() {
		return minVal;
	}

	public int getMaxVal() {
		return maxVal;
	}

	private int rand(int min, int max) {
		minVal = min;
		maxVal = max;
		answer = random.nextInt(max) + min;
		return answer;
	}

	private int rand() {
		minVal = 0;
		maxVal = RAND_MAX;
		answer = random.nextInt(maxVal);
		return answer;

	}

}
