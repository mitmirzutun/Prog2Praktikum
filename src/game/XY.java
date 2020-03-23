package game;
import java.math.BigInteger;
public class XY {
	public static void main(String args[]) {
	}
	public final BigInteger[] NULL= {BigInteger.ZERO,BigInteger.ZERO};
	private BigInteger pos[]=new BigInteger[2];
	public XY() {
		pos=NULL;
	}
	public XY(long x, long y) {
		if (x<0)
			throw new NumberFormatException("Expected positive x, got negative x");
		if (y<0)
			throw new NumberFormatException("Expected positive y, got negative y");
		pos[0]=BigInteger.valueOf(x);
		pos[1]=BigInteger.valueOf(y);
	}
	public XY(long x, BigInteger y) {
		if (x<0)
			throw new NumberFormatException("Expected positive x, got negative x");
		if (y.signum()<0)
			throw new NumberFormatException("Expected positive y, got negative y");
		pos[0]=BigInteger.valueOf(x);
		pos[1]=y;
	}
	public XY(BigInteger x, long y) {
		if (x.signum()<0)
			throw new NumberFormatException("Expected positive x, got negative x");
		if (y<0)
			throw new NumberFormatException("Expected positive y, got negative y");
		pos[0]=x;
		pos[1]=BigInteger.valueOf(y);
	}
	public XY(BigInteger x,BigInteger y) {
		if (x.signum()<0)
			throw new NumberFormatException("Expected positive x, got negative x");
		if (y.signum()<0)
			throw new NumberFormatException("Expected positive y, got negative y");
		pos[0]=x;
		pos[1]=y;
	}
	public XY(long[] pos) {
		if (pos==null)
			throw new NullPointerException("Expected position argument, got none");
		if (pos.length!=2)
			throw new RuntimeException("Expected position argument of length 2, got argument of length "+pos.length);
		if (pos[0]<0)
			throw new NumberFormatException("Expected positive x, got negative x");
		if (pos[1]<0)
			throw new NumberFormatException("Expected positive y, got negative y");
		this.pos[0]=BigInteger.valueOf(pos[0]);
		this.pos[1]=BigInteger.valueOf(pos[1]);
	}
	public XY(BigInteger[] pos) {
		if (pos==null)
			throw new NullPointerException("Expected position argument, got none");
		if (pos.length!=2)
			throw new RuntimeException("Expected position argument of length 2, got argument of length "+pos.length);
		if (pos[0].signum()<0)
			throw new NumberFormatException("Expected positive x, got negative x");
		if (pos[1].signum()<0)
			throw new NumberFormatException("Expected positive y, got negative y");
		this.pos=pos.clone();
	}
	public XY(XY pos) {
		if (pos==null)
			throw new NullPointerException("Expected position argument, got none");
		this.pos = pos.pos.clone();
	}
	public XY move(long x, long y) {
		return move(new XY(x,y));
	}
	public XY move(long x, BigInteger y) {
		return move(new XY(x,y));
	}
	public XY move(BigInteger x, long y) {
		return move(new XY(x,y));
	}
	public XY move(BigInteger x, BigInteger y) {
		return move(new XY(x,y));
	}
	public XY move(long[] vector) {
		return move(new XY(vector));
	}
	public XY move(BigInteger[] vector) {
		return move(new XY(vector));
	}
	public XY move(XY vector) {
		return new XY(pos[0].add(vector.pos[0]),pos[1].add(vector.pos[1]));
	}
	public XY clone() {
		return new XY(this);
	}
	public BigInteger getX() {
		return pos[0];
	}
	public BigInteger getY() {
		return pos[1];
	}
	public boolean equals(Object o) {
		if (o==null)
			throw new NullPointerException("No objecto to evaluate");
		return o instanceof XY?o.toString().equals(this.toString()):false;
	}
	public String toString() {
		String pos[]= {this.pos[0].toString(),this.pos[1].toString()};
		StringBuilder sb=new StringBuilder(5+pos[0].length()+pos[1].length());
		sb.append("x=");
		sb.append(pos[0]);
		sb.append("\ny=");
		sb.append(pos[1]);
		return sb.toString();
	}
	public int length() {
		return this.toString().length();
	}
}
