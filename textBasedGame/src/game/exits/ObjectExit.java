package game.exits;

import game.interfaces.conditions.ObjectCondition;
import game.objects.GameObject;
import game.objects.ObjectType;
import game.rooms.Room;

public class ObjectExit extends Exit implements ObjectCondition{

	//=== Attribute Static ====//
	private static final long serialVersionUID = 5093162035701669127L;
	
	//=== Attribute ====//
	private ObjectType object;
	
	//=== Constructor ====//
	public ObjectExit(Room room, ObjectType object) {
		super(room);
		this.object = object;
	}
	
	//=== Methods ===//
	@Override
	public void action()
	{
		// To Override when creating the exit.
	}
	
	@Override
	public boolean objectCondition(GameObject object) {
		if(object.getType() == this.object)
		{
			action();
			super.setCondition(true);
			return true;
		}
		else
		{
			return false;
		}
	}
}
