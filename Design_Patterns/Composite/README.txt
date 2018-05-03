

COMPOSITE DESIGN PATTERN 
————————————————————————


## Intent 
—————————

Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly. Composite pattern lets clients treat the individual objects in a uniform manner.

There are times when you feel a need of a tree data structure in your code. There are many variations to the tree data structure, but sometimes there is a need of a tree in which both branches as well as leafs of the tree should be treated as uniformly.

The Composite Pattern allows you to compose objects into a tree structure to represent the part-whole hierarchy which means you can create a tree of objects that is made of different parts, but that can be treated as a whole one big thing. Composite lets clients to treat individual objects and compositions of objects uniformly, that’s the intent of the Composite Pattern.

In software engineering, the composite pattern is a partitioning design pattern. The composite pattern describes that a group of objects is to be treated in the same way as a single instance of an object. The intent of a composite is to "compose" objects into tree structures to represent part-whole hierarchies. Implementing the composite pattern lets clients treat individual objects and compositions uniformly.

## Structure 
————————————

The classes and objects participating in this pattern are:

#Component   (DrawingElement): declares the interface for objects in the composition.
implements default behavior for the interface common to all classes, as appropriate.
declares an interface for accessing and managing its child components.

(optional) defines an interface for accessing a component's parent in the recursive structure, and implements it if that's appropriate.

#Leaf   (PrimitiveElement): represents leaf objects in the composition. A leaf has no children and defines behavior for primitive objects in the composition.

#Composite   (CompositeElement): defines behavior for components having children.
stores child components and implements child-related operations in the Component interface.

#Client  (CompositeApp): manipulates objects in the composition through the Component interface.



## Example 
——————————

Every sentence is composed of words which are in turn composed of characters. Each of these objects is printable and they can have something printed before or after them like sentence always ends with full stop and word always has space before it


## Applicability
————————————————

Use the Composite pattern when

i.  You want to represent part-whole hierarchies of objects

ii. You want clients to be able to ignore the difference between compositions of objects and individual objects. Clients will treat all objects in the composite structure uniformly

## Real world examples
——————————————————————

i.   [java.awt.Container] 
ii.  [java.awt.Component]
iii. [Apache Wicket] Component(https://github.com/apache/wicket) component tree, 
iv.  [Apache Wicket] MarkupContainer(https://github.com/apache/wicket) MarkupContainer 



