package de.hsa.games.fatsquirrel.core;

import de.hsa.games.fatsquirrel.entity.Entity;
import de.hsa.games.fatsquirrel.entity.wall.Wall;
import de.hsa.games.fatsquirrel.position.XY;

public class Board {
	private int x,y;
	private Entity[][] data;
	public Board() {
		x=100;
		y=100;
		data = new Entity[x][y];
		for (int i=0;i<x;i++) {
			data[i][0]=new Wall(new XY(i,0));
			data[i][y]=new Wall(new XY(i,y));
			data[0][i]=new Wall(new XY(0,i));
			data[x][i]=new Wall(new XY(x,i));
		}
	}
	public Board(int a) {
		if (a<=0)
			throw new NegativeArraySizeException();
		x=a;
		y=a;
		data = new Entity[x][y];
		for (int i=0;i<x;i++) {
			data[i][0]=new Wall(new XY(i,0));
			data[i][y]=new Wall(new XY(i,y));
			data[0][i]=new Wall(new XY(0,i));
			data[x][i]=new Wall(new XY(x,i));
		}
	}
	public Board(int x,int y) {
		if (x<=0||y<=0)
			throw new NegativeArraySizeException();
		this.x=x;
		this.y=y;
		data = new Entity[x][y];
		for (int i=0;i<x;i++) {
			data[i][0]=new Wall(new XY(i,0));
			data[i][y]=new Wall(new XY(i,y));
			data[0][i]=new Wall(new XY(0,i));
			data[x][i]=new Wall(new XY(x,i));
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
}
