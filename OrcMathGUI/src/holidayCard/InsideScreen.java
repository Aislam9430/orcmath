package holidayCard;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class InsideScreen extends FullFunctionScreen 
{

	public InsideScreen(int width, int height)
	{
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) 
	{
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/dbz.jpg"));
	}

}
