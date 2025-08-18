package products

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Products(
    @SerialName("id") val id: Int,
    @SerialName("product_name") val productName: String,
    @SerialName("product_description") val productDescription: String,
    @SerialName("product_category") val productCategory: ProductCategory,
    @SerialName("product_price") val productPrice: Double,
    @SerialName("product_brand") val productBrand: String,
    @SerialName("product_rating") val productRating: Double,
    @SerialName("product_availability") val productAvailability: Boolean,
)
