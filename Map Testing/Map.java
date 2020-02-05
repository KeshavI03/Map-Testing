import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
	
	PointObject[] obj;
	
	protected int numObjDec = 0;
	
	protected double scale = 2000;
	protected Point centLoc = new Point(500,500);
	
	public Map(int size) throws FileNotFoundException {
		
		obj = new PointObject[size];
		loadObject("indiana", "Polygon", -150 , 0, 1);
		loadObject("ohio", "Polygon", 249 , -78, 1);
		loadObject("pennsylvania", "Polygon", 873 , -229, 1);
		loadObject("wvirginia", "Polygon", 249 , -78, 1);

	}
	
	public void loadObject(String path, String type, double xBias, double yBias, int drawWidth) throws FileNotFoundException {
		Scanner scanNumLines = new Scanner(new File("src\\Vec Files\\" + path + ".txt"));
		Scanner vectorIn = new Scanner(new File("src\\Vec Files\\" + path + ".txt"));
		
		int numLines = 0;
		while(scanNumLines.hasNext()) {
			scanNumLines.nextLine();
			numLines++;
		}
		
		scanNumLines.close();
		
		String temp;
		
		if(type.equals("Polygon")) {
			obj[numObjDec] = new Polygon(numLines);
		}
		else if(type.equals("Line")) {
			obj[numObjDec] = new Line(numLines);
		}
		else {
			temp = vectorIn.nextLine();
			obj[numObjDec] = new Location(Double.parseDouble(temp.split(",", 2)[0]),Double.parseDouble(temp.split(",", 2)[1]));
			obj[numObjDec].setLineWidth(drawWidth);
			obj[numObjDec].setXBias(xBias);
			obj[numObjDec].setYBias(yBias);
			vectorIn.close();
			return;
		}
		obj[numObjDec].setLineWidth(drawWidth);
		obj[numObjDec].setXBias(xBias);
		obj[numObjDec].setYBias(yBias);
		while(vectorIn.hasNext()) {
			temp = vectorIn.nextLine();
			obj[numObjDec].addPoint(Double.parseDouble(temp.split(",", 2)[0]),Double.parseDouble(temp.split(",", 2)[1]));
		}
		vectorIn.close();
		numObjDec++;
	}
	
	public int length() {
		return obj.length;
	}
}
