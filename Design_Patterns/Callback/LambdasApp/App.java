
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Callback pattern is more native for functional languages where functions are treated as
 * first-class citizens. Prior to Java 8 callbacks can be simulated using simple (alike command)
 * interfaces.
 * 
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    /**
     * Program entry point
     */
    public static void main(String[] args) {
      Task task = new SimpleTask();
      Callback callback = new Callback() {
        @Override
        public void call() {
          LOGGER.info("I'm done now.");
        }
      };
      task.executeWith(callback);
    }
}
