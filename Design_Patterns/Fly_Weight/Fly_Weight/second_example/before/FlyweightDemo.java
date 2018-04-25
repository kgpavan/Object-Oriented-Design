package com.sourcemaking.flyweight.second_example.before;


import java.awt.*;
import java.awt.event.*;

class ColorBox extends Canvas implements Runnable {
    private int    pause;
    private Color  curColor = getColor();
    private static Color[]  colors = {Color.black, Color.blue, Color.cyan,
            Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.red,
            Color.magenta, Color.orange, Color.pink, Color.white, Color.yellow};

    public ColorBox(int p) {
        pause = p;
        new Thread(this).start();
    }

    private static Color getColor() {
        return colors[(int)(Math.random() * 1000) % colors.length];
    }
    public void run() {
        while(true) {
            curColor = getColor();
            repaint();
            try {
                Thread.sleep(pause);
            } catch(InterruptedException ignored) { }
        }
    }

    public void paint(Graphics g) {
        g.setColor(curColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}

public class FlyweightDemo {
    public static void main( String[] args ) {
        int size = 8;
        int pause = 100;
        if (args.length > 0) {
            size  = Integer.parseInt( args[0] );
        }
        if (args.length > 1) {
            pause = Integer.parseInt( args[1] );
        }
        Frame frame = new Frame( "ColorBoxes - 1 thread per ColorBox" );
        frame.setLayout( new GridLayout( size, size ) );
        for (int i=0; i < size*size; i++) {
            frame.add( new ColorBox(pause));
        }
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
