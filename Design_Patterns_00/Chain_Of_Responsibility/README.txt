

The Chain of Responsibility pattern is a behavior pattern in which a group of objects is chained together in a sequence and a responsibility (a request) is provided in order to be handled by the group. If an object in the group can process the particular request, it does so and returns the corresponding response. Otherwise, it forwards the request to the subsequent object in the group.

For a real life scenario, in order to understand this pattern, suppose you got a problem to solve. If you are able to handle it on your own, you will do so, otherwise you will tell your friend to solve it. If he’ll able to solve he will do that, or he will also forward it to some other friend. The problem would be forwarded until it gets solved by one of your friends or all your friends have seen the problem, but no one is able to solve it, in which case the problem stays unresolved.



DESCRIPTION
-----------

The intent of this pattern is to avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. We chain the receiving objects and pass the request along the chain until an object handles it.

This pattern is all about connecting objects in a chain of notification; as a notification travels down the chain, it’s handled by the first object that is set up to deal with the particular notification.

When there is more than one objects that can handle or fulfill a client request, the pattern recommends giving each of these objects a chance to process the request in some sequential order. Applying the pattern in such a case, each of these potential handlers can be arranged in the form of a chain, with each object having a reference to the next object in the chain. The first object in the chain receives the request and decides either to handle the request or to pass it on to the next object in the chain. The request flows through all objects in the chain one after the other until the request is handled by one of the handlers in the chain or the request reaches the end of the chain without getting processed.