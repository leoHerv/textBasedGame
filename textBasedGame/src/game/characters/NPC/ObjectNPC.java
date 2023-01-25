package game.characters.NPC;

import game.interfaces.conditions.ObjectCondition;
import game.objects.GameObject;
import game.objects.ObjectType;


public class ObjectNPC extends NPC implements ObjectCondition {

	private static final long serialVersionUID = -3496761107841333582L;
	
	private boolean has_object = true;
	private final ObjectType neededObject;
	private boolean condition_fulfilled = false;
	private final String solution ;

	public ObjectNPC(String name , String desciption ,  String dialogue , ObjectType type_obj , String solution)
	{

		super(name , desciption , dialogue);
		this.neededObject = type_obj ;
		this.solution = solution;
	} 

	
	public void printCharacter()
	{
		super.printDescription();
		super.printDialogue();
	}



	public boolean objectCondition(GameObject Obj)
	{
		if (this.neededObject == Obj.getType())
		{
			this.condition_fulfilled = true ;
			return true ;
		}
		else
		{
			return false ;
		}
	}


	public void specialAction(GameObject Obj)
	{

		if(this.objectCondition(Obj))
		{
		
			this.action();
			this.condition_fulfilled = false ;
		}
		else
		{

			System.out.println("This is not the required object");
		}
	}


	protected void action()
	{

		System.out.println(this.solution);

	}

} 

