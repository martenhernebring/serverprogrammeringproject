package se.sme.client;


import java.util.List;
//import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



import se.sme.domain.IntervalInstance;
import se.sme.service.TimeManagementService;

public class Main {
    public static void main(String[] args) throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context jndi = new InitialContext(jndiProperties);
        TimeManagementService service = (TimeManagementService)jndi.lookup("tm/IntervalManagementImplementation!se.sme.service.TimeManagementService");

      
//        IntervalInstance i1 = new IntervalInstance(0, 1);
//        IntervalInstance i2 = new IntervalInstance(20, 25);
//      
//	    service.registerInterval(i1);
//	    service.registerInterval(i2);

//	 
        
        List<IntervalInstance> intervals = service.getAllIntervals();
        for (IntervalInstance Interval: intervals) {
        	System.out.println(Interval);
        }
        List<IntervalInstance> IntervalInstances = service.searchByStart(0);
        for (IntervalInstance IntervalInstance: IntervalInstances) {
        System.out.println(IntervalInstance);
        }


    }
}
