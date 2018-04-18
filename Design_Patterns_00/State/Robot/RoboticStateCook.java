package com.state.robot;

/**
 * Created by Chaklader on 2/15/17.
 */
public class RoboticStateCook implements RoboticState{

    private final  Robot robot;

    public RoboticStateCook(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void off() {
        robot.setRoboticState(robot.getRoboticStateOff());
        System.out.println("the robot is switching off .. ");
    }

    @Override
    public void walk() {
        robot.setRoboticState(robot.getRoboticStateOn());
        System.out.println("the robot is walking ...");
    }

    @Override
    public void cook() {
        System.out.println("the robot is cooking ...");
    }
}
