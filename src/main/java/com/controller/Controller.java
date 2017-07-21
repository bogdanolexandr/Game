package com.controller;

import com.service.Game;
import com.util.Model;
import com.util.Reader;
import com.view.View;

public class Controller {

	private View view;
	private Reader reader;
	private Game game;

	public Controller(View view, Reader reader, Game game) {
		this.view = view;
		this.reader = reader;
		this.game = game;
	}

	public void doProcess() {
		Model model = new Model();
		int suspect;
		boolean isWinner;
		while (true) {
			model.addAttribute("min", game.getMinVal());
			model.addAttribute("max", game.getMaxVal());
			view.showInvitation(model);
			suspect = reader.readNumber();
			isWinner = game.guess(suspect);
			if(game.isCorrectEnter()) {
				if (isWinner) {
					model.addAttribute("result", game.getStatistics());
					view.showResult(model);
					break;
				}
			}else {
				model.addAttribute("error", game.getError());
				view.showRangeError(model);
			}
			
		}
	}

}
