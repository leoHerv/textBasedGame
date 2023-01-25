General informations:
	Our project is a game inspired by the game "Colossal Cave Adventure", it is a game based on the display of a text to describe a
	situation and thus to be able with this information to advance in the game via a console. Here we have a room principle, we
	moves from room to room to advance in the game and in this one we can have different interactions to be able to progress.
	Our game is called JAMG for "Just another Medieval Game" because in the end, as our game is based on a medieval universe, it made sense.

Project launch:
	The project is developed under java 17 on linux.
	To compile the project a makeFile is available, just go with a console in the /scr directory and do "make".
	There are 3 commands for the makefile: "make" which compiles the project, "make run" which compiles and runs the project and
	"make clean" which allows to erase all the .class of the project once we have finished.

How to play:
	To play the game you have to use commands, in the game there is one that allows you to display what all the others are doing which is "HELP".
	The different commands:
	GO:
		Allows you to move from one room to another "GO roomName"
 	HELP:
		Allows you to see all the usable commands "HELP"
 	LOOK:
		Allows you to see the different things in the room and to give the description of the current room "LOOK"
 	TAKE:
		Allows you to take an object from the room "TAKE objectName
	DROP:
		Allows you to put an object back in the room that comes from our inventory "DROP objectName"
 	USE:
		Allows to give an object to the NPC(non-player character) which is in the room "USE nomObjet" or to give this object or a code
		to an exit to unlock it "USE objectName ExitName"
 	EXAMINE:
		Allows to have the description of the element which is in the room "EXAMINE"
 	INTERACT:
		Allows you to talk to the NPC who is in the room "INTERACT"
 	INVENTORY:
		Allows you to display all the objects that the hero has in his inventory "INVENTORY"
 	SAVE:
		Allows you to save the game "SAVE saveFileName"
 	LOAD:
		Allows you to load a game save "LOAD saveFileName"
 	QUIT:
		Allows you to quit the game "QUIT"

Authors:
	BEN MOHAND Macine
	HERVOUET Leo
	Student at the University of Poitiers in the third year of a computer science degree.

Credits:
	Thanks to Skapin Xavier, Peltier Samuel and Defaye Alexis for helping and guiding us for this project.

	Inspired by the game "Colossal Cave Adventure", Adventure game, 1976 (Crowther); 1977 (Woods).