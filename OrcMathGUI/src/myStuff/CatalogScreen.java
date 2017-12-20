package myStuff;

import java.util.Date;
import java.util.List;

import guiPlayer.CDs;
import guiPlayer.CatalogMaker;
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
	private CatalogMaker catalog;
	private TextArea textarea;
	
	public CatalogScreen(int width, int height) 
	{
		super(width, height);

	}

	public void initAllObjects(List<Visible> viewObjects) 
	{
		catalog = new CatalogMaker();
		titleField = new TextField(40,40,200,30,"Text Goes Here","Title");
		artistField = new TextField(140,40,200,30,"Text Goes Here","Artist");
		priceField = new TextField(240,40,200,30,"Text Goes Here","Price");
		priceField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		isbnField = new TextField(340,40,200,30,"Text Goes Here","Isbn");
		isbnField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		releaseDateField = new TextField(440,40,200,30,"Text Goes Here","Date");
		textarea = new TextArea(400, 300, 200, 40, "cd list");
		add = new Button(40,70,100,40,"Text Add", new Action() 
		{
			
			public void act() 
			{
				addButtonClicked();
				
			}
		});
		viewObjects.add(titleField);
		viewObjects.add(artistField);
		viewObjects.add(priceField);
		viewObjects.add(isbnField);
		viewObjects.add(releaseDateField);
		viewObjects.add(add);
		viewObjects.add(textarea);;
		
	}

	protected void addButtonClicked() 
	{
		CDs album = new CDs(titleField.getText(),artistField.getText(),Integer.parseInt(priceField.getText()), Integer.parseInt(isbnField.getText()),new Date());
		String s = textarea.getText() + album + "\n";
		catalog.addCDs(new CDs(titleField.getText(),artistField.getText(),Integer.parseInt(priceField.getText()), Integer.parseInt(isbnField.getText()),new Date()));
		titleField.setText(" ");
		artistField.setText(" ");
		priceField.setText(" ");		
		isbnField.setText(" ");
		
	}

	

}


////String name,String artist,int price,int isbn,Date releaseDate