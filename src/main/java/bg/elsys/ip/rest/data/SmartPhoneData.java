package bg.elsys.ip.rest.data;

import java.util.ArrayList;
import java.util.List;

public class SmartPhoneData {
	private static SmartPhoneData data = null;
	
	private List<SmartPhone> phones;
	
	private SmartPhoneData() {
		phones = new ArrayList<>();
		
		SmartPhone phone1 = new SmartPhone(1, "Sumsung", "galaxy", 13.0f, 2.0f, 2014, 8);
		SmartPhone phone2 = new SmartPhone(2, "LG", "G3", 10.0f, 3.0f, 2013, 6);
		
		phones.add(phone1);
		phones.add(phone2);
	}
	
	public static SmartPhoneData getData() {
		if (data == null) {
			data = new SmartPhoneData();
		}
		
		return data;
	}

	public List<SmartPhone> getPhones () {
		return phones;
	}
	
	public void addPhone (SmartPhone item) {
		phones.add(item);
	}
	
	public List<SmartPhone> filteredByManufacturer(String manuf) {
		List<SmartPhone> filtered = new ArrayList<>();
		
		for (SmartPhone smartPhone : phones) {
			if (smartPhone.getManufacturer().equals(manuf)) {
				filtered.add(smartPhone);
			}
		}
		return filtered;
	}	
	public List<SmartPhone> filteredByModel() {
		return null;
	}
	public List<SmartPhone> filteredByCameraMP() {
		return null;
	}
	public List<SmartPhone> filteredByProcesorGHz() {
		return null;
	}
	public List<SmartPhone> filteredByYear() {
		return null;
	}
	public List<SmartPhone> filteredByMemoryRam() {
		return null;
	}
}
