package game;

public class Point {

	private int myX;
	private int myY;
	
	public Point(int x, int y)
	{
		myX = x;
		myY = y;
	}
	
	public Point(String pointString)
	{
		myX = Integer.parseInt(pointString.substring(pointString.indexOf(" ") + 1, pointString.indexOf(",")));
		myY = Integer.parseInt(pointString.substring(pointString.indexOf(",") + 1));
	}
	
	public void setX(int x)
	{
		myX = x;
	}
	
	public int getX()
	{
		return myX;
	}
	
	public void setY(int y)
	{
		myY = y;
	}
	
	public int getY()
	{
		return myY;
	}
}
