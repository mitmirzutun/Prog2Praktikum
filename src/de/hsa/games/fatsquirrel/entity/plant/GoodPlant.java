package de.hsa.games.fatsquirrel.entity.plant;

import java.math.BigInteger;

import de.hsa.games.fatsquirrel.position.XY;

public class GoodPlant extends Plant {
	public GoodPlant() {
		this.position=new XY();
		constPosition=false;
		energy=BigInteger.valueOf(100);
	}
	public GoodPlant(XY pos) {
		this.position=new XY(pos);
		constPosition=false;
		energy=BigInteger.valueOf(100);
	}
	private GoodPlant(GoodPlant plant) {
		this(plant.position);
		this.energy=plant.energy;
	}
	public GoodPlant clone() {
		return new GoodPlant(this);
	}
	public String toString() {
		String pos = position.toString();
		StringBuilder sb= new StringBuilder(27+pos.length());
		sb.append("Good Plant Object\nPosition\n");
		sb.append(pos);
		return sb.toString();
	}
	public boolean equals(Object o) {
		if (o==null)
			throw new NullPointerException("No object to compare to");
		return o instanceof GoodPlant?this.toString().equals(o.toString()):false;
	}
	public void nextStep() {
	}
}