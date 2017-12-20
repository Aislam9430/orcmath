package myStuff;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		priceField = new TextField(240,40,200,30,"11","Price");
		priceField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		isbnField = new TextField(340,40,200,30,"123","Isbn");
		isbnField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		releaseDateField = new TextField(440,40,200,30,"11/23/2017","Date");
		textarea = new TextArea(400, 300, 200, 200, "cd list");
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
		try {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date d = df.parse(releaseDateField.getText());
		CDs album = new CDs(titleField.getText(),artistField.getText(),Integer.parseInt(priceField.getText()), Integer.parseInt(isbnField.getText()),d);
		String s = textarea.getText() + album + "\n";
		textarea.setText(s);
		catalog.addCDs(new CDs(titleField.getText(),artistField.getText(),Integer.parseInt(priceField.getText()), Integer.parseInt(isbnField.getText()),d));
		titleField.setText("");
		artistField.setText("");
		priceField.setText("");		
		isbnField.setText("");
		titleField.update();
		
		}catch(NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}


////String name,String artist,int price,int isbn,Date releaseDate