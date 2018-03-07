/**
 * A drink item belonging to the convenience store inventory.
 * 
 * @author Eric Li
 * @version 1.0 2018-03-05
 */
public class Drink extends Item 
{
	private double volume;
	
	public Drink()
	{
		super();
	}
	
	public Drink(String name, int quantity, double price, double volume)
	{
		super(name, quantity, price);
		this.volume = volume;
	}

	@Override
	public int getID() 
	{
		return Inventory.DRINK_ID;
	}
	
	@Override
	public String getType() 
	{
		return "Drink";
	}
	
	public double getVolume() 
	{
		return volume;
	}
	
	public void setVolume(double volume)
	{
		this.volume = volume;
	}
}
