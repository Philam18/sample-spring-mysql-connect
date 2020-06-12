# sample-spring-mysql-connect
      
Sample code to get MySQL with Spring JDBC set up on Spring Boot with basic user/pass authentication.  
Uses NamedParameterJdbcTemplate for templating.

Spring Boot 2.3.0  
OpenJDK 11.0.7  

Dependencies: 
- [MySQL ConnectorJ 8.0.20](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.20)  
- [Spring Data JDBC 5.2.7](https://mvnrepository.com/artifact/org.springframework/spring-jdbc/5.2.7.RELEASE)  
- [Apache DBCP 2.7.0](https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2/2.7.0) (DBCP over Spring's DriverManagerDataSource for efficient connection pooling)
- [Apache Pool 2.8.0](https://mvnrepository.com/artifact/org.apache.commons/commons-pool2/2.8.0)

#### Setup

Add lines to `src\main\java\com\example\demo4\mysql.properties`:

```
db.host=<...>
db.port=<...>
db.username=<...>
db.password=<...>
db.connectionPoolInitialSize=<...>
db.connectionPoolMaxTotal=<...>
```

#### Resources
- [mysql connectorj ref](https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-spring-config.html)
