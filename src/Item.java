import java.util.ArrayList;

/**
 * An item belonging to the convenience store inventory.
 * 
 * @author Eric Li
 * @version 1.0 2018-01-10
 */
public class Item 
{
	// class fields

    // instance fields
    
	private double costPerUnit; // TODO
	private String name;
	private double price;
	private int quantity;
	private String type;
    
    // constructors
    
    /**
     * Constructs a store item with default characteristics
     */
    public Item()
    {
    		this.name = "";
    		this.price = 0;
    		this.quantity = 0;
    		this.type = "";
    } // end of default constructor Item()
    
    /**
     * Constructs a store item with the specified characteristics
     */
    public Item(String name, String type, int quantity, double price)
    {
    		this.name = name;
    		this.price = price;
    		this.quantity = quantity;
    		this.type = type;
    } // end of constructor StoreItem(String name...
    
    // accessors
    
    /**
     * Return the cost per unit quantity of this item
     * 
     * @return the cost per unit quantity of this item
     */
    public double getCostPerUnit()
    {
    		return costPerUnit;
    }
    
    /**
     * Returns the name of this item
     * 
     * @return the name of this item
     */
    public String getItemName() 
    {
    		return name;
    }
 
    /**
     * Returns the price of this item
     * 
     * @return the price of this item
     */
    public double getPrice() 
    {
    		return price;
    }
    
    /**
     * Returns the quantity in stock of this item
     * 
     * @return the quantity in stock of this item
     */
    public int getQuantity()
    {
    		return quantity;
    } // end of method getQuantity()
    
    /**
     * Returns the type of this item
     * 
     * @return the type of this item
     */
    public String getType()
    {
    		return type;
    } // end of method getType()
    
    // mutators
    
    /**
     * Adds the specified quantity to stock
     * 
     * @pre specified quantity must be a non-negative integer
     */
    public void addQuantity(int quantity)
    {
    		if (quantity > 0) 
    		{
    			this.quantity = this.quantity + quantity;
    		}
    } // end of method addQuantity 
    
    /**
     * Sets the cost per unit of this item
     * 
     * @param cost the cost per unit of this item
     */
    public void setCostPerUnit(int cost)
    	{
    		this.costPerUnit = cost;
    }
    
    /**
     * Sets the name of this item
     * 
     * @param name the name of this item
     */
    public void setName(String name)
    	{
    		this.name = name;
    }
    
    /**
     * Sets the type of this item
     * 
     * @param type the type of this item
     */
    public void setType(String type)
    	{
    		this.type = type;
    } // end of method setType()
    
    /**
     * Sets the quantity of this item to the specified quantity
     * 
     * @pre specified quantity must be a non-negative integer
     */
    public void setQuantity(int quantity)
    {
    		if (quantity > 0)
    		{
    			this.quantity = quantity;
    		}
    } // end of method setQuantity(int quantity)
    
    /**
     * Removes the specified quantity from stock
     * 
     * @pre specified quantity must be a non-negative integer
     */
    public void removeQuantity(int quantity)
    {
		if (quantity > 0) 
		{
			this.quantity = this.quantity - quantity;
		}
    } // end of removeQuantity(int quantity)

	public void setQuantity(String text) {
		// TODO Auto-generated method stub
		
	}

	public void setPrice(String text) {
		// TODO Auto-generated method stub
		
	}
    
    
}
