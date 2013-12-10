package GameBase;

import java.awt.Graphics;
import java.util.ArrayList;

import GameRes.Ball;
import GameRes.GameObject;

public class ResourceManager {
	private static ResourceManager manager;
	private Parsing parsing;
	private ArrayList<GameObject> objects;
	private Ball ball;
	private Collision collision;

	private ResourceManager() {
		collision = Collision.getInstance();
	}
	public static ResourceManager getInstance() {
		if(manager == null) manager = new ResourceManager();
		return manager;
	}
	public void draw(Graphics g) {
		ball.draw(g);
		for(int i = 0; i < objects.size(); i++)
			objects.get(i).draw(g);
	}
	public void update() {
		ball.update();
	}
	public void collision() {
		collision.check(ball, objects);
	}
	public void StageParsing(int STAGE) {
		try {
			parsing = new Parsing(STAGE + ".hnl");

			objects = parsing.getGameObjects();
			ball = (Ball) objects.remove(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
