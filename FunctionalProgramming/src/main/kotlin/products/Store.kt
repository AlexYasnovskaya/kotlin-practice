package products

fun main() {
    val products = ProductRepository.products

    var filtered = filter(products) { it.productPrice > 500 }
    filtered = filter(filtered) { it.productCategory == ProductCategory.SPORTS }
    filtered = filter(filtered) { it.productRating > 4 }

    for (product in filtered) {
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

//fun filter(products: List<Products>, condition: Condition): List<Products> {
//    val result = mutableListOf<Products>()
//
//    for (product in products) {
//        if (condition.isSuitable(product)) {
//            result.add(product)
//        }
//    }
//
//    return result.toList()
//}