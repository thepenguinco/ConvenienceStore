import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * An inventory table model that displays data from the inventory list in a JTable
 * 
 * @author Eric Li
 * @version 1.0 2018-03-02
 */
public class InventoryTableModel extends AbstractTableModel {

	// class fields

	/**
	 * The delimiter for a space in the file database.
	 */
	public static final String MAGIC_SPACE = "\\s";

	public static final int FOOD_ID = 0;

	public static final int DRINK_ID = 1;

	public static final int CIGARETTE_BOX_ID = 2;

	public static final int LOTTERY_TICKET_ID = 3;

	/**
	 * The valid number of line tokens per line in the file database.
	 */
	public static final int VALID_LINE_LENGTH = 5;


	/**
	 * Table column headers
	 */
	public final static String[] COLUMN_NAMES = {
			"Name",
			"Type",
			"Quantity",
			"Price",
			"Information"
	};

	// instance fields
	
	private ArrayList<Item> rowData;

	/**
	 * Constructs an empty inventory table model.
	 */
	public InventoryTableModel() 
	{
		rowData = new ArrayList<Item>();
	} // end of constructor 

	/**
	 * Refreshes the list displayed with the specified list.
	 * 
	 * @param inventoryList the inventoryList to be displayed
	 */
	public void refreshTable(ArrayList<Item> inventoryList) 
	{
		rowData.clear();
		rowData.addAll(inventoryList);
		fireTableDataChanged();
	}

	/**
	 * Removes 
	 * 
	 * @param row
	 */
	public void removeRow(int row) 
	{
		rowData.remove(row);
	}

	/**
	 * Returns the table row data.
	 * 
	 * @return the table row data
	 */
	public void setRow(int row, Item item)
	{
		rowData.set(row, item);
	}

	/**
	 * Returns the table row data.
	 * 
	 * @return the table row data
	 */
	public ArrayList<Item> getRowData()
	{
		return rowData;
	}

	@Override
	public int getRowCount() 
	{
		return rowData.size();
	}

	@Override
	public int getColumnCount() 
	{
		return COLUMN_NAMES.length;
	}

	@Override
	public String getColumnName(int column) 
	{
		return COLUMN_NAMES[column];
	}

	/**
	 * Returns the item data of the selected row.
	 * 
	 * @param row the selected row in this table
	 * @return the Item representation of the data at the specified row
	 */
	public Item getItemData(int row) 
	{
		return rowData.get(row);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		Item item = getItemData(rowIndex);
		Object value = null;
		switch (columnIndex) 
		{
		case 0:
			value = item.getItemName();
			break;
		case 1:
			value = item.getType();
			break;
		case 2:
			value = item.getQuantity();
			break;
		case 3:
			value = item.getPrice();
			break;
		case 4:
			if (item.getType().equals("Food"))
			{
				value = ((Food) item).getWeight() + "g";
			}
			else if (item.getType().equals("Drink"))
			{
				value = ((Drink) item).getVolume() + "ml";
			}
			else if (item.getType().equals("Cigarettes"))
			{
				value = ((CigaretteBox) item).getSize();
			}
			else
			{
				value = "";
			}
		}
		return value;
	}
	
	/**
	 * Synchronizes the table model with this inventory list.
	 * 
	 * @param rowData the row data of the table model
	 */
	public void set(ArrayList<Item> inventoryList) 
	{
		rowData = (ArrayList<Item>) inventoryList.clone();
	} // end of method set(ArrayList<Item> inventoryList)
}