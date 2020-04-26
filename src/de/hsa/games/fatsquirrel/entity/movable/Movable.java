package de.hsa.games.fatsquirrel.entity.movable;

import de.hsa.games.fatsquirrel.entity.Entity;
import de.hsa.games.fatsquirrel.position.XY;

public class Movable extends Entity {
	public Movable(XY pos, long energy) {
		setup(true, pos, energy);
	}
	public Movable(int x, int y,long energy) {
		setup(true,x,y,energy);
	}
	public String toString() {
		return null;
	}
}
