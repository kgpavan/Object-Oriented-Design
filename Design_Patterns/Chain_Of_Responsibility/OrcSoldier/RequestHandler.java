
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RequestHandler
 */
public abstract class RequestHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);

    private RequestHandler next;

    public RequestHandler(RequestHandler next) {
      this.next = next;
    }

    /**
     * Request handler
     */
    public void handleRequest(Request req) {
      if (next != null) {
        next.handleRequest(req);
      }
    }

    protected void printHandling(Request req) {
      LOGGER.info("{} handling request \"{}\"", this, req);
    }

    @Override
    public abstract String toString();
}
