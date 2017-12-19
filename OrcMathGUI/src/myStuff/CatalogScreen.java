package myStuff;

import java.util.Date;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen 
{
	private TextField titleField;
	private TextField artistField;
	private TextField priceField;
	private TextField isbnField;
	private TextField releaseDateField;
	private Button add;
	
	
	public CatalogScreen(int width, int height) 
	{
		super(width, height);

	}

	public void initAllObjects(List<Visible> viewObjects) 
	{
		titleField = new TextField(40,40,200,30,"Text Goes Here","Title");
		artistField = new TextField(140,40,200,30,"Text Goes Here","Artist");
		priceField = new TextField(240,40,200,30,"Text Goes Here","Price");
		isbnField = new TextField(340,40,200,30,"Text Goes Here","Isbn");
		releaseDateField = new TextField(440,40,200,30,"Text Goes Here","Date");
		add = new Button(40,70,100,40,"Text Add", new Action() 
		{
			
			public void act() 
			{
				titleField.setText("hello friend");
				
			}
		});
		viewObjects.add(titleField);
		viewObjects.add(artistField);
		viewObjects.add(priceField);
		viewObjects.add(isbnField);
		viewObjects.add(releaseDateField);
		viewObjects.add(add);
		
	}

	

}


////String name,String artist,int price,int isbn,Date releaseDate