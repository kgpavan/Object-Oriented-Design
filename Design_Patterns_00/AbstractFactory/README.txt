
ABSTRACT FACTORY 
----------------

The clients want to use their own XML rules to communicate with the product company. This means that for every client, the company should have client specific XML parsers. For example, for the NY client there should be four specific types of XML parsers, i.e. NYErrorXMLParser, NYFeedbackXML, NYOrderXMLParser, NYResponseXMLParser, and 4 different parsers for the TW client.

The company has asked you to change the application according to the new requirement. To develop the parser application we have used the Factory Method Design Pattern in which the exact object to use is decided by the subclasses according to the type of parser. Now, to implement this new requirement, we will use a factory of factories i.e. an Abstract Factory.

This time we need parsers according to client specific XMLs, so we will create different factories for different clients which will provide us the client specific XML to parse. We will do this by creating an Abstract Factory and then implement the factory to provide client specific XML factory. Then we will use that factory to get the desired client specific XML parser object.

Abstract Factory is the design pattern of our choice and before implementing it to solve our problem, lets us know more about it.



The Abstract Factory (A.K.A. Kit) is a design pattern which provides an interface for creating families of related or dependent objects without specifying their concrete classes. The Abstract Factory pattern takes the concept of the Factory Method Pattern to the next level. An abstract factory is a class that provides an interface to produce a family of objects. In Java, it can be implemented using an interface or an abstract class.

The Abstract Factory pattern is useful when a client object wants to create an instance of one of a suite of related, dependent classes without having to know which specific concrete class is to be instantiated. Different concrete factories implement the abstract factory interface. Client objects make use of these concrete factories to create objects and, therefore, do not need to know which concrete class is actually instantiated.

The abstract factory is useful for plugging in a different group of objects to alter the behavior of the system. For each group or family, a concrete factory is implemented that manages the creation of the objects and the inter-dependencies and consistency requirements between them. Each concrete factory implements the interface of the abstract factory


AbstractFactory
---------------
Declares an interface for operations that create abstract product objects.

ConcreteFactory
---------------
Implements the operations to create concrete product objects.

AbstractProduct
---------------
Declares an interface for a type of product object.

ConcreteProduct
---------------
Defines a product object to be created by the corresponding concrete factory.
Implements the AbstractProduct interface.

Client
------
USE only interfaces declared by AbstractFactory and AbstractProduct classes.

