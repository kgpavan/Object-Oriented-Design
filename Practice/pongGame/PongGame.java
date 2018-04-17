package design.practice.pongGame;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.Timer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class PongPanel extends JPanel implements ActionListener, KeyListener {


	public boolean upPressed = false;
	public boolean downPressed = false; 

	private int ballX = 250;
	private int ballY = 250;
	private int diameter = 20; 

	private int ballDelX = -5;
	private int ballDelY = 5;  

	// define the palyer one 
	private int playerOneX = 30;
	private int playerOneY = 150;
	private int playerOneWidth = 15;
	private int playerOneHeight = 150;

	private int paddleSpeed = 35;
	
	public PongPanel(){

		// System.out.println("Inside the Pong Panel Constructor");

		setBackground(Color.WHITE);
		setFocusable(true);
		addKeyListener(this);

		Timer timer = new Timer(100, this);
		timer.start();
	}



	public void actionPerformed(ActionEvent ae){

		setUp();
	}

	public void setUp(){

		// System.out.println("From the setUp method");

		if(upPressed){

			if(playerOneY - paddleSpeed >= 0)
				playerOneY -= paddleSpeed;
		}

		if(downPressed){

			if(playerOneY + playerOneHeight + paddleSpeed <=  500 )
				playerOneY += paddleSpeed;
		}

		int nextBallLeft = ballX + ballDelX;
		int nextBallTop =  ballY + ballDelY; 
		int nextBallRight = nextBallLeft + diameter;
		int nextBallBottom = nextBallTop + diameter; 




		// change the direction of the ball
		if(nextBallLeft <= 0 || nextBallRight >= 500 )
			ballDelX *= -1;

		// change the direction of the ball 
		if(nextBallTop <= 0 || nextBallBottom >= 500 )
			ballDelY *= -1;

		ballX += ballDelX;
		ballY += ballDelY;

		repaint();
	} 


	public void paintComponent(Graphics g){

		super.paintComponent(g);
		g.setColor(Color.RED);

		g.fillOval(ballX, ballY, diameter, diameter);

		g.setColor(Color.YELLOW);
		g.fillRect(playerOneX, playerOneY, playerOneWidth, playerOneHeight);
	}


	// @Override
	public void keyReleased(KeyEvent ke){

		// System.out.println("from the key released method");
		if(ke.getKeyCode() == KeyEvent.VK_UP){

			// System.out.println("the up key is released");
			upPressed = false;
		}

		if(ke.getKeyCode() == ke.VK_DOWN){

			// System.out.println("the down key is released");
			downPressed = false; 
		}
	}


	// @Override
	public void keyPressed(KeyEvent ke){

		// System.out.println("key pressed");

		if(ke.getKeyCode() == KeyEvent.VK_UP){

				// System.out.println("The up key is pressed");
			upPressed = true;
		}

		if(ke.getKeyCode() == KeyEvent.VK_DOWN){

			// System.out.println("the down key is pressed");
			downPressed = true;
		}
	}


	// @Override
	public void keyTyped(KeyEvent ke){

		// System.out.println("Key Typed");
	}
}



public class PongGame {

	
//	public static void main(String[] args) {
//
//		System.out.println("My pongGame");
//		JFrame frame = new JFrame("My pongGame");
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(new BorderLayout());
//
//		PongPanel pongPanel = new PongPanel();
//	    frame.add( pongPanel, BorderLayout.CENTER);
//
//		frame.setSize(500, 500);
//		frame.setVisible(true);
//	}
}