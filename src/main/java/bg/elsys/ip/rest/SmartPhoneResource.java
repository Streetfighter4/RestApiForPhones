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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/phones")
@Api("SmartPhones")
public class SmartPhoneResource {
	@GET
	@ApiOperation(value = "Get methot for getting all of the data or filter items", response = SmartPhone.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPhones(
			@ApiParam(name = "numberElement", value = "Number of element on one page") @DefaultValue("10") @QueryParam("numberElement") final int numberElement,
			@ApiParam(name = "newPage", value = "Which page of the data is return") @DefaultValue("1") @QueryParam("newPage") final int newPage,
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
		System.out.println("Before fillter size " + phones.size());
		
		if (year >= 1900) {
			System.out.println("Filter5");
			phones = SmartPhoneData.filteredByYear(year, phones);
		}
		System.out.println("After fillter size " + phones.size());
		
		if (memoryRam >= 0.0) {
			System.out.println("Filter6");
			phones = SmartPhoneData.filteredByMemoryRam(memoryRam, phones);
		}
		
		int start = Math.min((newPage-1)*numberElement, phones.size());
		int end = Math.min(newPage*numberElement, phones.size());
		phones = phones.subList(start, end);
		return Response.ok(phones).build();
	}
	@Path("/manufacturer")
	@GET
	@ApiOperation(value = "Get distinct manufacturers",  response = SmartPhone.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUniManufacturer() {
		List<String> manufacturers = null;
		manufacturers = SmartPhoneData.getData().manufacturerNames();
		
		return Response.ok(manufacturers).build();
	}
	
	@Path("/model")
	@GET
	@ApiOperation(value = "Get distinct models",  response = SmartPhone.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUniModel() {
		List<String> models = null;
		models = SmartPhoneData.getData().modelNames();
		
		return Response.ok(models).build();
	}
	
	
	@POST
	@ApiOperation(value = "Create new smart phone", response = SmartPhone.class)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPhone(SmartPhone phone) {
		SmartPhoneData.getData().addPhone(phone);
		return Response.status(Status.CREATED).build();
	}
}
