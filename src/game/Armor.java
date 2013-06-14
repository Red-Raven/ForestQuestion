package game;

public class Armor {
	public String myName;
	public int myStrength;
	
	public Armor(String name, int strength)
	{
		myName = name;
		myStrength = strength;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public int getStrength()
	{
		return myStrength;
	}

}