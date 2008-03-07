package org.brylex.sandbox.umo;

public class CapitalizeUMO {

	/** 
	 * Mule determines that this is the right method to invoke based on the
	 * method argument and returned types, which matches that of the endpoints 
	 * (after transformation).
	 **/
	public String capitalize(String text) {
	
		return text.toUpperCase();
	}
	
}