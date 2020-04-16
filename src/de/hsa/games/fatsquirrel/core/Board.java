package de.hsa.games.fatsquirrel.core;

import de.hsa.games.fatsquirrel.entity.Entity;
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

	for (int i=0; i<goodPlant ;i++ ) {
		setRandomEntity(new GoodPlant());
	}
	for (int i=0; i<badPlant ;i++ ) {
		setRandomEntity(new BadPlant());
	}
	for (int i=0; i<wall ;i++ ) {
		setRandomEntity(new Wall());
	}
	for (int i=0; i<badBeast ;i++ ) {
		setRandomEntity(new BadBeast());
	}
	for (int i=0; i<goodBeast ;i++ ) {
		setRandomEntity(new GoodBeast());
	}


	public Entity entityAtPos(int x,int y) {
		if (x<0||x>this.x)
			throw new ArrayIndexOutOfBoundsException(x);
		if (y<0||y>this.y)
			throw new ArrayIndexOutOfBoundsException(y);
		return data[x][y];
	}
	public boolean setEntity(Entity e, int x, int y) {
		if (x<0||x>this.x)
			throw new ArrayIndexOutOfBoundsException(x);
		if (y<0||y>this.y)
			throw new ArrayIndexOutOfBoundsException(y);
		if(e==null)
			throw new NullPointerException();
		if (data[x][y]==null) {
			data[x][y]=e;
			e.setPosition(x,y);
			return true;
		}
		if (data[x][y] instanceof de.hsa.games.fatsquirrel.entity.Entity)
			return false;
	}
	public setRandomEntity(Entity e) {
		if(e==null)
			throw new NullPointerException();
		Random zufall = new Random();
		int wunsch_x = zufall.nextInt()%x;
		int wunsch_y = zufall.nextInt()%y;
		if(setEntity(Entity, wunsch_x, wunsch_y))return;
		else{
			setRandomEntity(e);
			return;
		}

	}
	public Entity flatten(){
		return data;
	}
}