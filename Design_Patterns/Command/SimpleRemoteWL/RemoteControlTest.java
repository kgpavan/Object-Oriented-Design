package design.design_patterns.command.simpleremoteWL;



public class RemoteControlTest {

    public static void main(String[] args) {

        // initiates the instances for the classes
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();


        remote.setCommand(light::on);
        remote.buttonWasPressed();

        remote.setCommand(garageDoor::up);
        remote.buttonWasPressed();

        remote.setCommand(garageDoor::lightOn);
        remote.buttonWasPressed();

        remote.setCommand(garageDoor::lightOff);
        remote.buttonWasPressed();
    }

}
