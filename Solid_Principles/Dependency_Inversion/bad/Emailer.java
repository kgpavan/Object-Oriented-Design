package design.solid_principles.dependency_inversion.bad.src;

/**
 * Created by mrk on 4/8/14.
 */
public class Emailer {
    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}
