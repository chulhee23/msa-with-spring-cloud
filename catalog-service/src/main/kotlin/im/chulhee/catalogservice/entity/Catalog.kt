package im.chulhee.catalogservice.entity

import javax.persistence.*


@Entity
@Table(name = "catalog")
data class Catalog(
    val productId: String,
    val productName: String,
    val stock: Long,
    val unitPrice: Long
): BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null


}
