
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * The Data Transfer Object pattern is a design pattern in which an data 
 * transfer object is used to serve related information together to avoid 
 * multiple call for each piece of information.
 * </p>
 * In this example, ({@link CustomerClientApp}) as as customer details 
 * consumer i.e. client to request for customer details to server.
 * <p>
 * CustomerResource ({@link CustomerResource}) act as server to serve customer information.
 * And The CustomerDto ({@link CustomerDto} is data transfer object to share customer information.
 */
public class CustomerClientApp {


    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerClientApp.class);

    private static void printCustomerDetails(List<CustomerDto> allCustomers) {
        allCustomers.forEach(customer -> LOGGER.info(customer.getFirstName()));
    }

    /**
     * Method as act client and request to server for details.
     *
     * @param args program argument.
     */
    public static void main(String[] args) {

        List<CustomerDto> customers = new ArrayList<>();

        CustomerDto customerOne = new CustomerDto("1", "Kelly", "Brown");
        CustomerDto customerTwo = new CustomerDto("2", "Alfonso", "Bass");

        customers.add(customerOne);
        customers.add(customerTwo);

        CustomerResource customerResource = new CustomerResource(customers);

        LOGGER.info("All customers:-");
        List<CustomerDto> allCustomers = customerResource.getAllCustomers();
        printCustomerDetails(allCustomers);

        LOGGER.info("----------------------------------------------------------");

        LOGGER.info("Deleting customer with id {1}");
        customerResource.delete(customerOne.getId());
        allCustomers = customerResource.getAllCustomers();
        printCustomerDetails(allCustomers);

        LOGGER.info("----------------------------------------------------------");

        LOGGER.info("Adding customer three}");
        CustomerDto customerThree = new CustomerDto("3", "Lynda", "Blair");
        customerResource.save(customerThree);
        allCustomers = customerResource.getAllCustomers();
        printCustomerDetails(allCustomers);
    }
}
