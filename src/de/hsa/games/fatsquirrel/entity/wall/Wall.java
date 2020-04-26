package de.hsa.games.fatsquirrel.entity.wall;

import de.hsa.games.fatsquirrel.entity.Entity;
import de.hsa.games.fatsquirrel.position.XY;

public class Wall extends Entity {
	public Wall(long x, long y) {
		setup(true, x,y, -10);
	}
	public Wall(XY pos) {
		setup(true, pos, -10);
	}
	public String toString() {
		return null;
	}

}
