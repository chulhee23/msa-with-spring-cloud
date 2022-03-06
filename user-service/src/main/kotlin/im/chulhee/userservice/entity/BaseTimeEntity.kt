package im.chulhee.userservice.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseTimeEntity(

) {
    @Column(insertable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(insertable = false, updatable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()
}
