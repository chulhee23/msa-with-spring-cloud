package im.chulhee.userservice.service

import im.chulhee.userservice.dto.user.UserDto
import im.chulhee.userservice.dto.user.UserResponse

interface UserService {
    fun findAll(): List<UserResponse>
    fun createUser(userDto: UserDto): UserResponse
    fun getUser(id: Long): UserResponse

}
