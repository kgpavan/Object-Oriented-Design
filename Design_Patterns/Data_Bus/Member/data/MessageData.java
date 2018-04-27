
import com.iluwatar.databus.AbstractDataType;
import com.iluwatar.databus.DataType;

/**
 * An event raised when a string message is sent.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
public class MessageData extends AbstractDataType {

    private final String message;

    public MessageData(String message) {
      this.message = message;
    }

    public String getMessage() {
      return message;
    }

    public static DataType of(final String message) {
      return new MessageData(message);
    }
}
