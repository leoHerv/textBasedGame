package game.characters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import game.interfaces.moveObject.AddRemoveObject;
import game.objects.GameObject;
import game.objects.ObjectType;

public abstract class Character implements AddRemoveObject, Serializable{

	private static final long serialVersionUID = 8897465219786306561L;

	private List <GameObject> objectList = new ArrayList<>();

	private String name ;

	public Character(String name){

		this.name = name;
	}

	public String getName(){

		return this.name;
	}

	public void addObject(GameObject obj){

		if(obj != null)
			this.objectList.add(obj);
	}

	public GameObject removeObject(String object){

		GameObject obj = null ;

		for(GameObject o : this.objectList){

			if(o.getType().toString().equalsIgnoreCase(object)){

				obj = o;
				break; 
			}
		}
		if(obj == null){

			return null;
		}
		else
		{
			int index = this.objectList.indexOf(obj);
			return this.objectList.remove(index);
		}
	} 

	public void setName(String Name){

		this.name = Name;
	}
	public void printName()
	{
		System.out.println(this.name);
	}

	public abstract void printCharacter();

	public void printInventory()
	{
		if(this.objectList.size()==0)
		{
			System.out.println("You have nothing in your inventory");
		}
		else 
		{	
			System.out.println("In your Inventory you have :");
			for(GameObject o : this.objectList)
			{
				if(o != null)
					o.printObject();
			}
		}
	}
	
	public boolean isObjectInList(String object)
	{
		for(GameObject o : this.objectList)
		{
			ObjectType type = o.getType();
			if(type.toString().equalsIgnoreCase(object))
			{
				return true;
			}
		}
		return false;
	}

}  
