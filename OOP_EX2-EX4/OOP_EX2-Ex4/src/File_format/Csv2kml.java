package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Csv2kml {

	public static ArrayList<String> csvReader(String filepath) {

		String csvFile = filepath;
		String line = "";
		ArrayList<String> temp = new ArrayList<>();
		int count = 2;
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {
				if (count == 0) {
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

	public static void main(String[] args) {
		ArrayList<String> test = csvReader("WigleWifi_20171201110209.csv");
		for (int i=0; i<test.size(); i++) {
			System.out.println(test.get(i));
		}
	}
}
