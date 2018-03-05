import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InventoryTableModel extends AbstractTableModel {

	// class fields

	public static final String[] COLUMN_NAMES = {
			"Name",
			"Type",
			"Quantity",
			"Price",
	};

	// instance fields
	private ArrayList<Item> rowData;

	public InventoryTableModel() 
	{
		rowData = new ArrayList<Item>();
	}

	public void refreshTable(Inventory inventoryList) 
	{
		rowData.clear();
		rowData.addAll(inventoryList.getInventoryList());
		fireTableDataChanged();
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
		switch (columnIndex) {
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
	        value = Utility.CURRENCY_FORMAT.format(item.getPrice());
		}
		return value;
	}
}
