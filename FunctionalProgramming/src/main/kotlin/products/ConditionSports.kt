package products

class ConditionSports: Condition {
    override fun isSuitable(products: Products): Boolean {
        return products.productCategory == ProductCategory.SPORTS
    }
}