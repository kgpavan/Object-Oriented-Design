import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller providing endpoints to retrieve product inventories
 */
@RestController
public class InventoryController {

  /**
   * Endpoint to retrieve a product's inventories.
   *
   * @return product inventory.
   */
  @RequestMapping(value = "/inventories", method = RequestMethod.GET)
  public int getProductInventories() {
    return 5;
  }

}
