package Path;

import Game.Game;

public class Paths {
	Path[] Paths;

	public Paths(Game game) {
		ShortPathAlgo s = new ShortPathAlgo();
		Paths = new Path[game.getPackmanNum()];
		Paths = s.ShrotPath(game);
	}

}
