package im.chulhee.userservice.service

import im.chulhee.userservice.dto.user.UserDto
import im.chulhee.userservice.dto.user.UserResponse

interface UserService {

    fun createUser(userDto: UserDto): UserResponse
}
