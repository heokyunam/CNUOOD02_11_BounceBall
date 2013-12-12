package GameBase;

import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GameRes.Ball;

public class GUI extends JFrame implements ActionListener ,KeyListener{

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
	
	private Image forgroundImage;
	private Font font;
	private GUI() {
		cardLayout = new CardLayout();
		loadImage();
		font = new Font("Batang", Font.BOLD, 30);
		buttonPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(forgroundImage, 0, 0, null);
				g.drawString("BounceBall", 225, 100);
				super.paintComponents(g);
			}
		};
		setResizable(false);
		buttonPanel.setFont(font);
		
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
		
		//this.addKeyListener(keylistener);
		canvas.addKeyListener(this);


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
	public void loadImage() {
		if(this.forgroundImage == null) {
			MediaTracker tracker = new MediaTracker(this);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			this.forgroundImage = toolkit.getImage("picture.jpg");
			tracker.addImage(this.forgroundImage, 0);
			try {
				tracker.waitForAll();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public Graphics getCanvasGraphics() {
		return canvas.getGraphics();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == playButton) {
			cardLayout.show(this.getContentPane(), gameMode);
			
			GameManager.getInstance().GameRun();
			canvas.requestFocus();
			
		}
		else if(obj == exitButton) {
			setVisible(false);
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		GUI.getInstance();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT) {
			Ball ball = Ball.getInstance();
			ball.setBallDirection(-1);
		}
		else if(code == KeyEvent.VK_RIGHT) {
			Ball ball = Ball.getInstance();
			ball.setBallDirection(1);
		}
		else if(code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_R) {
			GameManager gm = GameManager.getInstance();
			gm.first();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT) {
			Ball ball = Ball.getInstance();
			ball.setBallDirection(0);
		}
		else if(code == KeyEvent.VK_RIGHT) {
			Ball ball = Ball.getInstance();
			ball.setBallDirection(0);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
