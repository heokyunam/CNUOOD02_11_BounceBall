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
			return caseRectangle(ball, gameObj);
		else if(gameObj instanceof Portal)
			return caseRectangle(ball, gameObj);
		else
			return false;		
	}
	private boolean caseRectangle(Ball ball, GameObject obj) {
		int ballCenterX = ball.getX() + ball.getWidth()/2;
		int ballCenterY = ball.getY() + ball.getHeight()/2;
		int objCenterX = obj.getX() + obj.getWidth()/2;
		int objCenterY = obj.getY() + obj.getHeight()/2;
		int case1 = obj.getHeight() / obj.getWidth() * (ball.getX() - objCenterX) + objCenterY;
		int case2 = -obj.getHeight() / obj.getWidth() * (ball.getX() - objCenterX) + objCenterY;
		
		if(ball.getY() > case1){
			if(ball.getY() > case2){//up;
				if(ball.getRadius() > Math.abs(ballCenterX-objCenterX))
					if(ball.getRadius() > Math.abs(ballCenterY-objCenterY)){
						ball.up();
						return true;
					}
			}
			else{//left
				if(ball.getRadius() > Math.abs(ballCenterX-objCenterX))
					if(ball.getRadius() > Math.abs(ballCenterY-objCenterY)){
						ball.left();
						return true;
					}
			}
		}
		else{
			if(ball.getY() > case2){//right
				if(ball.getRadius() > Math.abs(ballCenterX-objCenterX))
					if(ball.getRadius() > Math.abs(ballCenterY-objCenterY)){
						ball.up();
						return true;
					}
			}
			else{//down
				if(ball.getRadius() > Math.abs(ballCenterX-objCenterX))
					if(ball.getRadius() > Math.abs(ballCenterY-objCenterY)){
						ball.down();
						return true;
					}
			}
		}
		ball.nothing();
		return false;
	}
	//obj1��obj2��踰붿쐞���랁븯�붿�
	
	private boolean caseNeedle(Ball ball, GameObject obj) {
		int ballCenterX = ball.getX() + ball.getWidth()/2;
		int ballCenterY = ball.getY() + ball.getHeight()/2;
		int objCenterX = obj.getX() + obj.getWidth()/2;
		int objCenterY = obj.getY() + obj.getHeight()/2;
		
		if(ball.getRadius() > Math.abs(ballCenterX - objCenterX))
			if(ball.getRadius() > Math.abs(Math.abs(ballCenterY - objCenterY) - Math.abs(ballCenterX - objCenterX)))
				return true;
		return false;
	}
}
