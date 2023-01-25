package game.orders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import game.world.World;
import game.world.WorldReplace;

public abstract class OrderDecoding {


	public static String readString()
	{
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		return OrderDecoding.stringToLowerCase(s);
	}
	
	public static String stringToLowerCase(String s)
	{
		return s.toLowerCase();
	}
	
	public static List<String> stringToListString(String s)
	{
		return new ArrayList<String>(Arrays.asList(s.split(" ")));
	}
	
	public static void printListString(List<String> sList)
	{
		sList.forEach(s -> System.out.print(s + ", "));
		System.out.println();
	}
	
	public static OrderType getOrderFromStringList(List<String> sList)
	{
		Iterator<String> it = sList.iterator();
		if(it.hasNext())
		{
			String order = (String) it.next();
			it.remove();
			OrderType[] orderTab = OrderType.values();
			for(int i = 0; i < orderTab.length; i++)
			{
				if((stringToLowerCase(orderTab[i].name())).compareTo(order) == 0)
				{
					return orderTab[i];
				}
			}
		}
		return OrderType.NULL;
	}
	
	public static int isListValideForOrder(List<String> sList)
	{
		if(sList != null)
		{
			int nbOfAgr = sList.size();
			return nbOfAgr;
		}
		else
		{
			return 0;
		}
	}
	
	public static <T> T getFstList(List<T> l)
	{
		if(l != null)
		{
			Iterator<T> it = l.iterator();
			return it.next();
		}
		else
		{
			return null;
		}
	}
	
	public static <T> void removeFstList(List<T> l)
	{
		if(l != null)
		{
			Iterator<T> it = l.iterator();
			it.next();
			it.remove();
		}
	}
	
	public static <T> T getAndRemoveFstList(List<T> l)
	{
		T element = OrderDecoding.getFstList(l);
		OrderDecoding.removeFstList(l);
		return element;
	}
	
	public static void useOrder(List<String> sList, WorldReplace wr)
	{
		OrderType order = OrderDecoding.getOrderFromStringList(sList);
		int nbArg = isListValideForOrder(sList);
		boolean nbArgInvalid = false;
		World world = wr.getWorld();
		switch(order)
		{
			case GO:
				if(nbArg == 1)
				{
					Order.go(world, OrderDecoding.getAndRemoveFstList(sList));
					break;
				}
				nbArgInvalid = true;
				break;
			case HELP:
				if(nbArg == 0)
				{
					Order.help(world);
					break;
				}
				nbArgInvalid = true;
				break;
			case LOOK:
				if(nbArg == 0)
				{
					Order.look(world);
					break;
				}
				nbArgInvalid = true;
				break;
			case TAKE:
				if(nbArg == 1)
				{
					Order.take(world, OrderDecoding.getAndRemoveFstList(sList));
					break;
				}
				nbArgInvalid = true;
				break;
			case DROP:
				if(nbArg == 1)
				{
					Order.drop(world, OrderDecoding.getAndRemoveFstList(sList));
					break;
				}
				nbArgInvalid = true;
				break;
			case USE:
				if(nbArg == 2)
				{
					Order.use(world, OrderDecoding.getAndRemoveFstList(sList), OrderDecoding.getAndRemoveFstList(sList));
					break;
				}
				if(nbArg == 1)
				{
					Order.use(world, OrderDecoding.getAndRemoveFstList(sList));
					break;
				}
				nbArgInvalid = true;
				break;
			case EXAMINE:
				if(nbArg == 0)
				{
					Order.examine(world);
					break;
				}
				nbArgInvalid = true;
				break;
			case INTERACT:
				if(nbArg == 0)
				{
					Order.interact(world);
					break;
				}
				nbArgInvalid = true;
				break;
			case INVENTORY:
				if(nbArg == 0)
				{
					Order.inventory(world);
					break;
				}
				nbArgInvalid = true;
				break;
			case SAVE:
				if(nbArg == 1)
				{
					Order.save(world, OrderDecoding.getAndRemoveFstList(sList));
					break;
				}
				nbArgInvalid = true;
				break;
			case LOAD:
				if(nbArg == 1)
				{
					Order.load(wr, OrderDecoding.getAndRemoveFstList(sList));
					break;
				}
				nbArgInvalid = true;
				break;
			case QUIT:
				if(nbArg == 0)
				{
					Order.quit(world);
					break;
				}
				nbArgInvalid = true;
				break;
			default: 
				System.out.println("The command is invalid.");
				break;
		}
		if(nbArgInvalid)
		{
			System.out.println("The number of arguments is invalid.");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
