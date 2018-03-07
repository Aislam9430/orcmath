package soccer;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;
import guiTeacher.components.MovingComponent;

public class SoccerBall extends MovingComponent{
	
	private BufferedImage img;
	private int leftToRight;
	
	public SoccerBall(int w, int h) {
		super((int)(Math.random()*w), (int)(Math.random()*h), 30, 30);
		leftToRight = w;
		img = new Graphic(0, 0,30,30, "resources/soccer.png").getImage();
		setVy(1.5+Math.random()*2.0);
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
			setY(50);
			setVy(1.5+Math.random()*2.0);
			setX(5);
	}

}
