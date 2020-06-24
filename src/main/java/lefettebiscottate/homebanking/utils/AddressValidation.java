package lefettebiscottate.homebanking.utils;

import lefettebiscottate.homebanking.entity.AddressEntity;

//import lefettebiscottate.homebanking.entity.AddressEntity;

public class AddressValidation {

	public boolean validateFullAddress(AddressEntity a) {
		if (validateVia(a.getVia())) {
			if (validateCivico(a.getCivico())) {
				if (validateComune(a.getComune())) {
					if (validateProvincia(a.getProvincia())) {
						if (validateRegione(a.getRegione())) {
							if (validateStato(a.getStato())) {
								if (validateCap(a.getCap())) {
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
		return false;
	}

	public boolean validateVia(String via) {
		if (via.trim().length() > 0) {
			return via.trim().replaceAll("\\s+", " ").matches("[A-Za-z]");
		}
		return false;
	}

	public boolean validateCivico(String civico) {
		if (civico.trim().length() > 0) {
			return civico.trim().replaceAll("\\s+", "").matches("[0-9A-Za-z]");
		}
		return false;
	}

	public boolean validateComune(String comune) {
		if (comune.trim().length() > 0) {
			return comune.trim().replaceAll("\\s+", " ").matches("[A-Za-z]");
		}
		return false;
	}

	public boolean validateProvincia(String pro) {
		if (pro.trim().length() > 0) {
			return pro.trim().replaceAll("\\s+", "").matches("[A-Z]{2}");
		}
		return false;
	}

	public boolean validateRegione(String regione) {
		if (regione.trim().length() > 0) {
			return regione.trim().replaceAll("\\s+", " ").matches("[A-Za-z]");
		}
		return false;
	}

	public boolean validateStato(String stato) {
		if (stato.trim().length() > 0) {
			return stato.trim().replaceAll("\\s+", " ").matches("[A-Za-z]");
		}
		return false;
	}

	public boolean validateCap(int cap) {
		String caps = String.valueOf(cap);
		if (caps.trim().length() > 0) {
			return caps.trim().replaceAll("\\s+", "").matches("[0-9]{5}");
		}
		return false;
	}
}
