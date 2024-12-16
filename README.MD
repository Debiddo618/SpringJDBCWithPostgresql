# How to connect Spring with Postgresql

<div id="header" align="center">

  <img src="https://tse4.mm.bing.net/th?id=OIP.eW2_21gOmCpkeXb7rxTA5gHaDt&pid=Api&P=0&h=220" width="800" height="400">

</div>

1. Create a Spring project and download postgresql with the account setup
1. Open resources/application.properties
2. Add the following configurations

```Java
spring.datasource.url=jdbc:postgresql://localhost:5432/students
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver
```

- Database URL: This specifies the JDBC URL to connect to the PostgreSQL database, including the hostname (localhost), port (5432), and database name (student).

- Username: The username used to authenticate with the database. Here, it is set to postgres.

- Password: The password used to authenticate with the database. Here, it is set to postgres.

- Driver Class Name: This specifies the fully qualified class name of the JDBC driver used to connect to the database. For PostgreSQL, it is org.postgresql.Driver.