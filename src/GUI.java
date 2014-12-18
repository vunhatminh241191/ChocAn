package ChocAn;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GUI 
{
	
	public static void LoginGUI()
	{	
		final JFrame frame = new JFrame();
		frame.setTitle("ChocAn Login");
		frame.setLocationRelativeTo(null);
		frame.setSize(300,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		JLabel label = new JLabel();
		panel.add(label);
		label.setText("Please Login: ");
		JButton Manager = new JButton("Manager");
		
		//functionality for the manager button on the Login GUI		
		panel.add(Manager);
			class ManagerActionListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
			frame.dispose();
			 ManagerGUI();
			}
		}
			
		//functionality for the operator button on the Login GUI	
		JButton Operator = new JButton("Operator");
		panel.add(Operator);
			class OperatorActionListener implements ActionListener
		{
				public void actionPerformed (ActionEvent event)
				{
				frame.dispose();
				OperatorGUI();
				}
		}			
		//functionality for the provider button on the login GUI
			JButton Provider = new JButton("Provider");
			panel.add(Provider);
				class ProviderActionListener implements ActionListener
			{
					public void actionPerformed (ActionEvent event)
					{
					frame.dispose();
					ProviderGUI();
					}
			}
		// add action listeners for GUI buttons	
		Provider.addActionListener(new ProviderActionListener());	
		Manager.addActionListener(new ManagerActionListener());
		Operator.addActionListener(new OperatorActionListener());
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);		
	}
	
	public static void ManagerGUI()
	{
		final Manager_Member mm = new Manager_Member();
		final Provider_List pl = new Provider_List();
		final Service_List sl = new Service_List();
		final Member m = new Member();
		final Provider p = new Provider();
		final Service s = new Service();
		final JFrame frame = new JFrame();
		frame.setTitle("ChocAn Manager");
		frame.setLocationRelativeTo(null);
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Menu Bar for Manager Class
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
			
		//Manager Member Menu
		
		final String memberInputFile =  "inputMember.txt";
		final String providerInputFile= "inputProvider.txt";
		final String serviceInputFile = "inputService.txt";
		mm.inputFile(memberInputFile);
		pl.inputFile(providerInputFile);
		sl.inputFile(serviceInputFile);
		
		JMenu memberMenu = new JMenu("Member");
		menubar.add(memberMenu);
		final Container contentPane = frame.getContentPane();
		contentPane.removeAll();
		JMenuItem AddMember = new JMenuItem("Add Member");
		
		//add member menu item interface
		class AddMemberActionListener implements ActionListener
		{			
			   
		    	JLabel firstName = new JLabel("First Name:  ");
				JTextField iFirstName = new JTextField(10);
				JLabel lastName = new JLabel("Last Name:  ");
				JTextField iLastName = new JTextField(10);
				JLabel middleInitial = new JLabel("MI:  ");
				JTextField iMiddleInitial = new JTextField(3);
				JLabel phoneNumber = new JLabel ("Phone Number:  ");
				JTextField iPhoneNumber = new JTextField(10);
				JLabel streetAddress = new JLabel("Street Address:  ");
				JTextField iStreetAddress = new JTextField(20);
				JLabel city = new JLabel("City:  ");
				JTextField iCity = new JTextField(15);
				JLabel state = new JLabel("State:  ");
				JTextField iState = new JTextField(2);
				JLabel zip = new JLabel("Zip Code:  ");				
				JTextField iZip = new JTextField(9);	
				JLabel email = new JLabel("Email Address");
				JTextField iEmail = new JTextField(20);
				JButton Submit = new JButton("Submit");
				
				JPanel AddMemberPanel = new JPanel( );	
				
			String oFirstName;
			String oLastName;
			String oMiddleInitial;
			String oPhoneNumber;
			String oStreetAddress;
			String oCity;
			String oState;
			String oZip;
			String oEmail;
						
		public void InputPanel()
		{
		
				AddMemberPanel.setLayout(new GridLayout(11,2));
				AddMemberPanel.add(firstName);
				AddMemberPanel.add(iFirstName);
				AddMemberPanel.add(lastName);
				AddMemberPanel.add(iLastName);
				AddMemberPanel.add(middleInitial);
				AddMemberPanel.add(iMiddleInitial);
				AddMemberPanel.add(phoneNumber);
				AddMemberPanel.add(iPhoneNumber);
				AddMemberPanel.add(streetAddress );
				AddMemberPanel.add(iStreetAddress);
				AddMemberPanel.add(city );
				AddMemberPanel.add(iCity);
				AddMemberPanel.add(state );
				AddMemberPanel.add(iState);
				AddMemberPanel.add(zip );
				AddMemberPanel.add(iZip);
				AddMemberPanel.add(email);
				AddMemberPanel.add(iEmail);
				AddMemberPanel.add(Submit);
				
				Submit.addActionListener(this);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(AddMemberPanel);
				
				frame.pack();
				frame.setVisible(true);					
		}
				
				public void actionPerformed (ActionEvent event)
			{				
					InputPanel();
					if(event.getActionCommand().equals("Submit"))
					{
						
					 oFirstName = iFirstName.getText();
					 oLastName = iLastName.getText();
					 oMiddleInitial = iMiddleInitial.getText();
					 oPhoneNumber = iPhoneNumber.getText();
					 oStreetAddress = iStreetAddress.getText();
					 oCity = iCity.getText();
					 oState = iState.getText();
					 oZip = iZip.getText();
					 oEmail = iEmail.getText();
					m.FirstName = oFirstName;
					m.LastName = oLastName;
					m.MiddleName = oMiddleInitial;
					m.PhoneNumber = oPhoneNumber;
					m.Street = oStreetAddress;
					m.City = oCity;
					m.State = oState;
					m.ZipCode = oZip;
					m.Email = oEmail;
					mm.input(m);
					
					/*System.out.println(oFirstName);
					System.out.println(oLastName);
					System.out.println(oStreetAddress);
					System.out.println(oCity);
					System.out.println(oState);
					System.out.println(oZip);
					//	Member.getReport(oMemberID);*/
					mm.outputFile(memberInputFile);
//					iFirstName.setText("");
//					iLastName.setText("");
//					iMiddleInitial.setText("");
//					iPhoneNumber.setText("");
//					iStreetAddress.setText("");
//					iCity.setText("");
//					iState.setText("");
//					iZip.setText("");
//					iEmail.setText("");
					frame.dispose();
					ManagerGUI();				
					}
			}			
		}
		AddMember.addActionListener(new AddMemberActionListener());
		
		//edit member menu item interface
		JMenuItem EditMember = new JMenuItem("Edit Member");
		class EditMemberActionListener implements ActionListener
		{		
			JLabel memberID = new JLabel ("Member ID:  ");
			JTextField iMemberID = new JTextField(10);
	    	JLabel firstName = new JLabel("First Name:  ");
			JTextField iFirstName = new JTextField(10);
			JLabel lastName = new JLabel("Last Name:  ");
			JTextField iLastName = new JTextField(10);
			JLabel middleInitial = new JLabel("MI:  ");
			JTextField iMiddleInitial = new JTextField(3);
			JLabel phoneNumber = new JLabel ("Phone Number:  ");
			JTextField iPhoneNumber = new JTextField(10);
			JLabel streetAddress = new JLabel("Street Address:  ");
			JTextField iStreetAddress = new JTextField(20);
			JLabel city = new JLabel("City:  ");
			JTextField iCity = new JTextField(15);
			JLabel state = new JLabel("State:  ");
			JTextField iState = new JTextField(2);
			JLabel zip = new JLabel("Zip Code:  ");				
			JTextField iZip = new JTextField(9);	
			JLabel email = new JLabel("Email Address");
			JTextField iEmail = new JTextField(20);
			JButton SubmitID = new JButton("Submit ID");
			JPanel EditMemberPanel = new JPanel( );	
			JPanel EditInputPanel = new JPanel( );	
			JButton SubmitEdit = new JButton("Submit");
			
		// values for populating fields and outputting to file
			String oMemberID;
			String oFirstName;
			String oLastName;
			String oMiddleInitial;
			String oPhoneNumber;
			String oStreetAddress;
			String oCity;
			String oState;
			String oZip;
			String oEmail;
					
			public void InputID()
				{				
			    EditInputPanel.setLayout(new GridLayout(2,2));
				EditInputPanel.add(memberID);
				EditInputPanel.add(iMemberID);
				EditInputPanel.add(SubmitID);
			    oMemberID = iMemberID.getText();
				SubmitID.addActionListener(this);
				oFirstName = mm.GetFirstName(oMemberID);
				oLastName = mm.GetLastName(oMemberID);
				oMiddleInitial = mm.GetMiddleName(oMemberID);
				oPhoneNumber = mm.GetPhoneNumber(oMemberID);
				oStreetAddress = mm.GetStreet(oMemberID);
				oCity = mm.GettCity(oMemberID);
				oState = mm.GetState(oMemberID);
				oZip = mm.GetZip(oMemberID);
				oEmail = mm.GetEmail(oMemberID);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(EditInputPanel);				
				frame.pack();
				frame.setVisible(true);
				}
			
				public void  EditMemberForm()
				{	
					//generate edit form
					EditMemberPanel.setLayout(new GridLayout(14,2));
				 	EditMemberPanel.add(memberID);
				 	iMemberID.setEditable(false);
					EditMemberPanel.add(iMemberID);
					EditMemberPanel.add(firstName);
					EditMemberPanel.add(iFirstName);
					EditMemberPanel.add(lastName);
					EditMemberPanel.add(iLastName);
					EditMemberPanel.add(middleInitial);
					EditMemberPanel.add(iMiddleInitial);
					EditMemberPanel.add(phoneNumber);
					EditMemberPanel.add(iPhoneNumber);
					EditMemberPanel.add(streetAddress );
					EditMemberPanel.add(iStreetAddress);
					EditMemberPanel.add(city );
					EditMemberPanel.add(iCity);
					EditMemberPanel.add(state );
					EditMemberPanel.add(iState);
					EditMemberPanel.add(zip );
					EditMemberPanel.add(iZip);
					EditMemberPanel.add(email);
					EditMemberPanel.add(iEmail);
					EditMemberPanel.add(SubmitEdit);
					
					iMemberID.setText(oMemberID);
					iFirstName.setText(oFirstName);
					iLastName.setText(oLastName);
					iMiddleInitial.setText(oMiddleInitial);
					iPhoneNumber.setText(oPhoneNumber);
					iStreetAddress.setText(oStreetAddress);
					iCity.setText(oCity);
					iState.setText(oState);
					iZip.setText(oZip);
					iEmail.setText(oEmail);		
					SubmitEdit.addActionListener(this);													
					contentPane.removeAll();
					contentPane.validate();
					contentPane.repaint();
					contentPane.add(EditMemberPanel);	
											
					frame.pack();
					frame.setVisible(true);
				}
				
			public void actionPerformed (ActionEvent event)
	        {				
					
				InputID();
				if(event.getActionCommand().equals("Submit ID"))
				{
					 oMemberID = iMemberID.getText();

				 
				 EditMemberForm();				 				 
				}
				
				else if (event.getActionCommand().equals("Submit"))
				{
				 oFirstName = iFirstName.getText();
				 oLastName = iLastName.getText();
				 oMiddleInitial = iMiddleInitial.getText();
				 oPhoneNumber = iPhoneNumber.getText();
				 oStreetAddress = iStreetAddress.getText();
				 oCity = iCity.getText();
				 oState = iState.getText();
				 oZip = iZip.getText();
				 oEmail = iEmail.getText();
							
				mm.EditFirstName(oFirstName, oMemberID);
				mm.EditMiddleName(oMiddleInitial, oMemberID);
				mm.EditLastName(oLastName, oMemberID);
				mm.EditPhoneNUmber(oPhoneNumber, oMemberID);
				mm.EditStreet(oStreetAddress, oMemberID);
				mm.EditCity(oCity, oMemberID);
				mm.EditState(oState, oMemberID);
				mm.EditZipCode(oZip, oMemberID);
				mm.EditEmail(oEmail, oMemberID);
				mm.outputFile(memberInputFile);
				frame.dispose();
				ManagerGUI();				
				}				
			}
		}
		EditMember.addActionListener(new EditMemberActionListener());		
		
		JMenuItem SetInactive = new JMenuItem("Set Member Inactive");
		class SetInactiveActionListener implements ActionListener
		{
			JLabel memberID = new JLabel("Member ID:  ");
			JTextField iMemberID = new JTextField(10);
			JPanel SetInactivePanel = new JPanel();
			JPanel SetIDPanel = new JPanel();
			JLabel firstName = new JLabel("First Name:  ");
			JTextField iFirstName = new JTextField(10);
			JLabel lastName = new JLabel("Last Name:  ");
			JTextField iLastName = new JTextField(10);
			JLabel middleInitial = new JLabel("MI:  ");
			JTextField iMiddleInitial = new JTextField(3);
			JButton SubmitID = new JButton("Submit ID");
			JButton Submit = new JButton("Submit");
			JCheckBox setInactive = new JCheckBox("Active");
			String oMemberID;
			String oFirstName;
			String oLastName;
			String oMiddleInitial;
			Boolean active;
			
			public void InputID()
			{
			SetIDPanel.setLayout(new GridLayout(2,2));
			SetIDPanel.add(memberID);
			SetIDPanel.add(iMemberID);
			SetIDPanel.add(SubmitID);
			oMemberID = iMemberID.getText();
			SubmitID.addActionListener(this);
			oFirstName = mm.GetFirstName(oMemberID);
			oLastName = mm.GetLastName(oMemberID);
			oMiddleInitial = mm.GetMiddleName(oMemberID);
			contentPane.removeAll();
			contentPane.validate();
			contentPane.repaint();
			contentPane.add(SetIDPanel);
			frame.pack();
			frame.setVisible(true);
			}
			
			public void CheckBox()
			{
				SetInactivePanel.setLayout(new GridLayout(5,2));
				SetInactivePanel.add(memberID);
				SetInactivePanel.add(iMemberID);
				SetInactivePanel.add(firstName);
				SetInactivePanel.add(iFirstName);
				SetInactivePanel.add(lastName);
				SetInactivePanel.add(iLastName);
				SetInactivePanel.add(middleInitial);
				SetInactivePanel.add(iMiddleInitial);
				SetInactivePanel.add(setInactive);
				SetInactivePanel.add(Submit);
				Submit.addActionListener(this);
				iMemberID.setText(String.valueOf(oMemberID));
				iFirstName.setText(oFirstName);
				iLastName.setText(oLastName);
				iMiddleInitial.setText(oMiddleInitial);
				active = mm.GetActive(oMemberID);
				iMemberID.setEditable(false);
				iFirstName.setEditable(false);
				iLastName.setEditable(false);
				iMiddleInitial.setEditable(false);
				
				setInactive.setSelected(active);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(SetInactivePanel);
				frame.pack();
				frame.setVisible(true);
			}
			
			public void actionPerformed (ActionEvent event)
			{
			InputID();
			if(event.getActionCommand().equals("Submit ID"))
			{
				CheckBox();
			}
			else if(event.getActionCommand().equals("Submit"))
				{
				if(setInactive.isSelected())
				active = true;
				else active = false;
				mm.EditActive(active, oMemberID);
				mm.outputFile(memberInputFile);
				frame.dispose();
				ManagerGUI();	
				}		
			}
		}
		
		SetInactive.addActionListener(new SetInactiveActionListener());
		JMenuItem MemberReport = new JMenuItem("Run Member Report");
		
		class MemberReportActionListener implements ActionListener
		{
			    JLabel memberID = new JLabel("Member ID:  ");
				JTextField iMemberID = new JTextField(10);
				JPanel MemberReportPanel = new JPanel();
				JPanel MemberIDPanel = new JPanel();
				JLabel firstName = new JLabel("First Name:  ");
				JTextField iFirstName = new JTextField(10);
				JLabel lastName = new JLabel("Last Name:  ");
				JTextField iLastName = new JTextField(10);
				JLabel middleInitial = new JLabel("MI:  ");
				JTextField iMiddleInitial = new JTextField(3);
				JLabel phoneNumber = new JLabel ("Phone Number:  ");
				JTextField iPhoneNumber = new JTextField(10);
				JLabel streetAddress = new JLabel("Street Address:  ");
				JTextField iStreetAddress = new JTextField(20);
				JLabel city = new JLabel("City:  ");
				JTextField iCity = new JTextField(15);
				JLabel state = new JLabel("State:  ");
				JTextField iState = new JTextField(2);
				JLabel zip = new JLabel("Zip Code:  ");				
				JTextField iZip = new JTextField(9);	
				JLabel email = new JLabel("Email Address");
				JTextField iEmail = new JTextField(20);
				JButton submit = new JButton("Submit");
				String oMemberID;
				String oFirstName;
				String oLastName;
				String oMiddleInitial;
				String oPhoneNumber;
				String oStreetAddress;
				String oCity;
				String oState;
				String oZip;
				String oEmail;
				JButton OK = new JButton("Ok");
				
				public void InputPanel()
				{
								
				MemberIDPanel.setLayout(new GridLayout(2,2));
				MemberIDPanel.add(memberID);
				MemberIDPanel.add(iMemberID);
				MemberIDPanel.add(submit); 
				oMemberID = iMemberID.getText();
				oFirstName = mm.GetFirstName(oMemberID);
				oLastName = mm.GetLastName(oMemberID);
				oMiddleInitial = mm.GetMiddleName(oMemberID);
				oPhoneNumber = mm.GetPhoneNumber(oMemberID);
				oStreetAddress = mm.GetStreet(oMemberID);
				oCity = mm.GettCity(oMemberID);
				oState = mm.GetState(oMemberID);
				oZip = mm.GetZip(oMemberID);
				oEmail = mm.GetEmail(oMemberID);
				submit.addActionListener(this);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(MemberIDPanel);
				frame.pack();
				frame.setVisible(true);
				}
				
				public void OutputPanel()
				{
					MemberReportPanel.setLayout(new GridLayout(14,2));
					MemberReportPanel.add(memberID);
					MemberReportPanel.add(iMemberID);
					MemberReportPanel.add(firstName);
					MemberReportPanel.add(iFirstName);
					MemberReportPanel.add(lastName);
					MemberReportPanel.add(iLastName);
					MemberReportPanel.add(middleInitial);
					MemberReportPanel.add(iMiddleInitial);
					MemberReportPanel.add(phoneNumber);
					MemberReportPanel.add(iPhoneNumber);
					MemberReportPanel.add(streetAddress );
					MemberReportPanel.add(iStreetAddress);
					MemberReportPanel.add(city );
					MemberReportPanel.add(iCity);
					MemberReportPanel.add(state );
					MemberReportPanel.add(iState);
					MemberReportPanel.add(zip );
					MemberReportPanel.add(iZip);
					MemberReportPanel.add(email);
					MemberReportPanel.add(iEmail);
					MemberReportPanel.add(OK);
					
					iMemberID.setText(String.valueOf(oMemberID));
					iFirstName.setText(oFirstName);
					iLastName.setText(oLastName);
					iMiddleInitial.setText(oMiddleInitial);
					iPhoneNumber.setText(oPhoneNumber);
					iStreetAddress.setText(oStreetAddress);
					iCity.setText(oCity);
					iState.setText(oState);
					iZip.setText(oZip);
					iEmail.setText(oEmail);
					OK.addActionListener(this);
					
					contentPane.removeAll();
					contentPane.validate();
					contentPane.repaint();
					contentPane.add(MemberReportPanel);
					frame.pack();
					frame.setVisible(true);
				}
						
			public void actionPerformed (ActionEvent event)
			{
				InputPanel();
				if(event.getActionCommand().equals("Submit"))
				{
				OutputPanel();
				}
				else if (event.getActionCommand().equals("Ok"))
				{
				mm.outputPersonal("memberPersonalReport.txt", oMemberID);
				frame.dispose();
				ManagerGUI();
				}
				//System.out.println(oMemberID);
				//	Member.getReport(oMemberID);			
			}				
		}
	
		
		MemberReport.addActionListener(new MemberReportActionListener());
		JMenuItem DeleteMember = new JMenuItem("Delete Member");
		
		class DeleteMemberListener implements ActionListener
		{
			JLabel memberID = new JLabel("Member ID:  ");
			JTextField iMemberID = new JTextField(10);
			JLabel firstName = new JLabel("First Name:  ");
			JTextField iFirstName = new JTextField(10);
			JLabel lastName = new JLabel("Last Name:  ");
			JTextField iLastName = new JTextField(10);
			JLabel middleInitial = new JLabel("MI:  ");
			JTextField iMiddleInitial = new JTextField(3);
			JLabel phoneNumber = new JLabel ("Phone Number:  ");
			JTextField iPhoneNumber = new JTextField(10);
			JLabel streetAddress = new JLabel("Street Address:  ");
			JTextField iStreetAddress = new JTextField(25);
			JLabel city = new JLabel("City:  ");
			JTextField iCity = new JTextField(15);
			JLabel state = new JLabel("State:  ");
			JTextField iState = new JTextField(2);
			JLabel zip = new JLabel("Zip Code:  ");				
			JTextField iZip = new JTextField(9);	
			JLabel email = new JLabel("Email Address");
			JTextField iEmail = new JTextField(20);
			JButton SubmitDelete = new JButton("Delete");
			JPanel DeleteMemberPanel = new JPanel( );	
			JPanel DeleteInputPanel = new JPanel( );	
			JButton SubmitID = new JButton("Submit ID");
			String oMemberID;
			String oFirstName;
			String oLastName;
			String oMiddleInitial;
			String oPhoneNumber;
			String oStreetAddress;
			String oCity;
			String oState;
			String oZip;
			String oEmail;
			
			public void DeleteMemberID()
			{
				DeleteMemberPanel.setLayout(new GridLayout(2,2));
				DeleteMemberPanel.add(memberID);
				DeleteMemberPanel.add(iMemberID);
				DeleteMemberPanel.add(SubmitID);
				oMemberID = iMemberID.getText();
				oFirstName = mm.GetFirstName(oMemberID);
				oLastName = mm.GetLastName(oMemberID);
				oMiddleInitial = mm.GetMiddleName(oMemberID);
				oPhoneNumber = mm.GetPhoneNumber(oMemberID);
				oStreetAddress = mm.GetStreet(oMemberID);
				oCity = mm.GettCity(oMemberID);
				oState = mm.GetState(oMemberID);
				oZip = mm.GetZip(oMemberID);
				oEmail = mm.GetEmail(oMemberID);
				SubmitID.addActionListener(this);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(DeleteMemberPanel);
				frame.pack();
				frame.setVisible(true);
			}
			
			public void DeleteMemberInfo()
			{
				 DeleteInputPanel.setLayout(new GridLayout(14,2));
				 DeleteInputPanel.add(memberID);
				 DeleteInputPanel.add(iMemberID);
				 DeleteInputPanel.add(firstName);
				 DeleteInputPanel.add(iFirstName);
				 DeleteInputPanel.add(lastName);
				 DeleteInputPanel.add(iLastName);
				 DeleteInputPanel.add(middleInitial);
				 DeleteInputPanel.add(iMiddleInitial);
				 DeleteInputPanel.add(phoneNumber);
				 DeleteInputPanel.add(iPhoneNumber);
				 DeleteInputPanel.add(streetAddress );
				 DeleteInputPanel.add(iStreetAddress);
				 DeleteInputPanel.add(city );
				 DeleteInputPanel.add(iCity);
				 DeleteInputPanel.add(state );
				 DeleteInputPanel.add(iState);
				 DeleteInputPanel.add(zip );
				 DeleteInputPanel.add(iZip);
				 DeleteInputPanel.add(email);
				 DeleteInputPanel.add(iEmail);
				 DeleteInputPanel.add(SubmitDelete);			
					
			    iMemberID.setText(String.valueOf(oMemberID));
				iFirstName.setText(oFirstName);
				iLastName.setText(oLastName);
				iMiddleInitial.setText(oMiddleInitial);
				iPhoneNumber.setText(oPhoneNumber);
				iStreetAddress.setText(oStreetAddress);
				iCity.setText(oCity);
				iState.setText(oState);
				iZip.setText(oZip);
				iEmail.setText(oEmail);
				
				iMemberID.setEditable(false);
				iFirstName.setEditable(false);
				iLastName.setEditable(false);
				iMiddleInitial.setEditable(false);
				iPhoneNumber.setEditable(false);
				iStreetAddress.setEditable(false);
				iCity.setEditable(false);
				iState.setEditable(false);
				iZip.setEditable(false);
				iEmail.setEditable(false);
				
				SubmitDelete.addActionListener(this);													
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(DeleteInputPanel);	
										
				frame.pack();
				frame.setVisible(true);	
			}
			
			public void actionPerformed (ActionEvent event)
			{
				DeleteMemberID();
				if(event.getActionCommand().equals("Submit ID"))
				{
					DeleteMemberInfo();
				}
				else if (event.getActionCommand().equals("Delete"))
				{
					mm.remove(oMemberID);
					mm.outputFile(memberInputFile);
					frame.dispose();
					ManagerGUI();
					
				}				
			}
		}
		
		DeleteMember.addActionListener(new DeleteMemberListener());
		
		//populate menu items
		memberMenu.add(AddMember);
		memberMenu.add(EditMember);
		memberMenu.add(SetInactive);
		memberMenu.add(DeleteMember );
		memberMenu.add(MemberReport);
		
		//Manager Provider Menu
		JMenu providerMenu = new JMenu("Provider");
		menubar.add(providerMenu);
		JMenuItem AddProvider = new JMenuItem("Add Provider");
		class AddProviderListener implements ActionListener
		{
				JLabel providerName = new JLabel("Provider Name:  ");
				JTextField iProviderName = new JTextField(10);
				JLabel streetAddress = new JLabel("Street Address:  ");
				JTextField iStreetAddress = new JTextField(10);
				JLabel city = new JLabel("City:  ");
				JTextField iCity = new JTextField(10);
				JLabel state = new JLabel("State:  ");
				JTextField iState = new JTextField(10);
				JLabel zip = new JLabel("Zip Code:  ");
				JTextField iZip = new JTextField(10);				
				JButton Submit = new JButton("Submit");
				JPanel AddProviderPanel = new JPanel( );
				
				String oProviderName;
				String oStreetAddress;
				String oCity;
				String oState;
				String oZip;
				
				public void AddProviderInput()
				{
					AddProviderPanel .setLayout(new GridLayout(8,2));
			//	EditProviderPanel.add(providerID);
			//	EditProviderPanel.add(iProviderID);
					AddProviderPanel .add(providerName);
					AddProviderPanel .add(iProviderName);
					AddProviderPanel .add(streetAddress );
					AddProviderPanel .add(iStreetAddress);
					AddProviderPanel .add(city );
					AddProviderPanel .add(iCity);
					AddProviderPanel .add(state );
					AddProviderPanel .add(iState);
					AddProviderPanel .add(zip );
					AddProviderPanel .add(iZip);
					AddProviderPanel .add(Submit);
					
					Submit.addActionListener(this);
					contentPane.removeAll();
					contentPane.validate();
					contentPane.repaint();
					contentPane.add(AddProviderPanel );
					
					frame.pack();
					frame.setVisible(true);
				}
				
			public void actionPerformed (ActionEvent event)
			{
				AddProviderInput();
				if (event.getActionCommand().equals("Submit"))
				{
					oProviderName = iProviderName.getText();
					oStreetAddress = iStreetAddress.getText();
					oCity = iCity.getText();
					oState = iState.getText();
					oZip = iZip.getText();
					p.Name = oProviderName;
					p.Street = oStreetAddress;
					p.City = oCity;
					p.State = oState;
					p.ZipCode = oZip;
					
					pl.input(p);
					pl.outputFile(providerInputFile);
					frame.dispose();
					ManagerGUI();					
				}
			//	JLabel providerID = new JLabel ("Provider ID:  ");
			//	JTextField iProviderID = new JTextField(10);			
				
			}
		}
		
		AddProvider.addActionListener(new AddProviderListener());
		JMenuItem EditProvider = new JMenuItem("Edit Provider");
		
		class EditProviderActionListener implements ActionListener
		{
			        JLabel providerID = new JLabel("Provider ID:  ");
					JTextField iProviderID = new JTextField(9);
					JLabel providerName = new JLabel("Provider Name:  ");
					JTextField iProviderName = new JTextField(25);
					JLabel streetAddress = new JLabel("Street Address:  ");
					JTextField iStreetAddress = new JTextField(25);
					JLabel city = new JLabel("City:  ");
					JTextField iCity = new JTextField(10);
					JLabel state = new JLabel("State:  ");
					JTextField iState = new JTextField(14);
					JLabel zip = new JLabel("Zip Code:  ");
					JTextField iZip = new JTextField(7);					
					JButton Submit = new JButton("Submit");
					JButton SubmitID = new JButton("Submit ID");
					JPanel EditProviderPanel = new JPanel( );	
					JPanel IDPanel = new JPanel();
					String oProviderID;
				    String oProviderName;
					String oStreetAddress;
					String oCity;
					String oState;
					String oZip;
					
		public void EnterID()
		{
			SubmitID.addActionListener(this);
			IDPanel.add(providerID);
			IDPanel.add(iProviderID);
			IDPanel.add(SubmitID);
			
			contentPane.validate();
			contentPane.repaint();
			contentPane.removeAll();
			contentPane.add(IDPanel);
			
			frame.pack();
			frame.setVisible(true);		
		}
		
		public void EditProvider()
		{
			EditProviderPanel.setLayout(new GridLayout(8,2));
			EditProviderPanel.add(providerID);
			EditProviderPanel.add(iProviderID);
			EditProviderPanel.add(providerName);
			EditProviderPanel.add(iProviderName);
			EditProviderPanel.add(streetAddress );
			EditProviderPanel.add(iStreetAddress);
			EditProviderPanel.add(city );
			EditProviderPanel.add(iCity);
			EditProviderPanel.add(state );
			EditProviderPanel.add(iState);
			EditProviderPanel.add(zip );
			EditProviderPanel.add(iZip);
			EditProviderPanel.add(Submit);
			Submit.addActionListener(this);
			iProviderName.setText( pl.GetName(oProviderID));
			iStreetAddress.setText(pl.GetStreet(oProviderID));
			iCity.setText(pl.GetCity(oProviderID));
			iState.setText(pl.GetState(oProviderID));
			iZip.setText(pl.GetZip(oProviderID));
			
			contentPane.removeAll();
			contentPane.validate();
			contentPane.repaint();
			contentPane.add(EditProviderPanel);	
			frame.pack();
			frame.setVisible(true);	
			
			}						
		public void actionPerformed (ActionEvent event)
        {				
				
			EnterID();
			if(event.getActionCommand().equals("Submit ID"))
			{
				 oProviderID = iProviderID.getText();

			 
			 EditProvider();				 				 
			}
			
			else if (event.getActionCommand().equals("Submit"))
			{
			 oProviderName = iProviderName.getText();		
			 oStreetAddress = iStreetAddress.getText();
			 oCity = iCity.getText();
			 oState = iState.getText();
			 oZip = iZip.getText();
			 						
			pl.EditName(oProviderName, oProviderID);
			pl.EditStreet(oStreetAddress, oProviderID);
			pl.EditCity(oCity, oProviderID);
			pl.EditState(oState, oProviderID);
			pl.EditZipCode(oZip, oProviderID);
			pl.outputFile(providerInputFile);
			frame.dispose();
			ManagerGUI();				
			}				
		}		
		}
		
		EditProvider.addActionListener(new EditProviderActionListener());
		
		JMenuItem DeleteProvider = new JMenuItem("Delete Provider");
		class DeleteProviderActionListener implements ActionListener
		{
			JLabel providerID = new JLabel("Provider ID:  ");
			JTextField iProviderID = new JTextField(9);
			JLabel providerName = new JLabel("Provider Name:  ");
			JTextField iProviderName = new JTextField(25);
			JLabel streetAddress = new JLabel("Street Address:  ");
			JTextField iStreetAddress = new JTextField(25);
			JLabel city = new JLabel("City:  ");
			JTextField iCity = new JTextField(10);
			JLabel state = new JLabel("State:  ");
			JTextField iState = new JTextField(14);
			JLabel zip = new JLabel("Zip Code:  ");
			JTextField iZip = new JTextField(7);					
			JButton Submit = new JButton("Submit");
			JButton SubmitID = new JButton("Submit ID");
			JPanel EnterIDPanel = new JPanel();
			JPanel DeleteProviderPanel = new JPanel( );	
			
			String oProviderID;
		    String oProviderName;
			String oStreetAddress;
			String oCity;
			String oState;
			String oZip;
			
			public void EnterID()
			{
				EnterIDPanel.add(providerID);
				EnterIDPanel.add(iProviderID);
				EnterIDPanel.add(SubmitID);
				
				SubmitID.addActionListener(this);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(EnterIDPanel);
				
				frame.pack();
				frame.setVisible(true);
			}
			public void DeleteProviderInfo()
			{
				DeleteProviderPanel.setLayout(new GridLayout(7,2));
				oProviderID = iProviderID.getText();
				oProviderName = pl.GetName(oProviderID);
				oStreetAddress = pl.GetStreet(oProviderID);
				oCity = pl.GetCity(oProviderID);
				oState = pl.GetState(oProviderID);
				oZip = pl.GetZip(oProviderID);
				
				iProviderName.setText(oProviderName);
				iStreetAddress.setText(oStreetAddress);
				iCity.setText(oCity);
				iState.setText(oState);
				iZip.setText(oZip);
				
				iProviderID.setEditable(false);
				iProviderName.setEditable(false);
				iStreetAddress.setEditable(false);
				iCity.setEditable(false);
				iState.setEditable(false);
				iZip.setEditable(false);
				
				DeleteProviderPanel.add(providerID);
				DeleteProviderPanel.add(iProviderID);
				DeleteProviderPanel.add(providerName);
				DeleteProviderPanel.add(iProviderName);
				DeleteProviderPanel.add(streetAddress);
				DeleteProviderPanel.add(iStreetAddress);
				DeleteProviderPanel.add(city);
				DeleteProviderPanel.add(iCity);
				DeleteProviderPanel.add(state);
				DeleteProviderPanel.add(iState);
				DeleteProviderPanel.add(zip);
				DeleteProviderPanel.add(iZip);
				DeleteProviderPanel.add(Submit);
				Submit.addActionListener(this);
							
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(DeleteProviderPanel);
				
				frame.pack();
				frame.setVisible(true);
				
			}
			
			public void actionPerformed (ActionEvent event)
			{
				EnterID();
				if (event.getActionCommand().equals("Submit ID"))
				{
					DeleteProviderInfo();
				}
				else if (event.getActionCommand().equals("Submit"))
				{
					pl.remove(oProviderID);
					pl.outputFile(providerInputFile);
					frame.dispose();
					ManagerGUI();	
				}		
			}
		}
		
		DeleteProvider.addActionListener(new DeleteProviderActionListener());
		//JMenuItem SetInactive = new JMenuItem("Set Member Inactive");
		JMenuItem ProviderReport = new JMenuItem("Run Provider Report");
		class ProviderReportActionListener implements ActionListener
		{
			JLabel providerID = new JLabel("Provider ID:  ");
			JTextField iProviderID = new JTextField(9);
			JLabel providerName = new JLabel("Provider Name:  ");
			JTextField iProviderName = new JTextField(25);
			JLabel streetAddress = new JLabel("Street Address:  ");
			JTextField iStreetAddress = new JTextField(25);
			JLabel city = new JLabel("City:  ");
			JTextField iCity = new JTextField(10);
			JLabel state = new JLabel("State:  ");
			JTextField iState = new JTextField(14);
			JLabel zip = new JLabel("Zip Code:  ");
			JTextField iZip = new JTextField(7);					
			JButton Submit = new JButton("Submit");
			JButton SubmitID = new JButton("Submit ID");
			JPanel EnterIDPanel = new JPanel();
			JPanel ProviderReportPanel = new JPanel( );	
			
			String oProviderID;
		    String oProviderName;
			String oStreetAddress;
			String oCity;
			String oState;
			String oZip;
			
			public void EnterID()
			{
				EnterIDPanel.add(providerID);
				EnterIDPanel.add(iProviderID);
				EnterIDPanel.add(SubmitID);
				
				SubmitID.addActionListener(this);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(EnterIDPanel);
				
				frame.pack();
				frame.setVisible(true);
			}
			
			public void ProviderReportinfo()
			{
				ProviderReportPanel.setLayout(new GridLayout(8,2));
				oProviderID = iProviderID.getText();
				oProviderName = pl.GetName(oProviderID);
				oStreetAddress = pl.GetStreet(oProviderID);
				oCity = pl.GetCity(oProviderID);
				oState = pl.GetState(oProviderID);
				oZip = pl.GetZip(oProviderID);
				
				iProviderName.setText(oProviderName);
				iStreetAddress.setText(oStreetAddress);
				iCity.setText(oCity);
				iState.setText(oState);
				iZip.setText(oZip);
				
				ProviderReportPanel.add(providerID);
				ProviderReportPanel.add(iProviderID);
				ProviderReportPanel.add(providerName);
				ProviderReportPanel.add(iProviderName);
				ProviderReportPanel.add(streetAddress);
				ProviderReportPanel.add(iStreetAddress);
				ProviderReportPanel.add(city);
				ProviderReportPanel.add(iCity);
				ProviderReportPanel.add(state);
				ProviderReportPanel.add(iState);
				ProviderReportPanel.add(zip);
				ProviderReportPanel.add(iZip);
				ProviderReportPanel.add(Submit);
				Submit.addActionListener(this);
				
				iProviderID.setEditable(false);
				iProviderName.setEditable(false);
				iStreetAddress.setEditable(false);
				iCity.setEditable(false);
				iState.setEditable(false);
				iZip.setEditable(false);
				
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(ProviderReportPanel);
				
				frame.pack();
				frame.setVisible(true);
			}
			public void actionPerformed (ActionEvent event)
			{
				EnterID();
				if(event.getActionCommand().equals("Submit ID"))
				{
				    ProviderReportinfo();
				}
				else if (event.getActionCommand().equals("Submit"))
				{
					pl.outputPersonalProvider("ProviderOutputReport.txt", oProviderID);
					frame.dispose();
					ManagerGUI();
				}
			
			}
		}
		
		ProviderReport.addActionListener(new ProviderReportActionListener());
		providerMenu.add(AddProvider);
		providerMenu.add(EditProvider);
		providerMenu.add(DeleteProvider );
		providerMenu.add(ProviderReport);
		
		
		//Manager Service Menu
		JMenu serviceMenu = new JMenu ("Service");
		menubar.add(serviceMenu);
		
		JMenuItem AddService = new JMenuItem("Add Service");
		class AddServiceActionListener implements ActionListener
		{
			JLabel serviceName = new JLabel("Service Name: ");
			JTextField iServiceName = new JTextField(10);
			JLabel serviceFee = new JLabel("Fee");
			JTextField iServiceFee = new JTextField(8);
			JButton Submit = new JButton("Submit");
			JPanel AddServicePanel = new JPanel();
			public void Input()
			{
			AddServicePanel.setLayout(new GridLayout(3,2));
			AddServicePanel.add(serviceName);
			AddServicePanel.add(iServiceName);
			AddServicePanel.add(serviceFee);
			AddServicePanel.add(iServiceFee);
			AddServicePanel.add(Submit);
			Submit.addActionListener(this);
			contentPane.removeAll();
			contentPane.validate();
			contentPane.repaint();
			contentPane.add(AddServicePanel);	
			
			s.NameofService = iServiceName.getText();
			s.FeeofService = iServiceFee.getText();
			
			frame.pack();
			frame.setVisible(true);	
			}
			
			public void actionPerformed (ActionEvent event)
			{
				Input();
				if (event.getActionCommand().equals("Submit"))
				{
					sl.input(s);
					sl.outputFile(serviceInputFile);
					frame.dispose();
					ManagerGUI();
				}
			}
		}		
		AddService.addActionListener(new AddServiceActionListener());
		
		
		JMenuItem EditService = new JMenuItem("Edit Service");
		class EditServiceActionListener implements ActionListener
		{
			JLabel serviceID = new JLabel("Service ID:  ");
			JTextField iServiceID = new JTextField(10);
			JLabel serviceName = new JLabel("Service Name: ");
			JTextField iServiceName = new JTextField(10);
			JLabel serviceFee = new JLabel("Fee");
			JTextField iServiceFee = new JTextField(8);
			JButton Submit = new JButton("Submit");
			JButton SubmitID = new JButton("Submit ID");
			JPanel EditServicePanel = new JPanel();
			JPanel EnterIDPanel = new JPanel();
			String oServiceName;
			String oServiceFee;
			String oServiceID;
			
			public void EnterID()
			{
				EnterIDPanel.add(serviceID);
				EnterIDPanel.add(iServiceID);
				EnterIDPanel.add(SubmitID);
				SubmitID.addActionListener(this);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(EnterIDPanel);					
				oServiceID = iServiceID.getText();
				frame.pack();
				frame.setVisible(true);
			}
			
			public void EnterService()
			{
				EditServicePanel.remove(SubmitID);
				EditServicePanel.setLayout(new GridLayout(5,2));
				EditServicePanel.add(serviceID);
				EditServicePanel.add(iServiceID);
				EditServicePanel.add(serviceName);
				EditServicePanel.add(iServiceName);
				EditServicePanel.add(serviceFee);
				EditServicePanel.add(iServiceFee);
				EditServicePanel.add(Submit);
				
				oServiceName = sl.GetServiceName(oServiceID);
				oServiceFee = sl.GetServiceFee(oServiceID);
				iServiceName.setText(oServiceName);
				iServiceFee.setText(oServiceFee);
				iServiceID.setEditable(false);
				Submit.addActionListener(this);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(EditServicePanel);					
				
				frame.pack();
				frame.setVisible(true);	
			}
			
			public void actionPerformed (ActionEvent event)
			{
				EnterID();
				if(event.getActionCommand().equals("Submit ID"))
				{
					EnterService();
				}
				
				else if (event.getActionCommand().equals("Submit"))
				{
					oServiceName = iServiceName.getText();
					oServiceFee = iServiceFee.getText();
				sl.EditServiceName(oServiceName, oServiceID);
				sl.EditFeeOfService(oServiceFee, oServiceID);
				sl.outputFile(serviceInputFile);
				frame.dispose();
				ManagerGUI();
				}				
			}
		}
		
		EditService.addActionListener(new EditServiceActionListener());
		
		JMenuItem DeleteService = new JMenuItem("Delete Service");
		class DeleteServiceActionListener implements ActionListener
		{
			JLabel serviceID = new JLabel("Service ID:  ");
			JTextField iServiceID = new JTextField(10);
			JLabel serviceName = new JLabel("Service Name: ");
			JTextField iServiceName = new JTextField(10);
			JLabel serviceFee = new JLabel("Fee");
			JTextField iServiceFee = new JTextField(8);
			JButton Submit = new JButton("Delete");
			JButton SubmitID = new JButton("Submit ID");
			JPanel EditServicePanel = new JPanel();
			JPanel EnterIDPanel = new JPanel();
			String oServiceName;
			String oServiceFee;
			String oServiceID;
			
			public void EnterID()
			{
				EnterIDPanel.add(serviceID);
				EnterIDPanel.add(iServiceID);
				EnterIDPanel.add(SubmitID);
				SubmitID.addActionListener(this);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(EnterIDPanel);					
				oServiceID = iServiceID.getText();
				frame.pack();
				frame.setVisible(true);
			}
			
			public void EnterService()
			{
				EditServicePanel.setLayout(new GridLayout(4,2));
				EditServicePanel.add(serviceID);
				EditServicePanel.add(iServiceID);
				EditServicePanel.add(serviceName);
				EditServicePanel.add(iServiceName);
				EditServicePanel.add(serviceFee);
				EditServicePanel.add(iServiceFee);
				EditServicePanel.add(Submit);
				
				oServiceName = sl.GetServiceName(oServiceID);
				oServiceFee = sl.GetServiceFee(oServiceID);
				iServiceName.setText(oServiceName);
				iServiceFee.setText(oServiceFee);
				
				iServiceID.setEditable(false);
				iServiceName.setEditable(false);
				iServiceFee.setEditable(false);
				
				Submit.addActionListener(this);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(EditServicePanel);					
				
				frame.pack();
				frame.setVisible(true);	
			}
			
			public void actionPerformed (ActionEvent event)
			{
				EnterID();
				if(event.getActionCommand().equals("Submit ID"))
				{
					EnterService();
				}
				
				else if (event.getActionCommand().equals("Delete"))
				{
				sl.remove(oServiceID);
								frame.dispose();
				ManagerGUI();
				}				
			}
		}
		
		DeleteService.addActionListener(new DeleteServiceActionListener());
		serviceMenu.add(AddService);
		serviceMenu.add(EditService);
		serviceMenu.add(DeleteService);		
		JMenu Exit = new JMenu("Exit");
		
		menubar.add(Exit);
		JMenuItem backToLogin = new JMenuItem("Back To Login");
		
		class backToLoginActionListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
			frame.dispose();
			LoginGUI();
			}
		}
		
		JMenuItem ExitApplication = new JMenuItem("Exit");
		class ExitApplicationActionListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
			System.exit(0);
			}
		}
		
		Exit.add(backToLogin);
		Exit.add(ExitApplication);		
		backToLogin.addActionListener(new backToLoginActionListener());	
		ExitApplication.addActionListener(new ExitApplicationActionListener());
		frame.setVisible(true);		
	}
	
	public static void OperatorGUI()
	{
		{
			final Manager_Member mm = new Manager_Member();
			final Provider_List pl = new Provider_List();
			final Service_List sl = new Service_List();
			final Member m = new Member();
			final Provider p = new Provider();
			final Service s = new Service();
			final JFrame frame = new JFrame();
			frame.setTitle("ChocAn Operator");
			frame.setLocationRelativeTo(null);
			frame.setSize(400,200);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Menu Bar for Manager Class
			JMenuBar menubar = new JMenuBar();
			frame.setJMenuBar(menubar);
				
			//Operator Member Menu
			
			final String memberInputFile =  "inputMember.txt";
			final String providerInputFile= "inputProvider.txt";
			final String serviceInputFile = "inputService.txt";
			mm.inputFile(memberInputFile);
			pl.inputFile(providerInputFile);
			sl.inputFile(serviceInputFile);
			
			JMenu memberMenu = new JMenu("Member");
			menubar.add(memberMenu);
			final Container contentPane = frame.getContentPane();
			contentPane.removeAll();
			JMenuItem AddMember = new JMenuItem("Add Member");
			
			//add member menu item interface
			class AddMemberActionListener implements ActionListener
			{			
				   
			    	JLabel firstName = new JLabel("First Name:  ");
					JTextField iFirstName = new JTextField(10);
					JLabel lastName = new JLabel("Last Name:  ");
					JTextField iLastName = new JTextField(10);
					JLabel middleInitial = new JLabel("MI:  ");
					JTextField iMiddleInitial = new JTextField(3);
					JLabel phoneNumber = new JLabel ("Phone Number:  ");
					JTextField iPhoneNumber = new JTextField(10);
					JLabel streetAddress = new JLabel("Street Address:  ");
					JTextField iStreetAddress = new JTextField(20);
					JLabel city = new JLabel("City:  ");
					JTextField iCity = new JTextField(15);
					JLabel state = new JLabel("State:  ");
					JTextField iState = new JTextField(2);
					JLabel zip = new JLabel("Zip Code:  ");				
					JTextField iZip = new JTextField(9);	
					JLabel email = new JLabel("Email Address");
					JTextField iEmail = new JTextField(20);
					JButton Submit = new JButton("Submit");
					
					JPanel AddMemberPanel = new JPanel( );	
					
				String oFirstName;
				String oLastName;
				String oMiddleInitial;
				String oPhoneNumber;
				String oStreetAddress;
				String oCity;
				String oState;
				String oZip;
				String oEmail;
							
			public void InputPanel()
			{
			
					AddMemberPanel.setLayout(new GridLayout(11,2));
					AddMemberPanel.add(firstName);
					AddMemberPanel.add(iFirstName);
					AddMemberPanel.add(lastName);
					AddMemberPanel.add(iLastName);
					AddMemberPanel.add(middleInitial);
					AddMemberPanel.add(iMiddleInitial);
					AddMemberPanel.add(phoneNumber);
					AddMemberPanel.add(iPhoneNumber);
					AddMemberPanel.add(streetAddress );
					AddMemberPanel.add(iStreetAddress);
					AddMemberPanel.add(city );
					AddMemberPanel.add(iCity);
					AddMemberPanel.add(state );
					AddMemberPanel.add(iState);
					AddMemberPanel.add(zip );
					AddMemberPanel.add(iZip);
					AddMemberPanel.add(email);
					AddMemberPanel.add(iEmail);
					AddMemberPanel.add(Submit);
					
					Submit.addActionListener(this);
					contentPane.removeAll();
					contentPane.validate();
					contentPane.repaint();
					contentPane.add(AddMemberPanel);
					
					frame.pack();
					frame.setVisible(true);					
			}
					
					public void actionPerformed (ActionEvent event)
				{				
						InputPanel();
						if(event.getActionCommand().equals("Submit"))
						{
							
						 oFirstName = iFirstName.getText();
						 oLastName = iLastName.getText();
						 oMiddleInitial = iMiddleInitial.getText();
						 oPhoneNumber = iPhoneNumber.getText();
						 oStreetAddress = iStreetAddress.getText();
						 oCity = iCity.getText();
						 oState = iState.getText();
						 oZip = iZip.getText();
						 oEmail = iEmail.getText();
						m.FirstName = oFirstName;
						m.LastName = oLastName;
						m.MiddleName = oMiddleInitial;
						m.PhoneNumber = oPhoneNumber;
						m.Street = oStreetAddress;
						m.City = oCity;
						m.State = oState;
						m.ZipCode = oZip;
						m.Email = oEmail;
						mm.input(m);
						mm.outputFile(memberInputFile);
						frame.dispose();
						OperatorGUI();				
						}
				}			
			}
			AddMember.addActionListener(new AddMemberActionListener());
			
			//edit member menu item interface
			JMenuItem EditMember = new JMenuItem("Edit Member");
			class EditMemberActionListener implements ActionListener
			{		
				JLabel memberID = new JLabel ("Member ID:  ");
				JTextField iMemberID = new JTextField(10);
		    	JLabel firstName = new JLabel("First Name:  ");
				JTextField iFirstName = new JTextField(10);
				JLabel lastName = new JLabel("Last Name:  ");
				JTextField iLastName = new JTextField(10);
				JLabel middleInitial = new JLabel("MI:  ");
				JTextField iMiddleInitial = new JTextField(3);
				JLabel phoneNumber = new JLabel ("Phone Number:  ");
				JTextField iPhoneNumber = new JTextField(10);
				JLabel streetAddress = new JLabel("Street Address:  ");
				JTextField iStreetAddress = new JTextField(20);
				JLabel city = new JLabel("City:  ");
				JTextField iCity = new JTextField(15);
				JLabel state = new JLabel("State:  ");
				JTextField iState = new JTextField(2);
				JLabel zip = new JLabel("Zip Code:  ");				
				JTextField iZip = new JTextField(9);	
				JLabel email = new JLabel("Email Address");
				JTextField iEmail = new JTextField(20);
				JButton SubmitID = new JButton("Submit ID");
				JPanel EditMemberPanel = new JPanel( );	
				JPanel EditInputPanel = new JPanel( );	
				JButton SubmitEdit = new JButton("Submit");
				
			// values for populating fields and outputting to file
				String oMemberID;
				String oFirstName;
				String oLastName;
				String oMiddleInitial;
				String oPhoneNumber;
				String oStreetAddress;
				String oCity;
				String oState;
				String oZip;
				String oEmail;
						
				public void InputID()
					{				
				    EditInputPanel.setLayout(new GridLayout(2,2));
					EditInputPanel.add(memberID);
					EditInputPanel.add(iMemberID);
					EditInputPanel.add(SubmitID);
				    oMemberID = iMemberID.getText();
					SubmitID.addActionListener(this);
					oFirstName = mm.GetFirstName(oMemberID);
					oLastName = mm.GetLastName(oMemberID);
					oMiddleInitial = mm.GetMiddleName(oMemberID);
					oPhoneNumber = mm.GetPhoneNumber(oMemberID);
					oStreetAddress = mm.GetStreet(oMemberID);
					oCity = mm.GettCity(oMemberID);
					oState = mm.GetState(oMemberID);
					oZip = mm.GetZip(oMemberID);
					oEmail = mm.GetEmail(oMemberID);
					contentPane.removeAll();
					contentPane.validate();
					contentPane.repaint();
					contentPane.add(EditInputPanel);				
					frame.pack();
					frame.setVisible(true);
					}
				
					public void  EditMemberForm()
					{	
						//generate edit form
						EditMemberPanel.setLayout(new GridLayout(14,2));
					 	EditMemberPanel.add(memberID);
					 	iMemberID.setEditable(false);
						EditMemberPanel.add(iMemberID);
						EditMemberPanel.add(firstName);
						EditMemberPanel.add(iFirstName);
						EditMemberPanel.add(lastName);
						EditMemberPanel.add(iLastName);
						EditMemberPanel.add(middleInitial);
						EditMemberPanel.add(iMiddleInitial);
						EditMemberPanel.add(phoneNumber);
						EditMemberPanel.add(iPhoneNumber);
						EditMemberPanel.add(streetAddress );
						EditMemberPanel.add(iStreetAddress);
						EditMemberPanel.add(city );
						EditMemberPanel.add(iCity);
						EditMemberPanel.add(state );
						EditMemberPanel.add(iState);
						EditMemberPanel.add(zip );
						EditMemberPanel.add(iZip);
						EditMemberPanel.add(email);
						EditMemberPanel.add(iEmail);
						EditMemberPanel.add(SubmitEdit);
						
						iMemberID.setText(oMemberID);
						iFirstName.setText(oFirstName);
						iLastName.setText(oLastName);
						iMiddleInitial.setText(oMiddleInitial);
						iPhoneNumber.setText(oPhoneNumber);
						iStreetAddress.setText(oStreetAddress);
						iCity.setText(oCity);
						iState.setText(oState);
						iZip.setText(oZip);
						iEmail.setText(oEmail);		
						SubmitEdit.addActionListener(this);													
						contentPane.removeAll();
						contentPane.validate();
						contentPane.repaint();
						contentPane.add(EditMemberPanel);	
												
						frame.pack();
						frame.setVisible(true);
					}
					
				public void actionPerformed (ActionEvent event)
		        {				
						
					InputID();
					if(event.getActionCommand().equals("Submit ID"))
					{
						 oMemberID = iMemberID.getText();

					 
					 EditMemberForm();				 				 
					}
					
					else if (event.getActionCommand().equals("Submit"))
					{
					 oFirstName = iFirstName.getText();
					 oLastName = iLastName.getText();
					 oMiddleInitial = iMiddleInitial.getText();
					 oPhoneNumber = iPhoneNumber.getText();
					 oStreetAddress = iStreetAddress.getText();
					 oCity = iCity.getText();
					 oState = iState.getText();
					 oZip = iZip.getText();
					 oEmail = iEmail.getText();
								
					mm.EditFirstName(oFirstName, oMemberID);
					mm.EditMiddleName(oMiddleInitial, oMemberID);
					mm.EditLastName(oLastName, oMemberID);
					mm.EditPhoneNUmber(oPhoneNumber, oMemberID);
					mm.EditStreet(oStreetAddress, oMemberID);
					mm.EditCity(oCity, oMemberID);
					mm.EditState(oState, oMemberID);
					mm.EditZipCode(oZip, oMemberID);
					mm.EditEmail(oEmail, oMemberID);
					mm.outputFile(memberInputFile);
					frame.dispose();
					OperatorGUI();				
					}				
				}
			}
			EditMember.addActionListener(new EditMemberActionListener());		
			
			//populate menu items
			memberMenu.add(AddMember);
			memberMenu.add(EditMember);
					
			//operator Provider Menu
			JMenu providerMenu = new JMenu("Provider");
			menubar.add(providerMenu);
			JMenuItem AddProvider = new JMenuItem("Add Provider");
			class AddProviderListener implements ActionListener
			{
					JLabel providerName = new JLabel("Provider Name:  ");
					JTextField iProviderName = new JTextField(10);
					JLabel streetAddress = new JLabel("Street Address:  ");
					JTextField iStreetAddress = new JTextField(10);
					JLabel city = new JLabel("City:  ");
					JTextField iCity = new JTextField(10);
					JLabel state = new JLabel("State:  ");
					JTextField iState = new JTextField(10);
					JLabel zip = new JLabel("Zip Code:  ");
					JTextField iZip = new JTextField(10);				
					JButton Submit = new JButton("Submit");
					JPanel AddProviderPanel = new JPanel( );
					
					String oProviderName;
					String oStreetAddress;
					String oCity;
					String oState;
					String oZip;
					
					public void AddProviderInput()
					{
						AddProviderPanel .setLayout(new GridLayout(8,2));
						AddProviderPanel .add(providerName);
						AddProviderPanel .add(iProviderName);
						AddProviderPanel .add(streetAddress );
						AddProviderPanel .add(iStreetAddress);
						AddProviderPanel .add(city );
						AddProviderPanel .add(iCity);
						AddProviderPanel .add(state );
						AddProviderPanel .add(iState);
						AddProviderPanel .add(zip );
						AddProviderPanel .add(iZip);
						AddProviderPanel .add(Submit);
						
						Submit.addActionListener(this);
						contentPane.removeAll();
						contentPane.validate();
						contentPane.repaint();
						contentPane.add(AddProviderPanel );
						
						frame.pack();
						frame.setVisible(true);
					}
					
				public void actionPerformed (ActionEvent event)
				{
					AddProviderInput();
					if (event.getActionCommand().equals("Submit"))
					{
						oProviderName = iProviderName.getText();
						oStreetAddress = iStreetAddress.getText();
						oCity = iCity.getText();
						oState = iState.getText();
						oZip = iZip.getText();
						p.Name = oProviderName;
						p.Street = oStreetAddress;
						p.City = oCity;
						p.State = oState;
						p.ZipCode = oZip;
						
						pl.input(p);
						pl.outputFile(providerInputFile);
						frame.dispose();
						OperatorGUI();					
					}
				}
			}
			
			AddProvider.addActionListener(new AddProviderListener());
			JMenuItem EditProvider = new JMenuItem("Edit Provider");
			
			class EditProviderActionListener implements ActionListener
			{
				        JLabel providerID = new JLabel("Provider ID:  ");
						JTextField iProviderID = new JTextField(9);
						JLabel providerName = new JLabel("Provider Name:  ");
						JTextField iProviderName = new JTextField(25);
						JLabel streetAddress = new JLabel("Street Address:  ");
						JTextField iStreetAddress = new JTextField(25);
						JLabel city = new JLabel("City:  ");
						JTextField iCity = new JTextField(10);
						JLabel state = new JLabel("State:  ");
						JTextField iState = new JTextField(14);
						JLabel zip = new JLabel("Zip Code:  ");
						JTextField iZip = new JTextField(7);					
						JButton Submit = new JButton("Submit");
						JButton SubmitID = new JButton("Submit ID");
						JPanel EditProviderPanel = new JPanel( );	
						JPanel IDPanel = new JPanel();
						String oProviderID;
					    String oProviderName;
						String oStreetAddress;
						String oCity;
						String oState;
						String oZip;
						
			public void EnterID()
			{
				SubmitID.addActionListener(this);
				IDPanel.add(providerID);
				IDPanel.add(iProviderID);
				IDPanel.add(SubmitID);
				
				contentPane.validate();
				contentPane.repaint();
				contentPane.removeAll();
				contentPane.add(IDPanel);
				
				frame.pack();
				frame.setVisible(true);		
			}
			
			public void EditProvider()
			{
				EditProviderPanel.setLayout(new GridLayout(8,2));
				EditProviderPanel.add(providerID);
				EditProviderPanel.add(iProviderID);
				EditProviderPanel.add(providerName);
				EditProviderPanel.add(iProviderName);
				EditProviderPanel.add(streetAddress );
				EditProviderPanel.add(iStreetAddress);
				EditProviderPanel.add(city );
				EditProviderPanel.add(iCity);
				EditProviderPanel.add(state );
				EditProviderPanel.add(iState);
				EditProviderPanel.add(zip );
				EditProviderPanel.add(iZip);
				EditProviderPanel.add(Submit);
				Submit.addActionListener(this);
				iProviderName.setText( pl.GetName(oProviderID));
				iStreetAddress.setText(pl.GetStreet(oProviderID));
				iCity.setText(pl.GetCity(oProviderID));
				iState.setText(pl.GetState(oProviderID));
				iZip.setText(pl.GetZip(oProviderID));
				
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(EditProviderPanel);	
				frame.pack();
				frame.setVisible(true);	
				
				}						
			public void actionPerformed (ActionEvent event)
	        {				
					
				EnterID();
				if(event.getActionCommand().equals("Submit ID"))
				{
					 oProviderID = iProviderID.getText();

				 
				 EditProvider();				 				 
				}
				
				else if (event.getActionCommand().equals("Submit"))
				{
				 oProviderName = iProviderName.getText();		
				 oStreetAddress = iStreetAddress.getText();
				 oCity = iCity.getText();
				 oState = iState.getText();
				 oZip = iZip.getText();
				 						
				pl.EditName(oProviderName, oProviderID);
				pl.EditStreet(oStreetAddress, oProviderID);
				pl.EditCity(oCity, oProviderID);
				pl.EditState(oState, oProviderID);
				pl.EditZipCode(oZip, oProviderID);
				pl.outputFile(providerInputFile);
				frame.dispose();
				OperatorGUI();				
				}				
			}		
		}
			
			EditProvider.addActionListener(new EditProviderActionListener());
			providerMenu.add(AddProvider);
			providerMenu.add(EditProvider);
						
			//Operator Service Menu
			JMenu serviceMenu = new JMenu ("Service");
			menubar.add(serviceMenu);
			
			JMenuItem AddService = new JMenuItem("Add Service");
			class AddServiceActionListener implements ActionListener
			{
				JLabel serviceName = new JLabel("Service Name: ");
				JTextField iServiceName = new JTextField(10);
				JLabel serviceFee = new JLabel("Fee");
				JTextField iServiceFee = new JTextField(8);
				JButton Submit = new JButton("Submit");
				JPanel AddServicePanel = new JPanel();
				public void Input()
				{
				AddServicePanel.setLayout(new GridLayout(3,2));
				AddServicePanel.add(serviceName);
				AddServicePanel.add(iServiceName);
				AddServicePanel.add(serviceFee);
				AddServicePanel.add(iServiceFee);
				AddServicePanel.add(Submit);
				Submit.addActionListener(this);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				contentPane.add(AddServicePanel);	
				
				s.NameofService = iServiceName.getText();
				s.FeeofService = iServiceFee.getText();
				
				frame.pack();
				frame.setVisible(true);	
				}
				
				public void actionPerformed (ActionEvent event)
				{
					Input();
					if (event.getActionCommand().equals("Submit"))
					{
						sl.input(s);
						sl.outputFile(serviceInputFile);
						frame.dispose();
						OperatorGUI();
					}
				}
			}		
			AddService.addActionListener(new AddServiceActionListener());
			
			
			JMenuItem EditService = new JMenuItem("Edit Service");
			class EditServiceActionListener implements ActionListener
			{
				JLabel serviceID = new JLabel("Service ID:  ");
				JTextField iServiceID = new JTextField(10);
				JLabel serviceName = new JLabel("Service Name: ");
				JTextField iServiceName = new JTextField(10);
				JLabel serviceFee = new JLabel("Fee");
				JTextField iServiceFee = new JTextField(8);
				JButton Submit = new JButton("Submit");
				JButton SubmitID = new JButton("Submit ID");
				JPanel EditServicePanel = new JPanel();
				JPanel EnterIDPanel = new JPanel();
				String oServiceName;
				String oServiceFee;
				String oServiceID;
				
				public void EnterID()
				{
					EnterIDPanel.add(serviceID);
					EnterIDPanel.add(iServiceID);
					EnterIDPanel.add(SubmitID);
					SubmitID.addActionListener(this);
					contentPane.removeAll();
					contentPane.validate();
					contentPane.repaint();
					contentPane.add(EnterIDPanel);					
					oServiceID = iServiceID.getText();
					frame.pack();
					frame.setVisible(true);
				}
				
				public void EnterService()
				{
					EditServicePanel.remove(SubmitID);
					EditServicePanel.setLayout(new GridLayout(5,2));
					EditServicePanel.add(serviceID);
					EditServicePanel.add(iServiceID);
					EditServicePanel.add(serviceName);
					EditServicePanel.add(iServiceName);
					EditServicePanel.add(serviceFee);
					EditServicePanel.add(iServiceFee);
					EditServicePanel.add(Submit);
					
					oServiceName = sl.GetServiceName(oServiceID);
					oServiceFee = sl.GetServiceFee(oServiceID);
					iServiceName.setText(oServiceName);
					iServiceFee.setText(oServiceFee);
					iServiceID.setEditable(false);
					Submit.addActionListener(this);
					contentPane.removeAll();
					contentPane.validate();
					contentPane.repaint();
					contentPane.add(EditServicePanel);					
					
					frame.pack();
					frame.setVisible(true);	
				}
				
				public void actionPerformed (ActionEvent event)
				{
					EnterID();
					if(event.getActionCommand().equals("Submit ID"))
					{
						EnterService();
					}
					
					else if (event.getActionCommand().equals("Submit"))
					{
						oServiceName = iServiceName.getText();
						oServiceFee = iServiceFee.getText();
					sl.EditServiceName(oServiceName, oServiceID);
					sl.EditFeeOfService(oServiceFee, oServiceID);
					sl.outputFile(serviceInputFile);
					frame.dispose();
					OperatorGUI();
					}				
				}
			}
			
			EditService.addActionListener(new EditServiceActionListener());
			
			
			serviceMenu.add(AddService);
			serviceMenu.add(EditService);
			JMenu Exit = new JMenu("Exit");
			
			menubar.add(Exit);
			JMenuItem backToLogin = new JMenuItem("Back To Login");
			
			class backToLoginActionListener implements ActionListener
			{
				public void actionPerformed (ActionEvent event)
				{
				frame.dispose();
				LoginGUI();
				}
			}
			
			JMenuItem ExitApplication = new JMenuItem("Exit");
			class ExitApplicationActionListener implements ActionListener
			{
				public void actionPerformed (ActionEvent event)
				{
				System.exit(0);
				}
			}
			
			Exit.add(backToLogin);
			Exit.add(ExitApplication);		
			backToLogin.addActionListener(new backToLoginActionListener());	
			ExitApplication.addActionListener(new ExitApplicationActionListener());
			frame.setVisible(true);		
		}
	}
	
	public static void ProviderGUI()
	{
		final Manager_Member mm = new Manager_Member();
		final Provider_List pl = new Provider_List();
		final Service_List sl = new Service_List();
		final Member m = new Member();
		final Provider p = new Provider();
		final Service s = new Service();
		final JFrame frame = new JFrame();
		frame.setTitle("ChocAn Provider");
		frame.setLocationRelativeTo(null);
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Menu Bar for provider Class
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
			
		//Provider Member Menu
		
		final String memberInputFile =  "inputMember.txt";
		String providerInputFile= "inputProvider.txt";
		String serviceInputFile = "inputService.txt";
		mm.inputFile(memberInputFile);
		pl.inputFile(providerInputFile);
		sl.inputFile(serviceInputFile);
		
		JMenu memberMenu = new JMenu("Member");
		menubar.add(memberMenu);
		final Container contentPane = frame.getContentPane();	
		
		//JMenuItem VerifyMember = new JMenuItem("Verify Member");
		class VerifyMemberActionListener implements ActionListener
		{
			JLabel memberID = new JLabel ("Member ID:  ");
			JTextField iMemberID = new JTextField(10);
			JButton SubmitID = new JButton("Submit ID");
			JTextField output = new JTextField(10);
			JButton done = new JButton("Done");
			
			JPanel IDInput = new JPanel();
			
			String oMemberID ;
			String oText = "";
			
			public void memberID()
			{
				IDInput.setLayout(new GridLayout(2,2));
				IDInput.add(memberID);
				IDInput.add(iMemberID);
				IDInput.add(output);
				IDInput.add(SubmitID);
				IDInput.add(done);
				String oMemberID = iMemberID.getText();
				SubmitID.addActionListener(this);
				done.addActionListener(this);
				output.setEditable(false);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				frame.add(IDInput);
				frame.pack();
				frame.setVisible(true);
			}
						
			public void actionPerformed (ActionEvent event)
			{
				memberID();
				
				if(event.getActionCommand().equals("Submit ID"))
				{
					if(mm.GetActive(oMemberID))
				 {
					 oText = "Member is Active";
				 }
					else
				 {
						oText = "Member is not Active";
				}
				}
				output.setText(oText);
				if(event.getActionCommand().equals("Done"))
				{
					frame.dispose();
					ProviderGUI();
				}
			}
		}
		
	//	VerifyMember.addActionListener(new VerifyMemberActionListener());
	
		JMenuItem AddServiceRecord = new JMenuItem("Add Service Record");
		class AddServiceRecordActionListener implements ActionListener
		{
			JLabel memberID = new JLabel ("Member ID:  ");
			JTextField iMemberID = new JTextField(10);
	    	JLabel firstName = new JLabel("First Name:  ");
			JTextField iFirstName = new JTextField(10);
			JLabel lastName = new JLabel("Last Name:  ");
			JTextField iLastName = new JTextField(10);
			JLabel middleInitial = new JLabel("MI:  ");
			JTextField iMiddleInitial = new JTextField(3);
			JLabel phoneNumber = new JLabel ("Phone Number:  ");
			JTextField iPhoneNumber = new JTextField(10);
			JLabel streetAddress = new JLabel("Street Address:  ");
			JTextField iStreetAddress = new JTextField(20);
			JLabel city = new JLabel("City:  ");
			JTextField iCity = new JTextField(15);
			JLabel state = new JLabel("State:  ");
			JTextField iState = new JTextField(2);
			JLabel zip = new JLabel("Zip Code:  ");				
			JTextField iZip = new JTextField(9);	
			JLabel email = new JLabel("Email Address");
			JTextField iEmail = new JTextField(20);
			JButton SubmitID = new JButton("Submit ID");
			
			JLabel serviceID = new JLabel("Add Service ID: ");
			JTextField iServiceID = new JTextField(10);
			JButton SubmitService = new JButton("Submit Service");
			JLabel ServiceDate = new JLabel("Service Date:  ");
			JTextField iServiceDate = new JTextField(10);
			JTextField errorText = new JTextField(10);
			JPanel IDInput = new JPanel();
			JPanel Input = new JPanel();
			
		// values for populating fields and outputting to file
			String oMemberID;
			String oFirstName;
			String oLastName;
			String oMiddleInitial;
			String oPhoneNumber;
			String oStreetAddress;
			String oCity;
			String oState;
			String oZip;
			String oEmail;
			String oServiceID ;
			String oServiceDate ;
			String Error = "";
			public void memberID()
			{
				IDInput.setLayout(new GridLayout(2,2));
				IDInput.add(memberID);
				IDInput.add(iMemberID);
				IDInput.add(SubmitID);
				IDInput.add(errorText);
				errorText.setEditable(false);
				SubmitID.addActionListener(this);
				oMemberID = iMemberID.getText();
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				frame.add(IDInput);
				frame.pack();
				frame.setVisible(true);
			}
			
			public void addService()
			{
				Input.setLayout(new GridLayout(13,2));
				Input.add(serviceID);
				Input.add(iServiceID);
				Input.add(ServiceDate);
				Input.add(iServiceDate);
				Input.add(firstName);
				Input.add(iFirstName);
				Input.add(lastName);
				Input.add(iLastName);
				Input.add(middleInitial);
				Input.add(iMiddleInitial);
				Input.add(phoneNumber);
				Input.add(iPhoneNumber);
				Input.add(streetAddress );
				Input.add(iStreetAddress);
				Input.add(city );
				Input.add(iCity);
				Input.add(state );
				Input.add(iState);
				Input.add(zip );
				Input.add(iZip);
				Input.add(email);
				Input.add(iEmail);
				Input.add(SubmitService);
				Input.add(errorText);
				
				oServiceID = iServiceID.getText();
				oServiceDate = iServiceDate.getText();
				oFirstName = mm.GetFirstName(oMemberID);
				oLastName = mm.GetLastName(oMemberID);
				oMiddleInitial = mm.GetMiddleName(oMemberID);
				oPhoneNumber = mm.GetPhoneNumber(oMemberID);
				oStreetAddress = mm.GetStreet(oMemberID);
				oCity = mm.GettCity(oMemberID);
				oState = mm.GetState(oMemberID);
				oZip = mm.GetZip(oMemberID);
				oEmail = mm.GetEmail(oMemberID);
				iMemberID.setText(oMemberID);
				iFirstName.setText(oFirstName);
				iLastName.setText(oLastName);
				iMiddleInitial.setText(oMiddleInitial);
				iPhoneNumber.setText(oPhoneNumber);
				iStreetAddress.setText(oStreetAddress);
				iCity.setText(oCity);
				iState.setText(oState);
				iZip.setText(oZip);
				iEmail.setText(oEmail);	
				errorText.setText(Error);
				iMemberID.setEditable(false);
				iFirstName.setEditable(false);
				iLastName.setEditable(false);
				iMiddleInitial.setEditable(false);
				iPhoneNumber.setEditable(false);
				iStreetAddress.setEditable(false);
				iCity.setEditable(false);
				iState.setEditable(false);
				iZip.setEditable(false);
				iEmail.setEditable(false);
				errorText.setEditable(false);
				SubmitService.addActionListener(this);
				contentPane.removeAll();
				contentPane.validate();
				contentPane.repaint();
				frame.add(Input);
				frame.pack();
				frame.setVisible(true);
			
			}
			public void actionPerformed (ActionEvent event)
			{
				memberID();
				
				if(event.getActionCommand().equals("Submit ID"))
				{
					if(mm.GetActive(oMemberID))
					addService();
					else
					{
					Error = "Member is not Active";
					}
					errorText.setText(Error);
				}
				else if(event.getActionCommand().equals("Submit Service"))
				{
					
					{
					mm.AddService(oServiceID, oMemberID, oServiceDate);
					mm.outputFile(memberInputFile);
					frame.dispose();
					ProviderGUI();
					}
					
				}
			
			}
		
		}
		
		AddServiceRecord.addActionListener(new AddServiceRecordActionListener());
		//memberMenu.add(VerifyMember);
		memberMenu.add(AddServiceRecord);
				
		//Provider Service Menu
		JMenu serviceMenu = new JMenu ("Service");
		menubar.add(serviceMenu);
		
		JMenuItem RequestList = new JMenuItem("Request List Of Services");
		class RequestListActionListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
			sl.outputFile("ServiceList.txt");
			frame.dispose();
			ProviderGUI();
			}
		}
		
		RequestList.addActionListener(new RequestListActionListener());
		serviceMenu.add(RequestList);
		
		
		JMenu Exit = new JMenu("Exit");
		menubar.add(Exit);
		JMenuItem backToLogin = new JMenuItem("Back To Login");
		class backToLoginActionListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
				frame.dispose();
			LoginGUI();
			}
		}
		
		JMenuItem ExitApplication = new JMenuItem("Exit");
		class ExitApplicationActionListener implements ActionListener
		{
			public void actionPerformed (ActionEvent event)
			{
			System.exit(0);
			}
		}
		
		Exit.add(backToLogin);
		Exit.add(ExitApplication);	
		backToLogin.addActionListener(new backToLoginActionListener());	
		ExitApplication.addActionListener(new ExitApplicationActionListener());
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		
	}
	
}


