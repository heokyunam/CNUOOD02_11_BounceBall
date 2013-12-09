package GameBase;

public class GameThread extends Thread{
	
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
		// TODO Auto-generated method stub
		while(this.mRun){
			System.out.println("Run!!");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
