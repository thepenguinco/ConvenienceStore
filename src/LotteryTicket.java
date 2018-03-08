/**
 * A lottery ticket belonging to the convenience store inventory.
 * 
 * @author Eric Li
 * @version 1.0 2018-03-05
 */
public class LotteryTicket extends Item 
{
	/**
	 * Constructs a store lottery ticket with default characteristics.
	 */
	public LotteryTicket()
	{
		super();
	} // end of default constructor LotteryTicket()

	/**
	 * Constructs a store lottery ticket with the specified characteristics.
	 * 
	 * @param name the name of this item
	 * @param quantity the initial quantity of this item
	 * @param price the initial price of this item
	 */
	public LotteryTicket(String name, int quantity, double price)
	{
		super(name, quantity, price);
	} // end of constructor LotteryTicket(String name...

	@Override
	public int getID() 
	{
		return Inventory.LOTTERY_TICKET_ID;
	} // end of method getID()

	@Override
	public String getType() {
		return "Lottery Ticket";
	} // end of method getType()
} // end of class LotteryTicket
