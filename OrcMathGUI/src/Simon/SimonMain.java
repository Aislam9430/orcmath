package Simon;

import java.util.ArrayList;

import guiTeacher.GUIApplication;
import holiday.Front;
import holiday.HolidayCard;

public class SimonMain extends GUIApplication 
{
	public static SimonMain game;
	public static SimonScreen screen;
	
	public static void main(String[] args) {
		game = new SimonMain(800, 500);
		Thread runner = new Thread(game);
		runner.start();
	}
	public SimonMain(int width, int height) 
	{
		super(width, height);
		setVisible(true);
		ArrayList<Move> moves = new ArrayList<Move>();
	}

	@Override
	public void initScreen() 
	{
		screen = new SimonScreen(getWidth(), getHeight());
		setScreen(screen);
	}

}
