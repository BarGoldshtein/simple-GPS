package Game;

import GIS.GIS_element;
import GIS.Meta_data;
import Geom.Geom_element;
import Geom.Point3D;

public class PacAndFru implements GIS_element {
	Fruit Fruit;
	Packman Pac;
	char type;
	public PacAndFru (String line) {
		try {
		if(line.charAt(0)=='P') {
			this.Pac = new Packman(line);
			this.type = 'P';
		} else if(line.charAt(0) == 'F') {
			this.Fruit = new Fruit(line);
			this.type = 'F';
		} else {
			throw new Exception("the csv is not in a sported format.");
		}
		}catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	public PacAndFru(PacAndFru PnF) {
		if(PnF.getType()==0) {
			this.Pac=new Packman(PnF.Pac);
			this.type='P';
		}else if(PnF.getType()==1) {
			this.Fruit=new Fruit(PnF.Fruit);
			this.type='F';
		}
		
		
		
		
	}
	@Override
	public Geom_element getGeom() {
		if(getType() == 0) {
			return Pac.getGeom();
		} else if (getType()==1) {
			return Fruit.getGeom();
		} else {
			return null;
		}
	}

	@Override
	public Meta_data getData() {
		if(getType() == 0) {
			return Pac.getData();
		} else if (getType()==1) {
			return Fruit.getData();
		} else {
			return null;
		}
	}

	@Override
	public void translate(Point3D vec) {
		if(getType() == 0) {
			this.Pac.Place.add(vec);
		} else if (getType()==1) {
			this.Fruit.Place.add(vec);
		} 

	}	
		
		
	
	public DataPacAndFru getMetaData() {
		if(getType() == 0) {
			return Pac.getDataPnF();
		} else if (getType()==1) {
			return Fruit.getDataPnF();
		} else {
			return null;
		}
	}
	
	public Point3D getPoint3D() {
		if(getType() == 0) {
			return Pac.Place;
		} else if (getType()==1) {
			return Fruit.Place;
		} else {
			return null;
		}
	}
	
	public int getType() {
		if(this.type == 'P') {
			return 0;
		} else if(this.type == 'F') {
			return 1;    
		} else {
			return -1;
		}
	}
}
