package soccer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;
import guiTeacher.components.MovingComponent;

public class SoccerBall extends MovingComponent {
	
	private BufferedImage img;
	private int leftToRight;
	int speed;
	
	public SoccerBall(int w, int h,int s) {
		super(0, 400, 30, 30);
		leftToRight = w; 
		img = new Graphic(0, 0,30,30, "resources/soccer.png").getImage();
		speed = s;
		setVx(s);
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
			setVx(speed);
		}
		if(getVx() != 0 && getY() < 100) {
			setVx(0);
		}
		else if(getY() < 100) {
			setVy(0);
		}
	}
	public void kickForward() {
		setVx(0);
		setVy(-10);
	}
	public void kickRight() {
		setVx(5);
		setVy(-5);
	}
	public void kickLeft() {
		setVx(-5);
		setVy(-5);
	}
}
