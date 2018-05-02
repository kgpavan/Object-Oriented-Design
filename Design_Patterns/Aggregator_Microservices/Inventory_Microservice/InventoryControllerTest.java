import org.junit.Assert;
import org.junit.Test;

/**
 * Test Inventory Rest Controller
 */
public class InventoryControllerTest {

	@Test
	public void testGetProductInventories() throws Exception {
		
		InventoryController inventoryController = new InventoryController();
		int numberOfInventories = inventoryController.getProductInventories();

		Assert.assertEquals(5, numberOfInventories);
	}
}
