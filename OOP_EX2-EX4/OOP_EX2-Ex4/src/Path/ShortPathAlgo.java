package Path;

import java.util.ArrayList;

import Game.Game;
import Game.PacAndFru;

public class ShortPathAlgo {

	public ShortPathAlgo(){
		
	}
	
	public Path[] ShrotPath(Game g) {
		Path [] routes = new Path[g.getPackmanNum()];
		for (int i = 0; i<routes.length; i++) {
			routes[i] = new Path();
		}
		ArrayList<PacAndFru> pacs = new ArrayList<>();
		ArrayList<PacAndFru> fru = new ArrayList<>();
		int flag=0;
		for(int i=0; i<g.size(); i++) {
			if(g.getFruitsAndPacks().get(i).getType()==0) {
				pacs.add(g.getFruitsAndPacks().get(i));
				routes[flag].getPath().add(g.getFruitsAndPacks().get(i));
				flag++;
			} else if (g.getFruitsAndPacks().get(i).getType()==1) {
				fru.add(g.getFruitsAndPacks().get(i));
			}
		}
		
		while(!fru.isEmpty()) {
			for (int i=0; i<pacs.size(); i++) {
				double dist=Double.MAX_VALUE;
				int theClosest=0;
				for (int j=0; j<fru.size(); j++) {
					if(dist>pacs.get(i).getPoint3D().distance2D(fru.get(j).getPoint3D())) {
						dist=pacs.get(i).getPoint3D().distance2D(fru.get(j).getPoint3D());
						theClosest=j;
					}
				}
				
				routes[i].add(fru.get(theClosest));
				pacs.set(i, fru.get(theClosest));
				fru.remove(theClosest);
				if(fru.isEmpty()) {
					break;
				}
			}
		}
		return routes;
	}
	
}
