
ABSTRACT DOCUMENT DESIGN PATTERN 
————————————————————————————————

## Definition 
—————————————

An object-oriented structural design pattern for organizing objects in loosely typed key-value stores and exposing the data using typed views. The purpose of the pattern 
is to achieve a high degree of flexibility between components in a strongly typed 
language where new properties can be added to the object-tree on the fly, without 
losing the support of type-safety. The pattern makes use of traits to separate different properties of a class into different interfaces. The term "document" is inspired from document-oriented databases.

A document is an object that contains a number of properties. A property can for an example be a value like a number or a string, or it can be a list of other documents. Every property is referenced using a key. When traversing the document tree, the user specifies a constructor to be used for creating the implementation class of the next level. The implementations are often a union of various traits that extend the Document interface, making it possible for them to handle setting and getting properties on their own.


### Structure 
—————————————

The interface "Document" states that properties can be edited using the "put" method, read using the "get" method and sub-documents can be traversed using the "children" method. The "children" method requires a functional reference to a method that can produce a typed view of a child given a map of the data the child should have. The map should be a pointer to the original map so that changes in the view also affect the original document.

Implementations can inherit from multiple trait interfaces that describe different properties. Multiple implementations can even share the same map, the only restriction the pattern puts on the design of the implementation is that it must be stateless except for the properties inherited from "BaseDocument".



## Usage 
————————

The Abstract Document Pattern allows the developer to store variables like configuration settings in an untyped tree structure and operate on the documents using typed views. New views or alternative implementations of views can be created without affecting the internal document structure. The advantage of this is a more loosely coupled system, but it also increases the risk of casting errors as the inherit type of a property is not always certain.


## Intent
—————————

Achieve flexibility of untyped languages and keep the type-safety 


## Applicability
————————————————

Use the Abstract Document Pattern when - 

i.   There is a need to add new properties on the fly
ii.  You want a flexible way to organize domain in tree like structure
iii. You want more loosely coupled system


## Credits
——————————

i.  [Wikipedia: Abstract Document Pattern](https://en.wikipedia.org/wiki/Abstract_Document_Pattern)

ii. [Martin Fowler: Dealing with properties](http://martinfowler.com/apsupp/properties.pdf)


