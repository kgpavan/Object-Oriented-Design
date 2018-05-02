
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller providing endpoints to retrieve information about products
 */
@RestController
public class InformationController {

	/**
	* Endpoint to retrieve a product's informations.
	*
	* @return product inventory.
	*/
	@RequestMapping(value = "/information", method = RequestMethod.GET)
	public String getProductTitle() {
		return "The Product Title.";
	}
}
