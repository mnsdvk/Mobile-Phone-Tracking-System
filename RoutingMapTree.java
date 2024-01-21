
public class RoutingMapTree
{
	public Exchange root;	

	public RoutingMapTree ()

	{
		root=new Exchange (0);
		root.p=null;
		root.IDnum=0;		
	}

	
	public RoutingMapTree(Exchange e)
	{
		this.root = e;
	}
	public Exchange root()
	{
		return root;
	}	
	public Exchange parent(Exchange e) 
	{
		return e.parent();
	}	
	public int numchildren(Exchange e)
	{
		return e.numChildren();
	}	
	public boolean isInternal (Exchange e)
	{
		return (e.numChildren() !=0);
	}	
	public boolean isExternal (Exchange e)
	{
		return (e.numChildren()==0);
	}			
	public boolean isRoot (Exchange e)
	{
		return ( e==root() ) ;
	}	
	public boolean isEmpty()
	{
		return (root == null);
	}
	public ExchangeList ListOfChildren(Exchange v)
	{
		return v.cd;
	}
	
	public Exchange Child(Exchange e,int n) throws Exception
	{
		return e.child(n);
	}
	
	

	public ExchangeList AllNodes() throws Exception

	{
		ExchangeList intset = new ExchangeList();
		getAllNodes(root, intset);
		return intset;
	}

	public void getAllNodes(Exchange node, ExchangeList elelist) throws Exception
	{
		if(node != null)
		{
			elelist.AddElement(node);
			if (node.cd != null);
			{
				for(int i=1;i<=node.numChildren();i++)
				{
					getAllNodes(node.child(i),elelist);
				}
			}
		}
	}

	public Exchange FindExchange(int id) throws Exception
	{

		ExchangeList intset = new ExchangeList();
		getAllNodes(root, intset);
		for(int i= 1; i<=intset.getSize(); i++)
		{
			Exchange temp = intset.getValue(i);
			if(temp.IDnum == id)
				return temp;
		}
		return null;
	}


	public MobilePhone findMobilePhone(int id)
	{
		MobilePhone m = root.data.MobileID(id);
		return m;
	}







	public void switchOn(MobilePhone a, Exchange b) throws Exception
	{
		if(a.status() == false)
		{
			if(isExternal(b))
			{
				a.s = true;
				a.bs = b;
				b.data.Insert(a);
				Exchange temp = parent(b);
				while(temp != null)
				{
					temp.data.Insert(a);
					temp = parent(temp);
				}
			}
			else
				throw new Exception("not a 0level");
		}
		else
			throw new Exception("already on");
	}

	public void switchOff(MobilePhone a) throws Exception
	{
		if(a.status())
		{
			a.s = false;
			Exchange temp= a.bs;
			while(temp != null)
			{
				temp.data.Delete(a);
				temp = parent(temp);
			}
		}
		else
			throw new Exception("its switch off");
	}

	public void performAction(String actionMessage)
	{
		String str[] = actionMessage.split(" ");

		try{

			if(str[0].equals("addExchange"))
			{

				int a = Integer.parseInt(str[1]);
				int b = Integer.parseInt(str[2]);

				Exchange new_ex = new Exchange(b);
				if(FindExchange(a) == null)
					throw new Exception("No such Exchange found...");
				if(FindExchange(b) != null)
					throw new Exception("the Exchange trying to be added already exists...");
				//System.out.println(FindExchange(a).ID);
				FindExchange(a).AddChild(new_ex);
				new_ex.p = FindExchange(a);


			}

			if(str[0].equals("switchOnMobile"))
			{
				int id = Integer.parseInt(str[1]);
				MobilePhone mobile = new MobilePhone(id);
				Exchange ex = FindExchange(Integer.parseInt(str[2]));
				if(ex ==null)
					throw new Exception("Exchange not found...");
				if(findMobilePhone(id) != null)
					throw new Exception("this mobile is already exists at some other place...");
				switchOn(mobile,ex);
			}

			if(str[0].equals("switchOffMobile"))
			{
				int id = Integer.parseInt(str[1]);
				if(findMobilePhone(id) == null)
					throw new Exception("No such Mobile found...");
				switchOff(findMobilePhone(id));
			}

			if(str[0].equals("queryNthChild"))
			{
				int id = Integer.parseInt(str[1]);
				Exchange ex = FindExchange(id);
				int pos = Integer.parseInt(str[2]);
				if(ex != null)
					System.out.println(actionMessage+": "+ex.child(pos+1).IDnum);
				if(ex == null)
					throw new Exception("No such exchange found...");
			}

			if(str[0].equals("queryMobilePhoneSet"))
			{
				int id = Integer.parseInt(str[1]);
				Exchange ex = FindExchange(id);
				if(ex == null)
					throw new Exception("No such Exchange found...");
				else
				{
					System.out.print(actionMessage + ": ");
					ex.data.Emptysetprinting();
					System.out.println("");
				}
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}


}