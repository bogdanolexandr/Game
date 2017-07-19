package com;

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
		model.addAttribute("min", game.getMinVal());
		model.addAttribute("max", game.getMaxVal());
		int suspect;
		
		while (true) {
			suspect = reader.readNumber(model);
			if (game.guess(suspect)) {
				model.addAttribute("result", game.getStatistics());
				view.showResult(model);
				break;
			}
		}
	}

}
