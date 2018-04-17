package neuron;

import static java.lang.Math.cos;
import static java.lang.Math.exp;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.util.ArrayList;

/**
 * An object to act as a module for other {@link neuron.Neuron Neuron}s to provide adaptation currents.
 * This allows adaptation currents to be seamlessly added to other neurons. This class is not
 * meant to be instantiated by itself; it should be a data member of a Neuron object.
 *
 * @author	Adam J. Raczkowski
 * @since	0.1
 * @version	%I%, %G%
 */
public class AdaptationCurrent {

    protected final double tau_A = 40;
    protected final double C = 0.81;
    protected final double eta = 5;
    protected final double deltag_A = 0.02;

    private ThetaNeuron n;
    private ArrayList<Double> g_A;

    /**
     * Creates a module for a neuron to give it adaptation currents.
     * <code>n</code> is the neuron that adaptation currents will be applied to.
     * <code>g_A_0</code> is the initial value of <code>n</code>'s adaptation current
     * variable.
     * 
     * @param	n	The neuron to which to apply adaptation currents
     * @param	g_A_0	The initial value of the adaptation current constant
     * @since	0.1
     */
    public AdaptationCurrent(ThetaNeuron n, double g_A_0)
    {
	initialize(n, g_A_0);
    }

    /**
     * Initializes the instance variables for this adaptation current.
     *
     * @param	n	The neuron to which to apply adaptation currents
     * @param	s_0	The initial value of the adaptation current variable
     * @since	0.1
     */
    private void initialize(ThetaNeuron n, double g_A_0)
    {
	this.n = n;
	g_A = new ArrayList<Double>(Neuron.INIT_ARRAY_SIZE);
	addG_A(g_A_0);
    }

    /**
     * Returns the value of the adaptation current variable of the neuron this
     * adaptation current is attached to.
     *
     * @return	The value of the adaptation current variable for the neuron this adaptation current is attached to
     * @since	0.1
     */
    public double getG_A()
    {
	return g_A.get(g_A.size() - 1);
    }

    /**
     * Returns the entire accumulated history of adaptation current values for the neuron this adaptation
     * current is attached to.
     *
     * @return	Array of adaptation current values
     * @since	0.1
     */
    public Double[] getG_AList()
    {
	Double[] a = new Double[1];
	return g_A.toArray(a);
    }

    /**
     * Sets the adaptation current value to the specified value <code>v</code>.
     *
     * @param	v	The adaptation current value to set this object to
     * @since	0.1
     */
    public void addG_A(double v)
    {
	g_A.add(v);
    }

    /**
     * Calculates and returns the new adaptation current variable value for the neuron this adaptation current is
     * attached to. The new value is determined by using a first-order convergence Euler approximation
     * with timestep given by <code>stepSize</code> and the differential equation describing the adaptation
     * current variable value in {@link #dg_Adt dg_Adt}.
     *
     * @param	stepSize	The timestep to use in the Euler approximation of the new adaptation current value
     * @return	The new value for the adaptation current value
     * @see	#dg_Adt
     * @since	0.1
     */
    public double calcNewG_A(double stepSize)
    {
	double g_A = getG_A();
	return g_A + (stepSize * dg_Adt());
    }

    /**
     * Returns the value of the function d(g_A)/dt, the differential equation that governs the behavior
     * of the adaptation current variable value.
     *
     * @return	The value of the function d(g_A)/dt describing the adaptation current variable value
     * @since	0.1
     */
    protected double dg_Adt()
    {
	double g_A = getG_A();
	double theta_ = (n == null) ? 0.0 : n.getTheta();
	return -1*(g_A/tau_A) + C*sqrt(eta)*exp(-1*eta*(1+cos(theta_)))*deltag_A;
    }
}