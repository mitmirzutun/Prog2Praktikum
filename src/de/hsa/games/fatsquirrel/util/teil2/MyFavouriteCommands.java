package de.hsa.games.fatsquirrel.util.teil2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MyFavouriteCommands {
	static PrintStream outputStream=System.out;
	static BufferedReader inputReader=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String args[]) {
	}
	public static void process() {
		CommandTypeInfo[] commandType= {new CommandTypeInfo("HELP", " * list all commands"),
				new CommandTypeInfo("EXIT", " * exit program"),
				new CommandTypeInfo("ADDI", " <param1> <param2> * simple integer add",long.class,long.class),
				new CommandTypeInfo("ADDF", "<param1> <param2> * simple float add",double.class,double.class),
				new CommandTypeInfo("ECHO", "<param1> <param2> * echos param1 string param2 times ",String.class,long.class)};
		CommandScanner cs = new CommandScanner(commandType,inputReader,outputStream);
	}
}

