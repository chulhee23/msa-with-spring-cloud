package im.chulhee.userservice.seeds

import im.chulhee.userservice.dto.user.UserDto
import im.chulhee.userservice.service.UserService
import org.springframework.stereotype.Component

@Component
class InitSource(userService: UserService) {
    init {
        userService.createUser(
            UserDto(
                email = "test1@test.com",
                password = "password",
                name = "test1",
                phone = "010-1234-1234"
            )
        )
        userService.createUser(
            UserDto(
                email = "test2@test.com",
                password = "password",
                name = "test2",
                phone = "010-1234-1235"
            )
        )
        userService.createUser(
            UserDto(
                email = "test3@test.com",
                password = "password",
                name = "test3",
                phone = "010-1234-1236"
            )
        )
    }
}
