package org.brylex.sandbox.umo;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ReverseUMO {
	
	/** 
	 * Mule determines that this is the right method to invoke based on the
	 * method argument and returned types, which matches that of the endpoints 
	 * (after transformation).
	 **/
	public String reverse(String text) {

        text = text.trim();

        byte [] bytes = text.getBytes();
		
		Byte [] array = new Byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			array[i] = Byte.valueOf(bytes[i]);			
		}
				
		List list = Arrays.asList(array);
		Collections.reverse(list);
		
		bytes = new byte[list.size()];		
		for (int i=0;i<list.size();i++) {
			bytes[i] = ((Byte)list.get(i)).byteValue();
		}

        String result = new String(bytes);

        if (result.equals(text)) {
            throw new IllegalArgumentException("A palindrome is an illegal reverse() argument.");    
        }

        return result;
	}

}
