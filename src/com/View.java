package com;

public class View {

	private final String MIN_VAL = "minimum value";
	private final String MAX_VAL = "maximum value";
	private final String SUSPECT = "you've entered";
	private final String INVITATION = "please enter your number";
	private final String CONGRATULATION = "congratulation! you've guessed the number";
	private final String ERROR = "your input is wrong. you should enter number";
	private final String STORY = "you entered before";

	public void showInvitation(Model model) {
		int min = (int) model.getAttribute("min");
		int max = (int) model.getAttribute("max");
		System.out.println(INVITATION);
		System.out.println(MIN_VAL + " " + min + "   " + MAX_VAL +" "+ max);
	}

	public void showResult(Model model) {
		Statistics attempt = (Statistics) model.getAttribute("result");
		System.out.println(CONGRATULATION);
		System.out.println(SUSPECT + " " + attempt.getSuspect());
		System.out.println(STORY + " " + attempt.getAttempts());

	}

	public void showError(){
		System.out.println(ERROR);
	}
	
}
