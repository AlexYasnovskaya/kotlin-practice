package products

fun main() {
    val products = ProductRepository.products
    var filtered = filter(products, object: Condition {
        override fun isSuitable(product: Products): Boolean {
            return product.productPrice > 500
        }
    })
    filtered = filter(filtered, object: Condition {
        override fun isSuitable(product: Products): Boolean {
            return product.productCategory == ProductCategory.SPORTS
        }
    })
    filtered = filter(filtered, object: Condition {
        override fun isSuitable(product: Products): Boolean {
            return product.productRating > 4
        }
    })

    for (product in filtered) {
        println(product)
    }
}

fun filter(products: List<Products>, condition: Condition): List<Products> {
    val result = mutableListOf<Products>()

    for (product in products) {
        if (condition.isSuitable(product)) {
            result.add(product)
        }
    }

    return result.toList()
}