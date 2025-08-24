package products

fun main() {
    val products = ProductRepository.products
        .filter { it.productCategory == ProductCategory.CLOTHING }
        .map { it.copy(productPrice = it.productPrice * 2) }
        .map { "${it.id} - ${it.productName} - ${it.productPrice}" }

    for (product in products) {
        println(product)
    }
}