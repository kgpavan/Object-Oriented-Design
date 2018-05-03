import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of task that need to be executed
 */
public class SimpleTask extends Task {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTask.class);

	@Override
	public void execute() {
		LOGGER.info("Perform some important activity and after call the callback method.");
	}
}
