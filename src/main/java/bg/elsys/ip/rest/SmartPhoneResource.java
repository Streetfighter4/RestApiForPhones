package bg.elsys.ip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import bg.elsys.ip.rest.data.SmartPhone;
import bg.elsys.ip.rest.data.SmartPhoneData;

@Path("/phones")
public class SmartPhoneResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPhones(
			@DefaultValue("") @QueryParam("manufacturerFilter") final String manufacturer,
			@DefaultValue("") @QueryParam("modelFilter") final String model,
			@DefaultValue("-1") @QueryParam("cameraMPFilter") final Float cameraMP,
			@DefaultValue("-1") @QueryParam("procesorGHzFilter") final Float procesorGHz,
			@DefaultValue("-1") @QueryParam("yearFilter") final Integer year,
			@DefaultValue("-1") @QueryParam("memoryRamFilter") final Float memoryRam
			) {
		
		List<SmartPhone> phones = SmartPhoneData.getData().getPhones();
		
		if (manufacturer != null && !("".equals(manufacturer))) {
			System.out.println("Filter1");
			phones = SmartPhoneData.filteredByManufacturer(manufacturer, phones);
		}
		if (model != null && !("".equals(model))) {
			System.out.println("Filter2");
			phones = SmartPhoneData.filteredByModel(model, phones);
		}
		if (cameraMP >= 0.0) {
			System.out.println("Filter3");
			phones = SmartPhoneData.filteredByCameraMP(cameraMP, phones);
		}
		if (procesorGHz >= 0.0) {
			System.out.println("Filter4");
			phones = SmartPhoneData.filteredByProcesorGHz(procesorGHz, phones);
		}
		if (year >= 1900) {
			System.out.println("Filter5");
			phones = SmartPhoneData.filteredByYear(year, phones);
		}
		if (memoryRam >= 0.0) {
			System.out.println("Filter6");
			phones = SmartPhoneData.filteredByMemoryRam(memoryRam, phones);
		}
		
		return Response.ok(phones).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPhone(SmartPhone phone) {
		SmartPhoneData.getData().addPhone(phone);
		return Response.status(Status.CREATED).build();
	}
}
