package holidayCard;

import guiTeacher.*;
import myStuff.CatalogMakerGui;

public class HolidayCardGUI extends GUIApplication
{

	 public static InsideScreen in;
	 public static IntroScreen front;
	 public static HolidayCardGUI sample;
	

	public HolidayCardGUI(int width,int height) 
	{
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		sample = new HolidayCardGUI(800, 550);
		Thread go = new Thread(sample);
		go.start();

	}
	
	public void initScreen() 
	{
		in = new InsideScreen(getWidth(),getHeight());
		front = new IntroScreen(getWidth(),getHeight());
		setScreen(in);
		setScreen(front);

	}

}
