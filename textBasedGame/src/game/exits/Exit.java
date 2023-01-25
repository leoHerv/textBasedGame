package game.exits;

import java.io.Serializable;

import game.rooms.Room;

public abstract class Exit implements Serializable{
	
	//=== Attribute Static ====//
	private static final long serialVersionUID = 6255517266794194226L;
	
	//=== Attributes ====//
	private boolean condition;
	private Room room;
	
	//=== Constructors ====//
	public Exit(Room room)
	{
		this.condition = false;
		this.room = room;
	}
	
	public Exit(boolean condition, Room room)
	{
		this.condition = condition;
		this.room = room;
	}
	
	//=== Getters and Setters ===//
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public boolean getCondition() {
		return condition;
	}
	
	public void setCondition(boolean condition) {
		this.condition = condition;
	}
	
	//=== Methods ===//
	//Make the action of the exit.
	public abstract void action();
	
	// Look if the condition is check.
	public boolean checkCondition()
	{
		if(this.getCondition())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
	
