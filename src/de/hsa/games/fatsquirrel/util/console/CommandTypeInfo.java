package de.hsa.games.fatsquirrel.util.console;

public interface CommandTypeInfo {
	public String getName();
	public String getHelpText();
	public Class<?> getParamType();
}
