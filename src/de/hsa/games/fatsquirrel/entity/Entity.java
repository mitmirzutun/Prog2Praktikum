package de.hsa.games.fatsquirrel.entity;

import java.math.BigInteger;
import de.hsa.games.fatsquirrel.position.XY;

public abstract class Entity {
	protected BigInteger energy;
	protected XY position;
	protected boolean constPosition;


	//setEnergy
	public final void setEnergy(long energy) {
		this.energy=BigInteger.valueOf(energy);
	}

	//setPosition
	public void setPosition(long x, long y) {
		if (constPosition)
			throw new NoSuchMethodError("The Method setPosition(long, long) is undefined");
		position=new XY(x,y);
	}
	public void setPosition(XY pos) {
		if (constPosition)
			throw new NoSuchMethodError("The Method setPosition(XY) is undefined");
		position=new XY(pos);
	}

	//getFunktions
	public final BigInteger getEnergy() {
		return energy;
	}
	public final XY getPosition() {
		return position.clone();
	}
	public final BigInteger getX() {
		return position.getX();
	}
	public final BigInteger getY() {
		return position.getY();
	}
	public final int length() {
		return this.toString().length();
	}
	public abstract String toString();
	public abstract Entity clone();
	public abstract boolean equals(Object o);
	public abstract void nextStep();
}
