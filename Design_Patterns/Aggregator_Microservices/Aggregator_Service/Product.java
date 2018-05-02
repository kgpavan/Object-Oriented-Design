/**
 * Encapsulates all the data for a Product that clients will request.
 */
public class Product {

    /**
     * The title of the product.
     */
    private String title;


    /**
     * The inventories of the product.
     */
    private int productInventories;

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public int getProductInventories() {
      return productInventories;
    }

    public void setProductInventories(int productInventories) {
      this.productInventories = productInventories;
    }
}
