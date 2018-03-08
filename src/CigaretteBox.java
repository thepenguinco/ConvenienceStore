/**
 * A cigarette box belonging to the convenience store inventory.
 * 
 * @author Eric Li
 * @version 1.0 2018-03-05
 */
public class CigaretteBox extends Item 
{
	// class fields
	
	// instance fields
	
	private String size;
	
	// constructors
	
	/**
	 * Constructs a cigarette box with default characteristics.
	 */
	public CigaretteBox()
	{
		super();
		size = "";
	} // end of default constructor CigaretteBox()
	
	/**
	 * Constructs a store item with default characteristics.
	 * 
	 * @param name the name of this cigarette box
	 * @param quantity the initial quantity of this cigarette box
	 * @param price the initial price of this cigarette box
	 * @param size the initial size of this cigarette box
	 */
	public CigaretteBox(String name, int quantity, double price, String size)
	{
		super(name, quantity, price);
		this.size = size;
	} // end of constructor CigaretteBox(String name...
	
	@Override
	public int getID() 
	{
		return Inventory.CIGARETTE_BOX_ID;
	}

	@Override
	public String getType() 
	{
		return "Cigarette Box";
	}

	/**
	 * Returns the size of this cigarette box.
	 * 
	 * @return the size of this cigarette box
	 */
	public String getSize() 
	{
		return size;
	}
	
	/**
	 * Sets the size of this cigarette box.
	 * 
	 * @param size the size of this cigarette box
	 */
	public void setSize(String size)
	{
		this.size = size;
	} // end of method setSize(String size)
} // end of class CigaretteBox