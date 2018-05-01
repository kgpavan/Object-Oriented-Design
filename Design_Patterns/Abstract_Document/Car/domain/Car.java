import java.util.Map;
import com.iluwatar.abstractdocument.AbstractDocument;

/**
 * Car entity
 */
public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts {

	public Car(Map<String, Object> properties) {
		super(properties);
	}
}
