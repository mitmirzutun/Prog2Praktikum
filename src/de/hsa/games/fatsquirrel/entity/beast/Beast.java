package de.hsa.games.fatsquirrel.entity.beast;

import de.hsa.games.fatsquirrel.entity.Entity;
import de.hsa.games.fatsquirrel.position.XY;

public class Beast extends Entity {
	public Beast() {
		constPosition=false;
		position=new XY();
	}
	public Beast(XY pos) {
		constPosition=false;
		position=new XY(pos);
	}
	public Beast(Beast b) {
		constPosition=false;
		position=new XY(b.position);
		energy=b.energy;
	}
	public Beast clone() {
		return new Beast(this);
	}
	public String toString() {
		String pos = position.toString();
		StringBuilder sb= new StringBuilder(27+pos.length());
		sb.append("Beast Object\nPosition\n");
		sb.append(pos);
		return sb.toString();
	}
	public boolean equals(Object o) {
		if (o==null)
			throw new NullPointerException("No object to compare to");
		return o instanceof GoodBeast?this.toString().equals(o.toString()):false;
	}
	public void nextStep() {
	}
}