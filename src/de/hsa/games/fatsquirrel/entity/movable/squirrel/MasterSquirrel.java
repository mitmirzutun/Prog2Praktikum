package de.hsa.games.fatsquirrel.entity.movable.squirrel;

import de.hsa.games.fatsquirrel.entity.movable.Movable;
import de.hsa.games.fatsquirrel.position.XY;

public class MasterSquirrel extends Movable {
	public MasterSquirrel(int x, int y) {
		super(x, y,1000);
	}
	public MasterSquirrel(XY pos) {
		super(pos,1000);
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("MasterSquirrel on ");
		sb.append(getPos().toString());
		return sb.toString();
	}
}
