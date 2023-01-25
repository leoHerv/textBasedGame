package game.objects;

import java.io.Serializable;

public class GameObject implements Serializable{

	private static final long serialVersionUID = -4121101008693309897L;
	
	//=== Attributes ====//
	private ObjectType type;
	private String description;
	
	//=== Constructors ====//
	public GameObject(ObjectType type)
	{
		this.setType(type);
		switch(type)
		{
		case KEYS:
			this.description = "Keys that seem to be there for a long time.";
			break;
		case FISH:
			this.description = "A cooked Fish.";
			break;
		case SWORD:
			this.description = "A rusty sword.";
			break;
		case STONE :
			this.description = "A simple stone.";
			break;
		case FLOWERS:
			this.description = "A pretty bouquet of roses.";
			break;	
		}
		this.setDescription(description);
	}
	
	public void printObject()
	{
		System.out.print("\t");
		System.out.print(this.type +" :");
		System.out.println(this.description);
	}

	//=== Getters and Setters ===//
	public ObjectType getType() {
		return this.type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
