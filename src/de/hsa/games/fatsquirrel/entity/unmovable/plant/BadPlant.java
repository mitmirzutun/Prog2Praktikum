package de.hsa.games.fatsquirrel.entity.unmovable.plant;

import de.hsa.games.fatsquirrel.entity.unmovable.Unmovable;
import de.hsa.games.fatsquirrel.position.XY;

public class BadPlant extends Unmovable {
	public BadPlant(XY pos) {
		super(pos,-100);
	}
	public BadPlant(int x, int y) {
		super(x,y,-100);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("BadPlant	 on ");
		sb.append(getPos().toString());
		return sb.toString();
	}
}
