package im.chulhee.userservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
@EnableDiscoveryClient
class UserServiceApplication {
    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}

fun main(args: Array<String>) {
    runApplication<UserServiceApplication>(*args)


}
