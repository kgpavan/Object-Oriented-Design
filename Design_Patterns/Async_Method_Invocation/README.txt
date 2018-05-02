
## Intent
—————————

Asynchronous method invocation is pattern where the calling thread is not blocked while waiting results of tasks. The pattern provides parallel processing of multiple independent tasks and retrieving the results via callbacks or waiting until everything is done. 


## Applicability
————————————————

Use async method invocation pattern when

i.   You have multiple independent tasks that can run in parallel
ii.  You need to improve the performance of a group of sequential tasks
iii. You have limited amount of processing capacity or long running tasks and the caller should not wait the tasks to be ready


## Real world examples
——————————————————————

FutureTask
CompletableFuture
ExecutorService
