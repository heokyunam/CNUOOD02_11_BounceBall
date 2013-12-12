package GameBase;

import java.awt.event.KeyListener;

import GameRes.Ball;

public class GameThread extends Thread{
	
	private final int FRAME_TIME = 15;
	private boolean mRun = false;
	private ResourceManager rm;
	private GUI gui;
	
	
	public void ThreadStart(){
		this.mRun = true;
		this.rm = ResourceManager.getInstance();
		this.gui = GUI.getInstance();
		
		this.start();
	}
	
	public void ThreadStop(){
		this.mRun = false;
	}
	
	@Override
	public void run() {
		long startTime, endTime, toSleep;
		// TODO Auto-generated method stub
		while(this.mRun){
			
			startTime = System.currentTimeMillis();

			rm.clear();
			rm.collision();
			rm.update();
			rm.draw(gui.getCanvasGraphics());
			
			
			endTime = System.currentTimeMillis();
			toSleep = FRAME_TIME - (endTime - startTime);

			
			if (toSleep > 0) {
				try {
					Thread.sleep(toSleep);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
