import java.util.Optional;
import com.iluwatar.abstractdocument.Document;

/**
 * HasPrice trait for static access to 'price' property
 */
public interface HasPrice extends Document {

	String PROPERTY = "price";

	default Optional<Number> getPrice() {
		return Optional.ofNullable((Number) get(PROPERTY));
	}
}
