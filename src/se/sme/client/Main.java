package se.sme.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import se.sme.domain.Interval;
import se.sme.service.IntervalManagementImplementation;

public class Main {
    public static void main(String[] args) throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context jndi = new InitialContext(jndiProperties);
        //IntervalManagementImplementation service = (IntervalManagementService)jndi.lookup("friendlyName");
    }
}
