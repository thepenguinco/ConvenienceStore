/**
 * A food item belonging to the convenience store inventory.
 * 
 * @author Eric Li
 * @version 1.0 2018-03-05
 */
public class Food extends Item 
{
	private double weight;
	
	public Food()
	{
		super();
	}
	
	public Food(String name, int quantity, double price, double weight)
	{
		super(name, quantity, price);
		this.weight = weight;
	}

	@Override
	public String getType() {
		return "Food";
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight)
	{
		this.weight = weight;
	}
}
