package GameRes;

import java.awt.Graphics;
/*
 * GameObject��abstract�대옒�ㅼ씠硫�
 * collisionCheck硫붿냼�쒖� draw硫붿냼�쒕뒗 abstract硫붿냼�쒖씠��
 */
public abstract class GameObject {
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	
	public GameObject() {
		this(0, 0, 0, 0);
	}
	public GameObject(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	public abstract void draw(Graphics g);
	public abstract void collisionCheck(Ball ball);
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
}
