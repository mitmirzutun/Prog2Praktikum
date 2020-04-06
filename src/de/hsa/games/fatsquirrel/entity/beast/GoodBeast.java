package de.hsa.games.fatsquirrel.entity.beast;

import java.math.BigInteger;
import de.hsa.games.fatsquirrel.position.XY;

public class GoodBeast extends Beast {
	public GoodBeast() {
		this.position=new XY();
		this.constPosition=true;
		this.energy=BigInteger.valueOf(200);
	}
	public GoodBeast(XY pos) {
		this.position=new XY(pos);
		this.constPosition=true;
		this.energy=BigInteger.valueOf(200);
	}
	public GoodBeast clone() {
		return new GoodBeast(this);
	}
	public String toString() {
		String pos = position.toString();
		StringBuilder sb= new StringBuilder(27+pos.length());
		sb.append("Good beast Object\nPosition\n");
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