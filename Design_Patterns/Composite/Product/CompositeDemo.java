package com.sourcemaking.composite.second_example;

import java.util.*;

/**
 * A second static attribute is used to remember the "current level" of the traversal.
 */

abstract class Entity {
    protected static StringBuffer indent = new StringBuffer();
    protected static int level = 1;

    public abstract void traverse(int[] levels);

    protected boolean printThisLevel(int[] levels) {
        for (int value : levels) {
            if (level == value) {
                return true;
            }
        }
        return false;
    }
}

class Product extends Entity {
    private int value;
    public Product(int value) {
        this.value = value;
    }

    public void traverse(int[] levels) {
        if (printThisLevel(levels)) {
            System.out.println(indent.toString() + value);
        }
    }
}

class Box extends Entity {
    private List children = new ArrayList();
    private int value;
    public Box(int val) {
        value = val;
    }

    public void add(Entity c) {
        children.add(c);
    }

    public void traverse(int[] levels) {
        if (printThisLevel(levels)) {
            System.out.println(indent.toString() + value);
            indent.append( "   " );
        }
        level++;
        for (Object child : children) {
            ((Entity)child).traverse(levels);
        }
        level--;
        if (printThisLevel(levels)) {
            indent.setLength(indent.length() - 3);
        }
    }
}

public class CompositeDemo {
    public static void main(String[] args) {
        Box root = initialize();
        int[] levels = new int[args.length];
        for (int i=0; i < args.length; i++) {
            levels[i] = Integer.parseInt(args[i]);
        }
        root.traverse( levels );
    }

    private static Box initialize() {
        Box[] nodes = new Box[7];
        nodes[1] = new Box( 1 );
        int[] waves = {1, 4, 7};
        for (int i=0; i < 3; i++) {
            nodes[2] = new Box(21+i);
            nodes[1].add(nodes[2]);
            int level = 3;
            for (int j=0; j < 4; j++) {
                nodes[level-1].add( new Product(level*10 + waves[i]));
                nodes[level] = new Box(level*10 + waves[i]+1);
                nodes[level-1].add(nodes[level]);
                nodes[level-1].add(new Product(level*10 + waves[i]+2));
                level++;
            }
        }
        return nodes[1];
    }
}
