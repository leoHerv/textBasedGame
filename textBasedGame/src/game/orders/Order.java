package game.orders;

import java.util.Map;

import game.FunctionAux;
import game.characters.hero.Hero;
import game.exits.CodeExit;
import game.exits.Exit;
import game.exits.ObjectExit;
import game.objects.GameObject;
import game.rooms.Room;
import game.saveGame.SaveLoad;
import game.world.World;
import game.world.WorldReplace;

public abstract class Order {
	
	//=== Main Orders ===//
	public static void go(World world, String room)
	{
		world.moveLocation(room);
	}
	
	public static void help(World world)
	{
		FunctionAux.printf("HELP:");
		FunctionAux.printf("GO: to go somewhere (GO path)");
		FunctionAux.printf("HELP: gives the basic commands (HELP)");
		FunctionAux.printf("LOOK: to see what's in the room (LOOK)");
		FunctionAux.printf("TAKE: allows you to take an object (TAKE stone)");
		FunctionAux.printf("USE: give/use item on NPC/element (USE stone) if (use object/code exit) to use a blocked exit ");
		FunctionAux.printf("EXAMINE:  To examine an Element in a room ");
		FunctionAux.printf("INTERACT: To interact with an NPC ");
		FunctionAux.printf("INVENTORY: give the hero's inventory");
	}
	
	public static void look(World world)
	{
		world.reprintRooms();
		System.out.println();

		System.out.println("\t\tIn this Room\n");
		
		world.lookRoom();
	}
	
	public static void take(World world, String object)
	{
		Hero hero = world.getHero();
		Room currentRoom = world.getCurrentRoom();
		GameObject o = currentRoom.removeObject(object);
		hero.addObject(o);
	}
	
	public static void drop(World world, String object)
	{
		Hero hero = world.getHero();
		Room currentRoom = world.getCurrentRoom();
		GameObject o = hero.removeObject(object);
		currentRoom.addObject(o);
	}
	
	public static void use(World world, String objectName)
	{
		world.dropObject(objectName);
	}
	
	public static void use(World world, String objectOrCode, String elementOrNpcOrExit)
	{
		Room currentRoom = world.getCurrentRoom();
		Exit exit = Order.exitFromString(elementOrNpcOrExit, currentRoom.getExitList());
		if(exit != null)
		{
			if(exit instanceof CodeExit)
			{
				((CodeExit)exit).codeCondition(objectOrCode);
			}
			if(exit instanceof ObjectExit)
			{
				Hero hero = world.getHero();
				GameObject o = hero.removeObject(objectOrCode);
				if(o != null)
				{
					boolean goodObject = ((ObjectExit)exit).objectCondition(o);
					if(!goodObject)
					{
						FunctionAux.printf("This is not the right object.");
					}
					hero.addObject(o);
				}
				else
				{
					FunctionAux.printf("This item is not in your inventory.");
				}
			}
		}
	}
	
	public static void examine(World world)
	{
		world.examine();
	}
	
	public static void interact(World world)
	{
		world.interract();
	}
	
	public static void inventory(World world)
	{
		world.printInventory();
	}
	
	public static void save(World world, String nameFile)
	{
		SaveLoad.save(world, nameFile);
	}
	
	public static void load(WorldReplace wr, String nameFile)
	{
		wr.replace(new WorldReplace(SaveLoad.load(nameFile)));
	}
	
	public static void quit(World world)
	{
		world.kill();
	}
	
	// Check if the word corresponds to a real exit.
	public static Exit exitFromString(String exit, Map<String, Exit> eMap)
	{
		for(Map.Entry<String, Exit> e : eMap.entrySet())
		{
			String name = e.getKey();
			if(name.equalsIgnoreCase(exit))
			{
				return e.getValue();
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
