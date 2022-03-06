package im.chulhee.userservice.controller

import im.chulhee.userservice.dto.user.UserDto
import im.chulhee.userservice.dto.user.UserRequest
import im.chulhee.userservice.dto.user.UserResponse
import im.chulhee.userservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class UserController(
    private val userService: UserService
) {

    @RequestMapping
    fun test(): String {
        return "ok"
    }

    @GetMapping("/health_check")
    fun checkStatus(): String {
        return "ok"
    }

    @PostMapping("/users")
    fun createUser(@RequestBody userRequest: UserRequest): ResponseEntity<UserResponse> {
        val user = userService.createUser(UserDto.from(userRequest))

        return ResponseEntity(user, HttpStatus.CREATED)
    }


}
