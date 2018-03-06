import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JFileChooser;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

/**
 * The main interface of a convenience store. 
 * 
 * @author Eric Li
 * @version 1.0 2018-01-10
 */
public class StoreGUI extends JFrame 
{
	// class fields

	/**
	 * String array containing all the item types available at this store
	 */
	public static final String[] ITEM_TYPES = {"Food", "Drink", "Cigarettes", "Lottery Ticket"};
	
	// protected fields

	/*
	 * The GUI frame
	 */
	static StoreGUI frame = new StoreGUI();

	// instance fields
	private JPanel contentPane;
	private JTextField searchCriteria;
	private JTable table;
	private Inventory inventoryList;
	private InventoryTableModel model;
	private TableRowSorter<InventoryTableModel> sorter;

	// private methods
	/*
	 * Dialog box for adding items to the inventory management system
	 */
	private void addItemDialogBox() {
		JLabel categoryLabel = new JLabel("Category: ");
		JComboBox category = new JComboBox(ITEM_TYPES);
		category.setSelectedItem(null);
		JLabel nameLabel = new JLabel("Name:");
		JTextField name = new JTextField();
		JLabel quantityLabel = new JLabel("Quantity:");
		JTextField quantity = new JTextField();
		JLabel priceLabel = new JLabel("Price:");
		JTextField price = new JTextField();
		JLabel weightLabel = new JLabel("Weight:");
		JTextField weight = new JTextField();
		JLabel volumeLabel = new JLabel("Volume:");
		JTextField volume = new JTextField();
		Object[] message = {
				categoryLabel, category,
				nameLabel, name,
				quantityLabel, quantity,
				priceLabel, price,
				weightLabel, weight,
				volumeLabel, volume
		};
		category.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		            String selection = (String) category.getSelectedItem();
		            // FOOD
		            if (selection == ITEM_TYPES[0])
		            {
		            	weightLabel.setVisible(true);
		        		weight.setVisible(true);
		        		volumeLabel.setVisible(false);
		        		volume.setVisible(false);
		            }
		            // DRINK
		            else if (selection == ITEM_TYPES[1])
		            {
		            	weightLabel.setVisible(false);
		        		weight.setVisible(false);
		        		volumeLabel.setVisible(true);
		        		volume.setVisible(true);
		            }
		            // CIGARETTES
		            else if (selection == ITEM_TYPES[2])
		            {
		            	//TODO
		            }
		            else if (selection == ITEM_TYPES[3])
		            {
		            	// TODO
		            }
		        }
		    }
		});
		while (true)
		{
			
			int option = JOptionPane.showConfirmDialog(frame, message, "Add an item", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) 
			{
				try
				{
					if (name.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(frame, "You cannot leave the name empty.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if (category.getSelectedItem() == null)
					{
						JOptionPane.showMessageDialog(frame, "You cannot leave the category empty.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if (quantity.getText().isEmpty() || Integer.parseInt(quantity.getText()) <= 0)
					{
						JOptionPane.showMessageDialog(frame, "You must enter a valid quantity.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if (price.getText().isEmpty() || Double.parseDouble(price.getText()) <= 0)
					{
						JOptionPane.showMessageDialog(frame, "You must enter a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						Item item;
						String selection = (String) category.getSelectedItem();
						if (selection.equals(ITEM_TYPES[0]))
						{
							System.out.println("hello");
						}
						else if (selection.equals(ITEM_TYPES[1]))
						{
							System.out.println("hello");
						}
						else if (selection.equals(ITEM_TYPES[2]))
						{
							System.out.println("hello");
						}
						else if (selection.equals(ITEM_TYPES[3]))
						{
							System.out.println("hello");
						}
						else
						{
							System.out.println("Error!");
						}
						//Item item = new Item(name.getText(), , Integer.parseInt(quantity.getText()), Double.parseDouble(price.getText()));
						inventoryList.addItem(item);
						model.refreshTable(inventoryList);
						break;
					}
				}
				catch (NumberFormatException exception)
				{
					JOptionPane.showMessageDialog(frame, "You must enter a valid integer quantity and a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) 
			{
				break;
			}
		}
	}

	/*
	 * Dialog box for editing items in the inventory management system
	 */
	private void editItemDialogBox(Item item) {
		JTextField name = new JTextField(item.getItemName());
		JTextField quantity = new JTextField(Integer.toString(item.getQuantity()));
		JTextField price = new JTextField(Double.toString(item.getPrice()));
		Object[] message = {
				"Name:", name,
				"Type:", type,
				"Quantity:", quantity,
				"Price:", price
		};
		while (true)
		{	
			int option = JOptionPane.showConfirmDialog(frame, message, "Edit an item", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) 
			{
				try
				{
					if (name.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(frame, "You cannot leave the name empty.", "Error", JOptionPane.ERROR_MESSAGE);
					} 
					// USE INHERITANCE
					else if (type.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(frame, "You cannot leave the type empty.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if (quantity.getText().isEmpty() || Integer.parseInt(quantity.getText()) <= 0)
					{
						JOptionPane.showMessageDialog(frame, "You must enter a valid quantity.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if (price.getText().isEmpty() || Double.parseDouble(price.getText()) <= 0)
					{
						JOptionPane.showMessageDialog(frame, "You must enter a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						item.setName(name.getText());
						item.setType(type.getText());
						item.setQuantity(Integer.parseInt(quantity.getText()));
						item.setPrice(Double.parseDouble(price.getText()));
						model.refreshTable(inventoryList);
						break;
					}
				}
				catch (NumberFormatException exception)
				{
					JOptionPane.showMessageDialog(frame, "You must enter a valid integer quantity and a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) 
			{
				break;
			}
		}
	}
	
	/*
	 * 
	 */
	private void search(String text)
	{
		// TODO
	}

	/**
	 * Launch the main application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	} // end of method main(String[] args)

	/**
	 * Create the frame.
	 */
	public StoreGUI()
	{
		setTitle("Convenience Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 640, 441);
		contentPane.add(tabbedPane);

		JPanel inventoryPanel = new JPanel();
		tabbedPane.addTab("Inventory Management", null, inventoryPanel, null);
		inventoryPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 18, 510, 395);
		inventoryPanel.add(scrollPane);

		// Inventory List Initialization
		inventoryList = new Inventory();
		model = new InventoryTableModel();
		table = new JTable(model);
		sorter = new TableRowSorter<InventoryTableModel>(model);
		table.setRowSorter(sorter);
		scrollPane.setViewportView(table);

		searchCriteria = new JTextField();
		searchCriteria.setBounds(515, 44, 100, 20);
		inventoryPanel.add(searchCriteria);
		searchCriteria.setColumns(10);

		JLabel searchCriteriaLabel = new JLabel("Search Criteria");
		searchCriteriaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchCriteriaLabel.setBounds(515, 25, 100, 15);
		inventoryPanel.add(searchCriteriaLabel);

		JButton searchButton = new JButton("Search");
		searchButton.setBounds(515, 78, 99, 25);
		inventoryPanel.add(searchButton);

		searchButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				/*long b = System.currentTimeMillis();
				String s = String.valueOf(b);
				Date t = new Date(b);
				JOptionPane.showMessageDialog(frame, t, s, JOptionPane.WARNING_MESSAGE);*/
				search(searchCriteria.getText());
			}
		});

		JMenuBar mainMenuBar = new JMenuBar();
		mainMenuBar.setBounds(0, 0, 97, 20);
		inventoryPanel.add(mainMenuBar);

		JMenu fileMenu = new JMenu("File");
		mainMenuBar.add(fileMenu);

		JMenuItem loadInventoryButton = new JMenuItem("Load inventory from file");
		fileMenu.add(loadInventoryButton);

		loadInventoryButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser loadFile = new JFileChooser();
				loadFile.setFileSelectionMode(JFileChooser.FILES_ONLY);

				loadFile.setAcceptAllFileFilterUsed(false);

				int option = loadFile.showOpenDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) 
				{
					System.out.println(loadFile.getSelectedFile().toString());
					try 
					{
						inventoryList = new Inventory(loadFile.getSelectedFile().toString());
						model.refreshTable(inventoryList);
					}
					catch (IOException exception) 
					{
						exception.printStackTrace();
					}
				}
			}
		});

		JMenuItem exportInventoryButton = new JMenuItem("Export inventory from file");
		fileMenu.add(exportInventoryButton);

		exportInventoryButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser saveFile = new JFileChooser();
				int option = saveFile.showSaveDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) 
				{
					System.out.println(saveFile.getSelectedFile().toString());
					try 
					{
						inventoryList.saveInventory(saveFile.getSelectedFile().toString());
					}
					catch (IOException exception) 
					{
						exception.printStackTrace();
					}
				}
			}
		});

		/*JMenu sortMenu = new JMenu("Sort");
		mainMenuBar.add(sortMenu);

		JMenuItem sortByNameMenu = new JMenuItem("Name (Alphabetically)");
		sortMenu.add(sortByNameMenu);

		JMenuItem sortByTypeMenu = new JMenuItem("Type (Alphabetically)");
		sortMenu.add(sortByTypeMenu);

		JMenuItem sortByQuantityMenu = new JMenuItem("Quantity");
		sortMenu.add(sortByQuantityMenu);

		JMenuItem sortByPriceMenu = new JMenuItem("Price");
		sortMenu.add(sortByPriceMenu);*/

		JButton addButton = new JButton("Add Item");
		addButton.setBounds(515, 131, 98, 23);
		inventoryPanel.add(addButton);

		// Add Button ActionListener
		addButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				addItemDialogBox();
			}
		});

		JButton editButton = new JButton("Edit Item");
		editButton.setBounds(515, 165, 98, 25);
		inventoryPanel.add(editButton);

		// Edit Button ActionListener
		editButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					editItemDialogBox(model.getItemData(table.getSelectedRow()));
				}
				catch (ArrayIndexOutOfBoundsException exception)
				{
					System.out.println("No row is selected!");
				}
			}
		});
		
		JButton deleteButton = new JButton("Delete Item");
		deleteButton.setBounds(515, 199, 98, 25);
		inventoryPanel.add(deleteButton);
		
		// Delete Button ActionListener
		deleteButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					model.removeRow(table.getSelectedRow());
					inventoryList.set(model.getRowData());
					model.refreshTable(inventoryList);
				}
				catch (ArrayIndexOutOfBoundsException exception)
				{
					System.out.println("No row is selected!");
				}
			}
		});

		JPanel transactionPanel = new JPanel();
		tabbedPane.addTab("Process Transactions", null, transactionPanel, null);
	}
}