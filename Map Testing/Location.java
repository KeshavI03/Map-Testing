
public class Location extends PointObject{

	public Location() {
		super(1);
	}
	
	public Location(Point p) {
		super(1);
		super.addPoint(p);
	}
	
	public Location(double x, double y) {
		super(1);
		super.addPoint(x,y);
	}

}
