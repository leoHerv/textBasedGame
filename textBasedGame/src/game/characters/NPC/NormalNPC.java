package game.characters.NPC;

import game.interfaces.conditions.NormalCondition;
import game.objects.GameObject;

public class NormalNPC extends NPC implements NormalCondition {

	private static final long serialVersionUID = 7798984484671725894L;
	
	private final boolean CONDITION = true ;

	public NormalNPC (String name , String desctription , String dialogue){

		super(name , desctription , dialogue);
	}

	public boolean normalCondition(){

		return this.CONDITION ;
	} 

	public void printCharacter(){

		super.printDescription();
		this.specialAction();
	}


	public void specialAction(){

		if(this.normalCondition())
		{
		
			this.action();
		}
	}

	protected void action(){

		super.printDialogue();


	}

	
 	public void addObject(GameObject obj){

 		super.addObject(obj);
 	}

}