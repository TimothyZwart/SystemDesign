import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class ZwartBookFacePriceFilter extends JFrame {

	private JPanel contentPane;
	NumberFormat numFormat= NumberFormat.getNumberInstance();
	
	
	private final JLabel lblLessThan = new JLabel("RetailPrice less than");
	private final JLabel lblGreaterThan = new JLabel("RetailPrice greater than");
	private final JFormattedTextField lessthanformattedTextField = new JFormattedTextField(numFormat);
	private final JFormattedTextField greaterthanformattedTextField = new JFormattedTextField(numFormat);
	private final JLabel lblAnd = new JLabel("Between");
	private final JButton btnOk = new JButton("OK");
	private final JButton btnCancel = new JButton("Close");
	private final Item thing;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ZwartBookFacePriceFilter(Item it) {
		thing = it;
		jbInit();
	}
	private void jbInit() {
		setTitle("ZwartBookFacePriceFilter");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 580, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblLessThan.setBounds(359, 94, 195, 20);
		
		contentPane.add(lblLessThan);
		lblGreaterThan.setBounds(58, 94, 195, 20);
		
		contentPane.add(lblGreaterThan);
		lessthanformattedTextField.setToolTipText("Enter Higher Price");
		lessthanformattedTextField.setBounds(311, 151, 195, 20);
		
		contentPane.add(lessthanformattedTextField);
		greaterthanformattedTextField.setToolTipText("Enter Lower Price\r\n");
		greaterthanformattedTextField.setBounds(58, 151, 195, 20);
		
		contentPane.add(greaterthanformattedTextField);
		lblAnd.setBounds(257, 94, 195, 20);
		
		contentPane.add(lblAnd);
		btnOk.setToolTipText("Click to Submit");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnOk_actionPerformed(arg0);
			}
		});
		btnOk.setBounds(128, 208, 89, 23);
		
		contentPane.add(btnOk);
		btnCancel.setToolTipText("Click to close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_actionPerformed(e);
			}
		});
		btnCancel.setBounds(345, 208, 89, 23);
		
		contentPane.add(btnCancel);
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	protected void do_btnOk_actionPerformed(ActionEvent arg0) {

		String x= "something";
		String z = "something";
		String y ="something";
		if(lessthanformattedTextField.getText().isEmpty()||greaterthanformattedTextField.getText().isEmpty()){
			if(!lessthanformattedTextField.getText().isEmpty()){
				double lessthan= Double.parseDouble(lessthanformattedTextField.getText().replaceAll(",",""));
				x= " AND RetailPrice < " + lessthan+ " ";
				thing.setFilterbyprice("RetailPrice < " +lessthan);
				thing.setRetailprice(x);
				this.dispose();
			}
			if(!greaterthanformattedTextField.getText().isEmpty()){
				double greaterthan= Double.parseDouble(greaterthanformattedTextField.getText().replaceAll(",",""));
				x= " AND RetailPrice > " + greaterthan+ " ";
				thing.setFilterbyprice("RetailPrice > " +greaterthan);
				thing.setRetailprice(x);
				this.dispose();
			}
			if(lessthanformattedTextField.getText().isEmpty()&&greaterthanformattedTextField.getText().isEmpty()){
				JOptionPane.showMessageDialog(this,"Enter a range of values to filter or click cancel to close return to mainframe");
			}
		
		}
		else{
			
			double greaterthan= Double.parseDouble(greaterthanformattedTextField.getText().replaceAll(",",""));
			double lessthan= Double.parseDouble(lessthanformattedTextField.getText().replaceAll(",",""));
			x= " AND RetailPrice < " + lessthan+ " ";
			z =" AND RetailPrice > " + greaterthan+ " ";
			y = x+z;
			if(lessthan < greaterthan){
				JOptionPane.showMessageDialog(this,"Value range does not work");
			}else{
			thing.setRetailprice(y);
			thing.setTheQuery("SELECT BookID, BookName,AuthorName, Category, WholesalePrice, RetailPrice, QOH, MinQuant FROM Inventory"
					+ " WHERE 1=1"
					+ thing.getCategory()
					+ thing.getFilter());
			thing.setFilterbyprice(greaterthan+" Retail Price is between "+lessthan);
			this.dispose();
			}}
		System.out.println(thing.getRetailprice());

		System.out.println(thing.getTheQuery());
		
	}
}
