
INTENT 
——————

Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.

The classic technique for recovering lost type information.

Do the right thing based on the type of two objects.

Double dispatch.


PROBLEM 
———————

Many distinct and unrelated operations need to be performed on node objects in a heterogeneous aggregate structure. You want to avoid "polluting" the node classes with these operations. And, you don't want to have to query the type of each node and cast the pointer to the correct type before performing the desired operation.



DISCUSSION 
——————————

Visitor's primary purpose is to abstract functionality that can be applied to an aggregate hierarchy of "element" objects. The approach encourages designing lightweight Element classes - because processing functionality is removed from their list of responsibilities. New functionality can easily be added to the original inheritance hierarchy by creating a new Visitor subclass.

Visitor implements "double dispatch". OO messages routinely manifest "single dispatch" - the operation that is executed depends on: the name of the request, and the type of the receiver. In "double dispatch", the operation executed depends on: the name of the request, and the type of TWO receivers (the type of the Visitor and the type of the element it visits).

The implementation proceeds as follows. Create a Visitor class hierarchy that defines a pure virtual visit() method in the abstract base class for each concrete derived class in the aggregate node hierarchy. Each visit() method accepts a single argument - a pointer or reference to an original Element derived class.

Each operation to be supported is modelled with a concrete derived class of the Visitor hierarchy. The visit() methods declared in the Visitor base class are now defined in each derived subclass by allocating the "type query and cast" code in the original implementation to the appropriate overloaded visit() method.

Add a single pure virtual accept() method to the base class of the Element hierarchy. accept() is defined to receive a single argument - a pointer or reference to the abstract base class of the Visitor hierarchy.

Each concrete derived class of the Element hierarchy implements the accept() method by simply calling the visit() method on the concrete derived instance of the Visitor hierarchy that it was passed, passing its "this" pointer as the sole argument.

Everything for "elements" and "visitors" is now set-up. When the client needs an operation to be performed, (s)he creates an instance of the Visitor object, calls the accept() method on each Element object, and passes the Visitor object.

The accept() method causes flow of control to find the correct Element subclass. Then when the visit() method is invoked, flow of control is vectored to the correct Visitor subclass.  accept() dispatch plus visit() dispatch equals double dispatch.

The Visitor pattern makes adding new operations (or utilities) easy - simply add a new Visitor derived class. But, if the subclasses in the aggregate node hierarchy are not stable, keeping the Visitor subclasses in sync requires a prohibitive amount of effort.

An acknowledged objection to the Visitor pattern is that is represents a regression to functional decomposition - separate the algorithms from the data structures. While this is a legitimate interpretation, perhaps a better perspective/rationale is the goal of promoting non-traditional behavior to full object status.


EXAMPLE 
———————

The Visitor pattern represents an operation to be performed on the elements of an object structure without changing the classes on which it operates. This pattern can be observed in the operation of a taxi company. When a person calls a taxi company (accepting a visitor), the company dispatches a cab to the customer. Upon entering the taxi the customer, or Visitor, is no longer in control of his or her own transportation, the taxi (driver) is.


STRUCTURE
—————————

The Element hierarchy is instrumented with a "universal method adapter". The implementation of accept() in each Element derived class is always the same. But – it cannot be moved to the Element base class and inherited by all derived classes because a reference to this in the Element class always maps to the base type Element.

When the polymorphic firstDispatch() method is called on an abstract First object, the concrete type of that object is "recovered". When the polymorphic secondDispatch() method is called on an abstract Second object, its concrete type is "recovered". The application functionality appropriate for this pair of types can now be exercised.




CHECK LIST
——————————

Confirm that the current hierarchy (known as the Element hierarchy) will be fairly stable and that the public interface of these classes is sufficient for the access the Visitor classes will require. If these conditions are not met, then the Visitor pattern is not a good match.

Create a Visitor base class with a visit(ElementXxx) method for each Element derived type.

Add an accept(Visitor) method to the Element hierarchy. The implementation in each Element derived class is always the same – accept( Visitor v ) { v.visit( this ); }. Because of cyclic dependencies, the declaration of the Element and Visitor classes will need to be interleaved.

