package Simon;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button
{
	private boolean litUp;

	public CustomButton(int x, int y, int w, int h, String text, Color color, Action action) 
	{
		super(x, y, w, h, text, color, action);
		litUp = false;
		// TODO Auto-generated constructor stub
	}
	public void lightUp()
	{
		
	}
	public boolean getLitUp()
	{
		return litUp;
	}
	public void toggle()
	{
		litUp = !litUp; 
	}
}
