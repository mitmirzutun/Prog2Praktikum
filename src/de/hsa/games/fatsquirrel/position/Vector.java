package de.hsa.games.fatsquirrel.position;

public class Vector {
	private long x, y;
	public Vector(long x, long y) throws Exception {
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
	public long getX() {
		return x;
	}
	public long getY() {
		return y;
	}
}
