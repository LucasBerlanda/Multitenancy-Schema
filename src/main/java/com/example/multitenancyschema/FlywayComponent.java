package com.example.multitenancyschema;

import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class FlywayComponent {

    public void executeMigrationsForSchema(String schema, DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .locations("db/migration/empresas")
                .dataSource(dataSource)
                .schemas("empresa_%s".formatted(schema))
                .load();
        flyway.migrate();
    }

    public Flyway executeMigrationsForDefaultSchema(String schema, DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .locations("db/migration/db_default")
                .dataSource(dataSource)
                .schemas(schema)
                .load();
        flyway.migrate();
        return flyway;
    }


}
