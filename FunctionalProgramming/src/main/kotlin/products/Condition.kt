package products

import profile.Person

interface Condition {
    fun isSuitable(product: Products): Boolean
}