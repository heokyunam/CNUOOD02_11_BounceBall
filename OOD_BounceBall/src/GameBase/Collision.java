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
	private boolean isFadeWall = false;
	
	public static Collision getInstance() {
		if(collision == null) collision = new Collision();
		return collision;
	}
	public direction getCollisionDirection() {
		return Direction;
	}
	public void check(Ball ball, GameObject[] gameObjs) {
		for(int i = 0; i < gameObjs.length; i++){
			if(isCollided(ball, gameObjs[i])){
				gameObjs[i].collisionCheck(ball);
				return;
			}
		}
		ball.nothing();
	}
	public void check(Ball ball, ArrayList<GameObject> gameObjs) {
         for(int i = 0; i < gameObjs.size(); i++){
                 if(isCollided(ball, gameObjs.get(i))){
                         gameObjs.get(i).collisionCheck(ball);
                         if(isFadeWall){
                                     ResourceManager.getInstance().clear(gameObjs.get(i));
                                 gameObjs.remove(i);
                                 isFadeWall = false;
                         }
                         ball.nothing();
                         return;
                 }
         }
         ball.nothing();
 }
	
	private boolean isCollided(Ball ball, GameObject gameObj) {
		if(gameObj instanceof Land){
			return caseRectangle(ball, gameObj);
		}			
		else if(gameObj instanceof FadeWall){
			return caseFadeWall(ball, gameObj);
		}
		else if(gameObj instanceof Needle)
			return caseNeedle(ball, gameObj);
		else if(gameObj instanceof Schanze){
			return caseSchanze(ball, gameObj);
		}
		else if(gameObj instanceof Portal){			
			return casePortal(ball, gameObj);
		}
		else
			return false;
	}
	private boolean caseRectangle(Ball ball, GameObject obj) {
		int ballCenterX = ball.getX() + ball.getRadius();
		int ballCenterY = ball.getY() + ball.getRadius();
		int objCenterX = obj.getX() + obj.getWidth()/2;
		int objCenterY = obj.getY() + obj.getHeight()/2;
		double case1 = (((double)obj.getHeight() / obj.getWidth()) * (ballCenterX - objCenterX))+ objCenterY;
		double case2 = -(((double)obj.getHeight() / obj.getWidth()) * (ballCenterX - objCenterX))+ objCenterY;
		
		if(ballCenterY < case1){
			if(ballCenterY < case2){//up;
				if(ball.getRadius()+obj.getWidth()/2 > Math.abs(ballCenterX-objCenterX)){					
					if(ball.getRadius()+ obj.getHeight()/2 > Math.abs(ballCenterY-objCenterY)){
						ball.up();
						return true;
					}
				}
			}
			else{//right
				if(ball.getRadius()+obj.getWidth()/2 > Math.abs(ballCenterX-objCenterX))
					if(ball.getRadius()+ obj.getHeight()/2  > Math.abs(ballCenterY-objCenterY)){
						ball.right();	
						return true;
					}
			}
		}
		else{
			if(ballCenterY < case2){//left
				if(ball.getRadius()+obj.getWidth()/2 > Math.abs(ballCenterX-objCenterX))
					if(ball.getRadius()+ obj.getHeight()/2> Math.abs(ballCenterY-objCenterY)){		
						ball.left();						
						return true;
					}
			}
			else{//down
				if(ball.getRadius()+obj.getWidth()/2  > Math.abs(ballCenterX-objCenterX))
					if(ball.getRadius()+ obj.getHeight()/2 > Math.abs(ballCenterY-objCenterY)){
						ball.down();
						return true;
					}
			}
		}
		return false;
	}
	private boolean caseFadeWall(Ball ball, GameObject obj) {
		int ballCenterX = ball.getX() + ball.getRadius();
		int ballCenterY = ball.getY() + ball.getRadius();
		int objCenterX = obj.getX() + obj.getWidth()/2;
		int objCenterY = obj.getY() + obj.getHeight()/2;
		double case1 = (((double)obj.getHeight() / obj.getWidth()) * (ballCenterX - objCenterX))+ objCenterY;
		double case2 = -(((double)obj.getHeight() / obj.getWidth()) * (ballCenterX - objCenterX))+ objCenterY;
		
		if(ballCenterY < case1){
			if(ballCenterY < case2){//up;
				if(ball.getRadius()+obj.getWidth()/2 > Math.abs(ballCenterX-objCenterX)){					
					if(ball.getRadius()+ obj.getHeight()/2 > Math.abs(ballCenterY-objCenterY)){
						ball.up();
						isFadeWall = true;
						return true;
					}
				}
			}
			else{//right
				if(ball.getRadius()+obj.getWidth()/2 > Math.abs(ballCenterX-objCenterX))
					if(ball.getRadius()+ obj.getHeight()/2  > Math.abs(ballCenterY-objCenterY)){
						ball.right();	
						isFadeWall = true;
						return true;
					}
			}
		}
		else{
			if(ballCenterY < case2){//left
				if(ball.getRadius()+obj.getWidth()/2 > Math.abs(ballCenterX-objCenterX))
					if(ball.getRadius()+ obj.getHeight()/2> Math.abs(ballCenterY-objCenterY)){		
						ball.left();	
						isFadeWall = true;
						return true;
					}
			}
			else{//down
				if(ball.getRadius()+obj.getWidth()/2  > Math.abs(ballCenterX-objCenterX))
					if(ball.getRadius()+ obj.getHeight()/2 > Math.abs(ballCenterY-objCenterY)){
						ball.down();
						isFadeWall = true;
						return true;
					}
			}
		}
		return false;
	}

	private boolean  caseSchanze(Ball ball, GameObject obj) {
		int ballCenterX = ball.getX() + ball.getRadius();
		int ballCenterY = ball.getY() + ball.getRadius();
		int objCenterX = obj.getX() + obj.getWidth()/2;
		int objCenterY = obj.getY() + obj.getHeight()/2;
		
		if(ball.getRadius()+obj.getWidth()/2  > Math.abs(ballCenterX-objCenterX))
			if(ball.getRadius()+ obj.getHeight()/2 > Math.abs(ballCenterY-objCenterY)){
				ball.jump();
				return true;
			}
		return false;
	}
	private boolean  casePortal(Ball ball, GameObject obj) {
		int ballCenterX = ball.getX() + ball.getRadius();
		int ballCenterY = ball.getY() + ball.getRadius();
		int objCenterX = obj.getX() + obj.getWidth()/2;
		int objCenterY = obj.getY() + obj.getHeight()/2;
		
		if(ball.getRadius()+obj.getWidth()/2  > Math.abs(ballCenterX-objCenterX))
			if(ball.getRadius()+ obj.getHeight()/2 > Math.abs(ballCenterY-objCenterY)){
				return true;
			}
		return false;
	}
	private boolean caseNeedle(Ball ball, GameObject obj) {
		int ballCenterX = ball.getX() + ball.getRadius();
		int ballCenterY = ball.getY() + ball.getRadius();
		int objCenterX = obj.getX() + obj.getWidth()/2;
		int objCenterY = obj.getY() + obj.getHeight()/2;
		
		double HdivideW = ((double)obj.getWidth()/2)/(double)obj.getHeight();
		double distance = HdivideW*ball.getRadius()*Math.sqrt(HdivideW*HdivideW+1);
		
		int point1X = obj.getX() + obj.getWidth()/2;
		int point1Y = obj.getY();		
		int point2X = obj.getX();
		int point2Y = obj.getY() + obj.getHeight();
		int point3X = obj.getX()+obj.getWidth();
		int point3Y = obj.getY() + obj.getHeight();
		
		double slope1 = (double)(point1Y -  point2Y)/(point1X - point2X);
		double slope2 = (double)(point2Y -  point3Y)/(point2X - point3X);
		double slope3 = (double)(point1Y -  point3Y)/(point1X - point3X);
		
		double case1 = slope1*(ballCenterX-point1X) - distance + point1Y - ball.getRadius() ;
		double case2 = slope2*(ballCenterX-point2X) + ball.getRadius()+ point2Y;
		double case3 = slope3*(ballCenterX-point3X) - distance + point3Y - ball.getRadius();
		
		if(ball.getRadius()+obj.getWidth()/2  > Math.abs(ballCenterX-objCenterX))
			if(ball.getRadius()+ obj.getHeight()/2 > Math.abs(ballCenterY-objCenterY)){
				if(ballCenterY>case1 && ballCenterY>case3 && ballCenterY<case2)
					return true;	
			}		
		return false;
	}
}
