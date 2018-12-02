package File_format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;

import GIS.Element;
import GIS.Layer;

/**
 * this class will handle of files and save the data. its main purpose is to
 * convert a csv file to kml. sources:
 * 1.https://stackoverflow.com/questions/47183982/converting-csv-file-to-kml
 * 2.https://www.tutorialspoint.com/java/io/file_list.htm
 * 
 * @author Hai Hatan and Bar Goldshtein.
 *
 */
public class Csv2kml {

	public Csv2kml() {

	}

	/**
	 * this function will convert the csv file to a string ArrayList.
	 * 
	 * @param filepath: the path to the file.
	 * @param line:an empty string that we will fill in with lines from the csv file.
	 * @param temp:an ArrayList that we will fill in string lines from the csv file.
	 * @param count:we will need to run two round before we get to useable informtion 
	 * 				that why count must be smaller then 0.
	 * @return temp.
	 */

	public ArrayList<String> csvReader(String filepath) {
        if(!filepath.contains("WigleWifi_")||!filepath.substring(filepath.length()-4).equals("csv")) {
        	
        	return null;
        }
        
		String line = "";
		ArrayList<String> temp = new ArrayList<>();
		int count = 2;
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

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

	static void writeFileKML(Layer a, String fileName) {
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

	/**
	 * this function will convert the csv file into the kml one.
	 * @param FileLocation:where the csv file is.
	 * @param outpotName:how do we want to name the kml file.
	 * @param temp:an arralist that will hold the data from the csv file.
	 * @param list:will represent the layer of the csv file.
	 * 
	 */

	public void Cvs2KmlConverter(String FileLocation, String outpotName) {
		ArrayList<String> temp = csvReader(FileLocation);
		Layer list = new Layer(temp);
		writeFileKML(list, outpotName);
	}

}
