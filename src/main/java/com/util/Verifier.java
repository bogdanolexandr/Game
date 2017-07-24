package com.util;

public class Verifier {

	private String error = "no error";
	private boolean isCorrectEnter;

	public boolean verifyRange(int min, int max, int minExtremum, int maxExtremum, int availableDifference) {
		if ((min > minExtremum) && (max < maxExtremum)) {
			if ((max - min) >= availableDifference) {
				return true;
			}
		}
		return false;
	}

	public boolean verifyEnter(int suspect, int min, int max) {
		if (suspect == -1) {
			isCorrectEnter = false;
			this.error = " you should enter a number";
			return false;
		}
		if ((suspect < min) || (suspect > max)) {
			isCorrectEnter = false;
			this.error = " your number is out of range";
			return false;
		}
		isCorrectEnter = true;
		return true;
	}

	public boolean isCorrectEnter() {
		return isCorrectEnter;
	}

	public String getError() {
		return error;
	}
	
}
