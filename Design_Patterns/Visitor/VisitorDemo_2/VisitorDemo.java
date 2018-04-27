package com.sourcemaking.visitor.third_example;

/**
 * Discussion. We would like to declare a function like:
 * void process(virtual Base object1, virtual Base object2)
 * that does the right thing based on the type of 2 objects
 * that come from a single inheritance hierarchy. The only
 * problem is that the keyword "virtual" may not be used to
 * request dynamic binding for an object being passed as an
 * argument. Java will only "discriminate" the type of an object
 * being messaged, not the type of an object being passed.
 *
 * So in order for the type of 2 objects to be discriminated,
 * each object must be the receiver of a virtual function call.
 * Here, when execute() is called on the first object, its
 * type becomes "known" at runtime, but the type of the second
 * is still Unknown.  doJob() is then called on the second
 * object, and the identity (and type) of the first object is
 * passed as an argument. Flow of control has now been vectored
 * to the spot where the type (and identity) of both objects
 * are known.
 */

interface Base {
    void execute(Base target);
    void doJob(FOO target);
    void doJob(BAR target);
    void doJob(BAZ target);
}

class FOO implements Base {
    public void execute(Base base) {
        base.doJob(this);
    }

    public void doJob(FOO foo) {
        System.out.println("FOO object calls by yourself");
    }

    public void doJob(BAR bar) {
        System.out.println("BAR object was called from FOO");
    }

    public void doJob(BAZ baz) {
        System.out.println("BAZ object was called from FOO");
    }
}

class BAR implements Base {
    public void execute(Base base) {
        base.doJob(this);
    }

    public void doJob(FOO foo) {
        System.out.println("FOO object was called from BAR" );
    }

    public void doJob(BAR bar) {
        System.out.println("BAR object calls by yourself");
    }

    public void doJob(BAZ baz) {
        System.out.println("BAZ object was called from BAR");
    }
}

class BAZ implements Base {
    public void execute(Base base) {
        base.doJob( this);
    }

    public void doJob(FOO foo) {
        System.out.println("FOO object was called from BAZ");
    }

    public void doJob(BAR bar) {
        System.out.println("BAR object was called from BAZ");
    }

    public void doJob(BAZ baz) {
        System.out.println("BAZ object calls by yourself");
    }
}

public class VisitorDemo {
    public static void main(String[] args) {
        Base objects[] = {new FOO(), new BAR(), new BAZ()};
        for (Base object : objects) {
            for (int j = 0; j < 3; j++) {
                object.execute(objects[j]);
            }
            System.out.println();
        }
    }
}
