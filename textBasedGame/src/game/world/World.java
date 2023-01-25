package game.world;

import game.FunctionAux;
import game.characters.hero.Hero ;
import game.exits.*;
import game.rooms.Room;
import game.objects.ObjectType;
import game.objects.GameObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class World implements Serializable{


	private static final long serialVersionUID = -6221007053400473871L;

	static
	{	
		System.out.println("\n Welcome young hero to our adventure Game JAMG  we hope that you'll enjoy it .\n At every moment of the Game , "
				+ "remember that you are the choosen one and you are our only hope "
				+ "\n (Use the command HELP to see the other commands of the game)");
	}

	private static final World WORLD = new World();
	private final Hero hero ;
	private final List <Room> roomList = new ArrayList<>();
	private Room currentLocation;
	
	static 
	{
		//Room 1
		Room room1 = new Room("StonePath" , "You are on a long stone path." , "Campfire" , false , false , new GameObject(ObjectType.STONE) , null);
		room1.create_NormalNPCforRoom("Guide","Guide who seems to welcome everyone arriving in the region.","If you are here it's surely to find the princess who is in the castle. I wish you good luck");
		WORLD.addNewRoom(room1);

		//Room 2
		Room room2 = new Room("Campfire" , "You are at the campfire , where the LittleFire (a fire that cannot be extinguished) is located" , "HouseFront , StonePath " , false , false , new GameObject(ObjectType.FLOWERS) , null);
		room2.create_ObjectElementforRoom("LittleFire", "You are in front of a fire , there seems to be something where you can put an object", "you need to use stone ",new GameObject(ObjectType.STONE) ,new GameObject(ObjectType.SWORD));
		WORLD.addNewRoom(room2);

		//Room 3
		Room room3 = new Room("HouseFront" , "You are in front of a large country house with a wheal field around it" , "House" , false , false , new GameObject(ObjectType.FISH) , null);
		room3.create_CodeNPCforRoom("Arthur","I am the King Arthur","Who is my most loyal friend and war brother","lancelot","The other exit is Well");
		WORLD.addNewRoom(room3);
		

		//Room 4
		Room room4 = new Room("House" , "You are in the big country house witch seems not to be used for a long time." , "HouseFront " , false , false , null ,null);
		room4.create_NormalElementforRoom("Rug","Large Rug , there seems to bee something underneath","You found the entrance to the Cellar");
		WORLD.addNewRoom(room4);


		//Room 5
		Room room5 = new Room("Cellar","You are in the basement of the house , there are a lots of old objects covered in dust." , "House", false , false , null , null);
		room5.create_NormalElementforRoom("Wall", "It's an old and dusty wall with writting on it", "<< For all the travelers who would like to save the princess there is only one thing to remenber : Shazam >");
		WORLD.addNewRoom(room5);


		//Room 6
		Room room6 = new Room("Well" , "You are on the place of the old well","HouseFront , WellHole, Castle",false,false,new GameObject(ObjectType.KEYS),null);
		room6.create_ObjectNPCforRoom("Homeless","I am hungry ","Do you have something to eat dear adventurer",ObjectType.FISH,"WellHole is a dead end");
		WORLD.addNewRoom(room6);
		
		//Room 7 
		Room room7 = new Room("Castle" , "You are in the courtyard of the castle.","Well, Dungeon",false,false,null,null);
		WORLD.addNewRoom(room7);
		
		//Room 8
		Room room8 = new Room("Dungeon" , "You are in the highest tower of the castle with the princess on her bed.","Castle , Reality",false,false, null,null);
		room8.create_ObjectNPCforRoom("Princess", "She was waiting for you " , "Dear Hero you took to much time to come do you have something for me ",ObjectType.FLOWERS,"Hopefuly you have something that please me so you are forgiven");
		WORLD.addNewRoom(room8);

		//Room9
		Room room9 = new Room("WellHole" , "You are in a Hole Congratulation Fake Hero","Nowhere ( you are Dead )",false,true,null,null);
		WORLD.addNewRoom(room9);
		//Room10
		Room room10 = new Room("Reality" , "Time to start Working","your friends who are waiting you outside",true,false,null,null);
		WORLD.addNewRoom(room10);


		// Exit Room1 :
			//to room2
			Exit exit1_2 = new NormalExit(room2);
			room1.addExit("Campfire", exit1_2);
		// Exit Room2 : 
			//to room1
			Exit exit2_1 = new NormalExit(room1);
			room2.addExit("StonePath", exit2_1);
			//to room3
			Exit exit2_3 = new NormalExit(room3);
			room2.addExit("HouseFront", exit2_3);
		// Exit Room3 : 
			//to room2
			Exit exit3_2 = new NormalExit(room2);
			room3.addExit("campfire", exit3_2);
			//to room4
			Exit exit3_4 = new NormalExit(room4);
			room3.addExit("House", exit3_4);
			//to room5
			Exit exit3_6 = new NormalExit(room6);
			room3.addExit("Well",exit3_6);
		// Exit Room4 :
			//to room3
			Exit exit4_3 = new NormalExit(room3);
			room4.addExit("HouseFront",exit4_3);
			//to room5
			Exit exit4_5 = new NormalExit(room5);
			room4.addExit("Cellar",exit4_5);
		//Exit Room5 :
			//to room4
			Exit exit5_4 = new NormalExit(room4);
			room5.addExit("House",exit5_4);
		//Exit Room6 :
			//to room3
			Exit exit6_3 = new NormalExit(room3);
			room6.addExit("HouseFront",exit6_3);
			//to room9
			Exit exit6_9 = new NormalExit(room9);
			room6.addExit("WellHole",exit6_9);
			//to room7
			
			Exit exit6_7 = new CodeExit(room7, "Shazam"){
								private static final long serialVersionUID = -8438742037126742696L;
								@Override
								public void action()
								{
									FunctionAux.printf("The code is correct.");
								}
							};
			room6.addExit("castle",exit6_7);
		//Exit Room7 :
			//to room6
			Exit exit7_6 = new NormalExit(room6);
			room7.addExit("Well",exit7_6);
			// to room8
			Exit exit7_8 = new ObjectExit(room8, ObjectType.KEYS) {
								private static final long serialVersionUID = -8438742037126742696L;
								@Override
								public void action()
								{
									FunctionAux.printf("The keys open the door.");
								}
			};
			room7.addExit("Dungeon",exit7_8);
		//Exit Room8 :
			//to room7
			Exit exit8_7 = new NormalExit(room7);
			room8.addExit("Castle",exit8_7);
			//to room10
			Exit exit8_10 = new NormalExit(room10);
			room8.addExit("Reality",exit8_10);

			WORLD.startLocation();
	}

	//=== Constructors ===//
	private World(){

		this.hero = Hero.getHero();
		this.hero.herosetName();
	}

	

	//=== Methods ===//
	public static World getWorld(){

		return WORLD;
	}
	
	public String getNameCurrentLocation()
	{
		return this.currentLocation.getName();
	}

	public Hero getHero()
	{
		return this.hero;
	}
	
	public void startLocation()
	{
		this.currentLocation = this.roomList.get(0);
	}


	public Map<String, Exit> getCurrentLocationRoomsMap()
	{
		return this.currentLocation.getExitList();
	}



    public void moveLocation(String RoomName)
    {
        Room newRoom = this.currentLocation.goToNextRoom(RoomName);
        if(newRoom != null)
        {
            this.currentLocation = newRoom;
            this.printRooms();
            this.checkVictory();
        }
    }

	public boolean heroAlive(){

		return this.hero.isHeroAlive();
	}

	public void kill(){

		this.hero.killHero();
	}

	public Room getCurrentRoom()
	{
		return this.currentLocation;
	}
	
	public void printInventory()
	{
		this.hero.printInventory();
	}

	public void addNewRoom(Room room){
		this.roomList.add(room);
	}

	public void printRooms()
	{	
		this.currentLocation.printRoom();
		
	}
	
	public void reprintRooms()
	{
		this.currentLocation.setRoomIsAlreadyPrint(false);
		this.printRooms();
	}

	public void lookRoom()
	{	
		this.currentLocation.printObject();
		this.currentLocation.elementName();
		this.currentLocation.npcName();
	}

	public void interract()
	{
		this.currentLocation.printNpc();
	}

	public void examine(){
		this.currentLocation.printElement();
	}
	
	public void dropObject(String obj)
	{
		GameObject o = null;
		if(this.hero.isObjectInList(obj))
		{
			o = hero.removeObject(obj);
		}

		if(o!=null)
		{
			if(this.currentLocation.hasElement() && (this.currentLocation.isObjectElement() && this.currentLocation.elementHasObject() && this.currentLocation.checkConditionElement(o)))
				{
					hero.addObject(this.currentLocation.getObjectElement());
					System.out.println("something new in your inventory");
				}
			else 
				{
				if(this.currentLocation.hasNPC() && (this.currentLocation.isObjectNPC() && this.currentLocation.checkConditionNPC(o)))
					{
						this.currentLocation.npcAction(o);
					}
				else
					{
						System.out.println("Object not required or not the awaited object");
						hero.addObject(o);
					}
			
				}
		}
		else
			{
			System.out.println("Not in your inventory");
			}
	}


	public boolean end()
	{
		return this.currentLocation.iswin();
	}



	public boolean isObjectInList(List<GameObject> oList, String object)
	{
		for(GameObject o : oList)
		{
			ObjectType type = o.getType();
			if(type.toString().equalsIgnoreCase(object))
			{
				return true;
			}
		}
		return false;
	}
	
	public void checkVictory()
	{
		if(this.currentLocation.islose())
			this.kill();
		if(this.currentLocation.iswin())
		{
			System.out.println("Congratulation Hero you saved our beloved princess.");
		}

	}

	public boolean win()
	{
		return this.currentLocation.iswin();
	}

	public String getNameHero()
	{
		return this.hero.getName();
	}
}
