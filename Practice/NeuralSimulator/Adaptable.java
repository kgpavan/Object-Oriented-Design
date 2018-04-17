package neuron;

/**
 * Specifies methods for an adaptable neuron. An adaptable neuron is one that exhibits
 * adaptation currents. 
 *
 * @author	Adam J. Raczkowski
 * @since	0.1
 * @version	%I%, %G%
 */
public interface Adaptable {

    /**
     * Returns the current adaptation value of this neuron.
     *
     * @return	Adapation value of this neuron
     * @since	0.1
     */
    public double getG_A();

    /**
     * Returns the entire accumulated history of adaptation values for this neuron.
     *
     * @return	Array of adaptation values of this neuron
     * @since	0.1
     */
    public Double[] getG_AList();
}