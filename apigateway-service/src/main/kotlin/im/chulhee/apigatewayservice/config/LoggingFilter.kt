package im.chulhee.apigatewayservice.config

import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.core.Ordered
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono


@Component
class LoggingFilter : AbstractGatewayFilterFactory<LoggingFilter.Config>(Config::class.java) {
    private val log = LoggerFactory.getLogger(LoggingFilter::class.java)

    override fun apply(config: Config): GatewayFilter? {
        return OrderedGatewayFilter({ exchange, chain ->
            val request = exchange.request
            val response = exchange.response
            log.info("Logging Filter baseMessage: {}, {}", config.baseMessage, request.remoteAddress)

            if (config.preLogger) {
                log.info("Logging PRE Filter: request id -> {}", request.id)
            }

            chain.filter(exchange).then(Mono.fromRunnable {
                if (config.postLogger) {
                    log.info("Logging POST Filter: response code -> {}", response.statusCode)
                }
            })

        }, Ordered.HIGHEST_PRECEDENCE)

    }


    data class Config(
        val baseMessage: String? = null,
        val preLogger: Boolean = false,
        val postLogger: Boolean = false,
    )

}
