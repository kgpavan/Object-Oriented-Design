
INTENT 
——————
Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.
Capture the abstraction in an interface, bury implementation details in derived classes.


PROBLEM 
———————
One of the dominant strategies of object-oriented design is the "open-closed principle".

Encapsulate interface details in a base class, and bury implementation details in derived classes. Clients can then couple themselves to an interface, and not have to experience the upheaval associated with change: no impact when the number of derived classes changes, and no impact when the implementation of a derived class changes.

A generic value of the software community for years has been, "maximize cohesion and minimize coupling". The object-oriented design approach shown in figure is all about minimizing coupling. Since the client is coupled only to an abstraction (i.e. a useful fiction), and not a particular realization of that abstraction, the client could be said to be practicing "abstract coupling" . an object-oriented variant of the more generic exhortation "minimize coupling".

A more popular characterization of this "abstract coupling" principle is "Program to an interface, not an implementation".

Clients should prefer the "additional level of indirection" that an interface (or an abstract base class) affords. The interface captures the abstraction (i.e. the "useful fiction") the client wants to exercise, and the implementations of that interface are effectively hidden.


STRUCTURE 
—————————
The Interface entity could represent either an abstract base class, or the method signature expectations by the client. In the former case, the inheritance hierarchy represents dynamic polymorphism. In the latter case, the Interface entity represents template code in the client and the inheritance hierarchy represents static polymorphism.


CHECK LIST 
——————————
Identify an algorithm (i.e. a behavior) that the client would prefer to access through a "flex point".

Specify the signature for that algorithm in an interface.

Bury the alternative implementation details in derived classes.

Clients of the algorithm couple themselves to the interface.


RULES OF THUMB 
———————————————

Strategy is like Template Method except in its granularity.

State is like Strategy except in its intent.

Strategy lets you change the guts of an object. Decorator lets you change the skin.

State, Strategy, Bridge (and to some degree Adapter) have similar solution structures. They all share elements of the 'handle/body' idiom. They differ in intent - that is, they solve different problems.

Strategy has 2 different implementations, the first is similar to State. The difference is in binding times (Strategy is a bind-once pattern, whereas State is more dynamic).

Strategy objects often make good Flyweights.




INTRODUCTION 
————————————

The Strategy Design Pattern seems to be the simplest of all design patterns, yet it provides great flexibility to your code. This pattern is used almost everywhere, even in conjunction with the other design patterns. The patterns we have discussed so far have a relation with this pattern, either directly or indirectly. After this lesson, you will get an idea on how important this pattern is.

To understand the Strategy Design Pattern, let us create a text formatter for a text editor. Everyone should be aware of a text editor. A text editor can have different text formatters to format text. We can create different text formatters and then pass the required one to the text editor, so that the editor will able to format the text as required.

The text editor will hold a reference to a common interface for the text formatter and the editor’s job will be to pass the text to the formatter in order to format the text.

Let’s implement this using the Strategy Design Pattern which will make the code very flexible and maintainable. But before that, let us more about the Strategy Design Pattern.




DESCRIPTION 
———————————

The Strategy Design Pattern defines a family of algorithms, encapsulating each one, and making them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.

The Strategy pattern is useful when there is a set of related algorithms and a client object needs to be able to dynamically pick and choose an algorithm from this set that suits its current need. The Strategy pattern suggests keeping the implementation of each of the algorithms in a separate class. Each such algorithm encapsulated in a separate class is referred to as a strategy. An object that uses a Strategy object is often referred to as a context object.

With different Strategy objects in place, changing the behavior of a Context object is simply a matter of changing its Strategy object to the one that implements the required algorithm. To enable a Context object to access different Strategy objects in a seamless manner, all Strategy objects must be designed to offer the same interface. In the Java programming language, this can be accomplished by designing each Strategy object either as an implementer of a common interface or as a subclass of a common abstract class that declares the required common interface.

Once the group of related algorithms is encapsulated in a set of Strategy classes in a class hierarchy, a client can choose from among these algorithms by selecting and instantiating an appropriate Strategy class. To alter the behavior of the context, a client object needs to configure the context with the selected strategy instance. This type of arrangement completely separates the implementation of an algorithm from the context that uses it. As a result, when an existing algorithm implementation is changed or a new algorithm is added to the group, both the context and the client object (that uses the context) remain unaffected.



——————————————————————————————————————————————————————————————————————————————————
Strategy
————————
Declares an interface common to all supported algorithms. Context uses this interface to call the algorithm defined by a ConcreteStrategy.

ConcreteStrategy
————————————————
Implements the algorithm using the Strategy interface.

Context
———————
Is configured with a ConcreteStrategy object.
Maintains a reference to a Strategy object.
May define an interface that lets Strategy access its data.
——————————————————————————————————————————————————————————————————————————————————


USAGES 
——————
Many related classes differ only in their behavior. Strategies provide a way to configure a class with one of many behaviors.

You need different variants of an algorithm. For example, you might define algorithms reflecting different space/time trade-offs. Strategies can be used when these variants are implemented as a class hierarchy of algorithms.

An algorithm uses data that clients shouldn’t know about. Use the Strategy pattern to avoid exposing complex, algorithm-specific data structures.

A class defines many behaviors, and these appear as multiple conditional statements in its operations. Instead of many conditionals, move related conditional branches into their own Strategy class.


STRATEGY PATTERN IN JDK 
—————————————————————————————————
i.   java.util.Comparator#compare()
ii.  javax.servlet.http.HttpServlet
iii. javax.servlet.Filter#doFilter()













—————————————————————————————————————————————————————————————————————————————————

## Also known as
Policy

## Intent
Define a family of algorithms, encapsulate each one, and make them
interchangeable. Strategy lets the algorithm vary independently from clients
that use it.

![alt text](./etc/strategy_1.png "Strategy")

## Applicability
Use the Strategy pattern when

* many related classes differ only in their behavior. Strategies provide a way to configure a class either one of many behaviors
* you need different variants of an algorithm. for example, you might define algorithms reflecting different space/time trade-offs. Strategies can be used when these variants are implemented as a class hierarchy of algorithms
* an algorithm uses data that clients shouldn't know about. Use the Strategy pattern to avoid exposing complex, algorithm-specific data structures
* a class defines many behaviors, and these appear as multiple conditional statements in its operations. Instead of many conditionals, move related conditional branches into their own Strategy class

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
* [Functional Programming in Java: Harnessing the Power of Java 8 Lambda Expressions](http://www.amazon.com/Functional-Programming-Java-Harnessing-Expressions/dp/1937785467/ref=sr_1_1)






Participants

    The classes and objects participating in this pattern are:

Strategy  (SortStrategy)
declares an interface common to all supported algorithms. Context uses this interface to call the algorithm defined by a ConcreteStrategy
ConcreteStrategy  (QuickSort, ShellSort, MergeSort)
implements the algorithm using the Strategy interface
Context  (SortedList)
is configured with a ConcreteStrategy object
maintains a reference to a Strategy object
may define an interface that lets Strategy access its data.