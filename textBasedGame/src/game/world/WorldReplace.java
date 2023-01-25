package game.world;

public class WorldReplace {

	private World world;
	
	//=== Constructor ===//
	public WorldReplace(World world)
	{
		this.world = world;
	}
	
	//=== Function that replace the current world with "r". ===//
	public void replace(WorldReplace r)
	{
		this.world = r.getWorld();
	}
	
	//=== Getter ===//
	public World getWorld()
	{
		return this.world;
	}
}
