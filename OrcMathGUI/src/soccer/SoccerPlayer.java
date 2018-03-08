package soccer;

import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;

public class SoccerPlayer extends AnimatedComponent{
	
	private Graphic standing;
	
	public SoccerPlayer() {
		super(470, 410, 100, 100);
		
		standing = new Graphic(0, 0, 0, 0,"resources/standing.png");
	}
	public BufferedImage getImage() {
		if(getVy() < 0){
			return super.getImage();
		}else{
			return standing.getImage();
		}
	}
}
