package de.hsa.games.fatsquirrel.entity.plant;

import java.math.BigInteger;
import de.hsa.games.fatsquirrel.position.XY;

public class BadPlant extends Plant {
	public BadPlant() {
		this.constPosition = true;
		this.position=new XY();
		this.energy=BigInteger.valueOf(-100);
	}
	public BadPlant(XY pos) {
		this.position=new XY(pos);
		this.constPosition=true;
		this.energy=BigInteger.valueOf(-100);
	}
	private BadPlant(BadPlant plant) {
		this.position=plant.position;
		this.energy=plant.energy;
	}
	public BadPlant clone() {
		return new BadPlant(this);
	}
	public String toString() {
		String pos = position.toString();
		StringBuilder sb= new StringBuilder(26+pos.length());
		sb.append("Bad Plant Object\nPosition\n");
		sb.append(pos);
		return sb.toString();
	}
	public boolean equals(Object o) {
		if (o==null)
			throw new NullPointerException("No object to compare to");
		return o instanceof BadPlant?this.toString().equals(o.toString()):false;
	}
	public void nextStep() {
		
	}
}
