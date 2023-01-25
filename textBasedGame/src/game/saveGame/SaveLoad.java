package game.saveGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import game.FunctionAux;
import game.world.World;

public abstract class SaveLoad {
	
	// Take the name of a file and return a output stream.
	private static ObjectOutputStream openOutputStream(String nameFile)
	{
		FileOutputStream file = null;
		ObjectOutputStream output = null;
		try 
		{
			file = new FileOutputStream(nameFile + ".ser");
			try 
			{
				output = new ObjectOutputStream(file);
			} 
			catch (IOException e) 
			{
				FunctionAux.printf("Save: Failed to open the output stream to save the file.");
			}
		} 
		catch (FileNotFoundException e) 
		{
			FunctionAux.printf("Save: Failed to open file.");
		}
		return output;
	}
	
	// Take the name of a file and return a input stream.
	private static ObjectInputStream openInputStream(String nameFile)
	{
		FileInputStream file = null;
		ObjectInputStream input = null;
		try 
		{
			file = new FileInputStream(nameFile + ".ser");
			try 
			{
				input = new ObjectInputStream(file);
			} 
			catch (IOException e) 
			{
				FunctionAux.printf("Load: Failed to open the input stream to save the file.");
			}
		} 
		catch (FileNotFoundException e) 
		{
			FunctionAux.printf("Load: Failed to open file.");
		}
		return input;
	}
	
	// Allows you to save a world in a file "nameFile".
	public static void save(World world, String nameFile)
	{
		ObjectOutputStream output = openOutputStream(nameFile);
		if(output != null)
		{
			try 
			{
				if(output != null)
				{
					output.writeObject(world);
				}
			}
			catch (IOException e) 
			{
				FunctionAux.printf("Save: Failed to write int the file");
			}
		}
	}
	
	// Allows to load a world from a file "nameFile".SS
	public static World load(String nameFile)
	{
		ObjectInputStream input = openInputStream(nameFile);
		World world = null;
		if(input != null)
		{
			try 
			{
				world = (World)input.readObject();
			} 
			catch (IOException e) 
			{
				FunctionAux.printf("Load: Failed to read in the file.");
			} 
			catch (ClassNotFoundException e) 
			{
				FunctionAux.printf("Load: Class does not exist.");
			}
		}
		return world;
	}
}
