package game;

import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Place {

	private String myName;
	private String[] myDescriptions;
	private Point myLocation;
	private Point myEastEntrance;
	private Point mySouthEntrance;
	private Point myWestEntrance;
	private Point myNorthEntrance;
	private Point myDimensions;
	private Entity[][] myGrid;

	public Place(String name, String[] descriptions, Point location, Point eastEntrance, Point southEntrance, Point westEntrance, Point northEntrance, Point dimensions, Entity[][] grid)
	{myName = name;
	myDescriptions = descriptions;
	myLocation = location;
	myEastEntrance = eastEntrance;
	mySouthEntrance = southEntrance;
	myWestEntrance = westEntrance;
	myNorthEntrance = northEntrance;
	myDimensions = dimensions;
	myGrid = new Entity[myDimensions.getX()][myDimensions.getY()];}

	public Place(Path placePath) throws IOException
	{List<String> lines = Files.readAllLines(placePath, StandardCharsets.UTF_8);
	myName = lines.get(0).substring(lines.get(0).indexOf(" ") + 1);
	String[] descriptions = {lines.get(1), lines.get(2), lines.get(3), lines.get(4), lines.get(5), lines.get(6)};
	myDescriptions = descriptions;
	myLocation = new Point(lines.get(7));
	myEastEntrance = new Point(lines.get(8));
	mySouthEntrance = new Point(lines.get(9));
	myWestEntrance = new Point(lines.get(10));
	myNorthEntrance = new Point(lines.get(11));
	myDimensions = new Point(lines.get(12));
	myGrid = new Entity[myDimensions.getX()][myDimensions.getY()];
	int x = 0;
	int y = 0;
	while (y < myGrid.length)
		{String currentLine = lines.get(y + 14);
		while(x < myGrid[0].length)
			{String entityName = currentLine.substring(currentLine.indexOf(" ") + 1, currentLine.indexOf(","));
			if (entityName.equals(null))
				{myGrid[x][y] = null;}
			else {myGrid[x][y] = new ActiveEntity(Paths.get(Place.class.getResource("/") + "entities/" + entityName + ".txt"));
				currentLine = currentLine.substring(currentLine.indexOf(" "));}}}
	}

	public String getName()
	{return myName;}

	public String getDescription(String subject)
	{if (subject.equals("look"))
		{return myDescriptions[0];}
	else if (subject.equals("look detail"))
		{return myDescriptions[1];}
	else if (subject.equals("East"))
		{return myDescriptions[2];}
	else if (subject.equals("South"))
		{return myDescriptions[3];}
	else if (subject.equals("West"))
		{return myDescriptions[4];}
	else if (subject.equals("North"))
		{return myDescriptions[5];}
	else
		{return null;}}

	public Entity[][] getGrid()
	{return myGrid;}

	public Point getLocation()
	{return myLocation;}

	public Point getEntrancePoint(String direction)
	{if (direction.equals("West"))
		{return myEastEntrance;}
	else if (direction.equals("North"))
		{return mySouthEntrance;}
	else if (direction.equals("East"))
		{return myWestEntrance;}
	else if (direction.equals("South"))
		{return myNorthEntrance;}
	else
		{return null;}}

	public boolean addEntity(Entity entityToAdd, Point addPoint)
	{if (myGrid[addPoint.getX()][addPoint.getY()].equals(null))
		{myGrid[addPoint.getX()][addPoint.getY()] = entityToAdd;
		return true;}
	else {return false;}}

	public boolean removeEntity(Point removePoint)
	{if (myGrid[removePoint.getX()][removePoint.getY()].equals(null))
		{return false;}
	else {myGrid[removePoint.getX()][removePoint.getY()] = null;
		return true;}}

	public void moveEntity(Point currentPoint, Point movePoint)
	{addEntity(myGrid[currentPoint.getX()][currentPoint.getY()], movePoint);
	removeEntity(currentPoint);}

	public double getDistance(Entity entity1, Entity entity2)
	{return (Math.sqrt(Math.pow(entity1.getEntityPoint().getX() - entity2.getEntityPoint().getX(), 2) + 
			Math.pow(entity1.getEntityPoint().getY() - entity2.getEntityPoint().getY(), 2)));}
}
