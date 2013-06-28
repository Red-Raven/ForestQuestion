package game;

import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class Place {

	private String myName;
	private String[] myDescriptions;
	private boolean myIsAccessible;
	private int myLength;
	private int myWidth;
	private Entity[][] myGrid;
	private Point myLocation;
	private Point myEastEntrance;
	private Point mySouthEntrance;
	private Point myWestEntrance;
	private Point myNorthEntrance;

	public Place(String name, String[] descriptions, boolean isAccessible, int length, int width, Entity[][] grid, Point location, Point eastEntrance, Point southEntrance, Point westEntrance, Point northEntrance)
	{
		myName = name;
		myDescriptions = descriptions;
		myIsAccessible = isAccessible;
		myLength = length;
		myWidth = width;
		myGrid = new Entity[myLength][myWidth];
		myLocation = location;
		myEastEntrance = eastEntrance;
		mySouthEntrance = southEntrance;
		myWestEntrance = westEntrance;
		myNorthEntrance = northEntrance;
	}
	
	public Place(Path placePath) throws IOException
	{
		List<String> lines = Files.readAllLines(placePath, StandardCharsets.UTF_8);
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

	public boolean getIsAccessible()
	{return myIsAccessible;}
	
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
	
	public boolean moveEntity(Point currentPoint, Point movePoint)
	{addEntity(myGrid[currentPoint.getX()][currentPoint.getY()], movePoint);
	removeEntity(currentPoint);}

	public double getDistance(Entity entity1, Entity entity2)
	{return (Math.sqrt(Math.pow(entity1.getEntityPoint().getX() - entity2.getEntityPoint().getX(), 2) + 
			Math.pow(entity1.getEntityPoint().getY() - entity2.getEntityPoint().getY(), 2)));}
}
