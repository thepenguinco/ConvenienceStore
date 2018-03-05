import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * An inventory belonging to a convenience store.
 * 
 * @author Eric Li
 * @version 1.0 2018-01-10
 */
public class Inventory 
{
	// class fields

	/**
	 * The delimiter for a space in the file database.
	 */
	public static final String MAGIC_SPACE = "\\s";
	
	/**
	 * The valid number of line tokens per line in the file database.
	 */
	public static int VALID_LINE_LENGTH = 4;

	// instance fields

	private ArrayList<Item> inventoryList;

	// constructors

	/**
	 * Constructs an empty inventory list
	 */
	public Inventory()
	{
		inventoryList = new ArrayList<Item>();
	} // end of constructor Account()

	/**
	 * Constructs a inventory list from a file database.
	 * 
	 * @param fileName the file name of the database
	 * @throws IOException
	 */
	public Inventory(final String fileName) throws IOException
	{
		inventoryList = new ArrayList<Item>();

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
			if (line.length == VALID_LINE_LENGTH)
			{
				String name = line[0].replace(MAGIC_SPACE, " ");
				String type = line[1].replace(MAGIC_SPACE, " ");
				int quantity = Integer.parseInt(line[2]);
				double price = Double.parseDouble(line[3]);
				// double costPerUnit = Double.parseDouble(line[4]);
				Item item = new Item(name, type, quantity, price);
				inventoryList.add(item);
			} // end of if (line.length ...
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
		return inventoryList;
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
			database.println(item.getItemName().replace(" ", Utility.MAGIC_SPACE)
					+ " " + item.getType().replace(" ", Utility.MAGIC_SPACE)
					+ " " + item.getQuantity()
					+ " " + item.getPrice()
					/*+ " " + item.getCostPerUnit()*/);
		} // not done

		// wrap up
		database.close();
	} // end of method saveInventory(final String fileName...

	public void set(ArrayList<Item> rowData) 
	{
		inventoryList = rowData;
	}
}
