import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame {
	private int accountIndexUsed;
	private JTextField textField;
	private JTextField textField_1;
	
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { //using a try-catch allows the program to robustly attempt running the GUI
					GUI realEstateTrackerFrame = new GUI();
					realEstateTrackerFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUI() throws IOException {    	    
		setTitle("Real Estate Tracker"); //GUI extends JFrame so these methods reference the GUI object
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setSize(750,475);
		setResizable(false); //ensures all components are always visible  (requested by client)
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel loginPane = new JPanel();
		loginPane.setForeground(Color.BLACK);
		getContentPane().add(loginPane, "Login Pane");
		loginPane.setLayout(null);
		
		JPanel mainMenuPane = new JPanel();
		getContentPane().add(mainMenuPane, "Main Menu Pane");
		mainMenuPane.setLayout(null);
		
		JPanel newProjectPane = new JPanel();
		getContentPane().add(newProjectPane, "New Project Pane");
		newProjectPane.setLayout(null);
		
		JPanel projectPane = new JPanel();
		getContentPane().add(projectPane, "Project Pane");
		projectPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 60, 744, 386);
		projectPane.add(tabbedPane);
		
			JPanel detailsPanel = new JPanel();
			tabbedPane.addTab("Details", null, detailsPanel, null);
			detailsPanel.setLayout(null);
			
				JLabel projectAddressLabel = new JLabel("Address: ");
				projectAddressLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectAddressLabel.setBounds(25, 20, 91, 16);
				detailsPanel.add(projectAddressLabel);
				
				JLabel projectCityLabel = new JLabel("City: ");
				projectCityLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectCityLabel.setBounds(25, 40, 91, 16);
				detailsPanel.add(projectCityLabel);
				
				JLabel projectStateLabel = new JLabel("State: ");
				projectStateLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectStateLabel.setBounds(25, 60, 91, 16);
				detailsPanel.add(projectStateLabel);
				
				JLabel projectTotalLotsInDevelopmentLabel = new JLabel("Total Lots in Development: ");
				projectTotalLotsInDevelopmentLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectTotalLotsInDevelopmentLabel.setBounds(25, 100, 159, 16);
				detailsPanel.add(projectTotalLotsInDevelopmentLabel);
				
				JLabel projectTotalLotsDevelopedToDateLabel = new JLabel("Total Lots Developed To Date: ");
				projectTotalLotsDevelopedToDateLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectTotalLotsDevelopedToDateLabel.setBounds(25, 120, 178, 16);
				detailsPanel.add(projectTotalLotsDevelopedToDateLabel);
				
				JLabel projectTotalLotsUnderConstrustionLabel = new JLabel("Total Lots Under Construction: ");
				projectTotalLotsUnderConstrustionLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectTotalLotsUnderConstrustionLabel.setBounds(25, 140, 178, 16);
				detailsPanel.add(projectTotalLotsUnderConstrustionLabel);
				
				JLabel projectTotalLotsRemainingLabel = new JLabel("Total Lots Remaining: ");
				projectTotalLotsRemainingLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectTotalLotsRemainingLabel.setBounds(25, 160, 130, 16);
				detailsPanel.add(projectTotalLotsRemainingLabel);
				
				JLabel projectLotsSoldWithinLast30DaysLabel = new JLabel("Lots Sold Within the Last 30 Days: ");
				projectLotsSoldWithinLast30DaysLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectLotsSoldWithinLast30DaysLabel.setBounds(25, 200, 197, 16);
				detailsPanel.add(projectLotsSoldWithinLast30DaysLabel);
				
				JLabel projectSelloutLabel = new JLabel("Project Sellout: ");
				projectSelloutLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectSelloutLabel.setBounds(25, 220, 106, 16);
				detailsPanel.add(projectSelloutLabel);
				
				JLabel projectAvgCostPerLotLabel = new JLabel("Average Cost Per Lot: ");
				projectAvgCostPerLotLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectAvgCostPerLotLabel.setBounds(25, 260, 144, 16);
				detailsPanel.add(projectAvgCostPerLotLabel);
				
				JLabel projectAvgPricePerLotLabel = new JLabel("Average Sales Price Per Lot: ");
				projectAvgPricePerLotLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectAvgPricePerLotLabel.setBounds(25, 280, 178, 16);
				detailsPanel.add(projectAvgPricePerLotLabel);
				
				JLabel projectTotalRemainingRevenueLabel = new JLabel("Total Remaining Revenue: ");
				projectTotalRemainingRevenueLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectTotalRemainingRevenueLabel.setBounds(25, 300, 178, 16);
				detailsPanel.add(projectTotalRemainingRevenueLabel);
				
				JLabel projectProjectedRemainingProfitLabel = new JLabel("Projected Remaining Profit: ");
				projectProjectedRemainingProfitLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
				projectProjectedRemainingProfitLabel.setBounds(25, 320, 197, 16);
				detailsPanel.add(projectProjectedRemainingProfitLabel);
				
				JButton btnEdit = new JButton("Edit");
				btnEdit.setBounds(622, 317, 89, 23);
				detailsPanel.add(btnEdit);
				
				JLabel lblPartnersInvolved = new JLabel("Partners Involved");
				lblPartnersInvolved.setBounds(475, 13, 178, 23);
				lblPartnersInvolved.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
				detailsPanel.add(lblPartnersInvolved);
				
				JLabel[] projectData = new JLabel[16];
				for(int x=0;x<projectData.length;x++) {
					projectData[x] = new JLabel("This is a test message");
					detailsPanel.add(projectData[x]);
					projectData[x].setFont(new Font("Times New Roman", Font.BOLD, 12));}
				projectData[0].setBounds(231, 20, 200, 16);
				projectData[1].setBounds(231, 40, 91, 16);
				projectData[2].setBounds(231, 60, 91, 16);
				projectData[3].setBounds(231, 100, 91, 16);
				projectData[4].setBounds(231, 120, 91, 16);
				projectData[5].setBounds(231, 140, 91, 16);
				projectData[6].setBounds(231, 160, 91, 16);
				projectData[7].setBounds(231, 200, 91, 16);
				projectData[8].setBounds(231, 220, 91, 16);
				projectData[9].setBounds(231, 260, 91, 16);
				projectData[10].setBounds(231, 280, 91, 16);
				projectData[11].setBounds(231, 300, 91, 16);
				projectData[12].setBounds(231, 320, 91, 16);
				projectData[13].setBounds(270, 120, 91, 16);
				projectData[14].setBounds(270, 140, 91, 16);
				projectData[15].setBounds(270, 160, 91, 16);
				
				JLabel[] partnersInvoled = new JLabel[10];
				for(int x=0;x<10;x++) {
					partnersInvoled[x] = new JLabel("Partner Involed");
					partnersInvoled[x].setFont(new Font("Times New Roman", Font.BOLD, 12));
					partnersInvoled[x].setBounds(485, 40+(x*20), 200, 15);
				}
			
			JPanel tasksPanel = new JPanel();
			tabbedPane.addTab("Tasks", null, tasksPanel, null);
			tasksPanel.setLayout(null);
				
				JLabel lblCreateNewTask = new JLabel("Create New Task");
				lblCreateNewTask.setBounds(10, 291, 206, 28);
				lblCreateNewTask.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
				tasksPanel.add(lblCreateNewTask);
			
				JLabel lblTask = new JLabel("Task");
				lblTask.setBounds(10, 330, 46, 14);
				lblTask.setFont(new Font("Times New Roman", Font.BOLD, 12));
				tasksPanel.add(lblTask);
				
				JLabel lblContractor = new JLabel("Contractor");
				lblContractor.setBounds(176, 330, 74, 14);
				lblContractor.setFont(new Font("Times New Roman", Font.BOLD, 12));
				tasksPanel.add(lblContractor);
				
				JLabel lblProjectedCompletion = new JLabel("Projected Completion");
				lblProjectedCompletion.setBounds(367, 330, 125, 14);
				lblProjectedCompletion.setFont(new Font("Times New Roman", Font.BOLD, 12));
				tasksPanel.add(lblProjectedCompletion);
				
				JComboBox tasksComboBox = new JComboBox();
				tasksComboBox.setModel(new DefaultComboBoxModel(new String[] {" ", "Aminity", "Furniture", "Landscaping", "Mailboxes"}));
				tasksComboBox.setBounds(48, 327, 111, 20);
				tasksPanel.add(tasksComboBox);
				
				JTextField contractorTextField = new JTextField();
				contractorTextField.setBounds(242, 327, 111, 20);
				tasksPanel.add(contractorTextField);
				contractorTextField.setColumns(10);
				
				JTextField projCompMMTextField = new JTextField();
				projCompMMTextField.setBounds(488, 327, 31, 20);
				tasksPanel.add(projCompMMTextField);
				projCompMMTextField.setColumns(10);
				
				JTextField projCompDDTextField = new JTextField();
				projCompDDTextField.setColumns(10);
				projCompDDTextField.setBounds(529, 327, 31, 20);
				tasksPanel.add(projCompDDTextField);
				
				JTextField projCompYYYYTextField = new JTextField();
				projCompYYYYTextField.setColumns(10);
				projCompYYYYTextField.setBounds(570, 327, 65, 20);
				tasksPanel.add(projCompYYYYTextField);
				
				JButton btnExport = new JButton("Export");
				btnExport.setBounds(641, 279, 87, 23);
				tasksPanel.add(btnExport);
				
				JButton btnAdd = new JButton("Add");
				btnAdd.setBounds(657, 327, 57, 20);
				tasksPanel.add(btnAdd);
				
				String[] columnNames = {"Task","Contractor","Projected Completion"};
				DefaultTableModel tasksTableModel = new DefaultTableModel(columnNames,0){
				    //makes cells uneditable by ovveriding DefaultTableModel's isCellEditable() method
					public boolean isCellEditable(int rows, int columns) {return false;}
				};
				
				JTable tasksTable = new JTable(tasksTableModel);
				tasksTable.setBounds(10, 11, 719, 270);
				tasksTable.getTableHeader().setReorderingAllowed(false);
				tasksPanel.add(tasksTable);
				
				JScrollPane scrollpane = new JScrollPane(tasksTable);
				scrollpane.setBounds(10, 11, 719, 270);
				tasksPanel.add(scrollpane);
			
			JPanel commentsPanel = new JPanel();
			tabbedPane.addTab("Comments", null, commentsPanel, null);
			commentsPanel.setLayout(null);
			
				JLabel lblCreateNewComment = new JLabel("Create New");
				lblCreateNewComment.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
				lblCreateNewComment.setBounds(10, 292, 128, 28);
				commentsPanel.add(lblCreateNewComment);
				
				JLabel lblCreateNewCommentpt2 = new JLabel("Comment");
				lblCreateNewCommentpt2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
				lblCreateNewCommentpt2.setBounds(10, 319, 128, 28);
				commentsPanel.add(lblCreateNewCommentpt2);
				
				JButton btnSubmit_1 = new JButton("Submit");
				btnSubmit_1.setBounds(640, 309, 89, 23);
				commentsPanel.add(btnSubmit_1);
				
				JPanel commentBorderPanel = new JPanel();
				commentBorderPanel.setBackground(Color.GRAY);
				commentBorderPanel.setBounds(137, 292, 493, 60);
				commentsPanel.add(commentBorderPanel);
				commentBorderPanel.setLayout(null);
				
				JTextArea commentTextArea = new JTextArea();
				commentTextArea.setBounds(2, 2, 489, 56);
				//commentBorderPanel.add(commentTextArea);
				commentTextArea.setBackground(Color.WHITE);
				commentTextArea.setLineWrap(true);
					JScrollPane commentTextareaScrollPane = new JScrollPane(commentTextArea, 
																			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
																			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					commentTextareaScrollPane.setBounds(2, 2, 489, 56);
					commentBorderPanel.add(commentTextareaScrollPane);
					
					
				JLabel lblName = new JLabel("Name");
				lblName.setHorizontalAlignment(SwingConstants.TRAILING);
				lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
				lblName.setBounds(10, 1, 186, 20);
				commentsPanel.add(lblName);
				
				JLabel lblComment = new JLabel("Comment");
				lblComment.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
				lblComment.setBounds(211, 1, 158, 20);
				commentsPanel.add(lblComment);
				
				int numberOfCommentsSupported = 50;
				
					JPanel commentBoardPanel = new JPanel();
					commentBoardPanel.setLayout(null);
					commentBoardPanel.setBounds(10, 20, 719, 20+(30*numberOfCommentsSupported));  
					commentBoardPanel.setPreferredSize(new Dimension(719,(20+(30*numberOfCommentsSupported))));
					
					JLabel[] nameLabelArray = new JLabel[numberOfCommentsSupported];
					JLabel[] commentLabelArray = new JLabel[numberOfCommentsSupported];
						for(int x=0;x<numberOfCommentsSupported;x++) {
							nameLabelArray[x] = new JLabel("This is a name #"+x);
							nameLabelArray[x].setBounds(10, 10+(30*x), 175, 15);
							nameLabelArray[x].setFont(new Font("Times New Roman", Font.BOLD, 12));
							nameLabelArray[x].setHorizontalAlignment(SwingConstants.TRAILING);
							nameLabelArray[x].setVisible(false);
							commentBoardPanel.add(nameLabelArray[x]);
							
							commentLabelArray[x] = new JLabel("This is a comment #"+x);
							commentLabelArray[x].setBounds(200, 10+(30*x), 500, 15);
							commentLabelArray[x].setFont(new Font("Times New Roman", Font.BOLD, 12));
							commentLabelArray[x].setVisible(false);
							commentBoardPanel.add(commentLabelArray[x]);
						}
					
					JScrollPane commentGridScrollPane = new JScrollPane(commentBoardPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					commentGridScrollPane.setBounds(10, 20, 719, 250);
					commentGridScrollPane.setPreferredSize(new Dimension(719,250));
					commentsPanel.add(commentGridScrollPane);
				
			JPanel problemsPanel = new JPanel();
			tabbedPane.addTab("Problems", null, problemsPanel, null);
			problemsPanel.setLayout(null);
			
				JLabel lblCreateNewproblem = new JLabel("Add New problem");
				lblCreateNewproblem.setBounds(10, 291, 206, 28);
				lblCreateNewproblem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
				problemsPanel.add(lblCreateNewproblem);
			
				JLabel lblproblem = new JLabel("Title");
				lblproblem.setBounds(10, 330, 46, 14);
				lblproblem.setFont(new Font("Times New Roman", Font.BOLD, 12));
				problemsPanel.add(lblproblem);
				
				String[] problemColumnNames = {"Title","Description","Priority"};
				DefaultTableModel problemsTableModel = new DefaultTableModel(problemColumnNames,0){
				    //makes cells uneditable by ovveriding DefaultTableModel's isCellEditable() method
					public boolean isCellEditable(int rows, int columns) {return false;}
				};
				
				JTable problemsTable = new JTable(problemsTableModel);
				problemsTable.setBounds(10, 11, 719, 270);
				problemsTable.getTableHeader().setReorderingAllowed(false);
				problemsPanel.add(problemsTable);
				
				JScrollPane scrollpaneProblems = new JScrollPane(problemsTable);
				scrollpaneProblems.setBounds(10, 11, 719, 270);
				problemsPanel.add(scrollpaneProblems);
				
				JTextField titleTextField = new JTextField();
				titleTextField.setBounds(48, 327, 117, 20);
				problemsPanel.add(titleTextField);
				titleTextField.setColumns(10);
				
				JLabel lblDescription = new JLabel("Description");
				lblDescription.setFont(new Font("Times New Roman", Font.BOLD, 12));
				lblDescription.setBounds(192, 330, 72, 14);
				problemsPanel.add(lblDescription);
				
				JTextField descriptionTextField = new JTextField();
				descriptionTextField.setBounds(274, 327, 206, 20);
				problemsPanel.add(descriptionTextField);
				descriptionTextField.setColumns(10);
				
				JLabel lblPriority = new JLabel("Priority");
				lblPriority.setFont(new Font("Times New Roman", Font.BOLD, 12));
				lblPriority.setBounds(507, 330, 52, 14);
				problemsPanel.add(lblPriority);
				
				JComboBox priorityComboBox = new JComboBox();
				priorityComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
				priorityComboBox.setBounds(559, 327, 44, 20);
				problemsPanel.add(priorityComboBox);
				
				JButton btnAddProblem = new JButton("Add");
				btnAddProblem.setBounds(640, 326, 89, 23);
				problemsPanel.add(btnAddProblem);
				
				JButton btnRecommendAProblem = new JButton("Solve a Problem");
				btnRecommendAProblem.setBounds(559, 291, 170, 23);
				problemsPanel.add(btnRecommendAProblem);
				
				
			
				
		JLabel lblNewProjectTitle = new JLabel("New Project");
		lblNewProjectTitle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		lblNewProjectTitle.setBounds(71, 0, 235, 49);
		newProjectPane.add(lblNewProjectTitle);
		
		JButton btnBack = new JButton("\u2190");
		btnBack.setToolTipText("Going to the main menu won't delete your data");
		btnBack.setBounds(12, 12, 46, 19);
		newProjectPane.add(btnBack);
		btnBack.setFocusPainted(false);
		
		JLabel lblProjectName = new JLabel("Project Name:");
		lblProjectName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblProjectName.setBounds(12, 102, 91, 16);
		newProjectPane.add(lblProjectName);
		
		JTextField projectNameTextfield = new JTextField();
		projectNameTextfield.setBounds(96, 99, 167, 20);
		newProjectPane.add(projectNameTextfield);
		projectNameTextfield.setColumns(10);
		
		JLabel lblAdress = new JLabel("Adress: ");
		lblAdress.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAdress.setBounds(12, 133, 91, 16);
		newProjectPane.add(lblAdress);
		
		JTextField adressTextfield = new JTextField();
		adressTextfield.setColumns(10);
		adressTextfield.setBounds(96, 130, 167, 20);
		newProjectPane.add(adressTextfield);
		
		JLabel lblCity = new JLabel("City: ");
		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCity.setBounds(12, 164, 91, 16);
		newProjectPane.add(lblCity);
		
		JTextField cityTextfield = new JTextField();
		cityTextfield.setColumns(10);
		cityTextfield.setBounds(96, 161, 167, 20);
		newProjectPane.add(cityTextfield);
		
		JLabel lblState = new JLabel("State: ");
		lblState.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblState.setBounds(12, 194, 91, 16);
		newProjectPane.add(lblState);
		
		JTextField stateTextfield = new JTextField();
		stateTextfield.setColumns(10);
		stateTextfield.setBounds(96, 192, 167, 20);
		newProjectPane.add(stateTextfield);
		
		JLabel lblTotalLotsInDev = new JLabel("Total lots in development: ");
		lblTotalLotsInDev.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTotalLotsInDev.setBounds(12, 225, 147, 16);
		newProjectPane.add(lblTotalLotsInDev);
		
		JTextField totalLotsInDevTextfield = new JTextField();
		totalLotsInDevTextfield.setColumns(10);
		totalLotsInDevTextfield.setBounds(188, 222, 75, 20);
		newProjectPane.add(totalLotsInDevTextfield);
		
		JLabel lblPartersInvolved = new JLabel("Parters Involved: ");
		lblPartersInvolved.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPartersInvolved.setBounds(12, 269, 104, 16);
		newProjectPane.add(lblPartersInvolved);
		
		JCheckBox chckbxAccount[] = new JCheckBox[9];
		for(int x = 0; x < chckbxAccount.length; x++) {
			chckbxAccount[x] = new JCheckBox();
			if(x<5) chckbxAccount[x].setBounds(22,293+28*x,132,24);
			else chckbxAccount[x].setBounds(172, 293+28*(x-5), 132, 24);
			newProjectPane.add(chckbxAccount[x]);
		}
	
		JLabel lblTotalDevelopedTo = new JLabel("Total lots developed to date: ");
		lblTotalDevelopedTo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTotalDevelopedTo.setBounds(316, 101, 167, 16);
		newProjectPane.add(lblTotalDevelopedTo);
		
		JTextField lblTotalDevelopedTextfield = new JTextField();
		lblTotalDevelopedTextfield.setColumns(10);
		lblTotalDevelopedTextfield.setBounds(482, 99, 167, 20);
		newProjectPane.add(lblTotalDevelopedTextfield);
		
		JLabel TotalLotsUnderConstruction = new JLabel("Total lots under construction:  ");
		TotalLotsUnderConstruction.setFont(new Font("Times New Roman", Font.BOLD, 12));
		TotalLotsUnderConstruction.setBounds(316, 132, 167, 16);
		newProjectPane.add(TotalLotsUnderConstruction);
		
		JTextField totalLotsUnderConstructionTextfield = new JTextField();
		totalLotsUnderConstructionTextfield.setColumns(10);
		totalLotsUnderConstructionTextfield.setBounds(482, 130, 167, 20);
		newProjectPane.add(totalLotsUnderConstructionTextfield);
		
		JLabel lblTotalLotsRemaining = new JLabel("Total lots remaining:   ");
		lblTotalLotsRemaining.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTotalLotsRemaining.setBounds(316, 163, 167, 16);
		newProjectPane.add(lblTotalLotsRemaining);
		
		JTextField totalLotsRemainingTextfield = new JTextField();
		totalLotsRemainingTextfield.setColumns(10);
		totalLotsRemainingTextfield.setBounds(482, 161, 167, 20);
		newProjectPane.add(totalLotsRemainingTextfield);
		
		JLabel lblLotsSoldWithin = new JLabel("Lots sold within the last 30 days: ");
		lblLotsSoldWithin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLotsSoldWithin.setBounds(316, 193, 195, 16);
		newProjectPane.add(lblLotsSoldWithin);
		
		JTextField lotsSoldWithinTextfield = new JTextField();
		lotsSoldWithinTextfield.setColumns(10);
		lotsSoldWithinTextfield.setBounds(516, 191, 133, 20);
		newProjectPane.add(lotsSoldWithinTextfield);
		
		JLabel lblAverageCostPer = new JLabel("Average cost per lot:                 $");
		lblAverageCostPer.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAverageCostPer.setBounds(316, 225, 195, 16);
		newProjectPane.add(lblAverageCostPer);
		
		JTextField averageCostPerTextfield = new JTextField();
		averageCostPerTextfield.setColumns(10);
		averageCostPerTextfield.setBounds(482, 222, 167, 20);
		newProjectPane.add(averageCostPerTextfield);
		
		JLabel lblAveragePricePer = new JLabel("Average sales price per lot:     $");
		lblAveragePricePer.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAveragePricePer.setBounds(316, 250, 195, 16);
		newProjectPane.add(lblAveragePricePer);
		
		JTextField averagePricePerTextfield = new JTextField();
		averagePricePerTextfield.setColumns(10);
		averagePricePerTextfield.setBounds(482, 247, 167, 20);
		newProjectPane.add(averagePricePerTextfield);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(634, 404, 98, 26);
		newProjectPane.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(516, 404, 98, 26);
		newProjectPane.add(btnReset);
		
		JTextField usernameField = new JTextField();
		usernameField.setBounds(107, 156, 218, 20);
		loginPane.add(usernameField);
		usernameField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(107, 195, 218, 20);
		loginPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPassword.setBounds(35, 198, 62, 14);
		loginPane.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUsername.setBounds(35, 159, 62, 14);
		loginPane.add(lblUsername);
		
		JLabel lblIncorrectUandP = new JLabel("Incorrect username and password, please try again");
		lblIncorrectUandP.setForeground(Color.RED);
		lblIncorrectUandP.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIncorrectUandP.setBounds(27, 303, 358, 20);
		loginPane.add(lblIncorrectUandP);
		lblIncorrectUandP.setVisible(false);
		
		JLabel lblWelcome = new JLabel();
		lblWelcome.setText("Welcome client");
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		lblWelcome.setBounds(10, 0, 468, 62);
		mainMenuPane.add(lblWelcome);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(89, 258, 161, 23);
		loginPane.add(btnSubmit);
		
		JLabel lblRealEstate = new JLabel("Real Estate");
		lblRealEstate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 64));
		lblRealEstate.setBounds(390, 124, 310, 73);
		loginPane.add(lblRealEstate);
		
		JLabel labelTracker = new JLabel("Tracker");
		labelTracker.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 64));
		labelTracker.setBounds(434, 191, 298, 73);
		loginPane.add(labelTracker);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblLogin.setBounds(127, 116, 109, 28);
		loginPane.add(lblLogin);
		
		JLabel lblCurrentProjects = new JLabel("Current Projects");
		lblCurrentProjects.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCurrentProjects.setBounds(10, 135, 189, 27);
		mainMenuPane.add(lblCurrentProjects);
		
		JLabel lblNewProject = new JLabel("New Project");
		lblNewProject.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewProject.setBounds(453, 135, 189, 27);
		mainMenuPane.add(lblNewProject);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLogout.setBounds(453, 292, 189, 27);
		mainMenuPane.add(lblLogout);
		
		JButton btnLogout = new JButton("logout");
		btnLogout.setBounds(478, 330, 130, 23);
		mainMenuPane.add(btnLogout);
		
		JButton btnNewProject = new JButton("new project");
		btnNewProject.setBounds(478, 173, 130, 23);
		mainMenuPane.add(btnNewProject);
		
		JButton btnEventLog = new JButton("Event Log");
		btnEventLog.setBounds(616, 11, 118, 23);
		mainMenuPane.add(btnEventLog);
		
		JButton listOfProjectButtons[] = new JButton[50];
		for(int x = 0; x < listOfProjectButtons.length; x++) {
			listOfProjectButtons[x] = new JButton("EMPTY");
			listOfProjectButtons[x].setBounds(30, (170+(30*x)), 150, 25);
			mainMenuPane.add(listOfProjectButtons[x]);
			listOfProjectButtons[x].setVisible(false);
		}

		JLabel lblProjectTitle = new JLabel("Project X");
		lblProjectTitle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		lblProjectTitle.setBounds(71, 0, 496, 49);
		projectPane.add(lblProjectTitle);
		
		JButton btnBack1 = new JButton("\u2190");
		btnBack1.setBounds(12, 12, 46, 19);
		projectPane.add(btnBack1);
		btnBack1.setFocusPainted(false);
		
		JPanel editProjectPane = new JPanel();
		getContentPane().add(editProjectPane, "Edit Project Pane");
		editProjectPane.setLayout(null);
		
		JLabel lblEditProject = new JLabel("Edit Project");
		lblEditProject.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		lblEditProject.setBounds(71, 0, 235, 49);
		editProjectPane.add(lblEditProject);
		
		JButton editProjectPaneEditButton = new JButton("\u2190");
		editProjectPaneEditButton.setToolTipText("Going to the project menu WILL remove your revisions");
		editProjectPaneEditButton.setFocusPainted(false);
		editProjectPaneEditButton.setBounds(12, 12, 46, 19);
		editProjectPane.add(editProjectPaneEditButton);
		
		JLabel editProjectPaneProjectName = new JLabel("Project Name:");
		editProjectPaneProjectName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		editProjectPaneProjectName.setBounds(12, 102, 91, 16);
		editProjectPane.add(editProjectPaneProjectName);
		
		JTextField editProjectPaneProjectNameTextfield = new JTextField();
		editProjectPaneProjectNameTextfield.setColumns(10);
		editProjectPaneProjectNameTextfield.setBounds(96, 99, 167, 20);
		editProjectPane.add(editProjectPaneProjectNameTextfield);
		editProjectPaneProjectNameTextfield.setEditable(false);
		
		JLabel editProjectPaneAdress = new JLabel("Adress: ");
		editProjectPaneAdress.setFont(new Font("Times New Roman", Font.BOLD, 12));
		editProjectPaneAdress.setBounds(12, 133, 91, 16);
		editProjectPane.add(editProjectPaneAdress);
		
		JTextField editProjectPaneAdressTextfield = new JTextField();
		editProjectPaneAdressTextfield.setColumns(10);
		editProjectPaneAdressTextfield.setBounds(96, 130, 167, 20);
		editProjectPane.add(editProjectPaneAdressTextfield);
		editProjectPaneAdressTextfield.setEditable(false);
		
		JLabel editProjectPaneCity = new JLabel("City: ");
		editProjectPaneCity.setFont(new Font("Times New Roman", Font.BOLD, 12));
		editProjectPaneCity.setBounds(12, 164, 91, 16);
		editProjectPane.add(editProjectPaneCity);
		
		JTextField editProjectPaneCityTextfield = new JTextField();
		editProjectPaneCityTextfield.setColumns(10);
		editProjectPaneCityTextfield.setBounds(96, 161, 167, 20);
		editProjectPane.add(editProjectPaneCityTextfield);
		editProjectPaneCityTextfield.setEditable(false);
		
		JLabel editProjectPaneState = new JLabel("State: ");
		editProjectPaneState.setFont(new Font("Times New Roman", Font.BOLD, 12));
		editProjectPaneState.setBounds(12, 194, 91, 16);
		editProjectPane.add(editProjectPaneState);
		
		JTextField editProjectPaneStateTextfield = new JTextField();
		editProjectPaneStateTextfield.setColumns(10);
		editProjectPaneStateTextfield.setBounds(96, 192, 167, 20);
		editProjectPane.add(editProjectPaneStateTextfield);
		editProjectPaneStateTextfield.setEditable(false);
		
		JLabel editProjectPaneTLID = new JLabel("Total lots in development: ");
		editProjectPaneTLID.setFont(new Font("Times New Roman", Font.BOLD, 12));
		editProjectPaneTLID.setBounds(12, 225, 147, 16);
		editProjectPane.add(editProjectPaneTLID);
		
	    JTextField  editProjectPaneTLIDTextfield = new JTextField();
	    //editProjectPaneTLIDTextfield.setHorizontalAlignment(JTextField.RIGHT);
		editProjectPaneTLIDTextfield.setColumns(10);
		editProjectPaneTLIDTextfield.setBounds(188, 222, 75, 20);
		editProjectPane.add(editProjectPaneTLIDTextfield);
		
		JLabel editProjectPaneTLDTD = new JLabel("Total lots developed to date: ");
		editProjectPaneTLDTD.setFont(new Font("Times New Roman", Font.BOLD, 12));
		editProjectPaneTLDTD.setBounds(316, 101, 167, 16);
		editProjectPane.add(editProjectPaneTLDTD);
		
		JTextField editProjectPaneTLDTDTextfield = new JTextField();
		editProjectPaneTLDTDTextfield.setColumns(10);
		editProjectPaneTLDTDTextfield.setBounds(482, 99, 167, 20);
		editProjectPane.add(editProjectPaneTLDTDTextfield);
		
		JLabel editProjectPaneTLUC = new JLabel("Total lots under construction:  ");
		editProjectPaneTLUC.setFont(new Font("Times New Roman", Font.BOLD, 12));
		editProjectPaneTLUC.setBounds(316, 132, 167, 16);
		editProjectPane.add(editProjectPaneTLUC);
		
		JTextField editProjectPaneTLUCTextfield = new JTextField();
		editProjectPaneTLUCTextfield.setColumns(10);
		editProjectPaneTLUCTextfield.setBounds(482, 130, 167, 20);
		editProjectPane.add(editProjectPaneTLUCTextfield);
		
		JLabel editProjectPaneTLR = new JLabel("Total lots remaining:   ");
		editProjectPaneTLR.setFont(new Font("Times New Roman", Font.BOLD, 12));
		editProjectPaneTLR.setBounds(316, 163, 167, 16);
		editProjectPane.add(editProjectPaneTLR);
		
		JTextField editProjectPaneTLRTextfield = new JTextField();
		editProjectPaneTLRTextfield.setColumns(10);
		editProjectPaneTLRTextfield.setBounds(482, 161, 167, 20);
		editProjectPane.add(editProjectPaneTLRTextfield);
		
		JLabel editProjectPaneLSWTLTD = new JLabel("Lots sold within the last 30 days: ");
		editProjectPaneLSWTLTD.setFont(new Font("Times New Roman", Font.BOLD, 12));
		editProjectPaneLSWTLTD.setBounds(316, 193, 195, 16);
		editProjectPane.add(editProjectPaneLSWTLTD);
		
		JTextField editProjectPaneLSWTLTDTextfield = new JTextField();
		editProjectPaneLSWTLTDTextfield.setColumns(10);
		editProjectPaneLSWTLTDTextfield.setBounds(516, 191, 133, 20);
		editProjectPane.add(editProjectPaneLSWTLTDTextfield);
		
		JLabel editProjectPaneACPL = new JLabel("Average cost per lot:                 $");
		editProjectPaneACPL.setFont(new Font("Times New Roman", Font.BOLD, 12));
		editProjectPaneACPL.setBounds(316, 225, 195, 16);
		editProjectPane.add(editProjectPaneACPL);
		
		JTextField editProjectPaneACPLTextfield = new JTextField();
		editProjectPaneACPLTextfield.setColumns(10);
		editProjectPaneACPLTextfield.setBounds(482, 222, 167, 20);
		editProjectPane.add(editProjectPaneACPLTextfield);
		
		JLabel editProjectPaneAPPL = new JLabel("Average sales price per lot:     $");
		editProjectPaneAPPL.setFont(new Font("Times New Roman", Font.BOLD, 12));
		editProjectPaneAPPL.setBounds(316, 250, 195, 16);
		editProjectPane.add(editProjectPaneAPPL);
		
		JTextField editProjectPaneAPPLFextfield = new JTextField();
		editProjectPaneAPPLFextfield.setColumns(10);
		editProjectPaneAPPLFextfield.setBounds(482, 247, 167, 20);
		editProjectPane.add(editProjectPaneAPPLFextfield);
		
		JButton editProjectPaneSaveButton = new JButton("Save");
		editProjectPaneSaveButton.setBounds(634, 404, 98, 26);
		editProjectPane.add(editProjectPaneSaveButton);
		
		
		
