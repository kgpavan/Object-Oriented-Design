import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * An adapter to communicate with inventory micro-service.
 */
@Component
public class ProductInventoryClientImpl implements ProductInventoryClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductInventoryClientImpl.class);

    @Override
    public int getProductInventories() {
        String response = "0";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
          HttpGet httpGet = new HttpGet("http://localhost:51516/inventories");
          try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
            response = EntityUtils.toString(httpResponse.getEntity());
          }
        } catch (IOException e) {
          LOGGER.error("Exception caught.", e);
        }
        return Integer.parseInt(response);
    }
}
