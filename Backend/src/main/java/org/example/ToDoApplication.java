package org.example;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import org.example.api.CORSFilter;
import org.example.dao.TaskDAO;

import org.jdbi.v3.core.Jdbi;
import org.example.resources.TaskResource;


public class ToDoApplication extends Application<ToDoConfiguration> {
    public static void main(String[] args) throws Exception {
        new ToDoApplication().run(args);
    }

    @Override
    public String getName() {
        return "To-Do";
    }

    @Override
    public void initialize(Bootstrap<ToDoConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ToDoConfiguration configuration, Environment environment) {
//        Jdbi jdbi = Jdbi.create(configuration.getDataSourceFactory().build(environment.metrics(), "mysql"));
//        final TaskDAO taskDAO = new TaskDAO(jdbi);
//        final TaskResource taskResource = new TaskResource(taskDAO);

//        environment.jersey().register(taskResource);
        Jdbi jdbi = Jdbi.create(configuration.getDataSourceFactory().build(environment.metrics(), "mysql"));
        final TaskDAO taskDAO = new TaskDAO(jdbi);
        final TaskResource taskResource = new TaskResource(taskDAO);

        environment.jersey().register(taskResource);

        final TaskDAO dao = new TaskDAO(jdbi);
        environment.jersey().register(new TaskResource(dao));

        // Register the CORS filter
        environment.jersey().register(CORSFilter.class);
        // nothing to do yet
//        HelloWorldResource resource = new HelloWorldResource(
//                configuration.getTemplate(),
//                configuration.getDefaultName()
//        );
//        environment.jersey().register(resource);


//        TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
//        environment.healthChecks().register("template", healthCheck);
    }
}