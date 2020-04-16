package de.hsa.games.fatsquirrel.entity.beast;

import java.math.BigInteger;

import de.hsa.games.fatsquirrel.position.XY;

public final class BadBeast extends Beast {
	public BadBeast() {
		super();
		energy=BigInteger.valueOf(-150);
	}
	public BadBeast(XY pos) {
		super(pos);
		energy=BigInteger.valueOf(-150);
	}
	public BadBeast(BadBeast bb) {
		super(bb);
	}
	public BadBeast clone() {
		return new BadBeast(this);
	}
}
