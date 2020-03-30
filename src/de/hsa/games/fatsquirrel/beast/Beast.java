package de.hsa.games.fatsquirrel.beast;

import de.hsa.games.fatsquirrel.entity.Entity;

public class Beast extends Entity {
	private Beast(Beast b) {
		this.constPosition=false;
		this.energy=b.energy;
		this.position=b.position;
	}
	public String toString() {
		return null;
	}
	public Beast clone() {
		return new Beast(this);
	}
	public boolean equals(Object o) {
		return false;
	}
	public void nextStep() {
	}

}
