package File_format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Coords.MyCoords;

import java.io.File;

import GIS.Element;
import GIS.Layer;
import Geom.Point3D;

public class Csv2kml {

	public static ArrayList<String> csvReader(String filepath) {

		String csvFile = filepath;
		String line = "";
		ArrayList<String> temp = new ArrayList<>();
		int count = 2;
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {
				if (count <= 0) {
					// use comma as separator
					temp.add(line);
				} else {
					count--;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}

	static void writeFileKML(Layer a, String fileName) { // https://stackoverflow.com/questions/47183982/converting-csv-file-to-kml
		ArrayList<String> content = new ArrayList<String>();
		String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n <Document>\r\n" + "";
		content.add(kmlstart);

		String kmlend = " </Document>\r\n" + " </kml>";
		try {
			FileWriter fw = new FileWriter(fileName + ".kml");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 1; i < a.size(); i++) {
				Element s = (Element) a.get(i);
				String kmlelement = "<Placemark>\n" + "<name>" + s.gatMetaData().getSSID() + "</name>\n" + "<Point>\n"
						+ "<coordinates>" + s.getPoint3D().y() + ", " + s.getPoint3D().x() + "</coordinates>"
						+ "</Point>\n" + "</Placemark>\n";
				content.add(kmlelement);
			}

			content.add(kmlend);
			String csv = content.toString().replaceAll(",", "").replace("[", "").replace("]", "");
			bw.write(csv);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void Cvs2KmlConverter(String FileLocation, String outpotName) {
		ArrayList<String> temp = csvReader("WigleWifi_20171201110209.csv");
		Layer list = new Layer(temp);
		writeFileKML(list, outpotName);
	}

	public static void CvsFolder(String FolderLocation) {// https://www.tutorialspoint.com/java/io/file_list.htm
		File f = null;
		String[] paths;
		ArrayList<String> temp = new ArrayList<>();
		try {

			// create new file
			f = new File(FolderLocation);

			// array of files and directory
			paths = f.list();

			// for each name in the path array
			for (String path:paths) {
				temp.addAll(csvReader(FolderLocation+ "\\" + path));
			}

			Layer list = new Layer(temp);
			writeFileKML(list, "all");

		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Point3D a = new Point3D(2, 2, 8);
		Point3D b = new Point3D(4, 4, 6);
		
		MyCoords t = new MyCoords();
		double [] test =t.azimuth_elevation_dist(a, b);
		
		System.out.println(test[1]);
		}
}
