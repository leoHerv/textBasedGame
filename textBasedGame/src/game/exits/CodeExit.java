package game.exits;

import game.interfaces.conditions.CodeCondition;
import game.rooms.Room;

public class CodeExit extends Exit implements CodeCondition{
	
	//=== Attribute Static ====//
	private static final long serialVersionUID = -8438742037126742696L;
	
	//=== Attribute ====//
	private String code;

	//=== Constructor ====//
	public CodeExit(Room room, String code) {
		super(room);
		this.code = code;
	}

	//=== Getter and Setter ===//
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	//=== Methods ===//
	@Override
	public void action()
	{
		// To Override when creating the exit.
	}
	
	@Override
	public boolean codeCondition(String code) {
		if(this.code.equalsIgnoreCase(code))
		{
			this.action();
			super.setCondition(true);
			return true;
		}
		return false;
	}

}
