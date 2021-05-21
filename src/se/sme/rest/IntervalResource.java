package se.sme.rest;

import java.util.List;

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
//import javax.ws.rs.core.Response;
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
    public List<IntervalInstance> getIntervalByStart(@PathParam("startNo") int hour) {
        return service.searchByStart(hour);
    }
    
    @POST
    @Produces("application/JSON")
    @Consumes("application/JSON")
    public IntervalInstance createInterval(IntervalInstance interval) {
        service.registerInterval(interval);
        return interval;
    }
    
    @DELETE
    @Path("{hour}")
    public void delete(@PathParam("hour") int hour) {
        List<IntervalInstance> li = service.searchByStart(hour);
        for (IntervalInstance i:li){
        	service.delete(i);
        }
        

        //return Response.ok().build();
        
        
    }
    @PUT
    public Response update(@DefaultValue("1") @QueryParam("hour") Integer hour, @QueryParam("id") Integer id) {
    	if (hour >= 0 && id != null) {
    		//return Response.ok(service.addHours(hour, id)).build();
    		return Response.ok(service.addHours(hour, id)).build();
    		}
  
    		return Response.status(400).build();
    		}
    	
       // Todo updateTodo = todoDAO.findById(hour);

        //updateTodo.setTask(todo.getTask());
       // updateTodo.setDescription(todo.getDescription());
        //todoDAO.update(updateTodo);

       // return Response.ok().build();
    }

}
