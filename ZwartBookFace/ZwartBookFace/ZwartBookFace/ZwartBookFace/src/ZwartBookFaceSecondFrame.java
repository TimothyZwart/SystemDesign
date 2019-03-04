import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class ZwartBookFaceSecondFrame extends JFrame {

	private JPanel contentPane;
	
	NumberFormat numFormat= NumberFormat.getNumberInstance();
	NumberFormat curFormat= NumberFormat.getCurrencyInstance(Locale.US);
	MaskFormatter bookidMask= createFormatter ("#######");
	
	
	private final JButton btnOk = new JButton("OK");
	private final JButton btnCancel = new JButton("Close");
	private final JLabel lblBookid = new JLabel("BookID:");
	private final JLabel lblBookname = new JLabel("BookName:");
	private final JTextField booknametextField = new JTextField();
	private final JFormattedTextField bookidformattedTextField = new JFormattedTextField();
	private final JLabel lblAuthorname = new JLabel("AuthorName:");
	private final JTextField authornametextField = new JTextField();
	private final JComboBox categorycomboBox = new JComboBox();
	private final JLabel lblCategory = new JLabel("Category:");
	private final JLabel lblWholesaleprice = new JLabel("WholesalePrice:");
	private final JFormattedTextField wholesalepriceformattedTextField = new JFormattedTextField(numFormat);
	private final JLabel lblQoh = new JLabel("QOH:");
	private final JFormattedTextField qohformattedTextField = new JFormattedTextField(numFormat);
	private final JLabel lblRetailprice = new JLabel("RetailPrice:");
	private final JFormattedTextField retailpriceformattedTextField = new JFormattedTextField(numFormat);
	private final JLabel lblMinquant = new JLabel("MinQuant:");
	private final JFormattedTextField minquantformattedTextField = new JFormattedTextField(numFormat);

	
	/**
	 * Launch the application.
	 */
	public MaskFormatter createFormatter(String s) {
	     MaskFormatter formatter = null;
	     try {
	          formatter = new MaskFormatter(s);
	         } 
	     catch (java.text.ParseException exc) {
		          System.err.println("formatter is bad: " + exc.getMessage());
		          System.exit(-1);
		      }
	      return formatter;
	}//createFormatter
	/**
	 * Create the frame.
	 */
	public ZwartBookFaceSecondFrame() {
		authornametextField.setToolTipText("Enter Author Name");
		authornametextField.setBounds(290, 82, 149, 20);
		authornametextField.setColumns(10);
		booknametextField.setToolTipText("Enter Book Name");
		booknametextField.setBounds(290, 50, 149, 20);
		booknametextField.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("ZwartBookFaceAddBookFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnOk.setToolTipText("Click to submit");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnOk_actionPerformed(e);
			}
		});
		btnOk.setBounds(121, 284, 89, 23);
		
		contentPane.add(btnOk);
		btnCancel.setToolTipText("Click to close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnCancel_actionPerformed(arg0);
			}
		});
		btnCancel.setBounds(331, 284, 89, 23);
		
		bookidMask.setPlaceholderCharacter('0');
		
		contentPane.add(btnCancel);
		lblBookid.setBounds(49, 18, 161, 14);
		
		contentPane.add(lblBookid);
		lblBookname.setBounds(49, 50, 167, 14);
		
		contentPane.add(lblBookname);
		
		contentPane.add(booknametextField);
		bookidformattedTextField.setToolTipText("Enter Book Id");
		bookidformattedTextField.setBounds(290, 18, 149, 20);
		
		contentPane.add(bookidformattedTextField);
		lblAuthorname.setBounds(49, 82, 161, 14);
		
		contentPane.add(lblAuthorname);
		
		contentPane.add(authornametextField);
		categorycomboBox.setToolTipText("Choose Category of book");
		categorycomboBox.setModel(new DefaultComboBoxModel(new String[] {"Humor", "Biography", "Autobiography", "Literature", "Mystery", "GraphicNovel", "Youngadult", "Romance", "SciFi", "Other"}));
		categorycomboBox.setBounds(290, 114, 149, 20);
		
		contentPane.add(categorycomboBox);
		lblCategory.setBounds(49, 114, 161, 14);
		
		contentPane.add(lblCategory);
		lblWholesaleprice.setBounds(49, 146, 161, 14);
		
		contentPane.add(lblWholesaleprice);
		wholesalepriceformattedTextField.setToolTipText("Enter WholesalePrice");
		wholesalepriceformattedTextField.setBounds(290, 146, 149, 20);
		
		contentPane.add(wholesalepriceformattedTextField);
		lblQoh.setBounds(49, 210, 161, 14);
		
		contentPane.add(lblQoh);
		qohformattedTextField.setToolTipText("Enter Quantity Currently on hand");
		qohformattedTextField.setBounds(290, 210, 149, 20);
		
		contentPane.add(qohformattedTextField);
		lblRetailprice.setBounds(49, 178, 161, 14);
		
		contentPane.add(lblRetailprice);
		retailpriceformattedTextField.setToolTipText("Enter RetailPrice");
		retailpriceformattedTextField.setBounds(290, 178, 149, 20);
		
		contentPane.add(retailpriceformattedTextField);
		lblMinquant.setBounds(49, 246, 161, 14);
		
		contentPane.add(lblMinquant);
		minquantformattedTextField.setToolTipText("Enter minumum Quantity");
		minquantformattedTextField.setBounds(290, 246, 149, 20);
		
		contentPane.add(minquantformattedTextField);
		
		bookidMask.install(bookidformattedTextField);
		//load driver
		try{Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} //catch
	}
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		
		
		ResultSet rs = null;
		
		String insertQuery;
		Statement stmt= null;
		String dupcheck = null;
		if(bookidformattedTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,"Missing value for BookID", "Missing Value", JOptionPane.ERROR_MESSAGE, null);
		}
		if(booknametextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,"Missing value for BookName", "Missing Value", JOptionPane.ERROR_MESSAGE, null);
		}
		if(authornametextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,"Missing value for AuthorName", "Missing Value", JOptionPane.ERROR_MESSAGE, null);
		}
		if(wholesalepriceformattedTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,"Missing value for wholesaleprice", "Missing Value", JOptionPane.ERROR_MESSAGE, null);
		}
		if(qohformattedTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,"Missing value for QOH", "Missing Value", JOptionPane.ERROR_MESSAGE, null);
		}
		if(retailpriceformattedTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,"Missing value for RetailPrice", "Missing Value", JOptionPane.ERROR_MESSAGE, null);
		}
		if(minquantformattedTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,"Missing value for MinQuant", "Missing Value", JOptionPane.ERROR_MESSAGE, null);
		}
		else{
		try{
			
		Connection conn= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Public/BookFace.accdb");
		stmt = conn.createStatement();
		dupcheck = "SELECT * FROM Inventory WHERE BookID = " + bookidformattedTextField.getText();
		rs = stmt.executeQuery(dupcheck);
		if(rs.next()){
			JOptionPane.showMessageDialog(this,"Book or BookID already exists please insert New ID valuse if still incorrect, then the book already exists", "Duplicates", JOptionPane.ERROR_MESSAGE, null);
			System.out.println("No duplicates");
		}else{
		
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		insertQuery = "INSERT INTO Inventory(BookID, BookName, AuthorName, Category, WholesalePrice, RetailPrice, QOH, MinQuant) VALUES(";
		insertQuery += ""+ bookidformattedTextField.getText().trim()+",";
		insertQuery += "'"+ booknametextField.getText().trim()+"',";
		insertQuery += "'"+ authornametextField.getText().trim()+"',";
		insertQuery += "'"+ categorycomboBox.getSelectedItem().toString()+"',";
		insertQuery += ""+ wholesalepriceformattedTextField.getValue()+",";
		insertQuery += ""+ retailpriceformattedTextField.getValue()+",";
		insertQuery += ""+ qohformattedTextField.getValue()+",";
		insertQuery += ""+ minquantformattedTextField.getValue()+")";
		System.out.println(insertQuery);
		
		if(stmt.executeUpdate(insertQuery) != 0){
			System.out.println("Success");
			JOptionPane.showMessageDialog(this, "Success");
		}else{
			System.out.println("Failure");
		}
		
		}
		rs.close();
		conn.close();

		}catch (SQLException ex)
		{
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
			ex.printStackTrace();
		} //catch
	}}
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
