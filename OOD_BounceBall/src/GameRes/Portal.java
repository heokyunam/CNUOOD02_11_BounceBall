package GameRes;

import java.awt.Color;
import java.awt.Graphics;

import GameBase.GameManager;

public class Portal extends GameObject {
	private final Color c = Color.blue;
	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void collisionCheck(Ball ball) {
		GameManager g = GameManager.getInstance();
		g.next();		
	}

}
