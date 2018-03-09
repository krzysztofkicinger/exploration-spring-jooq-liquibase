# Exploration: Spring + jOOQ + Liquibase 

# Liquibase

* https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
* http://www.baeldung.com/liquibase-refactor-schema-of-java-app
* http://www.liquibase.org/documentation/maven
* https://stackoverflow.com/questions/22355725/loading-data-from-properties-file-to-be-used-by-liquibase-in-maven-build
* https://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html

By default, Liquibase autowires the (@Primary) DataSource in your context and uses that for migrations. If you need to use a different DataSource, you can create one and mark its @Bean as @LiquibaseDataSource. If you do so and you want two data sources, remember to create another one and mark it as @Primary. Alternatively, you can use Liquibase’s native DataSource by setting spring.liquibase.[url,user,password] in external properties. Setting either spring.liquibase.url or spring.liquibase.user is sufficient to cause Liquibase to use its own DataSource. If any of the three properties has not be set, the value of its equivalent spring.datasource property will be used.

# How to generate the changelog?

```bash
mvn resources:resources liquibase:generateChangeLog
```

# How to generate sql update script?

```bash
mvn resources:resources liquibase:updateSQL
```

# jOOQ

* https://github.com/jOOQ/jOOQ/issues/6650
* https://docs.spring.io/spring-boot/docs/1.3.8.RELEASE/reference/html/boot-features-jooq.html 