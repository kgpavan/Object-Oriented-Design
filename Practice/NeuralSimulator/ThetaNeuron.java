package neuron;

import java.lang.Math;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.exp;
import static java.lang.Math.sqrt;
import java.util.ArrayList;

/**
 * A neuron implemented using the standard theta model. The potential values
 * for this neuron are represented by angles on a unit circle (the theta values) and
 * the neuron spikes when the value of theta exceeds the threshold of pi (3.14..). When
 * a ThetaNeuron spikes above threshold, its theta value is decreased by 2*pi so that 
 * the theta value is always in the range from -pi to pi.
 *
 * @author	Adam J. Raczkowski
 * @since	0.1
 * @version	%I%, %G%
 */
public class ThetaNeuron extends Neuron {

    protected final double V_rev_E = -0.25;
    protected final double V_rev_I = 6.5;

    private final double INIT_I = 0.0;
    private final double SPIKE_THRESHOLD = PI;

    private double I;

    /**
     * Creates a theta neuron using default {@link neuron.Neuron#Neuron() Neuron} constructor and initial drive
     * given by INIT_I.
     *
     * @see	neuron.Neuron#Neuron()
     * @since	0.1
     */
    public ThetaNeuron()
    {
	super();
	initialize(INIT_I);
    }

    /**
     * Creates a theta neuron using appropriate {@link neuron.Neuron#Neuron(boolean) Neuron}
     * constructor and initial drive given by INIT_I.
     *
     * @param	isECell	Flag for whether this neuron is excitatory
     * @see	neuron.Neuron#Neuron(boolean)
     * @since	0.1
     */
    public ThetaNeuron(boolean isECell)
    {
	super(isECell);
	initialize(INIT_I);
    }

    /**
     * Creates a theta neuron using appropriate {@link neuron.Neuron#Neuron(Neuron.CellType) Neuron}
     * constructor and initial drive given by INIT_I.
     *
     * @param	type	The type of neuron to create
     * @see	neuron.Neuron#Neuron(Neuron.CellType)
     * @since	0.1
     */
    public ThetaNeuron(CellType type)
    {
	super(type);
	initialize(INIT_I);
    }

    /**
     * Creates a theta neuron using appropriate {@link neuron.Neuron#Neuron(double,double) Neuron}
     * constructor and initial drive given by <code>I</code>.
     *
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @see	neuron.Neuron#Neuron(double,double)
     * @since	0.1
     */
    public ThetaNeuron(double theta_0, double t_0, double I)
    {
	super(theta_0, t_0);
	initialize(I);
    }

    /**
     * Creates a theta neuron using appropriate {@link neuron.Neuron#Neuron(boolean,double,double) Neuron}
     * constructor and initial drive given by <code>I</code>.
     *
     * @param	isECell	Flag for whether this neuron is excitatory
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @see	neuron.Neuron#Neuron(boolean,double,double)
     * @since	0.1
     */
    public ThetaNeuron(boolean isECell, double theta_0, double t_0, double I)
    {
	super(isECell, theta_0, t_0);
	initialize(I);
    }

    /**
     * Creates a theta neuron using appropriate {@link neuron.Neuron#Neuron(CellType,double,double) Neuron}
     * constructor and initial drive given by <code>I</code>.
     *
     * @param	type	The type of neuron to create
     * @param	theta_0	The initial theta value for this neuron
     * @param	t_0	The start time for this neuron
     * @param	I	The amount of drive for this neuron
     * @see	neuron.Neuron#Neuron(CellType,double,double)
     * @since	0.1
     */
    public ThetaNeuron(CellType type, double theta_0, double t_0, double I)
    {
	super(type, theta_0, t_0);
	initialize(I);
    }

    /**
     * Initializes the instance variables for this theta neuron.
     *
     * @param	I	The amount of drive for this neuron
     * @since	0.1
     */
    private void initialize(double I)
    {
	this.I = I;
    }

    /**
     * Returns the drive value of this theta neuron.
     *
     * @return	The drive value of this theta neuron
     * @since	0.1
     */
    public double getI()
    {
	return I;
    }

    /**
     * Sets the drive value of this theta neuron to the specified <code>I</code>.
     *
     * @param	I	The drive value to change this theta neuron's drive value to
     * @since	0.1
     */
    public void setI(double I)
    {
	this.I = I;
    }

