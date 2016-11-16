package bg.elsys.ip.rest.data;

import java.util.ArrayList;
import java.util.List;

public class SmartPhoneData {
	private static SmartPhoneData data = null;
	
	private List<SmartPhone> phones;
	
	private SmartPhoneData() {
		phones = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			SmartPhone smartPhone= new SmartPhone("Samsung", "Galaxy", i*2f, 2+i*0.1f, 2010+i, 2^(i+1));
			phones.add(smartPhone);
		}
		for (int i = 0; i < 5; i++) {
			SmartPhone smartPhone = new SmartPhone("LG", "G3", i*2.1f, i*1.14f, 2014, 2^(i+1));
			phones.add(smartPhone);
		}
		for (int i = 0; i < 5; i++) {
			SmartPhone phone3 = new SmartPhone("iPhone", "S6 Plus", 16.0f, 3.14f, 2015, 2^(i+1));
			phones.add(phone3);
		}
		for (int i = 0; i < 5; i++) {
			SmartPhone phone4 = new SmartPhone("Lenovo", "A 7000", i*1.5f, (i+1)*1.14f, 2016, 2^(i+1));
			phones.add(phone4);
		}
		for (int i = 0; i < 5; i++) {
			SmartPhone phone5 = new SmartPhone("HTC", "Desire 530", 8f, 1.6f, 2016, 2^(i+1));
			phones.add(phone5);
		}
		for (int i = 0; i < 5; i++) {
			SmartPhone phone6 = new SmartPhone("Sony", "Xperia Z5", i+10f, (i+1)*0.74f, 2010+i, 2^(i+1));
			phones.add(phone6);
		}
		for (int i = 0; i < 5; i++) {
			SmartPhone phone7 = new SmartPhone("Huawei", "P9 Lite Black", i+10f, 2.0f, 2015, 2^(i+1));
			phones.add(phone7);
		}
		for (int i = 0; i < 5; i++) {
			SmartPhone phone8 = new SmartPhone("Blackberry", "Z30", i+5f, (i+1)*0.94f, 2013, 2^(i+1));
			phones.add(phone8);	
		}
		for (int i = 0; i < 5; i++) {
			SmartPhone phone9 = new SmartPhone("Samsung", "Nexus S", 13f, 2f, 2015, 2^(i+1));
			phones.add(phone9);
		}
		for (int i = 0; i < 5; i++) {
			SmartPhone phone10 = new SmartPhone("iPhone", "5S", 16f, 2.74f, 2016, 2^(i+1));
			phones.add(phone10);
		}
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
