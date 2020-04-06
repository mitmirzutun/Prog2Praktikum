package de.hsa.games.fatsquirrel.core;

public abstract class  Game {
	public void run() {
	    while (true) {
	        render();
	        processInput();
	        update();
	    }
	}
	//Die render()-Methode stellt jeweils den Spielzustand auf dem Ausgabemedium dar,
	public abstract void render();

	//Die Methode processInput() verarbeitet Benutzereingaben 
	public abstract void processInput();

	//Die Methode update() verändert (ggf. unter Berücksichtigung der Eingabe) den aktuellen Spielzustand
	public void update() {
		
	}
	
}
