package iterator_p;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

import iterator_p.My_iterator.Mycheck;
import iterator_p.My_iterator.check;

import org.junit.Test;

public class Test_filter {
	
	
	@Test
	public void test_filter1() { 
		/* this test ensures that the first element greater than 10 in the list
		 * after filtering is 16.
		*/
		Vector<Integer> al = new Vector<Integer>();
		al.add(5);
		al.add(16);
		al.add(5);
		al.add(20);
		al.add(8); 
		Iterator<Integer> itr=al.iterator();
		System.out.println(al);
		check c=new Mycheck();
				
		Iterator<Integer> itr2=My_iterator.filter(itr, c); 
		
		assertEquals("the test passes; Expected result: true  ",true,itr2.next().equals(new Integer(16)));
	}
	
	@Test
	public void test_filter2() { 
		/* this test ensures that the first element greater than 10 in the list
		 * after filtering is not the first element(5) .
		*/
		Vector<Integer> al = new Vector<Integer>();
		al.add(5);
		al.add(20);
		al.add(7);
		al.add(16);
		al.add(8);
		Iterator<Integer> itr=al.iterator();
		 check c=new Mycheck();
			
		Iterator<Integer> itr2=My_iterator.filter(itr, c); 
		//itr2.hasNext();
		assertFalse(itr2.next().equals((5)));
		
	}
	
	@Test 
	public void test_filter3() { 
		/* this test ensures that the second element greater than 10 in the list
		 * after filtering is not 20.
		*/
		Vector<Integer> al = new Vector<Integer>();
		al.add(5);
		al.add(20);
		al.add(7);
		al.add(16);
		al.add(8);
		al.add(18);
		Iterator<Integer> itr=al.iterator();
	    check c=new Mycheck();
		Iterator<Integer> itr2=My_iterator.filter(itr, c); 
		itr2.hasNext();		
		assertEquals("bad result 16 expected",(Integer)16,itr2.next());
	}
	
	
	@Test (expected = NullPointerException.class)
	public void test_filter4() { 
		/* this test ensures that no null iterator can be filter.
		 * Hence throws an Exception.
		*/
		check c=new Mycheck();		
		Iterator<Integer> itr3=null;
		itr3=My_iterator.filter(itr3, c); 
				
	}

	@Test (expected = NoSuchElementException.class)
	public void test_filter5() { 
		/* this test ensures that we cannot an attempt to return an empty iterator 
		 * will throw an exception.
		*/
		Vector<Integer> al = new Vector<Integer>();
		check c=new Mycheck();
		Iterator<Integer> itr=al.iterator();
		Iterator<Integer> itr2=My_iterator.filter(itr, c); 
		itr2.next();
		
	}
	

}