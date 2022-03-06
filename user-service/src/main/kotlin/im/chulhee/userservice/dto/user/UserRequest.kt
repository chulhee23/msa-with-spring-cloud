package im.chulhee.userservice.dto.user

import im.chulhee.userservice.annotation.Phone


data class UserRequest(
    val email: String,
    val name: String,
    val password: String,
    @Phone val phone: String
)