The Element hierarchy is coupled only to the Visitor base class, but the Visitor hierarchy is coupled to each Element derived class. If the stability of the Element hierarchy is low, and the stability of the Visitor hierarchy is high; consider swapping the 'roles' of the two hierarchies.

Create a Visitor derived class for each "operation" to be performed on Element objects. visit() implementations will rely on the Element's public interface.
The client creates Visitor objects and passes each to Element objects by calling accept().




RULES OF THUMB 
——————————————

The abstract syntax tree of Interpreter is a Composite (therefore Iterator and Visitor are also applicable).

Iterator can traverse a Composite. Visitor can apply an operation over a Composite.

The Visitor pattern is like a more powerful Command pattern because the visitor may initiate whatever is appropriate for the kind of object it encounters.

The Visitor pattern is the classic technique for recovering lost type information without resorting to dynamic casts.



NOTES 
—————

The November 2000 issue of JavaPro has an article by James Cooper (author of a Java companion to the GoF) on the Visitor design pattern. He suggests it "turns the tables on our object-oriented model and creates an external class to act on data in other classes ... while this may seem unclean ... there are good reasons for doing it."

His primary example. Suppose you have a hierarchy of Employee-Engineer-Boss. They all enjoy a normal vacation day accrual policy, but, Bosses also participate in a "bonus" vacation day program. As a result, the interface of class Boss is different than that of class Engineer. We cannot polymorphically traverse a Composite-like organization and compute a total of the organization's remaining vacation days. "The Visitor becomes more useful when there are several classes with different interfaces and we want to encapsulate how we get data from these classes."

His benefits for Visitor include:

	Add functions to class libraries for which you either do not have the source or cannot change the source

	Obtain data from a disparate collection of unrelated classes and use it to present the results of a global calculation to the user program

	Gather related operations into a single class rather than force you to change or derive classes to add these operations

	Collaborate with the Composite pattern

	Visitor is not good for the situation where "visited" classes are not stable. Every time a new Composite hierarchy derived class is added, every Visitor derived class must be amended.



INTRODUCTION 
————————————

In the Composite Pattern example, we had created an html structure composed of different types of objects. Now suppose that we need to add a css class to the html tags. One way to do this is by adding the class when adding a start tag using the setStartTag method. But this hard coded setting will create inflexibility to our code.

Another way of doing this is by adding a new method like addClass in the parent abstract HtmlTag class. All the child classes will override this method and will provide the css class. One major drawback of this approach is that, if there are many child classes (will be in large html page), it will become very expensive and hectic to implement this method in all the child classes. And suppose, later we need to add another style element in the tags, we again need to do the same thing.

The Visitor Design Pattern provides you with a way to add new operations on the objects without changing the classes of the elements, especially when the operations change quite often.



DESCRIPTION 
———————————

The intent of the Visitor Design Pattern is to represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.

The Visitor pattern is useful when designing an operation across a heterogeneous collection of objects of a class hierarchy. The Visitor pattern allows the operation to be defined without changing the class of any of the objects in the collection. To accomplish this, the Visitor pattern suggests defining the operation in a separate class referred to as a visitor class. This separates the operation from the object collection that it operates on. For every new operation to be defined, a new visitor class is created. Since the operation is to be performed across a set of objects, the visitor needs a way of accessing the public members of these objects. This requirement can be addressed by implementing the following two design ideas.




—————————————————————————————————————————————————————————————————————————————————————

STRUCTURE 
—————————

Visitor
———————
Declares a Visit operation for each class of ConcreteElement in the object structure. The operation’s name and signature identifies the class that sends the Visit request to the visitor. That lets the visitor determine the concrete class of the element being visited. Then the visitor can access the element directly through its particular interface.

ConcreteVisitor
———————————————
Implements each operation declared by Visitor. Each operation implements a fragment of the algorithm defined for the corresponding class of object in the structure. 

ConcreteVisitor provides the context for the algorithm and stores its local state. 

This state often accumulates results during the traversal of the structure.

Element
———————
Defines an Accept operation that takes a visitor as an argument.

