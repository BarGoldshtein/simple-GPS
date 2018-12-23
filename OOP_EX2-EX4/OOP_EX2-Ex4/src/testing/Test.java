package testing;

import File_format.Csv2kml;
import File_format.Path2Kml;
import Game.Game;
import Path.Paths;

public class Test {
	
	public static void main(String[] args) {
		Csv2kml csv = new Csv2kml();
		Game g = new Game(csv.csvReader("game_1543685769754.csv"));
		
		Paths p = new Paths(g);
		Path2Kml temp = new Path2Kml(p, "testing all");
	}
	
}
