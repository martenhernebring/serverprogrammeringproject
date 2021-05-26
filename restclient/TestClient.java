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

        // 1: Testar lägga in felaktigt interval som inte får börja på minus eller
        // större start än end.
//            IntervalInstance ibad = new IntervalInstance(-5, 25);
//    
//            Entity<IntervalInstance> ebad = Entity.entity(ibad, "application/JSON");
//            Response response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals")
//                    .request()
//                    .buildPost(ebad)
//                    .invoke();
//            System.out.println(response.getHeaders().toString());
//            System.out.println(response.getStatus());
//            System.out.println(response.readEntity(String.class));
//            response.close();
//            
//            IntervalInstance i0 = new IntervalInstance(25, 20);
//            
//            Entity<IntervalInstance> eweird = Entity.entity(i0, "application/JSON");
//            response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals")
//                    .request()
//                    .buildPost(eweird)
//                    .invoke();
//            System.out.println(response.getHeaders().toString());
//            System.out.println(response.getStatus());
//            System.out.println(response.readEntity(String.class));
//            response.close();
        // 2: Lägger in dessa två intervall
        // IntervalInstance i1 = new IntervalInstance(0, 1); 
//            IntervalInstance i2 = new IntervalInstance(20, 25);
//    
//            Entity<IntervalInstance> entity = Entity.entity(i2, "application/JSON");
//            Response response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals")
//                    .request()
//                    .buildPost(entity)
//                    .invoke();
//            System.out.println(response.getHeaders().toString());
//            System.out.println(response.getStatus());
//            System.out.println(response.readEntity(IntervalInstance.class));
//            response.close();

        // 3: Testar lägga in felaktigt hour som inte får börja på minus.
//            WebTarget target = client.target("http://localhost:8080/IntervalManagement/webservice/intervals/-3");
//            Invocation invocation = target.request().buildGet();
//            Response response = invocation.invoke();
//            System.out.println(response.getHeaders().toString());
//            System.out.println(response.getStatus());
//            response.close();

        // 4: Testar söka på en timma som inte finns.
//            WebTarget target = client.target("http://localhost:8080/IntervalManagement/webservice/intervals/5");
//            Invocation invocation = target.request().buildGet();
//            Response response = invocation.invoke();
//            System.out.println(response.getHeaders().toString());
//            System.out.println(response.getStatus());
//            response.close();
        // 5: Söker på det inlagda 20 startvärdet
//            WebTarget target = client.target("http://localhost:8080/IntervalManagement/webservice/intervals/20");
//            Invocation invocation = target.request().buildGet();
//            Response response = invocation.invoke();
//            System.out.println(response.getHeaders().toString());
//            System.out.println(response.getStatus());
//            System.out.println(response.readEntity(String.class));
//            response.close();
        // 6: Lägger in felaktigt id = 0 and negative hour
//        Response response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals?id=0&hour=1")
//                .request().buildPut(null).invoke();
//        System.out.println(response.getHeaders().toString());
//        System.out.println(response.getStatus());
//        response.close();
//        response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals?id=1&hour=-1")
//                .request().buildPut(null).invoke();
//        System.out.println(response.getHeaders().toString());
//        System.out.println(response.getStatus());
//        response.close();
        // 7: Försöker ändra ett id som inte finns
//        Response response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals?id=5")
//                .request().buildPut(null).invoke();
//        System.out.println(response.getHeaders().toString());
//        System.out.println(response.getStatus());
//        response.close();

        // 8: Ändrar 20-25 till 21-25
//        Response response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals?id=2").request()
//                .buildPut(null).invoke();
//        response.close();
//        response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals").request().buildGet()
//                .invoke();
//        List<IntervalInstance> list = response.readEntity(new GenericType<List<IntervalInstance>>() {
//        });
//        for (IntervalInstance ii : list) {
//            System.out.println(ii);
//        }
//        response.close();
        // 9: Försöker ta bort ett illegalt negativt starthour
//        Response response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals/-21")
//                .request()
//                .buildDelete()
//                .invoke();
//        System.out.println(response.getHeaders().toString());
//        System.out.println(response.getStatus());
//        response.close();
        // 10: Försöker ta bort startintervall som inte finns
//        Response response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals/100")
//                .request()
//                .buildDelete()
//                .invoke();
//        System.out.println(response.getHeaders().toString());
//        System.out.println(response.getStatus());
//        response.close();

        // 5: Ta bort alla intervaller som börjar på 21
//        Response response = client.target("http://localhost:8080/IntervalManagement/webservice/intervals/21")
//                .request()
//                .buildDelete()
//                .invoke();
//        System.out.println(response.getHeaders().toString());
//        System.out.println(response.getStatus());
//        response.close();
    }
}