ConcreteElement
———————————————
Implements an Accept operation that takes a visitor as an argument.

ObjectStructure
———————————————
Can enumerate its elements.

May provide a high-level interface to allow the visitor to visit its elements.

May either be a composite or a collection such as a list or a set.
—————————————————————————————————————————————————————————————————————————————————————


USAGES
——————

An object structure contains many classes of objects with differing interfaces, and you want to perform operations on these objects that depend on their concrete classes.
Many distinct and unrelated operations need to be performed on objects in an object structure, and you want to avoid “polluting” their classes with these operations. 

Visitor lets you keep related operations together by defining them in one class. When the object structure is shared by many applications, use Visitor to put operations in just those applications that need them.

The classes defining the object structure rarely change, but you often want to define new operations over the structure. Changing the object structure classes requires redefining the interface to all visitors, which is potentially costly. If the object structure classes change often, then it’s probably better to define the operations in those classes.


VISITOR DESIGN PATTERN IN THE JDK 
—————————————————————————————————

i.   javax.lang.model.element.Element 
ii.  javax.lang.model.element.ElementVisitor
iii. javax.lang.model.type.TypeMirror 
iv.  javax.lang.model.type.TypeVisitor











---
layout: pattern
title: Visitor
folder: visitor
permalink: /patterns/visitor/
pumlid: DSR14OGm20NGLhG0mtsxmSWeJa8oyD7sTo_xJczLgoqFIM_B1Spu43c_vLHSkMU8rs4GGwcZaxPy6UnqyyFR8Q6dRPC1SGlg7B_Gew4OJeBwVqdlPMPlNm00
categories: Behavioral
tags:
 - Java
 - Difficulty-Intermediate
 - Gang Of Four
---

## Intent
Represent an operation to be performed on the elements of an object
structure. Visitor lets you define a new operation without changing the classes
of the elements on which it operates.

![alt text](./etc/visitor_1.png "Visitor")

## Applicability
Use the Visitor pattern when

* an object structure contains many classes of objects with differing interfaces, and you want to perform operations on these objects that depend on their concrete classes
* many distinct and unrelated operations need to be performed on objects in an object structure, and you want to avoid "polluting" their classes with these operations. Visitor lets you keep related operations together by defining them in one class. When the object structure is shared by many applications, use Visitor to put operations in just those applications that need them
* the classes defining the object structure rarely change, but you often want to define new operations over the structure. Changing the object structure classes requires redefining the interface to all visitors, which is potentially costly. If the object structure classes change often, then it's probably better to define the operations in those classes

## Real world examples

* [Apache Wicket](https://github.com/apache/wicket) component tree, see [MarkupContainer](https://github.com/apache/wicket/blob/b60ec64d0b50a611a9549809c9ab216f0ffa3ae3/wicket-core/src/main/java/org/apache/wicket/MarkupContainer.java)
* [javax.lang.model.element.AnnotationValue](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/AnnotationValue.html) and [AnnotationValueVisitor](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/AnnotationValueVisitor.html)
* [javax.lang.model.element.Element](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/Element.html) and [Element Visitor](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/ElementVisitor.html)
* [java.nio.file.FileVisitor](http://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html)

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)







Participants
——————————————————

    The classes and objects participating in this pattern are:

Visitor  (Visitor)
declares a Visit operation for each class of ConcreteElement in the object structure. The operation's name and signature identifies the class that sends the Visit request to the visitor. That lets the visitor determine the concrete class of the element being visited. Then the visitor can access the elements directly through its particular interface
ConcreteVisitor  (IncomeVisitor, VacationVisitor)
implements each operation declared by Visitor. Each operation implements a fragment of the algorithm defined for the corresponding class or object in the structure. ConcreteVisitor provides the context for the algorithm and stores its local state. This state often accumulates results during the traversal of the structure.
Element  (Element)
defines an Accept operation that takes a visitor as an argument.
ConcreteElement  (Employee)
implements an Accept operation that takes a visitor as an argument
ObjectStructure  (Employees)
can enumerate its elements
may provide a high-level interface to allow the visitor to visit its elements
may either be a Composite (pattern) or a collection such as a list or a set