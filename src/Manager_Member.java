package ChocAn;

import java.io.*;
import java.util.Scanner;

public class Manager_Member {
	public Node head;
	public int listCount;
	  int NumberofProvider = 0;
	  int NumberofService = 0;
	  int NumberofMember = 0;
	public static Service_List sll = new Service_List();
	public Manager_Member()
	{
		head = null;
		listCount = 0;
	}
	
	public void add(Node temp)
	{
		if(head == null)
		{
			head = temp;
			head.setNext(null);
			if (head.m.ID == null)
			head.m.ID = "M10000000";
		}
		else
		{
			Node current;
			current = head;
			while (current.getNext() != null)
			{
				current = current.getNext();
			}
			temp.setNext(null);
			if (temp.m.ID == null)
			temp.m.ID = randomID();
			current.setNext(temp);
		}
		listCount++;
		
	}
	
	public void add(Node temp, int index)
	{
		Node current = head;
		for(int i =1;i<index &&current.getNext() != null;i++)
		{
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		listCount++;
	}
	
	public void remove(String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't any body in this list");
		}
		else
		{
			if(current.m.ID.equals(_ID))
			{
				head = current.getNext();
				current = null;
			}
			else
			{
				while(current.getNext() != null)
				{
					if(current.next.m.ID.equals(_ID))
					{
						Node current1 = null;
						current1 = current.getNext();
							current.setNext(current.getNext().getNext());
							current1 = null;
						
						break;
					}
					current = current.getNext();
				}
			}
		}
		listCount--;
	}
	
	public int size()
	{
		Node current = head;
		if(head == null)
		{
			listCount = 0;
		}
		else
		{
			while(current.getNext() != null)
			{
				listCount++;
			}
		}
		return listCount;
	}
	
	public Node get(int index)
	{
		if(index <= 0)
		{
			return null;
		}
		Node current = head.getNext();
		for(int i = 1;i<index;i++)
		{
			if(current.getNext() == null)
			{
				return null;
			}
			current = current.getNext();
		}
		return current.getData();
	}
	
