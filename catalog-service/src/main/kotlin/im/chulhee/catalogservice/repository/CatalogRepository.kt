package im.chulhee.catalogservice.repository

import im.chulhee.catalogservice.entity.Catalog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CatalogRepository: JpaRepository<Catalog, Long> {

    fun findByProductId(productId: String): Catalog
}
