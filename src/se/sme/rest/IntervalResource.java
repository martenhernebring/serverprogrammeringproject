package se.sme.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import se.sme.domain.*;
import se.sme.service.TimeManagementService;
@Stateless
@Path("/intervals")
public class IntervalResource {
	@Inject
	private TimeManagementService service;
	
	@GET
	@Produces("application/JSON")
	public List<IntervalInstance> getAllInstances() {
		return service.getAllIntervals();
	}

}
