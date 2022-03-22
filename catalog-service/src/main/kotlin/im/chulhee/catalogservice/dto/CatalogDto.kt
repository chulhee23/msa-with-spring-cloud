package im.chulhee.catalogservice.dto

data class CatalogDto(
    private val productId: String,
    private val qty: Long,
    private val unitPrice: Long,
    private val totalPrice: Long,
    private val orderId: Long,
    private val userId: Long,
) {
}
