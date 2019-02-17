package com.tesch.Game;

import com.tesch.UserInterface.UI;

public class Game {

	public static void main(String[] args) {
		try {
			UI window = new UI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
