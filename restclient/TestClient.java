import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

@SuppressWarnings("unused")
public class TestClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        /*
        //IntervalInstance i1 = new IntervalInstance(0, 1);
        IntervalInstance i2 = new IntervalInstance(20, 25);
        
        Entity<IntervalInstance> entity = Entity.entity(i2, "application/JSON");
        Response response = client.target("http://localhost:8080/IntervalManagment/webservice/intervals")
                .request()
                .buildPost(entity)
                .invoke();
        System.out.println(response.readEntity(IntervalInstance.class).getEndHour());
        response.close();*/
        
        
        /*WebTarget target = client.target("http://localhost:8080/Employee/webservice/employees/2");
        Invocation invocation = target.request().buildGet();
        Response response = invocation.invoke(); 
         
        Employee employee = response.readEntity(Employee.class);
        System.out.println(employee);
        response.close();
        response = client.target("http://localhost:8080/Employee/webservice/employees")
                         .request()
                         .buildGet()
                         .invoke();
        //System.out.println(response.readEntity(String.class));
        List<Employee> employees = response.readEntity(new GenericType<List<Employee>>() {});
        for (Employee em : employees) {
            System.out.println(em);
        }
        response.close();*/
    }
}
