package bg.elsys.ip.rest.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class SmartPhone {
	private static int countId = 0;
	@ApiModelProperty(value = "Shows ID for smart phone")
	private int id;
	@ApiModelProperty(value = "Shows manufacturer for smart phone")
	private String manufacturer;
	@ApiModelProperty(value = "Shows model for smart phone")
	private String model;
	@ApiModelProperty(value = "Shows camera(MP) for smart phone")
	private float cameraMP;
	@ApiModelProperty(value = "Shows GHz of the processor for smart phone")
	private float procesorGHz;
	@ApiModelProperty(value = "Shows year on smart phone")
	private int year;
	@ApiModelProperty(value = "Shows RAM memory for smart phone")
	private float memoryRam;
	
	public SmartPhone(String manufacturer, String model, float cameraMP,
			float procesorGHz, int year, float memoryRam) {
		super();
		countId++;
		this.id = countId;
		this.manufacturer = manufacturer;
		this.model = model;
		this.cameraMP = cameraMP;
		this.procesorGHz = procesorGHz;
		this.year = year;
		this.memoryRam = memoryRam;
	}

	public SmartPhone() {
		this("", "", 0.0f, 0.0f, 0, 0);
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
	public float getMemoryRam() {
		return memoryRam;
	}
	public void setMemoryRam(float memoryRam) {
		this.memoryRam = memoryRam;
	}	
}
