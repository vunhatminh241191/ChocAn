package ChocAn;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import ChocAn.Manager_Member.Node;


public class Service_List {
	public Node head;
	public int listCount;
		
	public Service_List()
	{
		head = null;
		listCount = 0;
	}
	
	public void add(Node temp)
	{
		if(head == null)
		{
			head= temp;
			if (head.s.IDofService == null)
			head.s.IDofService = "S10000";		
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
			if (temp.s.IDofService == null)
				temp.s.IDofService = randomID();
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
			if(current.s.IDofService.equals(_ID))
			{
				head = current.getNext();
				current = null;
			}
			else
			{
				while(current.getNext() != null)
				{
					if(current.next.s.IDofService.equals(_ID))
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
		try
		{
			 FileInputStream fstream = new FileInputStream(filename);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine = br.readLine();
			  int NumberofService = Integer.parseInt(strLine);
			  for(int i = 0; i < NumberofService; i++)
			  {						
				  Service s = new Service();
				  s.IDofService = br.readLine();
				  s.NameofService = br.readLine();
				//  s.DateofService = br.readLine();
				  s.FeeofService = br.readLine();
				  Node sll = new Node(s);
				  add(sll);
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
	        		p1.println(current.s.IDofService);
	        		p1.println(current.s.NameofService);
	        	//	if(current.s.DateofService != null)
	        //		{
	        	//		p1.println(current.s.DateofService);
	        		//}
	        		p1.println(current.s.FeeofService);
	        		current = current.getNext();
	        	}
	        }
	         out.close(); 
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
	}
		
	public void input(Service s)
	{
		Node temp = new Node(s);
		add(temp);
	}
	
	public String GetServiceName( String _ID)
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
				if(current.s.IDofService.equals(_ID))
				{
					return current.s.NameofService;
				}
				current = current.getNext();
			}
		}
		return null;		
	}

	public String GetServiceFee( String _ID)
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
				if(current.s.IDofService.equals(_ID))
				{
					return current.s.FeeofService;
				}
				current = current.getNext();
			}
		}
		return null;		
	}

	public String GetServiceDate( String _ID)
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
				if(current.s.IDofService.equals(_ID))
				{
					return current.s.DateofService;
				}
				current = current.getNext();
			}
		}
		return null;		
	}
	public void EditDateOfService(String _DateofService, String _IDofService)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't service in the system");
		}
		else
		{
			for(int i = 0; i<listCount;i++)
			{
				if(current.s.IDofService.equals(_IDofService))
				{
					current.s.DateofService = _DateofService;
				}
				current = current.getNext();
			}
		}
	}
	
	public void EditFeeOfService(String _FeeofService, String _IDofService)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't service in the system");
		}
		else
		{
			for(int i = 0; i<listCount;i++)
			{
				if(current.s.IDofService.equals(_IDofService))
				{
					current.s.FeeofService = _FeeofService;
				}
				current = current.getNext();
			}
		}
	}
	
	public void EditServiceName(String _NameofService, String _IDofService)
	{
		Node current = head;
		if(current == null)
		{
			System.out.println("There aren't service in the system");
		}
		else
		{
			for(int i = 0; i<listCount;i++)
			{
				if(current.s.IDofService.equals(_IDofService))
				{
					current.s.NameofService = _NameofService;
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
					temp = current.s.IDofService.substring(1);
					LastCharacter = Integer.parseInt(temp);
					LastCharacter++;
					generateID = Integer.toString(LastCharacter);
					newID = current.s.IDofService.substring(0,1) + generateID;
				}
				current = current.getNext();
			}
		}
		return newID;
	}
	public String [] ListNameofService()
	{
		String [] NameList = new String[listCount];
	        if(head != null)
	        {
	        	Node current = head;
	        	for(int i = 0; i<listCount ;i++)
	        	{
	        		NameList[i] = current.s.NameofService;
	        		current = current.getNext();
	        	}
	        }
	        return NameList;
	}
	
	public String FindDate(String _NameofService)
	{
		Node current = head;
		String _DateofService = "";
		if(current == null)
		{
			System.out.println("There isn't a list in this system");
		}
		else
		{
			for(int i = 0; i <listCount; i++)
			{
				if(current.s.NameofService.equals(_NameofService))
				{
					_DateofService = current.s.DateofService;
				}
				current = current.getNext();
			}
		}
		return _DateofService;
	}
	
	public Service GetServiceInfo(String _Name)
	{
		Node current = head;
		Service _s = new Service();
		if(current == null)
		{
			System.out.println("There isn't a list in the system");
		}
		else
		{
			for(int i =0; i< listCount; i++)
			{
				if(current.s.NameofService.equals(_Name))
				{
					_s = current.s;
				}
				current = current.getNext();
			}
		}
		return _s;
	}
	public class Node
	{
		Node next;
		Service s = new Service();
		public Node(Service _s)
		{
			next = null;
			s.DateofService = _s.DateofService;
			s.NameofService = _s.NameofService;
			s.IDofService = _s.IDofService;
			s.FeeofService = _s.FeeofService;
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
