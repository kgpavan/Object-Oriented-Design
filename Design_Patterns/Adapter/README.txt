
ADAPTER DESIGN PATTERN 
——————————————————————

## Intent
—————————

Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
Wrap an existing class with a new interface. Impedance match an old component to a new system. 

## Problem
——————————

An "off the shelf" component offers compelling functionality that you would like to reuse, but its "view of the world" is not compatible with the philosophy and architecture of the system currently being developed.

## Discussion
—————————————

Reuse has always been painful and elusive. One reason has been the tribulation of designing something new, while reusing something old. There is always something not quite right between the old and the new. It may be physical dimensions or misalignment. It may be timing or synchronization. It may be unfortunate assumptions or competing standards. It is like the problem of inserting a new three-prong electrical plug in an old two-prong wall outlet – some kind of adapter or intermediary is necessary.


Adapter is about creating an intermediary abstraction that translates, or maps, the old component to the new system. Clients call methods on the Adapter object which redirects them into calls to the legacy component. This strategy can be implemented either with inheritance or with aggregation. Adapter functions as a wrapper or modifier of an existing class. It provides a different or translated view of that class.

## Example
——————————

A software developer, Max, has worked on an e-commerce website. The website allows users to shop and pay online. The site is integrated with a 3rd party payment gateway, through which users can pay their bills using their credit card. Everything was going well, until his manager called him for a change in the project. The manager told him that they are planning to change the payment gateway vendor, and he has to implement that in the code.

The problem that arises here is that the site is attached to the Xpay payment gateway which takes an Xpay type of object. The new vendor, PayD, only allows the PayD type of objects to allow the process. Max doesn’t want to change the whole set of 100 of classes which have reference to an object of type XPay. This also raises the risk on the project, which is already running on the production. Neither he can change the 3rd party tool of the payment gateway. The problem has occurred due to the incompatible interfaces between the two different parts of the code. In order to get the process work, Max needs to find a way to make the code compatible with the vendor’s provided API. Now, the current code interface is not compatible with the new vendor’s interface.



What Max needs here is an Adapter which can sit in between the code and the vendor’s API, and can allow the process to flow. But before the solution, let us first see what an adapter is, and how it works.

Sometimes, there could be a scenario when two objects don’t fit together, as they should in-order to get the work done. This situation could arise when we are trying to integrate a legacy code with a new code, or when changing a 3rd party API in the code. This is due to incompatible interfaces of the two objects which do not fit together.

The Adapter pattern lets you to adapt what an object or a class exposes to what another object or class expects. It converts the interface of a class into another interface the client expects. It lets classes work together that couldn’t otherwise because of incompatible interfaces. It allows to fix the interface between the objects and the classes without modifying the objects and the classes directly.

You can think of an Adapter as a real world adapter which is used to connect two different pieces of equipment that cannot be connected directly. An adapter sits in-between these equipments, it gets the flow from the equipment and provides it to the other equipment in the form it wants, which otherwise, is impossible to get due to their incompatible interfaces.

An adapter uses composition to store the object it is supposed to adapt, and when the adapter’s methods are called, it translates those calls into something the adapted object can understand and passes the calls on to the adapted object. The code that calls the adapter never needs to know that it’s not dealing with the kind of object it thinks it is, but an adapted object instead.



## Class Adapter
————————————————

There are two types of adapters, the object adapter, and the class adapter. So far, we have seen the example of the object adapter which use object’s composition, whereas, the class adapter relies on multiple inheritance to adapt one interface to another. As Java does not support multiple inheritance, we cannot show you an example of multiple inheritance, but you can keep this in mind and may implement it in one of your favorite Object Oriented Language like c++ which supports multiple inheritance.

To implement a class adapter, an adapter would inherit publicly from Target and privately from Adaptee. As the result, adapter would be a subtype of Target, but not for Adaptee.




## When to use Adapter Pattern
——————————————————————————————

There is an existing class, and its interface does not match the one you need.
You want to create a reusable class that cooperates with unrelated or unforeseen classes, that is, classes that don’t necessarily have compatible interfaces.
There are several existing subclasses to be use, but it’s impractical to adapt their interface by subclassing every one. An object adapter can adapt the interface of its parent class.


## Structure
————————————

The Adapter pattern allows otherwise incompatible classes to work together by converting the interface of one class into an interface expected by the clients. Socket wrenches provide an example of the Adapter. A socket attaches to a ratchet, provided that the size of the drive is the same. Typical drive sizes in the United States are 1/2" and 1/4". Obviously, a 1/2" drive ratchet will not fit into a 1/4" drive socket unless an adapter is used. A 1/2" to 1/4" adapter has a 1/2" female connection to fit on the 1/2" drive ratchet, and a 1/4" male connection to fit in the 1/4" drive socket.



## Check list
—————————————

Identify the players: the component(s) that want to be accommodated (i.e. the client), and the component that needs to adapt (i.e. the adaptee).

Identify the interface that the client requires.

Design a "wrapper" class that can "impedance match" the adaptee to the client.

The adapter/wrapper class "has a" instance of the adaptee class.

The adapter/wrapper class "maps" the client interface to the adaptee interface.

The client uses (is coupled to) the new interface



## Rules of thumb
—————————————————

Adapter makes things work after they're designed; Bridge makes them work before they are.

Bridge is designed up-front to let the abstraction and the implementation vary independently. Adapter is retrofitted to make unrelated classes work together.

Adapter provides a different interface to its subject. Proxy provides the same interface. Decorator provides an enhanced interface.

Adapter is meant to change the interface of an existing object. Decorator enhances another object without changing its interface. Decorator is thus more transparent to the application than an adapter is. As a consequence, Decorator supports recursive composition, which isn't possible with pure Adapters.

Facade defines a new interface, whereas Adapter reuses an old interface. Remember that Adapter makes two existing interfaces work together as opposed to defining an entirely new one.






