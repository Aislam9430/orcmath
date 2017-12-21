package holidayCard;

import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class IntroScreen extends FullFunctionScreen 
{
	private Button open;
	private SnowFlake snow;
	private TextArea greet;

	public IntroScreen(int width, int height)
	{
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects)
	{
		createFont();
		greet = new TextArea(75,75,75,75,"8008135");
		open = new Button((getWidth()-100)/2,getHeight()-40,100,30,"Switch",new Action() 
		{
			public void act() 
			{
				HolidayCardGUI.sample.setScreen(HolidayCardGUI.in);
			}
		});
		snow = new SnowFlake(0,0,getWidth(),getHeight());
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
