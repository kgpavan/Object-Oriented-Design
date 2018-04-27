

INTENT 
——————

Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.
An object-oriented state machine
wrapper + polymorphic wrappee + collaboration


PROBLEM 
————————————
A monolithic object's behavior is a function of its state, and it must change its behavior at run-time depending on that state. Or, an application is characterized by large and numerous case statements that vector flow of control based on the state of the application.


DISCUSSION 
——————————

	The State pattern is a solution to the problem of how to make behavior depend on state.

	Define a "context" class to present a single interface to the outside world.

	Define a State abstract base class.Represent the different "states" of the state machine as derived classes of the State base class.

	Define state-specific behavior in the appropriate State derived classes.

	Maintain a pointer to the current "state" in the "context" class.

	To change the state of the state machine, change the current "state" pointer.
	The State pattern does not specify where the state transitions will be defined. The choices are two: the "context" object, or each individual State derived class. The advantage of the latter option is ease of adding new State derived classes. The disadvantage is each State derived class has knowledge of (coupling to) its siblings, which introduces dependencies between subclasses.

	A table-driven approach to designing finite state machines does a good job of specifying state transitions, but it is difficult to add actions to accompany the state transitions. The pattern-based approach uses code (instead of data structures) to specify state transitions, but it does a good job of accommodating state transition actions.




STRUCTURE 
—————————

The state machine's interface is encapsulated in the "wrapper" class. The wrappee hierarchy's interface mirrors the wrapper's interface with the exception of one additional parameter. The extra parameter allows wrappee derived classes to call back to the wrapper class as necessary. Complexity that would otherwise drag down the wrapper class is neatly compartmented and encapsulated in a polymorphic hierarchy to which the wrapper object delegates.




————————————————————————————————————————————————————————————————————————————————————

INTRODUCTION
————————————

To illustrate the use of the State Design Pattern, let us help a company which is looking to build a robot for cooking. The company wants a simple robot that can simply walk and cook. A user can operate a robot using a set of commands via remote control. Currently, a robot can do three things, it can walk, cook, or can be switched off.

The company has set protocols to define the functionality of the robot. If a robot is in “on” state you can command it to walk. If asked to cook, the state would change to “cook” or if set to “off”, it will be switched off.

Similarly, when in “cook” state it can walk or cook, but cannot be switched off. And finally, when in “off” state it will automatically get on and walk when the user commands it to walk but cannot cook in off state.

This might look like an easy implementation: a robot class with a set of methods like walk, cook, off, and states like on, cook, and off. We can use if-else branches or switch to implement the protocols set by the company. But too much if-else or switch statements will create a maintenance nightmare as complexity might increase in the future.

You might think that we can implement this without issues using if-else statements, but as a change comes the code would become more complex. The requirement clearly shows that the behavior of an object is truly based on the state of that object. We can use the State Design Pattern which encapsulates the states of the object into another individual class and keeps the context class independent of any state change.

Let’s first know about the State Design Pattern and then we will implement it to solve the problem above.



DESCRIPTION 
————————————
The State Design Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

The state of an object can be defined as its exact condition at any given point of time, depending on the values of its properties or attributes. The set of methods implemented by a class constitutes the behavior of its instances. Whenever there is a change in the values of its attributes, we say that the state of an object has changed.

The State pattern is useful in designing an efficient structure for a class, a typical instance of which can exist in many different states and exhibit different behavior depending on the state it is in. In other words, in the case of an object of such a class, some or all of its behavior is completely influenced by its current state. In the State design pattern terminology, such a class is referred to as a Context class. A Context object can alter its behavior when there is a change in its internal state and is also referred as a Stateful object.

The State pattern suggests moving the state-specific behavior out of the Context class into a set of separate classes referred to as State classes. Each of the many different states that a Context object can exist in can be mapped into a separate State class. The implementation of a State class contains the context behavior that is specific to a given state, not the overall behavior of the context itself. The context acts as a client to the set of State objects in the sense that it makes use of different State objects to offer the necessary state-specific behavior to an application object that uses the context in a seamless manner.

By encapsulating the state-specific behavior in separate classes, the context implementation becomes simpler to read: free of too many conditional statements such as if-else or switch-case constructs. When a Context object is first created, it initializes itself with its initial State object. This State object becomes the current State object for the context. By replacing the current State object with a new State object, the context transitions to a new state.

The client application using the context is not responsible for specifying the current State object for the context, but instead, each of the State classes representing specific states are expected to provide the necessary implementation to transition the context into other states. When an application object makes a call to a Context method (behavior),it forwards the method call to its current State object.


——————————————————————————————————————————————————————————————————————————————————————
STRUCTURE 
—————————

Context
———————
Defines the interface of interest to clients.
Maintains an instance of a ConcreteState subclass that defines the current state.

State
—————
Defines an interface for encapsulating the behavior associated with a particular state of the Context.


ConcreteState subclasses
————————————————————————
Each subclass implements a behavior associated with a state of the Context.



——————————————————————————————————————————————————————————————————————————————————————
USAGES 
——————

	An object’s behavior depends on its state, and it must change its behavior at run-time depending on that state.

	Operations have large, multipart conditional statements that depend on the object’s state. This state is usually represented by one or more enumerated constants. Often, several operations will contain this same conditional structure. The State pattern puts each branch of the conditional in a separate class. This lets you treat the object’s state as an object in its own right that can vary independently from other objects.


STATE DESIGN PATTERN IN JDK 
———————————————————————————
javax.faces.lifecycle.LifeCycle#execute()












———————————————————————————————————————————————————————————————————————————————————————
## Also known as
Objects for States

## Intent
Allow an object to alter its behavior when its internal state
changes. The object will appear to change its class.

![alt text](./etc/state_1.png "State")

## Applicability
Use the State pattern in either of the following cases

* an object's behavior depends on its state, and it must change its behavior at run-time depending on that state
* operations have large, multipart conditional statements that depend on the object's state. This state is usually represented by one or more enumerated constants. Often, several operations will contain this same conditional structure. The State pattern puts each branch of the conditional in a separate class. This lets you treat the object's state as an object in its own right that can vary independently from other objects.

## Real world examples

* [javax.faces.lifecycle.Lifecycle#execute()](http://docs.oracle.com/javaee/7/api/javax/faces/lifecycle/Lifecycle.html#execute-javax.faces.context.FacesContext-) controlled by [FacesServlet](http://docs.oracle.com/javaee/7/api/javax/faces/webapp/FacesServlet.html), the behavior is dependent on current phase of lifecycle.
* [JDiameter - Diameter State Machine](https://github.com/npathai/jdiameter/blob/master/core/jdiameter/api/src/main/java/org/jdiameter/api/app/State.java)

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
