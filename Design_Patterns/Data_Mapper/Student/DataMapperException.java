
/**
 * Using Runtime Exception for avoiding dependancy on implementation exceptions. This helps in
 * decoupling.
 * 
 * @author amit.dixit
 *
 */
public final class DataMapperException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new runtime exception with the specified detail message. The cause is not
   * initialized, and may subsequently be initialized by a call to {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for later retrieval by the
   *        {@link #getMessage()} method.
   */
  public DataMapperException(final String message) {
    super(message);
  }
}
