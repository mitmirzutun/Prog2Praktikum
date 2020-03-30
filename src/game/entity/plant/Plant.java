package game.entity.plant;

import game.entity.Entity;
import game.position.XY;

public class Plant extends Entity {
	public Plant() {
		position=new XY();
		constPosition=true;
	}
	public Plant(XY pos) {
		position = pos;
		constPosition=true;
	}
	private Plant(Plant p) {
		position=p.position.clone();
		energy=p.energy;
		constPosition=true;
	}
	public String toString() {
		String pos = position.toString();
		StringBuilder sb= new StringBuilder(22+pos.length());
		sb.append("Plant Object\nPosition\n");
		sb.append(pos);
		return sb.toString();
	}
	public Plant clone() {
		return new Plant(this);
	}
	public boolean equals(Object o) {
		if (o==null)
			throw new NullPointerException("No object to compare to");
		return o instanceof Plant?this.toString().equals(o.toString()):false;
	}
	public void nextStep() {
	}
	public static void main(String[] args) {

	}

}
