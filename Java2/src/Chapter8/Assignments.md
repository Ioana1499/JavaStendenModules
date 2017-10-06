#Assignments Index
Assignments for this week:
 - 8.1 to 8.19
 
# Assignment Solutions
 - **Exercise 8.1 Open the project network-v1. It contains the classes exactly as we have discussed them here. Create 
    some MessagePost objects and some PhotoPost objects. Create a NewsFeed object. Enter the posts into the news feed, 
    and then display the feed’s contents.**
    - Done, see [The Assignment81 Class](Network/Test/Assignments81.java) 
    - I also modified the project so I can alter objects after I added them. see the following classes: 
        - [The Altered NewsFeed Class](Network/NewsFeed.java)
        - [The Altered MessagePost Class](Network/MessagePost.java)
        - [The Altered PhotoPost Class](Network/PhotoPost.java)
        - [The New Post Contract Class](Network/Post.java)
    
 - **Exercise 8.2 Try the following. Create a MessagePost object. Enter it into the news feed. Display the news feed. 
     You will see that the post has no associated comments. Add a comment to the MessagePost object on the object 
     bench (the one you entered into the news feed). When you now list the news feed again, will the post listed 
     there have a comment attached? Try it. Explain the behavior you observe.**
     - Yes, the `NewsFeed.show()` iterates through the photo and message collections and prints each value.
     
 - **Exercise 8.3 Draw an inheritance hierarchy for the people in your place of study or work. For example, if you 
     are a university student, then your university probably has students (first- year students, second-year students, . . .), 
     professors, tutors, office personnel, etc.**
     ![alt text](SchoolDiagram.png "Diagram of school hierarchy.")
     
 - **Exercise 8.4 Open the project network-v2. This project contains a version of the network application, rewritten 
     to use inheritance, as described above. Note that the class diagram displays the inheritance relationship. 
     Open the source code of the MessagePost class and remove the “ extends Post ” phrase. Close the editor. What 
     changes do you observe in the class diagram? Add the “ extends Post ” phrase again.**
     - I used my own version of the project. But removing the `extends Post` would result in the connection being 
     broken between the Post and MessagePost classes. The MessagePost class loses its base methods and properties that
     were inherited from the Posts class..
     
 - **Exercise 8.5 Create a MessagePost object. Call some of its methods. Can you call the inherited methods 
     (for example, addComment )? What do you observe about the inherited methods?**
     - You can call the public methods from parent and child, package private methods from parent and child, protected
     methods from parent only by child, private methods only from parent.
     
 - **Exercise 8.6 In order to illustrate that a subclass can access non-private elements of its superclass without 
     any special syntax, try the following slightly artificial modification to the MessagePost and Post classes. 
     Create a method called printShortSummary in the MessagePost class. Its task is to print just the phrase 
     “Message post from NAME ”, where NAME should show the name of the author. However, because the username 
     field is private in the Post class, it will be necessary to add a public getUserName method to Post . 
     Call this method from printShortSummary to access the name for printing. Remember that no special syntax 
     is required when a subclass calls a superclass method. Try out your solution by creating a MessagePost object. 
     Implement a similar method in the PhotoPost class.**
     - Done see [The Post Contract ](Network/Post.java) with the [The Message Class ](Network/MessagePost.java) and [The Message Class ](Network/PhotoPost.java)
     
 - **Exercise 8.7 Set a breakpoint in the first line of the MessagePost class’s constructor. Then create a 
     MessagePost object. When the debugger window pops up, use Step Into to step through the code. Observe the 
     instance fields and their initialization. Describe your observations**
     - The parents constructor is called with `child.super()` this will invoke the parents constructor and initiate 
     the super class. If you don't call super with the username argument it won't get initiates. 
     
 - **Exercise 8.8 Open the network-v2 project. Add a class for event posts to the project. Create some event-post 
     objects and test that all methods work as expected.**
     - Done see: [The EventPost Class ](Network/EventPost.java)
     
 - **Exercise 8.9 Order these items into an inheritance hierarchy: apple, ice cream, bread, fruit, food item, 
     cereal, orange, dessert, chocolate mousse, baguette.**
     - FoodItem
        - Fruit
            - Apple
            - Orange
        - Dessert
            - IceCream
            - ChocolateMousse
        - Bread
            - baguette
        - Cereal
     
 - **Exercise 8.10 In what inheritance relationship might a touch pad and a mouse be? (We are talking about 
     computer input devices here, not small furry mammals.)**
     - Computer
        - I/O
            - InputDevices
               - Mouse
               - TouchPad
               - Keyboard
            - OutputDevices
               - Printer
               - Screen
        - Storage
           - DiskDrive
           - HardDisk
           - MagneticTape
     
 - **Exercise 8.11 Sometimes things are more difficult than they first seem. Consider this: In what kind of 
     inheritance relationship are Rectangle and Square ? What are the arguments? Discuss.**
     - Shape _An certain 2D object_
         - Eclipse _An object with no corners_
            - circle
         - Polygon _An object with strait lines and corners_
             - Quadrilaterals _An object with 4 corners_
                 - parallelogram _An object with 2 parallel lines that are the same length._
                     - Rectangle _An object with 4 parallel lines_
                        - Square _An object with 4 parallel lines and 4 are the same length._
             - Triangles _An object with 3 corners_
                - EquilateralTriangle _An object with every side is the same length_
                - IsoscelesTriangle _An object with 2 the of the same corner angles_
             - Pentagons _An object with 5 corners_
     
 - **Exercise 8.12 Assume that we have four classes: Person , Teacher , Student , and PhDStudent . Teacher and 
     Student are both subclasses of Person . PhDStudent is a subclass of Student.**
    - **a. Which of the following assignments are legal, and why or why not?**
        ``` 
        Person p1 = new Student(); // Fine, because Person > Student.
        Person p2 = new PhDStudent(); // Fine, because Person > Student > PhDStudent.
        PhDStudent phd1 = new Student(); // Wrong, because PhDStudent < Student.
        Teacher t1 = new Person(); // Wrong, because Teacher < Person.
        Student s1 = new PhDStudent(); // Fine, because Student > PhDStudent.
        ```
    - **b. Suppose that we have the following legal declarations and assignments:**
        ```
         Person p1 = new Person(); 
         Person p2 = new Person(); 
         PhDStudent phd1 = new PhDStudent(); 
         Teacher t1 = new Teacher(); 
         Student s1 = new Student(); 
         ```
    - **Based on those just mentioned, which of the following assignments are legal, and why or why not?** 
        ```
        s1 = p1; // Wrong, because Student < Persion
        s1 = p2; // Wrong, because Student < Persion
        p1 = s1; // Fine, becouse Person > Student
        t1 = s1; // Wrong, because student has nothing to to with an teacher.
        s1 = phd1; // Fine, because Student > PhDStudent
        phd1 = s1; wrong, because PhDStudent < Student
        ```
        
 - **Exercise 8.13 Test your answers to the previous question by creating bare-bones versions of the classes mentioned 
     in that exercise and trying it out in BlueJ.**
     - Not done, Its obvious...
     
 - **Exercise 8.14 What has to change in the NewsFeed class when another Post subclass 
     (for example, a class EventPost ) is added? Why?**
     - You could add an other list for the new type or make an list with an generic Post type. (or HashSet would be nice)
     
 - **Exercise 8.15 Use the documentation of the Java standard class libraries to find out about 
     the inheritance hierarchy of the collection classes. Draw a diagram showing the hierarchy**
     - Collection
        - List
            - Abstract Sequential List
                - LinkedList
                - DoubleLinkedList
            - Vector
                - Stack
            - ArrayList
        - Set
            - TreeSet
            - HashSet
                - LinkedHashSet
        - Map
            - TreeMap
            - HashMap
                - LinkedHashMap
            - IdentityHashMap
     
 - **Exercise 8.16 Go back to the lab-classes project from Chapter 1. Add instructors to the 
     project (every lab class can have many students and a single instructor). Use inheritance to 
     avoid code duplication between students and instructors (both have a name, contact details, etc.).**
     - Done see [The Person Contract](LabClass/Person.java) with the  [The Student Class](LabClass/Student.java) and [The Instructor Class](LabClass/Instructor.java). And [The LabClass Class](LabClass/LabClass.java)
     
 - **Exercise 8.17 Draw an inheritance hierarchy representing parts of a computer system (processor, memory, 
     disk drive, DVD drive, printer, scanner, keyboard, mouse, etc.).**
     - Already don at exercise 8.10
     
 - **Exercise 8.18 Look at the code below. You have four classes ( O , X , T , and M ) and a variable of each of these.**
     ```
     O o; 
     X x; 
     T t; 
     M m;
     ``` 
     **The following assignments are all legal (assume that they all compile):**
     ```
     m = t; 
     m = x; 
     o = t; 
     ```
     **The following assignments are all illegal (they cause compiler errors):**
      ```
      o = m; 
      o = x; 
      x = o; 
      ```
      **What can you say about the relationships of these classes? Draw a class diagram.**
      - M _Is super class_ and _Is parent of O and X_
         - o _Is child of M_ and _Is parent of O_
            - t _Is child of o_ 
         - x _Is child of M_ 

      
 - **Exercise 8.19 Draw an inheritance hierarchy of AbstractList and all its (direct and indirect) subclasses as 
     they are defined in the Java standard library.**
    - AbstractList
        - ArrayList
        - AbstractSequentialList
            - LinkedList
        - Vector
            - Stack