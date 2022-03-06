package im.chulhee.userservice.annotation

import im.chulhee.userservice.annotation.validator.PhoneValidator
import javax.validation.Constraint

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PhoneValidator::class])
annotation class Phone(
    val message: String = "휴대폰 번호",
)
