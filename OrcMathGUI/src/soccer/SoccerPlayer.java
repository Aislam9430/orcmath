package soccer;

import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;

public class SoccerPlayer extends AnimatedComponent{
	
	private Graphic standing;
	
	public SoccerPlayer() {
		super(400, 310,140,140);
		
		standing = new Graphic(400, 310, 140, 140,"resources/standing.png");
	}
	public BufferedImage getImage() {
		if(getVy() < 0){
			return super.getImage();
		}else{
			return standing.getImage();
		}
	}
}
