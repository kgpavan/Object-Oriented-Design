package com.state.robot;

/**
 * Created by Chaklader on 2/15/17.
 */


/*added the new behaviour of the robot and almost
dont need to change the code */
public class RoboticStateStandby implements RoboticState {

    private final Robot robot;

    public RoboticStateStandby(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void off() {
        System.out.println("the robot is in the standby state ...");
        robot.setRoboticState(robot.getRoboticStateOff());
        System.out.println("the robot is switched off .... ");
    }

    @Override
    public void walk() {
        System.out.println("the robot is in the standby state ...");
        robot.setRoboticState(robot.getRoboticStateOn());
        System.out.println("robot is walking ....");
    }

    @Override
    public void cook() {
        System.out.println("the robot is in the standby state ...");
        robot.setRoboticState(robot.getRoboticStateCook());
        System.out.println("robot is cooking .....");
    }
}
