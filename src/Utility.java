/**
 * A utility class for the convenience store.
 * 
 * @author Eric Li
 * @version 1.0 2018-01-10
 */
public class Utility 
{
	// TODO
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
