import java.io.IOException;
import java.util.ArrayList;

public class GreedyPath extends Path{
	
	private ArrayList<Point> greedyPath = new ArrayList();
	private ArrayList<Point> tempArray = new ArrayList();

	
	public GreedyPath(String file) throws IOException
	{
		super(file);
		tempArray = super.getPath();
		findPath();
	}
	
	private void findPath()
	{
		
		greedyPath.add(tempArray.get(0));
		
		int index = 0;
		for(int i = 0; i < tempArray.size()-1; i++)
		{
			double s = tempArray.get(i).getDistance(tempArray.get(i+1));

			for(int j = i + 1; j < tempArray.size() ; j++)
			{
				double dis = tempArray.get(i).getDistance(tempArray.get(j));
				boolean isV = tempArray.get(j).isVisited(tempArray.get(j));
				if (s > dis && isV == false)
				{
					index = j;
					Point sw = tempArray.get(index);
					tempArray.set(index, tempArray.get(i+1));

					tempArray.set(i+1, sw);

					s=dis;
					
				}
			}
			
			greedyPath.add(tempArray.get(i+1));
		}
		double d = getDistance();
	}
	@Override
	public double getDistance()
	{
		double finalDistance = 0.0;
		for(int i = 0; i < greedyPath.size()-1; i++)
		{
			double distance = greedyPath.get(i).getX() - greedyPath.get(i+1).getX();
			distance = distance * distance;
			double distance1 = greedyPath.get(i).getY() - greedyPath.get(i+1).getY();
			distance1 = distance1 * distance1;
			distance = distance + distance1;
			distance = Math.sqrt(distance);
			finalDistance += distance;
		}
		return finalDistance;	
	}
	
	@Override
	public Point getAPoint(int i)
	{
		Point p = greedyPath.get(i);
		return p;
	}

	@Override
	public String toString()
	{
		String s = "";
		for(Point x : greedyPath)
		{
			s += "( " + x.getX() + "," + x.getY() + ") ,";
		}		
		return s;
	}
}
