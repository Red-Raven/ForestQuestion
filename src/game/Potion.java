package game;

public class Potion {

	String myName;
	String myType;
	int myPurity;

	public Potion(String name, String type, int purity)
	{
		myName = name;
		myType = type;
		myPurity = purity;
	}

	//add different effects based on type;

	public String getName()
	{
		return myName;
	}

	public String getType()
	{
		return myType;
	}

	public int getPurity()
	{
		return myPurity;
	}

}
