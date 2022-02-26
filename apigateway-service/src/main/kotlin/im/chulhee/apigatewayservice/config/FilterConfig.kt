package im.chulhee.apigatewayservice.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FilterConfig {

    @Bean
    fun gatewayRoutes(builder: RouteLocatorBuilder): RouteLocator? {
        return builder.routes()
            .route { r: PredicateSpec ->
                r.path("/first-service/**")
                .filters { f: GatewayFilterSpec ->
                    f.addRequestHeader("X-service-request", "first-request")
                        .addResponseHeader("X-service-request", "first-response")
                }
                .uri("http://localhost:8081")
            }.route { r: PredicateSpec ->
                r.path("/second-service/**")
                    .filters { f: GatewayFilterSpec ->
                    f.addRequestHeader("X-service-request", "second-request")
                        .addResponseHeader("X-service-request", "second-response")
                     }
                .uri("http://localhost:8082")
            }.build()
    }
}
