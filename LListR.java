package hw06;

public class LListR implements EList
{
	Node root = null;

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

	public LListR()
	{
	}

	public LListR(int[] ini)
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
		if (root == null)
		{
			System.out.print("{}");
		}
		else if (root.next==root)
		{
			System.out.print("{" + root.val + "}");
		}
		else
		{
			Node p=root;
			System.out.print("{"+ root.val +", ");

			p=p.next;
			while (p!=root)
			{
				if(p.next != root) System.out.print(p.val + ", ");
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
		Node p = root;
		if(root==null) 
		{
			ret=0;
		}
		else if(root.next==root) 
		{
			ret=1;
		}
		else
		{
			p=p.next;
			ret=1;
			while(p != root)
			{
				ret++;
				p = p.next;
			}
		}
		return ret;
	}



	@Override
	public void clear() 
	{
		root = null;
	}

	@Override
	public int[] toArray() 
	{
		int[] ret = new int[size()];
		Node p=root;

		int i=0;
		while(i != size())
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

		if(root==null) 
		{
		}
		else if(root.next==root) 
		{
			str+= root.val;
		}
		else
		{
			str += root.val + ", ";
			while (p.next!=root)
			{
				p = p.next;
				str += (p.next!= root) ? p.val + ", " : p.val;

			}
		}
		str+="}";
		return str;
	}

	@Override
	public void addStart(int val) 
	{
		Node p = new Node(val);

		if(root==null) 
		{
			p.next=p;
			p.prev=p;
			root=p;
		}
		else
		{
			p.next= root;
			p.prev= root.prev;
			root.prev.next=p;
			root.prev=p;
			root=p;
		}
	}

	@Override
	public void addEnd(int val) 
	{
		Node p = new Node(val);

		if(root==null) 
		{
			p.next=p;
			p.prev=p;
			root=p;
		}
		else
		{
			p.next= root;
			p.prev= root.prev;
			root.prev.next=p;
			root.prev=p;
			p=root;
		}
	}

	@Override
	public void addPos(int pos, int val) 
	{
		if (pos<0 || pos>size()) 
			throw new IllegalArgumentException();

		if(pos==0) 
		{
			addStart(val);
		}
		else if (pos==size())
		{
			addEnd(val);
		}
		else  
		{
			Node p = root;
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
		if (root==null)
			throw new IllegalArgumentException();

		int deletedVal = root.val;
		if (root.next==root) 
		{
			root=null;
		}
		else
		{
			root=root.next;
			root.prev=root.prev.prev;
			root.prev.next=root;
		}
		return deletedVal;
	}

	@Override
	public int delEnd() 
	{
		if (root==null)
			throw new IllegalArgumentException();

		int deletedVal = root.prev.val;
		if (root.next==root) 
		{
			root=null;
		}
		else
		{
			root.prev=root.prev.prev;
			root.prev.next=root;
		}
		return deletedVal;

	}

	@Override
	public int delPos(int pos) 
	{
		if (root==null)
			throw new IllegalArgumentException();

		int deletedVal = 0;

		if (pos==0) 
		{
			deletedVal=delStart(); 
		}
		else if (pos==size()-1) 
		{
			deletedVal=delEnd(); 
		}
		else if (root.next==root) 
		{
			deletedVal=root.val;
			root=null;
		}
		else
		{
			Node p = root;
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

		Node p = root;
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

		Node p = root;
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

	@Override
	public void reverse() 
	{
		if (root==null || root.next==root) //если 0 или 1 эл-т
			return;

		Node p;
		Node pNew;
		Node rootNew;

		if (root.next.next==root) //если 2 эл-та
		{
			root=root.next;
		}
		else //если больше 2-х эл-тов
		{
			rootNew=root.prev;
			rootNew.next =root.prev.prev;
			rootNew.prev =root;

			p=rootNew.next;
			pNew=rootNew.next;
			while(pNew!=rootNew)
			{
				pNew.next=p.prev;
				pNew.prev=p.next;
				p=p.prev;
				pNew=p;
			}
			root=rootNew;	
		}
	}

	@Override
	public void reverseHalf() 
	{
		if (root==null || root.next==root) //если 0 или 1 эл-т
			return;

		if (root.next.next==root) //если 2 эл-та
		{
			root=root.next;
		}
		else //если больше 2-х эл-тов
		{
			Node p=null;
			Node rootNew=null;
			Node middle=null;

			p=root;
			for(int i=0;i<size()/2;i++)
			{
				p=p.next;
			}

			if (size()%2==0)
			{
				root=p;	
			}
			else
			{
				middle=p;
				rootNew=middle.next;
				root.prev.next=middle;
				middle.next=root;
				middle.prev.next=rootNew;
				root=rootNew;
			}
		}
	}

	@Override
	public void sort() 
	{
		if (root==null || root.next==root) //если 0 или 1 эл-т
			return;

		Node rootNew = null;
		Node minRef= null;
		Node p = root;
		int min = 0;
		int size = size();

		for(int i=0; i<size; i++)
		{
			//---блок поиска минимального элемента---
			minRef=root;
			p = root;
			min=minElem();
			while (p.val!=min) p=p.next;
			minRef=p;//-----получаем ссылку на минимальный элемент---
			
			//-----удаляем минимальный элемент---
			if (root.next==root)
			{
				root=null;
			}
			else
			{
				if (minRef==root)
				{
					root.prev.next=root.next;
					root.next.prev=root.prev;
					root=root.next;
				}
				else
				{
					minRef.next.prev=minRef.prev;
					minRef.prev.next=minRef.next;
				}
			}
			//---------------------------
			
			//---блок перемещения минимального элемента в новый список---
			if (rootNew==null) //если новый список пуст 
			{
				minRef.next=minRef;
				minRef.prev=minRef;
				rootNew=minRef;
			}
			else //если новый список уже содержит элементы
			{
				minRef.next=rootNew;
				minRef.prev=rootNew.prev;
				rootNew.prev.next=minRef;
				rootNew.prev=minRef;
				minRef=rootNew;
			}
		}
		root=rootNew;
	}
}
