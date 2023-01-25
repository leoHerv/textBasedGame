package game.characters.hero;

import game.characters.Character;
import java.util.Scanner ;


public class Hero extends Character{

	private static final long serialVersionUID = 1136933085429394838L;
	private static final Hero HERO = new Hero();
	private static final String DEFAULT_NAME = "PLAYER";

	private boolean state = true ;

	private Hero()
	{
		
		super(DEFAULT_NAME);
	}
	
	public static Hero getHero()
	{

		return Hero.HERO;
	}

	public void herosetName(){

		System.out.println();
		System.out.println("	«Please enter your Name brave hero » ");
		Scanner sc  = new Scanner(System.in);
		String name = sc.next();
		this.setName(name);
	}


	public void printCharacter(){

		System.out.println(this.getName());
	}

	public boolean isHeroAlive(){

		return this.state;
	} 

	public void killHero(){

		this.state = false ;
	}

}
