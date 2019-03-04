import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.time.Month;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SpinnerListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Font;

public class ZwartSACAPframe extends JFrame {

	private JPanel contentPane;
	NumberFormat curFormat= NumberFormat.getCurrencyInstance();
	NumberFormat numFormat= NumberFormat.getNumberInstance(); 
	MaskFormatter postalcodeMask= createFormatter ("#####");
	MaskFormatter telcelMask= createFormatter ("(###)###-####");
	
	private final JTabbedPane maintabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel applicantinfopanel = new JPanel();
	private final JPanel childinfopanel = new JPanel();
	private final JPanel financialinfopanel = new JPanel();
	private final JLabel lblChildren017 = new JLabel("# of Children 0-17");
	private final JLabel lblOfChildren18 = new JLabel("# of Children 18+");
	private final JLabel lblOfAdults = new JLabel("*# of Adults");
	private final JLabel lblEmail = new JLabel("*Email:");
	private final JLabel lblTelCel = new JLabel("*Tel/Cel:");
	private final JLabel lblResidence = new JLabel("Residence:");
	private final JLabel lblPostalCode = new JLabel("*Postal Code:");
	private final JLabel lblFirstName = new JLabel("*First Name:");
	private final JLabel lblLastName = new JLabel("*Last Name:");
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenuItem mntmStartNewForm = new JMenuItem("Start New Form");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenu mnHelp = new JMenu("Help");
	private final JTextField txtLastName = new JTextField();
	private final JTextField txtFirstName = new JTextField();
	private final JLabel lblIncome = new JLabel("Income");
	private final JLabel lblEmploymenttotal = new JLabel("Employment (total):");
	private final JLabel lblChildSpousalSupport = new JLabel("Child/ Spousal Support:");
	private final JLabel lblOntarioWorks = new JLabel("Ontario Works:");
	private final JLabel lblEiOrDisability = new JLabel("E.I. or Disability:");
	private final JLabel lblPensionIncome = new JLabel("Pension Income:");
	private final JLabel lblChildTaxCredits = new JLabel("Child Tax Credits:");
	private final JLabel lblExpenses = new JLabel("Expenses");
	private final JLabel lblRentOrMortgage = new JLabel("Rent or Mortgage:");
	private final JLabel lblGashydro = new JLabel("Gas+ Hydro:");
	private final JLabel lblPhoneTV = new JLabel("Phone + TV:");
	private final JLabel lblChildCare = new JLabel("Child Care:");
	private final JLabel lblTransitGas = new JLabel("Transit/ Gas:");
	private final JLabel lblLoansinsurance = new JLabel("Loans + Insurance:");
	private final JLabel lblTotalIncome = new JLabel("Total Income:");
	private final JLabel lblTotalExpenses = new JLabel("Total Expenses:");
	private final JLabel lblTotalNetIncome = new JLabel("Total Net Income:");
	private final JFormattedTextField postalcodeFTF = new JFormattedTextField();
	private final JFormattedTextField telcelFTF = new JFormattedTextField();
	private final JTextField emailtextField = new JTextField();
	private final JMenuItem mntmApplicationInfo = new JMenuItem("Application Info");
	private final JMenuItem mntmChildInfo = new JMenuItem("Child Info");
	private final JMenuItem mntmFinancialInfo = new JMenuItem("Financial Info");
	private final JSpinner adultspinner = new JSpinner();
	private final JSpinner children18spinner = new JSpinner();
	private final JSpinner children017spinner = new JSpinner();
	private final JTabbedPane childrentabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel child1panel = new JPanel();
	private final JLabel lblChild1FirstName = new JLabel("*Child Frist Name:");
	private final JLabel lblMaleFemale1 = new JLabel("*Male/ Female:");
	private final JLabel lblBirthdate1 = new JLabel("Birthdate:");
	private final JLabel lblAge1 = new JLabel("Age:");
	private final JRadioButton rdbtnRent = new JRadioButton("Rent");
	private final JRadioButton rdbtnMortgage = new JRadioButton("Mortgage");
	private final JFormattedTextField employmentFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField supportFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField ontarioworksFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField disabilityFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField pensionFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField childtaxcreditsFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField totalincomeFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField totalnetincomeFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField gashydroFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField phonetvFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField rentmortgageFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField childcareFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField transitgasFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField loansinsuranceFTF = new JFormattedTextField(curFormat);
	private final JFormattedTextField totalexpensesFTF = new JFormattedTextField(curFormat);
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JTextField child1firstnametextField = new JTextField();
	private final JRadioButton rdbtnMale1 = new JRadioButton("male");
	private final JRadioButton rdbtnFemale1 = new JRadioButton("female");
	private final JComboBox monthcomboBox1 = new JComboBox();
	private final JComboBox yearcomboBox1 = new JComboBox();
	private final JComboBox daycomboBox1 = new JComboBox();
	
	
	private double employment = 0;
	private double support = 0;
	private double ontarioworks = 0;
	private double disability = 0;
	private double pension = 0;
	private double childtaxcredits = 0;
	private double totalincome = 0;
	private double totalnetincome = 0;
	private double gashydro = 0;
	private double phonetv = 0;
	private double rentmortgage= 0;
	private double childcare = 0;
	private double transitgas = 0;
	private double loansinsurance = 0;
	private double totalexpenses =0;
	private final JLabel lblClothingSize1 = new JLabel("Clothing Size:");
	private final JComboBox clothingsizecomboBox1 = new JComboBox();
	private final JSpinner shoespinner1 = new JSpinner();
	private final JLabel lblShoeSize1 = new JLabel("Shoe Size:");
	private final JLabel lblCoatSize1 = new JLabel("Coat Size:");
	private final JComboBox coatsizecomboBox1 = new JComboBox();
	private final JLabel lblGameSystem1 = new JLabel("Game System:");
	private final JLabel lblChildsInterests1 = new JLabel("Child's Interests:");
	private final JList childsinterestjlist1 = new JList();
	private final JScrollPane scrollPane = new JScrollPane();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final JButton btnGoToChildTab = new JButton("Go to Child Tab");
	private final JComboBox residencecomboBox = new JComboBox();
	private final JButton btnGoToFinancialTab = new JButton("Go to Financial Tab");
	private final JButton btnSubmit = new JButton("Submit");
	private final JSpinner agespinner1 = new JSpinner();
	private final JPanel child2panel = new JPanel();
	private final JPanel child3panel = new JPanel();
	private final JPanel child4panel = new JPanel();
	private final JPanel child5panel = new JPanel();
	private final JPanel child6panel = new JPanel();
	private final JLabel lblChild2FirstName = new JLabel("*Child Frist Name:");
	private final JTextField child2firstnametextField = new JTextField();
	private final JLabel lblMaleFemale2 = new JLabel("*Male/ Female:");
	private final JRadioButton rdbtnMale2 = new JRadioButton("male");
	private final JRadioButton rdbtnFemale2 = new JRadioButton("female");
	private final JLabel lblBirthdate2 = new JLabel("Birthdate:");
	private final JComboBox monthcomboBox2 = new JComboBox();
	private final JComboBox daycomboBox2 = new JComboBox();
	private final JComboBox yearcomboBox2 = new JComboBox();
	private final JLabel lblAge2 = new JLabel("Age:");
	private final JSpinner agespinner2 = new JSpinner();
	private final JLabel lblClothingSize2 = new JLabel("Clothing Size:");
	private final JComboBox clothingsizecomboBox2 = new JComboBox();
	private final JLabel lblShoeSize2 = new JLabel("Shoe Size:");
	private final JSpinner shoespinner2 = new JSpinner();
	private final JLabel lblCoatSize2 = new JLabel("Coat Size:");
	private final JComboBox coatsizecomboBox2 = new JComboBox();
	private final JLabel lblChild3FirstName = new JLabel("*Child Frist Name:");
	private final JTextField child3firstnametextField = new JTextField();
	private final JLabel lblMaleFemale3 = new JLabel("*Male/ Female:");
	private final JRadioButton rdbtnMale3 = new JRadioButton("male");
	private final JRadioButton rdbtnFemale3 = new JRadioButton("female");
	private final JLabel lblBirthdate3 = new JLabel("Birthdate:");
	private final JComboBox monthcomboBox3 = new JComboBox();
	private final JComboBox daycomboBox3 = new JComboBox();
	private final JComboBox yearcomboBox3 = new JComboBox();
	private final JLabel lblAge3 = new JLabel("Age:");
	private final JSpinner agespinner3 = new JSpinner();
	private final JLabel lblClothingSize3 = new JLabel("Clothing Size:");
	private final JComboBox clothingsizecomboBox3 = new JComboBox();
	private final JLabel lblShoeSize3 = new JLabel("Shoe Size:");
	private final JSpinner shoespinner3 = new JSpinner();
	private final JLabel lblCoatSize3 = new JLabel("Coat Size:");
	private final JComboBox coatsizecomboBox3 = new JComboBox();
	private final JLabel lblChild4FirstName = new JLabel("*Child Frist Name:");
	private final JTextField child4firstnametextField = new JTextField();
	private final JLabel lblMaleFemale4 = new JLabel("*Male/ Female:");
	private final JRadioButton rdbtnMale4 = new JRadioButton("male");
	private final JRadioButton rdbtnFemale4 = new JRadioButton("female");
	private final JLabel lblBirthdate4 = new JLabel("Birthdate:");
	private final JComboBox monthcomboBox4 = new JComboBox();
	private final JComboBox daycomboBox4 = new JComboBox();
	private final JComboBox yearcomboBox4 = new JComboBox();
	private final JLabel lblAge4 = new JLabel("Age:");
	private final JSpinner agespinner4 = new JSpinner();
	private final JLabel lblClothingSize4 = new JLabel("Clothing Size:");
	private final JComboBox clothingsizecomboBox4 = new JComboBox();
	private final JLabel lblShoeSize4 = new JLabel("Shoe Size:");
	private final JSpinner shoespinner4 = new JSpinner();
	private final JLabel lblCoatSize4 = new JLabel("Coat Size:");
	private final JComboBox coatsizecomboBox4 = new JComboBox();
	private final JLabel lblChild5FirstName = new JLabel("*Child Frist Name:");
	private final JTextField child5firstnametextField = new JTextField();
	private final JLabel lblMaleFemale5 = new JLabel("*Male/ Female:");
	private final JRadioButton rdbtnMale5 = new JRadioButton("male");
	private final JRadioButton rdbtnFemale5 = new JRadioButton("female");
	private final JLabel lblBirthdate5 = new JLabel("Birthdate:");
	private final JComboBox monthcomboBox5 = new JComboBox();
	private final JComboBox daycomboBox5 = new JComboBox();
	private final JComboBox yearcomboBox5 = new JComboBox();
	private final JLabel lblAge5 = new JLabel("Age:");
	private final JSpinner agespinner5 = new JSpinner();
	private final JLabel lblClothingSize5 = new JLabel("Clothing Size:");
	private final JComboBox clothingsizecomboBox5 = new JComboBox();
	private final JLabel lblShoeSize5 = new JLabel("Shoe Size:");
	private final JSpinner shoespinner5 = new JSpinner();
	private final JLabel lblCoatSize5 = new JLabel("Coat Size:");
	private final JComboBox coatsizecomboBox5 = new JComboBox();
	private final JLabel lblChild6FirstName = new JLabel("*Child Frist Name:");
	private final JTextField child6firstnametextField = new JTextField();
	private final JLabel lblMaleFemale6 = new JLabel("*Male/ Female:");
	private final JRadioButton rdbtnMale6 = new JRadioButton("male");
	private final JRadioButton rdbtnFemale6 = new JRadioButton("female");
	private final JLabel lblBirthdate6 = new JLabel("Birthdate:");
	private final JComboBox monthcomboBox6 = new JComboBox();
	private final JComboBox daycomboBox6 = new JComboBox();
	private final JComboBox yearcomboBox6 = new JComboBox();
	private final JLabel lblAge6 = new JLabel("Age:");
	private final JSpinner agespinner6 = new JSpinner();
	private final JLabel lblClothingSize6 = new JLabel("Clothing Size:");
	private final JComboBox clothingsizecomboBox6 = new JComboBox();
	private final JLabel lblShoeSize6 = new JLabel("Shoe Size:");
	private final JSpinner shoespinner6 = new JSpinner();
	private final JLabel lblCoatSize6 = new JLabel("Coat Size:");
	private final JComboBox coatsizecomboBox6 = new JComboBox();
	private final JLabel lblGameSystem2 = new JLabel("Game System:");
	private final JList gamesystemlist2 = new JList();
	private final JLabel lblChildsInterests2 = new JLabel("Child's Interests:");
	private final JList childsinterestjlist2 = new JList();
	private final JLabel lblGameSystem3 = new JLabel("Game System:");
	private final JList gamesystemlist3 = new JList();
	private final JLabel lblChildsInterests3 = new JLabel("Child's Interests:");
	private final JList childsinterestjlist3 = new JList();
	private final JLabel lblGameSystem4 = new JLabel("Game System:");
	private final JList gamesystemlist4 = new JList();
	private final JLabel lblChildsInterests4 = new JLabel("Child's Interests:");
	private final JList childsinterestjlist4 = new JList();
	private final JLabel lblGameSystem5 = new JLabel("Game System:");
	private final JList gamesystemlist5 = new JList();
	private final JLabel lblChildsInterests5 = new JLabel("Child's Interests:");
	private final JList childsinterestjlist5 = new JList();
	private final JLabel lblGameSystem6 = new JLabel("Game System:");
	private final JList gamesystemlist6 = new JList();
	private final JLabel lblChildsInterests6 = new JLabel("Child's Interests:");
	private final JList childsinterestjlist6 = new JList();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JScrollPane scrollPane_3 = new JScrollPane();
	private final JScrollPane scrollPane_4 = new JScrollPane();
	private final JScrollPane scrollPane_5 = new JScrollPane();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	private final JButton btnGoToFinancial2 = new JButton("Go to Financial Tab");
	private final JButton btnGoToFinancial3 = new JButton("Go to Financial Tab");
	private final JButton btnGoToFinancial4 = new JButton("Go to Financial Tab");
	private final JButton btnGoToFinancial5 = new JButton("Go to Financial Tab");
	private final JButton btnGoToFinancial6 = new JButton("Go to Financial Tab");
	private final JScrollPane scrollPane_7 = new JScrollPane();
	private final JScrollPane scrollPane_8 = new JScrollPane();
	private final JScrollPane scrollPane_9 = new JScrollPane();
	private final JScrollPane scrollPane_10 = new JScrollPane();
	private final JScrollPane scrollPane_11 = new JScrollPane();
	private final JList gamesystemlist1 = new JList();
	private final JScrollPane scrollPane_6 = new JScrollPane();
	private final JLabel lblAddress = new JLabel("*Address:");
	private final JTextField addresstextField = new JTextField();
	private final JLabel lblIncicatesRequired = new JLabel("(*) Incicates Required Fields");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZwartSACAPframe frame = new ZwartSACAPframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//place this code after main()

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
	public ZwartSACAPframe() {
		child1firstnametextField.setToolTipText("Enter Childs First Name");
		child1firstnametextField.setBounds(155, 22, 127, 20);
		child1firstnametextField.setColumns(10);
		emailtextField.setToolTipText("Enter Email");
		emailtextField.setBounds(131, 268, 146, 20);
		emailtextField.setColumns(10);
		txtFirstName.setToolTipText("Enter First Name");
		txtFirstName.setBounds(131, 88, 142, 20);
		txtFirstName.setColumns(10);
		txtLastName.setToolTipText("Enter Last Name");
		txtLastName.setBounds(131, 52, 142, 20);
		txtLastName.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("ZwartSACAPframe");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 784, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		maintabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_tabbedPane_stateChanged(e);
			}
		});
		maintabbedPane.setBounds(0, 23, 768, 337);
		
		contentPane.add(maintabbedPane);
		postalcodeMask.setPlaceholderCharacter('0');
		telcelMask.setPlaceholderCharacter('0');
		
		maintabbedPane.addTab("Applicant Information", null, applicantinfopanel, null);
		maintabbedPane.setEnabledAt(0, true);
		applicantinfopanel.setLayout(null);
		lblChildren017.setBounds(352, 124, 104, 20);
		
		applicantinfopanel.add(lblChildren017);
		lblOfChildren18.setBounds(352, 88, 104, 20);
		
		applicantinfopanel.add(lblOfChildren18);
		lblOfAdults.setBounds(352, 52, 75, 20);
		
		applicantinfopanel.add(lblOfAdults);
		lblEmail.setBounds(10, 268, 75, 20);
		
		applicantinfopanel.add(lblEmail);
		lblTelCel.setBounds(10, 232, 75, 20);
		
		applicantinfopanel.add(lblTelCel);
		lblResidence.setBounds(10, 196, 75, 20);
		
		applicantinfopanel.add(lblResidence);
		lblPostalCode.setBounds(10, 160, 111, 20);
		
		applicantinfopanel.add(lblPostalCode);
		lblFirstName.setBounds(10, 88, 75, 20);
		
		applicantinfopanel.add(lblFirstName);
		lblLastName.setBounds(10, 52, 75, 20);
		
		applicantinfopanel.add(lblLastName);
		
		applicantinfopanel.add(txtLastName);
		
		applicantinfopanel.add(txtFirstName);
		postalcodeFTF.setToolTipText("Enter Postal Code");
		postalcodeFTF.setBounds(131, 160, 142, 20);
		
		applicantinfopanel.add(postalcodeFTF);
		telcelFTF.setToolTipText("Enter Phone Number");
		telcelFTF.setBounds(131, 232, 144, 20);
		postalcodeMask.install(postalcodeFTF);
		telcelMask.install(telcelFTF);
		applicantinfopanel.add(telcelFTF);
		
		applicantinfopanel.add(emailtextField);
		adultspinner.setToolTipText("Enter Amount of Adults in House Hold");
		adultspinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		adultspinner.setBounds(504, 52, 67, 20);
		
		applicantinfopanel.add(adultspinner);
		children18spinner.setToolTipText("Enter Children 18 and older");
		children18spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		children18spinner.setBounds(504, 88, 68, 20);
		
		applicantinfopanel.add(children18spinner);
		children017spinner.setToolTipText("Enter Children 17 and younger");
		children017spinner.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		children017spinner.setBounds(504, 124, 65, 20);
		
		applicantinfopanel.add(children017spinner);
		btnGoToChildTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnGoToNext_actionPerformed(arg0);
			}
		});
		btnGoToChildTab.setBounds(405, 198, 160, 20);
		
		applicantinfopanel.add(btnGoToChildTab);
		residencecomboBox.setToolTipText("<html>\r\nSelect From list.<br>\r\nIf not present type it in.\r\n</html> ");
		residencecomboBox.setEditable(true);
		residencecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Newmarket", "Aurora", "Markham", "Queensville", "Sharon", "Stouffville", "Mount Albert", "Richmond Hill", "Holand Landing", "Bradford", "Vaughan", "East Gwillimbury", "Georgina/Keswick"}));
		residencecomboBox.setBounds(131, 196, 142, 20);
		
		applicantinfopanel.add(residencecomboBox);
		applicantinfopanel.setFocusCycleRoot(true);
		lblAddress.setToolTipText("Enter Address");
		lblAddress.setBounds(10, 124, 75, 20);
		
		applicantinfopanel.add(lblAddress);
		addresstextField.setToolTipText("Enter Address");
		addresstextField.setColumns(10);
		addresstextField.setBounds(131, 124, 142, 20);
		
		applicantinfopanel.add(addresstextField);
		lblIncicatesRequired.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIncicatesRequired.setBounds(10, 16, 217, 20);
		
		applicantinfopanel.add(lblIncicatesRequired);
		applicantinfopanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtLastName, txtFirstName, addresstextField, postalcodeFTF, residencecomboBox, telcelFTF, emailtextField, adultspinner, children18spinner, children017spinner, btnGoToChildTab}));
		
		maintabbedPane.addTab("Child Information", null, childinfopanel, null);
		maintabbedPane.setEnabledAt(1, false);
		childinfopanel.setLayout(null);
		childrentabbedPane.setBounds(0, 0, 763, 309);
		
		childinfopanel.add(childrentabbedPane);
		
		childrentabbedPane.addTab("Child 1", null, child1panel, null);
		child1panel.setLayout(null);
		lblChild1FirstName.setBounds(32, 22, 102, 14);
		
		child1panel.add(lblChild1FirstName);
		lblMaleFemale1.setBounds(32, 58, 102, 14);
		
		child1panel.add(lblMaleFemale1);
		lblBirthdate1.setBounds(32, 94, 102, 14);
		
		child1panel.add(lblBirthdate1);
		lblAge1.setBounds(32, 130, 102, 14);
		
		child1panel.add(lblAge1);
		
		child1panel.add(child1firstnametextField);
		buttonGroup_1.add(rdbtnMale1);
		rdbtnMale1.setToolTipText("Choose Male or Female");
		rdbtnMale1.setBounds(155, 58, 59, 20);
		
		child1panel.add(rdbtnMale1);
		buttonGroup_1.add(rdbtnFemale1);
		rdbtnFemale1.setToolTipText("Choose Male or Female");
		rdbtnFemale1.setBounds(258, 58, 59, 20);
		
		child1panel.add(rdbtnFemale1);
		monthcomboBox1.setToolTipText("Choose Birthdate Month");
		monthcomboBox1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_monthcomboBox_propertyChange(evt);
			}
		});
		monthcomboBox1.setModel(new DefaultComboBoxModel(Month.values()));
		monthcomboBox1.setBounds(155, 94, 97, 20);
		
		child1panel.add(monthcomboBox1);
		yearcomboBox1.setToolTipText("Chose year of birthdate");
		yearcomboBox1.setModel(new DefaultComboBoxModel(new String[] {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996"}));
		yearcomboBox1.setBounds(321, 94, 59, 20);
		
		child1panel.add(yearcomboBox1);
		daycomboBox1.setToolTipText("Chose Birth Day");
		daycomboBox1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32"}));
		daycomboBox1.setBounds(258, 94, 53, 20);
		
		child1panel.add(daycomboBox1);
		lblClothingSize1.setBounds(32, 166, 102, 14);
		
		child1panel.add(lblClothingSize1);
		clothingsizecomboBox1.setToolTipText("Chose size clothing for child");
		clothingsizecomboBox1.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		clothingsizecomboBox1.setBounds(155, 166, 50, 20);
		
		child1panel.add(clothingsizecomboBox1);
		shoespinner1.setToolTipText("Chose Child's Shoe size");
		shoespinner1.setModel(new SpinnerListModel(new String[] {"1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9", "9.5", "10", "10.5", "11", "11.5", "12", "12.5", "13", "13.5", "14", "14.5", "15", "15.5", "16", "16.5", "17", "17.5", "18", "18.5", "19", "19.5", "20"}));
		shoespinner1.setBounds(155, 202, 47, 20);
		
		child1panel.add(shoespinner1);
		lblShoeSize1.setBounds(32, 202, 102, 14);
		
		child1panel.add(lblShoeSize1);
		lblCoatSize1.setBounds(32, 238, 102, 14);
		
		child1panel.add(lblCoatSize1);
		coatsizecomboBox1.setToolTipText("Chose Child's coat size");
		coatsizecomboBox1.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		coatsizecomboBox1.setBounds(155, 238, 50, 20);
		
		child1panel.add(coatsizecomboBox1);
		lblGameSystem1.setBounds(413, 22, 127, 14);
		
		child1panel.add(lblGameSystem1);
		lblChildsInterests1.setBounds(413, 71, 109, 14);
		
		child1panel.add(lblChildsInterests1);
		scrollPane.setBounds(532, 69, 160, 56);
		
		child1panel.add(scrollPane);
		childsinterestjlist1.setLocation(453, 0);
		childsinterestjlist1.setToolTipText("Chose the child's interests use ctrl click for multiple");
		scrollPane.setViewportView(childsinterestjlist1);
		childsinterestjlist1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Arts/Crafts", "Drawing", "Action Heroes", "Cars/Trucks", "Planes/Trains", "Music", "Construction", "Lego/Duplo", "Outdoors", "Dolls", "Sports"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		btnGoToFinancialTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnGoToNext_1_actionPerformed(arg0);
			}
		});
		btnGoToFinancialTab.setBounds(532, 198, 160, 20);
		
		child1panel.add(btnGoToFinancialTab);
		agespinner1.setModel(new SpinnerNumberModel(0, 0, 17, 1));
		agespinner1.setBounds(155, 130, 50, 20);
		
		child1panel.add(agespinner1);
		scrollPane_6.setBounds(532, 22, 160, 20);
		
		child1panel.add(scrollPane_6);
		gamesystemlist1.setToolTipText("Pick Childs game system CTRL+Click for more than 1");
		scrollPane_6.setViewportView(gamesystemlist1);
		gamesystemlist1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Xbox 360", "PS3", "Wii", "PSP", "Nintendo DS", "Xbox1", "PS4", "Computer"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		child1panel.setFocusCycleRoot(true);
		child1panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{child1firstnametextField, rdbtnMale1, rdbtnFemale1, monthcomboBox1, daycomboBox1, yearcomboBox1, agespinner1, clothingsizecomboBox1, shoespinner1, coatsizecomboBox1, gamesystemlist1, childsinterestjlist1, btnGoToFinancialTab}));
		
		childrentabbedPane.addTab("Child 2", null, child2panel, null);
		child2panel.setLayout(null);
		lblChild2FirstName.setBounds(32, 22, 102, 14);
		
		child2panel.add(lblChild2FirstName);
		child2firstnametextField.setToolTipText("Enter Childs First Name");
		child2firstnametextField.setColumns(10);
		child2firstnametextField.setBounds(155, 22, 127, 20);
		
		child2panel.add(child2firstnametextField);
		lblMaleFemale2.setBounds(32, 58, 102, 14);
		
		child2panel.add(lblMaleFemale2);
		buttonGroup_2.add(rdbtnMale2);
		rdbtnMale2.setToolTipText("Choose Male or Female");
		rdbtnMale2.setBounds(155, 58, 59, 20);
		
		child2panel.add(rdbtnMale2);
		buttonGroup_2.add(rdbtnFemale2);
		rdbtnFemale2.setToolTipText("Choose Male or Female");
		rdbtnFemale2.setBounds(258, 58, 59, 20);
		
		child2panel.add(rdbtnFemale2);
		lblBirthdate2.setBounds(32, 94, 102, 14);
		
		child2panel.add(lblBirthdate2);
		monthcomboBox2.setModel(new DefaultComboBoxModel(Month.values()));
		monthcomboBox2.setToolTipText("Choose Birthdate Month");
		monthcomboBox2.setBounds(155,94,97,20);
		
		child2panel.add(monthcomboBox2);
		daycomboBox2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32"}));
		daycomboBox2.setToolTipText("Chose Birth Day");
		daycomboBox2.setBounds(258, 94, 53, 20);
		
		child2panel.add(daycomboBox2);
		yearcomboBox2.setModel(new DefaultComboBoxModel(new String[] {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996"}));
		yearcomboBox2.setToolTipText("Chose year of birthdate");
		yearcomboBox2.setBounds(321,94,59,20);
		
		child2panel.add(yearcomboBox2);
		lblAge2.setBounds(32, 130, 102, 14);
		
		child2panel.add(lblAge2);
		agespinner2.setModel(new SpinnerNumberModel(0, 0, 17, 1));
		agespinner2.setBounds(155, 130, 50, 20);
		
		child2panel.add(agespinner2);
		lblClothingSize2.setBounds(32, 166, 102, 14);
		
		child2panel.add(lblClothingSize2);
		clothingsizecomboBox2.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		clothingsizecomboBox2.setToolTipText("Chose size clothing for child");
		clothingsizecomboBox2.setBounds(155, 166, 50, 20);
		
		child2panel.add(clothingsizecomboBox2);
		lblShoeSize2.setBounds(32, 202, 102, 14);
		
		child2panel.add(lblShoeSize2);
		shoespinner2.setModel(new SpinnerListModel(new String[] {"1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9", "9.5", "10", "10.5", "11", "11.5", "12", "12.5", "13", "13.5", "14", "14.5", "15", "15.5", "16", "16.5", "17", "17.5", "18", "18.5", "19", "19.5", "20"}));
		shoespinner2.setToolTipText("Chose Child's Shoe size");
		shoespinner2.setBounds(155, 202, 47, 20);
		
		child2panel.add(shoespinner2);
		lblCoatSize2.setBounds(32, 238, 102, 14);
		
		child2panel.add(lblCoatSize2);
		coatsizecomboBox2.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		coatsizecomboBox2.setToolTipText("Chose Child's coat size");
		coatsizecomboBox2.setBounds(155, 238, 50, 20);
		
		child2panel.add(coatsizecomboBox2);
		lblGameSystem2.setBounds(413, 22, 127, 14);
		
		child2panel.add(lblGameSystem2);
		scrollPane_7.setBounds(532, 22, 160, 20);
		
		child2panel.add(scrollPane_7);
		scrollPane_7.setViewportView(gamesystemlist2);
		gamesystemlist2.setModel(new AbstractListModel() {
			String[] values = new String[] {"Xbox 360", "PS3", "Wii", "PSP", "Nintendo DS", "Xbox1", "PS4", "Computer"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		gamesystemlist2.setToolTipText("Chose what game system the child owns");
		lblChildsInterests2.setBounds(413, 71, 109, 14);
		
		child2panel.add(lblChildsInterests2);
		scrollPane_1.setBounds(532, 69, 160, 56);
		
		child2panel.add(scrollPane_1);
		childsinterestjlist2.setModel(new AbstractListModel() {
			String[] values = new String[] {"Arts/Crafts", "Drawing", "Action Heroes", "Cars/Trucks", "Planes/Trains", "Music", "Construction", "Lego/Duplo", "Outdoors", "Dolls", "Sports"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(childsinterestjlist2);
		childsinterestjlist2.setToolTipText("Chose the child's interests use ctrl click for multiple");
		btnGoToFinancial2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoToFinancial2_actionPerformed(e);
			}
		});
		btnGoToFinancial2.setBounds(532, 198, 160, 20);
		
		child2panel.add(btnGoToFinancial2);
		child2panel.setFocusCycleRoot(true);
		child2panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{child2firstnametextField, rdbtnMale2, rdbtnFemale2, monthcomboBox2, daycomboBox2, yearcomboBox2, agespinner2, clothingsizecomboBox2, shoespinner2, coatsizecomboBox2, gamesystemlist2, childsinterestjlist2, btnGoToFinancial2}));
		
		childrentabbedPane.addTab("Child 3", null, child3panel, null);
		child3panel.setLayout(null);
		lblChild3FirstName.setBounds(32, 22, 102, 14);
		
		child3panel.add(lblChild3FirstName);
		child3firstnametextField.setToolTipText("Enter Childs First Name");
		child3firstnametextField.setColumns(10);
		child3firstnametextField.setBounds(155, 22, 127, 20);
		
		child3panel.add(child3firstnametextField);
		lblMaleFemale3.setBounds(32, 58, 102, 14);
		
		child3panel.add(lblMaleFemale3);
		buttonGroup_3.add(rdbtnMale3);
		rdbtnMale3.setToolTipText("Choose Male or Female");
		rdbtnMale3.setBounds(155, 58, 59, 20);
		
		child3panel.add(rdbtnMale3);
		buttonGroup_3.add(rdbtnFemale3);
		rdbtnFemale3.setToolTipText("Choose Male or Female");
		rdbtnFemale3.setBounds(258, 58, 59, 20);
		
		child3panel.add(rdbtnFemale3);
		lblBirthdate3.setBounds(32, 94, 102, 14);
		
		child3panel.add(lblBirthdate3);
		monthcomboBox3.setModel(new DefaultComboBoxModel(Month.values()));
		monthcomboBox3.setToolTipText("Choose Birthdate Month");
		monthcomboBox3.setBounds(155,94,97,20);
		
		child3panel.add(monthcomboBox3);
		daycomboBox3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32"}));
		daycomboBox3.setToolTipText("Chose Birth Day");
		daycomboBox3.setBounds(258, 94, 53, 20);
		
		child3panel.add(daycomboBox3);
		yearcomboBox3.setModel(new DefaultComboBoxModel(new String[] {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996"}));
		yearcomboBox3.setToolTipText("Chose year of birthdate");
		yearcomboBox3.setBounds(321,94,59,20);
		
		child3panel.add(yearcomboBox3);
		lblAge3.setBounds(32, 130, 102, 14);
		
		child3panel.add(lblAge3);
		agespinner3.setModel(new SpinnerNumberModel(0, 0, 17, 1));
		agespinner3.setBounds(155, 130, 50, 20);
		
		child3panel.add(agespinner3);
		lblClothingSize3.setBounds(32, 166, 102, 14);
		
		child3panel.add(lblClothingSize3);
		clothingsizecomboBox3.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		clothingsizecomboBox3.setToolTipText("Chose size clothing for child");
		clothingsizecomboBox3.setBounds(155, 166, 50, 20);
		
		child3panel.add(clothingsizecomboBox3);
		lblShoeSize3.setBounds(32, 202, 102, 14);
		
		child3panel.add(lblShoeSize3);
		shoespinner3.setModel(new SpinnerListModel(new String[] {"1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9", "9.5", "10", "10.5", "11", "11.5", "12", "12.5", "13", "13.5", "14", "14.5", "15", "15.5", "16", "16.5", "17", "17.5", "18", "18.5", "19", "19.5", "20"}));
		shoespinner3.setToolTipText("Chose Child's Shoe size");
		shoespinner3.setBounds(155, 202, 47, 20);
		
		child3panel.add(shoespinner3);
		lblCoatSize3.setBounds(32, 238, 102, 14);
		
		child3panel.add(lblCoatSize3);
		coatsizecomboBox3.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		coatsizecomboBox3.setToolTipText("Chose Child's coat size");
		coatsizecomboBox3.setBounds(155, 238, 50, 20);
		
		child3panel.add(coatsizecomboBox3);
		lblGameSystem3.setBounds(413, 22, 127, 14);
		
		child3panel.add(lblGameSystem3);
		scrollPane_8.setBounds(532, 22, 160, 20);
		
		child3panel.add(scrollPane_8);
		scrollPane_8.setViewportView(gamesystemlist3);
		gamesystemlist3.setModel(new AbstractListModel() {
			String[] values = new String[] {"Xbox 360", "PS3", "Wii", "PSP", "Nintendo DS", "Xbox1", "PS4", "Computer"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		gamesystemlist3.setToolTipText("Chose what game system the child owns");
		lblChildsInterests3.setBounds(413, 71, 109, 14);
		
		child3panel.add(lblChildsInterests3);
		scrollPane_2.setBounds(532, 69, 160, 56);
		
		child3panel.add(scrollPane_2);
		childsinterestjlist3.setModel(new AbstractListModel() {
			String[] values = new String[] {"Arts/Crafts", "Drawing", "Action Heroes", "Cars/Trucks", "Planes/Trains", "Music", "Construction", "Lego/Duplo", "Outdoors", "Dolls", "Sports"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_2.setViewportView(childsinterestjlist3);
		childsinterestjlist3.setToolTipText("Chose the child's interests use ctrl click for multiple");
		btnGoToFinancial3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoToFinancial3_actionPerformed(e);
			}
		});
		btnGoToFinancial3.setBounds(532, 198, 160, 20);
		
		child3panel.add(btnGoToFinancial3);
		child3panel.setFocusCycleRoot(true);
		child3panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{child3firstnametextField, rdbtnMale3, rdbtnFemale3, monthcomboBox3, daycomboBox3, yearcomboBox3, agespinner3, clothingsizecomboBox3, shoespinner3, coatsizecomboBox3, gamesystemlist3, childsinterestjlist3, btnGoToFinancial3}));
		
		childrentabbedPane.addTab("Child 4", null, child4panel, null);
		child4panel.setLayout(null);
		lblChild4FirstName.setBounds(32, 22, 102, 14);
		
		child4panel.add(lblChild4FirstName);
		child4firstnametextField.setToolTipText("Enter Childs First Name");
		child4firstnametextField.setColumns(10);
		child4firstnametextField.setBounds(155, 22, 127, 20);
		
		child4panel.add(child4firstnametextField);
		lblMaleFemale4.setBounds(32, 58, 102, 14);
		
		child4panel.add(lblMaleFemale4);
		buttonGroup_4.add(rdbtnMale4);
		rdbtnMale4.setToolTipText("Choose Male or Female");
		rdbtnMale4.setBounds(155, 58, 59, 20);
		
		child4panel.add(rdbtnMale4);
		buttonGroup_4.add(rdbtnFemale4);
		rdbtnFemale4.setToolTipText("Choose Male or Female");
		rdbtnFemale4.setBounds(258, 58, 59, 20);
		
		child4panel.add(rdbtnFemale4);
		lblBirthdate4.setBounds(32, 94, 102, 14);
		
		child4panel.add(lblBirthdate4);
		monthcomboBox4.setModel(new DefaultComboBoxModel(Month.values()));
		monthcomboBox4.setToolTipText("Choose Birthdate Month");
		monthcomboBox4.setBounds(155,94,97,20);
		
		child4panel.add(monthcomboBox4);
		daycomboBox4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32"}));
		daycomboBox4.setToolTipText("Chose Birth Day");
		daycomboBox4.setBounds(258, 94, 53, 20);
		
		child4panel.add(daycomboBox4);
		yearcomboBox4.setModel(new DefaultComboBoxModel(new String[] {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996"}));
		yearcomboBox4.setToolTipText("Chose year of birthdate");
		yearcomboBox4.setBounds(321,94,59,20);
		
		child4panel.add(yearcomboBox4);
		lblAge4.setBounds(32, 130, 102, 14);
		
		child4panel.add(lblAge4);
		agespinner4.setModel(new SpinnerNumberModel(0, 0, 17, 1));
		agespinner4.setBounds(155, 130, 50, 20);
		
		child4panel.add(agespinner4);
		lblClothingSize4.setBounds(32, 166, 102, 14);
		
		child4panel.add(lblClothingSize4);
		clothingsizecomboBox4.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		clothingsizecomboBox4.setToolTipText("Chose size clothing for child");
		clothingsizecomboBox4.setBounds(155, 166, 50, 20);
		
		child4panel.add(clothingsizecomboBox4);
		lblShoeSize4.setBounds(32, 202, 102, 14);
		
		child4panel.add(lblShoeSize4);
		shoespinner4.setModel(new SpinnerListModel(new String[] {"1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9", "9.5", "10", "10.5", "11", "11.5", "12", "12.5", "13", "13.5", "14", "14.5", "15", "15.5", "16", "16.5", "17", "17.5", "18", "18.5", "19", "19.5", "20"}));
		shoespinner4.setToolTipText("Chose Child's Shoe size");
		shoespinner4.setBounds(155, 202, 47, 20);
		
		child4panel.add(shoespinner4);
		lblCoatSize4.setBounds(32, 238, 102, 14);
		
		child4panel.add(lblCoatSize4);
		coatsizecomboBox4.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		coatsizecomboBox4.setToolTipText("Chose Child's coat size");
		coatsizecomboBox4.setBounds(155, 238, 50, 20);
		
		child4panel.add(coatsizecomboBox4);
		lblGameSystem4.setBounds(413, 22, 127, 14);
		
		child4panel.add(lblGameSystem4);
		scrollPane_9.setBounds(532, 22, 160, 20);
		
		child4panel.add(scrollPane_9);
		scrollPane_9.setViewportView(gamesystemlist4);
		gamesystemlist4.setModel(new AbstractListModel() {
			String[] values = new String[] {"Xbox 360", "PS3", "Wii", "PSP", "Nintendo DS", "Xbox1", "PS4", "Computer"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		gamesystemlist4.setToolTipText("Chose what game system the child owns");
		lblChildsInterests4.setBounds(413, 71, 109, 14);
		
		child4panel.add(lblChildsInterests4);
		scrollPane_3.setBounds(532, 69, 160, 56);
		
		child4panel.add(scrollPane_3);
		childsinterestjlist4.setSize(127, 176);
		childsinterestjlist4.setModel(new AbstractListModel() {
			String[] values = new String[] {"Arts/Crafts", "Drawing", "Action Heroes", "Cars/Trucks", "Planes/Trains", "Music", "Construction", "Lego/Duplo", "Outdoors", "Dolls", "Sports"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_3.setViewportView(childsinterestjlist4);
		childsinterestjlist4.setToolTipText("Chose the child's interests use ctrl click for multiple");
		btnGoToFinancial4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoToFinancial4_actionPerformed(e);
			}
		});
		btnGoToFinancial4.setBounds(532, 198, 160, 20);
		
		child4panel.add(btnGoToFinancial4);
		child4panel.setFocusCycleRoot(true);
		child4panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{child4firstnametextField, rdbtnMale4, rdbtnFemale4, monthcomboBox4, daycomboBox4, yearcomboBox4, agespinner4, clothingsizecomboBox4, shoespinner4, coatsizecomboBox4, gamesystemlist4, childsinterestjlist4, btnGoToFinancial4}));
		
		childrentabbedPane.addTab("Child 5", null, child5panel, null);
		child5panel.setLayout(null);
		lblChild5FirstName.setBounds(32, 22, 127, 14);
		
		child5panel.add(lblChild5FirstName);
		child5firstnametextField.setToolTipText("Enter Childs First Name");
		child5firstnametextField.setColumns(10);
		child5firstnametextField.setBounds(155, 22, 127, 20);
		
		child5panel.add(child5firstnametextField);
		lblMaleFemale5.setBounds(32, 58, 127, 14);
		
		child5panel.add(lblMaleFemale5);
		buttonGroup_5.add(rdbtnMale5);
		rdbtnMale5.setToolTipText("Choose Male or Female");
		rdbtnMale5.setBounds(155, 58, 59, 20);
		
		child5panel.add(rdbtnMale5);
		buttonGroup_5.add(rdbtnFemale5);
		rdbtnFemale5.setToolTipText("Choose Male or Female");
		rdbtnFemale5.setBounds(258, 58, 59, 20);
		
		child5panel.add(rdbtnFemale5);
		lblBirthdate5.setBounds(32, 94, 127, 14);
		
		child5panel.add(lblBirthdate5);
		monthcomboBox5.setModel(new DefaultComboBoxModel(Month.values()));
		monthcomboBox5.setToolTipText("Choose Birthdate Month");
		monthcomboBox5.setBounds(155,94,97,20);
		
		child5panel.add(monthcomboBox5);
		daycomboBox5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32"}));
		daycomboBox5.setToolTipText("Chose Birth Day");
		daycomboBox5.setBounds(258, 94, 53, 20);
		
		child5panel.add(daycomboBox5);
		yearcomboBox5.setModel(new DefaultComboBoxModel(new String[] {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996"}));
		yearcomboBox5.setToolTipText("Chose year of birthdate");
		yearcomboBox5.setBounds(321,94,59,20);
		
		child5panel.add(yearcomboBox5);
		lblAge5.setBounds(32, 130, 127, 14);
		
		child5panel.add(lblAge5);
		agespinner5.setModel(new SpinnerNumberModel(0, 0, 17, 1));
		agespinner5.setBounds(155, 130, 50, 20);
		
		child5panel.add(agespinner5);
		lblClothingSize5.setBounds(32, 166, 127, 14);
		
		child5panel.add(lblClothingSize5);
		clothingsizecomboBox5.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		clothingsizecomboBox5.setToolTipText("Chose size clothing for child");
		clothingsizecomboBox5.setBounds(155, 166, 50, 20);
		
		child5panel.add(clothingsizecomboBox5);
		lblShoeSize5.setBounds(32, 202, 127, 14);
		
		child5panel.add(lblShoeSize5);
		shoespinner5.setModel(new SpinnerListModel(new String[] {"1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9", "9.5", "10", "10.5", "11", "11.5", "12", "12.5", "13", "13.5", "14", "14.5", "15", "15.5", "16", "16.5", "17", "17.5", "18", "18.5", "19", "19.5", "20"}));
		shoespinner5.setToolTipText("Chose Child's Shoe size");
		shoespinner5.setBounds(155, 202, 47, 20);
		
		child5panel.add(shoespinner5);
		lblCoatSize5.setBounds(32, 238, 127, 14);
		
		child5panel.add(lblCoatSize5);
		coatsizecomboBox5.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		coatsizecomboBox5.setToolTipText("Chose Child's coat size");
		coatsizecomboBox5.setBounds(155, 238, 50, 20);
		
		child5panel.add(coatsizecomboBox5);
		lblGameSystem5.setBounds(413, 22, 127, 14);
		
		child5panel.add(lblGameSystem5);
		scrollPane_10.setBounds(532, 22, 160, 20);
		
		child5panel.add(scrollPane_10);
		scrollPane_10.setViewportView(gamesystemlist5);
		gamesystemlist5.setModel(new AbstractListModel() {
			String[] values = new String[] {"Xbox 360", "PS3", "Wii", "PSP", "Nintendo DS", "Xbox1", "PS4", "Computer"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		gamesystemlist5.setToolTipText("Chose what game system the child owns");
		lblChildsInterests5.setBounds(413, 71, 127, 14);
		
		child5panel.add(lblChildsInterests5);
		scrollPane_4.setBounds(532, 69, 160, 56);
		
		child5panel.add(scrollPane_4);
		childsinterestjlist5.setModel(new AbstractListModel() {
			String[] values = new String[] {"Arts/Crafts", "Drawing", "Action Heroes", "Cars/Trucks", "Planes/Trains", "Music", "Construction", "Lego/Duplo", "Outdoors", "Dolls", "Sports"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_4.setViewportView(childsinterestjlist5);
		childsinterestjlist5.setToolTipText("Chose the child's interests use ctrl click for multiple");
		btnGoToFinancial5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoToFinancial5_actionPerformed(e);
			}
		});
		btnGoToFinancial5.setBounds(532, 198, 160, 20);
		
		child5panel.add(btnGoToFinancial5);
		child5panel.setFocusCycleRoot(true);
		child5panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{child5firstnametextField, rdbtnMale5, rdbtnFemale5, monthcomboBox5, daycomboBox5, yearcomboBox5, agespinner5, clothingsizecomboBox5, shoespinner5, coatsizecomboBox5, gamesystemlist5, childsinterestjlist5, btnGoToFinancial5}));
		
		childrentabbedPane.addTab("Child 6", null, child6panel, null);
		child6panel.setLayout(null);
		lblChild6FirstName.setBounds(32, 22, 102, 14);
		
		child6panel.add(lblChild6FirstName);
		child6firstnametextField.setToolTipText("Enter Childs First Name");
		child6firstnametextField.setColumns(10);
		child6firstnametextField.setBounds(155, 22, 127, 20);
		
		child6panel.add(child6firstnametextField);
		lblMaleFemale6.setBounds(32, 58, 102, 14);
		
		child6panel.add(lblMaleFemale6);
		buttonGroup_6.add(rdbtnMale6);
		rdbtnMale6.setToolTipText("Choose Male or Female");
		rdbtnMale6.setBounds(155, 58, 59, 20);
		
		child6panel.add(rdbtnMale6);
		buttonGroup_6.add(rdbtnFemale6);
		rdbtnFemale6.setToolTipText("Choose Male or Female");
		rdbtnFemale6.setBounds(258, 58, 59, 20);
		
		child6panel.add(rdbtnFemale6);
		lblBirthdate6.setBounds(32, 94, 102, 14);
		
		child6panel.add(lblBirthdate6);
		monthcomboBox6.setModel(new DefaultComboBoxModel(Month.values()));
		monthcomboBox6.setToolTipText("Choose Birthdate Month");
		monthcomboBox6.setBounds(155,94,97,20);
		
		child6panel.add(monthcomboBox6);
		daycomboBox6.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32"}));
		daycomboBox6.setToolTipText("Chose Birth Day");
		daycomboBox6.setBounds(258, 94, 53, 20);
		
		child6panel.add(daycomboBox6);
		yearcomboBox6.setModel(new DefaultComboBoxModel(new String[] {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996"}));
		yearcomboBox6.setToolTipText("Chose year of birthdate");
		yearcomboBox6.setBounds(321,94,59,20);
		
		child6panel.add(yearcomboBox6);
		lblAge6.setBounds(32, 130, 102, 14);
		
		child6panel.add(lblAge6);
		agespinner6.setModel(new SpinnerNumberModel(0, 0, 17, 1));
		agespinner6.setBounds(155, 130, 50, 20);
		
		child6panel.add(agespinner6);
		lblClothingSize6.setBounds(32, 166, 102, 14);
		
		child6panel.add(lblClothingSize6);
		clothingsizecomboBox6.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		clothingsizecomboBox6.setToolTipText("Chose size clothing for child");
		clothingsizecomboBox6.setBounds(155, 166, 50, 20);
		
		child6panel.add(clothingsizecomboBox6);
		lblShoeSize6.setBounds(32, 202, 102, 14);
		
		child6panel.add(lblShoeSize6);
		shoespinner6.setModel(new SpinnerListModel(new String[] {"1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9", "9.5", "10", "10.5", "11", "11.5", "12", "12.5", "13", "13.5", "14", "14.5", "15", "15.5", "16", "16.5", "17", "17.5", "18", "18.5", "19", "19.5", "20"}));
		shoespinner6.setToolTipText("Chose Child's Shoe size");
		shoespinner6.setBounds(155, 202, 47, 20);
		
		child6panel.add(shoespinner6);
		lblCoatSize6.setBounds(32, 238, 102, 14);
		
		child6panel.add(lblCoatSize6);
		coatsizecomboBox6.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "2X"}));
		coatsizecomboBox6.setToolTipText("Chose Child's coat size");
		coatsizecomboBox6.setBounds(155, 238, 50, 20);
		
		child6panel.add(coatsizecomboBox6);
		lblGameSystem6.setBounds(413, 22, 127, 14);
		
		child6panel.add(lblGameSystem6);
		scrollPane_11.setBounds(532, 22, 160, 20);
		
		child6panel.add(scrollPane_11);
		scrollPane_11.setViewportView(gamesystemlist6);
		gamesystemlist6.setModel(new AbstractListModel() {
			String[] values = new String[] {"Xbox 360", "PS3", "Wii", "PSP", "Nintendo DS", "Xbox1", "PS4", "Computer"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		gamesystemlist6.setToolTipText("Chose what game system the child owns");
		lblChildsInterests6.setBounds(413, 71, 109, 14);
		
		child6panel.add(lblChildsInterests6);
		scrollPane_5.setBounds(532, 69, 160, 56);
		
		child6panel.add(scrollPane_5);
		childsinterestjlist6.setModel(new AbstractListModel() {
			String[] values = new String[] {"Arts/Crafts", "Drawing", "Action Heroes", "Cars/Trucks", "Planes/Trains", "Music", "Construction", "Lego/Duplo", "Outdoors", "Dolls", "Sports"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_5.setViewportView(childsinterestjlist6);
		childsinterestjlist6.setToolTipText("Chose the child's interests use ctrl click for multiple");
		btnGoToFinancial6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnGoToFinancial6_actionPerformed(e);
			}
		});
		btnGoToFinancial6.setBounds(532, 198, 160, 20);
		
		child6panel.add(btnGoToFinancial6);
		child6panel.setFocusCycleRoot(true);
		child6panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{child6firstnametextField, rdbtnMale6, rdbtnFemale6, monthcomboBox6, daycomboBox6, yearcomboBox6, agespinner6, clothingsizecomboBox6, shoespinner6, coatsizecomboBox6, gamesystemlist6, childsinterestjlist6, btnGoToFinancial6}));
		childinfopanel.setFocusCycleRoot(true);
		childinfopanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{childrentabbedPane, child1panel, child1firstnametextField, rdbtnMale1, rdbtnFemale1, monthcomboBox1, daycomboBox1, yearcomboBox1, agespinner1, clothingsizecomboBox1, shoespinner1, coatsizecomboBox1, gamesystemlist1, childsinterestjlist1, btnGoToFinancialTab, child2panel, child2firstnametextField, rdbtnMale2, rdbtnFemale2, monthcomboBox2, daycomboBox2, yearcomboBox2, agespinner2, clothingsizecomboBox2, shoespinner2, coatsizecomboBox2, gamesystemlist2, childsinterestjlist2, btnGoToFinancial2, child3panel, child3firstnametextField, rdbtnMale3, rdbtnFemale3, monthcomboBox3, daycomboBox3, yearcomboBox3, agespinner3, clothingsizecomboBox3, shoespinner3, coatsizecomboBox3, gamesystemlist3, childsinterestjlist3, btnGoToFinancial3, child4panel, child4firstnametextField, rdbtnMale4, rdbtnFemale4, monthcomboBox4, daycomboBox4, yearcomboBox4, agespinner4, clothingsizecomboBox4, shoespinner4, coatsizecomboBox4, gamesystemlist4, childsinterestjlist4, btnGoToFinancial4, child5panel, child5firstnametextField, rdbtnMale5, rdbtnFemale5, monthcomboBox5, daycomboBox5, yearcomboBox5, agespinner5, clothingsizecomboBox5, shoespinner5, coatsizecomboBox5, gamesystemlist5, childsinterestjlist5, btnGoToFinancial5, child6panel, child6firstnametextField, rdbtnMale6, rdbtnFemale6, monthcomboBox6, daycomboBox6, yearcomboBox6, agespinner6, clothingsizecomboBox6, shoespinner6, coatsizecomboBox6, gamesystemlist6, childsinterestjlist6, btnGoToFinancial6}));
		
		maintabbedPane.addTab("Financial Information", null, financialinfopanel, null);
		maintabbedPane.setEnabledAt(2, false);
		financialinfopanel.setLayout(null);
		lblIncome.setBounds(138, 12, 127, 20);
		
		financialinfopanel.add(lblIncome);
		lblEmploymenttotal.setBounds(10, 44, 157, 20);
		
		financialinfopanel.add(lblEmploymenttotal);
		lblChildSpousalSupport.setBounds(10, 76, 157, 20);
		
		financialinfopanel.add(lblChildSpousalSupport);
		lblOntarioWorks.setBounds(10, 108, 157, 20);
		
		financialinfopanel.add(lblOntarioWorks);
		lblEiOrDisability.setBounds(10, 140, 157, 20);
		
		financialinfopanel.add(lblEiOrDisability);
		lblPensionIncome.setBounds(10, 172, 157, 20);
		
		financialinfopanel.add(lblPensionIncome);
		lblChildTaxCredits.setBounds(10, 204, 157, 20);
		
		financialinfopanel.add(lblChildTaxCredits);
		lblExpenses.setBounds(416, 12, 127, 20);
		
		financialinfopanel.add(lblExpenses);
		lblRentOrMortgage.setBounds(307, 44, 127, 20);
		
		financialinfopanel.add(lblRentOrMortgage);
		lblGashydro.setBounds(307, 76, 127, 20);
		
		financialinfopanel.add(lblGashydro);
		lblPhoneTV.setBounds(307, 108, 127, 20);
		
		financialinfopanel.add(lblPhoneTV);
		lblChildCare.setBounds(307, 140, 127, 20);
		
		financialinfopanel.add(lblChildCare);
		lblTransitGas.setBounds(307, 172, 127, 20);
		
		financialinfopanel.add(lblTransitGas);
		lblLoansinsurance.setBounds(307, 204, 127, 20);
		
		financialinfopanel.add(lblLoansinsurance);
		lblTotalIncome.setBounds(10, 236, 157, 20);
		
		financialinfopanel.add(lblTotalIncome);
		lblTotalExpenses.setBounds(307, 236, 127, 20);
		
		financialinfopanel.add(lblTotalExpenses);
		lblTotalNetIncome.setBounds(10, 268, 157, 20);
		
		financialinfopanel.add(lblTotalNetIncome);
		buttonGroup.add(rdbtnRent);
		rdbtnRent.setToolTipText("Do you rent?");
		rdbtnRent.setBounds(416, 44, 63, 20);
		
		financialinfopanel.add(rdbtnRent);
		buttonGroup.add(rdbtnMortgage);
		rdbtnMortgage.setToolTipText("Do you have a mortgage?");
		rdbtnMortgage.setBounds(482, 44, 90, 20);
		
		financialinfopanel.add(rdbtnMortgage);
		employmentFTF.setToolTipText("Enter Employment Income");
		employmentFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_employmentFTF_propertyChange(evt);
			}
		});
		employmentFTF.setBounds(138, 43, 100, 20);
		employmentFTF.setValue(employment);
		
		financialinfopanel.add(employmentFTF);
		supportFTF.setToolTipText("Enter any support income");
		supportFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_supportFTF_propertyChange(evt);
			}
		});
		supportFTF.setBounds(138, 76, 100, 20);
		supportFTF.setValue(support);
		
		
		financialinfopanel.add(supportFTF);
		ontarioworksFTF.setToolTipText("Enter Ontario Works income");
		ontarioworksFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_ontarioworksFTF_propertyChange(evt);
			}
		});
		ontarioworksFTF.setBounds(138, 108, 100, 20);
		ontarioworksFTF.setValue(ontarioworks);
		
		financialinfopanel.add(ontarioworksFTF);
		disabilityFTF.setToolTipText("Enter Disability income");
		disabilityFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_disabilityFTF_propertyChange(evt);
			}
		});
		disabilityFTF.setBounds(138, 140, 100, 20);
		disabilityFTF.setValue(disability);
		
		financialinfopanel.add(disabilityFTF);
		pensionFTF.setToolTipText("Enter pension income");
		pensionFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_pensionFTF_propertyChange(evt);
			}
		});
		pensionFTF.setBounds(138, 172, 100, 20);
		pensionFTF.setValue(pension);
		
		financialinfopanel.add(pensionFTF);
		childtaxcreditsFTF.setToolTipText("Enter Child tax credits");
		childtaxcreditsFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_childtaxcreditsFTF_propertyChange(evt);
			}
		});
		childtaxcreditsFTF.setBounds(138, 204, 100, 20);
		childtaxcreditsFTF.setValue(childtaxcredits);
		
		financialinfopanel.add(childtaxcreditsFTF);
		totalincomeFTF.setEditable(false);
		totalincomeFTF.setToolTipText("Total income can be predetermined");
		totalincomeFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_totalincomeFTF_propertyChange(evt);
			}
		});
		totalincomeFTF.setBounds(138, 236, 100, 20);
		totalincomeFTF.setValue(totalincome);
		
		financialinfopanel.add(totalincomeFTF);
		totalnetincomeFTF.setEditable(false);
		totalnetincomeFTF.setBounds(138, 268, 100, 20);
		totalnetincomeFTF.setValue(totalnetincome);
		
		financialinfopanel.add(totalnetincomeFTF);
		gashydroFTF.setToolTipText("Enter gas and Hydro Expenses");
		gashydroFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_gashydroFTF_propertyChange(evt);
			}
		});
		gashydroFTF.setBounds(416, 76, 100, 20);
		gashydroFTF.setValue(gashydro);
		
		financialinfopanel.add(gashydroFTF);
		phonetvFTF.setToolTipText("Enter Phone and Television expenses");
		phonetvFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_phonetvFTF_propertyChange(evt);
			}
		});
		phonetvFTF.setBounds(416, 108, 100, 20);
		phonetvFTF.setValue(phonetv);
		
		financialinfopanel.add(phonetvFTF);
		rentmortgageFTF.setToolTipText("Enter Rent or morgage income");
		rentmortgageFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_rentmortgageFTF_propertyChange(evt);
			}
		});
		rentmortgageFTF.setBounds(571, 44, 100, 20);
		rentmortgageFTF.setValue(rentmortgage);
		
		financialinfopanel.add(rentmortgageFTF);
		childcareFTF.setToolTipText("Enter child care expenses");
		childcareFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_childcareFTF_propertyChange(evt);
			}
		});
		childcareFTF.setBounds(416, 140, 100, 20);
		childcareFTF.setValue(childcare);
		
		financialinfopanel.add(childcareFTF);
		transitgasFTF.setToolTipText("Enter travel expenses");
		transitgasFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_transitgasFTF_propertyChange(evt);
			}
		});
		transitgasFTF.setBounds(416, 172, 100, 20);
		transitgasFTF.setValue(transitgas);
		
		financialinfopanel.add(transitgasFTF);
		loansinsuranceFTF.setToolTipText("Enter loan and insurance expenses");
		loansinsuranceFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_loansinsuranceFTF_propertyChange(evt);
			}
		});
		loansinsuranceFTF.setBounds(416, 204, 100, 20);
		loansinsuranceFTF.setValue(loansinsurance);
		
		financialinfopanel.add(loansinsuranceFTF);
		totalexpensesFTF.setEditable(false);
		totalexpensesFTF.setToolTipText("Total expenses may be pre determinded");
		totalexpensesFTF.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_totalexpensesFTF_propertyChange(evt);
			}
		});
		totalexpensesFTF.setBounds(416, 236, 100, 20);
		totalexpensesFTF.setValue(totalexpenses);
		
		financialinfopanel.add(totalexpensesFTF);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSubmit_actionPerformed(e);
			}
		});
		btnSubmit.setBounds(331, 268, 160, 20);
		
		financialinfopanel.add(btnSubmit);
		financialinfopanel.setFocusCycleRoot(true);
		financialinfopanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{employmentFTF, supportFTF, ontarioworksFTF, disabilityFTF, pensionFTF, childtaxcreditsFTF, rdbtnRent, rdbtnMortgage, rentmortgageFTF, gashydroFTF, phonetvFTF, childcareFTF, transitgasFTF, loansinsuranceFTF, btnSubmit}));
		menuBar.setBounds(0, 0, 620, 21);
		
		contentPane.add(menuBar);
		
		menuBar.add(mnFile);
		mntmStartNewForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmStartNewForm_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmStartNewForm);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmExit);
		
		menuBar.add(mnHelp);
		mntmApplicationInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmApplicationInfo_actionPerformed(arg0);
			}
		});
		
		mnHelp.add(mntmApplicationInfo);
		mntmChildInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmChildInfo_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmChildInfo);
		mntmFinancialInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmFinancialInfo_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmFinancialInfo);
	}
	public void do_tabbedPane_stateChanged(ChangeEvent e) {//change tab original
		
	}
	protected void do_mntmExit_actionPerformed(ActionEvent arg0) {//exit system evitbutton
		
			System.exit(0);
	}
	public void calculateincome(){//calc total income
		totalincomeFTF.setValue(employment + support + ontarioworks + disability + pension + childtaxcredits);
		totalincome=((Number)totalincomeFTF.getValue()).doubleValue();
		totalincomeFTF.setText(""+curFormat.format(totalincome));
	}
	public void totalexpenses(){ //calc total expenses
		totalexpensesFTF.setValue(rentmortgage + gashydro + phonetv + childcare + transitgas + loansinsurance);
		totalexpenses=((Number)totalexpensesFTF.getValue()).doubleValue();
		totalexpensesFTF.setText(""+curFormat.format(totalexpenses));
	}
	public void totalnetincome(){ //calc net income
		totalnetincome =totalincome-totalexpenses;
		totalnetincomeFTF.setText(""+ curFormat.format(totalnetincome));
		if(totalnetincome < 0){totalnetincomeFTF.setForeground(Color.RED);}else
		{totalnetincomeFTF.setForeground(Color.BLACK);}
	}
	protected void do_employmentFTF_propertyChange(PropertyChangeEvent evt) {//get value in text fields
		employment=((Number)employmentFTF.getValue()).doubleValue();
		calculateincome();
	}
	protected void do_supportFTF_propertyChange(PropertyChangeEvent evt) {
		support=((Number)supportFTF.getValue()).doubleValue();
		calculateincome();
	}
	protected void do_ontarioworksFTF_propertyChange(PropertyChangeEvent evt) {
		ontarioworks=((Number)ontarioworksFTF.getValue()).doubleValue();
		calculateincome();
	}
	protected void do_disabilityFTF_propertyChange(PropertyChangeEvent evt) {
		disability=((Number)disabilityFTF.getValue()).doubleValue();
		calculateincome();
	}
	protected void do_pensionFTF_propertyChange(PropertyChangeEvent evt) {
		pension=((Number)pensionFTF.getValue()).doubleValue();
		calculateincome();
	}
	protected void do_childtaxcreditsFTF_propertyChange(PropertyChangeEvent evt) {
		childtaxcredits=((Number)childtaxcreditsFTF.getValue()).doubleValue();
		calculateincome();
	}
	protected void do_rentmortgageFTF_propertyChange(PropertyChangeEvent evt) {
		rentmortgage=((Number)rentmortgageFTF.getValue()).doubleValue();
		rentmortgageFTF.setForeground(Color.RED);
		totalexpenses();
	}
	protected void do_gashydroFTF_propertyChange(PropertyChangeEvent evt) {
		gashydro=((Number)gashydroFTF.getValue()).doubleValue();
		gashydroFTF.setForeground(Color.RED);
		totalexpenses();
	}
	protected void do_phonetvFTF_propertyChange(PropertyChangeEvent evt) {
		phonetv=((Number)phonetvFTF.getValue()).doubleValue();
		phonetvFTF.setForeground(Color.RED);
		totalexpenses();
	}
	protected void do_childcareFTF_propertyChange(PropertyChangeEvent evt) {
		childcare=((Number)childcareFTF.getValue()).doubleValue();
		childcareFTF.setForeground(Color.RED);
		totalexpenses();
	}
	protected void do_transitgasFTF_propertyChange(PropertyChangeEvent evt) {
		transitgas=((Number)transitgasFTF.getValue()).doubleValue();
		transitgasFTF.setForeground(Color.RED);
		totalexpenses();
	}
	protected void do_loansinsuranceFTF_propertyChange(PropertyChangeEvent evt) {
		loansinsurance=((Number)loansinsuranceFTF.getValue()).doubleValue();
		loansinsuranceFTF.setForeground(Color.RED);
		totalexpenses();
	}
	protected void do_totalincomeFTF_propertyChange(PropertyChangeEvent evt) {
		totalincome = ((Number)totalincomeFTF.getValue()).doubleValue();
		totalnetincome();
	}
	protected void do_totalexpensesFTF_propertyChange(PropertyChangeEvent evt) {
		totalexpenses = ((Number)totalexpensesFTF.getValue()).doubleValue();
		totalexpensesFTF.setForeground(Color.RED);
		totalnetincome();
	}
	protected void do_monthcomboBox_propertyChange(PropertyChangeEvent evt) {
		
	}
	protected void do_btnGoToNext_actionPerformed(ActionEvent arg0) {//setup non gray childpanel if criteria met
		

		if(txtFirstName.getText().isEmpty()||txtLastName.getText().isEmpty()||emailtextField.getText().isEmpty()||telcelFTF.getText().equals("(000)000-0000")||postalcodeFTF.getText().equals("00000")||adultspinner.getValue().toString().equals("0")){
			JOptionPane.showMessageDialog(this, "You are missing information please input information where lables are red. Then click go to next tab again.", "Missing Information", JOptionPane.ERROR_MESSAGE, null);
			if(txtFirstName.getText().isEmpty()){	
				lblFirstName.setForeground(Color.red);
				maintabbedPane.setEnabledAt(1, false);}
			else{lblFirstName.setForeground(Color.black);}
			if(addresstextField.getText().isEmpty()){	
				lblAddress.setForeground(Color.red);
				maintabbedPane.setEnabledAt(1, false);}
			else{lblAddress.setForeground(Color.black);}
			if(txtLastName.getText().isEmpty()){
				lblLastName.setForeground(Color.red);
				maintabbedPane.setEnabledAt(1, false);}
			else{lblLastName.setForeground(Color.black);}
			if(emailtextField.getText().isEmpty()){	
				lblEmail.setForeground(Color.red);
				maintabbedPane.setEnabledAt(1, false);}
			else{lblEmail.setForeground(Color.black);}
			if(telcelFTF.getText().equals("(000)000-0000")){
				lblTelCel.setForeground(Color.red);
				maintabbedPane.setEnabledAt(1, false);}
			else{lblTelCel.setForeground(Color.black);}
			if(postalcodeFTF.getText().equals("00000")){
				lblPostalCode.setForeground(Color.red);
				maintabbedPane.setEnabledAt(1, false);
			}else{lblPostalCode.setForeground(Color.black);
			}
			if(adultspinner.getValue().toString().equals("0")){
				lblOfAdults.setForeground(Color.red);
			}else{
				lblOfAdults.setForeground(Color.black);
				maintabbedPane.setEnabledAt(1, false);
			}
				}else{lblEmail.setForeground(Color.black);
				lblOfAdults.setForeground(Color.black);
				lblPostalCode.setForeground(Color.black);
				lblTelCel.setForeground(Color.black);
				lblLastName.setForeground(Color.black);
				lblFirstName.setForeground(Color.black);
				lblResidence.setForeground(Color.black);
				lblAddress.setForeground(Color.black);
					int dialogbutton = JOptionPane.showConfirmDialog(this, "<html>You are able to move onto next tab.<br>"
							+ "You will not be able to return to this tab latter.<br>Click No if you would like to look over your information again.<br>Otherwise Click Yes to continue"
							+ "</html>");
					if( dialogbutton == 0){		
			maintabbedPane.setEnabledAt(1, true);
			maintabbedPane.setEnabledAt(0, false);
			maintabbedPane.setSelectedIndex(1);
			int childtabs = Integer.parseInt(children017spinner.getModel().getValue().toString());
				if(childtabs < 6){childrentabbedPane.remove(5);
				child6panel.setEnabled(false);}
				if(childtabs < 5){childrentabbedPane.remove(4);
				child5panel.setEnabled(false);}
				if(childtabs < 4){childrentabbedPane.remove(3);
				child4panel.setEnabled(false);}
				if(childtabs < 3){childrentabbedPane.remove(2);
				child3panel.setEnabled(false);}
				if(childtabs < 2){childrentabbedPane.remove(1); 
				child2panel.setEnabled(false);}
					}
				}
	}
	public void checkifchildfill(){//Child fill checker set not filled values red and makes a popup
		if(child1firstnametextField.getText().isEmpty()||!rdbtnMale1.isSelected()&&!rdbtnFemale1.isSelected()||child2panel.isEnabled()&&child2firstnametextField.getText().isEmpty()||child2panel.isEnabled()&&(!rdbtnMale2.isSelected()&&!rdbtnFemale2.isSelected())||child3panel.isEnabled()&&child3firstnametextField.getText().isEmpty()||child3panel.isEnabled()&&(!rdbtnMale3.isSelected()&&!rdbtnFemale3.isSelected())||child4panel.isEnabled()&&child4firstnametextField.getText().isEmpty()||child4panel.isEnabled()&&(!rdbtnMale4.isSelected()&&!rdbtnFemale4.isSelected())||child5panel.isEnabled()&&child5firstnametextField.getText().isEmpty()||child5panel.isEnabled()&&(!rdbtnMale5.isSelected()&&!rdbtnFemale5.isSelected())||child6panel.isEnabled()&&child6firstnametextField.getText().isEmpty()||child6panel.isEnabled()&&(!rdbtnMale6.isSelected()&&!rdbtnFemale6.isSelected())){
		JOptionPane.showMessageDialog(this, "<html> You are missing information please input information where lables are red. <br>Also check other Child tabs if any.<br> Then click go to next tab again.</html>", "Missing Information", JOptionPane.ERROR_MESSAGE, null);
		if(child1firstnametextField.getText().isEmpty()){
			lblChild1FirstName.setForeground(Color.red);
			maintabbedPane.setEnabledAt(2, false);}else{
			lblChild1FirstName.setForeground(Color.black);
			}
		if(!rdbtnMale1.isSelected()&&!rdbtnFemale1.isSelected()){
			lblMaleFemale1.setForeground(Color.red);
		}else{
			lblMaleFemale1.setForeground(Color.black);
		}
	
	if(child2panel.isEnabled()){
		if(child2firstnametextField.getText().isEmpty()){
			lblChild2FirstName.setForeground(Color.red);
			maintabbedPane.setEnabledAt(2, false);}else{
			lblChild2FirstName.setForeground(Color.black);
			}
		if(!rdbtnMale2.isSelected()&&!rdbtnFemale2.isSelected()){
			lblMaleFemale2.setForeground(Color.red);
		}else{
			lblMaleFemale2.setForeground(Color.black);
		}	
	} if(child3panel.isEnabled()){
		if(child3firstnametextField.getText().isEmpty()){
			lblChild3FirstName.setForeground(Color.red);
			maintabbedPane.setEnabledAt(2, false);}else{
			lblChild3FirstName.setForeground(Color.black);
			}
		if(!rdbtnMale3.isSelected()&&!rdbtnFemale3.isSelected()){
			lblMaleFemale3.setForeground(Color.red);
		}else{
			lblMaleFemale3.setForeground(Color.black);
		}	
	}if(child4panel.isEnabled()){
		if(child4firstnametextField.getText().isEmpty()){
			lblChild4FirstName.setForeground(Color.red);
			maintabbedPane.setEnabledAt(2, false);}else{
			lblChild4FirstName.setForeground(Color.black);
			}
		if(!rdbtnMale4.isSelected()&&!rdbtnFemale2.isSelected()){
			lblMaleFemale4.setForeground(Color.red);
		}else{
			lblMaleFemale4.setForeground(Color.black);
		}	
	}if(child5panel.isEnabled()){
		if(child5firstnametextField.getText().isEmpty()){
			lblChild5FirstName.setForeground(Color.red);
			maintabbedPane.setEnabledAt(2, false);}else{
			lblChild5FirstName.setForeground(Color.black);
			}
		if(!rdbtnMale5.isSelected()&&!rdbtnFemale5.isSelected()){
			lblMaleFemale5.setForeground(Color.red);
		}else{
			lblMaleFemale5.setForeground(Color.black);
		}	
	}if(child6panel.isEnabled()){
		if(child6firstnametextField.getText().isEmpty()){
			lblChild6FirstName.setForeground(Color.red);
			maintabbedPane.setEnabledAt(2, false);}else{
			lblChild6FirstName.setForeground(Color.black);
			}
		if(!rdbtnMale6.isSelected()&&!rdbtnFemale6.isSelected()){
			lblMaleFemale6.setForeground(Color.red);
		}else{
			lblMaleFemale6.setForeground(Color.black);
		}	
	}}else{
	lblChild1FirstName.setForeground(Color.black);
	lblMaleFemale1.setForeground(Color.black);
	lblChild2FirstName.setForeground(Color.black);
	lblMaleFemale2.setForeground(Color.black);
	lblChild3FirstName.setForeground(Color.black);
	lblMaleFemale3.setForeground(Color.black);
	lblChild4FirstName.setForeground(Color.black);
	lblMaleFemale4.setForeground(Color.black);
	lblChild5FirstName.setForeground(Color.black);
	lblMaleFemale5.setForeground(Color.black);
	lblChild6FirstName.setForeground(Color.black);
	lblMaleFemale6.setForeground(Color.black);
	int dialogbutton = JOptionPane.showConfirmDialog(this, "<html>You are able to move onto next tab.<br>"
			+ "You will not be able to return to this tab latter.<br>Click No if you would like to look over your information again.<br>Otherwise Click Yes to continue"
			+ "</html>");
	if( dialogbutton == 0){		
	maintabbedPane.setSelectedIndex(2);
	maintabbedPane.setEnabledAt(2, true);
	maintabbedPane.setEnabledAt(1, false);}
	}
}
	protected void do_btnGoToNext_1_actionPerformed(ActionEvent arg0) {//call child panel checker
		checkifchildfill();
	}
	protected void do_mntmStartNewForm_actionPerformed(ActionEvent arg0) {//reset file
		this.dispose();
		ZwartSACAPframe frame = new ZwartSACAPframe();
		frame.setVisible(true);
	
	}
	protected void do_mntmApplicationInfo_actionPerformed(ActionEvent arg0) {//help for application
		JOptionPane.showMessageDialog(this,"<html>Last Name: Enter Last Name <br> "
				+ "First Name: Enter First Name <br> Address: enter Address"
				+ "<br>Postal code: enter 5 digit postalcode <br>"
				+ "Residence: Choose residence if not there type in yours <br> Tel/Cel: Put in phone number <br> Email: Put in Email<br> Adults: put in number of adults in family<br># of Children 18+: Put in amount of children over 18 <br> # of Children 0-17: Put in number of children under 18 years of age. min 1 max 6"
				+ "</html>");
	}
	protected void do_mntmChildInfo_actionPerformed(ActionEvent e) {//help for child info
		JOptionPane.showMessageDialog(this, "<html>Child First Name: Enter Child's First Name<br> Male/Female: Choose male or femal<br>"
				+ "Birdate: enter mm/dd/yyyy<br> Age: scroll to Child's age <br>Clothing Size: pick childs clothing size<br>Coat Size: pick child's coat size <br> Game System: Click on game systems the child owns Ctrl+click for multiple <br>Child's Interests: Select Child's interests Ctrl click for multiple</html>");
	}
	protected void do_mntmFinancialInfo_actionPerformed(ActionEvent e) { //help for Financial info
		JOptionPane.showMessageDialog(this, "<html><b>All Values Must Be Put Behind a $ </b><br> Under Income enter values requested <br>"
				+ "Total income cannot be change"
				+ "<br> Under Expenses enter desired expenses. <br>Rent/Mortage: must select either rent or mortgage. <br>Total Expenses cannot be edited.<br>"
				+ "Total net income cannot be edited<html>");
	}
	protected void do_btnSubmit_actionPerformed(ActionEvent e) {//submitted values dialog
		JOptionPane.showMessageDialog(this, "successfully submitted");
	}
	protected void do_btnGoToFinancial2_actionPerformed(ActionEvent e) {//call child pane fill checker
		checkifchildfill();
	}
	protected void do_btnGoToFinancial3_actionPerformed(ActionEvent e) {//call childpane fill checker
		checkifchildfill();
	}
	protected void do_btnGoToFinancial4_actionPerformed(ActionEvent e) {//call childpane fill checker
		checkifchildfill();
	}
	protected void do_btnGoToFinancial5_actionPerformed(ActionEvent e) {//call child pane fillchecker
		checkifchildfill();
	}
	protected void do_btnGoToFinancial6_actionPerformed(ActionEvent e) {//call child pane fill checker
		checkifchildfill();
	}
}
	
