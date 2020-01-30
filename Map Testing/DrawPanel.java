import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	
	protected Map map;
	protected int height;
	protected int width;
	
	public DrawPanel(int mHeight, int mWidth) {
		
		setOpaque(true);
		setBackground(Color.white);
		
		height = mHeight;
		width = mWidth;
		
	}
	
	public void setMap(Map m) {
		map = m;
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2); 
//        g2.setStroke(new BasicStroke(10));
//        g2.drawLine(0, 0, 100, 100);
		double xScale = width/ map.scale / 2;
		double yScale = height/ map.scale / 2;
		
		for(PointObject o: map.obj) {
			
			if(o instanceof Polygon) {
				g2.setStroke(new BasicStroke(map.polygonPXLength));
				for(int j = 1; j < o.length(); j++) 
					g2.drawLine((int)(o.getPoint(j).X() * xScale) + (width/2), (int)(o.getPoint(j).Y() * yScale) + (width/2),
								(int)(o.getPoint(j-1).X() * xScale) + (width/2), (int)(o.getPoint(j-1).Y() * yScale) + (width/2));
				
				g2.drawLine((int)(o.getPoint(0).X() * xScale) + (width/2), (int)(o.getPoint(0).Y() * yScale) + (width/2),
						(int)(o.getPoint(o.length()-1).X() * xScale) + (width/2), (int)(o.getPoint(o.length()-1).Y() * yScale) + (width/2));
			}
			
			else if(o instanceof Line) {
				g2.setStroke(new BasicStroke(map.linePXLength));
				for(int j = 1; j < o.length(); j++) 
					g2.drawLine((int)(o.getPoint(j).X() * xScale) + (width/2), (int)(o.getPoint(j).Y() * yScale) + (width/2),
								(int)(o.getPoint(j-1).X() * xScale) + (width/2), (int)(o.getPoint(j-1).Y() * yScale) + (width/2));
			}
			
			else if(o instanceof Location) {
				g2.drawOval((int)(o.getPoint(0).X() * xScale) + (width/2) - map.locationRadLength, (int)(o.getPoint(0).Y() * yScale) + (width/2) - map.locationRadLength,
						map.locationRadLength * 2, map.locationRadLength * 2);
			}
			
		}

	}

}







