
public class PointObject {
	
	protected String attribute;
	protected Point p[];
	private int num = 0;
	private PointObject link;
	protected int drawWidth = 1;
	protected double xBias = 0;
	protected double yBias = 0;
	
	public PointObject(int length) {
		p = new Point[length];
	}
	
	public int length() {
		return num;
	}
	
	public void setLineWidth(int width) {
		drawWidth = width;
	}
	
	public void setXBias(double shift) {
		xBias = shift;
	}
	
	public void setYBias(double shift) {
		yBias = shift;
	}
	
	public double getXBias() {
		return xBias;
	}
	
	public double getYBias() {
		return yBias;
	}
	
	public int getWidth() {
		return drawWidth;
	}
	
	public void setLink(PointObject l) {
		link = l;
	}
	
	public PointObject getLink() {
		return link;
	}
	
	public void setAttribute(String att) {
		attribute = att;
	}
	
	public String getAttribute() {
		return attribute;
	}
	
	public void addPoint(Point point) {
		if(num >= p.length)
			System.out.println("Adding more points than declared");
		else {
			p[num].setPoint(point.X(), point.Y());
			num++;
		}
			
	}
	
	public void addPoint(double x, double y) {
		if(num >= p.length)
			System.out.println("Adding more points than declared");
		else {
			p[num] = new Point(x, y);
			num++;
		}
			
	}
	
	public Point getPoint(int index) {
		if(index >= p.length) {
			System.out.println("Out of Index");
			return null;
		}
		else
			return p[index];
	}
}
