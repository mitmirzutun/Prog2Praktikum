package game.entity.wall;

import java.math.BigInteger;

import game.entity.Entity;
import game.position.XY;

public class Wall extends Entity {
	public Wall () {
		energy=BigInteger.valueOf(-10);
		position=new XY();
		constPosition=true;
	}
	public Wall(XY pos) {
		energy=BigInteger.valueOf(-10);
		position=new XY(pos);
		constPosition=true;
	}
	private Wall(Wall w) {
		position=new XY(w.position);
		constPosition=true;
		energy=w.energy;
	}
	public String toString() {
		String pos = position.toString();
		StringBuilder sb= new StringBuilder(21+pos.length());
		sb.append("Wall Object\nPosition\n");
		sb.append(pos);
		return sb.toString();
	}
	public Wall clone() {
		return new Wall(this);
	}
	public boolean equals(Object o) {
		return o instanceof Wall?this.toString().equals(o.toString()):false;
	}
	public void nextStep() {
	}
	public static void main(String[] args) {
	}

}
