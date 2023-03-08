import java.util.ArrayList;

public class Point 
{
	private double  x, y;
	private boolean visited;
	private ArrayList<Point> points;
	private static int num;
	
	public Point()
	{
		
	}
	
	public Point(double pointX, double pointY)
	{
		x = pointX;
		y = pointY;
		points = new ArrayList<Point>();
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public void addPoint(Point point)
	{
		points.add(point);
		
	}
	public boolean isVisited(Point visit)
	{
		for(int i=0; i<points.size(); i++)
		{
			 
			if(points.get(i).equals(visit))
			{
				visited = true;
			}
		}
		if(visited == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/** get the Euclidean distance between two points */
	public double getDistance(Point other)
	{
		double distance = this.getX() - other.getX();
		distance = distance * distance;
		double distance1 = this.getY() - other.getY();
		distance1 = distance1 * distance1;
		distance = distance + distance1;
		distance = Math.sqrt(distance);
		return distance; 
	}
	
	@Override
	public String toString()
	{
		String s = "";
		s = "(" + this.getX() + " , " + this.getY() + ")"; 
		return s;
	}
}
