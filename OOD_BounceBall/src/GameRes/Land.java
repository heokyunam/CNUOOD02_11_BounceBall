package GameRes;

import java.awt.Color;
import java.awt.Graphics;

public class Land extends GameObject{
	private Color color = Color.gray;
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}

	@Override
	public void collisionCheck(Ball ball) {
		// TODO Auto-generated method stub
		
	}
}
