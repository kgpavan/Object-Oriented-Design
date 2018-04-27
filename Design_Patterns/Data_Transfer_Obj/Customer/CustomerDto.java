
/**
 * {@link CustomerDto} is a data transfer object POJO. Instead of sending 
 * individual information to client We can send related information together 
 * in POJO.
 * <p>
 * Dto will not have any business logic in it.
 */
public class CustomerDto {

    private final String id;
    private final String firstName;
    private final String lastName;

    /**
     * @param id        customer id
     * @param firstName customer first name
     * @param lastName  customer last name
     */
    public CustomerDto(String id, String firstName, String lastName) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public String getId() {
      return id;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }
}
