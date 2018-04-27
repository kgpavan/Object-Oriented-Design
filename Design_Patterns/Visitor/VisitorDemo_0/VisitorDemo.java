package com.sourcemaking.visitor.first_example;

/**
 * Visitor design pattern
 * 1.Add an accept(Visitor) method to the "element" hierarchy
 * 2.Create a "visitor" base class w/a visit() method for every "element" type
 * 3.Create a "visitor" derived class for each "operation" to do on "elements"
 * 4.Client creates "visitor" objects and passes each to accept() calls
 */

interface Element {
    void accept(Visitor v);
}

class FOO implements Element {
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getFOO() {
        return "FOO";
    }
}

class BAR implements Element {
    public void   accept( Visitor v ) {
        v.visit( this );
    }

    public String getBAR() {
        return "BAR";
    }
}

class BAZ implements Element {
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getBAZ() {
        return "BAZ";
    }
}

interface Visitor {
    void visit(FOO foo);
    void visit(BAR bar);
    void visit(BAZ baz);
}

class UpVisitor implements Visitor {
    public void visit(FOO foo) {
        System.out.println("do Up on " + foo.getFOO());
    }

    public void visit(BAR bar) {
        System.out.println("do Up on " + bar.getBAR());
    }

    public void visit(BAZ baz) {
        System.out.println( "do Up on " + baz.getBAZ() );
    }
}

class DownVisitor implements Visitor {
    public void visit(FOO foo) {
        System.out.println("do Down on " + foo.getFOO());
    }

    public void visit(BAR bar) {
        System.out.println("do Down on " + bar.getBAR());
    }

    public void visit(BAZ baz ) {
        System.out.println("do Down on " + baz.getBAZ());
    }
}

public class VisitorDemo {
    public static void main( String[] args ) {
        Element[] list = {new FOO(), new BAR(), new BAZ()};
        UpVisitor up = new UpVisitor();
        DownVisitor down = new DownVisitor();
        for (Element element : list) {
            element.accept(up);
        }
        for (Element element : list) {
            element.accept(down);
        }
    }
}
