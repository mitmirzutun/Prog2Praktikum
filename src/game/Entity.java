package game;

import java.math.BigInteger;

public abstract class Entity {
	protected BigInteger energy, position[]={BigInteger.ZERO,BigInteger.ZERO};
	public static void main(String[] args) {
	}
	public void setEnergy(long energy) {
		this.energy=BigInteger.valueOf(energy);
	}
	public void setEnergy(BigInteger energy) {
		this.energy=energy;
	}
	public void setPosition(long x, long y) {
		setPosition(BigInteger.valueOf(x), BigInteger.valueOf(y));
	}
	public void setPosition(BigInteger x,long y) {
		setPosition(x,BigInteger.valueOf(y));
	}
	public void setPosition(long x, BigInteger y) {
		setPosition(BigInteger.valueOf(x),y);
	}
	public void setPosition(BigInteger x,BigInteger y) {
		position=new BigInteger[2];
		position[0]=x;
		position[1]=y;
	}
	public void setPosition(long pos[]) {
		if (pos==null)
			throw new NullPointerException("Empty position argument");
		if (pos.length!=2)
			throw new RuntimeException("Expected position argument of length 2. "+
		"Got position argument of length "+pos.length);
		setPosition(BigInteger.valueOf(pos[0]), BigInteger.valueOf(pos[1]));
	}
	public void setPosition(BigInteger pos[]) {
		if (pos==null)
			throw new NullPointerException("Empty position argument");
		if (pos.length!=2)
			throw new RuntimeException("Expected position argument of length 2. "+
		"Got position argument of length "+pos.length);
		position=pos.clone();
	}
	public BigInteger getEnergy() {
		return energy;
	}
	public BigInteger[] getPosition() {
		return position.clone();
	}
	public BigInteger getX() {
		return position[0];
	}
	public BigInteger getY() {
		return position[1];
	}
	public abstract String toString();
	public abstract Entity clone();
	public abstract boolean equals(Object o);
	public abstract void nextStep();
}
