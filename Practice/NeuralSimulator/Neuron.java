package neuron;

import java.util.ArrayList;

/**
 * An abstract base class for the various models used to describe
 * the spiking behavior of a neuron.
 *
 * @author	Adam J. Raczkowski
 * @since	0.1
 * @version	%I%, %G%
 */
public abstract class Neuron {

    private final double INIT_V = 0.0;
    private final double INIT_T = 0.0;
    private final int INIT_SPIKE_ARRAY_SIZE = 100;
    public static final int INIT_ARRAY_SIZE = 10000;

    private CellType type;
    private ArrayList<Double> values;
    private ArrayList<Double> t;
    private ArrayList<Double> spikes;

    /**
     * An enumeration of the possible cell types for a neuron. 
     *
     * @author	Adam J. Raczkowski
     * @since	0.1
     * @version	%I%, %G%
     */
    public enum CellType { ECELL, ICELL }

    /**
     * Creates an excitatory neuron with initial potential given by
     * INIT_V and at start time INIT_T.
     *
     * @since	0.1
     */
    public Neuron()
    {
	initialize(CellType.ECELL, INIT_V, INIT_T);
    }

    /**
     * Creates an neuron with initial potential given by
     * INIT_V and at start time INIT_T. If <code>isECell</code> is
     * true, then this neuron will be an excitatory neuron; otherwise, it
     * will be an inhibitory neuron.
     *
     * @param	isECell	Flag for whether this neuron is excitatory
     * @since	0.1
     */
    public Neuron(boolean isECell)
    {
	CellType type = (isECell) ? CellType.ECELL : CellType.ICELL;
	initialize(type, INIT_V, INIT_T);
    }

    /**
     * Creates an neuron with initial potential given by
     * INIT_V and at start time INIT_T and of type given by <code>type</code>.
     *
     * @param	type	The type of neuron to create
     * @since	0.1
     */
    public Neuron(CellType type)
    {
	initialize(type, INIT_V, INIT_T);
    }

    /**
     * Creates an excitatory neuron with initial potential given by
     * <code>v_0</code> and at start time <code>t_0</code>.
     *
     * @param	v_0	The initial potential for this neuron
     * @param	t_0	The start time for this neuron
     * @since	0.1
     */
    public Neuron(double v_0, double t_0)
    {
	initialize(CellType.ECELL, v_0, t_0);
    }

    /**
     * Creates an excitatory neuron with initial potential given by
     * <code>v_0</code> and at start time <code>t_0</code>. If <code>isECell</code> is
     * true, then this neuron will be an excitatory neuron; otherwise, it
     * will be an inhibitory neuron.
     *
     * @param	isECell	Flag for whether this neuron is excitatory
     * @param	v_0	The initial potential for this neuron
     * @param	t_0	The start time for this neuron
     * @since	0.1
     */
    public Neuron(boolean isECell, double v_0, double t_0)
    {
	CellType type = (isECell) ? CellType.ECELL : CellType.ICELL;
	initialize(type, v_0, t_0);
    }

    /**
     * Creates an neuron of type given by <code>type</code> with initial potential given by
     * <code>v_0</code> and at start time <code>t_0</code>.
     *
     * @param	type	The type of neuron to create
     * @param	v_0	The initial potential for this neuron
     * @param	t_0	The start time for this neuron
     * @since	0.1
     */
    public Neuron(CellType type, double v_0, double t_0)
    {
	initialize(type, v_0, t_0);
    }

    /**
     * Initializes the instance variables for this neuron.
     *
     * @param	type	The type of neuron to create
     * @param	v_0	The initial potential for this neuron
     * @param	t_0	The start time for this neuron
     * @since	0.1
     */
    private void initialize(CellType type, double v_0, double t_0)
    {
	this.type = type;

	values = new ArrayList<Double>(INIT_ARRAY_SIZE);
	t = new ArrayList<Double>(INIT_ARRAY_SIZE);
	spikes = new ArrayList<Double>(INIT_SPIKE_ARRAY_SIZE);

	addValue(v_0);
	addT(t_0);	
    }

    /**
     * Returns the cell type of this neuron.
     *
     * @return	The cell type of this neuron
     * @since	0.1
     */
    public CellType getType()
    {
	return this.type;
    }

    /**
     * Returns whether this neuron is an excitatory neuron.
     *
     * @return	<code>true</code> if this neuron is excitatory; <code>false</code> otherwise.
     * @since	0.1
     */
    public boolean isECell()
    {
	return getType() == CellType.ECELL;
    }

    /**
     * Sets the type of this neuron to the provided type.
     *
     * @param	type	The cell type to change this neuron to
     * @since	0.1
     */
    public void setType(CellType type)
    {
	this.type = type;
    }

