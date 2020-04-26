package de.hsa.games.fatsquirrel.entity.squirrel;

import de.hsa.games.fatsquirrel.position.XY;

public class MiniSquirrel extends Squirrel {

	public MiniSquirrel(long energy, long x, long y) {
		super(energy, x, y);
	}
	public MiniSquirrel(long energy, XY pos) {
		super(energy, pos);
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("MiniSquirrel on ");
		sb.append(getPos().toString());
		return sb.toString();
	}

}
