import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * A transaction performed at the convenience store.
 * 
 * @author Eric Li
 * @version 1.0 2018-01-10
 */
public class Receipt
{
	// class fields



	/**
	 * The valid number of tokens per line for 
	 */
	public static final int RECEIPT_INFORMATION = 2;
	
	/**
	 * The valid number of tokens per line for an item in a receipt.
	 */
	public static final int ITEM_LENGTH = 5;

	// instance fields
	
	private long timestamp;
	private double totalCost;
	private ArrayList<Item> purchasedItems;

	// constructors

	/**
	 * Constructs an empty receipt.
	 */
	public Receipt()
	{
		timestamp = System.currentTimeMillis();
		purchasedItems = new ArrayList<Item>();
	} // end of constructor Account()

	/**
	 * Constructs a receipt from a file database.
	 * 
	 * @param fileName the file name of the database
	 * @throws IOException
	 */
	public Receipt(final String fileName) throws IOException
	{
		purchasedItems = new ArrayList<Item>();

		// Establish connections to the text files
		BufferedReader database = new BufferedReader(new FileReader(fileName));

		// Read from the first file
		String lineOfText = database.readLine();

		while (true)
		{
			lineOfText = database.readLine();
			if (lineOfText == null) break;
			// System.out.println(lineOfText);
			String[] line = lineOfText.split(" ");
			if (line.length == RECEIPT_INFORMATION)
			{
				timestamp = Long.parseLong(line[0]);
				totalCost = Double.parseDouble(line[1]);
			} // end of if (line.length ...
			else if (line.length == ITEM_LENGTH)
			{
				Item item = new Item()
			}
			else 
			{
				System.out.println("Your database is corrupt!");
				System.out.println("Halting program!");
				System.exit(0);
			} // end of else
		} // end of while (true)

		// wrap up
		database.close();
	} // end of constructor Inventory(final String fileName)

	/**
	 * Returns this inventory list.
	 * 
	 * @return inventoryList the inventory list
	 */
	public ArrayList<Item> getInventoryList()
	{
		return purchasedItems;
	} // end of method getInventoryList()

	/**
	 * Returns the item at the specified index from this inventory list.
	 * 
	 * @return item the item to be retrieved
	 */
	public Item getItem(int index)
	{
		return inventoryList.get(index);
	} // end of method getItem(int index)

	/**
	 * Adds an item to this inventory list.
	 * 
	 * @param item item to be added 
	 */
	public void addItem(Item item)
	{
		inventoryList.add(item);
	} // end of method addItem(Item item)

	/**
	 * Removes an item at the specified index from this inventory list.
	 * 
	 * @param index index of the item to be removed
	 */
	public void removeItem(int index)
	{
		inventoryList.remove(index);
	} // end of method removeItem(int index)

	/**
	 * Saves this inventory to a file database.
	 * 
	 * @param fileName the name of the file containing the database
	 * @throws IOException
	 */
	public void saveInventory(final String fileName) throws IOException
	{
		// Establish connections to the text files.
		PrintWriter database = new PrintWriter(new FileWriter(fileName));

		// Print first line
		database.println("START");

		// Populate database
		for (Item item : inventoryList)
		{
			database.println(item.getName().replace(" ", MAGIC_SPACE)
					+ " " + item.getType().replace(" ", MAGIC_SPACE)
					+ " " + item.getPrice()
					+ " " + item.getQuantity()
					+ " " + item.getCostPerUnit());
		} // not done

		// wrap up
		database.close();
	} // end of method saveInventory(final String fileName...
	// Handle purchases and sales, fileIO this
}
