package Game;

import GIS.GIS_element;
import GIS.Meta_data;
import Geom.Geom_element;
import Geom.Point3D;

public class PacAndFru implements GIS_element {
	Point3D Geom;
	DataPacAndFru Data;	
	
	public PacAndFru (String line) {
		String [] temp = line.split(",");
		
		double x = Double.parseDouble(temp[2]);
		double y = Double.parseDouble(temp[3]);
		double z = Double.parseDouble(temp[4]);
		Geom = new Point3D(x, y, 0);
		if(temp[0].charAt(0)=='P') {
		Data = new DataPacAndFru(temp[0], temp[1], temp[5], temp[6]);
		} else {
			Data = new DataPacAndFru(temp[0], temp[1], temp[5], "0");
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
	
	public DataPacAndFru getMetaData() {
		return Data;
	}
	
	public Point3D getPoint3D() {
		return Geom;
	}
}
