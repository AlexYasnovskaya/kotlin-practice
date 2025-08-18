package products

fun main() {
    val products = ProductRepository.products

    for (product in products) {
        println(product)
    }
}