package im.chulhee.apigatewayservice.config

import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono


@Component
class GlobalFilter : AbstractGatewayFilterFactory<GlobalFilter.Config>(Config::class.java) {
    private val log = LoggerFactory.getLogger(GlobalFilter::class.java)

    override fun apply(config: Config): GatewayFilter? {
        return GatewayFilter { exchange: ServerWebExchange, chain: GatewayFilterChain ->
            val request = exchange.request
            val response = exchange.response
            log.info("Global Filter baseMessage: {}, {}", config.baseMessage, request.remoteAddress)

            if (config.preLogger) {
                log.info("Global Filter Start: request id -> {}", request.getId())
            }

            chain.filter(exchange).then(Mono.fromRunnable {
                if (config.postLogger) {
                    log.info("Global Filter End: response code -> {}", response.getStatusCode())
                }
            })
        }
    }


    data class Config(
        val baseMessage: String? = null,
        val preLogger: Boolean = false,
        val postLogger: Boolean = false,
    )

}
