import java.util.Optional;
import com.iluwatar.abstractdocument.Document;

/**
 * HasModel trait for static access to 'model' property
 */
public interface HasModel extends Document {

	String PROPERTY = "model";

	default Optional<String> getModel() {
		return Optional.ofNullable((String) get(PROPERTY));
	}
}
