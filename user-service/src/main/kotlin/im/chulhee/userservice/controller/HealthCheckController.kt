package im.chulhee.userservice.controller

import im.chulhee.userservice.config.ApiPath
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${ApiPath.ROOT}/health-check")
class HealthCheckController {

    @GetMapping
    fun checkStatus(): String {
        return "UserService is Running "
    }
}
