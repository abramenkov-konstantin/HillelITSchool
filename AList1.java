package hw06;

public class AList1 implements EList 
{
	private int[] ar={};
	private final int FULL=10;
	private int top;

	public AList1()
	{
	}

	public AList1(int[] ini)
	{
		init(ini);
	}

	@Override
	public void init(int[] ini)
	{	
		if (ini==null)
			ini = new int[0];

		int[] tmp = new int[FULL];
		top = ini.length;
		for (int i=0; i<top; i++)
		{
			tmp[i]=ini[i]; 
		}
		ar=tmp;
	}

	public void print() throws IllegalArgumentException
	{
		if (top<0)
			throw new IllegalArgumentException();

		System.out.println("top=" + top);
		for (int i=0; i<top; i++) 
		{
			if (i<top-1) System.out.print(ar[i]+", ");
			else System.out.print(ar[i]);
		}
		System.out.println();
	}
	@Override
	public int size()
	{
		if (top<0)
			throw new IllegalArgumentException();

		return top;
	}

	@Override
	public void clear()
	{
		ar = new int[0];
		top=0;
	}

	@Override
	public int[] toArray()
	{	
		int[] tmp = new int[top];
		for (int i=0; i<top; i++)
		{
			tmp[i]=ar[i]; 
		}
		return tmp;
	}

	@Override
	public String toString()
	{	
		if (top>10 || top<0) 
			throw new IllegalArgumentException();

		String str="{";
		for (int i=0; i<top; i++)
		{
			str+=i<top-1? ar[i]+ ", ": ar[i];
		}
		str+="}";
		if (top==0)
			str="{}";
		return str;
	}

	@Override
	public void addStart(int val)
	{ 
		if (top>=10 || top<0) 
			throw new IllegalArgumentException();

		top++;
		for (int i=top; i>=0; i--) 
		{ 
			ar[i+1]=ar[i]; 
		}
		ar[0]=val;
	}

	@Override
	public void addEnd(int val)
	{
		if (top>=10 || top<0) 
			throw new IllegalArgumentException();

		top++;
		ar[top-1]=val;
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (top>=10 || top<0 || pos>top || pos<0) 
			throw new IllegalArgumentException();

		if (top==0)
		{
			top++;
		}
		else
		{
			top++;
			for (int i=top; i>0; i--)
			{
				ar[i]=i<pos? ar[i]: ar[i-1];
			}
		}
		ar[pos]=val;
	}

	@Override
	public int delStart()
	{ 
		if (top==0 )
			throw new IllegalArgumentException();



		int val=ar[0]; 
		for (int i=0; i<=top; i++) 
		{ 
			ar[i]=ar[i+1]; 
		}
		top--;
		return val;
	}

	@Override
	public int delEnd()
	{ 
		if (top==0)
			throw new IllegalArgumentException();

		top--;
		return ar[top];
	}

	@Override
	public int delPos(int pos)
	{
		if (top==0 || pos>top || pos<0)
			throw new IllegalArgumentException();

		top--;
		int val=ar[pos];
		for (int i=0; i<top; i++)
		{
			ar[i]=i<pos? ar[i]: ar[i+1];
		}
		return val;
	}

	@Override
	public void set(int pos, int val)
	{
		if (top==0|| pos>top|| pos<0)
			throw new IllegalArgumentException();

		ar[pos]=val;
	}

	@Override
	public int get(int pos)
	{
		if (top==0 || pos>top || pos<0)
			throw new IllegalArgumentException();

		return ar[pos];
	}

	@Override
	public int minElem()
	{
		if (top==0)
			throw new NegativeArraySizeException();

		int min=ar[0];
		for (int i=1; i<top; i++)
		{
			if (min>ar[i])
			{
				min=ar[i];	
			}
		}	
		return min;
	}

	@Override
	public int maxElem()
	{
		if (top==0)
			throw new NegativeArraySizeException();

		int max=ar[0];
		for (int i=1; i<top; i++)
		{
			if (max<ar[i])
			{
				max=ar[i];	
			}
		}	
		return max;
	}

	@Override
	public int minInd()
	{
		if (top==0)
			throw new NegativeArraySizeException();

		int indexMin=0;
		for (int i=1; i<top; i++)
		{

			if (ar[indexMin]>ar[i])
			{
				indexMin=i;	
			}
		}
		return indexMin;
	}

	@Override
	public int maxInd()
	{
		if (top==0)
			throw new NegativeArraySizeException();

		int indexMax=0;
		for (int i=1; i<top; i++)
		{
			if (ar[indexMax]<ar[i])
			{
				indexMax=i;	  
			}
		}
		return indexMax;
	}

	@Override
	public void reverse()
	{
		if (top>0)
		{
			for (int i=0; i<top/2; i++) 
			{
				int tmp=ar[i];
				ar[i]=ar[top-i-1];
				ar[top-i-1]=tmp;
			}
		}
		else return;
	}		

	@Override
	public void reverseHalf()
	{
		if (top>0)
		{
			int d = (top%2==0) ? 0 : 1;
			for (int i=0; i<top/2; i++) 
			{
				int tmp=ar[i];
				ar[i] = ar[top/2+d+i];
				ar[top/2+d+i]=tmp;
			}
		}
		else return;
	}

	@Override
	public void sort()
	{
		for(int i=0; i<top; i++)					
		{
			for(int j=0; j<top-i-1; j++)
			{
				if(ar[j]>ar[j+1])  
				{
					int tmp=ar[j+1];	 
					ar[j+1]=ar[j];
					ar[j]=tmp;
				}
			}
		}
	}
}
