package hw06;

public class AList0 implements EList 
{
	private int[] ar={};

	public AList0()
	{
	}

	public AList0(int[] ini)
	{
		init(ini);
	}

	@Override
	public void init(int[] ini)
	{	
		if (ini==null)
			ini = new int[0];

		int[] tmp = new int[ini.length];
		for (int i=0; i<ini.length; i++)
		{
			tmp[i]=ini[i]; 
		}
		ar=tmp;
	}

	public void print()
	{
		if (ar==null || ar.length==0)
			throw new IllegalArgumentException();

		for (int i=0; i<ar.length; i++) 
		{
			if (i<ar.length-1) System.out.print(ar[i]+", ");
			else System.out.print(ar[i]);
		}
		System.out.println();
	}
	@Override
	public int size()
	{
		if (ar.length<0)
			throw new IllegalArgumentException();

		return ar.length;
	}

	@Override
	public void clear()
	{
		ar = new int[0];
	}

	@Override
	public int[] toArray()
	{	
		int[] tmp = new int[ar.length];
		for (int i=0; i<ar.length; i++)
		{
			tmp[i]=ar[i]; 
		}
		return tmp;
	}

	@Override
	public String toString()
	{	
		String str="{";
		for (int i=0; i<ar.length; i++)
		{
			str+=i<ar.length-1? ar[i]+ ", ": ar[i];
		}
		str+="}";
		if (ar.length==0)
			str="{}";
		return str;
	}

	@Override
	public void addStart(int val)
	{ 
		int[] tmp=new int[ar.length+1]; 
		tmp[0]=val; 
		for (int i=0; i<ar.length; i++) 
		{ 
			tmp[i+1]=ar[i]; 
		} 
		ar=tmp; 
	}

	@Override
	public void addEnd(int val)
	{
		int[] tmp=new int[ar.length+1];
		for (int i=0; i<ar.length; i++) 
		{
			tmp[i]=ar[i];
		}
		tmp[ar.length]=val;
		ar=tmp;
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (pos>ar.length || pos<0)
			throw new IllegalArgumentException();

		int[] tmp=new int[ar.length+1];
		if (ar.length==0)
		{
			tmp[pos]=val;
		}
		else
		{
			for (int i=0; i<=ar.length; i++)
			{
				tmp[i]=i<pos? ar[i]: ar[i-1];
			}
			tmp[pos]=val;
		}
		ar=tmp;
	}

	@Override
	public int delStart()
	{ 
		if (ar.length==0 )
			throw new IllegalArgumentException();

		int[] tmp=new int[ar.length-1];
		int val=ar[0]; 
		for (int i=0; i<ar.length-1; i++) 
		{ 
			tmp[i]=ar[i+1]; 
		} 
		ar=tmp;
		return val;
	}

	@Override
	public int delEnd()
	{ 
		if (ar.length==0)
			throw new IllegalArgumentException();

		int[] tmp=new int[ar.length-1];
		int val=ar[ar.length-1]; 
		for (int i=0; i<ar.length-1; i++) 
		{ 
			tmp[i]=ar[i]; 
		} 
		ar=tmp;
		return val;
	}

	@Override
	public int delPos(int pos)
	{
		if (ar.length==0 || pos>ar.length || pos<0)
			throw new IllegalArgumentException();

		int[] tmp=new int[ar.length-1];
		int val=ar[pos];
		for (int i=0; i<ar.length-1; i++)
		{
			tmp[i]=i<pos? ar[i]: ar[i+1];
		}
		ar=tmp;
		return val;
	}

	@Override
	public void set(int pos, int val)
	{
		if (ar.length==0 || pos>ar.length || pos<0)
			throw new IllegalArgumentException();

		ar[pos]=val;
	}

	@Override
	public int get(int pos)
	{
		if (ar.length==0 || pos>ar.length || pos<0)
			throw new IllegalArgumentException();

		return ar[pos];
	}

	@Override
	public int minElem()
	{
		if (ar.length==0)
			throw new NegativeArraySizeException();

		int min=ar[0];
		for (int i=1; i<ar.length; i++)
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
		if (ar.length==0)
			throw new NegativeArraySizeException();

		int max=ar[0];
		for (int i=1; i<ar.length; i++)
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
		if (ar.length==0)
			throw new NegativeArraySizeException();

		int indexMin=0;
		for (int i=1; i<ar.length; i++)
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
		if (ar.length==0)
			throw new NegativeArraySizeException();

		int indexMax=0;
		for (int i=1; i<ar.length; i++)
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
		if (ar.length>0)
		{
			for (int i=0; i<ar.length/2; i++) 
			{
				int tmp=ar[i];
				ar[i]=ar[ar.length-i-1];
				ar[ar.length-i-1]=tmp;
			}
		}
		else return;
	}		

	@Override
	public void reverseHalf()
	{
		if (ar.length>0)
		{
			int d = (ar.length%2==0) ? 0 : 1;
			for (int i=0; i<ar.length/2; i++) 
			{
				int tmp=ar[i];
				ar[i] = ar[ar.length/2+d+i];
				ar[ar.length/2+d+i]=tmp;
			}
		}
		else return;
	}

	@Override
	public void sort()
	{
		for(int i=0; i<ar.length; i++)					
		{
			for(int j=0; j<ar.length-i-1; j++)
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
