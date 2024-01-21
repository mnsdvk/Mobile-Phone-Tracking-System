
public class Myset{
	public LinkedList intset = new LinkedList();


	public int size(){
		return intset.size;
	}



	public boolean IsEmpty()
	{
		return(intset.isEmpty());
	}


	public boolean IsMember(Object e)
	{
		return(intset.IsPresent(e));
	}


	public void Insert(Object o)
	{
		if(!intset.IsPresent(o))
			intset.AddElement(o);
	}

	public void Delete(Object e) throws Exception
	{
		if(!intset.IsPresent(e))
			throw new Exception("Element not present") ;
		else 
			intset.RemoveElement(e);
	}
	public Myset Copy(){
		Myset c = new Myset();
		Node temp = intset.head;
		while(temp!=null){
			c.Insert(temp.element);
			temp=temp.getNext();
		}

		return c;
	}
	public Myset Union(Myset a)
	{
		Myset un = new Myset();
		un =a.Copy();
		Node temp =intset.head;
		while(temp!=null)
		{

			if(!un.IsMember(temp.getElement()) )
			{
				un.Insert(temp.getElement());
			}
			temp=temp.getNext();

		}
		return un;
	}

	public Myset  Intersection(Myset a)
	{
		Myset intern =new Myset();
		Node temp=intset.head;
		while(temp!=null)
		{
			if(a.IsMember(temp.element))
			{ 
				intern.Insert(temp.element);

			}

			temp=temp.next;
		}
		return intern;
	}

}