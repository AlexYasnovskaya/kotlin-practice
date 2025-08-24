package products

class ConditionRatingMoreThan4: Condition {
    override fun isSuitable(product: Products): Boolean {
        return product.productRating >= 4
    }
}