/*
 * 
 * B A C K G R O U N D   P R O C E S S E S
 * 		
 */
	//ACCOUNT CREATOR
		//reads white list file and prints a list similar to the file's list
		FileReader accountWhitelist = new FileReader("accountWhitelist.txt");
		int charReader;
		int count=0;
		String[] accountStringList = new String[10];
		for(int x=0;x<10;x++) accountStringList[x]="";
	    while ((charReader=accountWhitelist.read()) != -1) { //accountWhiteList is entirely read
	    	if((char)charReader != ';')
	    		accountStringList[count]+=(char)charReader; //non semi colons are read and added
	    	if((char)charReader == ';') { //semi colons indicate the account has been completely read
	    		count++;} //changes the accountStringList index
	    }
	    accountWhitelist.close();
	    
	    //creates the new Account classes
	    Account[] account = new Account[10];
	    for(int x=0;x<10;x++) {
	    	StringTokenizer st = new StringTokenizer(accountStringList[x],":"); //splits each account's line using the colon delimiter
	    	String[] items=new String[4];
	    	for(int xx=0;xx<=3;xx++) items[xx]=st.nextToken(); //adds each data point to the array
	    	account[x] = new Account(Integer.parseInt(items[0].trim()),items[1],items[2],items[3]);
	    }
	    
	    //creates the event stack
	    EventScripter.buildStackFromEventLogFile();
						
