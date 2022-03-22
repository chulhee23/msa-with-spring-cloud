package im.chulhee.userservice.controller

import im.chulhee.userservice.config.ApiPath
import im.chulhee.userservice.dto.user.UserDto
import im.chulhee.userservice.dto.user.UserRequest
import im.chulhee.userservice.dto.user.UserResponse
import im.chulhee.userservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${ApiPath.ROOT}/users")
class UserController(
    private val userService: UserService,
) {

    @GetMapping
    fun list(): ResponseEntity<List<UserResponse>> {
        return ResponseEntity(userService.findAll(), HttpStatus.OK)
    }

    @GetMapping("/{userId}")
    fun getUser(
        @PathVariable userId: Long,
    ): ResponseEntity<UserResponse> {
        return ResponseEntity(userService.getUser(userId), HttpStatus.OK)
    }

    @PostMapping
    fun createUser(@RequestBody userRequest: UserRequest): ResponseEntity<UserResponse> {
        val user = userService.createUser(UserDto.from(userRequest))
        return ResponseEntity(user, HttpStatus.CREATED)
    }

}
