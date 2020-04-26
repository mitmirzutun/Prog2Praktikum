package de.hsa.games.fatsquirrel.board;

import de.hsa.games.fatsquirrel.entity.Entity;
import de.hsa.games.fatsquirrel.entity.movable.squirrel.*;
import de.hsa.games.fatsquirrel.entity.movable.beast.*;
import de.hsa.games.fatsquirrel.entity.unmovable.plant.*;
import de.hsa.games.fatsquirrel.entity.unmovable.wall.Wall;
import de.hsa.games.fatsquirrel.position.*;

public class Board {
	private XY[][] positions;
	private Entity[][] entities;
	private MasterSquirrel master;
	private MiniSquirrel[] minis;
	public Board() {
		int xpos=BoardConfig.getX(),ypos=BoardConfig.getY();
		positions=new XY[xpos][ypos];
		for (int x=0;x<xpos;x++) {
			for (int y=0;y<ypos;y++) {
				try {
					positions[x][y]=new XY(x,y);
				} catch (Exception e) {
				}
			}
		}
		entities=new Entity[xpos][ypos];
		for (int x=0;x<xpos;x++) {
			entities[x][0]=new Wall(positions[x][0]);
			entities[x][ypos]=new Wall(positions[x][ypos]);
		}
		for (int y=0;y<ypos;y++) {
			entities[0][y]=new Wall(positions[0][y]);
			entities[xpos][y]=new Wall(positions[xpos][y]);
		}
		master=new MasterSquirrel(positions[xpos/2][ypos/2]);
		entities[master.getX()][master.getY()]=master;
		minis=new MiniSquirrel[0];
		for (int i=0;i<5;i++) {
			int x,y;
			do {
				x=(int)(xpos*Math.random());
				y=(int)(ypos*Math.random());
			} while (entities[x][y]!=null);
			entities[x][y]=new GoodBeast(positions[x][y]);
		}
		for (int i=0;i<5;i++) {
			int x,y;
			do {
				x=(int)(xpos*Math.random());
				y=(int)(ypos*Math.random());
			} while (entities[x][y]!=null);
			entities[x][y]=new BadBeast(positions[x][y]);
		}
		for (int i=0;i<5;i++) {
			int x,y;
			do {
				x=(int)(xpos*Math.random());
				y=(int)(ypos*Math.random());
			} while (entities[x][y]!=null);
			entities[x][y]=new GoodPlant(positions[x][y]);
		}
		for (int i=0;i<5;i++) {
			int x,y;
			do {
				x=(int)(xpos*Math.random());
				y=(int)(ypos*Math.random());
			} while (entities[x][y]!=null);
			entities[x][y]=new BadPlant(positions[x][y]);
		}
		for (int i=0;i<5;i++) {
			int x,y;
			do {
				x=(int)(xpos*Math.random());
				y=(int)(ypos*Math.random());
			} while (entities[x][y]!=null);
			entities[x][y]=new Wall(positions[x][y]);
		}
	}
	public void move(Entity e, Vector v) {
		int newX=e.getX()+v.getX(),newY=e.getY()+v.getY();
		if (e instanceof de.hsa.games.fatsquirrel.entity.unmovable.Unmovable)
			return;
		Entity colisionEntity=entities[newX][newY];
		if (colisionEntity==null) {
			try {
				e.newPos(positions[newX][newY]);
				entities[newX][newY]=e;
			} catch (Exception e1) {
			}
			return;
		}
		if (e instanceof GoodBeast) {
			return;
		}
		if (e instanceof BadBeast) {
			if (colisionEntity instanceof MasterSquirrel||colisionEntity instanceof MiniSquirrel) {
				colisionEntity.updateEnergy(e.getEnergy());
			}
			return;
		}
		if (e instanceof MiniSquirrel) {
			if (colisionEntity instanceof Wall||
					colisionEntity instanceof BadBeast||
					colisionEntity instanceof MasterSquirrel) {
				return;
			}
			e.updateEnergy(colisionEntity.getEnergy());
			try {
				e.newPos(positions[newX][newY]);
				entities[newX][newY]=e;
			} catch (Exception e1) {
			}
			return;
		}
		if (e instanceof MasterSquirrel) {
			if (colisionEntity instanceof Wall||
					colisionEntity instanceof BadBeast) {
				return;
			}
			e.updateEnergy(colisionEntity.getEnergy());
			try {
				e.newPos(positions[newX][newY]);
				entities[newX][newY]=e;
			} catch (Exception e1) {
			}
			return;
		}
	}
	public MasterSquirrel getMaster() {
		return master;
	}
	public void newMini(long energy) {
		int x,y;
		do {
			x=(int)(positions.length*Math.random());
			y=(int)(positions[0].length*Math.random());
		} while (entities[x][y]!=null);
		entities[x][y]=new MiniSquirrel(energy,positions[x][y]);
		MiniSquirrel tmp[] =minis.clone();
		minis=new MiniSquirrel[tmp.length+1];
		for (int i=0;i<tmp.length;i++) {
			minis[i]=tmp[i];
		}
		minis[tmp.length]=(MiniSquirrel)entities[x][y];
	}
}
