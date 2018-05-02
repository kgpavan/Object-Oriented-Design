import org.junit.Assert;
import org.junit.Test;

/**
 * Test for Information Rest Controller
 */
public class InformationControllerTest {

  @Test
  public void shouldGetProductTitle() {
    InformationController infoController = new InformationController();

    String title = infoController.getProductTitle();

    Assert.assertEquals("The Product Title.", title);
  }
}
