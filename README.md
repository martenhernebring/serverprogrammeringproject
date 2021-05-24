#serverprogrammeringproject

Ett projekt som lägger till, uppdaterar, tar bort och hämtar positiva intervaller med JPA i Wildfly och Derby.

## Hämta och köra
1. Klona vårt projekt från GitHub: https://github.com/suzyrgo/serverprogrammeringproject.git
2. cd Serverprogrammeringproject
3. Lägg till derbyclient.jar från Derby/lib, client.jar från WildFly/bin/client, jboss-javaee-all-7.0-1.0.3.Final.jar
4. Starta Derby med NetworkServerControl -p 50000 start, och ij med connect 'jdbc:derby://localhost:50000/IntervalDB; create=true';
5. Starta Wildfly med standalone-filen.
6. Skapa ett nytt projekt och lägg till filerna i foldern restclient.
7. Unzippa och lägg till filerna från restclient.zip

## Att tänka på
Vi hade mycket problem med moduler i Eclipse.
Bytte till Java 11 till 8.
Viktigt att tänka på att META-INF ska ha bindestreck och ligga inuti src-filer.
