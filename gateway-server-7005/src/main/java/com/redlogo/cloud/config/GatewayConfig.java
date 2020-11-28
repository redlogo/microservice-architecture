package com.redlogo.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Another way to redirect sites, add rules, other than application.yaml
 *
 * @author redlogo
 * @version 0.1
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // redirect localhost:7005/contact to netflix contact
        routes.route("path_route_test1", r -> r.path("/contact").uri("https://www.netflix.com/contact")).build();
        return routes.build();
    }
}
