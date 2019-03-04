import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class ZwartBookFaceFrame extends JFrame {

	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnTools = new JMenu("Tools");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmAddBook = new JMenuItem("Add Book");
	private final JMenu mnSetSort = new JMenu("Set Sort");
	private final JMenuItem mntmByBookName = new JMenuItem("By Book Name");
	private final JMenuItem mntmByRetailPrice = new JMenuItem("By Retail Price");
	private final JMenuItem mntmByCategory = new JMenuItem("By Category");
	private final JTable inventoryTable = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JButton btnQuery = new JButton("Reset");
	private final JLabel lblFiltersetting = new JLabel("FilterSetting");
	private final JLabel lblSortsetting = new JLabel("");
	private final JMenu mnFilterSettings = new JMenu("Filter Settings");
	private final JMenuItem mntmByRetailPrice_1 = new JMenuItem("By Retail Price");
	private final JMenuItem mntmByCategory_1 = new JMenuItem("By Category");
	private final Item theItem = new Item();
	private final JButton btnUpdate = new JButton("Update");
	private final JLabel lblRetailpriceFilter = new JLabel("RetailPrice Filter");
	private final JMenuItem mntmHelp = new JMenuItem("Help");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZwartBookFaceFrame frame = new ZwartBookFaceFrame();
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
	public ZwartBookFaceFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("ZwartBookFaceFrame");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1201, 464);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnTools);
		mntmAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmAddBook_actionPerformed(arg0);
			}
		});
		
		mnTools.add(mntmAddBook);
		
		mnTools.add(mnSetSort);
		mntmByBookName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByBookName_actionPerformed(e);
			}
		});
		
		mnSetSort.add(mntmByBookName);
		mntmByRetailPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByRetailPrice_actionPerformed(e);
			}
		});
		
		mnSetSort.add(mntmByRetailPrice);
		mntmByCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByCategory_actionPerformed(e);
			}
		});
		
		mnSetSort.add(mntmByCategory);
		
		mnTools.add(mnFilterSettings);
		mntmByRetailPrice_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByRetailPrice_1_actionPerformed(e);
			}
		});
		
		mnFilterSettings.add(mntmByRetailPrice_1);
		mntmByCategory_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByCategory_1_actionPerformed(e);
			}
		});
		
		mnFilterSettings.add(mntmByCategory_1);
		
		menuBar.add(mnHelp);
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmHelp_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setToolTipText("The Database\r\n");
		scrollPane.setBounds(10, 11, 1165, 200);
		
		contentPane.add(scrollPane);
		inventoryTable.setFont(new Font("Courier New", Font.PLAIN, 10));
		inventoryTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"BookID", "BookName", "AuthorName", "Category", "WholesalePrice", "RetailPrice", "QOH", "MinQuant"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Short.class, String.class, String.class, Double.class, Double.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(inventoryTable);
		btnQuery.setToolTipText("Reset to default database");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnQuery_actionPerformed(arg0);
			}
		});
		btnQuery.setBounds(335, 350, 89, 23);
		
		contentPane.add(btnQuery);
		//load driver
			try{Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				
			}catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			} //catch
		lblFiltersetting.setBounds(10, 233, 818, 14);
		
		contentPane.add(lblFiltersetting);
		lblSortsetting.setBounds(10, 288, 818, 14);
		
		contentPane.add(lblSortsetting);
		runquery();
		btnUpdate.setToolTipText("Update to filter and sort options");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnUpdate_actionPerformed(arg0);
			}
		});
		btnUpdate.setBounds(759, 350, 89, 23);
		
		contentPane.add(btnUpdate);
		lblRetailpriceFilter.setBounds(10, 258, 818, 14);
		
		contentPane.add(lblRetailpriceFilter);
	}
	protected void do_mntmExit_actionPerformed(ActionEvent arg0) {
		System.exit(0);//exitbutton
	}
	protected void do_mntmAddBook_actionPerformed(ActionEvent arg0) {
		ZwartBookFaceSecondFrame frame = new ZwartBookFaceSecondFrame();
		frame.setVisible(true);//create add frame
	}

	public void runquery(){
		lblFiltersetting.setText(theItem.getFilterbycategory());
		lblRetailpriceFilter.setText(theItem.getFilterbyprice());
		theItem.setTheQuery("SELECT BookID, BookName,AuthorName, Category, WholesalePrice, RetailPrice, QOH, MinQuant FROM Inventory"
				+ " WHERE 1=1"
				+ theItem.getRetailprice()
				+ theItem.getCategory()
				+ theItem.getFilter());
		ResultSet rs = null;
		Statement stat = null;
		System.out.println(theItem.getTheQuery());
		try{
			//declare connection
			Connection conn= DriverManager.getConnection("jdbc:ucanaccess://c:/Users/Public/ZwartBookFace.accdb");
		//create the statement
			stat= conn.createStatement();
		//Execute statement
			rs = stat.executeQuery(theItem.getTheQuery());
			while(inventoryTable.getRowCount()> 0 )
				((DefaultTableModel)inventoryTable.getModel()).removeRow(0);
				int numcolumns= rs.getMetaData().getColumnCount();	
				
				while(rs.next()){
					//create an object to hold a record
					Object[] row = new Object [numcolumns];
					for(int i = 0; i < numcolumns; i++){
						row[i] = rs.getObject(i+1);
					}//for
					
					//Insert the record into the jtable
					((DefaultTableModel)inventoryTable.getModel()).insertRow(rs.getRow() - 1, row);	
					
					
				}
		}catch (SQLException ex)
		{
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		} //catch
	}
	public void reset(){
		lblSortsetting.setText("");
		theItem.setRetailprice(" AND 3=3 ");
		theItem.setCategory(" AND 2=2 ");	
		theItem.setFilter(" ORDER BY BookID ");
		theItem.setFilterbycategory("");
		theItem.setFilterbyprice("");
		theItem.setTheQuery("SELECT BookID, BookName,AuthorName, Category, WholesalePrice, RetailPrice, QOH, MinQuant FROM Inventory"
				+ " WHERE 1=1"
				+ theItem.getRetailprice()
				+ theItem.getCategory()
				+ theItem.getFilter());
		
		runquery();
		}
	protected void do_btnQuery_actionPerformed(ActionEvent arg0) {
		reset();
	}
	protected void do_mntmByBookName_actionPerformed(ActionEvent e) {
		theItem.setFilter(" ORDER BY BookName, BookID ");
		theItem.setTheQuery("SELECT BookID, BookName,AuthorName, Category, WholesalePrice, RetailPrice, QOH, MinQuant FROM Inventory"
			+ " WHERE 1=1"
			+ theItem.getRetailprice()
			+ theItem.getCategory()
			+ theItem.getFilter());
		lblSortsetting.setText("Sorted by BookID");
		runquery();
	}
	protected void do_mntmByRetailPrice_actionPerformed(ActionEvent e) {
		theItem.setFilter(" ORDER BY RetailPrice, BookID ");
		theItem.setTheQuery("SELECT BookID, BookName,AuthorName, Category, WholesalePrice, RetailPrice, QOH, MinQuant FROM Inventory"
				+ " WHERE 1=1"
				+ theItem.getRetailprice()
				+ theItem.getCategory()
				+ theItem.getFilter());
		lblSortsetting.setText("Sorted by RetailPrice");
		runquery();
	}
	protected void do_mntmByCategory_actionPerformed(ActionEvent e) {	
		theItem.setFilter(" ORDER BY Category, BookID ");
		theItem.setTheQuery("SELECT BookID, BookName,AuthorName, Category, WholesalePrice, RetailPrice, QOH, MinQuant FROM Inventory"
				+ " WHERE 1=1"
				+ theItem.getRetailprice()
				+ theItem.getCategory()
				+ theItem.getFilter());
		lblSortsetting.setText("Sorted by Category");
		runquery();
	}
	protected void do_mntmByRetailPrice_1_actionPerformed(ActionEvent e) {
		ZwartBookFacePriceFilter frame = new ZwartBookFacePriceFilter(theItem);
		frame.setVisible(true);
	}
	protected void do_mntmByCategory_1_actionPerformed(ActionEvent e) {
		ZwartBookFaceCategoryFilter frame = new ZwartBookFaceCategoryFilter(theItem);
		frame.setVisible(true);
	}
	protected void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		theItem.setTheQuery("SELECT BookID, BookName,AuthorName, Category, WholesalePrice, RetailPrice, QOH, MinQuant FROM Inventory"
				+ " WHERE 1=1"
				+ theItem.getRetailprice()
				+ theItem.getCategory()
				+ theItem.getFilter());
		runquery();
		
	}
	protected void do_mntmHelp_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "<html><b>Click Update After Clicking on filter and sorting options. </b><br> You can reset the panel by clicking reset <br>"
				+ "Use Exit to close app. Addbook will allow for a new book to be registered. Filter will filter options will make popups."
				+ "<br> Close on popus will close the window, but will not get rid of previous inputs. <br>"
				+ "Sort options need not click update<br>"
				+ "RetailPrice will close when option is set into place.<html>");
	}
	}

