package de.hsa.games.fatsquirrel.entity.unmovable;

import de.hsa.games.fatsquirrel.entity.Entity;
import de.hsa.games.fatsquirrel.position.XY;

public class Unmovable extends Entity {
	public Unmovable(XY pos,long energy) {
		setup(true, pos, energy);
	}
	public Unmovable(int x,int y, long energy) {
		setup(true,x,y,energy);
	}
	public String toString() {
		return "";
	}

}
