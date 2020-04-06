package de.hsa.games.fatsquirrel.entity.plant;

import de.hsa.games.fatsquirrel.entity.Entity;

public abstract class Beast extends Entity {
	
	public newPosition(XY pos){
		this.position=new XY(pos);
	}
}
