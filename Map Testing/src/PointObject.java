
public class PointObject {
	
	protected String attribute;
	protected Point p[];
	public int num = 0;
	
	public PointObject(int length) {
		p = new Point[length];
	}
	
	public void setAttribute(String att) {
		attribute = att;
	}
	
	public String getAttribute() {
		return attribute;
	}
	
	public void addPoint(double x, double y) {
		if(num >= p.length)
			System.out.println("Adding more points than declared");
		else {
			p[num].setPoint(x, y);
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
