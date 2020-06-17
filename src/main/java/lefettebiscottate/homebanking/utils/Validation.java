package lefettebiscottate.homebanking.utils;

public class Validation {
	
	// RegEx for codiceFisale : /^[A-Z]{6}\d{2}[A-Z]\d{2}[A-Z]\d{3}[A-Z]$/i
	// name and surname : [A-Z][AEIOU][AEIOUX]|[B-DF-HJ-NP-TV-Z]{2}[A-Z]
	//email : ^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$
	// password : ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$
//	^                 # start-of-string
//	(?=.*[0-9])       # a digit must occur at least once
//	(?=.*[a-z])       # a lower case letter must occur at least once
//	(?=.*[A-Z])       # an upper case letter must occur at least once
//	(?=.*[@#$%^&+=])  # a special character must occur at least once
//	(?=\S+$)          # no whitespace allowed in the entire string
//	.{8,}             # anything, at least eight places though
//	$                 # end-of-string
	
	
	// phone number : ^\\d{10}$
	
	// PartitaIVE : ^\\d{11}$
	
	// dataOFBirth : "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$
//	1/1/11 :        true
//	01/01/11 :      true
//	01/01/2011 :    true
//	01/1/2011 :     true
//	1/11/2011 :     true
//	1/11/11 :       true
//	11/1/11 :       true
//	
	
	
	
	
	
	public static boolean validateName(Object o, String name) {

		return false;
	}
	
}
