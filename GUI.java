package Division;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {
	private static GUI gui;
	private Canvas canvas;
	private CardLayout cardLayout;
	private JButton playButton;
	private JButton exitButton;
	private JPanel buttonPanel;
	
	private final String menuMode = "MENU";
	private final String gameMode = "GAME";
	
	private final String gameStart = "게임 시작";
	private final String gameExit = "게임 종료";
	private final String gameTitle = "공 튀기기";
	
	private final int GUIwidth = 500;
	private final int GUIheigth = 350;
	
	private GUI() {
		cardLayout = new CardLayout();
		buttonPanel = new JPanel();
		playButton = new JButton(gameStart);
		exitButton = new JButton(gameExit);

		setLayout(cardLayout);
		
		JPanel panel = new JPanel();
		panel.add(playButton,BorderLayout.NORTH);
		panel.add(exitButton,BorderLayout.SOUTH);
		buttonPanel.add(panel, BorderLayout.SOUTH);
		add(buttonPanel,menuMode);
		
		canvas = new Canvas();
		add(canvas,gameMode);
		
		playButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		cardLayout.show(this.getContentPane(), menuMode);
		
		KeyListener keylistener = KeyListener.getInstance();
		addKeyListener(keylistener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(gameTitle);
		setSize(GUIwidth, GUIheigth);
		setVisible(true);
	}
	/*
	 * 생성자 사용시 KeyListener.getInstance()를 호출함.
	 */
	public static GUI getInstance() {
		if(gui == null) gui = new GUI();
		return gui;
	}
	/*
	 * getGraphics를 사용하려 했으나
	 * JFrame에서 다른 용도로 getGraphics를 사용해 오류가 생겨서
	 * 이런식으로 Graphics를 받아들일수밖에 없게 되었다.
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
			cardLayout.show(this, gameMode);
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
