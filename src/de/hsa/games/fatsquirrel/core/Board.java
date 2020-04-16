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
	private Entity[] data; //Objekte des Spielfeldes
	private int anzahlEntity = 0; //anzahl an Entity
//ich habe die vielen Constructoren rausgeschmissen da alle eigenschaften von der BordConfig klasse kommen sollen
	Board(){
		data = new Entity[2*x+2*y+goodPlant+badPlant+wall+goodBeast+badBeast];//ich habe das geändert weil wir die position ja schon in der klasse selber speicher und weil die aufgabenstellung sagt das nur die menge Menge der in der Landschaft vorhandenen Entities dastehen solll.
		//Umrandet spielfeld mit Mauern
		for (int i=0; i<x; i++) {
			data[anzahlEntity]=new Wall(new XY(i,0));anzahlEntity++;
			data[anzahlEntity]=new Wall(new XY(i,y));anzahlEntity++;
			data[anzahlEntity]=new Wall(new XY(0,i));anzahlEntity++;
			data[anzahlEntity]=new Wall(new XY(x,i));anzahlEntity++;
		}
		//Verteilt zufällig entity
		 Random zufall = new Random();
		 for (int i=0; i<goodPlant ;i++ ) {
		 	data[anzahlEntity]=new GoodPlant(new XY(zufall.nextInt()%x, zufall.nextInt()%y));
		 	anzahlEntity++;
		 }
		 for (int i=0; i<badPlant ;i++ ) {
		 	data[anzahlEntity]=new BadPlant(new XY(zufall.nextInt()%x, zufall.nextInt()%y));
		 	anzahlEntity++;
		 }
		 for (int i=0; i<goodBeast ;i++ ) {
		 	data[anzahlEntity]=new GoodBeast(new XY(zufall.nextInt()%x, zufall.nextInt()%y));
		 	anzahlEntity++;
		 }
		 for (int i=0; i<badBeast ;i++ ) {
		 	data[anzahlEntity]=new BadBeast(new XY(zufall.nextInt()%x, zufall.nextInt()%y));
		 	anzahlEntity++;
		 }
		 for (int i=0; i<wall ;i++ ) {
		 	data[anzahlEntity]=new Wall(new XY(zufall.nextInt()%x, zufall.nextInt()%y));
		 	anzahlEntity++;
		 }

	}

	public Entity entityAtPos(int x,int y) {
		if (x<0||x>this.x)
			throw new ArrayIndexOutOfBoundsException(x);
		if (y<0||y>this.y)
			throw new ArrayIndexOutOfBoundsException(y);
		return data[x*2+y*2];
	}
	public void setEntity(Entity e, int x, int y) {
		if (x<0||x>this.x)
			throw new ArrayIndexOutOfBoundsException(x);
		if (y<0||y>this.y)
			throw new ArrayIndexOutOfBoundsException(y);
		if(e==null)
			throw new NullPointerException();
		if (data[x+y]==null) {
			data[x+y]=e;
			return;
		}
		if (data[x+y] instanceof de.hsa.games.fatsquirrel.entity.wall.Wall)
			return;
	}
}