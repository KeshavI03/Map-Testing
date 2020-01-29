
public class Point {
	private double x;
	private double y;
	
	public Point() {
		x=0;
		y=0;
	}
	
	public Point(double inX, double inY) {
		x = inX;
		y = inY;
	}
	
	public double X() {
		return x;
	}
	
	public double Y() {
		return y;
	}
	
	public void setPoint(double inX, double inY) {
		x = inX;
		y = inY;
	}
	
	public double distance(Point p) {
		return Math.sqrt(Math.pow(p.X() - x, 2) + Math.pow(p.Y()-y, 2));
	}
}
