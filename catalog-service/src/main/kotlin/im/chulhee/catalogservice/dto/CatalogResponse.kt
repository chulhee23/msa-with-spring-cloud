package im.chulhee.catalogservice.dto

import im.chulhee.catalogservice.entity.Catalog
import java.time.LocalDateTime

data class CatalogResponse(
    val productId: String,
    val productName: String,
    val unitPrice: Long,
    val stock: Long,
    val createdAt: LocalDateTime
) {
    companion object {
        fun from(catalog: Catalog): CatalogResponse {
            return CatalogResponse(
                productId = catalog.productId,
                productName = catalog.productName,
                unitPrice = catalog.unitPrice,
                stock = catalog.stock,
                createdAt = catalog.createdAt,
            )
        }
    }
}
