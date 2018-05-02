import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Test Aggregation of domain objects
 */
public class AggregatorTest {

    @InjectMocks
    private Aggregator aggregator;

    @Mock
    private ProductInformationClient informationClient;

    @Mock
    private ProductInventoryClient inventoryClient;

    @Before
    public void setup() {
      MockitoAnnotations.initMocks(this);
    }

    /**
     * Tests getting the data for a desktop client
     */
    @Test
    public void testGetProduct() {
      String title = "The Product Title.";
      int inventories = 5;

      when(informationClient.getProductTitle()).thenReturn(title);
      when(inventoryClient.getProductInventories()).thenReturn(inventories);

      Product testProduct = aggregator.getProduct();

      assertEquals(title, testProduct.getTitle());
      assertEquals(inventories, testProduct.getProductInventories());
    }
}
