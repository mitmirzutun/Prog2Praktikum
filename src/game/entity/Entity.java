package game.entity;

import java.math.BigInteger;

import game.position.XY;

public abstract class Entity {
	protected BigInteger energy;
	protected XY position;
	protected boolean constPosition;
	public void setEnergy(long energy) {
		this.energy=BigInteger.valueOf(energy);
	}
	public void setEnergy(BigInteger energy) {
		this.energy=energy;
	}
	public void setPosition(long x, long y) {
		if (constPosition)
			throw new NoSuchMethodError("The Method setPosition(long, long) is undefined");
		position=new XY(x,y);
	}
	public void setPosition(BigInteger x,long y) {
		if (constPosition)
			throw new NoSuchMethodError("The Method setPosition(BigInteger, long) is undefined");
		position=new XY(x,y);
	}
	public void setPosition(long x, BigInteger y) {
		if (constPosition)
			throw new NoSuchMethodError("The Method setPosition(long, BigInteger) is undefined");
		position=new XY(x,y);
	}
	public void setPosition(BigInteger x,BigInteger y) {
		if (constPosition)
			throw new NoSuchMethodError("The Method setPosition(BigInteger,BigInteger) is undefined");
		position=new XY(x,y);
	}
	public void setPosition(long pos[]) {
		if (constPosition)
			throw new NoSuchMethodError("The Method setPosition(long[]) is undefined");
		position=new XY(pos);
	}
	public void setPosition(BigInteger pos[]) {
		if (constPosition)
			throw new NoSuchMethodError("The Method setPosition(BigInteger[]) is undefined");
		position=new XY(pos);
	}
	public void setPosition(XY pos) {
		if (constPosition)
			throw new NoSuchMethodError("The Method setPosition(XY) is undefined");
		position=new XY(pos);
	}
	public BigInteger getEnergy() {
		return energy;
	}
	public XY getPosition() {
		return position.clone();
	}
	public BigInteger getX() {
		return position.getX();
	}
	public BigInteger getY() {
		return position.getY();
	}
	public int length() {
		return this.toString().length();
	}
	public abstract String toString();
	public abstract Entity clone();
	public abstract boolean equals(Object o);
	public abstract void nextStep();
}
