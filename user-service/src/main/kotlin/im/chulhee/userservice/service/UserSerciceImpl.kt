package im.chulhee.userservice.service

import im.chulhee.userservice.dto.user.UserDto
import im.chulhee.userservice.dto.user.UserResponse
import im.chulhee.userservice.entity.User
import im.chulhee.userservice.generator.UserIdGenerator
import im.chulhee.userservice.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserSerciceImpl(
    private val userRepository: UserRepository
) : UserService {

    @Transactional
    override fun createUser(userDto: UserDto): UserResponse {
        userDto.setUserId()
        val user = User.from(userDto)
        user.encryptedPassword = "encrypted"
        val saved = userRepository.save(user)


        return UserResponse.from(saved)
    }


}

private fun UserDto.setUserId() {
    if (userId == null) {
        userId = UserIdGenerator.generate()
    }
}
