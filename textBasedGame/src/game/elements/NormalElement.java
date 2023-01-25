package game.elements;

import game.interfaces.conditions.NormalCondition;

public class NormalElement extends Element implements NormalCondition {

	private static final long serialVersionUID = -8358913577674524277L;
	
	private boolean normal = true ;

	public NormalElement(String Name , String simpleDescription , String Description )
	{
		super(Name,simpleDescription,Description);
	}

	public boolean normalCondition()
	{
		return this.normal;
	}

	@Override
	public void printDescription()
	{
		if(this.normalCondition())
		{
			super.printDescription();
		}

	}
}
