
CALL-BACK DESIGN PATTERN 
————————————————————————

## Intent
—————————

Callback is a piece of executable code that is passed as an argument to other code, which is expected to call back (execute) the argument at some convenient time.


## Applicability
————————————————

Use the Callback pattern when some arbitrary synchronous or asynchronous action must be performed after execution of some defined activity.

## Example
——————————

CyclicBarrier: constructor can accept callback that will be triggered every time when barrier is tripped.
