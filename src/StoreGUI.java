import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreGUI frame = new StoreGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StoreGUI() {
		setTitle("Convenience Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 624, 441);
		contentPane.add(tabbedPane);
		
		JPanel homePanel = new JPanel();
		tabbedPane.addTab("Home", null, homePanel, null);
		homePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(66, 51, 68, 24);
		homePanel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Load Inventory From File");
		btnNewButton.setBounds(214, 249, 171, 23);
		homePanel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(66, 86, 46, 14);
		homePanel.add(lblNewLabel_1);
		
		JPanel inventoryPanel = new JPanel();
		tabbedPane.addTab("Inventory Management", null, inventoryPanel, null);
		inventoryPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 381, 413);
		inventoryPanel.add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(395, 53, 86, 20);
		inventoryPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(395, 84, 86, 20);
		inventoryPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(395, 146, 86, 20);
		inventoryPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(395, 115, 86, 20);
		inventoryPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSearchCriteria = new JLabel("Search Criteria");
		lblSearchCriteria.setBounds(402, 28, 79, 14);
		inventoryPanel.add(lblSearchCriteria);
		
		JButton btnNewButton_1 = new JButton("Add Item");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(456, 257, 89, 23);
		inventoryPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(520, 96, 89, 23);
		inventoryPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sort Alphabetically");
		btnNewButton_3.setBounds(417, 343, 153, 23);
		inventoryPanel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sort by Price");
		btnNewButton_4.setBounds(417, 309, 153, 23);
		inventoryPanel.add(btnNewButton_4);
		
		JPanel transactionPanel = new JPanel();
		tabbedPane.addTab("Process Transactions", null, transactionPanel, null);
	}
}
