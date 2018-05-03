

COMMAND DESIGN PATTERN 
——————————————————————


## Intent 
—————————

Encapsulate a request as an object, thereby letting you

Parameterize clients with different requests, queue or log requests, and

Support undoable operations.


The command design pattern (aslo known as Action, Transaction) used in situations where is needed to issue requests to objects without knowing anything about the operation being requested or the receiver of the request. Encapsulate a request as an object, thereby letting you parametrize clients with different requests, queue or log requests, and support undoable operations. Promote "invocation of a method on an object" to full object status. The Command Design Pattern is a behavioral design pattern and helps to decouples the invoker from the receiver of a request. 

Intent of the Command Design Pattern is to encapsulate a request as an object, thereby letting the developer to parameterize clients with different requests, queue or log requests, and support undoable operations.

In general, an object-oriented application consists of a set of interacting objects each offering limited, focused functionality. In response to user interaction, the application carries out some kind of processing. For this purpose, the application makes use of the services of different objects for the processing requirement.


Command decouples the object that invokes the operation from the one that knows how to perform it. To achieve this separation, the designer creates an abstract base class that maps a receiver (an object) with an action (a pointer to a member function). The base class contains an execute() method that simply calls the action on the receiver.

All clients of Command objects treat each object as a "black box" by simply invoking the object's virtual execute() method whenever the client requires the object's "service".

A Command class holds some subset of the following: an object, a method to be applied to the object, and the arguments to be passed when the method is applied. The Command's "execute" method then causes the pieces to come together. Sequences of Command objects can be assembled into composite (or macro) commands.


## Structure 
————————————

In terms of implementation, the application may depend on a designated object that invokes methods on these objects by passing the required data as arguments. This designated object can be referred to as an invoker as it invokes operations on different objects. The invoker may be treated as part of the client application. The set of objects that actually contain the implementation to offer the services required for the request processing can be referred to as Receiver objects.

Using the Command pattern, the invoker that issues a request on behalf of the client and the set of service-rendering Receiver objects can be decoupled. The Command pattern suggests creating an abstraction for the processing to be carried out or the action to be taken in response to client requests. This abstraction can be designed to declare a common interface to be implemented by different concrete implementers referred to as Command objects. Each Command object represents a different type of client request and the corresponding processing.

A given Command object is responsible for offering the functionality required to process the request it represents, but it does not contain the actual implementation of the functionality. Command objects make use of Receiver objects in offering this functionality.

The client that creates a command is not the same client that executes it. This separation provides flexibility in the timing and sequencing of commands. Materializing commands as objects means they can be passed, staged, shared, loaded in a table, and otherwise instrumented or manipulated like any other object.

Command objects can be thought of as "tokens" that are created by one client that knows what need to be done, and passed to another client that has the resources for doing it.


## Formula 
——————————

Command: Declares an interface for executing an operation.

ConcreteCommand(CC): Defines a binding between a Receiver object and an action.
Implements Execute by invoking the corresponding operation(s) on Receiver.

Client: Creates a CC object and sets its receiver

Invoker: Asks the command to carry out the request

Receiver: Knows how to perform the operations associated with carrying out a request. Any class may serve as a Receiver



Participants

    The classes and objects participating in this pattern are:

Command  (Command)
declares an interface for executing an operation
ConcreteCommand  (CalculatorCommand)
defines a binding between a Receiver object and an action
implements Execute by invoking the corresponding operation(s) on Receiver
Client  (CommandApp)
creates a ConcreteCommand object and sets its receiver
Invoker  (User)
asks the command to carry out the request
Receiver  (Calculator)
knows how to perform the operations associated with carrying out the request.





## Example 
——————————

To understand the Command Design Pattern let’s create an example to execute different types of jobs. A job can be anything in a system, for example, sending emails, SMS, logging, and performing some IO functions.

The Command pattern would help to decouple the invoker from a receiver and helps to execute any type of job without knowing its implementation. Let us make this example more interesting by creating threads which will help to execute these jobs concurrently. As these jobs are independent of each other, so the sequence of execution of these jobs is not really important. We will create a thread pool to limit the number of threads to execute jobs. A command object will encapsulates jobs and will hand it over to a thread from the pool that will execute the job.


## Applicability
————————————————

Parameterize objects by an action to perform. You can express such parameterization in a procedural language with a callback function, that is, a function that's registered somewhere to be called at a later point. Commands are an object-oriented replacement for callbacks.

Specify, queue, and execute requests at different times. A Command object can have a lifetime independent of the original request. If the receiver of a request can be represented in an address space-independent way, then you can transfer a command object for the request to a different process and fulfill the request there

Support undo. The Command's execute operation can store state for reversing its effects in the command itself. The Command interface must have an added Unexecute operation that reverses the effects of a previous call to execute. Executed commands are stored in a history list. Unlimited-level undo and redo is achieved by traversing this list backwards and forwards calling unexecute and execute, respectively

Support logging changes so that they can be reapplied in case of a system crash. By augmenting the Command interface with load and store operations, you can keep a persistent log of changes. Recovering from a crash involves reloading logged commands from disk and re-executing them with the execute operation

Structure a system around high-level operations build on primitive operations. Such a structure is common in information systems that support transactions. A transaction encapsulates a set of changes to data. The Command pattern offers a way to model transactions. Commands have a common interface, letting you invoke all transactions the same way. The pattern also makes it easy to extend the system with new transactions


## Typical Use Case
————————————————————

i.   To keep a history of requests

ii.  Implement callback functionality

iii. Implement the undo functionality



## Real World Examples
——————————————————————

i.   [java.lang.Runnable](http://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html)

ii.  [Netflix Hystrix](https://github.com/Netflix/Hystrix/wiki)

iii. [javax.swing.Action](http://docs.oracle.com/javase/8/docs/api/javax/swing/Action.html)




