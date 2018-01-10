import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    		if (line.length > 0)
     		{
    			// TODO
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
    
    public void addItem()
    {
    	
    }
    
    /**
     * Remove an item from this inventory list.
     */
    public void removeItem()
    {
    	
    }
    
    /**
     * Saves this inventory to a file database.
     */
    public void saveInventory()
    {
    	
    }
}
