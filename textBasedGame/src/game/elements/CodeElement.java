package game.elements;

import game.interfaces.conditions.CodeCondition;

public class CodeElement extends Element implements CodeCondition {

	private static final long serialVersionUID = -6367245576171300609L;
	
	private String code ;

	public CodeElement(String Name , String simpleDescription , String Description , String code)
	{
		super(Name,simpleDescription,Description);
		this.code = code ;
	}

	public boolean codeCondition(String code)
	{
		return this.code.equals(code);
	}

	public void printDescription(String code)
	{
		if(this.codeCondition(code))
		{
			super.printDescription();
		}else
		{
			System.out.println("Wrong password");
		}
	}

}
