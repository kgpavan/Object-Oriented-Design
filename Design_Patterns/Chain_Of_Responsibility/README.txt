
CHAIN OF RESPONSIBILITY 
———————————————————————


## Intent 
—————————

The Chain of Responsibility pattern is a behavior pattern in which a group of objects is chained together in a sequence and a responsibility (a request) is provided in order to be handled by the group. If an object in the group can process the particular request, it does so and returns the corresponding response. Otherwise, it forwards the request to the subsequent object in the group.

It avoids coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.


## Example 
——————————

For a real life scenario, in order to understand this pattern, suppose you got a problem to solve. If you are able to handle it on your own, you will do so, otherwise you will tell your friend to solve it. If he’ll able to solve he will do that, or he will also forward it to some other friend. The problem would be forwarded until it gets solved by one of your friends or all your friends have seen the problem, but no one is able to solve it, in which case the problem stays unresolved.

The Orc King gives loud orders to his army. The closest one to react is the commander, then officer and then soldier. The commander, officer and soldier here form a chain of responsibility. In plain words It helps building a chain of objects. Request enters from one end and keeps going from object to object till it finds the suitable handler.



## Structure
————————————

In object-oriented design, the chain-of-responsibility pattern is a design pattern consisting of a source of command objects and a series of processing objects. Each processing object contains logic that defines the types of command objects that it can handle; the rest are passed to the next processing object in the chain.


The intent of this pattern is to avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. We chain the receiving objects and pass the request along the chain until an object handles it.

This pattern is all about connecting objects in a chain of notification; as a notification travels down the chain, it’s handled by the first object that is set up to deal with the particular notification.

When there is more than one objects that can handle or fulfill a client request, the pattern recommends giving each of these objects a chance to process the request in some sequential order. Applying the pattern in such a case, each of these potential handlers can be arranged in the form of a chain, with each object having a reference to the next object in the chain. The first object in the chain receives the request and decides either to handle the request or to pass it on to the next object in the chain. The request flows through all objects in the chain one after the other until the request is handled by one of the handlers in the chain or the request reaches the end of the chain without getting processed.



## Applicability
————————————————

i.   More than one object may handle a request, and the handler isn't known a priori. The handler should be ascertained automatically

ii.  You want to issue a request to one of several objects without specifying the receiver explicitly

iii. The set of objects that can handle a request should be specified dynamically


Participants

    The classes and objects participating in this pattern are:

Handler   (Approver)
defines an interface for handling the requests
(optional) implements the successor link
ConcreteHandler   (Director, VicePresident, President)
handles requests it is responsible for
can access its successor
if the ConcreteHandler can handle the request, it does so; otherwise it forwards the request to its successor
Client   (ChainApp)
initiates the request to a ConcreteHandler object on the chain





## Real world examples
——————————————————————

i.   [java.util.logging.Logger#log()](http://docs.oracle.com/javase/8/docs/api/java/util/logging/Logger.html#log%28java.util.logging.Level,%20java.lang.String%29)

ii.  [Apache Commons Chain](https://commons.apache.org/proper/commons-chain/index.html)

iii. [javax.servlet.Filter#doFilter()](http://docs.oracle.com/javaee/7/api/javax/servlet/Filter.html#doFilter-javax.servlet.ServletRequest-javax.servlet.ServletResponse-javax.servlet.FilterChain-)




















