import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	
	protected Map map;
	protected int height;
	protected int width;
	protected boolean setAntiAlias;
	
	public DrawPanel(int mHeight, int mWidth, boolean alias) {
		
		setOpaque(true);
		setBackground(Color.white);
		
		height = mHeight;
		width = mWidth;
		
		setAntiAlias = alias;
	}
	
	public void setMap(Map m) {
		map = m;
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		if(setAntiAlias) {
			RenderingHints rhints = g2.getRenderingHints();
		 	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}
		
		super.paintComponent(g2); 

		double xScale = width/ map.scale / 2;
		double yScale = height/ map.scale / 2;
		
		for(PointObject o: map.obj) {
			
			if(o instanceof Polygon) {
				g2.setStroke(new BasicStroke(o.getWidth()));
				for(int j = 1; j < o.length(); j++) 
					g2.drawLine((int)((o.getPoint(j).X() + (int)o.getXBias() - (int)map.centLoc.X()) * xScale) + (width/2),
								(int)((o.getPoint(j).Y() + (int)o.getYBias() - (int)map.centLoc.Y()) * yScale) + (width/2),
								(int)((o.getPoint(j-1).X() + (int)o.getXBias() - (int)map.centLoc.X()) * xScale) + (width/2),
								(int)((o.getPoint(j-1).Y() + (int)o.getYBias() -  (int)map.centLoc.Y()) * yScale) + (width/2));
				
				g2.drawLine((int)((o.getPoint(0).X() + (int)o.getXBias() - (int)map.centLoc.X()) * xScale) + (width/2),
							(int)((o.getPoint(0).Y() + (int)o.getYBias() - (int)map.centLoc.Y()) * yScale) + (width/2),
							(int)((o.getPoint(o.length()-1).X() + (int)o.getXBias() - (int)map.centLoc.X()) * xScale) + (width/2),
							(int)((o.getPoint(o.length()-1).Y() + (int)o.getYBias() - (int)map.centLoc.Y()) * yScale) + (width/2));
			}
			
			else if(o instanceof Line) {
				g2.setStroke(new BasicStroke(o.getWidth()));
				for(int j = 1; j < o.length(); j++) 
					g2.drawLine((int)((o.getPoint(j).X() -  (int)map.centLoc.X() + (int)o.getXBias()) * xScale) + (width/2),
								(int)((o.getPoint(j).Y() -  (int)map.centLoc.Y() + (int)o.getYBias()) * yScale) + (width/2),
								(int)((o.getPoint(j-1).X() -  (int)map.centLoc.X() + (int)o.getXBias()) * xScale) + (width/2),
								(int)((o.getPoint(j-1).Y() -  (int)map.centLoc.Y() + (int)o.getYBias()) * yScale) + (width/2));
			}
			
			else if(o instanceof Location) {
				g2.setStroke(new BasicStroke(2));
				g2.drawOval((int)((o.getPoint(0).X() -  (int)map.centLoc.X()  + (int)o.getXBias()) * xScale) + (width/2) - o.getWidth(),
						(int)((o.getPoint(0).Y() - o.getWidth() -  (int)map.centLoc.Y()) * yScale) + (width/2)  + (int)o.getYBias(),
						o.getWidth() * 2, o.getWidth() * 2);
			}
			
		}

	}

}







