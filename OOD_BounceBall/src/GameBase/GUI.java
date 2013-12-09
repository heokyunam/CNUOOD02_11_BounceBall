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
	private final String gameExit = "Game Exit ";
	private final String gameTitle = "BounceBall";
	
	private final int GUIwidth = 640;
	private final int GUIheigth = 480;
	private final int ButtonWidth = 100;
	private final int ButtonHeight = 28;
	
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
		
		playButton.setBounds(GUIwidth/2 - ButtonWidth/2, 320, ButtonWidth, ButtonHeight);
		exitButton.setBounds(GUIwidth/2 - ButtonWidth/2, 350, ButtonWidth, ButtonHeight);
		
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
	 * KeyListener.getInstance()
	 */
	public static GUI getInstance() {
		if(gui == null) gui = new GUI();
		return gui;
	}
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
