package bg.elsys.ip.rest.data;

public class SmartPhone {
	private int id;
	private String manufacturer;
	private String model;
	private float cameraMP;
	private float procesorGHz;
	private int year;
	private int memoryRam;
	
	public SmartPhone(int id, String manufacturer, String model, float cameraMP,
			float procesorGHz, int year, int memoryRam) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.cameraMP = cameraMP;
		this.procesorGHz = procesorGHz;
		this.year = year;
		this.memoryRam = memoryRam;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public float getCameraMP() {
		return cameraMP;
	}
	public void setCameraMP(float cameraMP) {
		this.cameraMP = cameraMP;
	}
	public float getProcesorGHz() {
		return procesorGHz;
	}
	public void setProcesorGHz(float procesorGHz) {
		this.procesorGHz = procesorGHz;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMemoryRam() {
		return memoryRam;
	}
	public void setMemoryRam(int memoryRam) {
		this.memoryRam = memoryRam;
	}
	
	
}
