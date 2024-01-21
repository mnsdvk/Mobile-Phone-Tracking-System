public class Exchange
{ 
	public int IDnum;
	public Exchange p;
	public ExchangeList cd;
	public  MobilePhoneSet data;


	public Exchange (int n){
		IDnum=n;
		cd=new ExchangeList();
		data =new MobilePhoneSet ();
		p=null;
	}

	public Exchange parent()
	{
		return p;
	}

	public int numChildren()
	{
		return cd.getSize();
	}

	public Exchange child(int i) throws Exception
	{
		if(i<=0)
			throw new Exception("no possibiity");
		if(cd == null)
			return null;
		if(i> cd.getSize())
			throw new Exception("children exceeds.");
		return cd.getValue(i);
	}

	public boolean isRoot()
	{
		return (p == null);
	}

	public MobilePhoneSet residentSet()
	{
		return data;
	}

	public void AddChild(Exchange e)
	{
		cd.AddElement(e);

	}

	public RoutingMapTree subtree(int i) throws Exception
	{
		RoutingMapTree st = new RoutingMapTree();
		st.root = cd.getValue(i);
		return st;
	}
}
