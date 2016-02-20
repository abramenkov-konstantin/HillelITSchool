package hw06;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)

public class EListTest 
{
	EList rr = null;
	//EList rr = new AList0();
	//EList rr = new AList1();
	//EList rr = new AList1();

	@Parameters
	public static Collection<Object[]> data() 
	{
		return Arrays.asList(new Object[][] 
				{     
			{ new AList0() }, 
			{ new AList1() },
			{ new AList2() },
			{ new LList1() },
			{ new LList2() }  
				}
				);
	}

	public EListTest(EList arg) 
	{
		rr=arg;
	}

	@Before
	public void SetUp()
	{
		rr.clear();
	}

	//================================
	// Size
	//================================

	/*@Test (expected = IllegalArgumentException.class)
	public void testSize0()
	{
		int[]ar = {};
		rr.init(ar);
		rr.size();
	}*/
	@Test
	public void testSize0()
	{
		int[]ar = {};
		rr.init(ar);
		int act = rr.size();
		assertEquals(0,act);
	}
	@Test
	public void testSize1()
	{
		int[]ar = {10};
		rr.init(ar);
		int act = rr.size();
		assertEquals(1,act);
	}
	@Test
	public void testSize2()
	{
		int[]ar = {10,20};
		rr.init(ar);
		int act = rr.size();
		assertEquals(2,act);
	}
	@Test
	public void testSizeMany()
	{
		int[]ar = {10,20,77,67,14};
		rr.init(ar);
		int act = rr.size();
		assertEquals(5,act);
	}

	//================================
	// Clear
	//================================

