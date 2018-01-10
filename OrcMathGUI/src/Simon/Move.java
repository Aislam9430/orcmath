package Simon;

public enum Move 
{
	RED(1),BLUE(2),YELLOW(3),GREEN(4),PINK(5),CYAN(6),ORANGE(7),BLACK(8);
	private int numColor;
	Move(int numColor)
	{
		numColor = this.numColor;
		
	}
}
