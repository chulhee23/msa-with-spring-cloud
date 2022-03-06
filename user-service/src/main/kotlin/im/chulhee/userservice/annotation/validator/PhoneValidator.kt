package im.chulhee.userservice.annotation.validator

import im.chulhee.userservice.annotation.Phone
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext


class PhoneValidator : ConstraintValidator<Phone, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return value?.matches(Regex("(01[016789])(\\d{3,4})(\\d{4})")) ?: false
    }
}
