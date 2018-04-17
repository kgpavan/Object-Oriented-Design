package com.state.robot;

/**
 * Created by Chaklader on 2/15/17.
 */
public class Robot implements RoboticState {

    private RoboticState roboticState;

    private RoboticState roboticStateOn;
    private RoboticState roboticStateOff;
    private RoboticState roboticStateCook;

    private RoboticState roboticStateStandby;

    public Robot() {
        this.roboticStateOn = new RoboticStateOn(this);
        this.roboticStateOff = new RoboticStateOff(this);
        this.roboticStateCook = new RoboticStateCook(this);
        this.roboticStateStandby = new RoboticStateStandby(this);

        this.roboticState = roboticStateOn;
    }


    // setter and the getter of the  the robotc state
    public RoboticState getRoboticState() {
        return roboticState;
    }

    public void setRoboticState(RoboticState roboticState) {
        this.roboticState = roboticState;
    }


    // setter and the getter of the robotic state on
    public RoboticState getRoboticStateOn() {
        return roboticStateOn;
    }

    public void setRoboticStateOn(RoboticState roboticStateOn) {
        this.roboticStateOn = roboticStateOn;
    }


    // setter and the getter of the robotic state off
    public RoboticState getRoboticStateOff() {
        return roboticStateOff;
    }

    public void setRoboticStateOff(RoboticState roboticStateOff) {
        this.roboticStateOff = roboticStateOff;
    }

    // setter and the getter of the robotic state cook
    public RoboticState getRoboticStateCook() {
        return roboticStateCook;
    }

    public void setRoboticStateCook(RoboticState roboticStateCook) {
        this.roboticStateCook = roboticStateCook;
    }


    // setter and getter of the robotic state standby
    public RoboticState getRoboticStateStandby() {
        return roboticStateStandby;
    }

    public void setRoboticStateStandby(RoboticState roboticStateStandby) {
        this.roboticStateStandby = roboticStateStandby;
    }

    @Override
    public void off() {
        roboticState.off();
    }

    // after walking, standby for a while
    @Override
    public void walk() {
        roboticState.walk();
        setRoboticState(getRoboticStateStandby());
    }

    // after cooking, standby for a while
    @Override
    public void cook() {
        roboticState.cook();
        setRoboticState(getRoboticStateStandby());
    }
}
