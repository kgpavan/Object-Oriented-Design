package com.state.robot;

/**
 * Created by Chaklader on 2/15/17.
 */
public class RoboticStateOff implements RoboticState{

    private  final Robot robot;

    public RoboticStateOff(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void off() {
        System.out.println("the robot is switched off now");
    }

    @Override
    public void walk() {
        robot.setRoboticState(robot.getRoboticStateOn());
        System.out.println("the robot is walking now ...");
    }

    @Override
    public void cook() {
        robot.setRoboticState(robot.getRoboticStateCook());
        System.out.println("the robot is cooking now ....");
    }
}
