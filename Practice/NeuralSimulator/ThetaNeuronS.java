package neuron;

import static java.lang.Math.cos;
import static java.lang.Math.exp;
import static java.lang.Math.sin;
import java.util.ArrayList;

/**
 * A theta neuron with the ability to be synaptically coupled to other couplable neurons. This extends
 * the functionality of a basic theta neuron by associating a synaptic gating value with each neuron and
 * by allowing associations of neurons by denoting that one neuron fires into another. These values
 * come into play when one neuron fires into another in a simple network.
 *
 * @author	Adam J. Raczkowski
 * @since	0.1
 * @version	%I%, %G%
 */
public class ThetaNeuronS extends ThetaNeuron implements Couplable {

    private final double INIT_S = 0.0; /* Between 0 and 1 please */
    private SynapticCoupling s;

    /**
     * Creates a theta neuron with synaptic coupling using default
     * {@link neuron.ThetaNeuron#ThetaNeuron() ThetaNeuron} constructor and
     * initial synaptic gating variable value of INIT_S.
     *
     * @see	neuron.ThetaNeuron#ThetaNeuron()
     * @since	0.1
     */
    public ThetaNeuronS()
    {
	super();
	initialize(INIT_S);
    }

    /**
     * Creates a theta neuron with synaptic coupling using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(boolean) ThetaNeuron} constructor
     * and initial synaptic gating variable value of INIT_S.
     *
     * @param	isECell	Flag for whether this neuron is excitatory
     * @see	neuron.ThetaNeuron#ThetaNeuron(boolean)
     * @since	0.1
     */
    public ThetaNeuronS(boolean isECell)
    {
	super(isECell);
	initialize(INIT_S);
    }

    /**
     * Creates a theta neuron with synaptic coupling using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType) ThetaNeuron} constructor
     * and initial synaptic gating variable value of INIT_S.
     *
     * @param	type	The type of neuron to create
     * @see	neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType)
     * @since	0.1
     */
    public ThetaNeuronS(CellType type)
    {
	super(type);
	initialize(INIT_S);
    }

    /**
     * Creates a theta neuron with synaptic coupling using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(double,double,double) ThetaNeuron} constructor
     * and initial synaptic gating variable value of <code>s_0</code>.
     *
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @param	s_0	The initial value of the synaptic coupling constant
     * @see	neuron.ThetaNeuron#ThetaNeuron(double,double,double)
     * @since	0.1
     */
    public ThetaNeuronS(double theta_0, double t_0, double I, double s_0)
    {
	super(theta_0, t_0, I);
	initialize(s_0);
    }

    /**
     * Creates a theta neuron with synaptic coupling using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(boolean,double,double,double) ThetaNeuron} constructor
     * and initial synaptic gating variable value of <code>s_0</code>.
     *
     * @param	isECell	Flag for whether this neuron is excitatory
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @param	s_0	The initial value of the synaptic coupling constant
     * @see	neuron.ThetaNeuron#ThetaNeuron(boolean,double,double,double)
     * @since	0.1
     */
    public ThetaNeuronS(boolean isECell, double theta_0, double t_0, double I, double s_0)
    {
	super(isECell, theta_0, t_0, I);
	initialize(s_0);
    }

    /**
     * Creates a theta neuron with synaptic coupling using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType,double,double,double) ThetaNeuron} constructor
     * and initial synaptic gating variable value of <code>s_0</code>.
     *
     * @param	type	The type of neuron to create
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @param	s_0	The initial value of the synaptic coupling constant
     * @see	neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType,double,double,double)
     * @since	0.1
     */
    public ThetaNeuronS(CellType type, double theta_0, double t_0, double I, double s_0)
    {
	super(type, theta_0, t_0, I);
	initialize(s_0);
    }

    /**
     * Initializes the instance variables of this theta neuron.
     * 
     * @param	s_0	The initial value of the synaptic gating variable
     * @since	0.1
     */
    private void initialize(double s_0)
    {
	s = new SynapticCoupling(this, s_0);	
    }

    /**
     * Returns the value of the synaptic gating variable of this neuron.
     *
     * @return	The value of the synaptic gating variable for this neuron
     * @since	0.1
     */
    public double getS()
    {
	return s.getS();
    }

    /**
     * Returns the weighted sum of all synaptic gating variables for those neurons that fire into
     * this neuron. The weights are given by the type of connectivity, determined by the
     * type of the presynaptic neuron and the type of the postsynaptic neuron (each either E cell or I cell).
     *
     * @return	The weighted sum of the synaptic gating variables of all presynaptic neurons
     * @since	0.1
     */
    public double getGS()
    {
	return s.getGS();
    }

    /**
     * Returns the entire accumulated history of synaptic gating values for this neuron.
     *
     * @return	Array of synaptic gating values
     * @since	0.1
     */
    public Double[] getSList()
    {
	return s.getSList();
    }

    /**
     * Adds <code>n</node> as a neuron that fires into this neuron.
     * Using this method, networks of neurons can be created.
     *
     * @param	n	A couplable neuron that fires into this neuron
     * @since	0.1 
     */
    public void addPresynapticNeuron(Couplable n)
    {
	s.addPresynapticNeuron(n);
    }

    /**
     * Returns array of all couplable neurons that fire into this neuron.
     *
     * @return	Array of all couplable neurons that fire into this neuron
     * @since	0.1
     */
    public Couplable[] getPresynapticNeurons()
    {
	return s.getPresynapticNeurons();
    }

    /**
     * Manually activates the synapse of this neuron by
     * setting the current synaptic gating value to 1. The current synaptic gating value is overwritten
     * and replaced by 1 and is not saved in the history generated by {@link #getSList getSList}.
     *
     * @since	0.1
     */
    public void activateSynapse()
    {
	s.activateSynapse();
    }

    /**
     * Steps this theta neuron into the future by an amount specified by <code>stepSize</code>. This method
     * is useful for simulations of neurons that would require a neuron to be time-stepped into the future
     * at small increments. The synaptic gating variable value is updated before calling the parent
     * method {@link neuron.ThetaNeuron#step step}. The synaptic gating variable value of this neuron
     * is updated to the return value of {@link neuron.SynapticCoupling#calcNewS calcNewS}.
     *
     * @param	stepSize	The amount of time by which to step this neuron into the future
     * @see	neuron.SynapticCoupling#calcNewS
     * @see	neuron.ThetaNeuron#step
     * @since	0.1
     */
    public void step(double stepSize)
    {
	double s_new = s.calcNewS(stepSize);

	super.step(stepSize);

	s.addS(s_new);
    }

    /**
     * Returns the value of the function d(theta)/dt, the differential equation that governs the
     * behavior of a theta neuron, with the addition of the synaptic coupling variable values.
     *
     * @return	Value of d(theta)/dt expression describing this theta neuron with synaptic coupling
     * @since	0.1
     */
    protected double dthetadt()
    {
	double theta_ = getTheta();
	double I_ = getI();
	double gs_ = getGS();
	double V_A = (this.isECell()) ? V_rev_E : V_rev_I;

	return (1 - cos(theta_)) + (I_+gs_*(2*V_A-1))*(1 + cos(theta_))-gs_*sin(theta_);
    }
}