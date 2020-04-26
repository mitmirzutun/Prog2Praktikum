package de.hsa.games.fatsquirrel.entity.movable.squirrel;

import de.hsa.games.fatsquirrel.entity.movable.Movable;
import de.hsa.games.fatsquirrel.position.XY;

public class MiniSquirrel extends Movable {

	public MiniSquirrel(long energy, int x, int y) {
		super(x, y,energy);
	}
	public MiniSquirrel(long energy, XY pos) {
		super(pos,energy);
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("MiniSquirrel on ");
		sb.append(getPos().toString());
		return sb.toString();
	}

}
