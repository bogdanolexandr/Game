package com;

import java.util.Scanner;

public class Reader {
	private View view;
	private Scanner scanner = new Scanner(System.in);

	public Reader(View view) {
		this.view = view;
	}

	public int readNumber(Model model) {
		view.showInvitation(model);

		String result = scanner.nextLine();

		int numberResult = -1;

		try {
			numberResult = Integer.valueOf(result);
		} catch (Exception e) {
			view.showError();
		}

		return numberResult;
	}

}
