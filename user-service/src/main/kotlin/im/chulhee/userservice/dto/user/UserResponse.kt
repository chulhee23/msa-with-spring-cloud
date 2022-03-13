package im.chulhee.userservice.dto.user

import im.chulhee.userservice.entity.User
import java.time.LocalDateTime

data class UserResponse(
    var userId: String? = null,
    val email: String,
    val name: String,
    val phone: String,
    val createdAt: LocalDateTime
) {
    companion object {
        fun from(user: User): UserResponse {
            return UserResponse(
                userId = user.userId.toString(),
                email = user.email,
                name = user.name,
                phone = user.phone,
                createdAt = user.createdAt,
            )

        }
    }
}
