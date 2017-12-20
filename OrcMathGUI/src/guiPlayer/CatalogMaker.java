package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CatalogMaker {

	public static Scanner in;

	private ArrayList<CDs> catalog;

	public CatalogMaker() {
		//instantiate the catalog
		catalog = new ArrayList<CDs>();
	}

	public static void main(String[] args){
		CatalogMaker maker = new CatalogMaker();
		in = new Scanner(System.in);
		maker.menu();
	}

	private static void displayMessage(String message){
		System.out.println(message);
	}

	private void menu() {
		displayMessage("Would you like to \"load\" a save file or \"create\" a new list? ");
		String[] allowedEntry = {"load","create"};
		String input = getEntry(allowedEntry);
		if(input.equals("load")){
			load();
		}else{
			create();
		}
	}

	private void create() {

		boolean running = true;
		while(running){
			showCatalog();
			displayMessage("Would you like to \"add\", \"save\", or \"quit\"?");
			String[] allowedEntry = {"add","save","quit"};
			String selection = getEntry(allowedEntry);
			if(selection.equals("add")){
				userAdd();
			}else if(selection.equals("save")){
				save();
			}else{
				running = false;
			}
		}
	}

	public void userAdd()
	{
		String name = null;
		String artist = null;
		int price =0;
		int isbn = 0;
		displayMessage("Please enter a name of cd");
		name = getStringInput();
		displayMessage("Please enter an artist");
		artist = getStringInput();
		displayMessage("Please enter the pricre.");
		price = getIntegerInput();
		displayMessage("Please enter the isbn.");
		isbn = getIntegerInput();
		addCDs(new CDs(name,artist,price,isbn,new Date()));
	}


	private int getIntegerInput() {
		String text = in.nextLine();
		int value = 0;
		boolean valid = false;
		while(!valid){
			try{
				value = Integer.parseInt(text);
				valid = true;
			}catch(NumberFormatException nfe){
				displayMessage("You must enter an integer.");
			}
		}
		return value;
	}

	private static String getStringInput(){
		String text = in.nextLine();
		while(text.isEmpty()){
			displayMessage("You must enter a non-empty String.");
			text = in.nextLine();
		}
		return text;
	}


	public void addCDs(CDs b){
		catalog.add(b);
	}

	private void save() {
		try{    
			FileWriter fw=new FileWriter("BookCatalog.csv");
			for(CDs b: catalog){
				fw.write(b+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"BookCatalog.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	private static String getEntry(String[] allowedEntry) {
		String input = in.nextLine();
		while(!matchesEntry(input, allowedEntry)){
			displayMessage("You must enter one of these words: ");
			for(String s: allowedEntry){
				System.out.print(s+" ");
			}
			displayMessage("\n");
			input = in.nextLine();
		}
		return input;
	}

	private static boolean matchesEntry(String text, String[] list){
		for(String l: list){
			if(l.equals(text))return true;
		}
		return false;
	}

	private  void showCatalog() {
		displayMessage("The catalog contains these CDs:\n");
		for(CDs b: catalog){
			displayMessage("   "+b.toString()+"\n");
		}
	}

	private void load() {
		String fileName = "";
		//empty the catalog to prepare for a new load
		catalog = new ArrayList<CDs>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read teh file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {

					String[] param = line.split(",");
					//add a new Book for each line in the save file
					catalog.add(new CDs(param[0],param[1],Integer.parseInt(param[2]),Integer.parseInt(param[3]),new Date()));



				}
				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}
		create();

	}
}
/*
 package guiPlayer;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CatalogMaker 
{
	private ArrayList<CDs> list;
	private Scanner n;

	public CatalogMaker() 
	{
		list = new ArrayList<CDs>();
		list.add(new CDs("Saturation III","Brockhampton",11,21231,new Date()));
		list.add(new CDs("No One Really Dies","N.E.R.D",11,24234,new Date()));
		Scanner n = new Scanner(System.in);

	}	

	public String getCSVContent()
	{
		String data = "Name,Artist,Price,ISBN,Date\n";
		for(CDs s: list)
		{
			data += s + "\n";
		}
		return data; 
	}
	private void testSaveContent(String fileName) 
	{
		try
		{   
			FileWriter fw=new FileWriter(fileName);    
			for(CDs s: list)
			{
				fw.write(s + "\n");
			}
			fw.close();    
		}
		catch(IOException e)
		{
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}
	private List<String> testFileLoading() 
	{
		Scanner in = new Scanner(System.in);
		String fileName = "";
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened)
		{
			try 
			{
				System.out.println("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read the file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) 
				{

					String[] param = line.split(",");



				}
				br.close();
				opened = true;
			}
			catch (IOException e) 
			{
			System.out.println("The file name you specified does not exist.");
			}
		}
		//close the Scanner
		in.close();
		return content;
	}

	public void addNewItem(String name,String artist,int price,int isbn)
	{

		list.add(new CDs(name,artist,price,isbn,new Date()));
		System.out.println("Item added successfully");
	}
	public void userAdd()
	{
		System.out.println("Create ur catalog. type stop when you are done");
		while(!n.nextLine().equals("stop"))
		{
			System.out.println("Name of CD Please");
			String name = n.nextLine();
			System.out.println("Name of artist");
			String artist = n.nextLine();
			System.out.println("price please");
			int price = n.nextInt();
			System.out.println("isbn please");
			int isbn = n.nextInt();
			addNewItem(name,artist,price,isbn);
		}
	}
	public static void main(String[] args) 
	{

		CatalogMaker m = new CatalogMaker();
		m.userAdd();
		System.out.println(m.getCSVContent());


	}


}
 */