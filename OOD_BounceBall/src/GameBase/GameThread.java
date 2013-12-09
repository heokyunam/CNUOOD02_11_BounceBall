package GameBase;

public class GameThread extends Thread{
	
	private final int FRAME_TIME = 33;
	private boolean mRun = false;
	
	
	public void ThreadStart(){
		this.mRun = true;
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
			System.out.println("Run!!");
			
			
			
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
