package im.chulhee.userservice.service

import im.chulhee.userservice.dto.user.UserDto
import im.chulhee.userservice.dto.user.UserResponse
import im.chulhee.userservice.entity.User
import im.chulhee.userservice.exception.NotFoundException
import im.chulhee.userservice.generator.UserIdGenerator
import im.chulhee.userservice.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder,
) : UserService {
    override fun findAll(): List<UserResponse> {

        val users = userRepository.findAll()
        return users.map { UserResponse.from(it) }

    }

    @Transactional
    override fun createUser(userDto: UserDto): UserResponse {
        userDto.setUserId()
        val user = User.from(userDto)
        user.encryptedPassword = passwordEncoder.encode(userDto.password)
        val saved = userRepository.save(user)

        return UserResponse.from(saved)
    }

    override fun getUser(id: Long): UserResponse {
        val user = userRepository.findById(id).orElse(null) ?: throw NotFoundException("id 에 맞는 유저가 없습니다.")
        return UserResponse.from(user)
    }
}
    
private fun UserDto.setUserId() {
    if (userId == null) {
        userId = UserIdGenerator.generate()
    }
}
