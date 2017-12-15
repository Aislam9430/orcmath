package guiPlayer;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

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
