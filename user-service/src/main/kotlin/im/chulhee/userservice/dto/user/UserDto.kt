package im.chulhee.userservice.dto.user

import java.time.LocalDateTime


data class UserDto(
    var userId: String? = null,
    val email: String,
    val password: String,
    val name: String,
    val phone: String,
    val createdAt: LocalDateTime? = null
) {


    companion object {
        fun from(userRequest: UserRequest): UserDto {
            return UserDto(
                email = userRequest.email,
                name = userRequest.name,
                phone = userRequest.phone,
                password = userRequest.password
            )
        }
    }
}
