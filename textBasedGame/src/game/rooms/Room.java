package game.rooms;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import game.objects.ObjectType;
import game.objects.GameObject;
import game.interfaces.moveObject.AddRemoveObject;
import game.FunctionAux;
import game.characters.NPC.CodeNPC;
import game.characters.NPC.NPC;
import game.characters.NPC.NormalNPC;
import game.characters.NPC.ObjectNPC;
import game.elements.CodeElement;
import game.elements.Element;
import game.elements.NormalElement;
import game.elements.ObjectElement;
import game.exits.Exit;



public class Room  implements AddRemoveObject, Serializable{

	private static final long serialVersionUID = 7623769031487853749L;
	
	private final String Name;
	private final String DescriptionRoom;
	private final String DescriptionRoomFar;
	private boolean win;
	private boolean lose;
	private boolean roomIsAlreadyPrint;
	private NPC roomNPC = null;
	private GameObject roomObject = null;
	private Element roomElement = null;
	private Map<String, Exit> exitList = new HashMap<String, Exit>();


	public Room(String Name, String DescriptionRoom, String DescriptionRoomFar, boolean win, boolean lose, GameObject object, Element element)
	{
		this.Name = Name;
		this.DescriptionRoom = DescriptionRoom;
		this.DescriptionRoomFar = DescriptionRoomFar;
		this.win = win;
		this.lose = lose;
		this.roomIsAlreadyPrint = false;
		this.roomObject = object;
		this.roomElement = element;
	}
	

	public boolean islose()
	{
		return this.lose;
	}

	public boolean iswin()
	{
		return this.win;
	}

	public String getName()
	{
		return this.Name;
	}
	
	public String getDescriptionRoomFar()
	{
		return this.DescriptionRoomFar;
	}
	
	public Map<String, Exit> getExitList()
	{
		return this.exitList;
	}
	
	public boolean getRoomIsAlreadyPrint()
	{
		return this.roomIsAlreadyPrint;
	}
	
	public void setRoomIsAlreadyPrint(boolean b)
	{
		this.roomIsAlreadyPrint = b;
	}

	public void addExit(String text, Exit exit)
	{
		this.exitList.put(text, exit);
	}

	public GameObject removeObject(String object)
	{
		if(roomObject != null)
		{
			if(roomObject.getType().toString().equalsIgnoreCase(object)){

				GameObject to_return = this.roomObject;
				this.roomObject = null;
				
				return to_return;
			}
		}
		return null;
	}
	
	public void addObject(GameObject obj)
	{
		if(this.roomObject == null)
		{
			this.roomObject = obj;
		}else{
			System.out.println("You can't drop your object here, \n there is already an object in this room");
		}
	}

	public boolean hasNPC()
	{
		return this.roomNPC != null;
	}

	public boolean isObjectNPC()
	{
		return (this.roomNPC instanceof ObjectNPC);
	}

	public boolean checkConditionNPC(GameObject object)
	{
		ObjectNPC npc = (ObjectNPC)this.roomNPC ;
		return npc.objectCondition(object);
	}

	public void npcAction(GameObject object)
	{
		ObjectNPC npc = (ObjectNPC)this.roomNPC ;
		npc.specialAction(object);
	}

	public boolean hasElement()
	{
		return this.roomElement != null ; 
	}

	public boolean isObjectElement()
	{
		return (this.roomElement instanceof ObjectElement);
	}

	public boolean elementHasObject()
	{
		ObjectElement e = (ObjectElement)this.roomElement ;
		return e.hasObject();
	}



	public GameObject getObjectElement()
	{
		ObjectElement e = (ObjectElement)this.roomElement ;
		return e.getObject();
	}

	public boolean checkConditionElement(GameObject object)
	{
		ObjectElement e = (ObjectElement)this.roomElement ;
		return e.objectCondition(object);
	}
	
	public Room goToNextRoom(String exitName)
    {
		boolean b = false;
        Map<String, Exit> exitMap = this.exitList;
        for(Map.Entry<String, Exit> e : exitMap.entrySet())
        {
            String name = e.getKey();
            if(name.equalsIgnoreCase(exitName))
            {
            	b = true;
                Exit exit = (Exit) e.getValue();
                if(exit.checkCondition())
                {
                    this.setRoomIsAlreadyPrint(false);
                    FunctionAux.clearScreen();
                    return exit.getRoom();
                }
                else
                {
                    System.out.println("Seems you couldn't go through.");
                }
            }
        }
        if(!b)
        {
        	 System.out.println("This exit does not exist");
        }
        return null;
    }
	
	//Creation Of the NPC

	public void create_CodeNPCforRoom(String NPCname, String Description, String Dialogue, String code, String solution)
	{
		this.roomNPC = new CodeNPC(NPCname, Description, Dialogue, code, solution);
	}

	public void create_NormalNPCforRoom(String Name, String Description, String Dialogue)
	{
		this.roomNPC = new NormalNPC(Name, Description, Dialogue);
	}

	public void create_ObjectNPCforRoom(String NPCname, String Description, String Dialogue, ObjectType type, String solution)
	{
		this.roomNPC = new ObjectNPC(NPCname, Description, Dialogue, type, solution);
	}


	//Creation Of the Element
	public void create_CodeElementforRoom(String Elementname, String simpleDescription, String Description, String code)
	{
		this.roomElement = new CodeElement(Elementname, simpleDescription, Description, code);
	}

	public void create_NormalElementforRoom(String Elementname, String simpleDescription, String Description)
	{
		this.roomElement = new NormalElement(Elementname, simpleDescription, Description);
	}

	public void create_ObjectElementforRoom(String Elementname, String simpleDescription, String Description, GameObject object , GameObject object_to_return)
	{
		this.roomElement = new ObjectElement(Elementname, simpleDescription, Description, object , object_to_return);
	}

	

	public void printRoom()
	{
		if(!this.getRoomIsAlreadyPrint())
		{
			System.out.println();
			System.out.println("\tYour current location is : ");
			System.out.print("\t\t");
			System.out.println(this.Name);
			System.out.print("\t");
			System.out.println(this.DescriptionRoom);
			if(this.roomObject != null)
			{
				System.out.print("   You can find in this room : ");
				this.roomObject.printObject();
			}
			System.out.println();
			System.out.println("\tFrom this room you can see :");
			System.out.print("\t");
			System.out.println(this.DescriptionRoomFar);
			System.out.println();
			
			this.setRoomIsAlreadyPrint(true);
		}
	}


	public void printNpc()
	{
		if(this.roomNPC != null)
		{
			roomNPC.printCharacter();
		}
	}

	public void npcName()
	{
		if(this.roomNPC != null)
		{
			System.out.print("\tYou can Interact with : ");
			this.roomNPC.printName();
		}else 
		{
		 System.out.println("\tNo one to Interact with in this room");
		}
	}

	public void printElement(){
		if(this.roomElement != null)
		{
			this.roomElement.printElement();
		}else
		{
			System.out.println("\tThere is no element in this room");
		}

		
		
	}

	public void elementName()
	{
		if(this.roomElement != null)
		{
			System.out.print("\tYou can Examine : ");
			this.roomElement.printName();
		}else
		{
			System.out.println("\tThere is no element in this room");
		}

		
	}

	public void printObject()
	{
		if(this.roomObject != null)
		{
			this.roomObject.printObject();
		}else
		{
			System.out.println("There is no object in this room");
		}

		
	}


}
