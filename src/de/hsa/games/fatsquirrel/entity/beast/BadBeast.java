package de.hsa.games.fatsquirrel.entity.beast;

import java.math.BigInteger;
import de.hsa.games.fatsquirrel.position.XY;

public class BadBeast extends Beast {
	public BadBeast() {
		this.constPosition = false;
		this.position=new XY();
		this.energy=BigInteger.valueOf(-150);
	}
	public BadBeast(XY pos) {
		this.position=new XY(pos);
		this.constPosition=false;
		this.energy=BigInteger.valueOf(-150);
	}
	public BadBeast clone() {
		return new BadBeast(this);
	}
	public String toString() {
		String pos = position.toString();
		StringBuilder sb= new StringBuilder(26+pos.length());
		sb.append("Bad beast Object\nPosition\n");
		sb.append(pos);
		return sb.toString();
	}
	public boolean equals(Object o) {
		if (o==null)
			throw new NullPointerException("No object to compare to");
		return o instanceof BadBeast?this.toString().equals(o.toString()):false;
	}
	public void nextStep() {
		
	}
}
