


101 design patterns & tips for developers - sourcemaking <https://sourcemaking.Com/design-patterns-and-tips>



Object oriented design
——————————————————————

1. Object oriented programming (oop) concepts like
Encapsulation, inheritance, polymorphism and abstraction

2. Design patterns

3. Solid principles







————————————————————————————————————————————————————————————————————————————————————
Solid design principles 
———————————————————————


In computer programming, solid (single responsibility, open-closed, liskov substitution, interface segregation and dependency inversion) is a mnemonic acronym introduced by michael feathers for the "First five principles" named by robert c. Martin in the early 2000s[3] that stands for five basic principles of object-oriented programming and design. The intention is that these principles, when applied together, will make it more likely that a programmer will create a system that is easy to maintain and extend over time.[3] the principles of solid are guidelines that can be applied while working on software to remove code smells by providing a framework through which the programmer may refactor the software's source code until it is both legible and extensible. It is part of an overall strategy of agile and adaptive software development.

	
1. Single responsibility principle (s)
A class should have only a single responsibility (I.E. Only one potential change in the software's specification should be able to affect the specification of the class)

2. Open/ close principle (o)
“software entities … should be open for extension, but closed for modification.”

3. Liskov substitution principle (l)
“objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program.” see also design by contract.

4. Interface segregation principle (I)
“many client-specific interfaces are better than one general-purpose interface.”

5. Dependency inversion principle (d)
One should depend upon abstractions, [not] concretions.
————————————————————————————————————————————————————————————————————————————————————





Software design patterns
————————————————————————


1. Adapter design pattern
—————————————————————————

The adapter pattern is a software design pattern (also known as wrapper, an alternative naming shared with the decorator pattern) that allows the interface of an existing class to be used as another interface.[1] it is often used to make existing classes work with others without modifying their source code.

2. Facade design pattern
————————————————————————
The facade pattern makes a complex interface easier to use, using a facade class. The facade pattern provides a unified interface to a set of interface in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

You want to provide a simple interface to a complex subsystem. Subsystems often get more complex as they evolve. Most patterns, when applied, result in more and smaller classes. This makes the subsystem more reusable and easier to customize, but it also becomes harder to use for clients that don’t need to customize it. A facade can provide a simple default view of the subsystem that is good enough for most clients. Only clients needing more customizability will need to look beyond the facade. There are many dependencies between clients and the implementation classes of an abstraction. Introduce a facade to decouple the subsystem from clients and other subsystems, thereby promoting subsystem independence and portability. You can layer your subsystems. Use a facade to define an entry point to each subsystem level. If subsystems are dependent, then you can simplify the dependencies between them by making them communicate with each other solely through their facades.

3. Composite design pattern
The composite pattern allows you to compose objects into a tree structure to represent the part-whole hierarchy which means you can create a tree of objects that is made of different parts, but that can be treated as a whole one big thing. Composite lets clients to treat individual objects and compositions of objects uniformly, that’s the intent of the composite pattern.

4. Bridge design pattern
The bridge pattern’s intent is to decouple an abstraction from its implementation so that the two can vary independently. It puts the abstraction and implementation into two different class hierarchies so that both can be extend independently.

5. Singleton design pattern
The singleton pattern is used when there must be exactly one instance of a class, and it must be accessible to clients from a well-known access point or when the sole instance should be extensible by sub-classing, and clients should be able to use an extended instance without modifying their code.

6. Observer design pattern
The observer pattern is a kind of behavior pattern which is concerned with the assignment of responsibilities between objects. It should be used when an abstraction has two aspects, one dependent on the other, when a change to one object requires changing others, and you don’t know how many objects need to be changed or when an object should be able to notify other objects without making assumptions about who these objects are. In other words, you don’t want these objects tightly coupled.

7. Mediator design pattern
The mediator pattern defines an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently. Rather than interacting directly with each other, objects ask the mediator to interact on their behalf which results in reusability and loose coupling. You will learn how and when the mediator design pattern should be used and how to structure your code in order to implement it.

8. Proxy design pattern
The proxy pattern provides a surrogate or placeholder for another object to control access to it. It comes up with many different variations. Some of the important variations are, remote proxy, virtual proxy, and protection proxy. In this lesson, we will know more about these variations and we will implement each of them in Java. But before we do that, let’s get to know more about the proxy pattern in general. You will learn how and when the proxy design pattern should be used and how to structure your code in order to implement it.

9. Chain of responsibility design pattern
The chain of responsibility pattern is a behavior pattern in which a group of objects is chained together in a sequence and a responsibility (a request) is provided in order to be handled by the group. If an object in the group can process the particular request, it does so and returns the corresponding response. Otherwise, it forwards the request to the subsequent object in the group.

10. Flyweight design pattern
The flyweight pattern is designed to control object creation where objects in an application have great similarities and are of a similar kind, and provides you with a basic caching mechanism. It allows you to create one object per type (the type here differs by a property of that object), and if you ask for an object with the same property (already created), it will return you the same object instead of creating a new one.

11. Builder design pattern
The intent of the builder pattern is to separate the construction of a complex object from its representation, so that the same construction process can create different representations. This type of separation reduces the object size. The design turns out to be more modular with each implementation contained in a different builder object. Adding a new implementation (I.E., adding a new builder) becomes easier.

12. Factory design pattern
The factory method pattern gives us a way to encapsulate the instantiations of concrete types. The factory method pattern encapsulates the functionality required to select and instantiate an appropriate class, inside a designated method referred to as a factory method. The factory method selects an appropriate class from a class hierarchy based on the application context and other influencing factors. It then instantiates the selected class and returns it as an instance of the parent class type.

13. Abstract factory design pattern
The abstract factory (a.K.A. Kit) is a design pattern which provides an interface for creating families of related or dependent objects without specifying their concrete classes. The abstract factory pattern takes the concept of the factory method pattern to the next level. An abstract factory is a class that provides an interface to produce a family of objects.

14. Prototype design pattern
The prototype design pattern is used to specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype. The concept is to copy an existing object rather than creating a new instance from scratch, something that may include costly operations. The existing object acts as a prototype and contains the state of the object.

15. Memento design pattern
Sometimes it’s necessary to record the internal state of an object. This is required when implementing checkpoints and “undo” mechanisms that let users back out of tentative operations or recover from errors. You must save state information somewhere, so that you can restore objects to their previous conditions. But objects normally encapsulate some or all of their state, making it inaccessible to other objects and impossible to save externally. Exposing this state would violate encapsulation, which can compromise the application’s reliability and extensibility. The memento pattern can be used to accomplish this without exposing the object’s internal structure.

16. Templete design pattern
The template design pattern is a behavior pattern and, as the name suggests, it provides a template or a structure of an algorithm which is used by users. A user provides its own implementation without changing the algorithm’s structure. The template pattern defines the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template method lets subclasses to redefine certain steps of an algorithm without changing the algorithm’s structure.

17. State design pattern
The state design pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class. The state of an object can be defined as its exact condition at any given point of time, depending on the values of its properties or attributes. The set of methods implemented by a class constitutes the behavior of its instances. Whenever there is a change in the values of its attributes, we say that the state of an object has changed.

18. Strategy design pattern
The strategy design pattern seems to be the simplest of all design patterns, yet it provides great flexibility to your code. This pattern is used almost everywhere, even in conjunction with the other design patterns. The strategy design pattern defines a family of algorithms, encapsulating each one, and making them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.

19. Command design pattern
The command design pattern is a behavioral design pattern and helps to decouples the invoker from the receiver of a request. The intent of the command design pattern is to encapsulate a request as an object, thereby letting the developer to parameterize clients with different requests, queue or log requests, and support undoable operations.

20. Interpreter design pattern
The interpreter design pattern is a heavy-duty pattern. It’s all about putting together your own programming language, or handling an existing one, by creating an interpreter for that language. Given a language, we can define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.

21. Decorator design pattern
The intent of the decorator design pattern is to attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to sub-classing for extending functionality. The pattern is used to extend the functionality of an object dynamically without having to change the original class source or using inheritance. This is accomplished by creating an object wrapper referred to as a decorator around the actual object.

22. Iterator design pattern
The intent of the iterator design pattern is to provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation. He iterator pattern allows a client object to access the contents of a container in a sequential manner, without having any knowledge about the internal representation of its contents.

23. Visitor design pattern
The visitor design pattern provides you with a way to add new operations on the objects without changing the classes of the elements, especially when the operations change quite often. The intent of the visitor design pattern is to represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.

24. Collections design pattern

25. Combined design pattern

26. Combining design pattern

27. Ducks design pattern

28. Iterenum design pattern

29. Templatemethod design pattern

30. Delegation design pattern 





Solid design principles
———————————————————————


In computer programming, solid (single responsibility, open-closed, liskov substitution, interface segregation and dependency inversion) is a mnemonic acronym introduced by michael feathers for the "First five principles" named by robert c. Martin in the early 2000s[3] that stands for five basic principles of object-oriented programming and design. The intention is that these principles, when applied together, will make it more likely that a programmer will create a system that is easy to maintain and extend over time.[3] the principles of solid are guidelines that can be applied while working on software to remove code smells by providing a framework through which the programmer may refactor the software's source code until it is both legible and extensible. It is part of an overall strategy of agile and adaptive software development.


1. Single responsibility principle (s)
——————————————————————————————————————
A class should have only a single responsibility (I.E. Only one potential change in the software's specification should be able to affect the specification of the class)

2. Open/ close principle (o)
————————————————————————————
“software entities … should be open for extension, but closed for modification.”

3. Liskov substitution principle (l)
————————————————————————————————————
“objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program.” see also design by contract.

4. Interface segregation principle (I)
——————————————————————————————————————
“many client-specific interfaces are better than one general-purpose interface.”

5. Dependency inversion principle (d)
—————————————————————————————————————
One should depend upon abstractions, [not] concretions.






The law of demeter (lod)
————————————————————————

The law of demeter (lod) or principle of least knowledge is a design guideline for developing software, particularly object-oriented programs. In its general form, the lod is a specific case of loose coupling. The guidelines can be succinctly summarized in each of the following ways:

A. Each unit should have only limited knowledge about other units: only units "Closely" related to the current unit.
B. Each unit should only talk to its friends; don't talk to strangers.
C. Only talk to your immediate friends.






Domain driven design

Event driven design 



————————————————————————————————————————————————————————————————————————————————————————

——————————————————————————
Creational design patterns
——————————————————————————

These design patterns are all about class instantiation. This pattern can be further divided into class-creation patterns and object-creational patterns. While class-creation patterns use inheritance effectively in the instantiation process, object-creation patterns use delegation effectively to get the job done.


Abstract factory
————————————————
Creates an instance of several families of classes

Builder
Separates object construction from its representation

Factory method
Creates an instance of several derived classes

Object pool
Avoid expensive acquisition and release of resources by recycling objects that are no longer in use

Prototype
—————————
A fully initialized instance to be copied or cloned

Singleton
A class of which only a single instance can exist


——————————————————————————
Structural design patterns
——————————————————————————

These design patterns are all about class and object composition. Structural class-creation patterns use inheritance to compose interfaces. Structural object-patterns define ways to compose objects to obtain new functionality.


Adapter
———————
Match interfaces of different classes

Bridge
Separates an object’s interface from its implementation

Composite
A tree structure of simple and composite objects

Decorator
Add responsibilities to objects dynamically

Facade
A single class that represents an entire subsystem

Flyweight
A fine-grained instance used for efficient sharing

Private class data
Restricts accessor/mutator access

Proxy
An object representing another object



——————————————————————————
Behavioral design patterns
——————————————————————————


These design patterns are all about class's objects communication. Behavioral patterns are those patterns that are most specifically concerned with communication between objects.


Chain of responsibility
A way of passing a request between a chain of objects

Command
Encapsulate a command request as an object

Interpreter
A way to include language elements in a program

Iterator
Sequentially access the elements of a collection

Mediator
Defines simplified communication between classes

Memento
Capture and restore an object's internal state

Null object
Designed to act as a default value of an object

Observer
A way of notifying change to a number of classes

State
Alter an object's behavior when its state changes

Strategy
Encapsulates an algorithm inside a class

Template method
Defer the exact steps of an algorithm to a subclass

Visitor
Defines a new operation to a class without change
———————————————————————————————————————————————————————————————————————————————————————


———————————————————————————————————————————————————————————————————————————————————————
Software design 
———————————————

Command–query separation (cqrs) design // contract (dbc) methodology
———————————————————————————————————————————————————————————————————————————————————————




Software development antipatterns
—————————————————————————————————

The blob
————————
Procedural-style design leads to one object with a lion’s share of the responsibilities, while most other objects only hold data or execute simple processes. The solution includes refactoring the design to distribute responsibilities more uniformly and isolating the effect of changes.

Continuous obsolescence
————————————————————————
Technology is changing so rapidly that developers often have trouble keeping up with current versions of software and finding combinations of product releases that work together. Given that every commercial product line evolves through new releases, the situation is becoming more difficult for developers to cope with. Finding compatible releases of products that successfully interoperate is even harder.

Lava flow
————————————————
Dead code and forgotten design information is frozen in an ever-changing design. This is analogous to a lava flow with hardening globules of rocky material. The refactored solution includes a configuration management process that eliminates dead code and evolves or refactors design toward increasing quality.

Ambiguous viewpoint
————————————————
Object-oriented analysis and design (ooa&d) models are often presented without clarifying the viewpoint represented by the model. By default, ooa&d models denote an implementation viewpoint that is potentially the least useful. Mixed viewpoints don’t allow the fundamental separation of interfaces from implementation details, which is one of the primary benefits of the object-oriented paradigm.

Functional decomposition
————————————————————————
This antipattern is the output of experienced, nonobject-oriented developers who design and implement an application in an object-oriented language. The resulting code resembles a structural language (pascal, fortran) in class structure. It can be incredibly complex as smart procedural developers devise very “clever” ways to replicate their time-tested methods in an object-oriented architecture.

Poltergeists
————————————————
Poltergeists are classes with very limited roles and effective life cycles. They often start processes for other objects. The refactored solution includes a reallocation of responsibilities to longer-lived objects that eliminate the poltergeists.

Boat anchor
————————————————
A boat anchor is a piece of software or hardware that serves no useful purpose on the current project. Often, the boat anchor is a costly acquisition, which makes the purchase even more ironic.

Golden hammer
————————————————
A golden hammer is a familiar technology or concept applied obsessively to many software problems. The solution involves expanding the knowledge of developers through education, training, and book study groups to expose developers to alternative technologies and approaches.

Dead end
————————
A dead end is reached by modifying a reusable component if the modified component is no longer maintained and supported by the supplier. When these modifications are made, the support burden transfers to the application system developers and maintainers. Improvements in the reusable component are not easily integrated, and support problems can be blamed upon the modification.

Spaghetti code
——————————————
Ad hoc software structure makes it difficult to extend and optimize code. Frequent code refactoring can improve software structure, support software maintenance, and enable iterative development.

Input kludge
————————————
Software that fails straightforward behavioral tests may be an example of an input kludge, which occurs when ad hoc algorithms are employed for handling program input.

Walking through a minefield
———————————————————————————
Using today’s software technology is analogous to walking through a high-tech mine field. Numerous bugs are found in released software products; in fact, experts estimate that original source code contains two to five bugs per line of code.

Cut-and-paste programming
—————————————————————————
Code reused by copying source statements leads to significant maintenance problems. Alternative forms of reuse, including black-box reuse, reduce maintenance issues by having common source code, testing, and documentation.

Mushroom management
———————————————————
In some architecture and management circles, there is an explicit policy to keep system developers isolated from the system’s end users. Requirements are passed second-hand through intermediaries, including architects, managers, or requirements analysts.




Software architecture antipatterns
——————————————————————————————————

Autogenerated stovepipe
———————————————————————
This antipattern occurs when migrating an existing software system to a distributed infrastructure. An autogenerated stovepipe arises when converting the existing software interfaces to distributed interfaces. If the same design is used for distributed computing, a number of problems emerge.

Stovepipe enterprise
————————————————————
A stovepipe system is characterized by a software structure that inhibits change. The refactored solution describes how to abstract subsystem and components to achieve an improved system structure. The stovepipe enterprise antipattern is characterized by a lack of coordination and planning across a set of systems.

Jumble
——————
When horizontal and vertical design elements are intermixed, an unstable architecture results. The intermingling of horizontal and vertical design elements limits the reusability and robustness of the architecture and the system software components.

Stovepipe system
————————————————
Subsystems are integrated in an ad hoc manner using multiple integration strategies and mechanisms, and all are integrated point to point. The integration approach for each pair of subsystems is not easily leveraged toward that of other subsystems. The stovepipe system antipattern is the single-system analogy of stovepipe enterprise, and is concerned with how the subsystems are coordinated within a single system.

Cover your assets
—————————————————
Document-driven software processes often produce less-than-useful requirements and specifications because the authors evade making important decisions. In order to avoid making a mistake, the authors take a safer course and elaborate upon alternatives.

Vendor lock-in
——————————————
Vendor lock-in occurs in systems that are highly dependent upon proprietary architectures. The use of architectural isolation layers can provide independence from vendor-specific solutions.

Wolf ticket
———————————
A wolf ticket is a product that claims openness and conformance to standards that have no enforceable meaning. The products are delivered with proprietary interfaces that may vary significantly from the published standard.

Architecture by implication
———————————————————————————
Management of risk in follow-on system development is often overlooked due to overconfidence and recent system successes. A general architecture approach that is tailored to each application system can help identify unique requirements and risk areas.

Warm bodies
———————————
Software projects are often staffed with programmers with widely varying skills and productivity levels. Many of these people may be assigned to meet staff size objectives (so-called “warm bodies”). Skilled programmers are essential to the success of a software project. So-called heroic programmers are exceptionally productive, but as few as 1 in 20 have this talent. They produce an order of magnitude more working software than an average programmer.

Design by committee
———————————————————
The classic antipattern from standards bodies, design by committee creates overly complex architectures that lack coherence. Clarification of architectural roles and improved process facilitation can refactor bad meeting processes into highly productive events.

Swiss army knife
————————————————
A swiss army knife is an excessively complex class interface. The designer attempts to provide for all possible uses of the class. In the attempt, he or she adds a large number of interface signatures in a futile attempt to meet all possible needs.

Reinvent the wheel
——————————————————
The pervasive lack of technology transfer between software projects leads to substantial reinvention. Design knowledge buried in legacy assets can be leveraged to reduce time-to-market, cost, and risk.

The grand old duke of york
——————————————————————————
Egalitarian software processes often ignore people’s talents to the detriment of the project. Programming skill does not equate to skill in defining abstractions. There appear to be two distinct groups involved in software development: abstractionists and their counterparts the implementationists.
———————————————————————————————————————————————————————————————————————————————————————





———————————————————————————————————————————————————————————————————————————————————————

——————————————
Rules of thumb
——————————————


Structural design pattern
—————————————————————————

	Adapter makes things work after they're designed; bridge makes them work before they are.

	Bridge is designed up-front to let the abstraction and the implementation vary independently. Adapter is retrofitted to make unrelated classes work together.

	Adapter provides a different interface to its subject. Proxy provides the same interface. Decorator provides an enhanced interface.

	Adapter changes an object's interface, decorator enhances an object's responsibilities. Decorator is thus more transparent to the client. As a consequence, decorator supports recursive composition, which isn't possible with pure adapters.

	Composite and decorator have similar structure diagrams, reflecting the fact that both rely on recursive composition to organize an open-ended number of objects.

	Composite can be traversed with iterator. Visitor can apply an operation over a composite. Composite could use chain of responsibility to let components access global properties through their parent. It could also use decorator to override these properties on parts of the composition. It could use observer to tie one object structure to another and state to let a component change its behavior as its state changes.

	Composite can let you compose a mediator out of smaller pieces through recursive composition.

	Decorator lets you change the skin of an object. Strategy lets you change the guts.

	Decorator is designed to let you add responsibilities to objects without subclassing. Composite's focus is not on embellishment but on representation. These intents are distinct but complementary. Consequently, composite and decorator are often used in concert.
	Decorator and proxy have different purposes but similar structures. Both describe how to provide a level of indirection to another object, and the implementations keep a reference to the object to which they forward requests.

	Facade defines a new interface, whereas adapter reuses an old interface. Remember that adapter makes two existing interfaces work together as opposed to defining an entirely new one.

	Facade objects are often singleton because only one facade object is required.

	Mediator is similar to facade in that it abstracts functionality of existing classes. 
	Mediator abstracts/centralizes arbitrary communication between colleague objects, it routinely "Adds value", and it is known/referenced by the colleague objects. In contrast, facade defines a simpler interface to a subsystem, it doesn't add new functionality, and it is not known by the subsystem classes.

	Abstract factory can be used as an alternative to facade to hide platform-specific classes.

	Whereas flyweight shows how to make lots of little objects, facade shows how to make a single object represent an entire subsystem.

	Flyweight is often combined with composite to implement shared leaf nodes.

	Flyweight explains when and how state objects can be shared.


Creational design pattern
—————————————————————————

	Sometimes creational patterns are competitors: there are cases when either prototype or abstract factory could be used profitably. At other times they are complementary: abstract factory might store a set of prototypes from which to clone and return product objects, builder can use one of the other patterns to implement which components get built. Abstract factory, builder, and prototype can use singleton in their implementation.

	Abstract factory, builder, and prototype define a factory object that's responsible for knowing and creating the class of product objects, and make it a parameter of the system. Abstract factory has the factory object producing objects of several classes. Builder has the factory object building a complex product incrementally using a correspondingly complex protocol. Prototype has the factory object (aka prototype) building a product by copying a prototype object.

	Abstract factory classes are often implemented with factory methods, but they can also be implemented using prototype.

	Abstract factory can be used as an alternative to facade to hide platform-specific classes.

	Builder focuses on constructing a complex object step by step. Abstract factory emphasizes a family of product objects (either simple or complex). Builder returns the product as a final step, but as far as the abstract factory is concerned, the product gets returned immediately.

	Builder is to creation as strategy is to algorithm.

	Builder often builds a composite.

	Factory methods are usually called within template methods.

	Factory method: creation through inheritance. Prototype: creation through delegation.

	Often, designs start out using factory method (less complicated, more customizable, subclasses proliferate) and evolve toward abstract factory, prototype, or builder (more flexible, more complex) as the designer discovers where more flexibility is needed.

	Prototype doesn't require subclassing, but it does require an initialize operation. Factory method requires subclassing, but doesn't require initialize.

	Designs that make heavy use of the composite and decorator patterns often can benefit from prototype as well.



Behavioral dp
—————————————

	Behavioral patterns are concerned with the assignment of responsibilities between objects, or, encapsulating behavior in an object and delegating requests to it.

	Chain of responsibility, command, mediator, and observer, address how you can decouple senders and receivers, but with different trade-offs. Chain of responsibility passes a sender request along a chain of potential receivers. Command normally specifies a sender-receiver connection with a subclass. Mediator has senders and receivers reference each other indirectly. Observer defines a very decoupled interface that allows for multiple receivers to be configured at run-time.

	Chain of responsibility can use command to represent requests as objects.

	Chain of responsibility is often applied in conjunction with composite. There, a component's parent can act as its successor.

	Command and memento act as magic tokens to be passed around and invoked at a later time. In command, the token represents a request; in memento, it represents the internal state of an object at a particular time. Polymorphism is important to command, but not to memento because its interface is so narrow that a memento can only be passed as a value.
	Command can use memento to maintain the state required for an undo operation.
	Macrocommands can be implemented with composite.

	A command that must be copied before being placed on a history list acts as a prototype.

	Interpreter can use state to define parsing contexts.

	The abstract syntax tree of interpreter is a composite (therefore iterator and visitor are also applicable).

	Terminal symbols within interpreter's abstract syntax tree can be shared with flyweight.

	Iterator can traverse a composite. Visitor can apply an operation over a composite.

	Polymorphic iterators rely on factory methods to instantiate the appropriate iterator subclass.

	Mediator and observer are competing patterns. The difference between them is that observer distributes communication by introducing "Observer" and "Subject" objects, whereas a mediator object encapsulates the communication between other objects. We've found it easier to make reusable observers and subjects than to make reusable mediators.

	On the other hand, mediator can leverage observer for dynamically registering colleagues and communicating with them.

	Mediator is similar to facade in that it abstracts functionality of existing classes. Mediator abstracts/centralizes arbitrary communication between colleague objects, it routinely "Adds value", and it is known/referenced by the colleague objects (I.E. It defines a multidirectional protocol). In contrast, facade defines a simpler interface to a subsystem, it doesn't add new functionality, and it is not known by the subsystem classes (I.E. It defines a unidirectional protocol where it makes requests of the subsystem classes but not vice versa).

	Memento is often used in conjunction with iterator. An iterator can use a memento to capture the state of an iteration. The iterator stores the memento internally.

	State is like strategy except in its intent.

	Flyweight explains when and how state objects can be shared.

	State objects are often singletons.

	Strategy lets you change the guts of an object. Decorator lets you change the skin.

	Strategy is to algorithm. As builder is to creation.

	Strategy has 2 different implementations, the first is similar to state. The difference is in binding times (strategy is a bind-once pattern, whereas state is more dynamic).

	Strategy objects often make good flyweights.

	Strategy is like template method except in its granularity.

	Template method uses inheritance to vary part of an algorithm. Strategy uses delegation to vary the entire algorithm.

	The visitor pattern is like a more powerful command pattern because the visitor may initiate whatever is appropriate for the kind of object it encounters.

———————————————————————————————————————————————————————————————————————————————————————















———————————————————————————————————————————————————————————————————————————————————————

Software design and architecture courses
————————————————————————————————————————


Basics of software architecture & design patterns in Java - udemy

Experience design patterns in Java - udemy

Java design patterns and architecture - udemy/ john purcell

From 0 to 1: design patterns - 24 that matter in Java - udemy/ loony cron

Byte size chunks : Java model-view-controller (mvc) - udemy/ loony cron

Software architecture & design - udacity

Software development process - udacity

Software engineering for the web applications - mit open courseare 

Java programming: build a recommendation system - coursera 

Object oriented tuts - derek banas/ Youtube 

Design patterns - derek banas/ Youtube 

Dzone design patterns <https://dzone.Com/refcardz/design-patterns>

OOP design patterns <https://sourcemaking.Com/>

OOP design patterns <http://www.dofactory.com/net/design-patterns>

Dzone domain-driven design (ddd) <https://dzone.Com/refcardz/getting-started-domain-driven>

Behavior driven design (bdd)


———————————————————————————————————————————————————————————
Grokking the system design interview  -  Educative.Io 
———————————————————————————————————————————————————————————


———————————————————————————————————————————————————————————
Four distributed systems architectural patterns - tim berglund/ Youtube 

Distributed systems in one lesson - tim berglund/ Youtube 

How uber scaled its real time infrastructure to trillion events per day - Youtube 

Real-time delivery architecture at twitter - Youtube 

Keynote: twitter's search architecture - Youtube 

Scaling instagram infrastructure - Youtube

Design a parking lot - success in tech/ Youtube 

Messenger service like whatsapp or wechat - success in tech/ Youtube 

System design: how to design twitter - success in tech/ Youtube 

System design: uber lyft ride sharing services - success in tech/ Youtube  
———————————————————————————————————————————————————————————




Software design and architecture specialization  - coursera 
———————————————————————————————————————————————————————————

Object-oriented design - University of alberta / coursera 

Design patterns - University of alberta / coursera 

Software architecture  - University of alberta / coursera 

Service-oriented architecture  - University of alberta / coursera 





Object oriented programming in Java specialization
——————————————————————————————————————————————————
Java programming: solving problems with software - University of california, san diego, duke University

Java programming: arrays, lists, and structured data - University of california, san diego, duke University

Object oriented programming in Java - University of california, san diego, duke University

Data structures and performance - University of california, san diego, duke University





Object oriented Java programming: data structures and beyond specialization
———————————————————————————————————————————————————————————————————————————

Object oriented programming in Java - University of california, san diego

Data structures and performance - University of california, san diego

Advanced data structures in Java - University of california, san diego

Mastering the software engineering interview - University of california, san diego

Capstone: analyzing (social) network data - University of california, san diego





BOOKS
—————

	Patterns for parallel programming - Timothy g. Mattson

	Design patterns: elements of reusable object-oriented software 

	J2ee design patterns - william crawford

	Elegant objects I & II - yegor bugayenko
	
	Head first design patterns

	Head first object-oriented design and analysis

	
MICRO-SERVICE ARCHITECTURE
——————————————————————————

	Building Micro-services - Sam Newman/ Oreilly 

	Production‑ready Micro-services: building standardized systems - Susan J. Fowler/ Oreilly 

	Micro-service architecture: aligning principles, practices, and culture - Irakli Nadareishvili/ Oreilly 

	The tao of Micro-services - Richard Rodger

	Spring Micro-services in action - John Carnell

	Micro-services: flexible software Architecture - Eberhard Wolff

	Mastering Micro-services with java - Sourabh Sharma/ Packt




















———————————————————————————————————————————————————
———————————————————————————————————————————————————
SYSTEM DESIGN, SCALABILITY, DATA HANDLING RESOURCES 
———————————————————————————————————————————————————

THE UNIVERSAL DESIGN PATTERN - STEVE  YEGGE 


- ### System Design, Scalability, Data Handling
    - Considerations from Yegge:
        - scalability
            - Distill large data sets to single values
            - Transform one data set to another
            - Handling obscenely large amounts of data
        - system design
            - features sets
            - interfaces
            - class hierarchies
            - designing a system under certain constraints
            - simplicity and robustness
            - tradeoffs
            - performance analysis and optimization
    - [x] **START HERE**: System Design from HiredInTech: http://www.hiredintech.com/system-design/
    - [x] https://www.quora.com/How-do-I-prepare-to-answer-design-questions-in-a-technical-interview?redirected_qid=1500023
    - [x] 8 Things You Need to Know Before a System Design Interview: http://blog.gainlo.co/index.php/2015/10/22/8-things-you-need-to-know-before-system-design-interviews/
    - [x] Algorithm design: http://www.hiredintech.com/algorithm-design/
    - [x] Database Normalization - 1NF, 2NF, 3NF and 4NF: https://www.Youtube.com/watch?v=UrYLYV7WSHM
    - [x] https://github.com/checkcheckzz/system-design-interview - There are a lot of resources in this one. Look through the articles and examples. I put some of them below.
    - [x] How to ace a systems design interview: http://www.palantir.com/2011/10/how-to-rock-a-systems-design-interview/
    - [x] Numbers Everyone Should Know: http://everythingisdata.wordpress.com/2009/10/17/numbers-everyone-should-know/
    - [x] How long does it take to make a context switch?: http://blog.tsunanet.net/2010/11/how-long-does-it-take-to-make-context.html
    - [x] Transactions Across Datacenters: https://www.Youtube.com/watch?v=srOgpXECblk
    - [x] A plain english introduction to CAP Theorem: http://ksat.me/a-plain-english-introduction-to-cap-theorem/
    - [x] Paxos Consensus algorithm: 
        - short video: https://www.Youtube.com/watch?v=s8JqcZtvnsM
        - extended video with use case and multi-paxos: https://www.Youtube.com/watch?v=JEpsBg0AO6o
        - paper: http://research.microsoft.com/en-us/um/people/lamport/pubs/paxos-simple.pdf
    - [x] Consistent Hashing: http://www.tom-e-white.com/2007/11/consistent-hashing.html
    - [x] NoSQL Patterns: http://horicky.blogspot.com/2009/11/nosql-patterns.html
    - [x] Optional: UML 2.0 Series: https://www.Youtube.com/watch?v=OkC7HKtiZC0&list=PLGLfVvz_LVvQ5G-LdJ8RLqe-ndo7QITYc
    - [x] OOSE: Software Dev Using UML and Java (21 videos): 
        - Can skip this if you have a great grasp of OO and OO design practices.
        - https://www.Youtube.com/playlist?list=PLJ9pm_Rc9HesnkwKlal_buSIHA-jTZMpO
    - [x] SOLID OOP Principles:
        - [x] Bob Martin SOLID Principles of Object Oriented and Agile Design: https://www.Youtube.com/watch?v=TMuno5RZNeE
        - [x] SOLID Design Patterns in C#: https://www.Youtube.com/playlist?list=PL8m4NUhTQU48oiGCSgCP1FiJEcg_xJzyQ
        - [x] SOLID Principles: https://www.Youtube.com/playlist?list=PL4CE9F710017EA77A
        - [x] S - Single Responsibility Principle | Single responsibility to each Object
            - http://www.oodesign.com/single-responsibility-principle.html
            - http://www.Javacodegeeks.com/2011/11/solid-single-responsibility-principle.html
            - more flavor: https://docs.google.com/open?id=0ByOwmqah_nuGNHEtcU5OekdDMkk
        - [x] O - Open/Closed Principal  | On production level Objects are ready for extension for not for modification
            - http://www.oodesign.com/open-close-principle.html
            - https://en.wikipedia.org/wiki/Open/closed_principle
            - more flavor: http://docs.google.com/a/cleancoder.com/viewer?a=v&pid=explorer&chrome=true&srcid=0BwhCYaYDn8EgN2M5MTkwM2EtNWFkZC00ZTI3LWFjZTUtNTFhZGZiYmUzODc1&hl=en
        - [x] L - Liskov Substitution Principal | Base Class and Derived class follow ‘IS A’ principal
            - http://www.oodesign.com/liskov-s-substitution-principle.html
            - http://stackoverflow.com/questions/56860/what-is-the-liskov-substitution-principle
            - more flavor: http://docs.google.com/a/cleancoder.com/viewer?a=v&pid=explorer&chrome=true&srcid=0BwhCYaYDn8EgNzAzZjA5ZmItNjU3NS00MzQ5LTkwYjMtMDJhNDU5ZTM0MTlh&hl=en
        - [x] I - Interface segregation principle | clients should not be forced to implement interfaces they don't use
            - http://www.oodesign.com/interface-segregation-principle.html
            - Interface Segregation Principle in 5 minutes: https://www.Youtube.com/watch?v=3CtAfl7aXAQ
            - more flavor: http://docs.google.com/a/cleancoder.com/viewer?a=v&pid=explorer&chrome=true&srcid=0BwhCYaYDn8EgOTViYjJhYzMtMzYxMC00MzFjLWJjMzYtOGJiMDc5N2JkYmJi&hl=en
        - [x] D - Dependency Inversion principle | Reduce the dependency In composition of objects.
            - http://www.oodesign.com/dependency-inversion-principle.html
            - http://stackoverflow.com/questions/62539/what-is-the-dependency-inversion-principle-and-why-is-it-important
            - more flavor: http://docs.google.com/a/cleancoder.com/viewer?a=v&pid=explorer&chrome=true&srcid=0BwhCYaYDn8EgMjdlMWIzNGUtZTQ0NC00ZjQ5LTkwYzQtZjRhMDRlNTQ3ZGMz&hl=en
    - [x] Scalability:
        - [x] Great overview: https://www.Youtube.com/watch?v=-W9F__D3oY4
        - [x] Short series: 
            - http://www.lecloud.net/post/7295452622/scalability-for-dummies-part-1-clones
            - http://www.lecloud.net/post/7994751381/scalability-for-dummies-part-2-database
            - http://www.lecloud.net/post/9246290032/scalability-for-dummies-part-3-cache
            - http://www.lecloud.net/post/9699762917/scalability-for-dummies-part-4-asynchronism
        - [x] Scalable Web Architecture and Distributed Systems: http://www.aosabook.org/en/distsys.html
        - [x] Fallacies of Distributed Computing Explained: https://pages.cs.wisc.edu/~zuyu/files/fallacies.pdf
        - [x] Pragmatic Programming Techniques: http://horicky.blogspot.com/2010/10/scalable-system-design-patterns.html
            - extra: Google Pregel Graph Processing: http://horicky.blogspot.com/2010/07/google-pregel-graph-processing.html
        - [x] Jeff Dean - Building Software Systems At Google and Lessons Learned: https://www.Youtube.com/watch?v=modXC5IWTJI
        - [x] Introduction to Architecting Systems for Scale: http://lethain.com/introduction-to-architecting-systems-for-scale/
        - [x] Scaling mobile games to a global audience using App Engine and Cloud Datastore: https://www.Youtube.com/watch?v=9nWyWwY2Onc
        - [x] How Google Does Planet-Scale Engineering for Planet-Scale Infra: https://www.Youtube.com/watch?v=H4vMcD7zKM0
        - [x] The Importance of Algorithms: https://www.topcoder.com/community/data-science/data-science-tutorials/the-importance-of-algorithms/
        - [x] Sharding: http://highscalability.com/blog/2009/8/6/an-unorthodox-approach-to-database-design-the-coming-of-the.html
        - [x] Scale at Facebook (2009): https://www.infoq.com/presentations/Scale-at-Facebook
        - [x] Scale at Facebook (2012), "Building for a Billion Users": https://www.Youtube.com/watch?v=oodS71YtkGU
        - [x] Engineering for the Long Game - Astrid Atkinson Keynote: https://www.Youtube.com/watch?v=p0jGmgIrf_M&list=PLRXxvay_m8gqVlExPC5DG3TGWJTaBgqSA&index=4
        - [x] 7 Years Of Youtube Scalability Lessons In 30 Minutes: http://highscalability.com/blog/2012/3/26/7-years-of-Youtube-scalability-lessons-in-30-minutes.html
            - video: https://www.Youtube.com/watch?v=G-lGCC4KKok
        - [x] How PayPal Scaled To Billions Of Transactions Daily Using Just 8VMs: http://highscalability.com/blog/2016/8/15/how-paypal-scaled-to-billions-of-transactions-daily-using-ju.html
        - [x] How to Remove Duplicates in Large Datasets: https://blog.clevertap.com/how-to-remove-duplicates-in-large-datasets/
        - [x] A look inside Etsy's scale and engineering culture with Jon Cowie: https://www.Youtube.com/watch?v=3vV4YiqKm1o
        - [x] What Led Amazon to its Own Microservices Architecture: http://thenewstack.io/led-amazon-microservices-architecture/
        - [x] To Compress Or Not To Compress, That Was Uber's Question: https://eng.uber.com/trip-data-squeeze/
        - [x] Asyncio Tarantool Queue, Get In The Queue: http://highscalability.com/blog/2016/3/3/asyncio-tarantool-queue-get-in-the-queue.html
        - [x] When Should Approximate Query Processing Be Used?: http://highscalability.com/blog/2016/2/25/when-should-approximate-query-processing-be-used.html
        - [x] Google's Transition From Single Datacenter, To Failover, To A Native Multihomed Architecture: http://highscalability.com/blog/2016/2/23/googles-transition-from-single-datacenter-to-failover-to-a-n.html
        - [x] Spanner: http://highscalability.com/blog/2012/9/24/google-spanners-most-surprising-revelation-nosql-is-out-and.html
        - [x] Egnyte Architecture: Lessons Learned In Building And Scaling A Multi Petabyte Distributed System: http://highscalability.com/blog/2016/2/15/egnyte-architecture-lessons-learned-in-building-and-scaling.html
        - [x] Machine Learning Driven Programming: A New Programming For A New World: http://highscalability.com/blog/2016/7/6/machine-learning-driven-programming-a-new-programming-for-a.html
        - [x] The Image Optimization Technology That Serves Millions Of Requests Per Day: http://highscalability.com/blog/2016/6/15/the-image-optimization-technology-that-serves-millions-of-re.html
        - [x] A Patreon Architecture Short: http://highscalability.com/blog/2016/2/1/a-patreon-architecture-short.html
        - [x] Tinder: How Does One Of The Largest Recommendation Engines Decide Who You'll See Next?: http://highscalability.com/blog/2016/1/27/tinder-how-does-one-of-the-largest-recommendation-engines-de.html
        - [x] Design Of A Modern Cache: http://highscalability.com/blog/2016/1/25/design-of-a-modern-cache.html
        - [x] Live Video Streaming At Facebook Scale: http://highscalability.com/blog/2016/1/13/live-video-streaming-at-facebook-scale.html
        - [x] A Beginner's Guide To Scaling To 11 Million+ Users On Amazon's AWS: http://highscalability.com/blog/2016/1/11/a-beginners-guide-to-scaling-to-11-million-users-on-amazons.html
        - [x] How Does The Use Of Docker Effect Latency?: http://highscalability.com/blog/2015/12/16/how-does-the-use-of-docker-effect-latency.html
        - [x] Does AMP Counter An Existential Threat To Google?: http://highscalability.com/blog/2015/12/14/does-amp-counter-an-existential-threat-to-google.html
        - [x] A 360 Degree View Of The Entire Netflix Stack: http://highscalability.com/blog/2015/11/9/a-360-degree-view-of-the-entire-netflix-stack.html
        - [x] Latency Is Everywhere And It Costs You Sales - How To Crush It: http://highscalability.com/latency-everywhere-and-it-costs-you-sales-how-crush-it
        - [x] Serverless (very long, just need the gist): http://martinfowler.com/articles/serverless.html
        - [x] What Powers Instagram: Hundreds of Instances, Dozens of Technologies: http://instagram-engineering.tumblr.com/post/13649370142/what-powers-instagram-hundreds-of-instances
        - [x] Cinchcast Architecture - Producing 1,500 Hours Of Audio Every Day: http://highscalability.com/blog/2012/7/16/cinchcast-architecture-producing-1500-hours-of-audio-every-d.html
        - [x] Justin.Tv's Live Video Broadcasting Architecture: http://highscalability.com/blog/2010/3/16/justintvs-live-video-broadcasting-architecture.html
        - [x] Playfish's Social Gaming Architecture - 50 Million Monthly Users And Growing: http://highscalability.com/blog/2010/9/21/playfishs-social-gaming-architecture-50-million-monthly-user.html
        - [x] TripAdvisor Architecture - 40M Visitors, 200M Dynamic Page Views, 30TB Data: http://highscalability.com/blog/2011/6/27/tripadvisor-architecture-40m-visitors-200m-dynamic-page-view.html
        - [x] PlentyOfFish Architecture: http://highscalability.com/plentyoffish-architecture
        - [x] Salesforce Architecture - How They Handle 1.3 Billion Transactions A Day: http://highscalability.com/blog/2013/9/23/salesforce-architecture-how-they-handle-13-billion-transacti.html
        - [x] ESPN's Architecture At Scale - Operating At 100,000 Duh Nuh Nuhs Per Second: http://highscalability.com/blog/2013/11/4/espns-architecture-at-scale-operating-at-100000-duh-nuh-nuhs.html
        - [x] See "Messaging, Serialization, and Queueing Systems" way below for info on some of the technologies that can glue services together
        - [x] Twitter:
            - O'Reilly MySQL CE 2011: Jeremy Cole, "Big and Small Data at @Twitter": https://www.Youtube.com/watch?v=5cKTP36HVgI
            - Timelines at Scale: https://www.infoq.com/presentations/Twitter-Timeline-Scalability
        - For even more, see "Mining Massive Datasets" video series in the Video Series section.
    - [x] Practicing the system design process: Here are some ideas to try working through on paper, each with some documentation on how it was handled in the real world:
        - review: System Design from HiredInTech: http://www.hiredintech.com/system-design/
        - cheat sheet: https://github.com/jwasham/google-interview-University/blob/master/extras/cheat%20sheets/system-design.pdf
        - flow:
            1. Understand the problem and scope:
                - define the use cases, with interviewer's help
                - suggest additional features
                - remove items that interviewer deems out of scope
                - assume high availability is required, add as a use case
            2. Think about constraints:
                - ask how many requests per month
                - ask how many requests per second (they may volunteer it or make you do the math)
                - estimate reads vs. writes percentage
                - keep 80/20 rule in mind when estimating
                - how much data written per second
                - total storage required over 5 years
                - how much data read per second
            3. Abstract design:
                - layers (service, data, caching)
                - infrastructure: load balancing, messaging
                - rough overview of any key algorithm that drives the service
                - consider bottlenecks and determine solutions
        - Exercises:
            - Design a CDN network: old article: http://repository.cmu.edu/cgi/viewcontent.cgi?article=2112&context=compsci
            - Design a random unique ID generation system: https://blog.twitter.com/2010/announcing-snowflake
            - Design an online multiplayer card game: http://www.indieflashblog.com/how-to-create-an-asynchronous-multiplayer-game.html
            - Design a key-value database: http://www.slideshare.net/dvirsky/introduction-to-redis
            - Design a function to return the top k requests during past time interval: https://icmi.cs.ucsb.edu/research/tech_reports/reports/2005-23.pdf
            - Design a picture sharing system: http://highscalability.com/blog/2011/12/6/instagram-architecture-14-million-users-terabytes-of-photos.html
            - Design a recommendation system: http://ijcai13.org/files/tutorial_slides/td3.pdf
            - Design a URL-shortener system: copied from above: http://www.hiredintech.com/system-design/the-system-design-process/
            - Design a cache system: https://www.adayinthelifeof.nl/2011/02/06/memcache-internals/

——————————————————————————————————————————————————————


Collections 

Combined 

Combining 



