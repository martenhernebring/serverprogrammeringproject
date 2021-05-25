#serverprogrammeringproject

Ett projekt som lägger till, uppdaterar, tar bort och hämtar positiva intervaller med JPA i Wildfly och Derby.

## Hämta och köra
1. Klona vårt projekt från GitHub: https://github.com/suzyrgo/serverprogrammeringproject.git
2. cd Serverprogrammeringproject
3. Lägg till derbyclient.jar från Derby/lib, client.jar från WildFly/bin/client, jboss-javaee-all-7.0-1.0.3.Final.jar
4. Starta Derby med NetworkServerControl -p 50000 start, och ij med connect 'jdbc:derby://localhost:50000/IntervalDB; create=true';
5. Lägg till följande i filen WildFly/standalone/configuration/standalone.xml:

				<datasource jndi-name="java:/IntervalDB" pool-name="IntervalDB" enabled="true" 						use-java-context="true">
                    <connection-url>jdbc:derby://localhost:50000/IntervalDB</connection-url>
                    <driver>derbyclient.jar</driver>
                    <security>
                        <user-name>APP</user-name>
                        <password>APP</password>
                    </security>
                </datasource>
                <drivers>
                    <driver name="h2" module="com.h2database.h2">
                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                    </driver>
                </drivers>
6. Starta Wildfly med standalone-filen.
7. Skapa ett nytt projekt och lägg till filerna i foldern restclient.
8. Unzippa och lägg till filerna från restclient.zip

## Att tänka på
Vi fick med moduler i Eclipse med grundinställning så bytte från Java 11 till 8.
Viktigt att tänka på att META-INF ska ha bindestreck och ligga inuti src-filer.
