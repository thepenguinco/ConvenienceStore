import java.text.NumberFormat;

/**
 * A utility class for the convenience store.
 * 
 * @author Eric Li
 * @version 1.0 2018-01-10
 */
public class Utility 
{
	/**
	 * The delimiter for a space in the file database.
	 */
	public static final String MAGIC_SPACE = "\\s";
	
	/**
	 * Format currency numbers to two decimal places
	 */
	public final static NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();
    /**
     * Formats numbers to two decimal places for displaying prices.
     * 
     * @param number the original number to format
     * @return the number formatted to two decimal places
     */
    public static String formatPrice(double number)
    {
        return String.format("%.2f", number);
    }
    
    
}
