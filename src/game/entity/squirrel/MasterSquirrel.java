package game.entity.squirrel;

import java.math.BigInteger;
public class MasterSquirrel extends Squirrel {
	public MasterSquirrel() {
		super();
		this.energy=BigInteger.valueOf(1000);
	}
	public MasterSquirrel(game.position.XY pos) {
		super(pos);
		this.energy=BigInteger.valueOf(1000);
	}
	private MasterSquirrel(MasterSquirrel squirrel) {
		super(squirrel.position);
		this.energy=squirrel.energy;
	}
	public MasterSquirrel clone() {
		return new MasterSquirrel(this);
	}
	public String toString() {
		String pos = position.toString();
		StringBuilder sb= new StringBuilder(32+pos.length());
		sb.append("Master Squirrel Object\nPosition\n");
		sb.append(pos);
		return sb.toString();
	}
	public boolean equals(Object o) {
		if (o==null)
			throw new NullPointerException("No object to compare to");
		return o instanceof MasterSquirrel?this.toString().equals(o.toString()):false;
	}
}
