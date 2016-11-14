package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bg.elsys.ip.rest.data.SmartPhoneData;

@Path("/phones")
public class SmartPhoneResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPhones() {
		return Response.ok(SmartPhoneData.getData().getPhones()).build();
	}
}
