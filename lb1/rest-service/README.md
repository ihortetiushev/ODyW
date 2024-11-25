Uses in-memory H2 database, so data is lost after app restart<br>
If you want to keep data use smth like in your application.properties
<pre>spring.datasource.url=jdbc:h2:file:/data/demo</pre>

to run:
<pre>mvn spring-boot:run</pre>


OpenAPI page to try out app:
http://localhost:8080/swagger-ui/index.html