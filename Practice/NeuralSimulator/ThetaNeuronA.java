package neuron;

import static java.lang.Math.cos;
import static java.lang.Math.exp;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.util.ArrayList;

/**
 * A theta neuron with adaptation currents. This extends
 * the functionality of a basic theta neuron by associating adaptation currents with each neuron.
 * These currents inhibit the neuron from firing just after it has fired.
 *
 * @author	Adam J. Raczkowski
 * @since	0.1
 * @version	%I%, %G%
 */
public class ThetaNeuronA extends ThetaNeuron implements Adaptable {

    private final double INIT_G = 0.0;

    private AdaptationCurrent a;

    /**
     * Creates a theta neuron with adaptation currents using the default
     * {@link neuron.ThetaNeuron#ThetaNeuron() ThetaNeuron} constructor and
     * initial adaptation current variable value of INIT_G.
     *
     * @see	neuron.ThetaNeuron#ThetaNeuron()
     * @since	0.1
     */
    public ThetaNeuronA()
    {
	super();
	initialize(INIT_G);
    }

    /**
     * Creates a theta neuron with adaptation currents using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(boolean) ThetaNeuron} constructor
     * and initial adaptation current variable value of INIT_G.
     *
     * @param	isECell	Flag for whether this neuron is excitatory
     * @see	neuron.ThetaNeuron#ThetaNeuron(boolean)
     * @since	0.1
     */
    public ThetaNeuronA(boolean isECell)
    {
	super(isECell);
	initialize(INIT_G);
    }

    /**
     * Creates a theta neuron with adaptation currents using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType) ThetaNeuron} constructor
     * and initial adaptation variable value of INIT_G.
     *
     * @param	type	The type of neuron to create
     * @see	neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType)
     * @since	0.1
     */
    public ThetaNeuronA(CellType type)
    {
	super(type);
	initialize(INIT_G);
    }

    /**
     * Creates a theta neuron with adaptation currents using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(double,double,double) ThetaNeuron} constructor
     * and initial adaptation current variable value of <code>g_0</code>.
     *
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @param	g_0	The initial value of the adaptation current variable
     * @see	neuron.ThetaNeuron#ThetaNeuron(double,double,double)
     * @since	0.1
     */
    public ThetaNeuronA(double theta_0, double t_0, double I, double g_0)
    {
	super(theta_0, t_0, I);
	initialize(g_0);
    }

    /**
     * Creates a theta neuron with adaptation currents using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(boolean,double,double,double) ThetaNeuron} constructor
     * and initial adaptation current variable value of <code>g_0</code>.
     *
     * @param	isECell	Flag for whether this neuron is excitatory
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @param	g_0	The initial value of the adaptation current variable
     * @see	neuron.ThetaNeuron#ThetaNeuron(boolean,double,double,double)
     * @since	0.1
     */
    public ThetaNeuronA(boolean isECell, double theta_0, double t_0, double I, double g_0)
    {
	super(isECell, theta_0, t_0, I);
	initialize(g_0);
    }

    /**
     * Creates a theta neuron with synaptic coupling using appropriate
     * {@link neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType,double,double,double) ThetaNeuron} constructor
     * and initial adaptation current variable value of <code>g_0</code>.
     *
     * @param	type	The type of neuron to create
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @param	g_0	The initial value of the adaptation current variable
     * @see	neuron.ThetaNeuron#ThetaNeuron(Neuron.CellType,double,double,double)
     * @since	0.1
     */
    public ThetaNeuronA(CellType type, double theta_0, double t_0, double I, double g_0)
    {
	super(type, theta_0, t_0, I);
	initialize(g_0);
    }

    /**
     * Initializes the instance variables of this theta neuron.
     * 
     * @param	g_0	The initial value of the adaptation current variable
     * @since	0.1
     */
    private void initialize(double g_0)
    {
	a = new AdaptationCurrent(this, g_0);
    }

    /**
     * Returns the value of the adaptation current variable of this neuron.
     *
     * @return	The value of the adaptation current variable for this neuron
     * @since	0.1
     */
    public double getG_A()
    {
	return a.getG_A();
    }

    /**
     * Returns the entire accumulated history of adaptation current values for this neuron.
     *
     * @return	Array of adaptation current values
     * @since	0.1
     */
    public Double[] getG_AList()
    {
	return a.getG_AList();
    }

    /**
     * Steps this theta neuron into the future by an amount specified by <code>stepSize</code>. This method
     * is useful for simulations of neurons that would require a neuron to be time-stepped into the future
     * at small increments. The adaptation variable value is updated before calling the parent
     * method {@link neuron.ThetaNeuron#step step}. The synaptic gating variable value of this neuron
     * is updated to the return value of {@link neuron.AdaptationCurrent#calcNewG_A calcNewG_A}.
     *
     * @param	stepSize	The amount of time by which to step this neuron into the future
     * @see	neuron.AdaptationCurrent#calcNewG_A
     * @see	neuron.ThetaNeuron#step
     * @since	0.1
     */
    public void step(double stepSize)
    {
	double g_A_new = a.calcNewG_A(stepSize);

	super.step(stepSize);

	a.addG_A(g_A_new);
    }

    /**
     * Returns the value of the function d(theta)/dt, the differential equation that governs the
     * behavior of a theta neuron, with the addition of the adaptation current variable values.
     *
     * @return	Value of d(theta)/dt expression describing this theta neuron with adaptation currents
     * @since	0.1
     */
    protected double dthetadt()
    {
	double theta_ = getTheta();
	double I_ = getI();
	double g_A = getG_A();
	double V_A = (isECell()) ? V_rev_E : V_rev_I;

	return (1 - cos(theta_)) + (I_+g_A*(2*V_A-1))*(1 + cos(theta_))-g_A*sin(theta_);
    }
}
