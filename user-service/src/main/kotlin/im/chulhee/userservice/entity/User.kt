package im.chulhee.userservice.entity

import im.chulhee.userservice.annotation.Phone
import im.chulhee.userservice.dto.user.UserDto
import javax.persistence.*


@Entity
@Table(name = "users")
class User(
    @Column
    var userId: String = "",

    @Column
    var email: String = "",

    @Column
    var name: String = "",

    @Phone
    @Column
    var phone: String = "010-0000-0000",
) : BaseTimeEntity() {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column
    var encryptedPassword: String = ""

    companion object {
        fun from(userDto: UserDto): User {
            return User(
                userId = userDto.userId!!,
                email = userDto.email,
                name = userDto.name, phone = userDto.phone
            )
        }
    }
}
