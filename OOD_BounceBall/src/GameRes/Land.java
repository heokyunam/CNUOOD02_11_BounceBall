package GameRes;

import java.awt.Graphics;

public class Land extends GameObject{

	@Override
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}

	@Override
	public void collisionCheck(Ball ball) {
		// TODO Auto-generated method stub
		
	}

}
