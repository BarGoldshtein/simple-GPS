package File_format;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import GIS.Layer;

public class MultiCSV {
	Csv2kml csv;

	/**
	 * this class will handle of files and save the data. its main purpose is to
	 * read a folder of csv and convert it to kml:
	 * 1.https://stackoverflow.com/questions/47183982/converting-csv-file-to-kml
	 * 2.https://www.tutorialspoint.com/java/io/file_list.htm
	 * 
	 * @author Hai Hatan and Bar Goldshtein.
	 *
	 */
	public MultiCSV(String FolderLocation) {

	}

	public ArrayList<Layer> readFolder(File f2) {
		try {
			ArrayList<Layer> list = new ArrayList<>();
			File[] files = f2.listFiles();
			csv = new Csv2kml();
			for (File temp : files) {
				if (f2.isDirectory()) {
					readFolder(f2.getAbsoluteFile());
				}
				Layer layer = new Layer();
				if (Csv2kml.fileType(temp.getName()) == 0) {
					layer.setLayerType1(csv.csvReader(f2.getAbsolutePath()));
				} else if (Csv2kml.fileType(temp.getName()) == 1) {
					layer.setLayerType2(csv.csvReader(f2.getAbsolutePath()));
				} else if (Csv2kml.fileType(temp.getName()) == -1) {
					throw new Exception("the file is not in a suppsorted type");
				}
				list.add(layer);
			}
			return list;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	public Layer allInOne(ArrayList<Layer> list) {
		Layer allInOne = new Layer();
		csv = new Csv2kml();
		for (int i = 0; i < list.size(); i++) {
			allInOne.addAll(list.get(i));
		}
		return allInOne;
	}

	public void kmlExport(Layer layer, String fileName) {

		Csv2kml.writeFileKML(layer, fileName);

	}

	public void allToOneKml(ArrayList<Layer> list, String fileName) {
		Layer temp = new Layer();
		temp = allInOne(list);
		kmlExport(temp, fileName);
	}
}
