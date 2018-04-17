package com.state.robot;

/**
 * Created by Chaklader on 2/15/17.
 */
public class RoboticStateOn implements RoboticState{

    private final Robot pandaRobot;

    public RoboticStateOn(Robot robot) {
        this.pandaRobot = robot;
    }

    @Override
    public void off() {
        pandaRobot.setRoboticState(pandaRobot.getRoboticStateOff());
        System.out.println("the robot is switching off ....");
    }

    // robot will starts to walk just after turing on
    @Override
    public void walk() {
        System.out.println("the robot is walking ... ");
    }

    @Override
    public void cook() {
        System.out.println("the robot is cooking ....");
        pandaRobot.setRoboticState(pandaRobot.getRoboticStateCook());
    }
}
