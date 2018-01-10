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
	private CustomButton play;
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
	
	private ArrayList<Move> userMove;
	private ArrayList<Move> simonMove;
	private ArrayList<Move> allMoves;
	
	public SimonScreen(int width, int height) 
	{
		super(width, height);
		round = 1;
		sequenceLength = 3;
		red = Move.RED;
		blue = Move.BLUE;
		yellow = Move.YELLOW;
		green = Move.GREEN;
		pink = Move.PINK;
		cyan = Move.CYAN;
		orange = Move.ORANGE;
		black = Move.BLACK;
		userMove = new ArrayList<Move>();
		simonMove = new ArrayList<Move>();
		allMoves = new ArrayList<Move>();
		allMoves.add(red);
		allMoves.add(blue);
		allMoves.add(yellow);
		allMoves.add(green);
		allMoves.add(pink);
		allMoves.add(cyan);
		allMoves.add(orange);
		allMoves.add(black);
		
		
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
		turn = new TextArea(400, 200, getWidth()-220, 400, "Press Play To Start The Game.");
		play = new CustomButton(500, 200, 75, 75,"Play", Color.DARK_GRAY,new Action(){ public void act() { playing(); } });
		b1 = new CustomButton(50,50, 75, 75, "",Color.RED, new Action(){ public void act() { clicked(red,b1); } });
		b2 = new CustomButton(300,300, 75, 75, "",Color.BLUE, new Action(){ public void act() { clicked(blue,b2); } });
		b3 = new CustomButton(175,50, 75, 75, "",Color.YELLOW, new Action(){ public void act() { clicked(yellow,b3); } });
		b4 = new CustomButton(50,175, 75, 75, "",Color.GREEN, new Action(){ public void act() { clicked(green,b4); } });
		b5 = new CustomButton(300,175, 75, 75, "",Color.PINK, new Action(){ public void act() { clicked(pink,b5); } });
		b6 = new CustomButton(175,300, 75, 75, "",Color.CYAN, new Action(){ public void act() { clicked(cyan,b6); } });
		b7 = new CustomButton(300,50, 75, 75, "",Color.ORANGE, new Action(){ public void act() { clicked(orange,b7); } });
		b8 = new CustomButton(50,300, 75, 75, "",Color.BLACK, new Action(){ public void act() { clicked(black,b8); } });
		viewObjects.add(play);
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
		turn.setText("I got the moves");
		pause(1000);
		SimonPlay();
		//light up buttons store info in arraylist
		turn.setText("Your Turn");
		pause(1000);
		turn.setText("");
	}
	public void SimonPlay()
	{
	    int index = generateNum();
	    switch(allMoves.get(index))
	    {
			case BLACK:
				if(simonMove.contains(black))
				{
					index = generateNum();
				}
				else
				{
					simonMove.add(black);
					break;
				}
			case BLUE:
				if(simonMove.contains(blue))
				{
					index = generateNum();
				}
				else
				{
					simonMove.add(blue);
					break;
				}
			case CYAN:
				if(simonMove.contains(cyan))
				{
					index = generateNum();
				}
				else
				{
					simonMove.add(cyan);
					break;
				}
			case GREEN:
				if(simonMove.contains(green))
				{
					index = generateNum();
				}
				else
				{
					simonMove.add(green);
					break;
				}
			case ORANGE:
				if(simonMove.contains(orange))
				{
					index = generateNum();
				}
				else
				{
					simonMove.add(orange);
					break;
				}
			case PINK:
				if(simonMove.contains(pink))
				{
					index = generateNum();
				}
				else
				{
					simonMove.add(pink);
					break;
				}
			case RED:
				if(simonMove.contains(red))
				{
					index = generateNum();
				}
				else
				{
					simonMove.add(red);
					break;
				}
			case YELLOW:
				if(simonMove.contains(yellow))
				{
					index = generateNum();
				}
				else
				{
					simonMove.add(yellow);
					break;
				}
			default:
				break;
	    
	    }
		
	}
	private int generateNum()
	{
		return (int)(Math.random()*9);
	}

	private void clicked(Move move,CustomButton b)
	{
		userMove.add(move);
		b.makeFalse();
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
