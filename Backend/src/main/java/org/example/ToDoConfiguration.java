package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.core.Configuration;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import io.dropwizard.db.DataSourceFactory;

//import io.dropwizard.jdbi3.*;
//import io.dropwizard.db.DataSourceFactory;
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;

public class ToDoConfiguration extends Configuration {
    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
//
//    @NotEmpty
//    private String template;
//
//    @NotEmpty
//    private String defaultName;
//
//    @JsonProperty
//    public String getTemplate() {
//        return template;
//    }
//
//    @JsonProperty
//    public void setTemplate(String template) {
//        this.template = template;
//    }
//
//    @JsonProperty
//    public String getDefaultName() {
//        return defaultName;
//    }
//
//    @JsonProperty
//    public void setDefaultName(String name) {
//        this.defaultName = name;
//    }
}