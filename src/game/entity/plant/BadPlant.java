package game.entity.plant;

import java.math.BigInteger;

import game.position.XY;

public class BadPlant extends Plant {
	public BadPlant() {
		super();
		energy=BigInteger.valueOf(-100);
	}
	public BadPlant(XY pos) {
		super(pos);
		energy=BigInteger.valueOf(-100);
	}
	private BadPlant(BadPlant plant) {
		super(plant.position);
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
}
