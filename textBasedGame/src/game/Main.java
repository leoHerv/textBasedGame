package game;

import java.util.List;

import game.orders.OrderDecoding;
import game.world.World;
import game.world.WorldReplace;

public class Main {

	public static void main(String[] args) {
		
		World w = World.getWorld();
		WorldReplace wr = new WorldReplace(w);


		w.printRooms();
		
		while(w.heroAlive() && !w.end())
		{
			String s = OrderDecoding.readString();
			s = OrderDecoding.stringToLowerCase(s);
			
			if (s.equals("quit"))
				break;

			List<String> sList = OrderDecoding.stringToListString(s);
			OrderDecoding.useOrder(sList, wr);
		}

		if(!w.heroAlive()){
			System.out.println("GAME OVER");
		}
		if(w.heroAlive() && w.win()){
			System.out.println("Congratulation you are The Hero of our World we are very grateful to you  until we found a better one ");
		}
	}
}
