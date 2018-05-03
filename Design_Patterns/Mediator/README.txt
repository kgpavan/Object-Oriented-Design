

INTENT 
——————

Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently.
Design an intermediary to decouple many peers.
Promote the many-to-many relationships between interacting peers to "full object status".
Problem
We want to design reusable components, but dependencies between the potentially reusable pieces demonstrates the "spaghetti code" phenomenon (trying to scoop a single serving results in an "all or nothing clump").

DISCUSSION
——————————
In Unix, permission to access system resources is managed at three levels of granularity: world, group, and owner. A group is a collection of users intended to model some functional affiliation. Each user on the system can be a member of one or more groups, and each group can have zero or more users assigned to it. Next figure shows three users that are assigned to all three groups.


If we were to model this in software, we could decide to have User objects coupled to Group objects, and Group objects coupled to User objects. Then when changes occur, both classes and all their instances would be affected.

An alternate approach would be to introduce "an additional level of indirection" - take the mapping of users to groups and groups to users, and make it an abstraction unto itself. This offers several advantages: Users and Groups are decoupled from one another, many mappings can easily be maintained and manipulated simultaneously, and the mapping abstraction can be extended in the future by defining derived classes.

Partitioning a system into many objects generally enhances reusability, but proliferating interconnections between those objects tend to reduce it again. The mediator object: encapsulates all interconnections, acts as the hub of communication, is responsible for controlling and coordinating the interactions of its clients, and promotes loose coupling by keeping objects from referring to each other explicitly.

The Mediator pattern promotes a "many-to-many relationship network" to "full object status". Modelling the inter-relationships with an object enhances encapsulation, and allows the behavior of those inter-relationships to be modified or extended through subclassing.

An example where Mediator is useful is the design of a user and group capability in an operating system. A group can have zero or more users, and, a user can be a member of zero or more groups. The Mediator pattern provides a flexible and non-invasive way to associate and manage users and groups.




INTRODUCTION 
————————————

Today’s world runs on software. Software runs in almost everything now, it is not only used in computers. Smart television, mobile phones, wrist watches, washing machines, etc. are having embedded software which operates the machine.

A big electronic company has asked you to develop a piece of software to operate its new fully automatic washing machine. The company has provided you with the hardware specification and the working knowledge of the machine. In the specification, they have provided you the different washing programs the machine supports. They want to produce a fully automatic washing machine that will require almost 0% of human interaction. The user should only need to connect the machine with a tap to supply water, load the clothes to wash, set the type of clothes in the machine like cotton, silk, or denims etc, provide detergent and softener to their respective trays, and press the start button.

The machine should be smart enough to fill the water in the drum, as much as required. It should adjust the wash temperature by itself by turning the heater on, according to the type of clothes in it. It should start the motor and spin the drum as much required, rinse according to the clothes needs, use soil removal if required, and softener too.

As an Object Oriented developer, you started analyzing and classifying objects, classes, and their relationships. Let’s check some of the important classes and parts of the system. First of all, a Machine class, which has a drum. So a Drum class, but also a heater, a sensor to check the temperature, a motor. Additionally, the machine also has a valve to control the water supply, a soil removal, detergent, and a softener.

These classes have a very complex relationship with each other, and the relationship also varies. Please note that currently we are taking only about the high level abstraction of the machine. If we try to design it without keeping much of OOP principles and patterns in mind, then the initial design would be very tightly coupled and hard to maintain. This is because the above classes should contact with each other to get the job done. Like for example, the Machine class should ask the Valve class to open the valve, or the Motor should spin the Drum at certain rpm according to the wash program set (which is set by the type of clothes in the machine). Some type of clothes require softener or soil removal while others don’t, or the temperature should be set according to the type of clothes.

If we allow classes to contact each other directly, that is, by providing a reference, the design will become very tightly coupled and hard to maintain. It would become very difficult to change one class without affecting the other. Even worse, the relationship between the classes varies, according to the different wash programs, like different temperature for different type of clothes. So these classes won’t able to be reused. Even worse, in order to support all the wash programs we need to put control statements like if-else in the code which would make the code even more complex and difficult to maintain.

