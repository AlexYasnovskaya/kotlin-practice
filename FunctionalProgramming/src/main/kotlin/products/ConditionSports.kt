package products

class ConditionSports: Condition {
    override fun isSuitable(product: Products): Boolean {
        return product.productCategory == ProductCategory.SPORTS
    }
}