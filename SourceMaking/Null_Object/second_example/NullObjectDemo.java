package com.sourcemaking.null_object.second_example;

/**
 * For an example of the Null Object pattern lets look
 * at a very simple immutable linked list.
 *
 * The entire system is completed by the visitor interface.
 */
interface ListVisitor {
    Object whenNonNullList(NonNullList host, Object param);
    Object whenNullList(NullList host, Object param);
}

/**
 * A Linked list is either a head element and a tail which is
 * a list or empty (i.e. Null). Thus is makes sense to model
 * an abstract linked list with a class List which has two methods
 * getTail and accept as per the Visitor pattern.
 */
abstract class List {
    public abstract List getTail();
    public abstract Object accept(ListVisitor visitor, Object param);
}

/**
 * Now we will need a class for non-empty lists, we'll call it
 * NonNullList. Its implementation is fairly straight forward.
 */
@SuppressWarnings("ALL")
class NonNullList extends List {
    private Object head;
    private List tail;

    // Creates a list from a head and tail. Acts as "cons"
    public NonNullList(Object head, List tail) {
        this.head = head;
        this.tail = tail;
    }
    // for convenience we could add a constructor taking only the head to make 1 element lists.
    public Object getHead() {
        return head;
    }

    public List getTail() {
        return tail;
    }

    public Object accept(ListVisitor visitor, Object param) {
        return visitor.whenNonNullList(this, param);
    }
}

/**
 * Now we get to the Null Object pattern's role. Rather than
 * using null to represent an empty list, we will create a
 * NullList class to represent the empty list. Notice that
 * it knows exactly what to do. Access to the head was
 * intentionally left out of the abstract list because the
 * NullList would be unable to fulfill that interface.
 *
 * However, the empty list can provide a tail (you may view
 * it differently but I believe the rest of nothing is more
 * nothing) and it can certainly accept a visitor. Since all
 * empty lists are identical, we will use the Singleton design
 * pattern.
 */
class NullList extends List
{
    private static final NullList instance = new NullList();
    private NullList() {}

    public static NullList singleton() {
        return instance;
    }

    public List getTail() {
        return this;
    }

    public Object accept(ListVisitor visitor, Object param) {
        return visitor.whenNullList(this, param);
    }
}
