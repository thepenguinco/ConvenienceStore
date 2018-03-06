import java.util.ArrayList;

/**
 * An item belonging to the convenience store inventory.
 * 
 * @author Eric Li
 * @version 1.0 2018-01-10
 */
public abstract class Item 
{
	// class fields

	// instance fields

	private double costPerUnit; // TODO
	private String name;
	private double price;
	private int quantity;

	// constructors

	/**
	 * Constructs a store item with default characteristics
	 */
	public Item()
	{
		this.name = "";
		this.price = 0;
		this.quantity = 0;
	} // end of default constructor Item()

	/**
	 * Constructs a store item with the specified characteristics
	 */
	public Item(String name, int quantity, double price)
	{
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	} // end of constructor Item(String name...

	// accessors

	//TODO ?
	/**
	 * Return the cost per unit quantity of this item
	 * 
	 * @return the cost per unit quantity of this item
	 */
	public double getCostPerUnit()
	{
		return costPerUnit;
	} // end of method getCostPerUnit

	/**
	 * Returns the name of this item
	 * 
	 * @return the name of this item
	 */
	public String getItemName() 
	{
		return name;
	} // end of method getItemName()

	/**
	 * Returns the price of this item
	 * 
	 * @return the price of this item
	 */
	public double getPrice() 
	{
		return price;
	} // end of method getPrice()

	/**
	 * Returns the type of this item..
	 * 
	 * @return the type of this item
	 */
	public abstract String getType();
	
	/**
	 * Returns the quantity in stock of this item.
	 * 
	 * @return the quantity in stock of this item
	 */
	public int getQuantity()
	{
		return quantity;
	} // end of method getQuantity()

	// mutators

	/**
	 * Adds the specified quantity to stock.
	 * 
	 * @param quantity the quantity to add to stock.
	 * @pre specified quantity must be a non-negative integer.
	 */
	public void addQuantity(int quantity)
	{
		if (quantity > 0) 
		{
			this.quantity = this.quantity + quantity;
		}
	} // end of method addQuantity(int quantity) 

	/**
	 * Sets the cost per unit of this item.
	 * 
	 * @param cost the cost per unit of this item.
	 */
	public void setCostPerUnit(int cost)
	{
		this.costPerUnit = cost;
	} // end of method setCostPerUnit(int cost)

	/**
	 * Sets the name of this item.
	 * 
	 * @param name the name of this item.
	 */
	public void setName(String name)
	{
		this.name = name;
	} // end of sertName(String name)

	/**
	 * Sets the quantity of this item to the specified quantity.
	 * 
	 * @param quantity the quantity of this item.
	 * @pre specified quantity must be a non-negative integer.
	 */
	public void setQuantity(int quantity)
	{
		if (quantity > 0)
		{
			this.quantity = quantity;
		}
	} // end of method setQuantity(int quantity)

	/**
	 * Sets the price of this item to the specified price.
	 * 
	 * @param price the price of this item.
	 * @pre specified price must be a non-negative double.
	 */
	public void setPrice(double price) 
	{
		if (price > 0)
		{
			this.price = price;
		}
	} // end of method setPrice(double price)

	/**
	 * Removes the specified quantity from stock
	 * 
	 * @param quantity the quantity to remove from stock.
	 * @pre specified quantity must be a non-negative integer
	 */
	public void removeQuantity(int quantity)
	{
		if (quantity > 0) 
		{
			this.quantity = this.quantity - quantity;
		}
	} // end of removeQuantity(int quantity) 
}