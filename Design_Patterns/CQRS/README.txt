
CQRS DESIGN PATTERN 
———————————————————

## Intent
—————————

CQRS Command Query Responsibility Segregation - Separate the query side from the command side.

## Description 
——————————————

CQRS (Command Query Responsibility Segregation) is a pattern used to separate query services from commands or writes services. The pattern is very simple but it has many consequences. For example, it can be used to tackle down a complex domain, or to use other architectures that were hard to implement with the classical way.

## Example 
——————————

This implementation is an example of managing books and authors in a library. The persistence of books and authors is done according to the CQRS architecture. A command side that deals with a data model to persist(insert,update,delete) objects to a database. And a query side that uses native queries to get data from the database and return objects as DTOs (Data transfer Objects).


## Applicability
————————————————

i.   You want to scale the queries and commands independently.

ii.  You want to use different data models for queries and commands. Useful when dealing with complex domains.

iii. You want to use architectures like event sourcing or task based UI.



## Credits
——————————
CQRS for great good - Oliver Wolf, innoQ/ Youtube



