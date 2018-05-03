import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Base class for weapon tests
 */
public abstract class WeaponTest {

  /**
   * Invoke the basic actions of the given weapon, and test if the underlying enchantment implementation
   * is invoked
   *
   */
  protected final void testBasicWeaponActions(final Weapon weapon) {
    assertNotNull(weapon);
    Enchantment enchantment = weapon.getEnchantment();
    assertNotNull(enchantment);
    assertNotNull(weapon.getEnchantment());

    weapon.swing();
    verify(enchantment).apply();
    verifyNoMoreInteractions(enchantment);

    weapon.wield();
    verify(enchantment).onActivate();
    verifyNoMoreInteractions(enchantment);

    weapon.unwield();
    verify(enchantment).onDeactivate();
    verifyNoMoreInteractions(enchantment);

  }
}
