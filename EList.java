package hw06;

interface EList 
{
	void init(int[] ini);
	int size();

	void clear();
	int[] toArray();
	String toString();
	
	void addStart(int val);
	void addEnd(int val);
	void addPos(int pos, int val);
	int delStart();
	int delEnd();
	int delPos(int pos);
	
	void set(int pos, int val);
	int get(int pos);
	
	int minElem();
	int maxElem();
	int minInd();
	int maxInd();
	void reverse();
	void reverseHalf();
	void sort();
}
