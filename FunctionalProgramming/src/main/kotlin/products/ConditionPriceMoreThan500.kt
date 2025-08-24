package products

import profile.Person

class ConditionPriceMoreThan500: Condition {
    override fun isSuitable(product: Products): Boolean {
        return product.productPrice > 500
    }
}