    /**
     * Returns the current potential for this neuron.
     *
     * @return	The current potential of this neuron
     * @since	0.1
     */
    public double getValue()
    {
	return values.get(values.size() - 1);
    }

    /**
     * Returns the entire accumulated history of potential values for this neuron.
     *
     * @return	The history list of potentials for this neuron
     * @since	0.1
     */
    public Double[] getValueList()
    {
	Double[] a = new Double[1];
	return values.toArray(a);
    }

    /**
     * Sets the potential of this neuron to the specified value <code>v</code>.
     *
     * @param	v	The potential to set this neuron to
     * @since	0.1
     */
    protected void addValue(double v)
    {
	values.add(v);
    }

    /**
     * Returns the current time value for this neuron.
     *
     * @return	The current time value for this neuron
     * @since	0.1
     */
    public double getT()
    {
	return t.get(t.size() - 1);
    }

    /**
     * Returns the entire accumulated history of time values for this neuron.
     *
     * @return	The history list of time values for this neuron
     * @since	0.1
     */
    public Double[] getTList()
    {
	Double[] a = new Double[1];
	return t.toArray(a);
    }

    /**
     * Sets the time value of this neuron to the specified value <code>v</code>.
     *
     * @param	v	The time value to set this neuron to
     * @since	0.1
     */
    protected void addT(double v)
    {
	t.add(v);
    }

    /**
     * Returns array of all times that this neuron has fired. The spike times 
     * are calculated and possibly approximated by the {@link #calcSpikeTime calcSpikeTime} method.
     *
     * @return	Array of all spike times for this neuron since its inception
     * @see	#calcSpikeTime
     * @since	0.1
     */
    public Double[] getSpikeList()
    {
	Double[] a = new Double[1];
	return spikes.toArray(a);
    }

    /**
     * Returns the last time that this neuron has spiked, or fired. If this neuron has not spiked
     * since its inception, returns -1. The spike time is calculated by
     * the {@link #calcSpikeTime calcSpikeTime} method.
     *
     * @return	The last time this neuron fired
     * @see	#calcSpikeTime
     * @since	0.1
     */
    public double getLastSpike()
    {
	if (spikes.size() == 0) return -1.0;
	return spikes.get(spikes.size()-1);
    }

    /**
     * Adds the specified time value <code>v</code> to the list of spike times for this neuron. This method
     * should only be called at the end of the {@link #calcSpikeTime calcSpikeTime} method after the spike
     * time has been approximated. Hence, this method may be deprecated in future versions.
     *
     * @param	v	The spike time to add to list of spikes
     * @see	#calcSpikeTime
     * @since	0.1
     */
    protected void addSpike(double v)
    {
	spikes.add(v);
    }

    /**
     * Steps this neuron into the future by an amount specified by <code>stepSize</code>. This method
     * is useful for simulations of neurons that would require a neuron to be time-stepped into the future
     * at small increments. Child classes should override this method to use an approximation (such as Euler's
     * method) to increment other instance variables.
     *
     * @param	stepSize	The amount of time by which to step this neuron into the future
     * @since	0.1
     */
    public void step(double stepSize)
    {
	// Step neuron into future by calculating new value of t and adding to array of t values
	double t_new = calcNewT(stepSize);
	addT(t_new);
    }

    /**
     * Calculates and returns the new time value for this neuron given a timestep into the future of
     * size <code>stepSize</code>. This method should be called by the {@link #step step} method and hence its
     * scope may become private in future versions.
     *
     * @param	stepSize	The amount of time by which this neuron is stepped into the future
     * @since	0.1
     */
    protected double calcNewT(double stepSize)
    {
	return this.getT() + stepSize; // Simply add the stepSize to the current time value
    }

    /**
     * Caculates and possibly approximates the time at which this neuron spiked (fired). The parameters
     * <code>t_i</code> and <code>value_i</code> denote the time and value, respectively, of this neuron
     * at the previous time step, and the parameters <code>t_f</code> and <code>value_f</code> denote the 
     * time and value of this neuron at the current time step. From these values and usually a given
     * threshold value above which the neuron spikes can the spike time of the neuron be approximated. This
     * method will depend upon threshold values and approximation strategies and so should be implemented
     * in the child class.
     *
     * @param	t_i	The time value of this neuron at the previous time step
     * @param	t_f	The time value of this neuron at the current time step
     * @param	value_i	The potential value of this neuron at the previous time step
     * @param	value_f The potential value of this neuron at the current time step
     * @since	0.1
     */
    abstract protected void calcSpikeTime(double t_i, double t_f, double value_i, double value_f);
}