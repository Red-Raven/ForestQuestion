package game;

public class Place {

	private String myName;
	private boolean myIsAccessible;
	private int myLength;
	private int myWidth;
	private int myXPosition;
	private int myYPosition;
	private int myEastEntranceX;
	private int myEastEntranceY;
	private int mySouthEntranceX;
	private int mySouthEntranceY;
	private int myWestEntranceX;
	private int myWestEntranceY;
	private int myNorthEntranceX;
	private int myNorthEntranceY;
	private Entity[][] myGrid;
	private String[] myDescriptions;

	public Place(String name, boolean isAccessible, int length, int width, int xPosition, int yPosition, int eastEntranceX, int eastEntranceY, int southEntranceX, int southEntranceY, int westEntranceX, int westEntranceY, int northEntranceX, int northEntranceY, String[] descriptions)
	{
		myName = name;
		myIsAccessible = isAccessible;
		myLength = length;
		myWidth = width;
		myGrid = new Entity[myLength][myWidth];
		myXPosition = xPosition;
		myYPosition = yPosition;
		myEastEntranceX = eastEntranceX;
		myEastEntranceY = eastEntranceY;
		mySouthEntranceX = southEntranceX;
		mySouthEntranceY = southEntranceY;
		myWestEntranceX = westEntranceX;
		myWestEntranceY = westEntranceY;
		myNorthEntranceX = northEntranceX;
		myNorthEntranceY = northEntranceY;
		myDescriptions = descriptions;
	}

	public Object getGridObject(int x, int y)
	{return myGrid[x][y];}

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

	public int getX()
	{return myXPosition;}

	public int getY()
	{return myYPosition;}

	public double getDistance(Entity entity1, Entity entity2)
	{return (Math.sqrt(Math.pow(entity1.getEntityPoint().getX() - entity2.getEntityPoint().getX(), 2) + 
			Math.pow(entity1.getEntityPoint().getY() - entity2.getEntityPoint().getY(), 2)));}
}
