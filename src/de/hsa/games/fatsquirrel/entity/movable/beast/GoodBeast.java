package de.hsa.games.fatsquirrel.entity.movable.beast;

import de.hsa.games.fatsquirrel.entity.movable.Movable;
import de.hsa.games.fatsquirrel.position.XY;

public class GoodBeast extends Movable {
	public GoodBeast(int x, int y) {
		super(x, y, 200);
	}
	public GoodBeast(XY pos) {
		super(pos, 200);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("GoodBeast on ");
		sb.append(getPos().toString());
		return sb.toString();
	}
}
