
BALKING DESIGN PATTERN
——————————————————————

## Intent
—————————

Balking Pattern is used to prevent an object from executing certain code if it is an
incomplete or inappropriate state. It only executes an action on an object when the object is in a particular state. For example, if an object reads ZIP files and a calling method invokes a get method on the object when the ZIP file is not open, the object would "balk" at the request. In the Java programming language, for example, an IllegalStateException might be thrown under these circumstances.

There are some specialists in this field who consider balking more of an anti-pattern than a design pattern. If an object cannot support its API, it should either limit the API so that the offending call is not available, or so that the call can be made without limitation it should:

	Be created in a "sane state"

	Not make itself available until it is in a sane state

	Become a facade and answer back an object that is in a sane state


## Usage
————————

Objects that use this pattern are generally only in a state that is prone to balking temporarily but for an unknown amount of time.[citation needed] If objects are to remain in a state which is prone to balking for a known, finite period of time, then the guarded suspension pattern may be preferred.


## Implementation
—————————————————

As demonstrated by the definition above, notice how the "synchronized" line is utilized. If there are multiple calls to the job method, only one will proceed while the other calls will return with nothing. Another thing to note is the jobCompleted() method. The reason it is synchronized is because the only way to guarantee another thread will see a change to a field is to synchronize all access to it or declare it as volatile.


## Applicability
————————————————
Use the Balking pattern when

i.  You want to invoke an action on an object only when it is in a particular state
ii. Objects are generally only in a state that is prone to balking temporarily but for an unknown amount of time


## Related patterns
———————————————————
i.  Guarded Suspension Pattern
ii. Double Checked Locking Pattern
