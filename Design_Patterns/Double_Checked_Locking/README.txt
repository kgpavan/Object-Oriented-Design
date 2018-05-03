
## Intent
——————————————————————

Reduce the overhead of acquiring a lock by first testing the locking criterion (the "lock hint") without actually acquiring the lock. Only if the locking criterion check indicates that locking is required does the actual locking logic proceed.


## Applicability
----------------

Use the Double Checked Locking pattern when

A. there is a concurrent access in object creation, e.g. singleton, where you want to create single instance of the same class and checking if it's null or not maybe not be enough when there are two or more threads that checks if instance is null or not.

B. there is a concurrent access on a method where method's behaviour changes according to the some constraints and these constraint change within this method.
