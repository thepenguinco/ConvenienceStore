import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

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
import java.util.Comparator;
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

	/**
	 * String array containing all the cigarette box sizes available at this store
	 */
	public static final String[] CIGARETTES_TYPES = {"Small", "Medium", "Large"};

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
		JLabel weightLabel = new JLabel("Weight (kg):");
		JTextField weight = new JTextField();
		JLabel volumeLabel = new JLabel("Volume (ml):");
		JTextField volume = new JTextField();
		JLabel sizeLabel = new JLabel("Size:");
		JComboBox size = new JComboBox(CIGARETTES_TYPES);
		Object[] message = {
				categoryLabel, category,
				nameLabel, name,
				quantityLabel, quantity,
				priceLabel, price,
				weightLabel, weight,
				volumeLabel, volume,
				sizeLabel, size				
		};
		category.addItemListener(new ItemListener() 
		{
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange() == ItemEvent.SELECTED) 
				{
					String selection = (String) category.getSelectedItem();
					// FOOD
					if (selection.equals(ITEM_TYPES[0]))
					{
						weightLabel.setVisible(true);
						weight.setVisible(true);
						volumeLabel.setVisible(false);
						volume.setVisible(false);
						sizeLabel.setVisible(false);
						size.setVisible(false);
					}
					// DRINK
					else if (selection.equals(ITEM_TYPES[1]))
					{
						weightLabel.setVisible(false);
						weight.setVisible(false);
						volumeLabel.setVisible(true);
						volume.setVisible(true);
						sizeLabel.setVisible(false);
						size.setVisible(false);
					}
					// CIGARETTES
					else if (selection.equals(ITEM_TYPES[2]))
					{
						weightLabel.setVisible(false);
						weight.setVisible(false);
						volumeLabel.setVisible(false);
						volume.setVisible(false);
						sizeLabel.setVisible(true);
						size.setVisible(true);
					}
					// LOTTERY TICKETS
					else if (selection.equals(ITEM_TYPES[3]))
					{
						weightLabel.setVisible(false);
						weight.setVisible(false);
						volumeLabel.setVisible(false);
						volume.setVisible(false);
						sizeLabel.setVisible(false);
						size.setVisible(false);
					}
				}
			}
		});
		category.setSelectedItem(ITEM_TYPES[0]);
		while (true)
		{
			UIManager.put("OptionPane.minimumSize",new Dimension(300, 300));
			int option = JOptionPane.showConfirmDialog(frame, message, "Add an item", JOptionPane.OK_CANCEL_OPTION);
			UIManager.put("OptionPane.minimumSize",new Dimension(120, 120));
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
					else if ((weight.getText().isEmpty() || Double.parseDouble(weight.getText()) <= 0) && weight.isVisible())
					{
						JOptionPane.showMessageDialog(frame, "You must enter a valid weight.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if ((volume.getText().isEmpty() || Double.parseDouble(volume.getText()) <= 0) && volume.isVisible())
					{
						JOptionPane.showMessageDialog(frame, "You must enter a valid volume.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if (size.getSelectedItem() == null && size.isVisible())
					{
						JOptionPane.showMessageDialog(frame, "You must enter a valid size.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						Item item;
						String selection = (String) category.getSelectedItem();
						// Food
						if (selection.equals(ITEM_TYPES[0]))
						{
							item = new Food(name.getText(), Integer.parseInt(quantity.getText()), Double.parseDouble(price.getText()), Double.parseDouble(weight.getText()));
						}
						// Drink
						else if (selection.equals(ITEM_TYPES[1]))
						{
							item = new Drink(name.getText(), Integer.parseInt(quantity.getText()), Double.parseDouble(price.getText()), Double.parseDouble(volume.getText()));
						}
						// Cigarettes
						else if (selection.equals(ITEM_TYPES[2]))
						{
							item = new CigaretteBox(name.getText(), Integer.parseInt(quantity.getText()), Double.parseDouble(price.getText()), (String) size.getSelectedItem());
						}
						// 
						else if (selection.equals(ITEM_TYPES[3]))
						{
							item = new LotteryTicket(name.getText(), Integer.parseInt(quantity.getText()), Double.parseDouble(price.getText()));
						}
						else
						{
							item = null;
						}
						inventoryList.addItem(item);
						model.refreshTable(inventoryList.getInventoryList());
						JOptionPane.showMessageDialog(frame, "Item Added Successfully.", "Item Added", JOptionPane.INFORMATION_MESSAGE);
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
	} // end of method addItemDialogBox()

	/*
	 * Dialog box for editing items in the inventory management system
	 */
	private void editItemDialogBox(int row) {
		JLabel categoryLabel = new JLabel("Category: ");
		JComboBox category = new JComboBox(ITEM_TYPES);
		JLabel nameLabel = new JLabel("Name:");
		JTextField name = new JTextField();
		JLabel quantityLabel = new JLabel("Quantity:");
		JTextField quantity = new JTextField();
		JLabel priceLabel = new JLabel("Price:");
		JTextField price = new JTextField();
		JLabel weightLabel = new JLabel("Weight (kg):");
		JTextField weight = new JTextField();
		JLabel volumeLabel = new JLabel("Volume (ml):");
		JTextField volume = new JTextField();
		JLabel sizeLabel = new JLabel("Size:");
		JComboBox size = new JComboBox(CIGARETTES_TYPES);
		Object[] message = {
				categoryLabel, category,
				nameLabel, name,
				quantityLabel, quantity,
				priceLabel, price,
				weightLabel, weight,
				volumeLabel, volume,
				sizeLabel, size				
		};
		Item item = model.getItemData(row);
		int typeId = item.getID();
		name.setText(item.getItemName());
		quantity.setText(Integer.toString(item.getQuantity()));
		price.setText(Double.toString(item.getPrice()));
		category.setSelectedItem(item.getType());
		if (typeId == Inventory.FOOD_ID)
		{
			weightLabel.setVisible(true);
			weight.setVisible(true);
			weight.setText(Double.toString(((Food) item).getWeight()));
			volumeLabel.setVisible(false);
			volume.setVisible(false);
			sizeLabel.setVisible(false);
			size.setVisible(false);
		}
		// DRINK
		else if (typeId == Inventory.DRINK_ID)
		{
			weightLabel.setVisible(false);
			weight.setVisible(false);
			volumeLabel.setVisible(true);
			volume.setVisible(true);
			volume.setText(Double.toString(((Drink) item).getVolume()));
			sizeLabel.setVisible(false);
			size.setVisible(false);
		}
		// CIGARETTES
		else if (typeId == Inventory.CIGARETTE_BOX_ID)
		{
			weightLabel.setVisible(false);
			weight.setVisible(false);
			volumeLabel.setVisible(false);
			volume.setVisible(false);
			sizeLabel.setVisible(true);
			size.setVisible(true);
			size.setSelectedItem(((CigaretteBox) item).getSize());
		}
		// LOTTERY TICKETS
		else if (typeId == Inventory.LOTTERY_TICKET_ID)
		{
			weightLabel.setVisible(false);
			weight.setVisible(false);
			volumeLabel.setVisible(false);
			volume.setVisible(false);
			sizeLabel.setVisible(false);
			size.setVisible(false);
		}

		category.addItemListener(new ItemListener() 
		{
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				if(e.getStateChange() == ItemEvent.SELECTED) 
				{
					String selection = (String) category.getSelectedItem();
					// FOOD
					if (selection.equals(ITEM_TYPES[0]))
					{
						weightLabel.setVisible(true);
						weight.setVisible(true);
						volumeLabel.setVisible(false);
						volume.setVisible(false);
						sizeLabel.setVisible(false);
						size.setVisible(false);
					}
					// DRINK
					else if (selection.equals(ITEM_TYPES[1]))
					{
						weightLabel.setVisible(false);
						weight.setVisible(false);
						volumeLabel.setVisible(true);
						volume.setVisible(true);
						sizeLabel.setVisible(false);
						size.setVisible(false);
					}
					// CIGARETTES
					else if (selection.equals(ITEM_TYPES[2]))
					{
						weightLabel.setVisible(false);
						weight.setVisible(false);
						volumeLabel.setVisible(false);
						volume.setVisible(false);
						sizeLabel.setVisible(true);
						size.setVisible(true);
					}
					// LOTTERY TICKETS
					else if (selection.equals(ITEM_TYPES[3]))
					{
						weightLabel.setVisible(false);
						weight.setVisible(false);
						volumeLabel.setVisible(false);
						volume.setVisible(false);
						sizeLabel.setVisible(false);
						size.setVisible(false);
					}
				}
			}
		});
		while (true)
		{
			UIManager.put("OptionPane.minimumSize",new Dimension(300, 300));
			int option = JOptionPane.showConfirmDialog(frame, message, "Edit an item", JOptionPane.OK_CANCEL_OPTION);
			UIManager.put("OptionPane.minimumSize",new Dimension(120, 120));
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
					else if ((weight.getText().isEmpty() || Double.parseDouble(weight.getText()) <= 0) && weight.isVisible())
					{
						JOptionPane.showMessageDialog(frame, "You must enter a valid weight.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if ((volume.getText().isEmpty() || Double.parseDouble(volume.getText()) <= 0) && volume.isVisible())
					{
						JOptionPane.showMessageDialog(frame, "You must enter a valid volume.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if (size.getSelectedItem() == null && size.isVisible())
					{
						JOptionPane.showMessageDialog(frame, "You must enter a valid size.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						String selection = (String) category.getSelectedItem();
						// Food
						if (selection.equals(ITEM_TYPES[0]))
						{
							item = new Food(name.getText(), Integer.parseInt(quantity.getText()), Double.parseDouble(price.getText()), Double.parseDouble(weight.getText()));
						}
						// Drink
						else if (selection.equals(ITEM_TYPES[1]))
						{
							item = new Drink(name.getText(), Integer.parseInt(quantity.getText()), Double.parseDouble(price.getText()), Double.parseDouble(volume.getText()));
						}
						// Cigarettes
						else if (selection.equals(ITEM_TYPES[2]))
						{
							item = new CigaretteBox(name.getText(), Integer.parseInt(quantity.getText()), Double.parseDouble(price.getText()), (String) size.getSelectedItem());
						}
						// Lottery Tickets
						else if (selection.equals(ITEM_TYPES[3]))
						{
							item = new LotteryTicket(name.getText(), Integer.parseInt(quantity.getText()), Double.parseDouble(price.getText()));
						}
						else
						{
							item = null;
						}
						inventoryList.addItem(item);
						model.setRow(row, item);
						inventoryList.set(model.getRowData());
						model.refreshTable(inventoryList.getInventoryList());
						JOptionPane.showMessageDialog(frame, "Item Edited Successfully.", "Item Edited", JOptionPane.INFORMATION_MESSAGE);
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
	} // end of method editItemDialogBox

	/*
	 * Item search method used by the GUI
	 */
	private void search(String text)
	{
		if (text.isEmpty())
		{
			model.refreshTable(inventoryList.getInventoryList());	
		}
		else
		{
			ArrayList<Item>searchList = new ArrayList<Item>();
			for (Item item : inventoryList.getInventoryList())
			{
				if (item.getItemName().toLowerCase().contains(text.toLowerCase()) || item.getType().toLowerCase().contains(text.toLowerCase())
						|| Integer.toString(item.getQuantity()).contains(text) || Double.toString(item.getPrice()).contains(text))
				{
					searchList.add(item);
				}
			}
			model.refreshTable(searchList);
		}
	}

	Comparator alphaComparator = new Comparator<String>()
	{
		@Override
		public int compare(String string1, String string2)
		{
			return string1.compareTo(string2);
		}        
	};

	Comparator doubleComparator = new Comparator<Double>()
	{
		@Override
		public int compare(Double number1, Double number2) {
			if (number1 < number2) return -1;
			if (number2 > number1) return 1;
			return 0;
		}        
	};

	Comparator integerComparator = new Comparator<Integer>()
	{
		@Override
		public int compare(Integer number1, Integer number2) {
			if (number1 < number2) return -1;
			if (number2 > number1) return 1;
			return 0;
		}        
	};

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
		sorter.setSortable(4, false);
		sorter.setComparator(0, alphaComparator);
		sorter.setComparator(1, alphaComparator);
		sorter.setComparator(2, integerComparator);
		sorter.setComparator(3, doubleComparator);
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
						model.refreshTable(inventoryList.getInventoryList());
						JOptionPane.showMessageDialog(frame, "Inventory Succesfully Loaded From File Database.", "File IO", JOptionPane.INFORMATION_MESSAGE);
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
						JOptionPane.showMessageDialog(frame, "Inventory Succesfully Exported To File Database.", "File IO", JOptionPane.INFORMATION_MESSAGE);
					}
					catch (IOException exception) 
					{
						exception.printStackTrace();
					}
				}
			}
		});
		
		JMenuItem aboutButton = new JMenuItem("About");
		fileMenu.add(aboutButton);
		
		aboutButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(frame, "Eric's Convenience Store Program: Beta Version.", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});

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
					editItemDialogBox(table.getSelectedRow());
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
					model.refreshTable(inventoryList.getInventoryList());
					JOptionPane.showMessageDialog(frame, "Item Deleted Successfully.", "Item Deleted", JOptionPane.INFORMATION_MESSAGE);
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