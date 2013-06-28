package game;

import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class Armor {
	public String myName;
	public int myStrength;
	
	public Armor(String name, int strength)
	{
		myName = name;
		myStrength = strength;
	}
	
	public Armor(Path armorPath) throws IOException
	{
		List <String> lines = Files.readAllLines(armorPath, StandardCharsets.UTF_8);
		myName = lines.get(0).substring(lines.get(0).indexOf(" ") + 1);
		myStrength = Integer.parseInt(lines.get(1).substring(lines.get(1).indexOf(" ") + 1));
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