	@Test
	public void testClear0()
	{
		int[] ar = {};
		int[] exp = {};
		rr.init(ar);
		rr.clear();
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testClear1()
	{
		int[] ar = {10};
		int[] exp = {};
		rr.init(ar);
		rr.clear();
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testClear2()
	{
		int[]ar = {10,20};
		int[] exp = {};
		rr.init(ar);
		rr.clear();
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testClearMany()
	{
		int[]ar = {10,20,77,67,14};
		int[] exp = {};
		rr.init(ar);
		rr.clear();
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}

	//================================
	// toArray
	//================================

	@Test
	public void testToArray0()
	{
		int[] ar = {};
		int[] exp = {};
		rr.init(ar);
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testToArray1()
	{
		int[] ar = {10};
		int[] exp = {10};
		rr.init(ar);
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testToArray2()
	{
		int[]ar = {10,20};
		int[] exp = {10,20};
		rr.init(ar);
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testToArrayMany()
	{
		int[]ar = {10,20,77,67,14};
		int[] exp = {10,20,77,67,14};
		rr.init(ar);
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}

	//================================
	// toString
	//================================

	@Test
	public void testToString0()
	{
		int[] ar = {};
		String exp = "{}";
		rr.init(ar);
		String act = rr.toString();
		assertEquals(exp,act);
	}
	@Test
	public void testToString1()
	{
		int[] ar = {10};
		String exp = "{10}";
		rr.init(ar);
		String act = rr.toString();
		assertEquals(exp,act);
	}
	@Test
	public void testToString2()
	{
		int[]ar = {10,20};
		String exp = "{10, 20}";
		rr.init(ar);
		String act = rr.toString();
		assertEquals(exp,act);
	}
	@Test
	public void testToStringMany()
	{
		int[]ar = {10,20,77,67,14};
		String exp = "{10, 20, 77, 67, 14}";
		rr.init(ar);
		String act = rr.toString();
		assertEquals(exp,act);
	}

	//================================
	// addStart
	//================================

	@Test
	public void testAddStart0()
	{
		int[] ar = {};
		rr.init(ar);
		rr.addStart(10);
		assertEquals(1,rr.size());
		int[] exp = {10};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testAddStart1()
	{
		int[] ar = {10};
		rr.init(ar);
		rr.addStart(20);
		assertEquals(2,rr.size());
		int[] exp = {20,10};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testAddStart2()
	{
		int[] ar = {10,20};
		rr.init(ar);
		rr.addStart(30);
		assertEquals(3,rr.size());
		int[] exp = {30,10,20};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testAddStartMany()
	{
		int[] ar = {10,20,23,43,5,33};
		rr.init(ar);
		rr.addStart(1);
		assertEquals(7,rr.size());
		int[] exp = {1,10,20,23,43,5,33};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}

	//================================
	// addEnd
	//================================

	@Test
	public void testAddEnd0()
	{
		int[] ar = {};
		rr.init(ar);
		rr.addEnd(10);
		assertEquals(1,rr.size());
		int[] exp = {10};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testAddEnd1()
	{
		int[] ar = {10};
		rr.init(ar);
		rr.addEnd(20);
		assertEquals(2,rr.size());
		int[] exp = {10,20};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testAddEnd2()
	{
		int[] ar = {10,20};
		rr.init(ar);
		rr.addEnd(30);
		assertEquals(3,rr.size());
		int[] exp = {10,20,30};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testAddEndMany()
	{
		int[] ar = {10,20,23,43,5,33};
		rr.init(ar);
		rr.addEnd(1);
		assertEquals(7,rr.size());
		int[] exp = {10,20,23,43,5,33,1};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	//================================
	// addPos
	//================================

	@Test
	public void testAddPos0()
	{
		int[] ar = {};
		rr.init(ar);
		rr.addPos(0,20);
		//assertEquals(1,rr.size());
		int[] exp = {20};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testAddPos1()
	{
		int[] ar = {10};
		rr.init(ar);
		rr.addPos(1,20);
		//assertEquals(2,rr.size());
		int[] exp = {10,20};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testAddPos2()
	{
		int[] ar = {10,20};
		rr.init(ar);
		rr.addPos(1, 30);
		assertEquals(3,rr.size());
		int[] exp = {10,30,20};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testAddPosMany()
	{
		int[] ar = {10,20,23,43,5,33};
		rr.init(ar);
		rr.addPos(2,1);
		assertEquals(7,rr.size());
		int[] exp = {10,20,1,23,43,5,33};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	//================================
	// delStart
	//================================

	@Test (expected = IllegalArgumentException.class)
	public void testDelStart0()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.delStart();
	}
	@Test
	public void testDelStart1()
	{
		int[] ar = {10};
		rr.init(ar);
		int res = rr.delStart();
		assertEquals(10,res);
		int[] exp = {};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testDelStart2()
	{
		int[] ar = {10,20};
		rr.init(ar);
		int res = rr.delStart();
		assertEquals(10,res);
		assertEquals(1,rr.size());
		int[] exp = {20};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testDelStartMany()
	{
		int[] ar = {10,20,30,40,50};
		rr.init(ar);
		int res = rr.delStart();
		assertEquals(10,res);
		assertEquals(4,rr.size());
		int[] exp = {20,30,40,50};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	//================================
	// delEnd
	//================================

	@Test (expected = IllegalArgumentException.class)
	public void testDelEnd0()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.delEnd();
	}
	@Test
	public void testDelEnd1()
	{
		int[] ar = {10};
		rr.init(ar);
		int res = rr.delEnd();
		assertEquals(10,res);
		int[] exp = {};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testDelEnd2()
	{
		int[] ar = {10,20};
		rr.init(ar);
		int res = rr.delEnd();
		assertEquals(20,res);
		int[] exp = {10};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testDelEndMany()
	{
		int[] ar = {10,20,30,40,50};
		rr.init(ar);
		int res = rr.delEnd();
		assertEquals(50,res);
		int[] exp = {10,20,30,40};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}

	//================================
	// delPos
	//================================

	@Test (expected = IllegalArgumentException.class)
	public void testDelPos0()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.delPos(3);
	}
	@Test
	public void testDelPos1()
	{
		int[] ar = {10};
		rr.init(ar);
		int res = rr.delPos(0);
		assertEquals(10,res);
		int[] exp = {};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testDelPos2()
	{
		int[] ar = {10,20};
		rr.init(ar);
		int res = rr.delPos(1);
		assertEquals(20,res);
		int[] exp = {10};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testDelPosMany()
	{
		int[] ar = {10,20,30,40,50};
		rr.init(ar);
		int res = rr.delPos(2);
		assertEquals(30,res);
		int[] exp = {10,20,40,50};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	//================================
	// set
	//================================

	@Test (expected = IllegalArgumentException.class)
	public void testSet00()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.set(1,40);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testSet01()  
	{
		int[] ar = {10};
		rr.init(ar);
		rr.set(10,23);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testSet02()  
	{
		int[] ar = {2,2};
		rr.init(ar);
		rr.set(-5,40);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testSet1()  
	{
		int[] ar = {2};
		rr.init(ar);
		rr.set(2,40);
	}
	@Test
	public void testSet2()  
	{
		int[] ar = {2,3};
		rr.init(ar);
		rr.set(1,40);
		int[] exp = {2,40};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testSetMany()  
	{
		int[] ar = {2,3,6,9,2};
		rr.init(ar);
		rr.set(1,40);
		int[] exp = {2,40,6,9,2};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}

	//================================
	// get
	//================================

	@Test (expected = IllegalArgumentException.class)
	public void testGet00()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.get(1);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGet01()  
	{
		int[] ar = {10};
		rr.init(ar);
		rr.get(10);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGet02()  
	{
		int[] ar = {2,2};
		rr.init(ar);
		rr.get(-5);
	}
	@Test
	public void testGet1()  
	{
		int[] ar = {2};
		rr.init(ar);
		int exp = rr.get(0);
		assertEquals(exp,2);
	}
	@Test
	public void testGet2()  
	{
		int[] ar = {2,4};
		rr.init(ar);
		int exp = rr.get(1);
		assertEquals(exp,4);
	}
	@Test
	public void testGetMany()  
	{
		int[] ar = {2,4,6,8,8};
		rr.init(ar);
		int exp = rr.get(2);
		assertEquals(exp,6);
	}

	//================================
	// max
	//================================

	@Test (expected = NegativeArraySizeException.class)
	public void testMax0()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.maxElem();
	}
	@Test
	public void testMax1()  
	{
		int[] ar = {2};
		rr.init(ar);
		int exp = rr.maxElem();
		assertEquals(exp,2);
	}
	@Test
	public void testMax2()  
	{
		int[] ar = {2,5};
		rr.init(ar);
		int exp = rr.maxElem();
		assertEquals(exp,5);
	}
	@Test
	public void testMax3()  
	{
		int[] ar = {2,5,1};
		rr.init(ar);
		int exp = rr.maxElem();
		assertEquals(exp,5);
	}
	@Test
	public void testMax4()  
	{
		int[] ar = {2,5,1,34,44,12,31};
		rr.init(ar);
		int exp = rr.maxElem();
		assertEquals(exp,44);
	}

	//================================
	// min
	//================================
	@Test (expected = NegativeArraySizeException.class)
	public void testMin0()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.minElem();
	}
	@Test
	public void testMin1()  
	{
		int[] ar = {2};
		rr.init(ar);
		int exp = rr.minElem();
		assertEquals(exp,2);
	}
	@Test
	public void testMin2()  
	{
		int[] ar = {4,2};
		rr.init(ar);
		int exp = rr.minElem();
		assertEquals(exp,2);
	}
	@Test
	public void testMin3()  
	{
		int[] ar = {2,4};
		rr.init(ar);
		int exp = rr.minElem();
		assertEquals(exp,2);
	}
	@Test
	public void testMin4()  
	{
		int[] ar = {2,45,25,1,45,12};
		rr.init(ar);
		int exp = rr.minElem();
		assertEquals(exp,1);
	}
		
	//================================
	// maxInd
	//================================

	@Test (expected = NegativeArraySizeException.class)
	public void testMaxInd0()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.maxInd();
	}
	//================================
	// minInd
	//================================
	@Test (expected = NegativeArraySizeException.class)
	public void testMinInd0()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.minInd();
	}

	//================================
	// sort
	//================================

	@Test
	public void testSort0()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.sort();
		int[] exp = {};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testSort1()  
	{
		int[] ar = {2};
		rr.init(ar);
		rr.sort();
		int[] exp = {2};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testSort2()  
	{
		int[] ar = {9,7};
		rr.init(ar);
		rr.sort();
		int[] exp = {7,9};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testSortMany()  
	{
		int[] ar = {9,73,43,2};
		rr.init(ar);
		rr.sort();
		int[] exp = {2,9,43,73};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}

	//================================
	// revers
	//================================

	@Test
	public void testReverse0()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.reverse();
		int[] exp = {};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testReverse1()  
	{
		int[] ar = {2};
		rr.init(ar);
		rr.reverse();
		int[] exp = {2};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testReverse2()  
	{
		int[] ar = {9,7};
		rr.init(ar);
		rr.reverse();
		int[] exp = {7,9};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testReverseMany()  
	{
		int[] ar = {9,73,43,2};
		rr.init(ar);
		rr.reverse();
		int[] exp = {2,43,73,9};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}

	//================================
	// revers
	//================================

	@Test
	public void testReverseHalf0()  
	{
		int[] ar = {};
		rr.init(ar);
		rr.reverseHalf();
		int[] exp = {};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testReverseHalf1()  
	{
		int[] ar = {2};
		rr.init(ar);
		rr.reverseHalf();
		int[] exp = {2};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testReverseHalf2()  
	{
		int[] ar = {9,7};
		rr.init(ar);
		rr.reverseHalf();
		int[] exp = {7,9};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testReverseHalfMany()  
	{
		int[] ar = {9,73,43,2};
		rr.init(ar);
		rr.reverseHalf();
		int[] exp = {43,2,9,73};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
	@Test
	public void testReverseHalfMany2()  
	{
		int[] ar = {9,73,43,2,4};
		rr.init(ar);
		rr.reverseHalf();
		int[] exp = {2,4,43,9,73};
		int[] act = rr.toArray();
		assertArrayEquals(exp,act);
	}
}
