package de.hsa.games.fatsquirrel.util.teil2;

import java.io.BufferedReader;
import java.io.PrintStream;

import de.hsa.games.fatsquirrel.util.Parser;

public class CommandScanner {
	private CommandTypeInfo[] commandType;
	BufferedReader inputReader;
	PrintStream outputStream;
	public CommandScanner(CommandTypeInfo[] commandType,BufferedReader inputReader,PrintStream outputStream) {
		this.commandType=commandType;
		this.inputReader=inputReader;
		this.outputStream=outputStream;
	}
	public Command next() throws Exception {
		String s=inputReader.readLine(),data[]=new String[2];
		int i;
		for (i=0;i<s.length();i++) {
			if (s.charAt(i)!=' '&&s.charAt(i)!='\t'&&s.charAt(i)!='\n'&&s.charAt(i)!='\r')
				break;
		}
		StringBuffer sb=new StringBuffer(s.length()-i);
		for (;i<s.length()&&s.charAt(i)>='A'&&s.charAt(i)<='Z';i++) {
			sb.append(s.charAt(i));
		}
		data[0]=sb.toString();
		if (s.charAt(i+1)!='(') {
			outputStream.println("Invalid Char");
			return null;
		}
		switch(MyFavouriteCommandType.valueOf(sb.toString())) {
		case HELP:
		case EXIT:
		case ALL:
		case UP:
		case DOWN:
		case LEFT:
		case RIGHT:
		case MASTER_ENERGY:
			return new Command(new CommandTypeInfo(sb.toString(),""));
		case SPAWN_MINI:
			StringBuilder num1= new StringBuilder();
			for (;s.charAt(i)>='0'&&s.charAt(i)<='9';i++) {
				num1.append(s.charAt(i));
			}
			return new Command(new CommandTypeInfo("SPAWN_MINI", "", long.class), Parser.ParseInt(num1.toString()));
		}
		return null;
	}
}
