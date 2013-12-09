package GameBase;

public class GameThread extends Thread{
	
	private boolean mRun = false;
	private ResourceManager manager;
	private GUI gui;
	
	public void ThreadStart(){
		this.mRun = true;
		this.manager = ResourceManager.getInstance();
		this.gui = GUI.getInstance();
		
		this.start();
	}
	
	public void ThreadStop(){
		this.mRun = false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(this.mRun){
			System.out.println("Run!!");
			manager.draw(gui.getCanvasGraphics());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
