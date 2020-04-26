package de.hsa.games.fatsquirrel.entity.squirrel;

import de.hsa.games.fatsquirrel.position.XY;

public class MasterSquirrel extends Squirrel {
	public MasterSquirrel(long x, long y) {
		super(1000, x, y);
	}
	public MasterSquirrel(XY pos) {
		super(1000,pos);
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("MasterSquirrel on ");
		sb.append(getPos().toString());
		return sb.toString();
	}
}
