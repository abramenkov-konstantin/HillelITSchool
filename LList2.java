package hw06;

public class LList2 implements EList 
{
	Node start = null;
	Node end = null;

	private class Node
	{
		int val;
		Node prev;
		Node next;

		public Node(int val) 
		{
			this.val = val;
		}
	}

	public LList2()
	{
	}

	public LList2(int[] ini)
	{
		init(ini);
	}

	@Override
	public void init(int[] a)
	{
		if(a == null)
		{
			a = new int[0];
		}

		for(int i = a.length-1; i >= 0; i--)
		{
			addStart(a[i]);
		}
	}

	public void print()
	{
		if (start == null)
		{
			System.out.print("{}");
		}
		else
		{
			Node p=start;
			System.out.print("{");
			while (p!=null)
			{
				if(p.next != null) System.out.print(p.val + ", ");
				else System.out.print(p.val);
				p = p.next;
			}
			System.out.print("}");		
		}
		System.out.println();	
	}


	@Override
	public int size()
	{
		int ret = 0;
		Node p = start;
		while(p != null)
		{
			ret++;
			p = p.next;
		}
		return ret;
	}

	@Override
	public void clear()
	{
		start = null;
		end = null;
	}

	@Override
	public int[] toArray()
	{
		int[] ret = new int[size()];
		Node p = start;
		int i = 0;
		while(p != null)
		{
			ret[i++] = p.val;
			p = p.next;
		}
		return ret;
	}

	@Override
	public String toString()
	{
		String str="{";
		Node p=start;
		while (p!=null)
		{
			str += (p.next != null) ? p.val + ", " : p.val;
			p = p.next;
		}
		str+="}";
		return str;
	}

	@Override
	public void addStart(int val)
	{
		Node p = new Node(val);
		if (start == null)
		{
			start=p;
			end=p;
		}
		else
		{
			p.next=start;
			start.prev=p;
			start=p;
		}
	}

	@Override
	public void addEnd(int val) 
	{
		Node p = new Node(val);
		if (start == null)
		{
			start=p;
			end=p;
		}
		else
		{
			p.prev=end;
			end.next=p; //p.prev.next=p;
			end=p;
		}
	}



	@Override
	public void addPos(int pos, int val)
	{
		if (pos<0 || pos>size()) 
			throw new IllegalArgumentException();

		if(size()==0 || pos==0) 
		{
			addStart(val);
		}
		else if (pos==size())
		{
			addEnd(val);
		}
		else
		{
			Node p = start;
			Node pPos = new Node(val);
			int i=1;

			while (i!=pos)
			{
				p = p.next;
				i++;
			}
			pPos.next=p.next;
			p.next=pPos;
			pPos.prev=p;
			p.next.prev=pPos;
		}
	}

	@Override
	public int delStart() 
	{
		if (size()<=0 )
			throw new IllegalArgumentException();

		int deletedVal = start.val;
		if (start.next==null) 
		{
			start=null;
			end=null;
		}
		else
		{
			start=start.next;
			start.prev=null;
		}
		return deletedVal;
	}

	@Override
	public int delEnd() 
	{
		if (size()<=0 )
			throw new IllegalArgumentException();

		int deletedVal = end.val;
		if (start.next==null) 
		{
			start=null;
			end=null;
		}
		else
		{
			end=end.prev;
			end.next=null;
		}
		return deletedVal;
	}

	@Override
	public int delPos(int pos) 
	{	
		if (size()<=0 )
			throw new IllegalArgumentException();

		Node p = start;
		int deletedVal=0;

		if (pos==0) 
		{
			deletedVal=delStart(); 
		}
		else if (pos==size()-1) 
		{
			deletedVal=delEnd(); 
		}
		else if (start.next==null) 
		{
			deletedVal=start.val;
			start=null;
			end=null;
		}
		else
		{
			for (int i=0; i<=pos; i++)
			{
				if (i==pos)
				{
					deletedVal = p.val;
					p.next.prev=p.prev;
					p.prev.next=p.next;
				}
				else
				{
					p = p.next;
				}
			}
		}
		return deletedVal;
	}

