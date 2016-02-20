package hw06;

public class LList1 implements EList 
{

	class Node //Вадим
	{
		int val;
		Node next;
		public Node(int val) 
		{
			this.val = val;
		}
	}

	Node root = null;

	public LList1()
	{
	}

	public LList1(int[] ini)
	{
		init(ini);
	}

	@Override
	public void init(int[] a) //Вадим
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
		if (root == null)
		{
			System.out.print("{}");
		}
		else
		{
			Node p=root;

			System.out.print("{"+ p.val);
			for (int i=1; i<=size(); i++) 
			{
				p=p.next;
				if (i<size()) 
				{
					System.out.print(", "+ p.val);
				}
				else 
				{
					System.out.print("}");		
				}
			}
			System.out.println();	
		}
	}


	@Override
	public int size() //Вадим
	{
		int ret = 0;
		Node p = root;
		while(p != null)
		{
			ret++;
			p = p.next;
		}
		return ret;
	}

	@Override
	public void clear()  //Вадим
	{
		root = null;
	}

	@Override
	public int[] toArray() //Вадим
	{
		int[] ret = new int[size()];
		Node p = root;
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

		Node p=root;
		while (p!=null)
		{
			str += (p.next != null) ? p.val + ", " : p.val;
			p = p.next;
		}
		str+="}";
		return str;
	}

	@Override
	public void addStart(int val) //Вадим
	{
		Node p = new Node(val);
		p.next = root;
		root = p;
	}

	@Override
	public void addEnd(int val) 
	{
		Node p = root;
		Node pLast = new Node(val);

		if(size()==0) 
		{
			root = pLast;
		}
		else
		{
			for (int i=1; i<size(); i++)
			{
				p = p.next;
			}
			p.next = pLast;
		}
	}

	@Override
	public void addPos(int pos, int val) 
	{
		Node p = root;
		Node pPos = new Node(val);

		if (pos<0 || pos>size()) 
			throw new IllegalArgumentException();

		if(size()==0 || pos==0) 
		{
			addStart(val);
		}
		else
		{
			for (int i=1; i<=pos; i++)
			{
				if (i==pos)
				{
					pPos.next = p.next;
					p.next=pPos;
				}
				else
				{
					p = p.next;
				}
			}
		}
	}

	@Override
	public int delStart() 
	{
		if (size()<=0)
			throw new IllegalArgumentException();

		int deletedVal = root.val;
		if (root.next==null) 
		{
			root=null;
		}
		else
		{
			root=root.next;	
		}
		return deletedVal;
	}

	@Override
	public int delEnd() 
	{
		Node p = root;
		int deletedVal = 0;

		if (size()<=0)
			throw new IllegalArgumentException();

		if (root.next==null)
		{
			deletedVal = root.val;
			root=null;
		}
		else
		{
			while (p.next.next!=null)
			{
				p=p.next;
			}
			deletedVal = p.next.val;
			p.next=null;
		}
		return deletedVal;
	}

	@Override
	public int delPos(int pos) 
	{
		Node p = root;
		int deletedVal = 0;

		if (size()<=0 || pos<0 || pos>size()-1) 
			throw new IllegalArgumentException();

		if(pos==0)  
		{
			deletedVal = root.val;
			root=p.next;
		}
		else if (root.next==null)
		{
			deletedVal = root.val;
			root=null;
		}
		else
		{
			for(int i=0; i<pos-1; i++)
			{
				p=p.next;
			}
			deletedVal = p.next.val;
			p.next=p.next.next;
		}
		return deletedVal;
	}


	@Override
	public void set(int pos, int val) 
	{
		Node p = root;

		if (pos<0 || pos>size()-1) 
			throw new IllegalArgumentException();

		for(int i=0; i<pos; i++)
		{
			p=p.next;
		}
		p.val=val;
	}

	@Override
	public int get(int pos) 
	{
		Node p = root;
		if (pos<0 || pos>size()-1) 
			throw new IllegalArgumentException();

		for(int i=0; i<pos; i++)
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

		Node p = root;
		int min = root.val;

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

		Node p = root;
		int max = root.val;

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

		Node p = root;
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

		Node p = root;
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

		Node p = root;
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
		delPos (index2+1);
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
