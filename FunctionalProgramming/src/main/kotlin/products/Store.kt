package products

fun main() {
    val products = ProductRepository.products
        .filter { it.productCategory == ProductCategory.CLOTHING }
        .transform { it.copy(productPrice = it.productPrice * 2) }
        .transform { "${it.id} - ${it.productName} - ${it.productPrice}" }

    for (product in products) {
        println(product)
    }
}

fun List<Products>.filter(isSuitable: (Products) -> Boolean): List<Products> {
    val result = mutableListOf<Products>()

    for (product in this) {
        if (isSuitable(product)) {
            result.add(product)
        }
    }

    return result.toList()
}

fun <T> List<Products>.transform(operation: (Products) -> T): List<T> {
    val result = mutableListOf<T>()

    for (product in this) {
        result.add(operation(product))
    }

    return result.toList()
}