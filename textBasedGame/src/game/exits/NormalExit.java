package game.exits;

import game.interfaces.conditions.NormalCondition;
import game.rooms.Room;

public class NormalExit extends Exit implements NormalCondition{
	
	//=== Attribute Static ====//
	private static final long serialVersionUID = -5789473379127293047L;

	//=== Constructor ====//
	public NormalExit(Room room) {
		super(true, room);
	}
	
	//=== Methods ===//
	@Override
	public void action() 
	{
		// To Override when creating the exit.
	}

	@Override
	public boolean normalCondition(){
		this.action();
		return true;
	}

}
