import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Path 
{

	private ArrayList<Point> points = new ArrayList();
	private double  minX, minY; //min X and Y values, for setting canvas scale
	private double  maxX, maxY; //maxes
	private int num;
	private int numOfPoints;
	
	/** construct a path from a given file */
	public Path(String fileName) throws IOException
	{
		File text = new File (fileName);
		Scanner s = new Scanner(text);
		numOfPoints = s.nextInt();
		for(int i = numOfPoints; i > 0; i--)
		{
			Double x = s.nextDouble();
			Double y = s.nextDouble();
			Point p = new Point(x,y);
			points.add(p);
		}
		//TODO
	}
	public ArrayList<Point> getPath()
	{
		return points;
	}
	public int getNumPoints()
	{
		return numOfPoints;
	}
	/** returns the distance traveled going point to point, in order given in file */
	public double getDistance()
	{
		double finalDistance = 0.0;
		for(int i = 0; i < points.size()-1; i++)
		{
			double distance = points.get(i).getX() - points.get(i+1).getX();
			distance = distance * distance;
			double distance1 = points.get(i).getY() - points.get(i+1).getY();
			distance1 = distance1 * distance1;
			distance = distance + distance1;
			distance = Math.sqrt(distance);
			finalDistance += distance;
		}
		return finalDistance;		
	}
	public double getMinX()
	{
		if(points.size() > 0)
		{
			minX = points.get(0).getX();
			for(int i = 0; i < points.size()-1; i++)
			{
				if(points.get(i).getX() < minX)
				{
					minX = points.get(i).getX();
				}
			}
		}
		return minX;
	}
	public double getMaxX()
	{
		if(points.size()> 0)
		{	
			maxX = points.get(0).getX();
			for(int i = 0; i < points.size(); i++)
			{
				if(points.get(i).getX() > maxX)
				{
					maxX = points.get(i).getX();
				}
			}
		}
		return maxX;
	}
	public double getMinY()
	{
		if(points.size() > 0)
		{
			minY = points.get(0).getY();
			for(int i = 0; i < points.size(); i++)
			{
				if(points.get(i).getY() < minY)
				{
					minY = points.get(i).getY();
				}
			}
		}
		return minY;
	}
	public double getMaxY()
	{
		if(points.size()> 0)
		{
			maxY = points.get(0).getY();
			for(int i = 0; i < points.size(); i++)
			{
				if(points.get(i).getY() > maxY)
				{
					maxY = points.get(i).getY();
				}
			}
		}
		return maxY;
	}
	public Point getAPoint(int i)
	{
		if(i < points.size())
		{
			Point p = points.get(i);
			return p;
		}
		else
		{
			return null;
		}
	}
	@Override
	public String toString()
	{
		String s = "";
		for(Point x : points)
		{
			s += "( " + x.getX() + "," + x.getY() + ") ,";
		}		
		return s;
	}
}
