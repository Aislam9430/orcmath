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
		stat = new TextArea(140, 180, getWidth()-220, 400, "Current Round"+round+"/nSequenceLength"+sequenceLength);
		b1 = new CustomButton(50,50, 100, 100, "",Color.RED, new Action(){ public void act() { clicked(); } });
	}
	private void clicked()
	{
		
	}

}
