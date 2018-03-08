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
	}
	public void keyPressed(KeyEvent e) {
		 int key = e.getKeyCode();

		    if (key == KeyEvent.VK_SPACE) {
		    	System.out.print("xw");
		    	/*if()//balls in front
		    		ball.kickForward();
		    	if()//balls in front
			        ball.kickRight();
		    	if()//balls in front
			        ball.kickLeft();
		    */}
		
	}
}
