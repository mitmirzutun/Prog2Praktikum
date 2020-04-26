package de.hsa.games.fatsquirrel.position;

public class XY {
	private int x,y;
	public static XY NULL;
	private static boolean firstSetup=false;
	public XY(int x,int y) throws Exception {
		if (!firstSetup) {
			firstSetup=true;
			NULL=new XY(0,0);
		}
		if (x<0)
			throw new Exception("Invalid x value "+x);
		if (y<0)
			throw new Exception("Invalid y value "+y);
		this.x=x;
		this.y=y;
	}
	public XY(XY pos) {
		this.x=pos.x;
		this.y=pos.y;
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Point with x=");
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
	public XY clone() {
		return new XY(this);
	}
	public XY addVector(Vector v) {
		try {
			return new XY(this.x+v.getX(),this.y+v.getY());
		} catch (Exception e) {
			return NULL;
		}
	}
	public boolean equals(Object o) {
		if (!(o instanceof XY))
			return false;
		XY pos=(XY)o;
		return pos.x==x&&pos.y==y;
	}
}
