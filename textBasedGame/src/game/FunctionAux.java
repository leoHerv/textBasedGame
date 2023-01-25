package game;


public class FunctionAux {

	// Simple println().
	public static void printf()
	{
		System.out.println();
	}
	
	// Simple println() with text.
	public static void printf(String s)
	{
		System.out.println(s);
	}
	
	public static void clearScreen()
	{
		try{
            String operatingSystem = System.getProperty("os.name");
			/*
            if(operatingSystem.contains("Windows"))
            {        
            	// Does not work with Eclipse.
                //ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                //Process startProcess = pb.inheritIO().start();
                //startProcess.waitFor();
            } 
            else 
            {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }*/
			ProcessBuilder pb = new ProcessBuilder("clear");
			Process startProcess = pb.inheritIO().start();

			startProcess.waitFor();
        }catch(Exception e){
            System.out.println(e);
        }
	}
}
