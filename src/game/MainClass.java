package game;

public class MainClass {

	//will store all core variables
	//the World variable
	//current place in world
	//the player
	//game settings
	//methods that generate all these variables
	
	private World myGameWorld;
	private Place myCurrentPlace;
	
	public MainClass()
	{
		
		
	}
	
	/***   game management methods   ***/
	public void changePlace(String direction)
	{
		Place nextPlace = myGameWorld.getPlaceInDirection(myCurrentPlace, direction);
		if (nextPlace.equals(null))
		{
			System.out.println("Place not found.");
		}
		else if (!nextPlace.getIsAccessible())
		{
			System.out.println("You can't go there.");
		}
		else
		{
			myCurrentPlace = nextPlace;
		}
	}
	
	/*** combat methods ***/
	public int getCalculatedDamage(Entity attacker, Entity attackee)
	{	
		double distance = myCurrentPlace.getDistance(attacker, attackee);
		int armorStrengthTotal = attackee.getInventory().getTotalArmorStrength();
		Weapon attackerWeapon = attacker.getInventory().getActiveWeapons(0);
		int range = attackerWeapon.getRange();
		int damage = attackerWeapon.getDamage();
		return (Math.abs((int)distance - range) + damage - armorStrengthTotal);
		
		//update this method as testing goes on.
		//distance - effect depends on range and kind of weapon
		//armor - calculated damage varies inversely
		//myRange - optimal distance for maximum damage
		//myDamage - overall effectiveness of weapon. multiple or divide final int by this.
		//possible tweaks:
		//range/dist (highest/lowest or opposite. if statement will set it to ensure it is always
		//a fraction or double/int greater than 1.)
		//multiply by damage
		//divide by armorStrengthTotal
	}
	
}
