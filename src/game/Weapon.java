package game;

public class Weapon {
	String myName;
	int myRange;
	int myDamage;

	public Weapon(String name, int range, int damage)
	{
		myName = name;
		myRange = range;
		myDamage = damage;
	}

	public String getName()
	{
		return myName;
	}

	public int getRange()
	{
		return myRange;
	}

	public int getDamage()
	{
		return myDamage;
	}

}
