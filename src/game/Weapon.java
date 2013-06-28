package game;

import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

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
	
	public Weapon(Path weaponPath) throws IOException
	{
		List<String> lines = Files.readAllLines(weaponPath, StandardCharsets.UTF_8);
		myName = lines.get(0).substring(lines.get(0).indexOf(" ") + 1);
		myRange = Integer.parseInt(lines.get(1).substring(lines.get(1).indexOf(" ") + 1));
		myDamage = Integer.parseInt(lines.get(2).substring(lines.get(2).indexOf(" ") + 1));
	
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
