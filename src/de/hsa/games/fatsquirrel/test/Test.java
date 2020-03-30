package de.hsa.games.fatsquirrel.test;

public class Test {
	private static boolean DEBUGGING=false;
	private static String debuggingPrefix="game.test.Test";
	public static boolean testAll() {
		if (DEBUGGING) {
			System.out.println(debuggingPrefix+": Testing game.position package");
		}
		if (!de.hsa.games.fatsquirrel.position.XY.testClass()) {
			System.out.println(debuggingPrefix+": Testing failed");
			return false;
		}
		return true;
	}
	public static void startDebuggingAll() {
		System.out.println(debuggingPrefix+": Call of startDebuggingAll");
		de.hsa.games.fatsquirrel.position.XY.startDebugging();
	}
	public static void startDebugging() {
		System.out.println(debuggingPrefix+" is starting debugging");
		DEBUGGING=true;
	}
	public static void stopDebuggingAll() {
		System.out.println(debuggingPrefix+": Call of stopDebuggingAll");
		de.hsa.games.fatsquirrel.position.XY.stopDebugging();
	}
	public static void stopDebugging() {
		System.out.println(debuggingPrefix+" is stopping debugging");
		DEBUGGING=false;
	}
}
