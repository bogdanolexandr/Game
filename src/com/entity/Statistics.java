package com.entity;

import java.util.List;

public class Statistics {

	private List<Integer> attempts;
	private int answer;
	private int maxValue;
	private int minValue;

	public Statistics(List<Integer> attempts, int suspect, int maxValue, int minValue) {
		this.attempts = attempts;
		this.answer = suspect;
		this.maxValue = maxValue;
		this.minValue = minValue;
	}

	public List<Integer> getAttempts() {
		return attempts;
	}

	public void setAttempts(List<Integer> attempts) {
		this.attempts = attempts;
	}

	public int getSuspect() {
		return answer;
	}

	public void setSuspect(int suspect) {
		this.answer = suspect;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

}
