public class ExchangeList
{
	LinkedList intset = new LinkedList(); 
	
	public boolean isEmpty()
	{
		return intset.isEmpty();
	}
	
	public int getSize()
	{
		return intset.getSize();
	}
	
	public void AddElement(Exchange e)
	{
		intset.AddElement(e);
	}
	
	public Exchange getValue(int pos) throws Exception
	{
		return ((Exchange)(intset.getValue(pos)));
	}
	
	public void RemoveElementI(int pos)
	{
		intset.RemoveElementI(pos);
	}
	
	public void RemoveElement(Exchange e) throws Exception
	{
		intset.RemoveElement(e);
	}
	
	public int getIndex(Exchange e) throws Exception
	{
		return intset.getIndex(e);
	}
	
	public boolean IsPresent(Exchange e)
	{
		return intset.IsPresent(e);
	}
	
}

