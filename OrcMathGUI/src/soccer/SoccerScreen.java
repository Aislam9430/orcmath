package soccer;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.Snowflake;

public class SoccerScreen extends FullFunctionScreen {
	
	SoccerBall ball;
	TextArea pointsBox;
	TextArea missed;
	int points;
	int misses;
	int speed;
	
	public SoccerScreen(int width, int height) {
		super(width, height);
		speed = 5;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/field.png"));
		
		ball = new SoccerBall(getWidth(),getHeight(),5);
		viewObjects.add(ball);
		viewObjects.add(new SoccerPlayer());
		
		viewObjects.add(new Graphic(315,50,200,200,"resources/soccerGoal.png"));
		pointsBox = new TextArea(135, 15, 200, 50, "POINTS:0");
		pointsBox.setSize(20);
		pointsBox.setCustomTextColor(new Color(255,255,0));
		viewObjects.add(pointsBox);
		
		missed = new TextArea(605, 15, 200, 50, "MISSED:0");
		missed.setSize(20);
		missed.setCustomTextColor(new Color(255,255,0));
		viewObjects.add(missed);
	}
	public void keyPressed(KeyEvent e) {
		 int key = e.getKeyCode();

		    if (key == KeyEvent.VK_SPACE) {
		    	if(ball.getX() > 400 && ball.getX() < 450) {
		    		ball.kickForward();
		    		points++;
		    	    pointsBox.setText("POINTS:"+points);
		    		addBall();
		    	}
		    	
		    	if(ball.getX() > 360 && ball.getX() < 400) {
			        ball.kickLeft();
			        misses++;
		    	    missed.setText("MISSED:"+misses);
		    	    addBall();
		    	}
		    	if(ball.getX() > 450 && ball.getX() < 500) {
			        ball.kickRight();
			        misses++;
		    	    missed.setText("MISSED:"+misses);
		    	    addBall();
		    	}
		    	
		    	
		    }
		    
		    update();
	}
	public void addBall() {
		if((points+5)%5 == 0) {
			speed += 1;
		}
		ball = new SoccerBall(getWidth(),getHeight(),speed);
		addObject(ball);
	}
	
}
