package Game;

import Coords.MyCoords;
import GIS.GIS_element;
import GIS.Meta_data;
import Geom.Geom_element;
import Geom.Point3D;

public class Packman implements GIS_element {

Point3D Place;
DataPacAndFru Data;
//the abilty to move...?


	
	
	public Packman(String Str) {
		try {
		String [] Strsplit=Str.split(",");
		double x=Double.parseDouble(Strsplit[2]);
		double y=Double.parseDouble(Strsplit[3]);
		double z=Double.parseDouble(Strsplit[4]);
		Place=new Point3D(x,y,z);
		Data=new DataPacAndFru(Strsplit[0], Strsplit[1], Strsplit[5], Strsplit[6]);
		}
		catch(Exception e) {
			System.err.println(e);
			
		}
	
	}
	
	public Packman(Packman p) {
		this.Place=new Point3D(p.Place);
		String type="";
		type+=p.Data.getType();
		String id="";
		id+=p.Data.getID();
		String sow="";
		sow+=p.Data.getSOW();
		String radius="";
		radius+=p.Data.getRadius();
		this.Data=new DataPacAndFru(type, id, sow, radius);
	}
	
	@Override
	public Geom_element getGeom() {

		return Place;
	}

	@Override
	public Meta_data getData() {

		return Data;
	}

	@Override
	public void translate(Point3D vec) {
		
		this.Place.add(vec);

	}
	
	public DataPacAndFru getDataPnF(){
		return Data;
		
	}

	public Point3D getPlace() {
		return Place;
	}
	
	public double Orientation(Point3D dest) {
		MyCoords coords = new MyCoords();
		double [] arr = new double[3];
		arr = coords.azimuth_elevation_dist(getPlace(), dest);
		return arr[0];
	}
}
