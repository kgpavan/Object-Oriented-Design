package com.state.robot;



/*
* A user can operate a robot using a set of commands via remote control. Currently, a robot can do
* three things, it can walk, cook, or can be switched off. The company has set protocols to define
* the functionality of the robot. If a robot is in “on” state you can command it to walk. If asked
* to cook, the state would change to “cook” or if set to “off”, it will be switched off. Similarly,
* when in “cook” state it can walk or cook, but cannot be switched off. And finally, when in “off”
* state it will automatically get on and walk when the user commands it to walk but cannot cook in
* off state. This might look like an easy implementation: a robot class with a set of methods like
* walk, cook, off, and states like on, cook, and off.
* */


public class RunRobotState {

    public static void main(String[] args) {

        System.out.println("Hello State Robot");
        Robot robot = new Robot();

        robot.walk();
        robot.cook();
        robot.walk();
        robot.off();

        robot.walk();
        robot.off();
        robot.cook();
    }
}
