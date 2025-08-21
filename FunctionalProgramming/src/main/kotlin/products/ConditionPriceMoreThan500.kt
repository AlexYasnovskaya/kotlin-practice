package products

import profile.Person

class ConditionPriceMoreThan500: Condition {
    override fun isSuitable(products: Products): Boolean {
        return products.productPrice > 500
    }
}