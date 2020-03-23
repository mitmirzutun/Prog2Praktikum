package game;

public abstract class Entity {
	protected long energy, position[]= {0,0};
	public void setPosition(long x,long y) {
		position=new long[2];
		position[0]=x;
		position[1]=y;
	}
	public void setPosition(long pos[]) {
		if (pos==null)
			throw new NullPointerException("Empty position argument");
		position=pos.clone();
	}
}
