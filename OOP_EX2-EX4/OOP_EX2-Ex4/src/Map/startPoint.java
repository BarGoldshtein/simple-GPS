package Map;

import java.util.ArrayList;

import javax.swing.JFrame;

import File_format.Csv2kml;
import GIS.Layer;
import Geom.Point3D;

public class startPoint {

	public static void main(String[] args) {
//		Csv2kml csv = new Csv2kml();
//		ArrayList<String> E2 = new ArrayList<>();
		Point3D TL = new Point3D(32.105624937, 35.2024151733);
//		E2 = csv.csvReader("game_1543684662657.csv");
//		Layer list = new Layer();
//		list.setLayerType2(E2);
//		Pixel[] dot = new Pixel[1];
//		Map m = new Map(TL, 950, 420, "Ariel1.png");
//		for (int i = 0; i < dot.length; i++) {
//			dot[i] = new Pixel(m.getPixelFromGPS(list.get(i).getGeom()));
//	}
//		
//		JFrame frame = new JFrame();
//		
//		frame.setSize(1920,1080);
//		
//		PaintAll temp = new PaintAll(dot, "Ariel1.png");
//
//		frame.add(temp);
//
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Map m = new Map(TL, 980, 420, "Ariel1.png");
		Pixel [] dot = new Pixel[1];
		for (int i = 0; i < dot.length; i++) {
			dot[i] = new Pixel(m.getPixelFromGPS(new Point3D(32.1049413, 35.20511639)));
		}
		JFrame frame = new JFrame();
		frame.setSize(1920,1080);
		PaintAll temp = new PaintAll(dot, "Ariel1.png");
		frame.add(temp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Point3D t = new Point3D(m.getGPSFromPixel(dot[0]));
		
		System.out.println(t.toString());
	}
}
