import java.util.ArrayList;

public class Map {
	
	PointObject[] obj = new PointObject[3];
	
	protected double scale = 10;
	protected Point centerLocation = new Point(0,0);
	
	protected int polygonPXLength = 3;
	protected int linePXLength = 2;
	protected int locationRadLength = 5;
	
	public Map() {
		
		obj[0] = new Polygon(5);
		
		obj[0].addPoint(0,0);
		obj[0].addPoint(1,0);
		obj[0].addPoint(1,1);
		obj[0].addPoint(1,2);
		obj[0].addPoint(0,1);
		
		obj[1] = new Line(3);
		
		obj[1].addPoint(2,3);
		obj[1].addPoint(5,3);
		obj[1].addPoint(7,4);
		
		obj[2] = new Location(2,4);
	}
	
	public int length() {
		return obj.length;
	}
}
