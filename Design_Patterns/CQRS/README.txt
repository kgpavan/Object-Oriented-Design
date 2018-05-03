——————————————————————

/**
 * CQRS : Command Query Responsibility Segregation. A pattern used to separate query services from commands or writes
 * services. The pattern is very simple but it has many consequences. For example, it can be used to tackle down a
 * complex domain, or to use other architectures that were hard to implement with the classical way.
 * 
 * This implementation is an example of managing books and authors in a library. The persistence of books and authors is
 * done according to the CQRS architecture. A command side that deals with a data model to persist(insert,update,delete)
 * objects to a database. And a query side that uses native queries to get data from the database and return objects as
 * DTOs (Data transfer Objects).
 */

 
## Intent
CQRS Command Query Responsibility Segregation - Separate the query side from the command side.


## Applicability
Use the CQRS pattern when

* you want to scale the queries and commands independently.
* you want to use different data models for queries and commands. Useful when dealing with complex domains.
* you want to use architectures like event sourcing or task based UI.

## Credits

* [Greg Young - CQRS, Task Based UIs, Event Sourcing agh!](http://codebetter.com/gregyoung/2010/02/16/cqrs-task-based-uis-event-sourcing-agh/)
* [Martin Fowler - CQRS](https://martinfowler.com/bliki/CQRS.html)
* [Oliver Wolf - CQRS for Great Good](https://www.youtube.com/watch?v=Ge53swja9Dw)
