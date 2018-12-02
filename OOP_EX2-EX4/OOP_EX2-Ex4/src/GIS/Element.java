package GIS;

import Geom.Geom_element;
import Geom.Point3D;
/**
 * this class will hold the Point3D and the MetaData of a csv file.
 * @author Hai Hatan and Bar Goldshtein.
 *
 */
public class Element implements GIS_element {
	Point3D Geom;
	MetaData Data;
	/**
	 * this function will act as an constructor of the new Point3D and the MetaData we take from the csv file line.
	 * @param line:the line from the csv file.
	 * @param Geom: the new Point3D.
	 * @param Data: the new MetaData.
	 */
	public Element (String line) {
		String [] temp = line.split(",");
		
		double x = Double.parseDouble(temp[6]);
		double y = Double.parseDouble(temp[7]);
		double z = Double.parseDouble(temp[8]);
		Geom = new Point3D(x, y, z);
		
		
		Data = new MetaData(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[9], 
				temp[10]);
		
		
	}
	
	/**
	 * the function will give us the value of the geom.
	 */

	@Override
	public Geom_element getGeom() {
		return Geom;
	}
	
	
	/**
	 * this function will get the data value of the MetaData.
	 */
	@Override
	public Meta_data getData() {
		return Data;
	}
	
	
	/**
	 * will give us the Point3D after we change it with the vector.
	 */
	@Override
	public void translate(Point3D vec) {
		this.Geom.add(vec);
		
	}
    
	/**
	 * this function will get the data value of the MetaData.
	 * this allow us to use the function of MetaData
	 */
	public MetaData gatMetaData() {	
		return Data;
	}
	/**
	 * the function will give us the value of the geom(Point3D).
	 */

	public Point3D getPoint3D() {
		return Geom;
	}
}