	public void inputFile(String filename)
	{
		sll.inputFile("inputService.txt");
		try
		{
			 FileInputStream fstream = new FileInputStream(filename);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine = br.readLine();
			  String strLine1 ="";
			  String strLine2 = "";
			  String strLine3 = "";
			  String strLine4 = "";
			  NumberofMember = Integer.parseInt(strLine);
			  for(int i = 0; i < NumberofMember; i++)
			  {						
				  Member m = new Member();
				  m.FirstName= br.readLine();
				  m.LastName = br.readLine();
				  m.MiddleName = br.readLine();
				  m.ID = br.readLine();
				  strLine1 = br.readLine();
				  if(strLine1.equals("True"))
				  {
					  m.Active = true;
				  }
				  else
				  {
					  m.Active = false;
				  }
				  m.PhoneNumber = br.readLine();
				  m.Street = br.readLine();
				  m.City = br.readLine();
				  m.State = br.readLine();
				  m.ZipCode = br.readLine();
				  m.Email = br.readLine();
				  strLine2 = br.readLine();
				  if(strLine2.equals("0"))
				  {
					  NumberofProvider = Integer.parseInt(strLine2);
				  }
				  else
				  {
					  NumberofProvider = Integer.parseInt(strLine2);
					  m.p = new Provider[NumberofProvider];
					  for(int j =0; j <NumberofProvider; j++)
					  {
						  m.p[j] = new Provider();
						  m.p[j].Name = br.readLine();
					  }
				  }
				  strLine3 = br.readLine();
				  if(strLine3.equals("0"))
				  {
					  NumberofService = Integer.parseInt(strLine3);
				  }
				  else
				  {
					  NumberofService = Integer.parseInt(strLine3);
					  m.s = new Service[NumberofService];
					  for(int k =0; k <NumberofService; k++)
					  {
						  strLine4 = br.readLine();
						  m.s[k] = new Service();
						  m.s[k].NameofService = strLine4;
						  m.s[k].DateofService = br.readLine();
						  m.s[k] = sll.GetServiceInfo(strLine4);					  
					  }
				  }
				  Node mll = new Node(m);			  
				  add(mll);
			  }
			  in.close();
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void outputFile(String filename)
	{
		try
		{
			 FileOutputStream out = new FileOutputStream(filename); // declare a file output object
	          PrintStream p1 = new PrintStream( out ); // declare a print stream object
	        if(head != null)
	        {
	        	Node current = head;
	        	p1.println(listCount);
	        	for(int i = 1; i<= listCount ;i++)
	        	{
	        			p1.println(current.m.FirstName);
	        			p1.println(current.m.LastName);
	        			p1.println(current.m.MiddleName);
	        			p1.println(current.m.ID);
	        			if(current.m.Active == true)
	        			{
	        				p1.println("True");
	        			}
	        			else if(current.m.Active == false)
	        			{
	        				p1.println("False");
	        			}
	        			p1.println(current.m.PhoneNumber);
	        			p1.println(current.m.Street);
	        			p1.println(current.m.City);
	        			p1.println(current.m.State);
	        			p1.println(current.m.ZipCode);
	        			p1.println(current.m.Email);
	        			p1.println(current.m.p.length);
	        			if(current.m.p.length != 0)
	        			{
		        			for(int j = 0; j < current.m.p.length; j++)
		        			{
		        				p1.println(current.m.p[j].Name);
		        			}
	        			}
	        			p1.println(current.m.s.length);
	        			if(current.m.p.length != 0)
	        			{
		        			for(int k = 0; k < current.m.s.length;k++)
		        			{
		        				p1.println(current.m.s[k].NameofService);
		        				p1.println(current.m.s[k].DateofService);
		        			}
	        			}
	        		current = current.getNext();
	        	}
	        }
	         out.close(); 
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
	}
		
	public void input(Member m)
	{		
		Node temp = new Node(m);
		add(temp);
	}
	
	public String GetFirstName( String _MemberID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't any body in this list");
		}
		else
		{
			for(int i = 1; i <= listCount; i++)
			{
				if(current.m.ID.equals(_MemberID))
				{
					return current.m.FirstName;
				}
				current = current.getNext();
			}
		}
		return null;		
	}
	
	public String GetLastName( String _MemberID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't any body in this list");
		}
		else
		{
			for(int i = 1; i <= listCount; i++)
			{
				if(current.m.ID.equals(_MemberID))
				{
					return current.m.LastName;
				}
				current = current.getNext();
			}
		}
		return null;		
	}
	
	public String GetMiddleName( String _MemberID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't any body in this list");
		}
		else
		{
			for(int i = 1; i <= listCount; i++)
			{
				if(current.m.ID.equals(_MemberID))
				{
					return current.m.MiddleName;
				}
				current = current.getNext();
			}
		}
		return null;		
	}
	
