package lefettebiscottate.homebanking.utils;

import lefettebiscottate.homebanking.entity.UserEntity;

//import lefettebiscottate.homebanking.entity.UserEntity;

public class UserValidation {
	
	// RegEx for codiceFisale : /^[A-Z]{6}\d{2}[A-Z]\d{2}[A-Z]\d{3}[A-Z]$/i
	// name and surname : [A-Z][AEIOU][AEIOUX]|[B-DF-HJ-NP-TV-Z]{2}[A-Z]
	// [A-Za-z]
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
	
	
//	Deve essere inserito il metodo per compattare il numero della carta
	
	//name
	//suraname
	//birthdate
	//phone
	//email
	//codicefiscale
	//partitaIVA
	//password
	//==========
	//gender
	//account_type
	//
	public boolean validateUser(UserEntity u) {
		if(validateName(u.getName())) {
			if(validateSurName(u.getSurname())) {
				if(validateBirthdate(u.getBirthdate().toString())) {
					if(validatePhone(u.getPhonenumber())) {
						if(validateCodiceFiscale(u.getFiscal_code()) || validatePartitaIVA(u.getPartita_IVA())) {
							if(validatePassword(u.getPassword())) {
								return true;
							}
							return false;
						}
						return false;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	public boolean validateName(String name) {
		if(name.trim().length() > 0) {
			return name.trim().replaceAll("\\s+", "").matches("[A-Za-z]");
		}
		return false;
	}
	public boolean validateSurName(String surname) {
		if(surname.trim().length() > 0) {
			return surname.trim().replaceAll("\\s+", " ").matches("[A-Za-z]");
		}
		return false;
	}
	public boolean validateBirthdate(String bDate) {
		// yyyy-mm-dd
		if(bDate.trim().length() > 0) {
			return bDate.trim().replaceAll("\\s+", "").matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
		}
		return false;
	}
	public boolean validatePhone(String phone) {
		if(phone.trim().length() > 0) {
			return phone.trim().replaceAll("\\s+", "").matches("^\\d{10}$");
		}
		return false;
	}
	public boolean validateCodiceFiscale(String cf) {
		if(cf.trim().length() > 0) {
			return cf.trim().replaceAll("\\s+", "").matches("^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$");
		}
		return false;
	}
	public boolean validatePartitaIVA(String IVA) {
		if(IVA.trim().length() > 0) {
			return IVA.trim().replaceAll("\\s+", "").matches("^\\d{11}$");
		}
		return false;
	}
	public boolean validatePassword(String pass) {
//		^                 # start-of-string
//		(?=.*[0-9])       # a digit must occur at least once
//		(?=.*[a-z])       # a lower case letter must occur at least once
//		(?=.*[A-Z])       # an upper case letter must occur at least once
//		(?=.*[@#$%^&+=])  # a special character must occur at least once
//		(?=\S+$)          # no whitespace allowed in the entire string
//		.{8,}             # anything, at least eight places though
//		$                 # end-of-string
		
		if(pass.trim().length() > 0) {
			return pass.trim().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
		}
		return false;
	}
	
}
