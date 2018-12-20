package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class Element2 implements GIS_element {
	Point3D Geom;
	MetaData2 Data;	
	
	public Element2 (String line) {
		String [] temp = line.split(",");
		
		double x = Double.parseDouble(temp[2]);
		double y = Double.parseDouble(temp[3]);
		double z = Double.parseDouble(temp[4]);
		Geom = new Point3D(x, y, z);
		if(temp[0].charAt(0)=='P') {
		Data = new MetaData2(temp[0], temp[1], temp[5], temp[6]);
		} else {
			Data = new MetaData2(temp[0], temp[1], temp[5], "0.00001");
		}
		
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
		this.Geom.add(vec);
	}
	
	public MetaData2 getMetaData() {
		return Data;
	}
	
	public Point3D getPoint3D() {
		return Geom;
	}
}
