package game;

public abstract class Entity {
	
	private String myName;
	private Inventory myEntityInventory;
	private Point myEntityPoint;
	
	public Entity (String name, Inventory entityInventory, Point entityPoint)
	{
		myName = name;
		myEntityInventory = entityInventory;
		myEntityPoint = entityPoint;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public Point getEntityPoint()
	{
		return myEntityPoint;
	}
	public Inventory getInventory()
	{
		return myEntityInventory;
	}

}
