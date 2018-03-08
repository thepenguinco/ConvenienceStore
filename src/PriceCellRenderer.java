import java.awt.Component;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * A cell renderer that formats prices with currency symbols.
 * 
 * @author Eric Li
 * @version 1.0 2018-03-06
 */
public class PriceCellRenderer extends DefaultTableCellRenderer {

	/**
	 * Format the prices to 2 decimal places and with the dollar sign
	 */
	public final static NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();
	
	/**
	 * Default constructor for a price cell renderer.
	 */
	public PriceCellRenderer() 
	{
		super();
	} // end of default constructor PriceCellRenderer()

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	{
		if (value instanceof Double) {
			value = CURRENCY_FORMAT.format(value);
		}
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	} // end of method getTableCellRendererComponent...
} // end of class PriceCellRenderer