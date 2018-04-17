package neuron;

import static java.lang.Math.cos;
import static java.lang.Math.exp;
import static java.lang.Math.sin;
import java.util.ArrayList;

/**
 * An object to act as a module for other {@link neuron.Neuron Neuron}s to provide synaptic coupling.
 * This allows networks to be created where one neuron will fire into another. This class is not
 * meant to be instantiated by itself; it should be a data member of a Neuron object.
 *
 * @author	Adam J. Raczkowski
 * @since	0.1
 * @version	%I%, %G%
 */
public class SynapticCoupling {

    private final double tau_R = 0.1;
    private final double eta = 5;

    private final double g_EE = 0.077;
    private final double g_IE = 0.077;
    private final double g_EI = 0.077;
    private final double g_II = 0.077;

    private ThetaNeuron n;
    private ArrayList<Double> s;
    private ArrayList<Couplable> actedUponBy;

    /**
     * Creates a module for a neuron to give it the ability to couple synaptically with
     * other neurons. <code>n_0</code> is the neuron that the synaptic coupling will
     * be applied to. <code>s_0</code> is the initial value of <code>n_0</code>'s synaptic gating
     * variable, a value between 0 and 1 which describes the openness of the synaptic gates
     * (0 for completely closed; 1 for completely open).
     * 
     * @param	n_0	The neuron to which to apply synaptic coupling
     * @param	s_0	The initial value of the synaptic gating variable
     * @since	0.1
     */
    public SynapticCoupling(ThetaNeuronS n_0, double s_0)
    {
	initialize(n_0, s_0);
    }

    /**
     * Initializes the instance variables for this synaptic coupling.
     *
     * @param	n_0	The neuron to which to apply synaptic coupling
     * @param	s_0	The initial value of the synaptic gating variable
     * @since	0.1
     */
    private void initialize(ThetaNeuronS n_0, double s_0)
    {
	this.n = n_0;
	s = new ArrayList<Double>(Neuron.INIT_ARRAY_SIZE);
	actedUponBy = new ArrayList<Couplable>();
	addS(s_0);
    }

    /**
     * Returns the value of the synaptic gating variable of the neuron this
     * synaptic coupling is attached to.
     *
     * @return	The value of the synaptic gating variable for the neuron this synaptic coupling is attached to
     * @since	0.1
     */
    public double getS()
    {
	return s.get(s.size() - 1);
    }

    /**
     * Returns the weighted sum of all synaptic gating variables for those neurons that fire into the neuron
     * that has this synaptic coupling. The weights are given by the type of connectivity, determined by the
     * type of the presynaptic neuron and the type of the postsynaptic neuron (each either E cell or I cell).
     *
     * @return	The weighted sum of the synaptic gating variables of all presynaptic neurons
     * @since	0.1
     */
    public double getGS()
    {
	double ret = 0.0;

	double g; double s_0;
	for (Couplable n_0 : actedUponBy) // Look at each presynaptic neuron
	{
	    s_0 = n_0.getS(); // Get s value of presynaptic neuron

	    // Apply appropriate weight
	    if (n.isECell())
		g = (n_0.isECell()) ? g_EE : g_IE;
	    else
		g = (n_0.isECell()) ? g_EI : g_II;

	    ret += g*s_0; // Keep running total
	}

	return ret;
    }

    /**
     * Returns the entire accumulated history of synaptic gating values for the neuron this synaptic
     * coupling is attached to.
     *
     * @return	Array of synaptic gating values
     * @since	0.1
     */
    public Double[] getSList()
    {
	Double[] a = new Double[1];
	return s.toArray(a);
    }

    /**
     * Sets the synaptic gating value to the specified value <code>v</code>.
     *
     * @param	v	The synaptic gating value to set this coupling to
     * @since	0.1
     */
    public void addS(double v)
    {
	s.add(v);
    }

    /**
     * Adds <code>n_0</node> as a neuron that fires into the neuron that this synaptic coupling is
     * attached to. Using this method, networks of neurons can be created.
     *
     * @param	n_0	A couplable neuron that fires into the neuron this synaptic coupling is associated with
     * @since	0.1 
     */
    public void addPresynapticNeuron(Couplable n_0)
    {
	actedUponBy.add(n_0);
    }

    /**
     * Returns array of all couplable neurons that fire into the neuron associated with this synaptic coupling.
     *
     * @return	Array of all couplable neurons that fire into the neuron associated with this synaptic coupling
     * @since	0.1
     */
    public Couplable[] getPresynapticNeurons()
    {
	Couplable[] a = new Couplable[1];
	return actedUponBy.toArray(a);
    }

    /**
     * Manually activates the synapse of the neuron this synaptic coupling is associated with by
     * setting the current synaptic gating value to 1. The current synaptic gating value is overwritten
     * and replaced by 1 and is not saved in the history generated by {@link #getSList getSList}.
     *
     * @since	0.1
     */
    public void activateSynapse()
    {
	s.set(s.size()-1, 1.0);
    }

    /**
     * Calculates and returns the new synaptic gating value for the neuron this synaptic coupling is
     * attached to. The new value is determined by using a first-order convergence Euler approximation
     * with timestep given by <code>stepSize</code> and the differential equation describing the synaptic
     * gating value in {@link #dsdt dsdt}.
     *
     * @param	stepSize	The timestep to use in the Euler approximation of the new synaptic gating value
     * @return	The new value for the synaptic gating value
     * @see	#dsdt
     * @since	0.1
     */
    public double calcNewS(double stepSize)
    {
	double s_ = getS();
	return s_ + (stepSize * dsdt());
    }

    /**
     * Returns the value of the function ds/dt, the differential equation that governs the behavior
     * of the synaptic gating value.
     *
     * @return	The value of the function ds/dt describing the synaptic gating value
     * @since	0.1
     */
    protected double dsdt()
    {
	double s_ = getS();
	double tau_D = (n.isECell()) ?  2 : 10; // tau_E is 2; tau_I is 10
	double theta_ = n.getTheta();

	return -1*(s_/tau_D) + exp(-1*eta*(1+cos(theta_)))*((1-s_)/tau_R);
    }
}