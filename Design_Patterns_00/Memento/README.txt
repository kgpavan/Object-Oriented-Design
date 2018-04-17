
INTENT
——————

	Without violating encapsulation, capture and externalize an object's internal state so that the object can be returned to this state later.

	A magic cookie that encapsulates a "check point" capability.

	Promote undo or rollback to full object status.


PROBLEM
———————
Need to restore an object back to its previous state (e.g. "undo" or "rollback" operations).

DISCUSSION
——————————
The client requests a Memento from the source object when it needs to checkpoint the source object's state. The source object initializes the Memento with a characterization of its state. The client is the "care-taker" of the Memento, but only the source object can store and retrieve information from the Memento (the Memento is "opaque" to the client and all other objects). If the client subsequently needs to "rollback" the source object's state, it hands the Memento back to the source object for reinstatement.

An unlimited "undo" and "redo" capability can be readily implemented with a stack of Command objects and a stack of Memento objects.

————————————————————————————————————————————————————————————————————————————————
The Memento design pattern defines three distinct roles:

	Originator - the object that knows how to save itself.
	Caretaker - the object that knows why and when the Originator needs to save and restore itself.
	Memento - the lock box that is written and read by the Originator, and shepherded by the Caretaker.
————————————————————————————————————————————————————————————————————————————————


CHECK LIST
——————————

	Identify the roles of “caretaker” and “originator”.

	Create a Memento class and declare the originator a friend.

	Caretaker knows when to "check point" the originator.

	Originator creates a Memento and copies its state to that Memento.

	Caretaker holds on to (but cannot peek into) the Memento.

	Caretaker knows when to "roll back" the originator.

	Originator reinstates itself using the saved state in the Memento.


RULES OF THUMB 
——————————————
Command and Memento act as magic tokens to be passed around and invoked at a later time. In Command, the token represents a request; in Memento, it represents the internal state of an object at a particular time. Polymorphism is important to Command, but not to Memento because its interface is so narrow that a memento can only be passed as a value.

Command can use Memento to maintain the state required for an undo operation.
Memento is often used in conjunction with Iterator. An Iterator can use a Memento to capture the state of an iteration. The Iterator stores the Memento internally.	




———————————————————————————————————————————————————————————————————————————————————————

INTRODUCTION 
————————————

Sometimes it’s necessary to record the internal state of an object. This is required when implementing checkpoints and “undo” mechanisms that let users back out of tentative operations or recover from errors. You must save state information somewhere, so that you can restore objects to their previous conditions. But objects normally encapsulate some or all of their state, making it inaccessible to other objects and impossible to save externally. Exposing this state would violate encapsulation, which can compromise the application’s reliability and extensibility.

The Memento pattern can be used to accomplish this without exposing the object’s internal structure. The object whose state needs to be captured is referred to as the originator.

To illustrate the use of the Memento Pattern, let’s see an example. We will create a class that will contain two double type fields and we will run some mathematical operations on it. We will provide users with the undo operation. If the results after some operations are not satisfied to a user, the user can call the undo operation which will restore the state of the object to the last saved point.

The example also includes a save point mechanism which is used by the user to save the state of the object. We will also provide a variety of undo operations. A simple undo would restore the object state to the previous save point. An undo with the specified save point will restore that particular state of the object and undo all will delete all the saved state of the object and restore the object in the initialized state, when the object was created.

Before implementing the pattern, let’s know more about the Memento Design Pattern.




STRUCTURE 
—————————
The Memento Pattern’s intent is, without violating encapsulation, to capture and externalize an object’s internal state so that the object can be restored to this state later.

Memento

Stores internal state of the Originator object. The memento may store as much or as little of the originator’s internal state as necessary at its originator’s discretion.
Protects against access by objects other than the originator. Mementos have effectively two interfaces. Caretaker sees a narrow interface to the Memento—it can only pass the memento to other objects. Originator, in contrast, sees a wide interface, one that lets it access all the data necessary to restore itself to its previous state. Ideally, only the originator that produced the memento would be permitted to access the memento’s internal state.

Originator

Creates a memento containing a snapshot of its current internal state.
Uses the memento to restore its internal state.

Caretaker

Is responsible for the memento’s safekeeping.
Never operates on or examines the contents of a memento.


When a client wants to save the state of the originator, it requests the current state from the originator. The originator stores all those attributes that are required for restoring its state in a separate object referred to as a Memento and returns it to the client. Thus a Memento can be viewed as an object that contains the internal state of another object, at a given point of time. A Memento object must hide the originator variable values from all objects except the originator. In other words, it should protect its internal state against access by objects other than the originator. Towards this end, a Memento should be designed to provide restricted access to other objects while the originator is allowed to access its internal state.

When the client wants to restore the originator back to its previous state, it simply passes the memento back to the originator. The originator uses the state information contained in the memento and puts itself back to the state stored in the Memento object.


WHEN TO USE 
———————————
Use the Memento Pattern in the following cases:

	A snapshot of (some portion of) an object’s state must be saved so that it can be restored to that state later

	A direct interface to obtaining the state would expose implementation details and break the object’s encapsulation.


MEMENTO PATTERN IN JDK 
——————————————————————
	
	i. java.util.Date
	ii. java.io.Serializable
	