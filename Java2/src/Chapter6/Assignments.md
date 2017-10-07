# Assignments Chapter 6
###Required assignments for this week: :heavy_exclamation_mark:
 - Exercises 6.1 t/m 6.7 :white_check_mark:
 - Exercises 6.8 :white_check_mark:
 - Exercises 6.9 t/m 6.14 :white_check_mark:
 - Exercises 6.16 t/m 6.18 :white_check_mark:
 - Exercises 6.20 t/m 6.21 :white_check_mark:
 - Exercises 6.22 t/m 6.25 :white_check_mark:
 - Exercises 6.28 t/m 6.33 :white_check_mark:

# Assignment solutions
 - **Exercise 6.1 Open the project zuul-bad. (This project is called “bad” because its implemen-
	tation contains some bad design decisions, and we want to leave no doubt that this should not
	be used as an example of good programming practice!) Execute and explore the application.
	The project comment gives you some information about how to run it.
	While exploring the application, answer the following questions:**
 - **What does this application do?**
    - Amusing an user.
 - **What commands does the game accept?**
    - `go`
    - `quit`
    - `help`
 - **What does each command do?**
    - `go` Nothing because of errors in the code... But its meant to change the users position on the map.
    - `quit` Nothing because of errors in the code... But is should terminate the game.
    - `help` Nothing because of errors in the code... But it shows the available commands.
 - **How many rooms are in the scenario?**
    - Five: Outside, Theatre, pub, lab and office.
 - **Draw a map of the existing rooms.**
    - Done.
    
 - **Exercise 6.2 After you know what the whole application does, try to find out what each indi-
   vidual class does. Write down for each class its purpose. You need to look at the source code
   to do this. Note that you might not (and need not) understand all of the source code. Often,
   reading through comments and looking at method headers is enough.**
   - Class `Command` Data object representing an command and its arguments.
   - Class `CommandWords` Object storing valid commands.
   - Class `Game` The main entry point of the game and the world generator.
   - Class `Parser` Handles user input.
   - Class `Room` An data object representing an room in the game.
   
 - **Exercise 6.3 Design your own game scenario. Do this away from the computer. Do not
     think about implementation, classes, or even programming in general. Just think about invent-
     ing an interesting game. This could be done with a group of people.**
   - Done, its a game where player must continue to complete boring java 
     assignments without killing himself.
     
 - **Exercise 6.4 Draw (on paper) a map for the game you invented in Exercise 6.3. Open the
     zuul-bad project and save it under a different name (e.g., zuul). This is the project you will use
     for making improvements and modifications throughout this chapter. You can leave off the
     -bad suffix, because it will (hopefully) soon not be that bad anymore. <br><br>
     As a first step, change the createRooms method in the Game class to create the rooms and
     exits you invented for your game. Test!**
     Done see [ZuulBad](ZuulBad)
 - **Exercise 6.5 Implement and use a separate printLocationInfo method in your
     project, as discussed in this section. Test your changes.**
   - Done see [ZuulBad :: Game.java ](ZuulBad/Game.java) and [ZuulBad :: Room.java ](ZuulBad/Room.java) 
     
 - **Exercise 6.6 Make the changes we have described to the Room and Game classes.**
     - Done see [ZuulBad :: Room.java](ZuulBad/Room.java)
 - **Exercise 6.7 Make a similar change to the printLocationInfo method of Game so that
     details of the exits are now prepared by the Room rather than the Game. Define a method in
     Room with the following signature:**
     ```java
     /**
     * Return a description of the room’s exits,
     * for example, "Exits: north west".
     * @return A description of the available exits.
     */
     public String getExitString()
    ```
   - Done see [ZuulBad :: Game.java ](ZuulBad/Game.java) and [ZuulBad :: Room.java ](ZuulBad/Room.java) 

 - **Exercise 6.8 Implement the changes described in this section in your own zuul project.**
   - Done see [ZuulBad :: Room.java ](ZuulBad/Room.java)

 - **Exercise 6.9 Look up the keySet method in the documentation of HashMap. What does it do?**
   - You get an Set containing the key values.
 
 - **Exercise 6.10 Explain, in detail and in writing, how the getExitString method shown in
     Code 6.7 works.**
   - I done it differently with an stream:
   ```java
   public String getExitString()
   {
       return "Exits:" + exits.keySet()
               .stream()
               .map( str -> str )
               .collect(Collectors.joining( " " ));
   }
   ```
 - **Exercise 6.11 Implement the changes described in this section in your own zuul project.**
   - Done see [ZuulBad :: Room.java ](ZuulBad/Room.java)
   
 - **Exercise 6.12 Draw an object diagram with all objects in your game, the way they are just
     after starting the game**
   - Not done
   
 - **Exercise 6.13 How does the object diagram change when you execute a go command?**
   - Dont know.
   
 - **Exercise 6.14 Add the look command to your version of the zuul game.**
   - Done see [ZuulBad :: Game.java ](ZuulBad/Game.java)
   
 - **Exercise 6.15 Add another command to your game. For a start, you could choose some-
     thing simple, such as a command eat that, when executed, just prints out “You have eaten
     now and you are not hungry any more.” Later, we can improve this so that you really get hun-
     gry over time and you need to find food.**
     - Done see [ZuulBad :: Game.java ](ZuulBad/Game.java) I created the kill command:
     ```java
     private void killCommand()
     {
         System.out.println("We are killing the JVM!");
         while(true)
         {
             // How manny treads will it take?
             Thread thread = new Thread(new Runnable(){
                 @Override
                 public void run() {
                     while(true) {
                         killCommand();
                     }
                 }
             });
             thread.start();
         }
     }
     ```
 - **Exercise 6.16 Implement the improved version of printing out the command words, as
     described in this section.**
   -  Done see [ZuulBad :: CommandWords.java ](ZuulBad/CommandWords.java)
      ```java
      public void showALl()
      {
          Arrays.stream(validCommands).forEach( System.out::println );
      }
      ```
 - **Exercise 6.17 If you now add another new command, do you still need to change the Game
     class? Why?**
   - Nope, the classes responsibilities are separated. 
 - **Exercise 6.18 Implement the suggested change. Make sure that your program still works
     as before.**
   -  Done see [ZuulBad :: CommandWords.java ](ZuulBad/CommandWords.java)
         ```java
         public String getCommandList()
         {
             return Arrays.stream(validCommands).collect(Collectors.joining(" "));
         }
         ```
 - **Exercise 6.19 Find out what the model-view-controller pattern is. You can do a web search
     to get information, or you can use any other sources you find. How is it related to the topic
     discussed here? What does it suggest? How could it be applied to this project? (Only discuss
     its application to this project, as an actual implementation would be an advanced-challenge
     exercise.)**
   - MVC can be used to structure different layers of an application into:
     - A data layer `the model`, that contains: Business logic, Databases, etc
     - A action layer `the controller`, that contains: actions/paths the application can execute.
     - A presentation layer `the view`, that contains: forms, windows, text boxes, terminal output, webpages.
 
 - **Exercise 6.20 Extend either your adventure project or the zuul-better project so that a room
     can contain a single item. Items have a description and a weight. When creating rooms and
     setting their exits, items for this game should also be created. When a player enters a room,
     information about an item present in this room should be displayed.**
   -  Done see [ZuulBetter :: Item.java ](ZuulBetter/Item.java) and [ZuulBetter :: Room.java ](ZuulBetter/Room.java)  
   
 - **Exercise 6.21 How should the information be produced about an item present in a room?
     Which class should produce the string describing the item? Which class should print it?
     Why? Explain in writing. If answering this exercise makes you feel you should change your
     implementation, go ahead and make the changes.**
   -  Done see [ZuulBetter :: Item.java ](ZuulBetter/Item.java) and [ZuulBetter :: Room.java ](ZuulBetter/Room.java)  

 - **Exercise 6.22 Modify the project so that a room can hold any number of items. Use a
     collection to do this. Make sure the room has an addItem method that places an item into the
     room. Make sure all items get shown when a player enters a room.**
   -  Done see [ZuulBetter :: Item.java ](ZuulBetter/Item.java) and [ZuulBetter :: Room.java ](ZuulBetter/Room.java)  
 
 - **Exercise 6.23 Implement a back command. This command does not have a second word.
     Entering the back command takes the player into the previous room he/she was in.**
   -  Done see [ZuulBetter :: Game.java ](ZuulBetter/Game.java) and [ZuulBetter :: Room.java ](ZuulBetter/Room.java)  
 
 - **Exercise 6.24 Test your new command. Does it work as expected? Also test cases where
     the command is used incorrectly. For example, what does your program do if a player types a
     second word after the back command? Does it behave sensibly?**
   - Yes, it works see  [ Test.ZuulBetter.TestGame.java :: main ](Test/ZuulBetter/TestGame.java)
 
 - **Exercise 6.25 What does your program do if you type “back” twice? Is this behavior sensible?**
   - You will go one room back.
 
 - **Exercise 6.28 Refactor your project to introduce a separate Player class. A Player object should store at 
     least the current room of the player, but you may also like to store the player’s name or other information.**
   - Done, see [ZuulBetter :: Player.java ](ZuulBetter/Player.java) 
 
 - **Exercise 6.29 Implement an extension that allows a player to pick up one single item. This includes implementing 
     two new commands: take and drop.**
   - Done, see [ZuulBetter :: Player.java ](ZuulBetter/Player.java) 
 
 - **Exercise 6.30 Extend your implementation to allow the player to carry any number of
     items.**
   - Done, see [ZuulBetter :: Player.java ](ZuulBetter/Player.java)
 
 - **Exercise 6.31 Add a restriction that allows the player to carry items only up to a specified
     maximum weight. The maximum weight a player can carry is an attribute of the player.**
   - Done, see [ZuulBetter :: Player.java ](ZuulBetter/Player.java) 
   
 - **Exercise 6.32 Implement an items command that prints out all items currently carried and
     their total weight.**
   - Done, see [ZuulBetter :: Player.java ](ZuulBetter/Player.java) 
 
 - **Exercise 6.33 Add a magic cookie item to a room. Add an eat cookie command. If a player
     finds and eats the magic cookie, it increases the weight that the player can carry. (You might
     like to modify this slightly to better fit into your own game scenario.)**
   - Done, see [ZuulBetter :: Player.java ](ZuulBetter/Player.java) 