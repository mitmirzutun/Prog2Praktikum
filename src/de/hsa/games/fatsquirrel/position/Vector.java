package de.hsa.games.fatsquirrel.position;

public class Vector {
	private int x, y;
	public static  Vector UP,DOWN,LEFT,RIGHT;
	private static boolean firstSetup=false;
	public Vector(int x, int y) throws Exception {
		if (!firstSetup) {
			UP=new Vector(-1,0);
			DOWN=new Vector(1,0);
			LEFT=new Vector(0,-1);
			RIGHT=new Vector(0,1);
			firstSetup=true;
		}
		if (x>1||x<-1)
			throw new Exception("Invalid x value: "+x);
		if (y>1||y<-1)
			throw new Exception("Invalid y value: "+y);
		this.x=x;
		this.y=y;
	}
	public Vector(Vector v) {
		this.x=v.x;
		this.y=v.y;
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Vector with x=");
		sb.append(x);
		sb.append(" and y=");
		sb.append(y);
		return sb.toString();
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
