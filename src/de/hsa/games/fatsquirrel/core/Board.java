package de.hsa.games.fatsquirrel.core;

import java.util.Random;

import de.hsa.games.fatsquirrel.entity.Entity;
import de.hsa.games.fatsquirrel.entity.beast.BadBeast;
import de.hsa.games.fatsquirrel.entity.beast.GoodBeast;
import de.hsa.games.fatsquirrel.entity.plant.BadPlant;
import de.hsa.games.fatsquirrel.entity.plant.GoodPlant;
import de.hsa.games.fatsquirrel.entity.wall.Wall;
import de.hsa.games.fatsquirrel.position.XY;

//Board hält alle Informationen über die Spiellandschaft
public class Board extends BoardConfig {
	private Entity[][] data; //Objekte des Spielfeldes
	private int anzahlEntity = 0; //anzahl an Entity
	Board(){
		data = new Entity[x][y];
		for (int i=0; i<x; i++) {
			data[i][0]=new Wall(new XY(i,0));anzahlEntity++;
			data[i][y]=new Wall(new XY(i,y));anzahlEntity++;
			data[0][i]=new Wall(new XY(0,i));anzahlEntity++;
			data[x][i]=new Wall(new XY(x,i));anzahlEntity++;
		}
		//Verteilt zufällig entity
		 Random zufall = new Random();
		 int wunsch_x=0, wunsch_y=0;
		 for (int i=0; i<goodPlant ;i++ ) {
		 	wunsch_x=zufall.nextInt()%x;
		 	wunsch_y=zufall.nextInt()%y;
		 	if (data[x][y] == null){
		 	data[wunsch_x][wunsch_y]=new GoodPlant(new XY(wunsch_x, wunsch_y));
		 	anzahlEntity++;
		 }
		 else{i--;}
		}
		 for (int i=0; i<badPlant ;i++ ) {
		 	wunsch_x=zufall.nextInt()%x;
		 	wunsch_y=zufall.nextInt()%y;
		 	if (data[x][y] == null){
		 	data[wunsch_x][wunsch_y]=new BadPlant(new XY(wunsch_x, wunsch_y));
		 	anzahlEntity++;
		 }
		 else{i--;}
		}
		 for (int i=0; i<wall ;i++ ) {
		 	wunsch_x=zufall.nextInt()%x;
		 	wunsch_y=zufall.nextInt()%y;
		 	if (data[x][y] == null){
		 	data[wunsch_x][wunsch_y]=new Wall(new XY(wunsch_x, wunsch_y));
		 	anzahlEntity++;
		 }
		 else{i--;}
		}
		 for (int i=0; i<badBeast ;i++ ) {
		 	wunsch_x=zufall.nextInt()%x;
		 	wunsch_y=zufall.nextInt()%y;
		 	if (data[x][y] == null){
		 	data[wunsch_x][wunsch_y]=new BadBeast(new XY(wunsch_x, wunsch_y));
		 	anzahlEntity++;
		 }
		 else{i--;}
		}
		 for (int i=0; i<goodBeast ;i++ ) {
		 	wunsch_x=zufall.nextInt()%x;
		 	wunsch_y=zufall.nextInt()%y;
		 	if (data[x][y] == null){
		 	data[wunsch_x][wunsch_y]=new GoodBeast(new XY(wunsch_x, wunsch_y));
		 	anzahlEntity++;
		 }
		 else{i--;}
		}
	}

	public Entity entityAtPos(int x,int y) {
		if (x<0||x>this.x)
			throw new ArrayIndexOutOfBoundsException(x);
		if (y<0||y>this.y)
			throw new ArrayIndexOutOfBoundsException(y);
		return data[x][y];
	}
	public void setEntity(Entity e, int x, int y) {
		if (x<0||x>this.x)
			throw new ArrayIndexOutOfBoundsException(x);
		if (y<0||y>this.y)
			throw new ArrayIndexOutOfBoundsException(y);
		if(e==null)
			throw new NullPointerException();
		if (data[x][y]==null) {
			data[x][y]=e;
			return;
		}
		if (data[x][y] instanceof de.hsa.games.fatsquirrel.entity.wall.Wall)
			return;
	}
	public Entity flatten(){
		return null;
	}
}