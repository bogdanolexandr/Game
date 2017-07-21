package com.main;

import com.controller.Controller;
import com.service.Game;
import com.util.Reader;
import com.view.View;

public class Main {

	public static void main(String[] args) {

		View view = new View();
		Reader reader = new Reader(view);
		Game game = new Game(1,5);
		Controller controller = new Controller(view, reader,game);
		controller.doProcess();

	}

}

