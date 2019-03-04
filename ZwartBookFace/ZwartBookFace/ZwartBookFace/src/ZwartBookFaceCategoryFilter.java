import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class ZwartBookFaceCategoryFilter extends JFrame {

	private JPanel contentPane;
	private final JButton btnOk = new JButton("OK");
	private final JButton btnCancel = new JButton("Close");
	private final Item thing;
	private final JList listCategories = new JList();
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ZwartBookFaceCategoryFilter(Item it) {
		thing = it;
		jbInit();
	}
	private void jbInit() {
		setTitle("ZwartBookFaceCategoryFilter");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		btnOk.setBounds(74, 196, 89, 23);
		
		contentPane.add(btnOk);
		btnCancel.setToolTipText("click to close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_actionPerformed(e);
			}
		});
		btnCancel.setBounds(228, 196, 89, 23);
		
		contentPane.add(btnCancel);
		scrollPane.setBounds(133, 63, 152, 97);
		
		contentPane.add(scrollPane);
		listCategories.setToolTipText("Can click multiple by using ctrl+ mouseclick\r\n");
		scrollPane.setViewportView(listCategories);
		listCategories.setModel(new AbstractListModel() {
			String[] values = new String[] {"Humor", "Biography", "AutoBiography", "Literature", "Mystery", "GraphicNovel", "YoungAdult", "Romance", "SciFi", "Other"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		String x = " AND ( 1=2 ";
		String z = "Filtered by ";
		int categories[]= listCategories.getSelectedIndices();
		Object Selectedcategories[] = listCategories.getSelectedValues();
		for (int i = 0, h = categories.length; i< h; i++){
			x = x + " OR Category = '" + Selectedcategories[i] +"'" ;
			z= z + Selectedcategories[i] + ", ";
			
			if ( i == h - 1){
				x=x+")";
				thing.setCategory(x);
				System.out.println(thing.getCategory());
				thing.setTheQuery("SELECT BookID, BookName,AuthorName, Category, WholesalePrice, RetailPrice, QOH, MinQuant FROM Inventory"
				+ " WHERE 1=1"
				+ thing.getCategory()
				+ thing.getFilter());
				thing.setFilterbycategory(z);
				System.out.println(thing.getTheQuery());
			}
			
		}
		
	}
}
