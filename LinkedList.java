

class Node
{
	public Object element;
	public Node next;
	
	public Node()
	{
		this(null,null);
	}
	
	public Node(Object e, Node n)
	{
		element=e;
		next=n;
	}
	
	public Object getElement()
	{
		return element;
	}
	public Node getNext()
	{
		return next;
	}
	public void setElement(Object o)
	{
		element = o;
	}
	public void setNext(Node nn)
	{
		next = nn;
	}
	
}

public class LinkedList
{
	public Node head, tail;
	public int size;
	
	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return (head == null);
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void AddElement(Object e)
	{
		Node v = new Node(e, null);
		size++;
		if(head == null)
		{
			head = v;
			tail = head;
		}
		else
		{
			v.setNext(null);
			tail.setNext(v);
			tail=v;
		}
	}
	
	//removes i'th node in the linked list...
	public void RemoveElementI(int pos)
	{
		if(pos==1)
		{
			head = head.getNext();
			size--;
			return;
		}
		if(pos == size)
		{
			Node s=head;
			Node t = head;
			while(s != tail)
			{
				t= s;
				s= s.getNext();
			}
			tail = t;
			tail.setNext(null);
			size--;
			return;
		}
		Node ptr = head;
		pos = pos-1;
		for(int i=1; i<size-1; i++)
		{
			if(i == pos)
			{
				Node temp = ptr.getNext();
				temp = temp.getNext();
				ptr.setNext(temp);
				break;
			}
			ptr=ptr.getNext();
		}
		size--;
	}
	
	
	//removes the element specified node..
	public void RemoveElement(Object e) throws Exception
	{
		if (isEmpty())
			throw new Exception("cannot remove ");
		if (!IsPresent(e))
			throw new Exception(" not present");
		int pos  = getIndex(e);
		RemoveElementI(pos);
	}
	
	
	public int getIndex(Object e) throws Exception
	{
		int ctr = 0;
		if(isEmpty())
			throw new Exception("empty list");
		if(IsPresent(e))
		{
			Node temp = head;
			
			while(temp != null)
			{
				if(temp.element.equals(e))
				{
					return ctr+1;
				}
				else
				{
					ctr= ctr+1;
					temp = temp.getNext();
				}
			}
			
		}
		if(ctr == 0 )
			throw new Exception("element doesnt exist");
		return ctr+1;
	}
	
	public boolean IsPresent(Object e)
	{
		if (isEmpty())
			return false;
		else
		{
			Node temp = head;
			while(temp != null)
			{
				if(temp.element.equals(e))
					return true;
				else
					temp = temp.next;
			}
		}
		return false;
	}
	
	public Object getValue(int pos) throws Exception
	{
		if(pos>size)
			throw new Exception("no such position");
		Node temp =head;
		for(int i =1; i<pos; i++)
		{
			temp = temp.next;
		}
		return(temp.getElement());
	}
	
	
}

/*public class Test
{
	public static void main(String args[]) throws EmptyListException, ElementNotPresent
	{
		LinkedList l = new LinkedList();
		l.AddElement(6);
		l.AddElement(5);
		l.AddElement(7);
		l.AddElement(9);
		l.AddElement("Mukesh");
		
		System.out.println(""+l.head.element);
		
		System.out.println(l.IsPresent(6));
		
		l.printElemnts();
		System.out.println("\n"+l.getIndex(5));
		
		
		
		l.RemoveElement(6);
		l.printElemnts();
	}
}*/

