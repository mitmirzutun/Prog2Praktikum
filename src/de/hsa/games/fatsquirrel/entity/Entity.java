package de.hsa.games.fatsquirrel.entity;

import java.util.InvalidPropertiesFormatException;

import de.hsa.games.fatsquirrel.position.*;

public abstract class Entity {
	private boolean constPos;
	private XY pos;
	private long energy;
	public abstract String toString();
	public void nextStep(Vector vector) throws Exception{
		if (constPos)
			throw new InvalidPropertiesFormatException("This Entity is not movable.");
		pos=new XY(pos.getX()+vector.getX(),pos.getY()+vector.getY());
	}
	public void newPos(XY pos) throws Exception {
		if (constPos)
			throw new InvalidPropertiesFormatException("This Entity is not movable.");
		this.pos=pos;
	}
	public void updateEnergy(long energy) {
		this.energy+=energy;
	}
	public void setup(boolean constPos,XY pos, long energy) {
		this.constPos=constPos;
		this.pos=pos;
		this.energy=energy;
	}
	public void setup(boolean constPos,int x,int y, long energy) {
		try {
			setup(constPos,new XY(x,y),energy);
		} catch (Exception e) {
			System.out.println("Setup failed.");
		}
	}
	public XY getPos() {
		return pos;
	}
	public int getX() {
		return pos.getX();
	}
	public int getY() {
		return pos.getY();
	}
	public long getEnergy() {
		return energy;
	}
}
