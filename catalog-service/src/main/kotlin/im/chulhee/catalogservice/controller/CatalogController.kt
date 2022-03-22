package im.chulhee.catalogservice.controller

import im.chulhee.catalogservice.dto.CatalogResponse
import im.chulhee.catalogservice.service.CatalogService
import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/catalog-service/catalogs")
class CatalogController(
    private val catalogService: CatalogService
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<CatalogResponse>> {

        return ResponseEntity(catalogService.findAll(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long): ResponseEntity<CatalogResponse> {

//        return ResponseEntity(catalogService.findOne(id), HttpStatus.OK)
        return ResponseEntity(CatalogResponse("asdf", "asdf", 12L, 12L, LocalDateTime.now()), HttpStatus.OK)
    }


}
