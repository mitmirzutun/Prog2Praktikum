package de.hsa.games.fatsquirrel.entity.squirrel;
import java.math.BigInteger;
import de.hsa.games.fatsquirrel.position.*;
public class MasterSquirrel extends Squirrel {
	/**
	 * */
	public MasterSquirrel() {
		this.position=new XY();//
		this.constPosition=false;
		this.energy=BigInteger.valueOf(1000);
	}
	public MasterSquirrel(de.hsa.games.fatsquirrel.position.XY pos) {
		this.position=new XY(pos);
		this.constPosition=false;
		this.energy=BigInteger.valueOf(1000);
	}
	private MasterSquirrel(MasterSquirrel squirrel) {
		this.position=new XY(squirrel.position);
		this.constPosition=false;
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
	public void nextStep() {
				
	}
}
