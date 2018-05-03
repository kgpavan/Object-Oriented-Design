

INTENT 
——————
Define the skeleton of an algorithm in an operation, deferring some steps to client subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure. Base class declares algorithm 'placeholders', and derived classes implement the placeholders.


PROBLEM 
———————
Two different components have significant similarities, but demonstrate no reuse of common interface or implementation. If a change common to both components becomes necessary, duplicate effort must be expended.


DISCUSSION 
——————————
The component designer decides which steps of an algorithm are invariant (or standard), and which are variant (or customizable). The invariant steps are implemented in an abstract base class, while the variant steps are either given a default implementation, or no implementation at all. The variant steps represent "hooks", or "placeholders", that can, or must, be supplied by the component's client in a concrete derived class.

The component designer mandates the required steps of an algorithm, and the ordering of the steps, but allows the component client to extend or replace some number of these steps.

Template Method is used prominently in frameworks. Each framework implements the invariant pieces of a domain's architecture, and defines "placeholders" for all necessary or interesting client customization options. In so doing, the framework becomes the "center of the universe", and the client customizations are simply "the third rock from the sun". This inverted control structure has been affectionately labelled "the Hollywood principle" - "don't call us, we'll call you".



CHECK LIST 
——————————

	Examine the algorithm, and decide which steps are standard and which steps are peculiar to each of the current classes.

	Define a new abstract base class to host the "don't call us, we'll call you" framework.

	Move the shell of the algorithm (now called the "template method") and the definition of all standard steps to the new base class.

	Define a placeholder or "hook" method in the base class for each step that requires many different implementations. This method can host a default implementation – or – it can be defined as abstract (Java) or pure virtual (C++).

	Invoke the hook method(s) from the template method.

	Each of the existing classes declares an "is-a" relationship to the new abstract base class.

	Remove from the existing classes all the implementation details that have been moved to the base class.

	The only details that will remain in the existing classes will be the implementation details peculiar to each derived class.


RULES OF THUMB 
——————————————

	Strategy is like Template Method except in its granularity.

	Template Method uses inheritance to vary part of an algorithm. Strategy uses delegation to vary the entire algorithm.

	Strategy modifies the logic of individual objects. Template Method modifies the logic of an entire class.

	Factory Method is a specialization of Template Method.








INTRODUCTION 
————————————

The Template Design Pattern is a behavior pattern and, as the name suggests, it provides a template or a structure of an algorithm which is used by users. A user provides its own implementation without changing the algorithm’s structure.

It is easier to understand this pattern with the help of a problem. We will understand the scenario in this section and will implement the solution using the Template pattern in a later section.

Have you ever connected to a relation database using your Java application? Let’s recall some important steps which are required to connect and insert data into the database. First, we need a driver according to the database we want to connect with. Then, we pass some credentials to the database, then, we prepare a statement, set data into the insert statement and insert it using the insert command. Later, we close all the connections, and optionally destroy all the connection objects.

You need to write all these steps regardless of any vendor’s relational database. Consider a problem where you need to insert some data into the different databases. You need to fetch some data from a CSV file and have to insert it into a MySQL database. Some data comes from a text file and which should be insert into an Oracle database. The only difference is the driver and the data, the rest of the steps should be the same, as JDBC provides a common set of interfaces to communicate to any vendor’s specific relation database.

We can create a template, which will perform some steps for the client, and we will leave some steps to let the client to implement them in its own specific way. Optionally, a client can override the default behavior of some already defined steps.







DESCRIPTION 
———————————

The Template Pattern defines the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses to redefine certain steps of an algorithm without changing the algorithm’s structure.

The Template Method pattern can be used in situations when there is an algorithm, some steps of which could be implemented in multiple different ways. In such scenarios, the Template Method pattern suggests keeping the outline of the algorithm in a separate method referred to as a template method inside a class, which may be referred to as a template class, leaving out the specific implementations of the variant portions (steps that can be implemented in multiple different ways) of the algorithm to different subclasses of this class.

The Template class does not necessarily have to leave the implementation to subclasses in its entirety. Instead, as part of providing the outline of the algorithm, the Template class can also provide some amount of implementation that can be considered as invariant across different implementations. It can even provide default implementation for the variant parts, if appropriate. Only specific details will be implemented inside different subclasses. This type of implementation eliminates the need for duplicate code, which means a minimum amount of code to be written.


————————————————————————————————————————————————————————————————————————————————————
STRUCTURE 
—————————

AbstractClass
—————————————
Defines abstract primitive operations that concrete subclasses define to implement steps of an algorithm.

Implements a template method defining the skeleton of an algorithm. The template method calls primitive operations as well as operations defined in AbstractClass or those of other objects.

ConcreteClass
—————————————
Implements the primitive operations to carry.
————————————————————————————————————————————————————————————————————————————————————






USAGES 
——————
	To implement the invariant parts of an algorithm once and leave it up to subclasses to implement the behavior that can vary.

	When common behavior among subclasses should be factored and localized in a common class to avoid code duplication. You first identify the differences in the existing code and then separate the differences into new operations. Finally, you replace the differing code with a template method that calls one of these new operations.

	To control subclasses extensions. You can define a template method that calls “hook” operations (see Consequences) at specific points, thereby permitting extensions only at those points.


TEMPLATE DESIGN PATTERN IN JDK 
——————————————————————————————
i.   java.util.Collections#sort()
ii.  java.io.InputStream#skip()
iii. java.io.InputStream#read()
iv.  java.util.AbstractList#indexOf()













——————————————————————————————————————————————————————————————————————————————————————

## Intent
Define the skeleton of an algorithm in an operation, deferring some
steps to subclasses. Template method lets subclasses redefine certain steps of
an algorithm without changing the algorithm's structure.

![alt text](./etc/template-method_1.png "Template Method")

## Applicability
The Template Method pattern should be used

* to implement the invariant parts of an algorithm once and leave it up to subclasses to implement the behavior that can vary
* when common behavior among subclasses should be factored and localized in a common class to avoid code duplication. This is good example of "refactoring to generalize" as described by Opdyke and Johnson. You first identify the differences in the existing code and then separate the differences into new operations. Finally, you replace the differing code with a template method that calls one of these new operations
* to control subclasses extensions. You can define a template method that calls "hook" operations at specific points, thereby permitting extensions only at those points

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)





Participants

    The classes and objects participating in this pattern are:

AbstractClass  (DataObject)
defines abstract primitive operations that concrete subclasses define to implement steps of an algorithm
implements a template method defining the skeleton of an algorithm. The template method calls primitive operations as well as operations defined in AbstractClass or those of other objects.
ConcreteClass  (CustomerDataObject)
implements the primitive operations ot carry out subclass-specific steps of the algorithm