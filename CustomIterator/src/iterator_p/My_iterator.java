package iterator_p;

import java.util.*;

/**
 * 
 * @author Thierry Edson Noumessi
 * 
 * this class represents an Iterator checker .
 * 
 */

public class My_iterator<E> {

	/**
	 * @param args
	 */
	
	
	// this is the stand alone filter
	
	 static Iterator<Integer> filter(Iterator<Integer> g, check x){
		if (g==null) throw new NullPointerException("the Iterator is null");
		return new Mygen(g, x);
		
	}
	
	// this is the interface that defines the checker to be used for the filter
	interface check{
		public boolean checker(Integer e);
	}
	
	// this is the class that implements check along with checker
	static class Mycheck implements check{
		
		/* checker here has been chosen arbitrary just to show that the filter works 
		 * Here it checks if the value in parameter is superior to 10.
		 */
	public 	boolean checker(Integer i){
			if(i<10) return false; 
			else return true;
		}
	} 
	/* this is a standalone class used to implement the iterator.
	 * @rep Iterator itr: itr// an iterator
	*@rep int val  : 4 //the instance variable val is the next variable that satisfies the check
	*/
	
	private static class Mygen implements Iterator<Integer>{
		private Iterator<Integer> itr;
		private check c;
		private int val;
		
	// constructor
		Mygen(Iterator<Integer> itr, check c){
			this.itr=itr;
			this.c=c;
			
		}
		
		
		public boolean hasNext(){
			 try{
			      while(itr.hasNext()){ 
			    	 
				if(c.checker( val=(Integer) itr.next()))   return true;
				
			      }
		}catch(IllegalArgumentException e ){ throw new IllegalArgumentException("iterator contains only Integers");
				
			}
			 return false;
		}
		public Integer next() throws NoSuchElementException{
			if(hasNext())
			return val;
			throw new NoSuchElementException("the iterator is empty");
		}


		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}