
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// Inventory
public class Inventory {


    private static final Logger LOGGER = LoggerFactory.getLogger(Inventory.class);

    private final int inventorySize;
    private final List<Item> items;
    private final Lock lock;

    /**
     * Constructor
     */
    public Inventory(int inventorySize) {
        this.inventorySize = inventorySize;
        this.items = new ArrayList<>(inventorySize);
        this.lock = new ReentrantLock();
    }

    /**
     * Add item
     */
    public boolean addItem(Item item) {
  
        if (items.size() < inventorySize) {  
          lock.lock();
  
          try {

            if (items.size() < inventorySize) {
                items.add(item);
                LOGGER.info("{}: items.size()={}, inventorySize={}", Thread.currentThread(), items.size(), inventorySize);
                return true;
            }
          } finally {
              lock.unlock();
          }
        }
        return false;
    }

    /**
     * Get all the items in the inventory
     *
     * @return All the items of the inventory, as an unmodifiable list
     */
    public final List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

}
