package game;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Weapon> myInventoryWeapons;
	private ArrayList<Armor> myInventoryArmor;
	private ArrayList<Potion> myInventoryPotions;
	private Weapon[] myActiveWeapons;
	private Armor[] myActiveArmor;
	
	public Inventory(ArrayList<Weapon> inventoryWeapons, ArrayList<Armor> inventoryArmor, ArrayList<Potion> inventoryPotions, Weapon[] activeWeapons, Armor[] activeArmor){
		myInventoryWeapons = inventoryWeapons;
		myInventoryArmor = inventoryArmor;
		myInventoryPotions = inventoryPotions;
	}
	
	//implement armor slots
	
	public ArrayList<Weapon> getIntventoryWeapons()
	{
		return myInventoryWeapons;
	}

	public ArrayList<Armor> getInventoryArmor()
	{
		return myInventoryArmor;
	}
	
	public ArrayList<Potion> getIntventoryPotions()
	{
		return myInventoryPotions;
	}
	
	public Weapon[] getActiveWeapons()
	{
		return myActiveWeapons;
	}
	
	public Weapon getActiveWeapons(int index)
	{
		return myActiveWeapons[index];
	}
	
	public Armor[] getActiveArmor()
	{
		return myActiveArmor;
	}
	
	public Armor getActiveArmor(int index)
	{
		return myActiveArmor[index];
	}
	
	public int getTotalArmorStrength()
	{
		int totalStrength = 0;
		for (Armor currentArmor : myActiveArmor)
		{
			totalStrength += currentArmor.getStrength();
		}
		return totalStrength;
	}
}
