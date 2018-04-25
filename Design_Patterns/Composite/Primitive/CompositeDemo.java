package com.sourcemaking.composite.third_example;

/**
 * Composite design pattern
 * 1.Create a "lowest common denominator" that makes classes interchangeable
 * 2.All concrete classes declare an "isa" relationship to the interface
 * 3.All "container" classes couple themselves to the interface
 * 4."Container" classes use polymorphism as they delegate to their children
 */

// 1. "lowest common denominator"
interface Component {
    void traverse();
}

// 2. "Isa" relationship
class Primitive implements Component {
    private int value;

    public Primitive(int val) {
        value = val;
    }

    public void traverse() {
        System.out.print( value + "  " );
    }
}

// 2. "Isa" relationship
abstract class Composite implements Component {
    // 3. Couple to interface
    private Component[] children = new Component[9];
    private int total = 0;
    private int value;
    public Composite(int val) {
        value = val;
    }

    // 3. Couple to interface
    public void add(Component c) {
        children[total++] = c;
    }

    public void traverse() {
        System.out.print(value + "  ");
        for (int i=0; i < total; i++) {
            // 4. Delegation and polymorphism
            children[i].traverse();
        }
    }
}

// Two different kinds of "container" classes.  Most of the
// "meat" is in the Composite base class.
class Row extends Composite {
    public Row(int val) {
        super(val);
    }

    public void traverse() {
        System.out.print("Row");
        super.traverse();
    }
}

class Column extends Composite {
    public Column(int val) {
        super(val);
    }

    public void traverse() {
        System.out.print("Col");
        super.traverse();
    }
}

public class CompositeDemo {
    public static void main( String[] args ) {
        Composite first  = new Row( 1 );
        Composite second = new Column( 2 );
        Composite third  = new Column( 3 );
        Composite fourth = new Row( 4 );
        Composite fifth  = new Row( 5 );
        first.add(second);
        first.add(third);
        third.add(fourth);
        third.add(fifth);
        first.add(new Primitive(6));
        second.add(new Primitive(7));
        third.add(new Primitive(8));
        fourth.add(new Primitive(9));
        fifth.add(new Primitive(10));
        first.traverse();
    }
}
