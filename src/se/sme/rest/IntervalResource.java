package se.sme.rest;

import java.util.List;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import se.sme.domain.IntervalInstance;
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

    @GET
    @Produces("application/JSON")
    @Path("{startNo}")
    public Response getIntervalByStart(@PathParam("startNo") int hour) {
        if (hour < 0) {
            return Response.status(400).build();
        } //bad request
        List<IntervalInstance> list = service.searchByStart(hour);
        if(list.size() == 0) { //not found
            return Response.status(404).build();
        }
        return Response.ok(list).build();
    }

    @POST
    @Produces("application/JSON")
    @Consumes("application/JSON")
    public Response createInterval(IntervalInstance interval) {
        IntervalInstance ii;
        try {
            ii = new IntervalInstance(interval.getStartHour(), interval.getEndHour());
        } catch (IllegalArgumentException ex) {
          //bad request
            return Response.status(400).build();
        }
        service.registerInterval(ii);
        return Response.ok(interval).build();
    }

    @DELETE
    @Path("{hour}")
    public Response delete(@PathParam("hour") int hour) {
        if(hour < 0) {
            return Response.status(400).build(); //bad
        }
        List<IntervalInstance> li = service.searchByStart(hour);
        if(li.size() < 1) {
            return Response.status(404).build(); //not found
        }
        System.out.println(li.size());
        for (IntervalInstance i : li) {
            service.delete(i);
        }
        return Response.ok().build();
    }

    @PUT
    public Response update(@DefaultValue("1") @QueryParam("hour") Integer hour, @QueryParam("id") Integer id) {
        if(id < 1 || hour < 0) {
            return Response.status(400).build(); //bad
        }
        try {
            service.addHours(hour, id);
            return Response.ok().build();
        } catch (EJBTransactionRolledbackException ex) {
            return Response.status(404).build(); //not found
        }
    }

}
