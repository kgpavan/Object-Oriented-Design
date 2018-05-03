package design.solid_principles.dependency_inversion.good.src;

/**
 * Created by mrk on 4/8/14.
 */
public class MobileDevice implements Notifier {
    public void alertWeatherConditions(String weatherConditions) {
        if (weatherConditions == "rainy")
            System.out.print("It is rainy");
    }
}
