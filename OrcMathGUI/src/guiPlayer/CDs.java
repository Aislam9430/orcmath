package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Date;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class CDs extends AnimatedComponent 
{
	private String name;
	private String artist;
	private int price;
	private int isbn;
	private Date releaseDate;

	public CDs(String name,String artist,int price,int isbn,Date releaseDate)
	{
		super(0,0,300,300);
		this.name = name;
		this.artist = artist;
		this.price = price; 
		this.isbn = isbn;
		this.releaseDate = releaseDate;
	}

	
	public String toString()
	{
		return name + "," + artist + "," + price + "," + isbn + "," + releaseDate;
	}
	
	

}
