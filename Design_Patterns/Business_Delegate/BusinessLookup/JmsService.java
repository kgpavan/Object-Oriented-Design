import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service JMS implementation
 */
public class JmsService implements BusinessService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JmsService.class);

	@Override
		public void doProcessing() {
		LOGGER.info("JmsService is now processing");
	}
}
