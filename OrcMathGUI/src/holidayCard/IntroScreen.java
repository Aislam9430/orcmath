package holidayCard;

import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class IntroScreen extends FullFunctionScreen 
{
	private Button open;
	private AnimatedComponent snow;
	private TextArea greet;

	public IntroScreen(int width, int height)
	{
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects)
	{
		///createFont();
		greet = new TextArea(75,75,75,75,"");
		open = new Button((getWidth()-100)/2,getHeight()-40,100,30,"Switch",new Action() 
		{
			public void act() 
			{
				HolidayCardGUI.sample.setScreen(HolidayCardGUI.in);
			}
		});
		snow = new AnimatedComponent(0, 0, 65, 56);
		snow.addSequence("resources/s.png", 40, 0, 0, 20, 100, 2);
		Thread run = new Thread(snow);
		run.start();
		
		viewObjects.add(snow);
		viewObjects.add(greet);
		viewObjects.add(open);
		
	}
	

	public void createFont()
	{
		try
		{

			 File fontFile = new File("resources//AdventPro-Medium.ttf");

			 Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			 Font baseFont=font.deriveFont(16f);

			 greet.setFont(baseFont);

			 } 
		catch (Exception e) 
		{
			 e.printStackTrace();
		}
	}
}
