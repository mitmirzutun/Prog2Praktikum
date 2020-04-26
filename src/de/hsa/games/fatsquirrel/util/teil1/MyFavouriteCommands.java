package de.hsa.games.fatsquirrel.util.teil1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MyFavouriteCommands {
	private static PrintStream outputStream=System.out;
	private static BufferedReader inputReader=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String [] args) {
		try {
			process();
		} catch(Exception e) {
			
		}
	}
	public static void process() throws Exception{
		CommandTypeInfo[] commandType= {new CommandTypeInfo("HELP", " * list all commands"),
				new CommandTypeInfo("EXIT", " * exit program"),
				new CommandTypeInfo("ADDI", " <param1> <param2> * simple integer add",long.class,long.class),
				new CommandTypeInfo("ADDF", "<param1> <param2> * simple float add",double.class,double.class),
				new CommandTypeInfo("ECHO", "<param1> <param2> * echos param1 string param2 times ",String.class,long.class)};
		CommandScanner cs = new CommandScanner(commandType,inputReader,outputStream);
		while (true) {
			outputStream.print(">>> ");
			Command c=cs.next();
			if (c==null)
				continue;
			Object params[] =c.getParams();
			switch(MyFavouriteCommandType.valueOf(c.getCommandType().getName())) {
			case HELP:
				help();
				break;
			case EXIT:
				System.exit(0);
				break;
			case ADDI:
				outputStream.println((long)params[0]+(long)params[1]);
				break;
			case ADDF:
				outputStream.println((double)params[0]+(double)params[1]);
				break;
			case ECHO:
				for (int i=0;i<(long)params[1];i++)
					outputStream.println(params[0]+" x"+i);
			}
		}
	}
	private static void help() {
		outputStream.println("HELP(\"help\", \"  * list all commands\"),\r\n" + 
				"EXIT(\"exit\", \"  * exit program\"),\n" + 
				"ADDI(\"addi\", \"<param1>  <param2>   * simple integer add \",int.class, int.class ),\n" + 
				"ADDF(\"addf\", \"<param1>  <param2>   * simple float add \",float.class, float.class ),\n" + 
				"ECHO(\"echo\", \"<param1>  <param2>   * echos param1 string param2 times \",String.class, int.class )");
	}
}

