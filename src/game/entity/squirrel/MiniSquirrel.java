package game.entity.squirrel;

import game.position.XY;

public class MiniSquirrel extends Squirrel {
	public MiniSquirrel() {
		position=new XY();
		constPosition=false;
	}
	public MiniSquirrel(XY pos) {
		position=pos;
		constPosition=false;
	}
	private MiniSquirrel(MiniSquirrel s) {
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
	public MiniSquirrel clone() {
		return new MiniSquirrel(this);
	}
	public boolean equals(Object o) {
		if (o==null)
			throw new NullPointerException("No object to compare to");
		return o instanceof MiniSquirrel?this.toString().equals(o.toString()):false;
	}
	public void nextStep() {
		
	}

}
