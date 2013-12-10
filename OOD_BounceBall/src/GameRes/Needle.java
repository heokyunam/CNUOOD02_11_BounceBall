package GameRes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import GameBase.GameManager;

public class Needle extends GameObject{
	private final Color c = Color.red;
	private Polygon p;
	public Needle() {
		this(0, 0, 0, 0);
	}
	public Needle(int x, int y, int height, int width) {
		super(x, y, height, width);
	}
	@Override
	public void draw(Graphics g) {
		if(p == null) {
			p = new Polygon();
			p.addPoint(x, y + height);
			p.addPoint(x + width/2, y);
			p.addPoint(x + width, y + height);			
		}
		g.setColor(c);
		g.fillPolygon(p);
	}

	@Override
	public void collisionCheck(Ball ball) {
		GameManager gm = GameManager.getInstance();
		gm.first();		
	}

}
