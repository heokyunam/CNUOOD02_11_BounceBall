package GameRes;

import java.awt.Color;
import java.awt.Graphics;

public class FadeWall extends GameObject{
	private final Color c = Color.gray;
	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void collisionCheck(Ball ball) {
		// TODO Auto-generated method stub
		
	}

}
