package game;

import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Inventory {
	private ArrayList<Armor> myInventoryArmor;
	private ArrayList<Potion> myInventoryPotions;
	private ArrayList<Weapon> myInventoryWeapons;
	private Weapon[] myActiveWeapons;
	private Armor[] myActiveArmor;
	
	public Inventory(ArrayList<Armor> inventoryArmor, ArrayList<Potion> inventoryPotions, ArrayList<Weapon> inventoryWeapons, Armor[] activeArmor, Weapon[] activeWeapons)
	{
		myInventoryWeapons = inventoryWeapons;
		myInventoryArmor = inventoryArmor;
		myInventoryPotions = inventoryPotions;
	}
	
	public Inventory (Path inventoryPath) throws IOException
	{
		List<String> lines = Files.readAllLines(inventoryPath, StandardCharsets.UTF_8);
		myInventoryArmor = makeArmorList(lines.get(0));
	/** temporary **/ myInventoryPotions = new ArrayList<Potion>(); 	
		myInventoryWeapons = makeWeaponList(lines.get(2));
	/**temporary **/ myActiveArmor = new Armor[7];
	/**temporary **/ myActiveWeapons = new Weapon[3];
	}
	
	public static ArrayList<Armor> makeArmorList(String armorNames) throws IOException
	{
		ArrayList<Armor>  armorList = new ArrayList<Armor>();
		while (armorNames.indexOf(",") + 1 >= armorNames.length() && armorNames.length() > 0)
		{
			armorList.add(new Armor(Paths.get(Inventory.class.getResource("/") + "armor/" + armorNames.substring(armorNames.indexOf(" ") + 1, armorNames.indexOf(",")) + ".txt")));
			armorNames = armorNames.substring(armorNames.indexOf(",") + 1);
		}
		return armorList;
	}
	
	public static ArrayList<Weapon> makeWeaponList(String weaponNames) throws IOException
	{
		ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
		while(weaponNames.indexOf(",") + 1 >= weaponNames.length() && weaponNames.length() > 0)
		{
			weaponList.add(new Weapon(Paths.get(Inventory.class.getResource("/") + "weapons/" + weaponNames.substring(weaponNames.indexOf(" ") + 1, weaponNames.indexOf(",")) + ".txt")));
			weaponNames = weaponNames.substring(weaponNames.indexOf(",") + 1);
		}
		return weaponList;
	}
	
	//implement armor slots
	
	public ArrayList<Armor> getInventoryArmor()
	{
		return myInventoryArmor;
	}
	
	public ArrayList<Potion> getIntventoryPotions()
	{
		return myInventoryPotions;
	}
	
	public ArrayList<Weapon> getIntventoryWeapons()
	{
		return myInventoryWeapons;
	}
	
	public Armor[] getActiveArmor()
	{
		return myActiveArmor;
	}
	
	public Armor getActiveArmor(int index)
	{
		return myActiveArmor[index];
	}
	
	public Weapon[] getActiveWeapons()
	{
		return myActiveWeapons;
	}
	
	public Weapon getActiveWeapons(int index)
	{
		return myActiveWeapons[index];
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
