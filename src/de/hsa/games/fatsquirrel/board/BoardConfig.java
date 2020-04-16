package de.hsa.games.fatsquirrel.board;

//Konfigurationsdaten für die Initialisierung des Spiels benötigt
public class BoardConfig{
	protected final int x = 100, y = 100; //Größe des Spielfeldes
	protected final int goodPlant = 3, badPlant = 3;//Anzahl an Pflanzen
	protected final int wall = 6;//Anzahl an Mauerelementen ohne Umrandung
	protected final int goodBeast = 3, badBeast = 3;//Anzahl an Tieren
	BoardConfig(){
		}
	}