    /**
     * Returns the current theta value of this theta neuron.
     *
     * @return	The current theta value of this theta neuron
     * @since	0.1
     */
    public double getTheta()
    {
	return getValue(); // The theta value is the potential value returned by getValue()
    }

    /**
     * Returns the entire accumulated history of theta values for this theta neuron.
     *
     * @return	Array of theta values of this neuron
     * @since	0.1
     */
    public Double[] getThetaList()
    {
	return getValueList(); // Theta values are the potential values returned by getValueList()
    }

    /**
     * Sets the theta value of this neuron to the specified value <code>theta</code>.
     *
     * @param	theta	The theta value to set this theta neuron to
     * @since	0.1
     */
    protected void addTheta(double theta)
    {
	addValue(theta); // Add theta value into general pontential value list
    }

    /**
     * Steps this theta neuron into the future by an amount specified by <code>stepSize</code>. This method
     * is useful for simulations of neurons that would require a neuron to be time-stepped into the future
     * at small increments. The theta value of this neuron is updated to the return value of
     * {@link #calcNewTheta calcNewTheta}. If the new value of theta is above SPIKE_THRESHOLD, then the
     * time at which this neuron spiked is calculated by {@link #calcSpikeTime calcSpikeTime} and the spike
     * list updated.
     *
     * @param	stepSize	The amount of time by which to step this neuron into the future
     * @see	#calcNewTheta
     * @see	#calcSpikeTime
     * @since	0.1
     */
    public void step(double stepSize)
    {
	double theta_ = getTheta(); // Somehow make this whole bit easier; push calcSpike to Neuron.class?
	double t_ = getT();
	double t_new = calcNewT(stepSize);

	double theta_new = calcNewTheta(stepSize);

	if (theta_new > SPIKE_THRESHOLD)
	{
	    calcSpikeTime(t_, t_new, theta_, theta_new);
	    theta_new -= 2*SPIKE_THRESHOLD;
 	}

	super.step(stepSize);

	addTheta(theta_new);
    }

    /**
     * Calculates and returns the new theta value for this theta neuron given a timestep into the future of
     * size <code>stepSize</code>. The new value of theta is calculated using a first-order convergence
     * Euler method approximation using the equation described by {@link #dthetadt dthetadt}.
     * This method should be called by the {@link #step step} method and hence its scope may
     * become private in future versions.
     *
     * @param	stepSize	The amount of time by which this neuron is stepped into the future
     * @see	#dthetadt
     * @since	0.1
     */
    protected double calcNewTheta(double stepSize)
    {
	/* TODO: Second order convergence on Euler's Method (Make it fancier) */
	double theta_ = getTheta();
	return theta_ + (stepSize * dthetadt());	
    }

    /**
     * Returns the value of the function d(theta)/dt, the differential equation that governs the
     * behavior of a theta neuron.
     *
     * @return	Value of d(theta)/dt expression describing this theta neuron
     * @since	0.1
     */
    protected double dthetadt()
    {
	double theta_ = getTheta();
	return (1 - cos(theta_)) + I*(1 + cos(theta_));
    }

    /**
     * Caculates and approximates the time at which this neuron spiked (fired). The parameters
     * <code>t_i</code> and <code>theta_i</code> denote the time and theta value, respectively, of this neuron
     * at the previous time step, and the parameters <code>t_f</code> and <code>theta_f</code> denote the 
     * time and value of this neuron at the current time step. From these values and the SPIKE_THRESHOLD value,
     * a linear approximation is used to determine when this theta neuron spiked using a convex combination
     * of the parameter values <code>t_i</code> and <code>t_f</code>.
     *
     * @param	t_i	The time value of this neuron at the previous time step
     * @param	t_f	The time value of this neuron at the current time step
     * @param	theta_i	The theta value of this neuron at the previous time step
     * @param	theta_f The theta value of this neuron at the current time step
     * @since	0.1
     */
    protected void calcSpikeTime(double t_i, double t_f, double theta_i, double theta_f)
    {
	double deltaTheta = theta_f - theta_i;
	double alpha = (PI - theta_i)/deltaTheta;
	double beta  = (theta_f - PI)/deltaTheta;
	
	double t_spike = alpha*t_i + beta*t_i;

	addSpike(t_spike);
    }
}