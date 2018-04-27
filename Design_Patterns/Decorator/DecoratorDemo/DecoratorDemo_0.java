package com.sourcemaking.decorator.first_example;

class A {
    public void doIt() {
        System.out.print('A');
    }
}

class AwithX extends A {
    public  void doIt() {
        super.doIt();
        doX();
    }

    private void doX() {
        System.out.print('X');
    }
}

class aWithY extends A {
    public void doIt() {
        super.doIt();
        doY();
    }

    public void doY()  {
        System.out.print('Y');
    }
}

class aWithZ extends A {
    public void doIt() {
        super.doIt();
        doZ();
    }

    public void doZ() {
        System.out.print('Z');
    }
}

class AwithXY extends AwithX {
    private aWithY obj = new aWithY();
    public void doIt() {
        super.doIt();
        obj.doY();
    }
}

class AwithXYZ extends AwithX {
    private aWithY obj1 = new aWithY();
    private aWithZ obj2 = new aWithZ();

    public void doIt() {
        super.doIt();
        obj1.doY();
        obj2.doZ();
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        A[] array = {new AwithX(), new AwithXY(), new AwithXYZ()};
        for (A a : array) {
            a.doIt();
            System.out.print("  ");
        }
    }
}
