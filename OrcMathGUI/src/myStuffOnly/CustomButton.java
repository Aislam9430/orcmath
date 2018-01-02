package myStuffOnly;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiPlayer.CustomLabel;

public class CustomButton extends Button implements CustomLabel
{
	private String string1;
	private String string2;
	
	public CustomButton(int x, int y, int w, int h, String text, Color color, Action action) 
	{
		super(x, y, w, h, text, color, action);
	}

	public CustomButton(int x, int y, int w, int h, String text, Action action) 
	{
		super(x, y, w, h, text, action);
	}
	public void update(Graphics2D g)
	{
		
	}
	public void drawButton(Graphics2D g, boolean hover)
	{
		g.setColor(new Color(0,0,0));
		g.drawString(string1, 150, 150);
		g.drawString(string2, 0, 150);
	}

	public void updateString1(String string) 
	{
		this.string1 = string;
	}

	public void updateString2(String string) 
	{		
		this.string2 = string;
	}

	public void setIconColor(Color color)
	{
		
	}

	
	
}
