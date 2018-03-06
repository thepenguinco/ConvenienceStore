/**
 * A cigarette box belonging to the convenience store inventory.
 * 
 * @author Eric Li
 * @version 1.0 2018-03-05
 */
public class CigaretteBox extends Item 
{
	private String size;
	
	public CigaretteBox()
	{
		super();
	}
	
	public CigaretteBox(String name, int quantity, double price, String size)
	{
		super(name, quantity, price);
		this.size = size;
	}

	@Override
	public String getType() {
		return "Cigarettes";
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size)
	{
		this.size = size;
	}
}
