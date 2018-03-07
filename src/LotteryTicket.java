/**
 * A lottery ticket belonging to the convenience store inventory.
 * 
 * @author Eric Li
 * @version 1.0 2018-03-05
 */
public class LotteryTicket extends Item 
{
	public LotteryTicket()
	{
		super();
	}
	
	public LotteryTicket(String name, int quantity, double price)
	{
		super(name, quantity, price);
	}
	
	@Override
	public int getID() 
	{
		return Inventory.LOTTERY_TICKET_ID;
	}
	
	@Override
	public String getType() {
		return "Lottery Ticket";
	}
}
