package de.hsa.games.fatsquirrel.entity.movable.beast;

import de.hsa.games.fatsquirrel.entity.movable.Movable;
import de.hsa.games.fatsquirrel.position.XY;

public class BadBeast extends Movable {
	public BadBeast(int x, int y) {
		super(x, y,-150);
	}
	public BadBeast(XY pos) {
		super(pos,-150);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("BadBeast on ");
		sb.append(getPos().toString());
		return sb.toString();
	}
}
