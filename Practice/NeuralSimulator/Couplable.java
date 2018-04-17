package neuron;

/**
 * Specifies methods for a couplable neuron. A couplable neuron is one that can be
 * synaptically joined with other neurons to form a network.
 *
 * @author	Adam J. Raczkowski
 * @since	0.1
 * @version	%I%, %G%
 */
public interface Couplable {

    /**
     * Returns the current synaptic gating variable value of this neuron. This value is
     * in the range between 0 and 1, with 0 meaning the synapse gates are completely closed
     * and 1 meaning the synapse gates are completely open.
     *
     * @return	The synaptic gating variable value of this neuron
     * @since	0.1
     */
    public double getS();

    /**
     * Returns the entire accumulated history of synaptic gating variable values of this neuron.
     *
     * @return	Array of synaptic gating variable values of this neuron
     * @since	0.1
     */
    public Double[] getSList();

    /**
     * Returns whether this neuron is an excitatory neuron.
     *
     * @return	<code>true</code> if this neuron is excitatory; <code>false</code> otherwise.
     * @since	0.1
     */
    public boolean isECell();

    /**
     * Adds the couplable object <code>n</code> as a presynaptic neuron to this Couplable object.
     * That is, <code>n</code> fires directly from a synapse into this Couplable object.
     *
     * @param	n	The Couplable object that fires directly into this object
     * @since	0.1
     */
    public void addPresynapticNeuron(Couplable n);

    /**
     * Returns array of all Couplable objects that fire into this object.
     *
     * @return	Array of all Couplable objects that fire into this object.
     * @since 0.1
     */
    public Couplable[] getPresynapticNeurons();
}