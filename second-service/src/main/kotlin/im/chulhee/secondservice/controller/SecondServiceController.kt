package im.chulhee.secondservice.controller

import org.slf4j.LoggerFactory
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/second-service")
class SecondServiceController(
    private val env: Environment
) {
    private val logger = LoggerFactory.getLogger(SecondServiceController::class.java)


    @GetMapping("/welcome")
    fun welcome(
        @RequestHeader("X-service-request") requestFrom: String
    ): String {
        logger.info("RequestFrom : $requestFrom")
        return "welcome to second service!"
    }

    @GetMapping("/check")
    fun check(request: HttpServletRequest): String {
        logger.info("Server port = {}", request.serverPort)
        return "check second service, PORT ${env.getProperty("local.server.port")}"
    }


}
