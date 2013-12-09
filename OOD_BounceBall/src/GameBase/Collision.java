package GameBase;

import java.util.ArrayList;

import GameRes.Ball;
import GameRes.FadeWall;
import GameRes.GameObject;
import GameRes.Land;
import GameRes.Needle;
import GameRes.Portal;
import GameRes.Schanze;

public class Collision {
	private static Collision collision;
	public enum direction {up, left, right, down, not}
	private direction Direction = direction.not;
	
	public static Collision getInstance() {
		if(collision == null) collision = new Collision();
		return collision;
	}
	public direction getCollisionDirection() {
		return Direction;
	}
	public void check(Ball ball, GameObject[] gameObjs) {
		for(int i = 0; i < gameObjs.length; i++)
			if(isCollided(ball, gameObjs[i])) gameObjs[i].collisionCheck(ball);
	}
	public void check(Ball ball, ArrayList<GameObject> gameObjs) {
		for(int i = 0; i < gameObjs.size(); i++)
			if(isCollided(ball, gameObjs.get(i))) gameObjs.get(i).collisionCheck(ball);
	}
	private boolean isCollided(Ball ball, GameObject gameObj) {
		if(gameObj instanceof Land)
			return caseRectangle(ball, gameObj);
		else if(gameObj instanceof FadeWall)
			return caseRectangle(ball, gameObj);
		else if(gameObj instanceof Needle)
			return caseNeedle(ball, gameObj);
		else if(gameObj instanceof Schanze)
			return caseSchanze(ball, gameObj);
		else if(gameObj instanceof Portal)
			return caseRectangle(ball, gameObj);
		else
			return false;		
	}
	private boolean caseRectangle(Ball ball, GameObject obj) {
		if(isInArea(ball, obj, true)) {
			if(ap(ball, false) == obj.getY()) {
				Direction = direction.down;
				return true;
			}
			if(ball.getY() == ap(obj, false)) {
				Direction = direction.up;
				return true;
			}
		}
		if(isInArea(ball, obj, false)) {
			if(ap(ball, true) == obj.getX()) {
				Direction = direction.right;
				return true;
			}
			if(ball.getX() == ap(obj, true)) {
				Direction = direction.left;
				return true;
			}
		}
		return false;
	}
	//obj1��obj2��踰붿쐞���랁븯�붿�
	private boolean isInArea(GameObject obj1, GameObject obj2, boolean isX) {
		if(isX) {
			if(obj2.getX() <= obj1.getX() && ap(obj1, true) <= ap(obj2, true)) {
				return true;
			}
			else return false;
		}
		else {
			if(obj2.getY() <= obj1.getY() && ap(obj1, false) <= ap(obj2, false)) {
				return true;
			}
			else return false;
		}
	}
	private int ap(GameObject obj, boolean isX) {
		if(isX) {
			return obj.getX() + obj.getWidth();
		}
		else {
			return obj.getY() + obj.getHeight();
		}
	}
	private boolean caseSchanze(Ball ball, GameObject obj) {
		return false;
	}
	private boolean caseNeedle(Ball ball, GameObject obj) {
		return false;
	}
}
