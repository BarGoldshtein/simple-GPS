package Path;

import java.util.LinkedList;


import Game.PacAndFru;

public class Path {

	LinkedList<PacAndFru> Path;
	double pathLength;
	
	public Path(LinkedList<PacAndFru> Path) {
		Path = new LinkedList<PacAndFru>();
		this.Path = Path;
		pathLength = this.pathLength();
	}
	
	public Path() {
		Path = new LinkedList<PacAndFru>();
	}
	public double pathLength() {
		double ans = 0;
		for (int i = 0; i < Path.size()-1; i++) {
			ans += Path.get(i).getPoint3D().distance2D(Path.get(i+1).getPoint3D());
		}
		return ans;
	}

	public LinkedList<PacAndFru> getPath() {
		return Path;
	}
	
	public double getPathLength() {
		return pathLength;
	}
	
	public void add(PacAndFru pnf) {
		Path.add(pnf);
		this.pathLength=pathLength();
	}
}
