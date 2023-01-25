package game.characters.NPC;

import game.characters.Character;
import game.objects.GameObject;

public abstract class NPC extends Character{

 	private static final long serialVersionUID = 3034824041098700202L;
 	
	private String description ;
 	private String dialogue ;

 	public NPC(String name , String description , String dialogue){
 		super(name) ;
 		this.description = description ;
 		this.dialogue = dialogue ;
 	}

 	protected abstract void action();

 	public abstract void printCharacter();

 	public void specialAction(){}

 	public void printName(){

 		super.printName();
 	}

 	public void printDescription(){
 		
 		System.out.println(this.description);
 	}

 	public void printDialogue(){

 		System.out.println(this.dialogue);

 	}


 	public void addObject(GameObject obj){

 		super.addObject(obj);
 	}


 }