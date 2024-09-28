package com.example.multitenancyschema;

import com.example.multitenancyschema.multitenancy.TenantContext;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Autowired
    private FlywayComponent flywayService;

    /**
     * Responsável por executar as migrations do schema default ao subir a aplicação
     */
    @Bean
    public Flyway flyway(DataSource dataSource) {
        return flywayService.executeMigrationsForDefaultSchema(TenantContext.DEFAULT_SCHEMA, dataSource);
    }

//    /**
//     * Responsável por executar as migrations dos demais schemas por empresa ao subir a aplicação
//     */
//    @Bean
//    CommandLineRunner commandLineRunner(EmpresaRepository repository, DataSource dataSource) {
//        return args -> {
//            repository.findAll().forEach(empresa -> {
//                flywayService.executeMigrationsForSchema(String.valueOf(empresa.getCodigo()), dataSource);
//            });
//        };
//    }
}