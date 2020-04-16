package de.hsa.games.fatsquirrel.entity.beast;

import java.math.BigInteger;
import de.hsa.games.fatsquirrel.position.XY;

public class GoodBeast extends Beast {
	public GoodBeast() {
		super();
		this.energy=BigInteger.valueOf(200);
	}
	public GoodBeast(XY pos) {
		super(pos);
		this.energy=BigInteger.valueOf(200);
	}
	public GoodBeast(GoodBeast gb) {
		super(gb);
	}
	public GoodBeast clone() {
		return new GoodBeast(this);
	}
}