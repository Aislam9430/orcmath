package Simon;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import holiday.HolidayCard;

public class SimonScreen extends ClickableScreen 
{
	private CustomButton b1; 
	private CustomButton b2;
	private CustomButton b3;
	private CustomButton b4;
	private CustomButton b5;
	private CustomButton b6;
	private CustomButton b7;
	private CustomButton b8; 
	private TextArea stat;	
	private TextArea turn;
	
	private int round;
	private int sequenceLength;
	
	public SimonScreen(int width, int height) 
	{
		super(width, height);
		round = 1;
		sequenceLength = 3;
	}
	public void addRound() {
		round++;
	}
	public void addSequence() {
		sequenceLength++;
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) 
	{
		stat = new TextArea(140, 180, getWidth()-220, 400, "Current Round "+round+"\nSequenceLength "+sequenceLength);
		turn = new TextArea(175, 400, getWidth()-220, 400, "");
		b1 = new CustomButton(50,50, 75, 75, "",Color.RED, new Action(){ public void act() { clicked(); } });
		b2 = new CustomButton(300,300, 75, 75, "",Color.BLUE, new Action(){ public void act() { clicked(); } });
		b3 = new CustomButton(175,50, 75, 75, "",Color.YELLOW, new Action(){ public void act() { clicked(); } });
		b4 = new CustomButton(50,175, 75, 75, "",Color.GREEN, new Action(){ public void act() { clicked(); } });
		b5 = new CustomButton(300,175, 75, 75, "",Color.PINK, new Action(){ public void act() { clicked(); } });
		b6 = new CustomButton(175,300, 75, 75, "",Color.CYAN, new Action(){ public void act() { clicked(); } });
		b7 = new CustomButton(300,50, 75, 75, "",Color.ORANGE, new Action(){ public void act() { clicked(); } });
		b8 = new CustomButton(50,300, 75, 75, "",Color.BLACK, new Action(){ public void act() { clicked(); } });
		viewObjects.add(stat);
		viewObjects.add(turn);
		viewObjects.add(b1);
		viewObjects.add(b2);
		viewObjects.add(b3);
		viewObjects.add(b4);
		viewObjects.add(b5);
		viewObjects.add(b6);
		viewObjects.add(b7);
		viewObjects.add(b8);
	}
	private void playing()
	{
		turn.setText("Simon's Turn");
		//light up buttons store info in arraylist
		turn.setText("Your Turn");
		pause(600);
		turn.setText("");
	}
	private void clicked()
	{
		
	}
	public void pause(long time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
