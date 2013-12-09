package GameBase;

import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {

	private final String menuMode = "MENU";
	private final String gameMode = "GAME";
	
	private final String gameStart = "Game Start";
	private final String gameExit = "Game EXIT";
	private final String gameTitle = "BounceBall";
	
	private final int GUIwidth = 640;
	private final int GUIheigth = 480;
	
	private static GUI gui;
	private Canvas canvas;
	private CardLayout cardLayout;
	private JButton playButton;
	private JButton exitButton;
	private JPanel buttonPanel;
	
	private GUI() {
		cardLayout = new CardLayout();
		buttonPanel = new JPanel();
		
		buttonPanel.setLayout(null);
		//28, 89
		playButton = new JButton(gameStart);
		exitButton = new JButton(gameExit);
		//89(踰꾪듉���� / 2 = 44
		playButton.setBounds(GUIwidth/2 - 44, 320, 89, 28);
		exitButton.setBounds(GUIwidth/2 - 44, 350, 89, 28);
		
		buttonPanel.add(playButton);
		buttonPanel.add(exitButton);
		
		this.setLayout(cardLayout);
		
		this.add(buttonPanel,menuMode);
		
		canvas = new Canvas();
		this.add(canvas,gameMode);
		
		playButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		cardLayout.show(this.getContentPane(), menuMode);
		
		KeyListener keylistener = KeyListener.getInstance();
		this.addKeyListener(keylistener);		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(gameTitle);
		this.setSize(GUIwidth, GUIheigth);
		this.setVisible(true);
		System.out.println(playButton.getSize().height + " " + playButton.getSize().width);
	}
	/*
	 * �앹꽦���ъ슜��KeyListener.getInstance()瑜��몄텧��
	 */
	public static GUI getInstance() {
		if(gui == null) gui = new GUI();
		return gui;
	}
	/*
	 * getGraphics瑜��ъ슜�섎젮 �덉쑝��	 * JFrame�먯꽌 �ㅻⅨ �⑸룄濡�getGraphics瑜��ъ슜���ㅻ쪟媛��앷꺼��	 * �대윴�앹쑝濡�Graphics瑜�諛쏆븘�ㅼ씪�섎컰���녾쾶 �섏뿀��
	 */
	public Graphics getCanvasGraphics() {
		return canvas.getGraphics();
	}
	public void clear() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == playButton) {
			cardLayout.show(this.getContentPane(), gameMode);
			GameManager.getInstance().GameRun();
			
		}
		else if(obj == exitButton) {
			setVisible(false);
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		GUI.getInstance();
	}
}
