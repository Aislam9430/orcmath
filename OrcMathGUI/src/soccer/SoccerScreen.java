package soccer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.Snowflake;

public class SoccerScreen extends FullFunctionScreen {
	
	SoccerBall ball;
	
	public SoccerScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/field.png"));
		ball = new SoccerBall(getWidth(),getHeight());
		viewObjects.add(ball);
		viewObjects.add(new SoccerPlayer());
		viewObjects.add(new Graphic(315,50,200,200,"resources/soccerGoal.png"));
	}
	public void keyPressed(KeyEvent e) {
		 int key = e.getKeyCode();

		    if (key == KeyEvent.VK_SPACE) {
		    	if(ball.getX() > 400 && ball.getX() < 450) 
		    		ball.kickForward();
		    	if(ball.getX() > 360 && ball.getX() < 400)
			        ball.kickLeft();
		    	if(ball.getX() > 450 && ball.getX() < 500)
			        ball.kickRight();
		    }
		
	}
}
