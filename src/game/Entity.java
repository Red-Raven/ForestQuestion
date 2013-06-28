package game;

import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

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
	
	public Entity(Path entityPath) throws IOException
	{
		List<String> lines = Files.readAllLines(entityPath, StandardCharsets.UTF_8);
		myName = lines.get(0).substring(lines.get(0).indexOf(" "));
		myEntityInventory = new Inventory(Paths.get(ActiveEntity.class.getResource("/") + "inventories/" + lines.get(1).substring(lines.get(1).indexOf(" ")) + ".txt"));
		myEntityPoint = new Point(lines.get(2));
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
