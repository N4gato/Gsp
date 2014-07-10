package com.list.list;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
/**
 * This class shows how to create ArrayList of arrays of same type and different types
 * @author pankaj
 *
 */
public class Liste {

	List<float[]> positions = new ArrayList<float[]>();
	
	public Liste(float[] array) {
	    //List of String arrays
	    
	    positions.add(array);
	    //printing list of String arrays in the ArrayList
	    
	}
	
	public void getListe(Liste list){
		for (float[] position : positions) {
	        System.out.println(Arrays.toString(position));
	    }
	}

}