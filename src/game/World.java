package game;

import java.nio.file.Paths;

public class World {
	
	private Place[][] myPlaceGrid;
	private int myLength;
	private int myWidth;
	
	public World(int length, int width)
	{
		myLength = length;
		myWidth = width;
		myPlaceGrid = new Place[myLength][myWidth];
	}
	
	public Place getPlace(int x, int y)
	{
		return myPlaceGrid[x][y];
	}
	
	public Place getPlaceInDirection(Place currentPlace, String direction)
	{
		int x = currentPlace.getLocation().getX();
		int y = currentPlace.getLocation().getY();
		
		if (direction.equals("East") && x + 1 < myLength)
			return myPlaceGrid[x + 1][y];
		else if (direction.equals("South") && y + 1 < myWidth)
			return myPlaceGrid[x][y + 1];
		else if (direction.equals("West") && x - 1 >= 0 )
			return myPlaceGrid[x - 1][y];
		else if (direction.equals("North") && y - 1 >= 0)
			return myPlaceGrid[x][y - 1];
		return null;
	}

}
