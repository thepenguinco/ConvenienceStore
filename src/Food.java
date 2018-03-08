/**
 * A food item belonging to the convenience store inventory.
 * 
 * @author Eric Li
 * @version 1.0 2018-03-05
 */
public class Food extends Item 
{
	// class fields
	
	// instance fields
	
	private double weight;
	
	// constructors
	
	/**
	 * Constructs a food item with default characteristics.
	 */
	public Food()
	{
		super();
		weight = 0;
	} // end of default constructor Food()
	
	/**
	 * Constructs a store food item with the specified characteristics.
	 * 
	 * @param name the name of this food item
	 * @param quantity the initial quantity of this food item
	 * @param price the initial price of this food item
	 * @param weight the initial weight of this food item
	 */
	public Food(String name, int quantity, double price, double weight)
	{
		super(name, quantity, price);
		this.weight = weight;
	} // end of constructor Food(String name...)

	@Override
	public int getID() 
	{
		return Inventory.FOOD_ID;
	} // end of method getID()
	
	@Override
	public String getType() 
	{
		return "Food";
	} // end of method getType()
	
	/**
	 * Returns the weight of this food item.
	 * 
	 * @return the weight of this food item
	 */
	public double getWeight() 
	{
		return weight;
	} // end of method getWeight()
	
	// mutators
	
	/**
	 * Sets the weight of this food item.
	 * 
	 * @param weight the weight of this food item
	 */
	public void setWeight(double weight)
	{
		this.weight = weight;
	} // end of method setWeight()
} // end of class Food