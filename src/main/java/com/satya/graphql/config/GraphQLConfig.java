package com.satya.graphql.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfig {

    /*@Bean
    public GraphQLScalarType jsonScalar() {
        return ExtendedScalars.Json;
    }*/

    @Bean
    public RuntimeWiringConfigurer configurer() {
        return c->
                c.scalar(ExtendedScalars.GraphQLLong)
                        .scalar(ExtendedScalars.GraphQLByte)
                        .scalar(ExtendedScalars.GraphQLShort)
                        .scalar(ExtendedScalars.GraphQLBigDecimal)
                        .scalar(ExtendedScalars.GraphQLBigInteger)
                        .scalar(ExtendedScalars.Date)
                        .scalar(ExtendedScalars.LocalTime)
                        .scalar(ExtendedScalars.DateTime)
                        .scalar(ExtendedScalars.Json)
                        .scalar(ExtendedScalars.Object);
    }
}
