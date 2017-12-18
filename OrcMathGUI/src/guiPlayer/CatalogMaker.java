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
