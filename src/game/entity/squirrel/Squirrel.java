package game.entity.squirrel;

import game.entity.Entity;
import game.position.XY;

public class Squirrel extends Entity {
	public Squirrel() {
		position=new XY();
		constPosition=false;
	}
	public Squirrel(XY pos) {
		position=pos;
		constPosition=false;
	}
	private Squirrel(Squirrel s) {
		position=s.position;
		constPosition=false;
		energy=s.energy;
	}
	public String toString() {
		String pos = position.toString();
		StringBuilder sb= new StringBuilder(26+pos.length());
		sb.append("Squirrel Object\nPosition\n");
		sb.append(pos);
		return sb.toString();
	}
	public Entity clone() {
		return new Squirrel(this);
	}
	public boolean equals(Object o) {
		if (o==null)
			throw new NullPointerException("No object to compare to");
		return o instanceof Squirrel?this.toString().equals(o.toString()):false;
	}
	public void nextStep() {
		
	}

}