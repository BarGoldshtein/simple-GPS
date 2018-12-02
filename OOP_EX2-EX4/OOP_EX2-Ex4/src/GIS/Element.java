package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class Element implements GIS_element {
	Point3D Geom;
	MetaData Data;
	
	public Element (String line) {
		String [] temp = line.split(",");
		
		double x = Double.parseDouble(temp[6]);
		double y = Double.parseDouble(temp[7]);
		double z = Double.parseDouble(temp[8]);
		Geom = new Point3D(x, y, z);
		
		
		Data = new MetaData(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[9], 
				temp[10]);
		
		
	}

	@Override
	public Geom_element getGeom() {
		return Geom;
	}
	
	
	
	@Override
	public Meta_data getData() {
		return Data;
	}
	
	
	
	@Override
	public void translate(Point3D vec) {
		
	}

	public MetaData gatMetaData() {	
		return Data;
	}
	
	public Point3D getPoint3D() {
		return Geom;
	}
}
