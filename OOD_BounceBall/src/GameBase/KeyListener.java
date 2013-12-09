package GameBase;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import GameRes.Ball;

/*
 * �쇱そ��-1 �ㅻⅨ履쎌� +1 媛믪쓣 留ㅺ컻蹂�닔濡��댁꽌 Ball��硫붿냼�쒕� �몄텧�쒗궡.
 * 留ㅻ쾲 �낅뜲�댄듃 �곹솴留덈떎 �ㅺ� �뚮젮�덉쑝硫�ball��硫붿냼�쒕� 吏�냽�곸쑝濡��몄텧�쒗궡.
 * 
 * ESC瑜��꾨� 寃쎌슦 �ㅽ뀒�댁�瑜�珥덇린���쒗궎��寃껋뿉 ��븳 �ㅼ젙���꾩쭅 誘몄셿�� */
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