	public String GetPhoneNumber( String _MemberID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't any body in this list");
		}
		else
		{
			for(int i = 1; i <= listCount; i++)
			{
				if(current.m.ID.equals(_MemberID))
				{
					return current.m.PhoneNumber;
				}
				current = current.getNext();
			}
		}
		return null;		
	}
	
	public String GetStreet( String _MemberID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't any body in this list");
		}
		else
		{
			for(int i = 1; i <= listCount; i++)
			{
				if(current.m.ID.equals(_MemberID))
				{
					return current.m.Street;
				}
				current = current.getNext();
			}
		}
		return null;		
	}
	
	
	public String  GettCity( String _MemberID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't any body in this list");
		}
		else
		{
			for(int i = 1;i <= listCount; i++)
			{
				if(current.m.ID.equals(_MemberID))
				{
					return current.m.City;
				}
				current = current.getNext();
			}
		}
		return null;
	}
	
	public String GetState(String _MemberID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't any body in this list");
		}
		else
		{
			for(int i = 1; i<= listCount; i++)
			{
				if(current.m.ID.equals(_MemberID))
				{
					return current.m.State;
				}
				current = current.getNext();
			}
		}
		return null;
	}
	
	public String GetZip(String _MemberID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't any body in this list");
		}
		else
		{
			for(int i = 1; i<= listCount; i++)
			{
				if(current.m.ID.equals(_MemberID))
				{
					return current.m.ZipCode;
				}
				current = current.getNext();
			}
		}
		return null;
	}
	
	public String GetEmail(String _MemberID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't any body in this list");
		}
		else
		{
			for(int i = 1; i<= listCount; i++)
			{
				if(current.m.ID.equals(_MemberID))
				{
					return current.m.Email;
				}
				current = current.getNext();
			}
		}
		return null;
	}
	
	public Node EditActive(Boolean active, String _MemberID)
	{
		
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't any body in this list");
		}
		else
		{
			for(int i = 1; i<= listCount; i++)
			{
				if(current.m.ID.equals(_MemberID))
				{
					current.m.Active = active;
				}
				current = current.getNext();
			}
		}
		return current;
	}

	public boolean GetActive(String _MemberID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't any body in this list");
		}
		else
		{
			for(int i = 1; i<= listCount; i++)
			{
				if(current.m.ID.equals(_MemberID))
				{
					return current.m.Active;
				}
				current = current.getNext();
			}
		}
		return false;
	}

	public void EditFirstName(String _FirstName, String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't any body in this list");
		}
		else
		{
			for(int i = 1; i <= listCount; i++)
			{
				if(current.m.ID.equals(_ID))
					
				{
					if(_FirstName.isEmpty())
					{
						current.m.FirstName = current.m.FirstName;
					}
					else
					{
						current.m.FirstName = _FirstName;
					}
				}
				current = current.getNext();
			}
		}
	}
	
	public void EditLastName(String _LastName, String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't any body in this list");
		}
		else
		{
			for(int i = 1; i <= listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{
					if(_LastName.isEmpty())
					{
						current.m.LastName = current.m.LastName;
					}
					else
					{
						current.m.LastName = _LastName;
					}
				}
				current = current.getNext();
			}
		}
	}
	
	public void EditMiddleName(String _MiddleName, String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't any body in this list");
		}
		else
		{
			for(int i = 1; i <= listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{
					if(_MiddleName.isEmpty())
					{
						current.m.MiddleName = current.m.MiddleName;
					}
					else
					{
						current.m.MiddleName = _MiddleName;
					}
				}
				current = current.getNext();
			}
		}	
	}
	
	public void EditPhoneNUmber(String _PhoneNumber, String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't any body in this list");
		}
		else
		{
			for(int i = 1; i <= listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{
					if(_PhoneNumber.isEmpty())
					{
						current.m.PhoneNumber = current.m.PhoneNumber;
					}
					else
					{
						current.m.PhoneNumber = _PhoneNumber;
					}
				}
				current = current.getNext();
			}
		}
	}
	
	public void EditStreet(String _Street, String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't any body in this list");
		}
		else
		{
			for(int i = 1; i <= listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{
					if(_Street.isEmpty())
					{
						current.m.Street =  current.m.Street;
					}
					else
					{
						current.m.Street = _Street;
					}
					
				}
				current = current.getNext();
			}
		}
	}
	
	public void EditCity(String _City, String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't any body in this list");
		}
		else
		{
			for(int i = 1;i <= listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{
					if(_City.isEmpty())
					{
						current.m.City = current.m.City;
					}
					else
					{
						current.m.City = _City;
					}
				}
				current = current.getNext();
			}
		}
	}
	
	public void EditState(String _State, String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't any body in this list");
		}
		else
		{
			for(int i = 1; i<= listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{
					if(_State.isEmpty())
					{
						current.m.State = current.m.State;
					}
					else
					{
						current.m.State = _State;
					}
				}
				current = current.getNext();
			}
		}
	}
	
	public void EditZipCode(String _ZipCode, String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't any body in this list");
		}
		else
		{
			for(int i = 1; i<= listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{
					if(_ZipCode.isEmpty())
					{
						current.m.ZipCode = current.m.ZipCode;
					}
					else
					{
						current.m.ZipCode = _ZipCode;
					}
				}	
				current = current.getNext();
			}
		}
	}
	
	public void EditEmail(String _Email, String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't any body in this list");
		}
		else
		{
			for(int i = 1; i<= listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{
					if(_Email.isEmpty())
					{
						current.m.Email = current.m.Email;
					}
					else
					{
						current.m.Email = _Email;
					}
				}
				current = current.getNext();
			}
		}
	}
	
	public String randomID()
	{
		Node current = head;
		String generateID = "";
		String temp = "";
		int LastCharacter = 0;
		String newID = "";
		if(current == null)
		{ 
			System.out.println("There aren't a list in the system");
		}
		else
		{
			for(int i = 0;i< listCount; i++)
			{
				if(current.getNext() == null)
				{
					int temp1 = current.m.ID.length() -1;
					temp = current.m.ID.substring(1);
					LastCharacter = Integer.parseInt(temp);
					LastCharacter++;
					generateID = Integer.toString(LastCharacter);
					newID = current.m.ID.substring(0,1) + generateID;
				}
				current = current.getNext();
			}
		}
		return newID;
	}
	
	public void SetInActiveID(String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't list in the system");
		}
		else
		{
			for(int i = 0; i<listCount;i++)
			{
				if(current.m.ID.equals(_ID))
				{
					if(current.m.Active == true)
					{
						current.m.Active = false;
					}
					else
					{
						current.m.Active = true;
					}
				}
				current = current.getNext();
			}
				
		}
	}
	
	public void outputPersonal(String filename,String _ID)
	{
		try
		{
			 FileOutputStream out = new FileOutputStream(filename); // declare a file output object
	          PrintStream p1 = new PrintStream( out ); // declare a print stream object
	        	Node current = head;
	        	for(int i =0; i<listCount;i++)
	        	{
		        	if(current.m.ID.equals(_ID))
		        	{
		        		String Fee = getFee(current.m.ID);
		        			p1.println(current.m.FirstName);
		        			p1.println(current.m.LastName);
		        			p1.println(current.m.MiddleName);
		        			p1.println(current.m.ID);
		        			if(current.m.Active == true)
		        			{
		        				p1.println("True");
		        			}
		        			else if(current.m.Active == false)
		        			{
		        				p1.println("False");
		        			}
		        			p1.println(current.m.PhoneNumber);
		        			p1.println(current.m.Street);
		        			p1.println(current.m.City);
		        			p1.println(current.m.State);
		        			p1.println(current.m.ZipCode);
		        			p1.println(current.m.Email);
		        			p1.println(current.m.p.length);
		        			if(current.m.p.length !=0)
		        			{
			        			for(int j = 0; j < current.m.p.length; j++)
			        			{
			        				p1.println(current.m.p[j].Name);
			        			}
		        			}
		        			p1.println(current.m.s.length);
		        			if(current.m.s.length != 0)
		        			{
		        				for(int k = 0; k < current.m.s.length;k++)
		        				{
			        				p1.println(current.m.s[k].NameofService);
			        				p1.println(current.m.s[k].DateofService);
			        				p1.println(current.m.s[k].FeeofService);
			        			}
		        			}
		        			p1.println(Fee);
		        	}
		        	current = current.getNext();
	        	}
	         out.close(); 
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
	}
	
	public String getFee(String _ID)
	{
		Node current = head;
		String TotalFee = "";
		int Fee = 0;
		String oFee = "";
		int tempFee = 0;
		if(current == null)
		{
			System.out.println("There is not a list in the system");
		}
		else
		{
			for(int i =0; i <listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{
							for(int j =0; j <current.m.s.length; j++)
							{
								oFee = current.m.s[j].FeeofService;
								tempFee = Integer.parseInt(oFee);
								Fee = tempFee + Fee;
							}
				}
				current = current.getNext();
			}
			TotalFee = Integer.toString(Fee);
		}
		return TotalFee;
	}
	
	public Member GetInfo(String _ID)
	{
		Node current = head;
		Member _m = new Member();
		if(current == null)
		{
			System.out.println("There isn't a list in the system");
		}
		else
		{
			for(int i =0; i< listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{
					_m = current.m;
				}
				current = current.getNext();
			}
		}
		return _m;
	}
	
	public void CheckMember(String _ID)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't a list in the system");
		}
		else
		{
			for(int i =0; i< listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{
					System.out.println("There is member in the list");
					break;
				}
				else
				{
					System.out.println("There isn't member in the list");
				}
				current = current.getNext();
			}
		}
	}
	
	public void AddService(String _ID, String _ServiceID, String _Date)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There isn't a list in the system");
		}
		else
		{
			for(int i =0; i< listCount; i++)
			{
				if(current.m.ID.equals(_ID))
				{		
					if(_ServiceID.isEmpty())
					{
						current.m.s = current.m.s;
					}
					else if(current.m.s == null)
					{	
						current.m.s = new Service[1];
						current.m.s[0] = new Service();
						current.m.s[0] = sll.GetServiceInfo(_ServiceID);
						current.m.s[0].DateofService = _Date;
					}
					else if(current.m.s != null)
					{
						Service [] _s = new Service[current.m.s.length + 1];
						for(int k = 0; k < current.m.s.length;k++)
						{
							_s[k] = new Service();
							_s[k] = current.m.s[k];
							
						}
						current.m.s = null;
						current.m.s = new Service[_s.length];
						for(int o = 0; o<current.m.s.length;o++)
						{
							current.m.s[o] = new Service();
							current.m.s[o] = _s[o];
							if(o == current.m.s.length -1)
							{
								current.m.s[o] = sll.GetServiceInfo(_ServiceID);
								current.m.s[o].DateofService = _Date;
							}
						}
					}
					break;
				}
				else
				{
					System.out.println("There isn't member in the list");
				}
				current = current.getNext();
			}
		}
	}
		
		public void AddProvider(String _ID, String _ProviderName)
		{
			Node current = head;
			if(current == null)
			{
				System.out.println("There isn't a list in the system");
			}
			else
			{
				for(int i =0; i< listCount; i++)
				{
					if(current.m.ID.equals(_ID))
					{			
						if(_ProviderName.isEmpty())
						{
							current.m.p = current.m.p;
						}
						else if(current.m.p == null)
						{	
							current.m.p = new Provider[1];
							current.m.p[0] = new Provider();
							current.m.p[0].Name = _ProviderName;
						}
						else if(current.m.p != null)
						{
							Provider [] _p = new Provider[current.m.p.length + 1];
							for(int k = 0; k < current.m.p.length;k++)
							{
								_p[k] = new Provider();
								_p[k] = current.m.p[k];
							}
							current.m.p = null;
							current.m.p = new Provider[_p.length];
							for(int o = 0; o<current.m.p.length;o++)
							{
								current.m.p[o] = new Provider();
								if(o == current.m.p.length -1)
								{
									current.m.p[o].Name = _ProviderName;
								}
								else
								{
									current.m.p[o] = _p[o];
								}
							}
						}
						break;
					}
					else
					{
						System.out.println("There isn't member in the list");
					}
					current = current.getNext();
				}
			}
	}
	public static class Node
	{
		Node next;
		Member m = new Member();
		
		public Node(Member _m)
		{
			next = null;
			m.FirstName = _m.FirstName;
			m.LastName = _m.LastName;
			m.MiddleName = _m.MiddleName;
			m.ID = _m.ID;
			m.Active = _m.Active;
			m.PhoneNumber = _m.PhoneNumber;
			m.Street = _m.Street;
			m.City = _m.City;
			m.State = _m.State;
			m.ZipCode = _m.ZipCode;
			m.Email = _m.Email;
			m.p = new Provider[_m.p.length];
			for(int i =0; i< _m.p.length;i++)
			{
				m.p[i] = new Provider();
				m.p[i].Name = _m.p[i].Name;
			}
			m.s = new Service[_m.s.length];
			for(int j = 0; j <_m.s.length;j++)
			{
				m.s[j] = new Service();
				m.s[j] = _m.s[j];
			}
		}
		
		public void setNext(Node _next)
		{
			next = _next;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public Node getData()
		{
			return next;
		}	
	}
}
