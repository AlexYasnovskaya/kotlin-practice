package products

class ConditionRatingMoreThan4: Condition {
    override fun isSuitable(products: Products): Boolean {
        return products.productRating >= 4
    }
}