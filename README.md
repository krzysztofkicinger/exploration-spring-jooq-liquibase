# Exploration: Spring + jOOQ + Liquibase 

# Liquibase

* https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
* http://www.baeldung.com/liquibase-refactor-schema-of-java-app
* https://stackoverflow.com/questions/22355725/loading-data-from-properties-file-to-be-used-by-liquibase-in-maven-build

By default, Liquibase autowires the (@Primary) DataSource in your context and uses that for migrations. If you need to use a different DataSource, you can create one and mark its @Bean as @LiquibaseDataSource. If you do so and you want two data sources, remember to create another one and mark it as @Primary. Alternatively, you can use Liquibase’s native DataSource by setting spring.liquibase.[url,user,password] in external properties. Setting either spring.liquibase.url or spring.liquibase.user is sufficient to cause Liquibase to use its own DataSource. If any of the three properties has not be set, the value of its equivalent spring.datasource property will be used.

# How to generate the changelog?

```bash
mvn liquibase:generateChangeLog
```

# How to generate a diff between two databases?

```bash
mvn liquibase:diff
```