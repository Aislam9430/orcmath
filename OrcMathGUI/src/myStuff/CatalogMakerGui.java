package myStuff;


import guiTeacher.*;

public class CatalogMakerGui extends GUIApplication 
{

	public CatalogMakerGui(int width, int height) 
	{
		super(width, height);
		setVisible(true);

	}
	
	public void initScreen()
	{
		
		setScreen(s);
	}

	public static void main(String[] args)
	{
		CatalogMakerGui sample = new CatalogMakerGui(800, 550);
		Thread go = new Thread(sample);
		go.start();
	}

}
