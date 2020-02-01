import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
	
	PointObject[] obj;
	
	protected int numObjDec = 0;
	
	protected double scale = 500;
	protected Point centLoc = new Point(200,200);
	
	public Map(int size) throws FileNotFoundException {
		
		obj = new PointObject[size];
		loadMap("indiana", "Polygon", 3);
		loadMap("point", "Location", 1);

	}
	
	public void loadMap(String path, String type, int drawWidth) throws FileNotFoundException {
		Scanner vectorIn = new Scanner(new File("src\\Vec Files\\" + path + ".txt"));
		String temp;
		
		if(type.equals("Polygon")) {
			obj[numObjDec] = new Polygon(267);
		}
		else if(type.equals("Line")) {
			obj[numObjDec] = new Line(267);
		}
		else {
			temp = vectorIn.nextLine();
			obj[numObjDec] = new Location(Double.parseDouble(temp.split(",", 2)[0]),Double.parseDouble(temp.split(",", 2)[1]));
			obj[numObjDec].setLineWidth(drawWidth); 
			vectorIn.close();
			return;
		}
		obj[numObjDec].setLineWidth(drawWidth);
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
