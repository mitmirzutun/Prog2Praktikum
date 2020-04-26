package de.hsa.games.fatsquirrel.entity.squirrel;

import de.hsa.games.fatsquirrel.entity.Entity;
import de.hsa.games.fatsquirrel.position.XY;

public class Squirrel extends Entity {
	public Squirrel(long energy,XY pos) {
		setup(false, pos, energy);
	}
	public Squirrel(long energy,long x, long y) {
		setup(false, x, y, energy);
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Squirrel on ");
		sb.append(getPos().toString());
		return sb.toString();
	}
}
