package Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import File_format.Csv2kml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.Layer;
import GIS.Meta_data;
import GIS.Meta_dataList;
import Geom.Point3D;

public class Game implements GIS_layer {
	ArrayList<PacAndFru> FruitsAndPacks;
	int PackmanNum = 0;
	int FruitsNum = 0;


	public Game(ArrayList<String> temp) {
		FruitsAndPacks = new ArrayList<>();
		try {
			for (int i = 0; i < temp.size(); i++) {

				FruitsAndPacks.add(new PacAndFru(temp.get(i)));

				if (FruitsAndPacks.get(i).getType() == 0) {
					PackmanNum++;
				}
				else if (FruitsAndPacks.get(i).getType() == 1)
					FruitsNum++;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/*public Game(Game g) {
		for(int i=0; i<g.FruitsAndPacks.size(); i++) {
			g.FruitsAndPacks.get(i).
		}
	}*/

	@Override
	public int size() {
		int size = FruitsAndPacks.size();
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (FruitsAndPacks.isEmpty()) {
			return true;
		}

		return false;
	}

	@Override
	public boolean contains(Object o) {
		if (FruitsAndPacks.contains(o)) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<GIS_element> iterator() {
		Iterator<GIS_element> it = FruitsAndPacks.iterator();
		return it;
	}

	@Override
	public Object[] toArray() {
		return FruitsAndPacks.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return FruitsAndPacks.toArray(a);
	}

	@Override
	public boolean add(GIS_element e) {
		if (FruitsAndPacks.add((PacAndFru) e))
			return true;
		return false;
	}

	@Override
	public boolean remove(Object o) {
		if (FruitsAndPacks.remove(o))
			return true;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if (FruitsAndPacks.containsAll(c))
			return true;
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> c) {
		if (FruitsAndPacks.containsAll(c))
			return true;
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if (FruitsAndPacks.retainAll(c))
			return true;
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if (FruitsAndPacks.removeAll(c))
			return true;
		return false;
	}

	@Override
	public void clear() {
		FruitsAndPacks.clear();
	}

	@Override
	public Meta_data get_Meta_data() {
		Meta_dataList temp = new Meta_dataList(FruitsAndPacks.);
		return temp;
	}

	
	public int getPackmanNum() {
		return PackmanNum;
	}

	public int getFruitsNum() {
		return FruitsNum;
	}
	
	
	public ArrayList<PacAndFru> getFruitsAndPacks() {
		return FruitsAndPacks;
	}

	public void csvWriter(String name, Game game) throws FileNotFoundException {
		ArrayList<PacAndFru> PnF = new ArrayList<>(game.FruitsAndPacks);
		PrintWriter pw = new PrintWriter(new File(name+".csv"));
		StringBuilder sb = new StringBuilder();
		sb.append("Type");
		sb.append(',');
		sb.append("ID");
		sb.append(',');
		sb.append("Lat");
		sb.append(',');
		sb.append("Lon");
		sb.append(',');
		sb.append("Alt");
		sb.append(',');
		sb.append("Speed/Weight");
		sb.append(',');
		sb.append("Radius");
		sb.append(',');
		sb.append(PackmanNum);
		sb.append(',');
		sb.append(FruitsNum);
		sb.append(',');
		sb.append('\n');
		
//		PackmanNum = 0; // TODO check if need to clear
//		FruitsNum = 0;
		
		
		for (int i = 0; i < PnF.size(); i++) {


			sb.append(PnF.get(i).type);
			sb.append(',');
			
			if(PnF.get(i).getType()==0) {
				sb.append(PnF.get(i).Pac.getDataPnF().getID());
				sb.append(',');
				sb.append(PnF.get(i).Pac.getPlace().x());
				sb.append(',');
				sb.append(PnF.get(i).Pac.getPlace().y());
				sb.append(',');
				sb.append(PnF.get(i).Pac.getPlace().z());
				sb.append(',');
				sb.append(PnF.get(i).Pac.getDataPnF().getSOW());
				sb.append(',');
				sb.append(PnF.get(i).Pac.getDataPnF().getRadius());
				sb.append(',');
				sb.append('\n');
				
			}
			else if(PnF.get(i).getType()==1) {
				sb.append(PnF.get(i).Fruit.getDataPnF().getID());
				sb.append(',');
				sb.append(PnF.get(i).Fruit.getPlace().x());
				sb.append(',');
				sb.append(PnF.get(i).Fruit.getPlace().y());
				sb.append(',');
				sb.append(PnF.get(i).Fruit.getPlace().z());
				sb.append(',');
				sb.append(PnF.get(i).Fruit.getDataPnF().getSOW());
				sb.append(',');
				sb.append('\n');
			}		
		}
		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");
	}
	public static void main(String[] args) {
		Csv2kml csv = new Csv2kml();
		Game game = new Game(csv.csvReader("game_1543684662657.csv"));
		try {
		game.csvWriter("test2", game);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	

}
