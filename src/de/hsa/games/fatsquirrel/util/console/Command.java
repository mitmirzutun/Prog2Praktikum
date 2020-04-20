package de.hsa.games.fatsquirrel.util.console;

public class Command implements CommandTypeInfo{
	public Command(CommandTypeInfo commandType,Object...params) {
		
	}
	public String getName() {
		return null;
	}
	public String getHelpText() {
		return null;
	}
	public Class<?> getParamType() {
		return null;
	}
}