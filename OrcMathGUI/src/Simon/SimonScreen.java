package Simon;

import java.awt.Color;
import java.util.ArrayList;
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
	
	private Move red;
	private Move blue;
	private Move yellow;
	private Move green;
	private Move pink;
	private Move cyan;
	private Move orange;
	private Move black;
	
	private int round;
	private int sequenceLength;
	
	private ArrayList<Move> userMov;
	public SimonScreen(int width, int height) 
	{
		super(width, height);
		round = 1;
		sequenceLength = 3;
		red = new Move(1);
		blue = new Move(2);
		yellow = new Move(3);
		green = new Move(4);
		pink = new Move(5);
		cyan = new Move(6);
		orange = new Move(7);
		black = new Move(8);
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
		b1 = new CustomButton(50,50, 75, 75, "",Color.RED, new Action(){ public void act() { clicked(red); } });
		b2 = new CustomButton(300,300, 75, 75, "",Color.BLUE, new Action(){ public void act() { clicked(blue); } });
		b3 = new CustomButton(175,50, 75, 75, "",Color.YELLOW, new Action(){ public void act() { clicked(yellow); } });
		b4 = new CustomButton(50,175, 75, 75, "",Color.GREEN, new Action(){ public void act() { clicked(green); } });
		b5 = new CustomButton(300,175, 75, 75, "",Color.PINK, new Action(){ public void act() { clicked(pink); } });
		b6 = new CustomButton(175,300, 75, 75, "",Color.CYAN, new Action(){ public void act() { clicked(cyan); } });
		b7 = new CustomButton(300,50, 75, 75, "",Color.ORANGE, new Action(){ public void act() { clicked(orange); } });
		b8 = new CustomButton(50,300, 75, 75, "",Color.BLACK, new Action(){ public void act() { clicked(black); } });
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
	public void SimonPlay()
	{
		
	}
	private void clicked(Move move)
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
