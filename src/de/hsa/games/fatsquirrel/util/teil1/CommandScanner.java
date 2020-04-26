package de.hsa.games.fatsquirrel.util.teil1;

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
		StringBuffer command=new StringBuffer(4);
		char c=(char)inputReader.read();
		while (c==' '|| c=='\t'||c=='\n'||c=='\r')
			c=(char)inputReader.read();
		command.append(c);
		for (int i=1;i<4;i++) {
			command.append((char)inputReader.read());
		}
		switch(MyFavouriteCommandType.valueOf(command.toString())) {
		case HELP:
			c=(char)inputReader.read();
			while (c==' '|| c=='\t')
				c=(char)inputReader.read();
			if (c!='(') {
				outputStream.println("Invalid Input on HELP: "+c);
				return null;
			}
			c=(char)inputReader.read();
			while (c==' '|| c=='\t')
				c=(char)inputReader.read();
			if (c!=')') {
				outputStream.println("Invalid Input on HELP: "+c);
				return null;
			}
			c=(char)inputReader.read();
			while (c==' '|| c=='\t')
				c=(char)inputReader.read();
			if (c!='\n'&&c!='\r') {
				outputStream.println("Invalid Input on HELP: "+c);
				return null;
			}
			return new Command(commandType[0]);
		case EXIT:
			c=(char)inputReader.read();
			while (c==' '|| c=='\t')
				c=(char)inputReader.read();
			if (c!='(') {
				outputStream.println("Invalid Input on EXIT: "+c);
				return null;
			}
			c=(char)inputReader.read();
			while (c==' '|| c=='\t')
				c=(char)inputReader.read();
			if (c!=')') {
				outputStream.println("Invalid Input on EXIT: "+c);
				return null;
			}
			c=(char)inputReader.read();
			while (c==' '|| c=='\t')
				c=(char)inputReader.read();
			if (c!='\n'&&c!='\r') {
				outputStream.println("Invalid Input on EXIT: "+c);
				return null;
			}
			return new Command(commandType[1]);
		case ADDI:
		{
			StringBuilder num1=new StringBuilder(),num2=new StringBuilder();
			c=(char)inputReader.read();
			while (c==' '|| c=='\t')
				c=(char)inputReader.read();
			if (c!='(') {
				outputStream.println("Invalid Input on ADDI: "+c);
				return null;
			}
			c=(char)inputReader.read();
			while (c>='0'&&c<='9') {
				num1.append(c);
				c=(char)inputReader.read();
			}
			if (c!=',') {
				outputStream.println("Invalid Input on ADDI: "+c);
				return null;
			}
			c=(char)inputReader.read();
			while (c>='0'&&c<='9') {
				num2.append(c);
				c=(char)inputReader.read();
			}
			if (c!=')') {
				outputStream.println("Invalid Input on ADDI: "+c);
				return null;
			}
			c=(char)inputReader.read();
			if (c!='\r'&&c!='\n')
				return null;
			try {
				return new Command(commandType[2],Parser.ParseInt(num1.toString()),Parser.ParseInt(num2.toString()));
			} catch (Exception e) {
				return null;
			}
		}
		case ADDF:
		{
			boolean decimalPointAppeared=false;
			StringBuilder num1=new StringBuilder(),num2=new StringBuilder();
			c=(char)inputReader.read();
			while (c==' '|| c=='\t')
				c=(char)inputReader.read();
			if (c!='(') {
				outputStream.println("Invalid Input on ADDF: "+c);
				return null;
			}
			c=(char)inputReader.read();
			while (c>='0'&&c<='9'||c=='.') {
				if (c=='.'||!decimalPointAppeared) {
					decimalPointAppeared=true;
				} else if (c=='.') {
					outputStream.println("Invalid Input on ADDF: "+c);
					return null;
				}
				num1.append(c);
				c=(char)inputReader.read();
			}
			if (c!=',') {
				outputStream.println("Invalid Input on ADDF: "+c);
				return null;
			}
			c=(char)inputReader.read();
			while (c>='0'&&c<='9'||c=='.') {
				if (c=='.'||!decimalPointAppeared) {
					decimalPointAppeared=true;
				} else if (c=='.') {
					outputStream.println("Invalid Input on ADDF: "+c);
					return null;
				}
				num2.append(c);
				c=(char)inputReader.read();
			}
			if (c!=')') {
				outputStream.println("Invalid Input on ADDF: "+c);
				return null;
			}
			c=(char)inputReader.read();
			if (c!='\r'&&c!='\n')
				return null;
			try {
				return new Command(commandType[3],Parser.ParseFloat(num1.toString()),Parser.ParseFloat(num2.toString()));
			} catch (Exception e) {
				return null;
			}
			}
		case ECHO:
		{
			StringBuilder string=new StringBuilder(),num=new StringBuilder();
			c=(char)inputReader.read();
			while (c==' '|| c=='\t')
				c=(char)inputReader.read();
			if (c!='(') {
				outputStream.println("Invalid Input on ECHO: "+c);
			return null;
			}
			c=(char)inputReader.read();
			while (c!=','&&c!=')') {
				string.append(c);
				c=(char)inputReader.read();
			}
			if (c==')')
				return new Command(commandType[4],string.toString(),0);
			c=(char)inputReader.read();
			while (c>='0'&&c<='9') {
				num.append(c);
				c=(char)inputReader.read();
			}
			if (c!=')') {
				outputStream.println("Invalid Input on ECHO: "+c);
				return null;
			}
			c=(char)inputReader.read();
			if (c!='\r'&&c!='\n')
				return null;
			try {
				long L = Parser.ParseInt(num.toString());
				return L>0?new Command(commandType[4],string.toString(),L):null;
			} catch (Exception e) {
				return null;
			}
			}
			default:
				return null;
			}
	}
}
