package bg.elsys.ip.rest.data;

import java.util.ArrayList;
import java.util.List;

public class SmartPhoneData {
	private static SmartPhoneData data = null;
	
	private List<SmartPhone> phones;
	
	private SmartPhoneData() {
		phones = new ArrayList<>();
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
	public List<SmartPhone> filteredByModel(String model) {
		List<SmartPhone> filtered = new ArrayList<>();
		
		for (SmartPhone smartPhone : phones) {
			if (smartPhone.getManufacturer().equals(model)) {
				filtered.add(smartPhone);
			}
		}
		return filtered;
	}
	public List<SmartPhone> filteredByCameraMP(float cameraMP) {
		List<SmartPhone> filtered = new ArrayList<>();
		
		for (SmartPhone smartPhone : phones) {
			if (smartPhone.getManufacturer().equals(cameraMP)) {
				filtered.add(smartPhone);
			}
		}
		return filtered;
	}
	public List<SmartPhone> filteredByProcesorGHz(float procesorGHz) {
		List<SmartPhone> filtered = new ArrayList<>();
		
		for (SmartPhone smartPhone : phones) {
			if (smartPhone.getManufacturer().equals(procesorGHz)) {
				filtered.add(smartPhone);
			}
		}
		return filtered;
	}
	public List<SmartPhone> filteredByYear(int year) {
		List<SmartPhone> filtered = new ArrayList<>();
		
		for (SmartPhone smartPhone : phones) {
			if (smartPhone.getManufacturer().equals(year)) {
				filtered.add(smartPhone);
			}
		}
		return filtered;
	}
	public List<SmartPhone> filteredByMemoryRam(int memoryRam) {
		List<SmartPhone> filtered = new ArrayList<>();
		
		for (SmartPhone smartPhone : phones) {
			if (smartPhone.getManufacturer().equals(memoryRam)) {
				filtered.add(smartPhone);
			}
		}
		return filtered;
	}
}
