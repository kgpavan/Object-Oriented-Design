package com.sourcemaking.state.third_example;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * State design pattern - an FSM with two states and one event
 * 1. (distributed transition logic - logic in the derived state classes)
 * 2. Create a "wrapper" class that models the state machine
 * 3. The wrapper class maintains a "current" state object
 * 4. All client requests are simply delegated to the current state object and the wrapper object's "this" pointer is passed
 * 5. Create a state base class that makes the concrete states interchangeable
 * 6. The State base class specifies any useful "default" behavior
 * 7. The State derived classes only override the messages they need to o/r
 * 8. The State methods will change the "current" state in the "wrapper"
 */

// 1. The "wrapper" class
class Button {
    // 2. The "current" state object
    private State current;

    public Button() {
        current = OFF.instance();
    }

    public void setCurrent(State s) {
        current = s;
    }

    // 3. The "wrapper" always delegates to the "wrappee"
    public void push() {
        current.push(this);
    }
}

// 4. The "wrappee" hierarchy
class State {
    // 5. Default behavior can go in the base class
    public void push(Button b) {
        b.setCurrent(OFF.instance());
        System.out.println("   turning OFF");
    }
}

class ON extends State {
    private static ON instance = new ON();

    private ON() {}

    public static State instance() {
        return instance;
    }
}

class OFF extends State {
    private static OFF instance = new OFF();
    private OFF() { }

    public static State instance() {
        return instance;
    }
    // 6. Override only the necessary methods
    public void push(Button b) {
        // 7. The "wrappee" may callback to the "wrapper"
        b.setCurrent(ON.instance());
        System.out.println("   turning ON");
    }
}

public class StateDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader( System.in );
        Button btn = new Button();
        while (true) {
            System.out.print("Press 'Enter'");
            is.read();
            btn.push();
        }
    }
}
