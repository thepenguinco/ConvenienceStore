import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * An inventory table model that displays data from the inventory list in a JTable
 * 
 * @author Eric Li
 * @version 1.0 2018-03-02
 */
public class InventoryTableModel extends AbstractTableModel {

	// class fields

	public final static NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();

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

	public void refreshTable(ArrayList<Item> inventoryList) 
	{
		rowData.clear();
		rowData.addAll(inventoryList);
		fireTableDataChanged();
	}

	public void removeRow(int row) 
	{
		rowData.remove(row);
	}

	public void setRow(int row, Item item)
	{
		rowData.set(row, item);
	}

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
			value = CURRENCY_FORMAT.format(item.getPrice());
			break;
		case 4:
			if (item.getType().equals("Food"))
			{
				value = ((Food) item).getWeight() + "kg";
			}
			else if (item.getType().equals("Drink"))
			{
				value = ((Drink) item).getVolume() + "ml";
			}
			else if (item.getType().equals("Cigarettes"))
			{
				value = ((CigaretteBox) item).getSize();
			}
			//else if (item.getType().equals("Lottery Ticket"))
			else
			{
				value = "";
			}
		}
		return value;
	}
}