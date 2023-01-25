JFLAGS = -g
JC = javac

CLASSES = \
		game/interfaces/conditions/NormalCondition.java \
		game/interfaces/conditions/ObjectCondition.java \
		game/interfaces/conditions/CodeCondition.java \
		game/interfaces/moveObject/AddRemoveObject.java \
		game/objects/ObjectType.java \
		game/objects/GameObject.java \
		game/characters/Character.java \
		game/characters/hero/Hero.java \
		game/characters/NPC/NPC.java \
		game/characters/NPC/NormalNPC.java \
		game/characters/NPC/ObjectNPC.java \
		game/characters/NPC/CodeNPC.java \
		game/elements/Element.java \
		game/elements/NormalElement.java \
		game/elements/ObjectElement.java \
		game/elements/CodeElement.java \
		game/exits/Exit.java \
		game/exits/NormalExit.java \
		game/exits/ObjectExit.java \
		game/exits/CodeExit.java \
		game/orders/Order.java \
		game/orders/OrderDecoding.java \
		game/orders/OrderType.java \
		game/rooms/Room.java \
		game/world/World.java \
		game/world/WorldReplace.java \
		game/saveGame/SaveLoad.java \
		game/FunctionAux.java \
		game/Main.java

all:
	@echo "Creating all .class files"
	@$(JC) $(JFLAGS) $(CLASSES)

run: all
	@clear
	@echo "Game is running:"
	@java game.Main

clean:
	@echo "Clean all .class files"
	@$(RM) $(CLASSES:.java=.class)