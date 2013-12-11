package GameRes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Schanze extends GameObject{
	private Polygon p;
	private final Color c = Color.black;
	@Override
	public void draw(Graphics g) {
		if(p == null) {
			p.addPoint(x, y);
			p.addPoint(x + width, y);
		}
		g.setColor(c);
		g.drawPolygon(p);
	}

	@Override
	public void collisionCheck(Ball ball) {
		
	}

}
