package Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.Layer;
import GIS.Meta_data;
import GIS.Meta_dataList;

public class Game implements GIS_layer {
	ArrayList<GIS_element> FruitsAndPacks;


	public Game(ArrayList<String> temp) {
		try {
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).charAt(0) == 'P') {
					FruitsAndPacks.add(new Packman(temp.get(i)));

				} else if (temp.get(i).charAt(0) == 'F') {
					FruitsAndPacks.add(new Fruit(temp.get(i)));
				} else {
					throw new Exception("the CSV is in a worng format");
				}

			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public int size() {
		int size=FruitsAndPacks.size();
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(FruitsAndPacks.isEmpty()) {
			return true;
		}

		return false ;
	}

	@Override
	public boolean contains(Object o) {
		if(FruitsAndPacks.contains(o)) {
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
		if (FruitsAndPacks.add(e))
			return true;
		return false;
	}

	@Override
	public boolean remove(Object o) {
		if(FruitsAndPacks.remove(o))
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
		if(FruitsAndPacks.containsAll(c))
			return true;
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if(FruitsAndPacks.retainAll(c))
			return true;
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if(FruitsAndPacks.removeAll(c))
			return true;
		return false;
	}

	@Override
	public void clear() {
		FruitsAndPacks.clear();
	}

	@Override
	public Meta_data get_Meta_data() {
		Meta_dataList temp=new Meta_dataList(FruitsAndPacks);
		return temp;
	}
}
