package ChocAn;

import java.io.*;
import java.util.*;

import org.w3c.dom.Node;


public class Provider_List 
{
		private Node head;
		private int listCount;
		public static Manager_Member _m = new Manager_Member();
		public Provider_List()
		{
			head = null;
			listCount = 0;
		}
		
		public void add(Node temp)
		{
			if(head == null)
			{
				head= temp;
				if (temp.p.ID == null)
				temp.p.ID = "P10000000";
				head.setNext(null);
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
				if (temp.p.ID == null)
				temp.p.ID = randomID();
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
				if(current.p.ID.equals(_ID))
				{
					head = current.getNext();
					current = null;
				}
				else
				{
					while(current.getNext() != null)
					{
						if(current.next.p.ID.equals(_ID))
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
			_m.inputFile("inputMember.txt");
			try
			{
				 FileInputStream fstream = new FileInputStream(filename);
				  // Get the object of DataInputStream
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine = br.readLine();
				  int NumberofProvider = Integer.parseInt(strLine);
				  int NumberofMember = 0;
				  int NumberofService = 0;
				  String strLine1 = "";
				  String strLine2 = "";
				  String strLine3 = "";
				  String strLine4 = "";
				  for(int i = 0; i < NumberofProvider; i++)
				  {						
					  Provider p = new Provider();
					  p.Name= br.readLine();
					  p.ID = br.readLine();
					  p.Street = br.readLine();
					  p.City = br.readLine();
					  p.State = br.readLine();
					  p.ZipCode = br.readLine();
					  strLine1 = br.readLine();
					  if(strLine1.equals("0"))
					  {
						  NumberofMember = 0;
					  }
					  else
					  {
						  NumberofMember = Integer.parseInt(strLine1);
						  p.m = new Member[NumberofMember];
						  for(int j = 0; j < NumberofMember;j++)
						  {
							  p.m[j] = new Member();
							  p.m[j].FirstName = br.readLine();
							  p.m[j].ID = br.readLine();
							  p.m[j] = _m.GetInfo(p.m[j].ID);
							  strLine2 = br.readLine();
							  if(strLine2.equals("0"))
							  {
								  NumberofService = 0;
							  }
							  else
							  {
								  NumberofService = Integer.parseInt(strLine2);
								  for(int k = 0; k < p.m[j].s.length;k++)
								  {
			        				p.m[j].s[k].DateofService = br.readLine();
			        				p.m[j].s[k].IDofService = br.readLine();
			        				p.m[j].s[k].FeeofService = br.readLine();
								  }
							  }
						  }
					  }
					  strLine3 = br.readLine();
					  if(strLine3.equals("0"))
					  {
						  p.Consultation = 0;
					  }
					  else
					  {
						  p.Consultation = Integer.parseInt(strLine3);
					  }
					  strLine4 = br.readLine();
					  if(strLine4.equals("0"))
					  {
						  p.TotalFee = "0";
					  }
					  else
					  {
						 p.TotalFee = strLine4;
					  }
					  Node pll = new Node(p);			  
					  add(pll);
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
		        		current.p.TotalFee = getFee(current.p.ID);
		        			p1.println(current.p.Name);
		        			p1.println(current.p.ID);
		        			p1.println(current.p.Street);
		        			p1.println(current.p.City);
		        			p1.println(current.p.State);
		        			p1.println(current.p.ZipCode);
		        			p1.println(current.p.m.length);
		        			for(int j = 0; j < current.p.m.length; j++)
		        			{
		        				p1.println(current.p.m[j].FirstName);
		        				p1.println(current.p.m[j].ID);
		        				p1.println(current.p.m[j].s.length);
		        				for(int k = 0; k < current.p.m[j].s.length;k++)
			        			{
			        				p1.println(current.p.m[j].s[k].DateofService);
			        				p1.println(current.p.m[j].s[k].IDofService);
			        				p1.println(current.p.m[j].s[k].FeeofService);
			        			}
		        			}
	        				p1.println(current.p.Consultation);
    						p1.println(current.p.TotalFee);
		        		current = current.getNext();
		        	}
		        }
		         out.close(); 
			}catch (Exception e){//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
			}
		}
			
		public void input(Provider p)
		{
			Node temp = new Node(p);
			add(temp);
		}
				
		public String GetZip(String _ID)
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
					if(current.p.ID.equals(_ID))
					{
						return current.p.ZipCode;
					}
					current = current.getNext();
				}
			}
			return null;
		}
		
		public String GetState(String _ID)
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
					if(current.p.ID.equals(_ID))
					{
						return current.p.State;
					}
					current = current.getNext();
				}
			}
			return null;
		}
		
		public String GetCity(String _ID)
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
					if(current.p.ID.equals(_ID))
					{
						return current.p.City;
					}
					current = current.getNext();
				}
			}
			return null;
		}
		public String GetStreet(String _ID)
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
					if(current.p.ID.equals(_ID))
					{
						return current.p.Street;
					}
					current = current.getNext();
				}
			}
			return null;
		}
		public String GetName(String _ID)
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
					if(current.p.ID.equals(_ID))
					{
						return current.p.Name;
					}
					current = current.getNext();
				}
			}
			return null;
		}
		public Node EditStreet(String _Street, String _ID)
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
					if(current.p.ID.equals(_ID))
					{
						if(_Street.isEmpty())
						{
							current.p.Street = current.p.Street;
						}
						else
						{	
							current.p.Street = _Street;
						}
					}
					current = current.getNext();
				}
			}
			return current;
		}
		
		public Node EditCity(String _City, String _ID)
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
					if(current.p.ID.equals(_ID))
					{
						if(_City.isEmpty())
						{
							current.p.City = current.p.City;
						}
						else
						{
							current.p.City = _City;
						}
					}
					current = current.getNext();
				}
			}
			return current;
		}
		
		public Node EditState(String _State, String _ID)
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
					if(current.p.ID.equals(_ID))
					{
						if(_State.isEmpty())
						{
							current.p.State = current.p.State;
						}
						else
						{
						current.p.State = _State;
						}
					}
					current = current.getNext();
				}
			}
			return current;
		}
		
		public Node EditZipCode(String _ZipCode, String _ID)
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
					if(current.p.ID.equals(_ID))
					{
						if(_ZipCode.isEmpty())
						{
							current.p.ZipCode = current.p.ZipCode;
						}
						else
						{
						current.p.ZipCode = _ZipCode;
						}
					}
					current = current.getNext();
				}
			}
			return current;
		}
		
		public Node EditName(String _Name, String _ID)
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
					if(current.p.ID.equals(_ID))
					{
						if(_Name.isEmpty())
						{
							current.p.Name = current.p.Name;
						}
						else
						{
							current.p.Name = _Name;
						}
					}
					current = current.getNext();
				}
			}
			return current;
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
						temp = current.p.ID.substring(1);
						LastCharacter = Integer.parseInt(temp);
						LastCharacter++;
						generateID = Integer.toString(LastCharacter);
						newID = current.p.ID.substring(0,1) + generateID;
					}
					current = current.getNext();
				}
			}
			return newID;
		}
		
		public String [] ListNameofProvider()
		{
			String [] NameList = new String[listCount];
		        if(head != null)
		        {
		        	Node current = head;
		        	for(int i = 0; i<listCount ;i++)
		        	{
		        		NameList[i] = current.p.Name;
		        		current = current.getNext();
		        	}
		        }
		        return NameList;
		}
		
		public void outputPersonalProvider(String filename, String _ID)
		{
			try
			{
				 FileOutputStream out = new FileOutputStream(filename); // declare a file output object
		          PrintStream p1 = new PrintStream( out ); // declare a print stream object
		        if(head != null)
		        {
		        	Node current = head;
		        	for(int i = 1; i<= listCount ;i++)
		        	{
		        		if(current.p.ID.equals(_ID))
			        	{
		        			p1.println(current.p.Name);
		        			p1.println(current.p.ID);
		        			p1.println(current.p.Street);
		        			p1.println(current.p.City);
		        			p1.println(current.p.State);
		        			p1.println(current.p.ZipCode);
		        			for(int j = 0; j < current.p.m.length; j++)
		        			{
		        				p1.println(current.p.m[j].FirstName);
		        				p1.println(current.p.m[j].ID);
		        				for(int k = 0; k < current.p.m[j].s.length;k++)
			        			{
			        				p1.println(current.p.m[j].s[k].DateofService);
			        				p1.println(current.p.m[j].s[k].IDofService);
			        				p1.println(current.p.m[j].s[k].FeeofService);
			        			}
		        			}		        			
		        			p1.println(current.p.Consultation);
		        			current.p.TotalFee = getFee(current.p.ID);
		        			p1.println(current.p.TotalFee);
		        		current = current.getNext();
			        	}
		        	}
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
					if(current.p.ID.equals(_ID))
					{
						if(current.p.m.length != 0)
						{
							for(int k = 0; k <current.p.m.length;k++)
							{
								for(int j =0; j <current.p.m[k].s.length; j++)
								{
									oFee = current.p.m[k].s[j].FeeofService;
									tempFee = Integer.parseInt(oFee);
									Fee = tempFee + Fee;
								}
							}
						}
					}
					current = current.getNext();
				}
				TotalFee = Integer.toString(Fee);
			}
			return TotalFee;
		}
		
		private class Node
		{
			Node next;
			Provider p = new Provider();
			
			public Node(Provider _p)
			{
				next = null;
				p.Name = _p.Name;
				p.ID = _p.ID;
				p.Consultation = _p.Consultation;
				p.Street = _p.Street;
				p.City = _p.City;
				p.State = _p.State;
				p.ZipCode = _p.ZipCode;
				p.m = new Member[_p.m.length];
				for(int i =0; i< _p.m.length;i++)
				{
					p.m[i] = new Member();
					p.m[i].FirstName = _p.m[i].FirstName;
					p.m[i].ID = _p.m[i].ID;
					p.m[i].s = _p.m[i].s;
				}
				p.TotalFee = _p.TotalFee;
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

