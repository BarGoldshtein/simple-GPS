package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Coords.MyCoords;
import Geom.Point3D;

class MyCoordsTest {


	@Test
	void testAdd() {
		Point3D p= new Point3D(32.103315,35.209039, 670 );
		Point3D v= new Point3D(3337.6989921,-359.2492069, -20 );
		Point3D ans= new Point3D(32.106352,35.205225, 650 );
		MyCoords test = new MyCoords();
		Point3D trueans=test.add(p, v);
	    assertTrue(Math.abs(trueans.x()-ans.x())<0.1);
	    assertTrue(Math.abs(trueans.y()-ans.y())<0.1);
	    assertTrue(Math.abs(trueans.z()-ans.z())<0.1);
	}

	@Test
	void testDistance3d() {
		MyCoords test = new MyCoords();
		Point3D p0= new Point3D(32.103315,35.209039, 670 );
		Point3D p1= new Point3D(32.106352,35.205225, 650 );
		double dist = test.distance3d(p0, p1);
		double theAns = 493.052;		
		assertTrue(Math.abs(dist-theAns)<5);
	}
	
	
	@Test
	void testAzimuth_elevation_dist() {
		MyCoords test = new MyCoords();
		Point3D p0= new Point3D(32.103315,35.209039, 670 );
		Point3D p1= new Point3D(32.106352,35.205225, 650 );
		double [] AED = test.azimuth_elevation_dist(p0, p1);
		 
		assertTrue(Math.abs(AED[0]-313.23)<0.01);
	}
	
	@Test
	void testIsValid_GPS_Point() {
		MyCoords test = new MyCoords();
		Point3D p0= new Point3D(32.103315,35.209039, 670 );
		Point3D noGps = new Point3D(5,5,-600);
		
		assertTrue(test.isValid_GPS_Point(p0));
		assertFalse(test.isValid_GPS_Point(noGps));
	}

}
