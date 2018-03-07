package soccer;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.Snowflake;

public class SoccerScreen extends FullFunctionScreen{

	public SoccerScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/field.png"));
		viewObjects.add(new SoccerBall(getWidth(), getHeight()));
		viewObjects.add(new Graphic(410, 350, 60, 150,"resources/tempsoccerplayer.jpg"));
	}

}
