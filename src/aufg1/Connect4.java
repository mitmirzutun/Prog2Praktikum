package aufg1;
import java.util.HashMap;

public class Connect4 {
	public static void main(String args[]) throws Exception {
		System.out.println(1>=0);
		Connect4 c4=new Connect4();
		c4.start();
	}
	public void start() throws Exception {
		boolean player1Turn=true;
		Field f=new Field();
		while (true) {
			System.out.println(f.toString());
			if (f.winner().containsKey(true)) {
				System.out.print("Player ");
				System.out.print(f.winner().containsValue('X')?'X':'O');
				System.out.println(" has won");
				return;
			}
			if (f.isFull()) {
				System.out.println("Tie!");
				return;
			}
			System.out.print("Turn of Player ");
			System.out.println(player1Turn?"O":"X");
			char c1=(char)System.in.read(),c2=(char)System.in.read();
			while (c1=='\n'||c1=='\r') {
				c1=c2;
				c2=(char)System.in.read();
			}
			if (c2!='\n'&&c2!='\r'||c1<'1'||c1>'8') {
				System.out.println("invalid input");
				continue;
			}
			if (f.isFull(c1-'1')) {
				System.out.println("Row full");
				continue;
			}
			f.insertToken(c1-'1', player1Turn?'O':'X');
			player1Turn=!player1Turn;
		}
	}
}
class Field {
	private Vector[] field;
	public Field() {
		field=new Vector[8];
		for (int i=0;i<field.length;i++) {
			field[i]=new Vector();
		}
	}
	public void insertToken(int line, char token) {
		field[line].addToken(token);
	}
	public boolean isFull() {
		for (int i=0;i<8;i++)
			if (!this.isFull(i))
				return false;
		return true;
	}
	public boolean isFull(int i) {
		return field[i].getLength()==8;
	}
	public HashMap<Boolean, Character> winner() {
		HashMap<Boolean,Character> tmp= new HashMap<Boolean, Character>();
		for (int i=0;i<8;i++) {
			for (int j=0;j<field[i].getLength()-3;j++) {
				if (field[i].getToken(j)==field[i].getToken(j+1)&&
						field[i].getToken(j)==field[i].getToken(j+2)&&
						field[i].getToken(j)==field[i].getToken(j+3)) {
					tmp.put(true, field[i].getToken(j));
					return tmp;
				}
			}
		}
		for (int i=0;i<5;i++) {
			for (int j=0;j<field[i].getLength()&&
					j<field[i+1].getLength()&&
					j<field[i+2].getLength()&&
					j<field[i+3].getLength();j++) {
				if (field[i].getToken(j)==field[i+1].getToken(j)&&
						field[i+1].getToken(j)==field[i+2].getToken(j)&&
						field[i].getToken(j)==field[i+3].getToken(j)) {
					tmp.put(true, field[i].getToken(j));
					return tmp;
				}
			}
			for (int j=0;j<field[i].getLength()&&
					j<field[i+1].getLength()-1&&
					j<field[i+2].getLength()-2&&
					j<field[i+3].getLength()-3;j++) {
				if (field[i].getToken(j)==field[i+1].getToken(j+1)&&
						field[i+1].getToken(j+1)==field[i+2].getToken(j+2)&&
						field[i].getToken(j)==field[i+3].getToken(j+3)) {
					tmp.put(true, field[i].getToken(j));
					return tmp;
				}
			}
			for (int j=0;j<field[i].getLength()-3&&
					j<field[i+1].getLength()-2&&
					j<field[i+2].getLength()-1&&
					j<field[i+3].getLength();j++) {
				if (field[i].getToken(j+3)==field[i+1].getToken(j+2)&&
						field[i+1].getToken(j+2)==field[i+2].getToken(j+1)&&
						field[i].getToken(j+3)==field[i+3].getToken(j)) {
					tmp.put(true, field[i].getToken(j+3));
					return tmp;
				}
			}
		}
		tmp.put(false, (char)0);
		return tmp;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder(200);
		int[] tmp=new int[8];
		for (int i=0;i<8;i++) {
			sb.append(i+1);
			sb.append(' ');
			tmp[i]=field[i].getLength();
		}
		sb.append('\n');
		for (int i=0;i<=7;i++) {
			for (int j=0;j<8;j++) {
				sb.append((tmp[j]<=7-i?'.':field[j].getToken(7-i)));
				sb.append(' ');
			}
			sb.append('\n');
		}
		for (int i=1;i<=8;i++) {
			sb.append(i);
			sb.append(' ');
		}
		return sb.toString();
	}
}
class Vector {
	private int n=0;
	private char[] tokens;
	public Vector() {
		tokens=new char[8];
	}
	public void addToken(char token) {
		if (n==tokens.length)
			throw new ArrayIndexOutOfBoundsException();
		tokens[n++]=token;
	}
	public char getToken(int index) {
		if (index>=n)
			throw new ArrayIndexOutOfBoundsException(index);
		return tokens[index];
	}
	public int getLength() {
		return n;
	}
	public HashMap<Boolean,Character> winner() {
		HashMap<Boolean,Character> tmp = new HashMap<Boolean, Character>();
		for (int i=0;i<n-3;i++) {
			if (tokens[i]==tokens[i+1]&&
					tokens[i]==tokens[i+2]&&
					tokens[i]==tokens[i+3]) {
				tmp.put(true, tokens[i]);
				return tmp;
			}
		}
		tmp.put(false,(char)0);
		return tmp;
	}
}