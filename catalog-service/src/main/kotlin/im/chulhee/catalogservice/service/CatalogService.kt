package im.chulhee.catalogservice.service

import im.chulhee.catalogservice.dto.CatalogResponse
import im.chulhee.catalogservice.entity.Catalog
import im.chulhee.catalogservice.repository.CatalogRepository
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class CatalogService(
    private val catalogRepository: CatalogRepository
) {
    @PostConstruct
    fun init() {
        catalogRepository.save(Catalog("CATALOG-001", "Test1", 100, 10000))
        catalogRepository.save(Catalog("CATALOG-002", "Test2", 200, 20000))
        catalogRepository.save(Catalog("CATALOG-003", "Test3", 300, 30000))
    }

    fun findAll(): List<CatalogResponse> {
        val catalogs = catalogRepository.findAll()
        return catalogs.map { CatalogResponse.from(it) }
    }

    fun findOne(id: Long): CatalogResponse {
        return CatalogResponse.from(catalogRepository.getById(id))
    }

}
