import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Tests for hammer
 */
public class HammerTest extends WeaponTest {

  /**
   * Invoke all possible actions on the weapon and check if the actions are executed on the actual
   * underlying weapon implementation.
   */
  @Test
  public void testHammer() throws Exception {
    final Hammer hammer = spy(new Hammer(mock(FlyingEnchantment.class)));
    testBasicWeaponActions(hammer);
  }
}