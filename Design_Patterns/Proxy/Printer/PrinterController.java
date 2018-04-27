
/**
 * Delegator Class to delegate the implementation of the Printer.
 * This ensures two things:
 *  - when the actual implementation of the Printer class changes the delegation will still be operational
 *  - the actual benefit is observed when there are more than one implementors and they share a delegation control
 */
public class PrinterController implements Printer {

    private final Printer printer;

    public PrinterController(Printer printer) {
      this.printer = printer;
    }

    /**
     * This method is implemented from {@link Printer} however instead on providing an
     * implementation, it instead calls upon the class passed through the constructor. This is the delegate,
     * hence the pattern. Therefore meaning that the caller does not care of the implementing class only the owning
     * controller.
     *
     * @param message to be printed to the screen
     */
    @Override
    public void print(String message) {
      printer.print(message);
    }
}
