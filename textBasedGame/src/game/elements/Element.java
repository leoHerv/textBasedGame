package game.elements;

import java.io.Serializable;

public abstract class Element implements Serializable{
	
	private static final long serialVersionUID = 1188039443881019320L;
	
	//=== Attributes ====//
	private final String name;
	private final String simpleDescription;
	private final String description;
	
	//=== Constructors ====//
	public Element(String name, String simpleDescription, String description)
	{
		this.name = name;
		this.simpleDescription = simpleDescription;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void printElement()
	{
		System.out.println(this.simpleDescription);
		System.out.println(this.description);
	}

	public void printName()
	{
		System.out.println(this.name);
	}

	public void printDescription()
	{
		System.out.println(this.description);
	}

	
}
