package com.util;

import java.util.Scanner;

public class Reader {

	private Scanner scanner = new Scanner(System.in);

	public int readNumber() {
		String result = scanner.nextLine();
		int numberResult = -1;
		try {
			numberResult = Integer.valueOf(result);
		} catch (Exception e) {
		
		}
		return numberResult;
	}

}
