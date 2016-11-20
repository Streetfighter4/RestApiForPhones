package bg.elsys.ip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
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
								//@QueryParam("manufacturerFilter") final String manufacturer,
								//@QueryParam("modelFilter") final String model,
								//@QueryParam("cameraMPFilter") final float cameraMP,
								//@QueryParam("procesorGHzFilter") final float procesorGHz,
								//@QueryParam("yearFilter") final int year,
								//@QueryParam("memoryRamFilter") final int memoryRam
			) {
		
		List<SmartPhone> phones = SmartPhoneData.getData().getPhones();
		/*
		if (manufacturer != null || !("".equals(manufacturer))) {
			phones = SmartPhoneData.filteredByManufacturer(manufacturer, phones);
		}
		if (model != null || !("".equals(model))) {
			phones = SmartPhoneData.filteredByModel(model, phones);
		}
		if (cameraMP != 0.0) {
			phones = SmartPhoneData.filteredByCameraMP(cameraMP, phones);
		}
		if (procesorGHz != 0.0) {
			phones = SmartPhoneData.filteredByProcesorGHz(procesorGHz, phones);
		}
		if (year != 0) {
			phones = SmartPhoneData.filteredByYear(year, phones);
		}
		if (memoryRam != 0) {
			phones = SmartPhoneData.filteredByMemoryRam(memoryRam, phones);
		} */
		return Response.ok(phones).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPhone(SmartPhone phone) {
		SmartPhoneData.getData().addPhone(phone);
		return Response.status(Status.CREATED).build();
	}
}