	@Override
	public void set(int pos, int val) 
	{
		if (pos<0 || pos>size()) 
			throw new IllegalArgumentException();

		Node p = start;
		for (int i=0; i<pos; i++)
		{
			p=p.next;
		}
		p.val=val;
	}

	@Override
	public int get(int pos) 
	{
		if (pos<0 || pos>size()) 
			throw new IllegalArgumentException();

		Node p = start;
		for (int i=0; i<pos; i++)
		{
			p=p.next;
		}
		return p.val;
	}

	@Override
	public int minElem() 
	{
		if (size()<=0 )
			throw new NegativeArraySizeException();

		Node p = start;
		int min =start.val;
		for(int i=1; i<=size(); i++)
		{
			min=min>p.val? p.val: min;
			p=p.next;
		}
		return min;
	}

	@Override
	public int maxElem() 
	{
		if (size()<=0)
			throw new NegativeArraySizeException();

		Node p = start;
		int max = start.val;
		for(int i=1; i<=size(); i++)
		{
			max=max<p.val? p.val: max;
			p=p.next;
		}
		return max;
	}

	@Override
	public int minInd() 
	{
		if (size()<=0 )
			throw new NegativeArraySizeException();

		Node p = start;
		int min = minElem(), minIndex=0;

		while (p.val>min)
		{
			minIndex++;
			p=p.next;
		}
		return minIndex;
	}

	@Override
	public int maxInd() 
	{
		if (size()<=0 )
			throw new NegativeArraySizeException();

		Node p = start;
		int max = maxElem(), maxIndex=0;

		while (p.val<max)
		{
			maxIndex++;
			p=p.next;
		}
		return maxIndex;
	}

	public void swap (int index1, int index2)
	{
		if (size()<0 )
			throw new NegativeArraySizeException();

		if (index1<0 || index2<0 || index1>size() || index1>size() || index1>index2)
			throw new IllegalArgumentException();

		if (index1==index2) return;

		//реализация #3 (правильная) через обмен ссылками
		//в разработке

		//реализация #2 через addPos() delPos() 
		/*Node p = start;
		Node tmp1=null, tmp2=null;
		for (int i=0; i<=index2;i++)
		{
			if (i==index1) tmp1=p;
			if (i==index2) tmp2=p;
			p=p.next;
		}

		addPos(index1, tmp2.val);
		addPos(index2+1, tmp1.val);
		delPos (index1+1);
		delPos (index2+1);*/

		//реализация #1 через get() set()
		int tmp= get(index1);
		set(index1, get(index2));
		set(index2, tmp);


	}

	@Override
	public void reverse() 
	{
		if (size()>0 )
		{
			for (int i=0; i<size()/2; i++) 
			{
				swap(i, size()-i-1);
				/*int tmp= get(i);
				set(i, get( size()-i-1 ));
				set(size()-i-1, tmp);*/
			}
		}
	}

	@Override
	public void reverseHalf() 
	{
		if (size()<0 )
			throw new NegativeArraySizeException();

		if (size()>0 )
		{
			int d = (size()%2==0) ? 0 : 1;

			for (int i=0; i<size()/2; i++) 
			{
				swap (i,size()/2+d+i);
				/*int tmp= get(i);
				set(i, get( size()/2+d+i ));
				set(size()/2+d+i, tmp);*/
			}
		}
	}

	@Override
	public void sort() 
	{
		for(int i=0; i<size(); i++)					
		{
			for(int j=0; j<size()-i-1; j++)
			{
				if(get(j)>get(j+1))
				{
					swap (j,j+1);
					/*int tmp= get(j+1);
					set(j+1, get(j));
					set(j, tmp);*/
				}
			}
		}
	}
}
