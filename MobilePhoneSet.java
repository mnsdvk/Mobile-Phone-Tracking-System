
public class MobilePhoneSet
{
	Myset mp= new Myset();
	
	
	public boolean IsMember(MobilePhone o)
	{
		return (mp.IsMember(o));
	}
	public boolean IsEmpty()
	{
		return (mp.IsEmpty());
	}
	
	
	public void Insert(MobilePhone o)
	{
		mp.Insert(o);
	}
	
	public void Delete(MobilePhone o) throws Exception
	{
		mp.Delete(o);
	}
	
	public MobilePhone MobileID(int id)
	{
		Node t = mp.intset.head;
		while(t!=null)
		{
			if(id==((MobilePhone)(t.element)).number())
			{
				return (MobilePhone)(t.element);
			}
			t = t.getNext();
		}
		
		return null;
	} 
	
	public MobilePhoneSet Union(MobilePhoneSet a)
	{
		MobilePhoneSet union = new MobilePhoneSet();
		union.mp = a.mp.Copy();
		union.mp  = mp.Union(union.mp);
		return union;
	}
	
	public MobilePhoneSet Intersection(MobilePhoneSet a)
	{
		MobilePhoneSet intern = new MobilePhoneSet();
		intern.mp = a.mp.Copy();
		intern.mp = mp.Intersection(a.mp);
		return intern;
	}
	
public void Emptysetprinting()
	{
		LinkedList es = mp.intset;
		if (mp.IsEmpty())
		{
			System.out.println("EmptySet");
			return;
		}
		Node temp = (es.head);
		System.out.print(((MobilePhone)(temp.element)).number());
		temp = temp.getNext();
		while(temp != null)
		{
			System.out.print(", "+((MobilePhone)(temp.element)).number());
			temp = temp.getNext();
		}
	}
}
