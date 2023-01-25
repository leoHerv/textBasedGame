package game.characters.NPC;
import game.interfaces.conditions.CodeCondition;

import java.util.Scanner;

public class CodeNPC extends NPC implements CodeCondition {

	private static final long serialVersionUID = 953159425338972038L;
	
	private String code ;
	private String solution ;
	private boolean condition_fulfilled = false ;

	public CodeNPC(String name , String description , String dialogue , String code ,String solution)
	{

		super(name , description , dialogue);
		this.code = code ;
		this.solution = solution ;
	}

	public void printCharacter(){

		super.printDescription();
		super.printDialogue();
		
		Scanner sc = new Scanner(System.in);
		
		if(sc.hasNext()){
			String code = sc.next();
			this.specialAction(code.toLowerCase());
		}
	}

	public boolean codeCondition(String code){

		if (this.code.equals(code))
		{
			this.condition_fulfilled = true ;
			return true ;

		}
		else
		{
			return false;
		}
	}


	public void specialAction(String code){

		if(this.codeCondition(code))
		{
			this.action();
			this.condition_fulfilled = false ;
		}
		else
		{
			System.out.println("This is not the right password");
		}

	}

	protected void action(){

		System.out.println(this.solution);

	} 



}

