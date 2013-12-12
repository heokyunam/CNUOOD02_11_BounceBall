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
	public void clear() {
		Graphics g = GUI.getInstance().getCanvasGraphics();
		g.clearRect(ball.getX()-5, ball.getY()-5, ball.getRadius() * 2 + 10, ball.getRadius() * 2 + 10);
	}
	public void clear(GameObject obj) {
		Graphics g = GUI.getInstance().getCanvasGraphics();
		g.clearRect(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight());		
	}
	public void allClear() {
		Graphics g = GUI.getInstance().getCanvasGraphics();
		g.clearRect(0, 0, 640, 480);	
		
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