/*
 * 
 * C L A S S E S 
 * 
 */
	    class DisplayData{
	    	public void projectData() {
	    		//READ DATA
	    		NumberFormat cf = NumberFormat.getCurrencyInstance();
	    		//^creates a currency number formatter for financial data values
	    		String input = lblProjectTitle.getText();
	    		StringTokenizer st = new StringTokenizer(input);
	    		String nameBuilder="";
	    		while(st.hasMoreTokens()) nameBuilder+=st.nextToken();
	    		//^creates the project's data name through tokenizing the title label
	    		File projectDataFile = new File(nameBuilder+"Data.txt");
	    		Scanner reader=null;
					try {reader = new Scanner(projectDataFile);}
					catch (FileNotFoundException e) {e.printStackTrace();}
	    		reader.nextLine();
	    		//^creates a scanner for the project's data file
				
	    		for(int x=0;x<=7;x++) projectData[x].setText(reader.nextLine());
	    		//^the first seven data points are directly converted into labels
				
				double totalRemaining = (Integer.parseInt(projectData[5].getText()) + 
										 Integer.parseInt(projectData[6].getText()));
				//^calculates a total remaining value, used in future calculations
				
				int selloutInteger = (int) Math.ceil(totalRemaining / 
										   Integer.parseInt(projectData[7].getText()));
				//^calculates the maximum number of months needed to completely sell out
				String selloutString =""+selloutInteger;
				projectData[8].setText(selloutString+" months");
				//^converts calculated number into a string and into a label
				
				double[] costsUnformatted = new double[2];
				for(int x=9;x<=10;x++){ //reads specifically 2 lines
					double value = Double.parseDouble(reader.nextLine());
					//^reads two lines
					costsUnformatted[x-9]=value;
					projectData[x].setText(""+cf.format(value));
					//^converts the data into currencies and puts them into labels
				}
	    		
				double revenue = totalRemaining * costsUnformatted[1];
				projectData[11].setText(""+cf.format(revenue));
				//^calculates total revenue and places it in a label
				
				double profit = costsUnformatted[1] - costsUnformatted[0];
				double totalProfit = profit * totalRemaining;
				projectData[12].setText(""+cf.format(totalProfit));
				//^subtracts costs from revenue to calculate profit; places in label
				
				double percentDeveloped = (Double.parseDouble(projectData[4].getText()) /
										   Double.parseDouble(projectData[3].getText()))*100;
				percentDeveloped = Math.round(percentDeveloped*100)/100;
				projectData[13].setText("("+(int)percentDeveloped+"%)");
				//^calculates the percentage of properties that are in development
				
				double percentUnderConstruction = (Double.parseDouble(projectData[5].getText()) /
												   Double.parseDouble(projectData[3].getText()))*100;
				percentUnderConstruction = Math.round(percentUnderConstruction*100)/100;
				projectData[14].setText("("+(int)percentUnderConstruction+"%)");
				//^calculates the percentage of properties that are under construction
				
				double percentRemaining = (Double.parseDouble(projectData[6].getText()) /
										   Double.parseDouble(projectData[3].getText()))*100;
				percentRemaining = Math.round(percentRemaining*100)/100;
				projectData[15].setText("("+(int)percentRemaining+"%)");
				//^calculates the percentage of properties that are remaining
				
				reader.close();
				
				//FIND PARTNERS INVOLVED
				File projectAccountFile = new File(nameBuilder+"Accounts.txt");
				Scanner r1=null;
					try {r1 = new Scanner(projectAccountFile);}
					catch (FileNotFoundException e) {e.printStackTrace();}
				//^creates a new scanner in the project's account file
				ArrayList<String> accountNames = new ArrayList<String>();
				while(r1.hasNextLine()) accountNames.add(r1.nextLine());
				//^makes an ArrayList containing all the accounts involved in the project
				int JLabelCounter = 0;
				for(int x=0;x<accountNames.size();x++) {
					partnersInvoled[x].setText("- "+accountNames.get(x));
					partnersInvoled[x].setVisible(true);
					detailsPanel.add(partnersInvoled[x]);
					JLabelCounter++;
					//^makes partnersInvoled labels only visible for the needed partners
				}
				for(int x = JLabelCounter;x<10;x++){
					partnersInvoled[x].setVisible(false);
					//^ensures the rest are reset and non-visible
				}
				r1.close();
	    	}
	    	
	    	public void editProjectData(){
	    		StringTokenizer st = new StringTokenizer(lblProjectTitle.getText());
	    		String nameBuilder="";
	    		while(st.hasMoreTokens()) nameBuilder+=st.nextToken();
	    		//^builds the project's name based on the project's title label
	    		
	    		File projectDataFile = new File(nameBuilder+"Data.txt");
	    		Scanner r1=null;
					try {r1 = new Scanner(projectDataFile);}
					catch (FileNotFoundException e) {e.printStackTrace();}
				//^makes a scanner for the project's data file
				editProjectPaneProjectNameTextfield.setText(r1.nextLine());
				editProjectPaneAdressTextfield.setText(r1.nextLine());
				editProjectPaneCityTextfield.setText(r1.nextLine());
				editProjectPaneStateTextfield.setText(r1.nextLine());
				editProjectPaneTLIDTextfield.setText(r1.nextLine());
				editProjectPaneTLDTDTextfield.setText(r1.nextLine());
				editProjectPaneTLUCTextfield.setText(r1.nextLine());
				editProjectPaneTLRTextfield.setText(r1.nextLine());
				editProjectPaneLSWTLTDTextfield.setText(r1.nextLine());
				editProjectPaneACPLTextfield.setText(r1.nextLine());
				editProjectPaneAPPLFextfield.setText(r1.nextLine());
				//^transfers each line in the file to the according textfield
				r1.close();
					
	    		editProjectPane.setVisible(true);
	    		projectPane.setVisible(false);
	    		//^sets the edit project pane visible, after the textfields have been filled
	    	}
	    } DisplayData displayData = new DisplayData();
	    
	    
	    //class used to clear JPanels and their components, such as text boxes and check boxes
	    class Clear {	
			public void loginPage() {
				passwordField.setText("");
				lblIncorrectUandP.setVisible(false);
			}
			public void newProjectPage() {
				projectNameTextfield.setText("");
				adressTextfield.setText("");
				cityTextfield.setText("");
				stateTextfield.setText("");
				totalLotsInDevTextfield.setText("");
				lblTotalDevelopedTextfield.setText("");
				totalLotsUnderConstructionTextfield.setText("");
				totalLotsRemainingTextfield.setText("");
				lotsSoldWithinTextfield.setText("");
				averageCostPerTextfield.setText("");
				averagePricePerTextfield.setText("");
				//^clears all the text fields
				for(JCheckBox x : chckbxAccount) x.setSelected(false);
				//^clears all the partner involved checkboxes
			}
			public void newTasks(){
				projCompDDTextField.setText("");
				projCompMMTextField.setText("");
				projCompYYYYTextField.setText("");
				contractorTextField.setText("");
				tasksComboBox.setSelectedItem(" ");
			}
			public void newProblems(){
				titleTextField.setText("");
				descriptionTextField.setText("");
				priorityComboBox.setSelectedItem("1");
			}
		} /*Creates an instance of the Clear class for the rest of the program*/ Clear clear = new Clear();
		
		JButton[] aryBtnProject = new JButton[15];
		for(int x=0;x<15;x++) {
			aryBtnProject[x] = new JButton();
			aryBtnProject[x].setText("BUTTON");
			aryBtnProject[x].setFont(new Font("Times New Roman", Font.BOLD, 14));
			aryBtnProject[x].setBounds(44, (174+(35*x)), 200, 20);
			aryBtnProject[x].setVisible(true);
		}
		
		class ProjectListGenerator{
			public void createProjectList() {
				for(int x=0;x<listOfProjectButtons.length;x++){ //resets all buttons
					listOfProjectButtons[x].setText("EMPTY");
					listOfProjectButtons[x].setBounds(30, (170+(30*x)), 150, 25);
					mainMenuPane.add(listOfProjectButtons[x]);
					listOfProjectButtons[x].setVisible(false);
				}
				
				String[] projectArray = null;
				try {
					projectArray = RandomAccessFileEditor.getProjects("ListOfProjectsRAF.txt");
					//Recursively reads the ListOfProjectsRAF file
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}					
				int count=0;
				for(int i=0;i<projectArray.length;i++) { //reads each line of the ListOfProjects.txt														
					String projectFileName = projectArray[i];										
					File accountFile = new File(projectFileName+"Accounts.txt");
					Scanner r2=null;
						try { //creates a scanner to search the accounts of each project in the ListOfProjects.txt
							r2 = new Scanner(accountFile);	
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					ArrayList<String> listOfAccounts = new ArrayList<String>();
					while(r2.hasNext()) listOfAccounts.add(r2.nextLine()); //makes a list of accounts per project
					r2.close();																				
					for(int x=0;x<listOfAccounts.size();x++) {										
						if(listOfAccounts.get(x).equals(account[accountIndexUsed].getName())) {	
							//^checks if any of the names in the ArrayList match the logged in client
							File dataFile = new File(projectFileName+"Data.txt");
							Scanner r3=null;
								try { //creates a scanner for the project's data file
									r3 = new Scanner(dataFile);
								} catch (FileNotFoundException e) {
									e.printStackTrace();
								}
							String projectName = r3.nextLine();	//locates the project's name								
							r3.close();
							listOfProjectButtons[count].setText(projectName); 
							listOfProjectButtons[count].setVisible(true); //creates a button for the respective project
							count++;
						}else {
							listOfProjectButtons[count].setVisible(false);
						}
					}
				}
			} 
		}  ProjectListGenerator projectListMaker = new ProjectListGenerator();
		
		
		//creates the login system
		class Login{
			public void runLogin() {
				for(int x=0;x<10;x++){
					if(account[x].getUsername().equals(usernameField.getText()) && account[x].getPassword().equals(
							//generates the hash code for the inputed password
							PasswordHasher.generateHash(new String(passwordField.getPassword())))) {
						lblIncorrectUandP.setVisible(false);
						loginPane.setVisible(false);
						mainMenuPane.setVisible(true); //changes panels visible in the card layout
						accountIndexUsed = x; //records the index of the logged in client
						projectListMaker.createProjectList(); //creates the list of projects in the main menu
						lblWelcome.setText("Welcome " + account[accountIndexUsed].getName()); //builds the welcome JLabel
						}
					else lblIncorrectUandP.setVisible(true);
			}} 
		} Login login = new Login(); //creates an instance of the login class
		
		abstract class TableManager implements DataTable{
			public String getFileName(){
				StringTokenizer st = new StringTokenizer(lblProjectTitle.getText()," ");
				String fileName="";
				while(st.hasMoreTokens()) fileName+=st.nextToken();
				return fileName;
			}
			public void generateData(){}
			public void addData() {}
		}
		
		//creates the table for the tasks page and adds new values to the table
		class TasksTable extends TableManager implements DataTable{
			public void generateData() {
				
				//removes the preexisting table from another project
				tasksTableModel.setRowCount(0);
				
				File csvFile = new File(super.getFileName()+"Tasks.csv"); 
				Scanner reader=null;
					try {reader = new Scanner(csvFile);}
					catch (FileNotFoundException e) {e.printStackTrace();}
				
				//creates the data ArrayList
				ArrayList<String> dataList = new ArrayList<String>();
					
				//reads through the header values (they have already been set and only...
				//...exist in the text file for exporting reasons)
				reader.nextLine();

				//reads the actual task data
				while(reader.hasNextLine()) dataList.add(reader.nextLine());
				
				//converts from an ArrayList to a normal array
				String[] dataArray = new String[dataList.size()];
				for(int x=0;x<dataArray.length;x++) dataArray[x] = dataList.get(x);
				
				//adds the data to the JTable
				for(int x=0;x<dataArray.length;x++){
					String[] rowData = new String[3];
					int rowIndex = 0;
					StringTokenizer st2 = new StringTokenizer(dataArray[x], ",");
					while(st2.hasMoreTokens()) {
						rowData[rowIndex] = st2.nextToken();
						rowIndex++;}
					tasksTableModel.addRow(rowData); //uses defaultTableModel
				}
				reader.close();
			}
			
			public void addData() {
				//gets the project's name
				StringTokenizer st = new StringTokenizer(lblProjectTitle.getText()," ");
				String fileName="";
				while(st.hasMoreTokens()) fileName+=st.nextToken();
				
				//makes the file and filewriter and printwriter
				File csvFile = new File(fileName+"Tasks.csv");
				FileWriter fileWriter = null;
					try {fileWriter = new FileWriter(csvFile, true);} 
					catch (IOException e1) {e1.printStackTrace();}
				PrintWriter printWriter = new PrintWriter(fileWriter);
				
				//writes the new task to the text file
				String task = (String) tasksComboBox.getSelectedItem();
				String contractor = contractorTextField.getText();
				String date = projCompMMTextField.getText() +"/"+ 
							  projCompDDTextField.getText() +"/"+ 
							  projCompYYYYTextField.getText();
				printWriter.print("\r\n");
				printWriter.print(task +", "+ contractor +", "+ date);
				printWriter.close();
				
				//adds the data to the JTable
				String[] rowData = {task, contractor, date};
				tasksTableModel.addRow(rowData);
				
			}
		} DataTable taskTable = new TasksTable();
		
		class CommentBoard{
			public void generateCommentBoard() {
				//creates array lists of the ID's of the accounts and the comments themselves
				ArrayList<Integer> indexArray = new ArrayList<Integer>();
				ArrayList<String> commentArray = new ArrayList<String>();
				
				//reads the text file
				StringTokenizer st = new StringTokenizer(lblProjectTitle.getText()," ");
				String fileName="";
				while(st.hasMoreTokens()) fileName+=st.nextToken();
				File commentsFile = new File(fileName+"Comments.txt"); 
				Scanner reader=null;
					try {reader = new Scanner(commentsFile);}
					catch (FileNotFoundException e) {e.printStackTrace();}
				//^makes a scanner for the project's comments file
				while(reader.hasNextLine()) {
					//each line in the text file has an ID and a comment
					StringTokenizer st2 = new StringTokenizer(reader.nextLine(),";");
					//^account indexes and comments are split by the semi-colon delimiter
					indexArray.add(Integer.parseInt(st2.nextToken()));
					commentArray.add(st2.nextToken());
				}
				
				//erases previous comments from other opened projects
				for(int x=0;x<numberOfCommentsSupported;x++) {			
					nameLabelArray[x].setText("");
					nameLabelArray[x].setVisible(false);
					commentLabelArray[x].setText("");
					commentLabelArray[x].setVisible(false);
				}
				
				//converts the information from the array lists into JLabels
				for(int x=0;x<indexArray.size();x++) {			
					nameLabelArray[x].setText(""+account[indexArray.get(x)].getName());
					//^finds the respective name of the account index recorded
					nameLabelArray[x].setVisible(true);
					commentLabelArray[x].setText(""+commentArray.get(x));
					commentLabelArray[x].setToolTipText(""+commentArray.get(x));
					commentLabelArray[x].setVisible(true);}
			}
			public void addComment() {
				//adds the new comment to the comment text file
				StringTokenizer st = new StringTokenizer(lblProjectTitle.getText()," ");
				String fileName="";
				while(st.hasMoreTokens()) fileName+=st.nextToken();
				//^builds the project's name based on the project's title label
				File commentsFile = new File(fileName+"Comments.txt");
				FileWriter dataWriter = null;
					try {dataWriter = new FileWriter(commentsFile, true);} //supports amending 
					catch (IOException e1) {e1.printStackTrace();}
				PrintWriter dpw = new PrintWriter(dataWriter);
				//^creates a File and PrintWriter for the project's comments file
				dpw.print(""+account[accountIndexUsed].getIndex()+";"+commentTextArea.getText());
				//^prints the client's index and the comment itself, using the semi-colon delimiter
				dpw.println("");
				dpw.close();
				commentTextArea.setText(""); 
				//^resets the comment's textarea without invoking a Clear method
				
				generateCommentBoard(); //regenerates the comment board by invoking the method
			}
		} CommentBoard commentBoard = new CommentBoard();
		
		//creates the table for the tasks page and adds new values to the table
		class ProblemsTable extends TableManager implements DataTable{
			
			private PQueue problemQueue;
			
			public void generateProblemQueue() {
				//removes the preexisting table from another project
				problemsTableModel.setRowCount(0);
				
				//reads the tasks csv file
				File csvFile = new File(super.getFileName()+"Problems.csv"); 
				Scanner reader=null;
					try {reader = new Scanner(csvFile);}
					catch (FileNotFoundException e) {e.printStackTrace();}
				
				//creates the data ArrayList
				ArrayList<String> dataList = new ArrayList<String>();
					
				//reads through the header values (they have already been set and only...
				//...exist in the text file for exporting reasons)
				reader.nextLine();

				//reads the actual task data
				while(reader.hasNextLine()) dataList.add(reader.nextLine());
				
				//converts from an ArrayList to a normal array
				String[] dataArray = new String[dataList.size()];
				for(int x=0;x<dataArray.length;x++) dataArray[x] = dataList.get(x);
				
				//creates an array of Problem instances
				problemQueue = new PQueue(dataList.size()*3); 
				
				//adds the data to the Problem Queue
				for(int x=0;x<dataArray.length;x++){
					String[] rowData = new String[3];
					int rowIndex = 0;
					StringTokenizer st2 = new StringTokenizer(dataArray[x], ",");
					String title = st2.nextToken();
					String description = st2.nextToken();
					int priority = Integer.parseInt(st2.nextToken());
					problemQueue.enqueue(new Problem(title, description, priority));
				}
				reader.close();
			}
			
			public void generateData() {
				
				generateProblemQueue();
				
				//adds the data to the JTable
				while(!problemQueue.isEmpty()){
					Problem temp = problemQueue.dequeue();
					String[] rowData = new String[3];
					rowData[0] = temp.getTitle();
					rowData[1] = temp.getDescription();
					rowData[2] = ""+temp.getPriority();
					problemsTableModel.addRow(rowData); //uses defaultTableModel
				}
			}
			
			public void addData() {
				//makes the file and filewriter and printwriter
				File csvFile = new File(super.getFileName()+"Problems.csv");
				FileWriter fileWriter = null;
					try {fileWriter = new FileWriter(csvFile, true);} 
					catch (IOException e1) {e1.printStackTrace();}
				PrintWriter printWriter = new PrintWriter(fileWriter);
				
				//writes the new task to the text file
				String title = (String) titleTextField.getText();
				String description = (String) descriptionTextField.getText();
				int priority = Integer.parseInt((String) priorityComboBox.getSelectedItem());
				printWriter.print("\r\n");
				printWriter.print(title +","+ description +","+ priority);
				printWriter.close();
				
				//adds the data to the JTable simply by adding to the row (not by actually enqueue/dequeue'ing the queue)
				//String[] rowData = {title, description, ""+priority};
				//problemsTableModel.addRow(rowData);
				
				//adds the data to the JTable by actually enqueue/dequeue'ing the queue
				generateData();
			}
			
			public Problem removeProblem(){
				//makes the altered queue
				generateProblemQueue();
				Problem removedProblem = problemQueue.dequeue();
				
				//makes the file
				File csvFile = new File(super.getFileName()+"Problems.csv");
				
				//deletes the file's contents
				PrintWriter writer = null;
					try {writer = new PrintWriter(csvFile);}
					catch (FileNotFoundException e) {e.printStackTrace();}
				writer.print("");
				
				//makes the file editor classes
				FileWriter fileWriter = null;
					try {fileWriter = new FileWriter(csvFile, true);} 
					catch (IOException e1) {e1.printStackTrace();}
				PrintWriter printWriter = new PrintWriter(fileWriter);
				
				//sets up header
				printWriter.print("Title,Description,Priority");
				
				//prints the new queue
				while(!problemQueue.isEmpty()) {
					Problem temp = problemQueue.dequeue();
					printWriter.print("\r\n");
					printWriter.print(temp.getTitle()+","+temp.getDescription()+","+temp.getPriority());
				}
				printWriter.close();
				
				return removedProblem;
			}
			
		} ProblemsTable problemTable = new ProblemsTable();
		

		class ChangeChecker{
			public String originalProjectPaneProjectNameTextfield;
			public String originalProjectPaneAdressTextfield;
			public String originalProjectPaneCityTextfield;
			public String originalProjectPaneStateTextfield;
			public String originalProjectPaneTLIDTextfield;
			public String originalProjectPaneTLDTDTextfield;
			public String originalProjectPaneTLUCTextfield;
			public String originalProjectPaneTLRTextfield;
			public String originalProjectPaneLSWTLTDTextfield;
			public String originalProjectPaneACPLTextfield;
			public String originalProjectPaneAPPLFextfield;
			
			public void captureOriginalDataValues() {
				originalProjectPaneProjectNameTextfield = editProjectPaneProjectNameTextfield.getText();
				originalProjectPaneAdressTextfield = editProjectPaneAdressTextfield.getText();
				originalProjectPaneCityTextfield = editProjectPaneCityTextfield.getText();
				originalProjectPaneStateTextfield = editProjectPaneStateTextfield.getText();
				originalProjectPaneTLIDTextfield = editProjectPaneTLIDTextfield.getText();
				originalProjectPaneTLDTDTextfield = editProjectPaneTLDTDTextfield.getText();
				originalProjectPaneTLUCTextfield = editProjectPaneTLUCTextfield.getText();
				originalProjectPaneTLRTextfield = editProjectPaneTLRTextfield.getText();
				originalProjectPaneLSWTLTDTextfield = editProjectPaneLSWTLTDTextfield.getText();
				originalProjectPaneACPLTextfield = editProjectPaneACPLTextfield.getText();
				originalProjectPaneAPPLFextfield = editProjectPaneAPPLFextfield.getText();
			}
		} ChangeChecker checker = new ChangeChecker();
		
		/*class ProjectClassCreator{
			public void createProjectClasses() {
				Scanner r1 = new Scanner("listOfProjects.txt");
				int c=0;
				while(r1.hasNext()) {
					String projectNameFromFile=r1.next();
					boolean projectPreviouslyCreated = false;
					for(int x=0;x<listOfProjects.size();x++) {
						StringTokenizer st = new StringTokenizer(listOfProjects.get(x).getName()," ");
						String projectNameFromArray = "";
						while(st.hasMoreTokens()) projectNameFromArray+=st.nextToken();
						//System.out.println("Array: "+projectNameFromArray+" File: "+projectNameFromFile);
						if (projectNameFromFile.equals(projectNameFromArray)) projectPreviouslyCreated=true;
					}
					if(projectPreviouslyCreated==false) {
						Scanner r2 = new Scanner(projectNameFromFile+"Data.txt");
						listOfProjects.add(new Project(r2.nextLine()));
						listOfProjects.get(c).setAddress(r2.nextLine());
						listOfProjects.get(c).setCity(r2.nextLine());
						listOfProjects.get(c).setState(r2.nextLine());
						listOfProjects.get(c).setTotalLotsInDevelopment(r2.nextInt());
						listOfProjects.get(c).setTotalLotsDeveloped(r2.nextInt());
						listOfProjects.get(c).setTotalLotsUnderConstruction(r2.nextInt());
						listOfProjects.get(c).setTotalLotsRemaining(r2.nextInt());
						listOfProjects.get(c).setTotalLotsSoldIn30Days(r2.nextInt());
						listOfProjects.get(c).setAvgCostPerLot(r2.nextInt());
						listOfProjects.get(c).setAvgPricePerLot(r2.nextInt());
						r2.close();
						c++;
					}
				}
				r1.close();
				System.out.println("Project maker has been run");
		}} ProjectClassCreator projecClassMaker = new ProjectClassCreator();*/
/*
 * 
 * A C T I O N   L I S T E N E R S
 * 		
 */
		//back buttons
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newProjectPane.setVisible(false);
				mainMenuPane.setVisible(true);
				setTitle("Real Estate Tracker"); 
				//^removes specific project from the window title
				projectListMaker.createProjectList();
				//^regenerates the client's list of projects
			}
		});
		btnBack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projectPane.setVisible(false);
				mainMenuPane.setVisible(true);
				setTitle("Real Estate Tracker");
				//^removes specific project from the window title
				projectListMaker.createProjectList();
				//^regenerates the client's list of projects
			}
		});
		editProjectPaneEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editProjectPane.setVisible(false);
				projectPane.setVisible(true);
				//^returns to the project pane
				displayData.projectData();
				//^refreshes the project data
			}
		});
		
		//save edits to project data
		editProjectPaneSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean emptyTextFields = false;    
				boolean noNumberTextFields = false; //sets all error booleans to false
				
				if(editProjectPaneProjectNameTextfield.getText().isEmpty() || 
						editProjectPaneAdressTextfield.getText().isEmpty() ||
						editProjectPaneCityTextfield.getText().isEmpty() ||
						editProjectPaneStateTextfield.getText().isEmpty() ||
						editProjectPaneTLIDTextfield.getText().isEmpty() ||
						editProjectPaneTLDTDTextfield.getText().isEmpty() ||
						editProjectPaneTLUCTextfield.getText().isEmpty() ||
						editProjectPaneTLRTextfield.getText().isEmpty() ||
						editProjectPaneLSWTLTDTextfield.getText().isEmpty() ||
						editProjectPaneACPLTextfield.getText().isEmpty() ||
						editProjectPaneAPPLFextfield.getText().isEmpty()) {
						//^checks if any textfields are left empty 
							emptyTextFields =  true;
							System.out.println("ERROR: Empty text fields");
				}
				
				if(emptyTextFields==true) {
					JOptionPane.showMessageDialog(new JFrame(),
						    "All textboxes must be filled before revision",
						    "ERROR",
						    JOptionPane.WARNING_MESSAGE);
					//^runs a warning option pane, if textfield(s) are empty
				}
				
				if(emptyTextFields==false) { //runs if all textfields are full
					try {
						Integer.parseInt(editProjectPaneTLIDTextfield.getText());
						Integer.parseInt(editProjectPaneTLDTDTextfield.getText());
						Integer.parseInt(editProjectPaneTLUCTextfield.getText());
						Integer.parseInt(editProjectPaneTLRTextfield.getText());
						Integer.parseInt(editProjectPaneLSWTLTDTextfield.getText());
						Double.parseDouble(editProjectPaneACPLTextfield.getText());
						Double.parseDouble(editProjectPaneAPPLFextfield.getText());
						//^check if certain textfields contain numbers
					}
					catch(NumberFormatException e1) {
					//^runs if certain textfields do not contain numbers
						JOptionPane.showMessageDialog(new JFrame(),
							    "Please insert numbers where needed",
							    "ERROR",
							    JOptionPane.WARNING_MESSAGE);
						noNumberTextFields = true;
						//^runs a warning option pane, if textfield(s) dont have numbers
					}
				}
				
				if(noNumberTextFields==false && emptyTextFields==false) {
				//^runs if there have been no errors found
					StringTokenizer st = new StringTokenizer(lblProjectTitle.getText());
		    		String nameBuilder="";
		    		while(st.hasMoreTokens()) nameBuilder+=st.nextToken();
		    		//^builds the project's name from the project title label
		    		File projectDataFile = new File(nameBuilder+"Data.txt");
					FileWriter dataWriter = null;
						try {dataWriter = new FileWriter(projectDataFile);} 
						catch (IOException e1) {e1.printStackTrace();}
					PrintWriter dpw = new PrintWriter(dataWriter);
					//^makes a File and PrintWriter for the project's data file
					
					String newProjectPaneProjectNameTextfield = editProjectPaneProjectNameTextfield.getText();
						if(!newProjectPaneProjectNameTextfield.equals(checker.originalProjectPaneProjectNameTextfield)) {		
							DataEvent temp = new DataEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
									"Project Name",checker.originalProjectPaneACPLTextfield,
									newProjectPaneProjectNameTextfield);
							EventScripter.addEvent(temp);
						}
					String newProjectPaneAdressTextfield = editProjectPaneAdressTextfield.getText();
					if(!newProjectPaneAdressTextfield.equals(checker.originalProjectPaneAdressTextfield)) {		
						DataEvent temp = new DataEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
								"Project Address",checker.originalProjectPaneACPLTextfield,
								newProjectPaneAdressTextfield);
						EventScripter.addEvent(temp);
					}
					String newProjectPaneCityTextfield = editProjectPaneCityTextfield.getText();
					if(!newProjectPaneCityTextfield.equals(checker.originalProjectPaneCityTextfield)) {		
						DataEvent temp = new DataEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
								"Project City",checker.originalProjectPaneCityTextfield,
								newProjectPaneCityTextfield);
						EventScripter.addEvent(temp);
					}
					String newProjectPaneStateTextfield = editProjectPaneStateTextfield.getText();
					if(!newProjectPaneStateTextfield.equals(checker.originalProjectPaneStateTextfield)) {		
						DataEvent temp = new DataEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
								"Project State",checker.originalProjectPaneStateTextfield,
								newProjectPaneStateTextfield);
						EventScripter.addEvent(temp);
					}
					String newProjectPaneTLIDTextfield = editProjectPaneTLIDTextfield.getText();
					if(!newProjectPaneTLIDTextfield.equals(checker.originalProjectPaneTLIDTextfield)) {		
						DataEvent temp = new DataEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
								"Total Lots in Development",checker.originalProjectPaneTLIDTextfield,
								newProjectPaneTLIDTextfield);
						EventScripter.addEvent(temp);
					}
					String newProjectPaneTLDTDTextfield = editProjectPaneTLDTDTextfield.getText();
					if(!newProjectPaneTLDTDTextfield.equals(checker.originalProjectPaneTLDTDTextfield)) {		
						DataEvent temp = new DataEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
								"Total Lots Developed to Date",checker.originalProjectPaneTLDTDTextfield,
								newProjectPaneTLDTDTextfield);
						EventScripter.addEvent(temp);
					}
					String newProjectPaneTLUCTextfield = editProjectPaneTLUCTextfield.getText();
					if(!newProjectPaneTLUCTextfield.equals(checker.originalProjectPaneTLUCTextfield)) {		
						DataEvent temp = new DataEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
								"Total Lots Under Construction",checker.originalProjectPaneTLUCTextfield,
								newProjectPaneTLUCTextfield);
						EventScripter.addEvent(temp);
					}
					String newProjectPaneTLRTextfield = editProjectPaneTLRTextfield.getText();
					if(!newProjectPaneTLRTextfield.equals(checker.originalProjectPaneTLRTextfield)) {		
						DataEvent temp = new DataEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
								"Total Lots Remaining",checker.originalProjectPaneTLRTextfield,
								newProjectPaneTLRTextfield);
						EventScripter.addEvent(temp);
					}
					String newProjectPaneLSWTLTDTextfield = editProjectPaneLSWTLTDTextfield.getText();
					if(!newProjectPaneLSWTLTDTextfield.equals(checker.originalProjectPaneLSWTLTDTextfield)) {		
						DataEvent temp = new DataEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
								"Total Lots Sold Within the Last 30 Days",checker.originalProjectPaneLSWTLTDTextfield,
								newProjectPaneLSWTLTDTextfield);
						EventScripter.addEvent(temp);
					}
					String newProjectPaneACPLTextfield = editProjectPaneACPLTextfield.getText();
					if(!newProjectPaneACPLTextfield.equals(checker.originalProjectPaneACPLTextfield)) {		
						DataEvent temp = new DataEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
								"Average Cost Per Lot",checker.originalProjectPaneACPLTextfield,
								newProjectPaneACPLTextfield);
						EventScripter.addEvent(temp);
					}
					String newProjectPaneAPPLFextfield = editProjectPaneAPPLFextfield.getText();
					if(!newProjectPaneAPPLFextfield.equals(checker.originalProjectPaneAPPLFextfield)) {		
						DataEvent temp = new DataEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
								"Average Cost Per Lot",checker.originalProjectPaneAPPLFextfield,
								newProjectPaneAPPLFextfield);
						EventScripter.addEvent(temp);
					}
					
					dpw.println(editProjectPaneProjectNameTextfield.getText());
					dpw.println(editProjectPaneAdressTextfield.getText());
					dpw.println(editProjectPaneCityTextfield.getText());
					dpw.println(editProjectPaneStateTextfield.getText());
					dpw.println(editProjectPaneTLIDTextfield.getText());
					dpw.println(editProjectPaneTLDTDTextfield.getText());
					dpw.println(editProjectPaneTLUCTextfield.getText());
					dpw.println(editProjectPaneTLRTextfield.getText());
					dpw.println(editProjectPaneLSWTLTDTextfield.getText());
					dpw.println(editProjectPaneACPLTextfield.getText());
					dpw.println(editProjectPaneAPPLFextfield.getText());
					//^prints the new data values, replacing the older ones
					dpw.close();
					
					editProjectPane.setVisible(false);
					projectPane.setVisible(true);
					//^takes the client back to the respective project's detail pane
					displayData.projectData();
					//^reruns the projectData() method to refresh the detail labels 
				}
			}
		});
		
		//resets the new project pane 
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] warningOptions={"Return","Reset new project"};
				int resetWarning = JOptionPane.showOptionDialog //generates a JOptionPane warning the client
						 (null, "WARNING\nAre you sure you want to reset your new project?", 
								"Warning",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, warningOptions, warningOptions[0]);
				if(resetWarning==1) { //runs if "reset" was nevertheless selected
					clear.newProjectPage();	//resets the new project page
				}
		}});
		
		//login verification system
			//submit button
				btnSubmit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0){ 
						login.runLogin(); 
					}});	
			//enter button
				passwordField.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt){ 
						if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
							login.runLogin(); 
						}
					}});
						
		
		//logout confirmation
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int logoutConformation = JOptionPane.showConfirmDialog
						(null, "Are you sure?","Conformation", JOptionPane.YES_NO_OPTION);
				if(logoutConformation==0) { //runs if client selects "YES"
					loginPane.setVisible(true);
					mainMenuPane.setVisible(false); //takes client back to the login pane
					clear.loginPage(); //clears the login page
					clear.newProjectPage(); //clear the new project pane
				}
			}
		});
		
		//Takes client to the new project pane
		btnNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newProjectPane.setVisible(true);
				mainMenuPane.setVisible(false); //takes user to the new pane
				
				//renames check boxes to account names
				int accountIndexHasBeenMet=0;
				for(int x=0;x<account.length;x++) {
					if(x==accountIndexUsed) accountIndexHasBeenMet=1; //checks for the client's index
					if(x!=accountIndexUsed){ //skips over the client's index
						if(accountIndexHasBeenMet==0) chckbxAccount[x].setText(account[x].getName());
						if(accountIndexHasBeenMet==1) chckbxAccount[x-1].setText(account[x].getName());
						//^titles checkboxes in the correct index, based on the if the client's index has been met
					}
				}
			}
		});
		
		//takes client to the respective project page
		for(int x=0;x<listOfProjectButtons.length;x++){
			listOfProjectButtons[x].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mainMenuPane.setVisible(false);
					projectPane.setVisible(true); //takes user to the respective project
					lblProjectTitle.setText(e.getActionCommand()); //writes the project title label
					tabbedPane.setSelectedIndex(0);
					displayData.projectData(); //displays the project's data
					taskTable.generateData(); //generates the task table
					commentBoard.generateCommentBoard(); //generates the comment board
					problemTable.generateData(); //generates the problem table
					setTitle(e.getActionCommand()+" - Real Estate Tracker"); //renames window title
				}
			});
		}
		
		
		//saving a new project
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean emptyTextFields = false;    
				boolean noNumberTextFields = false; //sets all error booleans to false
				
				if(projectNameTextfield.getText().isEmpty() || 
					adressTextfield.getText().isEmpty() ||
					cityTextfield.getText().isEmpty() ||
					stateTextfield.getText().isEmpty() ||
					totalLotsInDevTextfield.getText().isEmpty() ||
					lblTotalDevelopedTextfield.getText().isEmpty() ||
					totalLotsUnderConstructionTextfield.getText().isEmpty() ||
					totalLotsRemainingTextfield.getText().isEmpty() ||
					lotsSoldWithinTextfield.getText().isEmpty() ||
					averageCostPerTextfield.getText().isEmpty() ||
					averagePricePerTextfield.getText().isEmpty()) {
					//^checks if any of the textfields are left empty
						emptyTextFields =  true; //triggers error boolean
						System.out.println("ERROR: Empty text fields");
				}
				
				if(emptyTextFields==true) { //runs if textfield(s) left empty
					JOptionPane.showMessageDialog(new JFrame(),
						    "All textboxes must be filled before submission",
						    "ERROR",
						    JOptionPane.WARNING_MESSAGE);
					//^displays an error option pane advising the client to fill all textfields
				}
				
				if(emptyTextFields==false) { //runs if all textfields contain data
					try {
						Integer.parseInt(totalLotsInDevTextfield.getText());
						Integer.parseInt(lblTotalDevelopedTextfield.getText());
						Integer.parseInt(totalLotsUnderConstructionTextfield.getText());
						Integer.parseInt(totalLotsRemainingTextfield.getText());
						Integer.parseInt(lotsSoldWithinTextfield.getText());
						Double.parseDouble(averageCostPerTextfield.getText());
						Double.parseDouble(averagePricePerTextfield.getText());
						//^checks if certain textfields are numbers
					}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(new JFrame(),
							    "Please insert numbers where needed",
							    "ERROR",
							    JOptionPane.WARNING_MESSAGE);
					//^displays an error option pane advising the client to fill in numbers
						noNumberTextFields = true; //triggers erorr boolean
					}
				}
				if(noNumberTextFields==false && emptyTextFields==false) { //runs if no error booleans
					//creating file's name
					StringTokenizer st = new StringTokenizer(projectNameTextfield.getText()," ");
					String fileName = "";
					while(st.hasMoreTokens()) fileName+=st.nextToken(); //builds the project name
					
					//data file
					File dataFile = new File(fileName+"Data.txt"); //creates the project's data file
					FileWriter dataWriter = null;
						try {dataWriter = new FileWriter(dataFile);} 
						catch (IOException e1) {e1.printStackTrace();}
					PrintWriter dpw = new PrintWriter(dataWriter); //makes a File and PrintWriter
					dpw.println(projectNameTextfield.getText());
					dpw.println(adressTextfield.getText());
					dpw.println(cityTextfield.getText());
					dpw.println(stateTextfield.getText());
					dpw.println(totalLotsInDevTextfield.getText());
					dpw.println(lblTotalDevelopedTextfield.getText());
					dpw.println(totalLotsUnderConstructionTextfield.getText());
					dpw.println(totalLotsRemainingTextfield.getText());
					dpw.println(lotsSoldWithinTextfield.getText());
					dpw.println(averageCostPerTextfield.getText());
					dpw.println(averagePricePerTextfield.getText());
					//^writes the project's data into the new data file
					dpw.close();
					
					//account file
					File accountFile = new File(fileName+"Accounts.txt"); //creates the project's account file
					FileWriter accountWriter = null;
						try {accountWriter = new FileWriter(accountFile);} 
						catch (IOException e1) {e1.printStackTrace();}
					PrintWriter apw = new PrintWriter(accountWriter); //makes a File and PrintWriter
					apw.println(account[accountIndexUsed].getName()); //automatically adds the client to the file
					for(int x=0;x<chckbxAccount.length;x++)
						if(chckbxAccount[x].isSelected())
							apw.println(chckbxAccount[x].getText());
					//^if checkbox is selected, then the account is added to the project account file
					apw.close();
					
					//writes new project to the list of projects file
					try{
						RandomAccessFileEditor.addProject("listOfProjectsRAF.txt", fileName);
					} 
					catch (Exception e2) {
						e2.printStackTrace();
					}
					
					//creates task, comment, and problem files
					File tasksFile = new File(fileName+"Tasks.csv"); //creates the project's tasks file
						FileWriter tasksFileWriter = null;
							try {tasksFileWriter = new FileWriter(tasksFile, true);} 
							catch (IOException e1) {e1.printStackTrace();}
						PrintWriter tasksPW = new PrintWriter(tasksFileWriter); //makes a File and PrintWriter
						tasksPW.print("Task,Contractor,Projected Completion"); 
						//^prints headers despite using a tableModel (used for exports; requested by the client)
						tasksPW.close();
					File commentsFile = new File(fileName+"Comments.txt"); //creates the project's comment file
						FileWriter commentsFileWriter = null;
							try {commentsFileWriter = new FileWriter(commentsFile, true);} 
							catch (IOException e1) {e1.printStackTrace();}
						PrintWriter commentsPW = new PrintWriter(commentsFileWriter); //makes a File and PrintWriter
						commentsPW.print(""); //ensures project comments file is ready for future comments
						commentsPW.close();
					File problemsFile = new File(fileName+"Problems.csv"); //creates the project's problems file
						FileWriter problemsFileWriter = null;
							try {problemsFileWriter = new FileWriter(problemsFile, true);} 
							catch (IOException e1) {e1.printStackTrace();}
						PrintWriter problemsPW = new PrintWriter(problemsFileWriter); //makes a File and PrintWriter
						problemsPW.print("Title,Description,Priority");
						//^ensures project problems file is ready for future problems
						problemsPW.close();
					
				//GUI processes
					mainMenuPane.setVisible(true);
					newProjectPane.setVisible(false); //returns user to the main menu
					clear.newProjectPage(); //clears the new project pane
					projectListMaker.createProjectList(); 
					//^reruns the project list algorithm so that the new project appears as a button
				}
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayData.editProjectData();
				
				checker.captureOriginalDataValues();
			}
		});
		
		//adds the new task to the task table
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String typeOfTask = tasksComboBox.getSelectedItem().toString();
				String contractor = contractorTextField.getText();
				String date = projCompMMTextField.getText() + "/" + projCompDDTextField.getText() + "/" + 
						projCompYYYYTextField.getText();
				
				boolean emptyTextFields = false;    
				boolean noNumberTextFields = false; //sets all error booleans to false
				
				if(projCompYYYYTextField.getText().isEmpty() || 
					projCompDDTextField.getText().isEmpty() ||
					projCompMMTextField.getText().isEmpty() ||
					contractorTextField.getText().isEmpty() ||
					tasksComboBox.getSelectedItem().equals(" ")) {
					//^runs if textfield(s) are left empty
						emptyTextFields =  true;
						System.out.println("ERROR: Empty text fields");
				}
				
				if(emptyTextFields==true) {
				//^runs if textfield(s) are left empty
					JOptionPane.showMessageDialog(new JFrame(),
						    "All textboxes must be filled before submission",
						    "ERROR",
						    JOptionPane.WARNING_MESSAGE);
					//^A warning option pane notifies the user of the blank textfields
				}
				
				if(emptyTextFields==false) {
				//^runs if all textfields are filled
					try {
						Integer.parseInt(projCompYYYYTextField.getText());
						Integer.parseInt(projCompDDTextField.getText());
						Integer.parseInt(projCompMMTextField.getText());
						//^tests if certain textfields are numbers
					}
					catch(NumberFormatException e1) {
					//^runs if those certian textfields are not numbers
						JOptionPane.showMessageDialog(new JFrame(),
							    "Please insert a valid date",
							    "ERROR",
							    JOptionPane.WARNING_MESSAGE);
						noNumberTextFields = true;
						//^runs a warning option pane notifying the client of the mistake
					}
				}
				if(noNumberTextFields==false && emptyTextFields==false) {
				//^runs if no errors have been found
					taskTable.addData(); //adds the new task
					clear.newTasks(); //clears the textfields on the tasks pane
					
					TaskEvent temp = new TaskEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),
							typeOfTask, contractor, date);
					
					EventScripter.addEvent(temp);
				}
			}
		});
		
		//exports the task csv file by opening the file in notepad
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringTokenizer st = new StringTokenizer(lblProjectTitle.getText());
	    		String nameBuilder="";
	    		while(st.hasMoreTokens()) nameBuilder+=st.nextToken();
					try {Runtime.getRuntime().exec("notepad "+nameBuilder+"Tasks.csv");} 
					catch (IOException e) {e.printStackTrace();}
			}
		});
		
		//saves a new comment made
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String comment = commentTextArea.getText();
				
				boolean emptyTextFields = false; //sets error boolean to false
				
				if(commentTextArea.getText().isEmpty()) {
						emptyTextFields =  true;
						System.out.println("ERROR: Empty text fields");
				}
				if(emptyTextFields==true) { //runs if the comment area is left blank
					JOptionPane.showMessageDialog(new JFrame(),
						    "You must write a comment before you submit one!",
						    "ERROR",
						    JOptionPane.WARNING_MESSAGE);
					//^runs a warning option pane informing the client of the problem
				}
				if(emptyTextFields==false) { //runs if there are no errors
					commentBoard.addComment();
					
					CommentEvent temp = new CommentEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(),comment);
					
					EventScripter.addEvent(temp);
				}
			}
		});
		
		//adds a new problem
		btnAddProblem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String title = titleTextField.getText();
				String description = descriptionTextField.getText();
				String priority = priorityComboBox.getSelectedItem().toString();
				
				boolean emptyTextFields = false;    
				
				if(titleTextField.getText().isEmpty() || descriptionTextField.getText().isEmpty()) {
				//^runs if textfield(s) are left empty
					emptyTextFields =  true;
					System.out.println("ERROR: Empty text fields");
				}
				
				if(emptyTextFields==true) {
				//^runs if textfield(s) are left empty
					JOptionPane.showMessageDialog(new JFrame(),
						    "All textboxes must be filled before submission",
						    "ERROR",
						    JOptionPane.WARNING_MESSAGE);
					//^A warning option pane notifies the user of the blank textfields
				}
				
				if(emptyTextFields==false) {	
				//^runs if no errors have been found
					problemTable.addData(); //adds the new task
					clear.newProblems(); //clears the textfields on the tasks pane
					
					ProblemEvent temp = new ProblemEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(), 
											title, description, priority, 0);
					
					EventScripter.addEvent(temp);
				}
				
			}
		});
		
		//Creates a recommended problem to solve
		btnRecommendAProblem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reads the problems csv file
				StringTokenizer st = new StringTokenizer(lblProjectTitle.getText()," ");
				String fileName="";
				while(st.hasMoreTokens()) fileName+=st.nextToken();
				File csvFile = new File(fileName+"Problems.csv"); 
				Scanner reader=null;
					try {reader = new Scanner(csvFile);}
					catch (FileNotFoundException e1) {e1.printStackTrace();}
				
				//creates the data ArrayList
				ArrayList<String> dataList = new ArrayList<String>();
					
				//reads through the header values (they have already been set and only...
				//...exist in the text file for exporting reasons)
				reader.nextLine();

				//reads the actual task data
				while(reader.hasNextLine()) dataList.add(reader.nextLine());
				
				//converts from an ArrayList to a normal array
				String[] dataArray = new String[dataList.size()];
				for(int x=0;x<dataArray.length;x++) dataArray[x] = dataList.get(x);
				
				//creates an array of Problem instances
				PQueue tempProblemQueue = new PQueue(dataList.size()*3); 
				//the capacity is three times larger than the list size for extra...
				//...robustness at the sake of computational speed 
				
				//adds the data to the Problem Queue
				for(int x=0;x<dataArray.length;x++){
					String[] rowData = new String[3];
					int rowIndex = 0;
					StringTokenizer st2 = new StringTokenizer(dataArray[x], ",");
					String title = st2.nextToken();
					String description = st2.nextToken();
					int priority = Integer.parseInt(st2.nextToken());
					tempProblemQueue.enqueue(new Problem(title, description, priority));
				}
				reader.close();

				//checks for empty problem queue
				if(tempProblemQueue.isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(),
						    "There are no problems to solve",
						    "ERROR",
						    JOptionPane.WARNING_MESSAGE);
				}
				else {
					//recognizes the recommended problem
					Problem recommendation = tempProblemQueue.front();
					String output = "";
					output += "SOLVE THIS PROBLEM FIRST\n\n";
					output += "Title: "+recommendation.getTitle()+"\n";
					output += "Description: "+recommendation.getDescription()+"\n";
					output += " ";
					
					Object[] selectionOptions={"Solve Problem","Dismiss"};
					int resetWarning = JOptionPane.showOptionDialog //generates a JOptionPane warning the client
							 (null, output, 
									"Recommended Problem to Solve",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, selectionOptions, selectionOptions[0]);
					if(resetWarning==0) { //runs if "Solve Problem" was selected
						Problem tempProblem = problemTable.removeProblem();
						problemTable.generateData(); //removes the problem
						
						ProblemEvent temp = new ProblemEvent(account[accountIndexUsed].getName(), lblProjectTitle.getText(), 
								tempProblem.getTitle(), tempProblem.getDescription(), ""+tempProblem.getPriority(), 1);
						//problem event is instantiated with a "1" parameter at the end to signal this is a ~removed~ problem
						
						EventScripter.addEvent(temp);
					}
				}
			}
		});
		
		
		//allows the client to CTRL+TAB through project tabs
		ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
		tabbedPane.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				pressedKeys.add(e.getKeyCode());
				if(pressedKeys.size()>1) {
					int selectionIndex = tabbedPane.getSelectedIndex();
					switch(selectionIndex) {
						case 0: tabbedPane.setSelectedIndex(1);
						case 1: tabbedPane.setSelectedIndex(2);
						case 2: tabbedPane.setSelectedIndex(0);
					}
				}
			}
			public void keyReleased(KeyEvent e) {
				pressedKeys.remove(e.getKeyCode());
			}
			public void keyTyped(KeyEvent e) {/*Not overrided*/}
		});
		
		//Allows the client to view the event script
		btnEventLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] options = {"Unsorted/Chronological",
				                    "Sorted by Project",
				                    "Sorted by Operation"};
				int n = JOptionPane.showOptionDialog(new JFrame(),
				    "Select your event log sorting type",
				    "Event Log",
				    JOptionPane.YES_NO_CANCEL_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,
				    options,
				    options[0]);
								
				JFrame eventFrame = new JFrame();
					//eventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					eventFrame.setTitle("Event Log");
					eventFrame.setSize(500,500);
					eventFrame.setLocationRelativeTo(null);
				
				JPanel eventPanel = new JPanel();
				GridLayout layout = new GridLayout();
				eventPanel.setLayout(layout);
				
				String[][] data = null;
				switch(n) {
				case 0:
					data = EventScripter.getUnsortedEventTable(account[accountIndexUsed].getName());
					break;
				case 1:
					data = EventScripter.getProjectSortedEventTable(account[accountIndexUsed].getName());
					break;
				case 2:
					data = EventScripter.getOperationSortedEventTable(account[accountIndexUsed].getName());
					break;
				}
				String[] columnName = {"Project","Operation","Details"};
				JTable eventTable = new JTable(data, columnName);
				JScrollPane scrollpane = new JScrollPane(eventTable);
				eventPanel.add(scrollpane);
				

				eventFrame.add(eventPanel);
				eventFrame.setVisible(true);
			}
		});
		
		
	}
}