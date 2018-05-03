import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * Service EJB implementation 
 */
public class EjbService implements BusinessService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EjbService.class);

	@Override
	public void doProcessing() {
		LOGGER.info("EjbService is now processing");
	}
}
