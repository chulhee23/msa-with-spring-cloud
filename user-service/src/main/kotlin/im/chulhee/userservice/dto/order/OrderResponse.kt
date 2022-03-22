package im.chulhee.userservice.dto.order

import im.chulhee.userservice.entity.BaseTimeEntity

data class OrderResponse(
    private val id: Long,
    private val userId: Long,
    private val quantity: Long,
    private val unitPrice: Long,
    private val totalPrice: Long,
) : BaseTimeEntity() {
}