To decouple these objects from each other we need a mediator, which will contact the object on behalf of the other object, hence providing loose coupling between them. The object only needs to know about the mediator, and perform operations on it. The mediator will perform operations on the required underlying object in order to get the work done.

The Mediator Pattern is best suited for this, but before implementing it to solve our problem. Let’s first know more about the Mediator Design Pattern.






MEDIATOR PATTERN 
————————————————

The Mediator Pattern defines an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently.

Rather than interacting directly with each other, objects ask the Mediator to interact on their behalf which results in reusability and loose coupling. It encapsulates the interaction between the objects and makes them independent from each other. This allows them to vary their interaction with other objects in a totally different way by implementing a different mediator. The Mediator helps to reduce the complexity of the classes. Each object no longer has to know in detail about how to interact with the other objects. The coupling between objects goes from tight and brittle to loose and agile.


The Mediator design pattern should be your first choice any time you have a set of objects that are tightly coupled. If every one of a series of objects has to know the internal details of the other objects, and maintaining those relationships becomes a problem, think of the Mediator. Using a Mediator means the interaction code has to reside in only one place, and that makes it easier to maintain. Using a mediator can hide a more serious problem: If you have multiple objects that are too tightly coupled, your encapsulation may be faulty. It might be time to rethink how you’ve broken your program into objects.


————————————————————————————————————————————————————————————————————————————————
The classess which hold reference of the mediator are called colleagues. The major participants of the Mediator Pattern are:

	Mediator: Defines an interface for communicating with Colleague objects.

	ConcreteMediator: Implements cooperative behavior by coordinating Colleague objects. It also knows and maintains its colleagues.

	Colleague Classes: Each Colleague class knows its Mediator object. Each colleague communicates with its mediator whenever it would have otherwise communicated with another colleague.
————————————————————————————————————————————————————————————————————————————————






USE OF THE MEDIATOR PATTENR 
———————————————————————————

	A set of objects communicate in well-defined but complex ways. The resulting interdependencies are unstructured and difficult to understand.

	Reusing an object is difficult because it refers to and communicates with many other objects.

	A behavior that’s distributed between several classes should be customizable without a lot of sub-classing.


MEDIATOR PATTERN IN JDK
———————————————————————
The following are the usages of the Mediator Pattern in JDK.

	java.util.concurrent.ScheduledExecutorService (all scheduleXXX() methods)

	java.util.concurrent.ExecutorService (the invokeXXX() and submit() methods)

	java.util.concurrent.Executor#execute()

	java.util.Timer (all scheduleXXX() methods)

	java.lang.reflect.Method#invoke()


	










———————————————————————————————————————————————————————————————————————————————————————

## Intent
Define an object that encapsulates how a set of objects interact.
Mediator promotes loose coupling by keeping objects from referring to each
other explicitly, and it lets you vary their interaction independently.

![alt text](./etc/mediator_1.png "Mediator")

## Applicability
Use the Mediator pattern when

* a set of objects communicate in well-defined but complex ways. The resulting interdependencies are unstructured and difficult to understand
* reusing an object is difficult because it refers to and communicates with many other objects
* a behavior that's distributed between several classes should be customizable without a lot of subclassing

## Real world examples

* All scheduleXXX() methods of [java.util.Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)
* [java.util.concurrent.Executor#execute()](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executor.html#execute-java.lang.Runnable-)
* submit() and invokeXXX() methods of [java.util.concurrent.ExecutorService](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html)
* scheduleXXX() methods of [java.util.concurrent.ScheduledExecutorService](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ScheduledExecutorService.html)
* [java.lang.reflect.Method#invoke()](http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html#invoke-java.lang.Object-java.lang.Object...-)

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)

———————————————————————————————————————————————————————————————————————————————————————





Participants

    The classes and objects participating in this pattern are:

Mediator  (IChatroom)
defines an interface for communicating with Colleague objects
ConcreteMediator  (Chatroom)
implements cooperative behavior by coordinating Colleague objects
knows and maintains its colleagues
Colleague classes  (Participant)
each Colleague class knows its Mediator object
each colleague communicates with its mediator whenever it would have otherwise communicated with another colleague