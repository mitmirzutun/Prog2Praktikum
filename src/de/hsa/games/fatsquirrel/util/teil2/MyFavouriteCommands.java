package de.hsa.games.fatsquirrel.util.teil2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import de.hsa.games.fatsquirrel.board.Board;
import de.hsa.games.fatsquirrel.position.Vector;

public class MyFavouriteCommands {
	static PrintStream outputStream=System.out;
	static BufferedReader inputReader=new BufferedReader(new InputStreamReader(System.in));
	static Board b=new Board();
	public static void main(String args[]) {
	}
	public static void process() throws Exception {
		CommandTypeInfo[] commandType= {new CommandTypeInfo("HELP", " * list all commands"),
				new CommandTypeInfo("EXIT", " * exit program"),
				new CommandTypeInfo("ADDI", " <param1> <param2> * simple integer add",long.class,long.class),
				new CommandTypeInfo("ADDF", "<param1> <param2> * simple float add",double.class,double.class),
				new CommandTypeInfo("ECHO", "<param1> <param2> * echos param1 string param2 times ",String.class,long.class)};
		CommandScanner cs = new CommandScanner(commandType,inputReader,outputStream);
		Command c=cs.next();
		switch(MyFavouriteCommandType.valueOf(c.getCommandType().getName())) {
		case HELP:
		case EXIT:
			System.exit(0);
		case UP:
			b.move(b.getMaster(), Vector.UP);
			break;
		case DOWN:
			b.move(b.getMaster(), Vector.DOWN);
			break;
		case LEFT:
			b.move(b.getMaster(), Vector.LEFT);
			break;
		case RIGHT:
			b.move(b.getMaster(), Vector.RIGHT);
			break;
		case MASTER_ENERGY:
			outputStream.print(b.getMaster().getEnergy());
		case SPAWN_MINI:
			b.newMini((int)c.getParams()[0]);
		case ALL:
		}
	}
}

