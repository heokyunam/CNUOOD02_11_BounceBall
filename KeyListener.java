package Division;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * 왼쪽은 -1 오른쪽은 +1 값을 매개변수로 해서 Ball의 메소드를 호출시킴.
 * 매번 업데이트 상황마다 키가 눌려있으면 ball의 메소드를 지속적으로 호출시킴.
 * 
 * ESC를 누를 경우 스테이지를 초기화 시키는 것에 대한 설정이 아직 미완성
 */
public class KeyListener extends KeyAdapter{
	private static KeyListener keyListener;
	private KeyListener() {
		
	}
	public static KeyListener getInstance() {
		if(keyListener == null)
			keyListener = new KeyListener();
		return keyListener;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT) {
			Ball ball = Ball.getInstance();
			ball.setBallDirection(-1);
		}
		else if(code == KeyEvent.VK_RIGHT) {
			Ball ball = Ball.getInstance();
			ball.setBallDirection(1);
		}
		else if(code == KeyEvent.VK_ESCAPE) {
			GUI gui = GUI.getInstance();
			
		}
	}
}
