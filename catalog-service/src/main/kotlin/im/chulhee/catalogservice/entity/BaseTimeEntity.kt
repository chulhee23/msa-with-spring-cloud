package im.chulhee.catalogservice.entity


import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseTimeEntity(
) {
    @Column
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column
    val updatedAt: LocalDateTime = LocalDateTime.now()
}
