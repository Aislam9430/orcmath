package soccer;

import java.util.ArrayList;

import guiTeacher.GUIApplication;


public class SoccerMain extends GUIApplication 
{
	public static SoccerMain game;
	public static SoccerScreen screen;
	
	public static void main(String[] args) {
		game = new SoccerMain(820, 470);
		Thread runner = new Thread(game);
		runner.start();
		
	}
	public SoccerMain(int width, int height) 
	{
		super(width, height);
		setVisible(true);
		
	}

	@Override
	public void initScreen() 
	{
		screen = new SoccerScreen(getWidth(), getHeight());
		setScreen(screen);
	}

}
