
import org.junit.Assert;
import org.junit.Test;


/**
 * Test for Price Rest Controller
 */
public class PriceControllerTest {

	@Test
	public void testgetPrice() {
		PriceController priceController = new PriceController();

		String price = priceController.getPrice();
		Assert.assertEquals("20", price);
	}
}
