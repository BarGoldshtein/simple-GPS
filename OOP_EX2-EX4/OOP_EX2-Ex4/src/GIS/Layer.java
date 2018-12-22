package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * this class will hold an array of Elements.
 * @author Hai Hatan and Bar Goldshtein.
 *
 */
public class Layer implements GIS_layer {
	
	ArrayList<GIS_element> list;
    /**
     * this is the basic constructor for layer. 
     * @param str:the csv string.
     * @param list: the new arraylist that will hold the elements.
     */
	public Layer(ArrayList<String> str) {
		list = new ArrayList<>();
		for (int i = 0; i < str.size(); i++) {
			list.add(new Element(str.get(i)));
		}
	}
	

	
	
    /**
     * this function will add a new gis element to the list.
     * @param arg0: the gis element we going to add.
     * @return true if we sucsess to add or flase if we didnt.
     */
	@Override
	public boolean add(GIS_element arg0) {
		if (!list.contains(arg0)) {
			list.add(arg0);
			return true;
		}
		return false;
	}
    /**
     * this function will add a collection of new gis element to the list.
     * 
     */
	@Override
	public boolean addAll(Collection<? extends GIS_element> arg0) {
		if (arg0.isEmpty()) {
			Element[] arr = (Element[]) arg0.toArray();
			for (int i = 0; i < arr.length; i++) {
				add(arr[i]);
			}
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		list.clear();
	}
    /** 
     * this function return true if the list contains the object arg0.
     */
	@Override
	public boolean contains(Object arg0) {

		return list.contains(arg0);

	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		if (!arg0.isEmpty()) {
			Element[] arr = (Element[]) arg0.toArray();
			for (int i = 0; i < arr.length; i++) {
				if (!list.contains(arr[i])) {
					return false;
				}
			}
			return true;
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Iterator<GIS_element> iterator() {
		Iterator<GIS_element> itr = list.iterator();
		return itr;
	}

	@Override
	public boolean remove(Object arg0) {
		if (contains(arg0)) {
			list.remove(arg0);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		if (!arg0.isEmpty()) {
			Element[] arr = (Element[]) arg0.toArray();
			boolean flag = true;
			for (int i = 0; i < arr.length; i++) {
				if (!remove(arr[i])) {
					flag = false;
				}
			}
			return flag;
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return list.retainAll(arg0);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Object[] toArray() {
		Element [] temp = (Element[]) list.toArray();
		return temp;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		
		return list.toArray(arg0);
	}

	@Override
	public Meta_data get_Meta_data() {
		Meta_dataList temp = new Meta_dataList(list);
		
		return temp;
	}
	
	public GIS_element get(int i) {
		return list.get(i);
	}
}
