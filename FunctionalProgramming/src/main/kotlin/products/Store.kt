package products

fun main() {
    ProductRepository.products
        .also { println("filter by category") }
        .filter { it.productCategory == ProductCategory.CLOTHING }
        .also { println("increase price") }
        .map { it.copy(productPrice = it.productPrice * 2) }
        .also { println("covert to string") }
        .map { "${it.id} - ${it.productName} - ${it.productPrice}" }
        .also { println("print info") }
        .forEach { println(it) }
}