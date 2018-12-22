package Game;

import GIS.GIS_element;
import GIS.Meta_data;
import Geom.Geom_element;
import Geom.Point3D;

public class Fruit implements GIS_element {
	Point3D Place;
	DataPacAndFru Data;

	public Fruit(String Str) {
		
		try {
			String [] Strsplit=Str.split(",");
			double x=Double.parseDouble(Strsplit[2]);
			double y=Double.parseDouble(Strsplit[3]);
			double z=Double.parseDouble(Strsplit[4]);
			Place=new Point3D(x,y,z);
			Data=new DataPacAndFru(Strsplit[0], Strsplit[1], Strsplit[5], "0");
			}
			catch(Exception e) {
				System.err.println(e);
				
			}
		
		}
	
	 public Fruit(Fruit f) {
		 this.Place=new Point3D(f.Place);
			String type="";
			type+=f.Data.getType();
			String id="";
			id+=f.Data.getID();
			String sow="";
			sow+=f.Data.getSOW();
			String radius="";
			radius+=f.Data.getRadius();
			this.Data=new DataPacAndFru(type, id, sow, radius);
		}
	
	
	

	@Override
	public Geom_element getGeom() {

		return Place;
	}

	public Point3D getPlace() {
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
}
