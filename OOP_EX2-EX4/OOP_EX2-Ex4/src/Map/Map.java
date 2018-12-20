package Map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.xml.internal.fastinfoset.stax.events.ReadIterator;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;

public class Map {

	Point3D topLeftPoint;
	double scaleMetersWidth;
	double scaleMetersHight;
	double mapDistansWidthMeters;
	double mapDistansHightMeters;


	public Map(Point3D topLeftCornerGpsPoint, double widthDistansMeters, double hightDistansMeters, 
			String imageLocation) {
		try {
			BufferedImage img = ImageIO.read(new File(imageLocation));
			this.topLeftPoint = new Point3D(topLeftCornerGpsPoint.x(), topLeftCornerGpsPoint.y(), 0);
			this.mapDistansWidthMeters = widthDistansMeters;
			this.mapDistansHightMeters = hightDistansMeters;
			this.scaleMetersWidth = img.getWidth() / widthDistansMeters;
			this.scaleMetersHight = img.getHeight() / hightDistansMeters;
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public Pixel getPixelFromGPS(Geom_element geom_element) {
		MyCoords temp = new MyCoords();
		Point3D dist = new Point3D(temp.vector3D(topLeftPoint, (Point3D) geom_element));

		int xVal = (int) Math.abs(dist.x() * scaleMetersWidth);
		int yVal = (int) (dist.y() * scaleMetersHight);

		Pixel pix = new Pixel(xVal, yVal);
		return pix;
	}

	public Point3D getGPSFromPixel(Pixel pix) {
		MyCoords coords = new MyCoords();
		int yVal = pix.getY();
		int xVal = pix.getX();

		double distY = yVal/scaleMetersHight;
		double distX = -(xVal/scaleMetersWidth);

		Point3D vec = new Point3D(distX, distY);
		Point3D toGPS = new Point3D(coords.add(topLeftPoint, vec));

		return toGPS;
	}

	public double[] distanceAndAzimuthOfTwoPixels(Pixel Pix0, Pixel Pix1) {
		MyCoords coords = new MyCoords();
		Point3D Pix0GPS = new Point3D(getGPSFromPixel(Pix0));
		Point3D Pix1GPS = new Point3D(getGPSFromPixel(Pix1));
		double[] temp = new double [3];
		double[] ans = new double [2];
		temp = coords.azimuth_elevation_dist(Pix0GPS, Pix1GPS);
		ans[0] = temp[0]; // azimuth
		ans[1] = temp[2]; // distance
		return ans; // an array with both distance and azimuth between two pixels
	}
}
