package products

fun main() {
    val products = ProductRepository.products

    val filtered = filter(products) { it.productCategory == ProductCategory.CLOTHING }
    val transformed = transform(filtered) { it.copy(productPrice = it.productPrice * 2) }
    val result = transform(transformed) { "${it.id} - ${it.productName} - ${it.productPrice}" }

    for (product in result) {
        println(product)
    }
}

fun filter(products: List<Products>, isSuitable: (Products) -> Boolean): List<Products> {
    val result = mutableListOf<Products>()

    for (product in products) {
        if (isSuitable(product)) {
            result.add(product)
        }
    }

    return result.toList()
}

fun <T> transform(products: List<Products>, operation: (Products) -> T): List<T> {
    val result = mutableListOf<T>()

    for (product in products) {
        result.add(operation(product))
    }

    return result.toList()
}