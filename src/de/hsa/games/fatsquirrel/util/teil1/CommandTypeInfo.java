package de.hsa.games.fatsquirrel.util.teil1;

public class CommandTypeInfo {
	private String name,helpText;
	private Object[] params;
	public CommandTypeInfo(String name, String helpText,Object...params) {
		this.name=name;
		this.helpText=helpText;
		this.params=params;
	}
	public String getName() {
		return name;
	}
	public String getHelpText() {
		return helpText;
	}
	public Object[] getParams() {
		return params;
	}
}
