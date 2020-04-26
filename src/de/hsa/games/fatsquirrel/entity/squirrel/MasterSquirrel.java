package de.hsa.games.fatsquirrel.entity.squirrel;

import de.hsa.games.fatsquirrel.position.XY;

public class MasterSquirrel extends Squirrel {
	public MasterSquirrel(long x, long y) {
		super(1000, x, y);
	}
	public MasterSquirrel(XY pos) {
		super(1000,pos);
	}
}
