package Game;

import GIS.Meta_data;
import Geom.Point3D;

public class DataPacAndFru implements Meta_data {
	char Type;
	int ID;
	double SOW;//Speed or Weight
	double Radius;
	
	public DataPacAndFru(String Type, String ID, String SOW, String Radius) {
		try {
		this.Type = Type.charAt(0);
		this.ID=Integer.parseInt(ID);
		this.SOW = Double.parseDouble(SOW);
		this.Radius = Double.parseDouble(Radius);
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
	
	
	@Override
	public long getUTC() {
		return 0;
	}

	@Override
	public Point3D get_Orientation() {	
		return null;
	}


	public char getType() {
		return Type;
	}


	public int getID() {
		return ID;
	}


	public double getSOW() {
		return SOW;
	}


	public double getRadius() {
		return Radius;
	}

}
