package neuron;

import java.lang.Math;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.exp;
import static java.lang.Math.sqrt;
import java.util.ArrayList;

/**
 * A theta neuron with simplified virtual coupling. That is, this neuron cannot be coupled to other neurons,
 * but inhibitory pulses can be introduced that simulate an I cell firing into this neuron. The relevant
 * equation of d(theta)/dt is modified to more easily study the effect of inhibitory pulses on the behavior
 * of theta.
 *
 * @author	Adam J. Raczkowski
 * @since	0.1
 * @version	%I%, %G%
 */
public class ThetaNeuronSSimple extends ThetaNeuron {

    protected final double tau_I_DEFAULT = 10;
    protected final double r_DEFAULT = 5;

    private double ISpikeTime;
    private double tau_I;
    private double r;

    /**
     * Creates a simple theta neuron with inhibitory input using default
     * {@link neuron.ThetaNeuron#ThetaNeuron() ThetaNeuron} constructor and
     * initial inhibitory constant tau_I_DEFAULT and initial r value r_DEFAULT.
     *
     * @see	neuron.ThetaNeuron#ThetaNeuron()
     * @since	0.1
     */
    public ThetaNeuronSSimple()
    {
	super();
	initialize(-1.0, tau_I_DEFAULT, r_DEFAULT);
    }

    /**
     * Creates a simple theta neuron with inhibitory input using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(boolean) ThetaNeuron} constructor and
     * initial inhibitory constant tau_I_DEFAULT and initial r value r_DEFAULT.
     *
     * @param	isECell	Flag for whether this neuron is excitatory
     * @see	neuron.ThetaNeuron#ThetaNeuron(boolean)
     * @since	0.1
     */
    public ThetaNeuronSSimple(boolean isECell)
    {
	super(isECell);
	initialize(-1.0, tau_I_DEFAULT, r_DEFAULT);
    }

    /**
     * Creates a simple theta neuron with inhibitory input using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType) ThetaNeuron} constructor and
     * initial inhibitory constant tau_I_DEFAULT and initial r value r_DEFAULT.
     *
     * @param	type	The type of neuron to create
     * @see	neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType)
     * @since	0.1
     */
    public ThetaNeuronSSimple(CellType type)
    {
	super(type);
	initialize(-1.0, tau_I_DEFAULT, r_DEFAULT);
    }

    /**
     * Creates a simple theta neuron with inhibitory input using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(double,double,double) ThetaNeuron} constructor and
     * initial inhibitory constant tau_I_DEFAULT and initial r value r_DEFAULT.
     *
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @see	neuron.ThetaNeuron#ThetaNeuron(double,double,double)
     * @since	0.1
     */
    public ThetaNeuronSSimple(double theta_0, double t_0, double I)
    {
	super(theta_0, t_0, I);
	initialize(-1.0, tau_I_DEFAULT, r_DEFAULT);
    }

    /**
     * Creates a simple theta neuron with inhibitory input using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(boolean,double,double,double) ThetaNeuron} constructor and
     * initial inhibitory constant tau_I_DEFAULT and initial r value r_DEFAULT.
     *
     * @param	isECell	Flag for whether this neuron is excitatory
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @see	neuron.ThetaNeuron#ThetaNeuron(boolean,double,double,double)
     * @since	0.1
     */
    public ThetaNeuronSSimple(boolean isECell, double theta_0, double t_0, double I)
    {
	super(isECell, theta_0, t_0, I);
	initialize(-1.0, tau_I_DEFAULT, r_DEFAULT);
    }

    /**
     * Creates a simple theta neuron with inhibitory input using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType,double,double,double) ThetaNeuron} constructor and
     * initial inhibitory constant tau_I_DEFAULT and initial r value r_DEFAULT.
     *
     * @param	type	The type of neuron to create
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @see	neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType,double,double,double)
     * @since	0.1
     */
    public ThetaNeuronSSimple(CellType type, double theta_0, double t_0, double I)
    {
	super(type, theta_0, t_0, I);
	initialize(-1.0, tau_I_DEFAULT, r_DEFAULT);
    }

    /**
     * Creates a simple theta neuron with inhibitory input using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(boolean,double,double,double) ThetaNeuron}
     * constructor and initial inhibitory constant
     * <code>tI_0</code> and initial r value <code>r_0</code>.
     *
     * @param	isECell	Flag for whether this neuron is excitatory
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @param	tI_0	The value of the inhibitory constant
     * @param	r_0	The r value (strength of virtual "coupling")
     * @see	neuron.ThetaNeuron#ThetaNeuron(boolean,double,double,double)
     * @since	0.1
     */
    public ThetaNeuronSSimple(boolean isECell, double theta_0, double t_0, double I, double tI_0, double r_0)
    {
	super(isECell, theta_0, t_0, I);
	initialize(-1.0, tI_0, r_0);
    }

    /**
     * Initializes the instances variables of this theta neuron.
     *
     * @param	d	The initial I cell spike time
     * @param	tau_I_0	The inhibitory coupling constant
     * @param	r_0	The strength of the virtual "coupling"
     * @since	0.1
     */
    private void initialize(double d, double tau_I_0, double r_0)
    {
	ISpikeTime = d;
	tau_I = tau_I_0;
	r = r_0;
    }

    /**
     * Introduces a virtual inhibitory spike to this simplified theta neuron. The input is
     * virtual because no such I cell is coupled to this neuron.
     *
     * @since	0.1
     */
    public void introduceISpike()
    {
	ISpikeTime = getT();
    }

    /**
     * Returns the value of the function d(theta)/dt, the differential equation that governs the
     * behavior of a theta neuron, with the addition of the simplified synaptic coupling variable values.
     *
     * @return	Value of d(theta)/dt expression describing this theta neuron with simplified synaptic coupling
     * @since	0.1
     */
    public double dthetadt()
    {
	double theta_ = getTheta();
	double t_spike = ISpikeTime;
	double I_ = getI();
	double t_ = getT();

	if (t_spike < 0.0)
	    return (1 - cos(theta_)) + I_*(1 + cos(theta_));

	return (1 - cos(theta_)) + I_*(1 - r*exp((t_spike - t_)/tau_I))*(1 + cos(theta_));
    }
}