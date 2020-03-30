package de.hsa.games.fatsquirrel.position;
import java.math.BigInteger;
public class XY {
	private static boolean DEBUGGING=false;
	private static String debuggingPrefix="game.position.XY";
	public static void main(String args[]) {
		startDebugging();
		System.out.println(testClass());
	}
	public static final BigInteger[] NULL= {BigInteger.ZERO,BigInteger.ZERO};
	private BigInteger pos[]=new BigInteger[2];
	public XY() {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of Constructor()");
		}
		pos=NULL;
		if (DEBUGGING)
			System.out.println(debuggingPrefix+": x="+pos[0].toString()+"\ny="+pos[1].toString());
	}
	public XY(long x, long y) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of Constructor(long, long)");
		}
		if (x<0)
			throw new NumberFormatException("Expected positive x, got negative x");
		if (y<0)
			throw new NumberFormatException("Expected positive y, got negative y");
		pos[0]=BigInteger.valueOf(x);
		pos[1]=BigInteger.valueOf(y);
		if (DEBUGGING)
			System.out.println(debuggingPrefix+": x="+pos[0].toString()+"\ny="+pos[1].toString());
	}
	public XY(long x, BigInteger y) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of Constructor(long, BigInteger)");
		}
		if (x<0)
			throw new NumberFormatException("Expected positive x, got negative x");
		if (y.signum()<0)
			throw new NumberFormatException("Expected positive y, got negative y");
		pos[0]=BigInteger.valueOf(x);
		pos[1]=y;
		if (DEBUGGING)
			System.out.println(debuggingPrefix+": x="+pos[0].toString()+"\ny="+pos[1].toString());
	}
	public XY(BigInteger x, long y) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of Constructor(BigInteger, long)");
		}
		if (x.signum()<0)
			throw new NumberFormatException("Expected positive x, got negative x");
		if (y<0)
			throw new NumberFormatException("Expected positive y, got negative y");
		pos[0]=x;
		pos[1]=BigInteger.valueOf(y);
		if (DEBUGGING)
			System.out.println(debuggingPrefix+": x="+pos[0].toString()+"\ny="+pos[1].toString());
	}
	public XY(BigInteger x,BigInteger y) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of Constructor(BigInteger,BigInteger)");
		}
		if (x.signum()<0)
			throw new NumberFormatException("Expected positive x, got negative x");
		if (y.signum()<0)
			throw new NumberFormatException("Expected positive y, got negative y");
		pos[0]=x;
		pos[1]=y;
		if (DEBUGGING)
			System.out.println(debuggingPrefix+": x="+pos[0].toString()+"\ny="+pos[1].toString());
	}
	public XY(long[] pos) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of Constructor(long[])");
		}
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
		if (DEBUGGING)
			System.out.println(debuggingPrefix+": x="+pos[0]+"\ny="+pos[1]);
	}
	public XY(BigInteger[] pos) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of Constructor(BigInteger[])");
		}
		if (pos==null)
			throw new NullPointerException("Expected position argument, got none");
		if (pos.length!=2)
			throw new RuntimeException("Expected position argument of length 2, got argument of length "+pos.length);
		if (pos[0].signum()<0)
			throw new NumberFormatException("Expected positive x, got negative x");
		if (pos[1].signum()<0)
			throw new NumberFormatException("Expected positive y, got negative y");
		this.pos=pos.clone();
		if (DEBUGGING)
			System.out.println(debuggingPrefix+": x="+pos[0].toString()+"\ny="+pos[1].toString());
	}
	public XY(XY pos) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of Constructor(XY)");
		}
		if (pos==null)
			throw new NullPointerException("Expected position argument, got none");
		this.pos = pos.pos.clone();
		if (DEBUGGING)
			System.out.println(debuggingPrefix+": x="+this.pos[0].toString()+"\ny="+this.pos[1].toString());
	}
	public XY move(long x, long y) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of move(long,long)");
		}
		return new XY(pos[0].add(BigInteger.valueOf(x)),pos[1].add(BigInteger.valueOf(y)));
	}
	public XY move(long x, BigInteger y) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of move(long,BigInteger)");
		}
		return new XY(pos[0].add(BigInteger.valueOf(x)),pos[1].add(y));
	}
	public XY move(BigInteger x, long y) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of move(BigInteger,long)");
		}
		return new XY(pos[0].add(x),pos[1].add(BigInteger.valueOf(y)));
	}
	public XY move(BigInteger x, BigInteger y) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of move(BigInteger,BigInteger)");
		}
		return new XY(pos[0].add(x),pos[1].add(y));
	}
	public XY move(long[] vector) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of move(long[])");
		}
		return new XY(pos[0].add(BigInteger.valueOf(vector[0])),pos[1].add(BigInteger.valueOf(vector[1])));
	}
	public XY move(BigInteger[] vector) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of move(BigInteger[])");
		}
		return new XY(pos[0].add(vector[0]),pos[1].add(vector[1]));
	}
	public XY move(XY vector) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of move(XY)");
		}
		return new XY(pos[0].add(vector.pos[0]),pos[1].add(vector.pos[1]));
	}
	public XY clone() {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of clone()");
		}
		return new XY(this);
	}
	public BigInteger getX() {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of getX()");
		}
		return pos[0];
	}
	public BigInteger getY() {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of getY()");
		}
		return pos[1];
	}
	public boolean equals(Object o) {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of equals(Object)");
		}
		if (o==null)
			throw new NullPointerException("No objecto to evaluate");
		return o instanceof XY?o.toString().equals(this.toString()):false;
	}
	public String toString() {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of String toString()");
		}
		String pos[]= {this.pos[0].toString(),this.pos[1].toString()};
		StringBuilder sb=new StringBuilder(5+pos[0].length()+pos[1].length());
		sb.append("x=");
		sb.append(pos[0]);
		sb.append("\ny=");
		sb.append(pos[1]);
		return sb.toString();
	}
	public int length() {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of length()");
		}
		return this.toString().length();
	}
	public static boolean isDebugging() {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Call of isDebugging()");
		}
		return DEBUGGING;
	}
	public static void startDebugging() {
		System.out.println(debuggingPrefix+" is starting debugging");
		DEBUGGING=true;
	}
	public static void stopDebugging() {
		System.out.println(debuggingPrefix+" is starting debugging");
		DEBUGGING=false;
	}
	public static boolean testClass() {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Starting Testing.");
			System.out.println(debuggingPrefix+": Testing Constructors");
			System.out.println(debuggingPrefix+": Testing Constructor()");
		}
		XY pos = new XY();
		if (!pos.pos.equals(NULL)){
			if (DEBUGGING)
				System.out.println(debuggingPrefix+": Testing failed");
			return false;
		}
		if (DEBUGGING)
			System.out.println(debuggingPrefix+": Testing Constructor(long,long)");
		try {
			pos=new XY(-5,0);
			return false; 
		} catch (Exception e) {
			if (!(e instanceof NumberFormatException)) {
				if (DEBUGGING)
					System.out.println(debuggingPrefix+": Testing failed");
				return false;
			}
		}
		try {
			pos=new XY(0,-5);
			return false;
		} catch (Exception e) {
			if (!e.equals(new NumberFormatException("Expected positive y, got negative y"))) {
				if (DEBUGGING)
					System.out.println(debuggingPrefix+": Testing failed");
				return false;
			}
		}
		return true;
	}
}
