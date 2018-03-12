# Exploration: Spring + jOOQ + Liquibase 

## Properites Maven Plugin

### How to use it from command line?

```bash
mvn properties:read-project-property
```

* http://www.mojohaus.org/properties-maven-plugin/plugin-info.html

### How to configure it?

Usually we define the `<execution>` tag that describes the phase which in the plugin should be applied. 

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>properties-maven-plugin</artifactId>
    <version>1.0.0</version>
    <executions>
        <execution>
            <phase>initialize</phase>
            <goals>
                <goal>read-project-properties</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

This means that during `initialize` phase the plugin will be applied. Otherwise we can crete a global configuration:

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>properties-maven-plugin</artifactId>
    <version>1.0.0</version>
    <configuration>
        <files>
            <file>src/main/resources/db.properties</file>
        </files>
    </configuration>
</plugin>
```

Then we need to run the plugin explicitly:

```bash
mvn properties:read-project-property ...
```

* http://www.mojohaus.org/properties-maven-plugin/usage.html

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

mvn properties:read-project-properties liquibase:updateSQL
```

# How to generate sql update script?

```bash
mvn resources:resources liquibase:updateSQL

mvn properties:read-project-properties liquibase:updateSQL
```

# jOOQ

* https://github.com/jOOQ/jOOQ/issues/6650
* https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html#boot-features-jooq
* https://www.jooq.org/doc/3.9/manual/getting-started/tutorials/jooq-in-7-steps/

The fluent API offered by jOOQ is initiated via the org.jooq.DSLContext interface. Spring Boot will auto-configure a DSLContext as a Spring Bean and connect it to your application DataSource. To use the DSLContext you can just @Autowire it:

## How to generate sources?

```bash
mvn properties:read-project-properties generate-sources
```

# Requests

## Users GET request - /users

### Accept: application/json

```json
[{"id":1,"firstname":"John","lastname":"Smith","password":null,"email":null}]
```

### Accept: text/event-stream

```bash
data:{"id":1,"firstname":"John","lastname":"Smith","password":null,"email":null}
```
