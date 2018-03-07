package soccer;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;
import guiTeacher.components.MovingComponent;

public class SoccerBall extends MovingComponent implements KeyListener{
	
	private BufferedImage img;
	private int leftToRight;
	
	public SoccerBall(int w, int h) {
		super(0, 400, 30, 30);
		leftToRight = w;
		img = new Graphic(0, 0,30,30, "resources/soccer.png").getImage();
		setVx(5);
		update();
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void drawImage(Graphics2D g) {
		if(img != null){
			g.drawImage(img, 0, 0, null);
		}
	}

	@Override
	public void checkBehaviors() {
		if(getX()>leftToRight){
			setX(0);
			setVx(5);
			System.out.print("x");
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
