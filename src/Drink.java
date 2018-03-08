/**
 * A drink item belonging to the convenience store inventory.
 * 
 * @author Eric Li
 * @version 1.0 2018-03-05
 */
public class Drink extends Item 
{
	// class fields
	
	// instance fields
	
	private double volume;
	
	// constructors 
	
	/**
	 * Constructs a drink item with the default characteristics.
	 */
	public Drink()
	{
		super();
		volume = 0;
	} // end of default constructor Drink()
	
	/**
	 * Constructs a store drink with the specified characteristics.
	 * 
	 * @param name the name of this drink
	 * @param quantity the initial quantity of this drink
	 * @param price the initial price of this drink
	 * @param volume the initial volume of this drink
	 */
	public Drink(String name, int quantity, double price, double volume)
	{
		super(name, quantity, price);
		this.volume = volume;
	} // end of constructor Drink(String name...
	
	// accessors

	@Override
	public int getID() 
	{
		return Inventory.DRINK_ID;
	} // end of method getID()
	
	@Override
	public String getType() 
	{
		return "Drink";
	} // end of method getType()
	
	/**
	 * Returns the volume of this drink.
	 * 
	 * @return the volume of this drink
	 */
	public double getVolume() 
	{
		return volume;
	} // end of method getVolume()
	
	// mutators
	
	/**
	 * Sets the volume of this drink.
	 * 
	 * @param volume the volume of this drink
	 */
	public void setVolume(double volume)
	{
		this.volume = volume;
	} // end of method setVolume(double volume)
} // end of class Drink