package myStuffOnly;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiPlayer.CustomLabel;

public class CustomButton extends Button implements CustomLabel
{

	public CustomButton(int x, int y, int w, int h, String text, Color color, Action action) 
	{
		super(x, y, w, h, text, color, action);
		// TODO Auto-generated constructor stub
	}

	public CustomButton(int x, int y, int w, int h, String text, Action action) 
	{
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}
	public void update(Graphics2D g)
	{
		
	}
	public void drawButton(Graphics2D g, boolean hover)
	{
		
	}

	
	
}
