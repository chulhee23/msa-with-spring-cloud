package im.chulhee.firstservice.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/first-service")
class FirstController {

    @GetMapping("/welcome")
    fun welcome() : String {
        return "welcome to first service!"
    }
}
