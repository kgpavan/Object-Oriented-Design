import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Composite pattern is a partitioning design pattern. The Composite pattern describes that a
 * group of objects is to be treated in the same way as a single instance of an object. The intent
 * of a composite is to "compose" objects into tree structures to represent part-whole hierarchies.
 * Implementing the Composite pattern lets clients treat individual objects and compositions
 * uniformly.
 * <p>
 * In this example we have sentences composed of words composed of letters. All of the objects can
 * be treated through the same interface ({@link LetterComposite}).
 * 
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    /**
     * Program entry point
     * 
     * @param args command line args
     */
    public static void main(String[] args) {
      LOGGER.info("Message from the orcs: ");

      LetterComposite orcMessage = new Messenger().messageFromOrcs();
      orcMessage.print();

      LOGGER.info("\nMessage from the elves: ");

      LetterComposite elfMessage = new Messenger().messageFromElves();
      elfMessage.print();
    }
}
