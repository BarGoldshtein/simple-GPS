package File_format;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import GIS.Element;
import Game.PacAndFru;
import Path.Paths;

public class Path2Kml {

	public Path2Kml(Paths p, String fileName) {

		ArrayList<String> content = new ArrayList<String>();
		String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n <Document>\r\n" + "";
		content.add(kmlstart);

		String kmlend = "</Document>\r\n" + "</kml>";
		try {
			FileWriter fw = new FileWriter(fileName + ".kml");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < p.size(); i++) {
				for (int j = 0; j < p.get(i).size(); j++) {
					PacAndFru pnf = p.get(i).getPath().get(j);
					String kmlelement = "<Placemark>\n" + "<name>" + "path " + (i + 1) + " part " + (j + 1)
							+ "</name>\n" + "<Point>\n" + "<coordinates>" + pnf.getPoint3D().y() + " "
							+ pnf.getPoint3D().x() + "</coordinates>" + "</Point>\n" + "</Placemark>\n";
					content.add(kmlelement);
				}
			}
			String kmlelement = "<Placemark>\n" + "<LineString>\n" + "<extrude>1</extrude>\n"
					+ "<tessellate>1</tessellate>\n" + "<altitudeMode>absolute</altitudeMode>\n" + "<coordinates>";
			content.add(kmlelement);
			for (int i = 0; i < p.size(); i++) {
				for (int j = 0; j < p.get(i).size() - 1; j++) {
					PacAndFru pnf = p.get(i).getPath().get(j);
					PacAndFru pnfNext = p.get(i).getPath().get(j + 1);
					String coords = pnf.getPoint3D().y() + ", " + pnf.getPoint3D().x() + " "+ 0 + "\n"  + pnfNext.getPoint3D().y()+ " "
							+ pnfNext.getPoint3D().x()+ " "+ 0 + "\n";
					content.add(coords);
				}
			}
			String endPath = "</coordinates>\n" + "</LineString>\n" + "</Placemark>\n";
			content.add(endPath);
			content.add(kmlend);
			String csv = content.toString().replace("[", "").replace("]", "");
			bw.write(csv);
			bw.close();
			System.out.println("done!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
