package de.hsa.games.fatsquirrel.entity.unmovable.wall;

import de.hsa.games.fatsquirrel.entity.Entity;
import de.hsa.games.fatsquirrel.entity.unmovable.Unmovable;
import de.hsa.games.fatsquirrel.position.XY;

public class Wall extends Unmovable {
	public Wall(int x, int y) {
		super(x,y, -10);
	}
	public Wall(XY pos) {
		super(pos, -10);
	}
	public String toString() {
		return null;
	}

}
