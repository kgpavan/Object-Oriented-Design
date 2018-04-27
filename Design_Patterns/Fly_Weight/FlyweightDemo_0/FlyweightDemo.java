package com.sourcemaking.flyweight.second_example.after;


import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

/**
 * 8 shared HandlerThreads in a ThreadPool
 * The ColorBox class has now become a Flyweight: the color changing
 * and painting capability remains "intrinsic", and the threaded
 * behavior has been made "extrinsic".
 *
 * The ThreadPool class plays the role of the Factory. As ColorBox
 * objects are created, they register themselves with the ThreadPool
 * object. The latter launches 8 "handler" threads. When each thread
 * is swapped into the CPU, it selects a random Flyweight from the
 * ThreadPool's cache, and asks the object to changeColor().
 */

class ColorBox extends Canvas {
    private Color  curColor = getColor();
    private static Color[]  colors = { Color.black, Color.blue, Color.cyan,
            Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.red,
            Color.magenta, Color.orange, Color.pink, Color.white, Color.yellow };

    public ColorBox(ThreadPool tp) {
        tp.register(this);
    }

    private static Color getColor() {
        return colors[(int)(Math.random() * 1000) % colors.length];
    }

    public void changeColor() {
        curColor = getColor();
        repaint();
    }

    public void paint(Graphics g) {
        g.setColor(curColor);
        g.fillRect( 0, 0, getWidth(), getHeight() );
    }
}

class ThreadPool {
    private Vector boxes = new Vector();
    private int pause;

    class HandlerThread extends Thread {
        public void run() {
            while(true) {
                ((ColorBox)boxes.elementAt(
                        (int)(Math.random()*1000) % boxes.size() )).changeColor();
                try {
                    Thread.sleep(pause);
                } catch(InterruptedException ignored) {}
            }
        }
    }

    public ThreadPool(int p) {
        pause = p;
    }

    public void register(ColorBox r) {
        boxes.addElement(r);
    }

    public void start() {
        int NUM_THREADS = 8;
        for (int i = 0; i < NUM_THREADS; i++) {
            new HandlerThread().start();
        }
    }
}

public class FlyweightDemo {
    public static void main( String[] args ) {
        int size = 8;
        int pause = 100;
        if (args.length > 0) {
            size  = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            pause = Integer.parseInt(args[1]);
        }
        ThreadPool tp = new ThreadPool(pause);
        Frame frame = new Frame("ColorBoxes - 8 shared HandlerThreads");
        frame.setLayout(new GridLayout(size, size));
        for (int i=0; i < size * size; i++) {
            frame.add(new ColorBox(tp));
        }
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        tp.start();
    }
}
