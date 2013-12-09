package Main;

import GameBase.GameManager;

public class GameMain {

	public static void main(String[] args) {
		GameManager gameManager = GameManager.getInstance();
		gameManager.start();
	}
}
