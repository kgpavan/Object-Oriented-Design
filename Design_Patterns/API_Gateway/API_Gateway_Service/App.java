import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * This implementation shows what the API Gateway pattern could look like for an e-commerce site.
 * The {@link ApiGateway} makes calls to the Image and Price microservices using the
 * {@link ImageClientImpl} and {@link PriceClientImpl} respectively. Customers viewing the site on a
 * desktop device can see both price information and an image of a product, so the {@link ApiGateway}
 * calls both of the microservices and aggregates the data in the {@link DesktopProduct} model.
 * However, mobile users only see price information; they do not see a product image. For mobile
 * users, the {@link ApiGateway} only retrieves price information, which it uses to populate the
 * {@link MobileProduct}. </p>
 */
@SpringBootApplication
public class App {

	/**
	* Program entry point
	*
	* @param args
	*          command line args
	*/
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
