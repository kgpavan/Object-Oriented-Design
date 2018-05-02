import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Tests for {@link WashingMachine}
 */
public class WashingMachineTest {

    private volatile WashingMachineState machineStateGlobal;

    @Test
    public void wash() throws Exception {
      WashingMachine washingMachine = new WashingMachine();
      ExecutorService executorService = Executors.newFixedThreadPool(2);
      executorService.execute(washingMachine::wash);
      executorService.execute(() -> {
        washingMachine.wash();
        machineStateGlobal = washingMachine.getWashingMachineState();
      });
      executorService.shutdown();
      try {
        executorService.awaitTermination(10, TimeUnit.SECONDS);
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
      assertEquals(WashingMachineState.WASHING, machineStateGlobal);
    }

    @Test
    public void endOfWashing() throws Exception {
      WashingMachine washingMachine = new WashingMachine();
      washingMachine.wash();
      assertEquals(WashingMachineState.ENABLED, washingMachine.getWashingMachineState());
    }
}