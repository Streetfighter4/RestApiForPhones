package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import bg.elsys.ip.rest.data.SmartPhone;
import bg.elsys.ip.rest.data.SmartPhoneData;

@Path("/phones")
public class SmartPhoneResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPhones() {
		return Response.ok(SmartPhoneData.getData().getPhones()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPhone(SmartPhone phone) {
		SmartPhoneData.getData().addPhone(phone);
		return Response.status(Status.CREATED).build();
	}
	
	
}
