package de.hsa.games.fatsquirrel.entity.unmovable.plant;

import de.hsa.games.fatsquirrel.entity.unmovable.Unmovable;
import de.hsa.games.fatsquirrel.position.XY;

public class GoodPlant extends Unmovable {
	public GoodPlant(XY pos) {
		super(pos,100);
	}
	public GoodPlant(int x, int y) {
		super(x,y,100);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("GoodPlant on ");
		sb.append(getPos().toString());
		return sb.toString();
	}
}
