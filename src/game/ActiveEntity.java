package game;

public class ActiveEntity extends Entity{
	
	private String myName;
	private Inventory myEntityInventory;
	private Point MyEntityPoint;
	private final int MYMAXHEALTH;
	private int myHealth;
	private boolean myIsDead = false;
	
	public ActiveEntity(String name, Inventory entityInventory, Point entityPoint, int MAXHEALTH, int health)
	{
		super(name, entityInventory, entityPoint);
		MYMAXHEALTH = MAXHEALTH;
		myHealth = health;
	}
	//create separate AI class or add AI methods to this class for enemies (multiple AIs possible).
	//If methods are added to this class, add them to an extended class and use this class or another
	//extended class for the Player.
	public void changeHealth(int changeAmount, boolean isHeal)
	{
		if (isHeal)
		{
			myHealth += changeAmount;
			//find way to add changeAmount w/o it being possible for it to go over MYMAXHEALTH.
			if (myHealth > MYMAXHEALTH)
			{
				myHealth = MYMAXHEALTH;
			}
		}
		else
		{
			myHealth -= changeAmount;
			if (myHealth <= 0)
				myIsDead = true;
		}
	
	}
	
	
}
