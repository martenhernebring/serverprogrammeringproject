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

        IntervalInstance i1 = new IntervalInstance(0, 1);
        IntervalInstance i2 = new IntervalInstance(20, 25);

        Entity<IntervalInstance> entity = Entity.entity(i2, "application/JSON");
        Response response = client.target("http://localhost:8080/IntervalManagment/webservice/intervals").request()
                .buildPost(entity).invoke();
        System.out.println(response.readEntity(IntervalInstance.class).getEndHour());
        response.close();

        WebTarget target = client.target("http://localhost:8080/IntervalManagement/webservice/intervals/0");
        Invocation invocation = target.request().buildGet();
        response = invocation.invoke();

        List<IntervalInstance> startingWith0 = response.readEntity(new GenericType<List<IntervalInstance>>() {
        });
        for (IntervalInstance ii : startingWith0) {
            System.out.println(ii);
        }
        response.close();

        response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals?id=1").request()
                .buildPut(null).invoke();
        response.close();

        response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals").request().buildGet()
                .invoke();
        // System.out.println(response.readEntity(String.class));
        List<IntervalInstance> intervals = response.readEntity(new GenericType<List<IntervalInstance>>() {
        });
        for (IntervalInstance ii : intervals) {
            System.out.println(ii);
        }
        response.close();
    }
}
