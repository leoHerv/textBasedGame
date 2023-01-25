package game.elements;

import game.interfaces.conditions.ObjectCondition;
import game.objects.GameObject;

public class ObjectElement extends Element implements ObjectCondition{

	private static final long serialVersionUID = -3200123771216688576L;
	
	private final GameObject neededObject ;
	private  GameObject object_to_return ;

	public ObjectElement(String Name , String simpleDescription , String Description , GameObject neededObject , GameObject object_to_return)
	{
		super(Name,simpleDescription,Description);
		this.neededObject = neededObject ;
		this.object_to_return = object_to_return;
	}

	public boolean objectCondition(GameObject object)
	{
		return this.neededObject.getType() == object.getType();
	}

	public void printDescription(GameObject object)
	{
		if(this.objectCondition(object))
		{
			super.printDescription();
		}else
		{
			System.out.println("Wrong object");
		}
	}

	public boolean hasObject()
	{
		return this.object_to_return != null ;
	}

	public GameObject getObject()
	{
		GameObject tmp = this.object_to_return ;
		this.object_to_return = null ;
		return tmp ;
	}

	public GameObject action(GameObject obj)
	{
		return obj;
	}

}