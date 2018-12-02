package GIS;

import java.util.ArrayList;

import Geom.Point3D;

public class Meta_dataList implements Meta_data {
	ArrayList <Meta_data> MData; 
	
	public Meta_dataList() {
		MData=new ArrayList<>();
	}
	
	public Meta_dataList(ArrayList<GIS_element> list) {
	
		if(!list.isEmpty()) {
			MData=new ArrayList<>();
			for(int i=0; i<list.size(); i++) {
				MData.add(list.get(i).getData());
			}
		}
		
	}
	
	@Override
	public long getUTC() {
		
		return 0;
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
